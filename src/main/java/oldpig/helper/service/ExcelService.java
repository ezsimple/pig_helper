package oldpig.helper.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import io.mkeasy.resolver.CommandMap;
import io.mkeasy.webapp.processor.ExcelFactory;
import lombok.extern.slf4j.Slf4j;
import oldpig.common.service.AbstractPigService;

@Slf4j
@Service
public class ExcelService extends AbstractPigService {
	
    @Autowired
    ExcelFactory excelFactory;

	public List<Map<String, String>> upload(MultipartFile excelfile, ModelMap model, CommandMap commandMap) throws Exception {
		return excelFactory.upload(excelfile, model, commandMap);
	}

	public void download(HttpServletRequest request, HttpServletResponse response
			,String dnFileName // 다운로드 엑셀파일명
			,List<String> headerNames // 엑셀파일 컬럼명
			,List<String> fieldNames  // 쿼리결과 필드명
			,List<Map<String, Object>> result) throws Exception {
		excelFactory.download(request, response, dnFileName, headerNames, fieldNames, result);
	}

	
}
