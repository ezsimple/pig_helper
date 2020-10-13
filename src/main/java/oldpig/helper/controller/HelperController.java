package oldpig.helper.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import io.mkeasy.resolver.CommandMap;
import lombok.extern.slf4j.Slf4j;
import oldpig.helper.service.HelperService;
import oldpig.utils.PropertiesUtil;

@Slf4j
@Controller
class HelperController {
	
	@Resource 
	ApplicationContext ctx;
	
	@Autowired
	PropertiesUtil propertiesUtil;
	
	@Autowired
	HelperService helperService;

	// 월요일 육종가 업로드
	@RequestMapping(value= {"/excel/yukjongga.do"}, method=RequestMethod.POST)
	public String excel1(@RequestParam(value="file") MultipartFile file, ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		helperService.excel1(file, model, commandMap);
		return excel1(model, commandMap);
	} 
	// 월요일 육종가
	@RequestMapping(value= {"/excel/yukjongga.do"}, method=RequestMethod.GET)
	public String excel1(ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		return "excel/yukjongga";
	} 
	

	// 매달 시세 업로드
	@RequestMapping(value= {"/excel/sisae.do"}, method=RequestMethod.POST)
	public String excel2(@RequestParam(value="file") MultipartFile file, ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		helperService.excel2(file, model, commandMap);
		return excel2(model, commandMap);
	} 
	// 매달 시세
	@RequestMapping(value= {"/excel/sisae.do"}, method=RequestMethod.GET)
	public String excel2(ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		return "excel/sisae";
	}
	


	// 농장데이터 이관 업로드
	@RequestMapping(value= {"/excel/farm_migration.do"}, method=RequestMethod.POST)
	public String excel3(@RequestParam(value="file") MultipartFile file, ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		helperService.excel3(file, model, commandMap);
		return excel3(model, commandMap);
	} 
	// 농장데이터 이관
	@RequestMapping(value= {"/excel/farm_migration.do"}, method=RequestMethod.GET)
	public String excel3(ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		return "excel/farm_migration";
	}
	


	// 다비육종 생시체중 업로드
	@RequestMapping(value= {"/excel/dabi_seangsi_chejung.do"}, method=RequestMethod.POST)
	public String excel4(@RequestParam(value="file") MultipartFile file, ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		helperService.excel4(file, model, commandMap);
		return excel4(model, commandMap);
	} 
	// 다비육종 생시체중
	@RequestMapping(value= {"/excel/dabi_seangsi_chejung.do"}, method=RequestMethod.GET)
	public String excel4(ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		return "excel/dabi_seangsi_chejung";
	}
	


	// 검정자료 IMF값 업로드
	@RequestMapping(value= {"/excel/jumjungzaryu_imf.do"}, method=RequestMethod.POST)
	public String excel5(@RequestParam(value="file") MultipartFile file, ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		helperService.excel5(file, model, commandMap);
		return excel5(model, commandMap);
	} 
	// 검정자료 IMF값
	@RequestMapping(value= {"/excel/jumjungzaryu_imf.do"})
	public String excel5(ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		return "excel/jumjungzaryu_imf";
	}
	


	// 도드람농가 업데이트 업로드
	@RequestMapping(value= {"/excel/dodram_update.do"}, method=RequestMethod.POST)
	public String excel6(@RequestParam(value="file") MultipartFile file, ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		helperService.excel6(file, model, commandMap);
		return excel6(model, commandMap);
	} 
	// 도드람농가 업데이트
	@RequestMapping(value= {"/excel/dodram_update.do"})
	public String excel6(ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		return "excel/dodram_update";
	}
	
	

	// 자돈등기 파일출력
	@RequestMapping(value= {"/excel/jadondunggi_print.do"})
	public String excel7(ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		return "excel/jadondunggi_print";
	}


}
