package oldpig.helper.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import io.mkeasy.resolver.CommandMap;
import oldpig.common.service.AbstractPigService;

@Service
public class HelperService extends AbstractPigService {
	
	@Autowired
	ExcelService excelService;

	// 월요일 육종가
	public String excel1(MultipartFile excelfile, ModelMap model, CommandMap commandMap) throws Exception {
		excelService.upload(excelfile, model, commandMap);
		JSONObject result = new JSONObject();
		result.put("success", true);
		return  result.toString(2);
	}


	// 매달 시세
	public String excel2(MultipartFile excelfile, ModelMap model, CommandMap commandMap) throws Exception {
		excelService.upload(excelfile, model, commandMap);
		JSONObject result = new JSONObject();
		result.put("success", true);
		return  result.toString(2);
	}


	// 농장데이터 이관
	public String excel3(MultipartFile excelfile, ModelMap model, CommandMap commandMap) throws Exception {
		excelService.upload(excelfile, model, commandMap);
		JSONObject result = new JSONObject();
		result.put("success", true);
		return  result.toString(2);
	}


	// 다비육종 생시체중
	public String excel4(MultipartFile excelfile, ModelMap model, CommandMap commandMap) throws Exception {
		excelService.upload(excelfile, model, commandMap);
		JSONObject result = new JSONObject();
		result.put("success", true);
		return  result.toString(2);
	}


	// 검정자료 IMF값
	public String excel5(MultipartFile excelfile, ModelMap model, CommandMap commandMap) throws Exception {
		excelService.upload(excelfile, model, commandMap);
		JSONObject result = new JSONObject();
		result.put("success", true);
		return  result.toString(2);
	}

	// 도드람농가 업데이트
	public String excel6(MultipartFile excelfile, ModelMap model, CommandMap commandMap) throws Exception {
		excelService.upload(excelfile, model, commandMap);
		JSONObject result = new JSONObject();
		result.put("success", true);
		return  result.toString(2);
	}

	// 자돈등기 파일출력
	public String excel7(MultipartFile excelfile, ModelMap model, CommandMap commandMap) throws Exception {
		JSONObject result = new JSONObject();
		result.put("success", true);
		return  result.toString(2);
	}

}
