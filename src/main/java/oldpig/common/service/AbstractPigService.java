/*
 * Copyright 2020 the original EzFarm and author or authors.
*/

package oldpig.common.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import io.mkeasy.utils.QueryMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public abstract class AbstractPigService implements PigServiceInf {
	
	protected QueryMap convertClobToStringMap(QueryMap queryMap) throws SQLException, IOException {
		QueryMap clobToStringMap = new QueryMap();
		Iterator<String> keys = queryMap.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
            Object value = queryMap.get(key);
            if (value instanceof Clob) {
            	InputStream in = ((Clob) value).getAsciiStream();
                StringWriter w = new StringWriter();
                IOUtils.copy(in, w);
                value = w.toString();
            }
            clobToStringMap.put(key, value);
        }
		return clobToStringMap;
	}
	
	protected int countLines(String bigString) {
        int count = 1;
        int len_m1 = bigString.length() - 1;
        for (int i = 1; i < len_m1; i++) {
            if (bigString.charAt(i) == '\n') {
                count++;
            }
        }
        return count;
    }

}
