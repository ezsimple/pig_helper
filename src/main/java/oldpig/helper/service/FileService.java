package oldpig.helper.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mkeasy.resolver.CommandMap;
import io.mkeasy.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import oldpig.common.service.AbstractPigService;
import oldpig.utils.PropertiesUtil;

@Slf4j
@Service
public class FileService extends AbstractPigService {
	
    @Autowired
    PropertiesUtil propertiesUtil;

	public void download(HttpServletRequest request, HttpServletResponse response, CommandMap commandMap) throws Exception {

		commandMap.debugParams();

    	String dnKey = propertiesUtil.getProperty("download.key");
    	String dir = propertiesUtil.getProperty("download.dir");

		String key = String.valueOf(commandMap.getParam("key"));
		if(!StringUtils.equals(key, dnKey)) {
			log.error("{} key is mismatch");
			return;
		}
		
		String fid = commandMap.getParam("fid");
		if(StringUtils.isEmpty(fid)) {
			log.error("{} fid is empty");
			return;
		}
		
		String dnFile = propertiesUtil.getProperty("download.file"+fid);
		String dnFileName = propertiesUtil.getProperty("download.file"+fid+"Name");
		if(StringUtils.isEmpty(dnFile)
				|| StringUtils.isEmpty(dnFileName)) {
			log.error("{} download file is not defined");
			return;
		}
		
		log.debug("dir={}, dnFile={}, dnFileName={}, dnKey={}", dir, dnFile, dnFileName, dnKey);
	
		String filePath = dir + "/" + dnFile;
		File file = new File(filePath);

		FileUtil.download(request, response, file, dnFileName);
		
	}
	
}
