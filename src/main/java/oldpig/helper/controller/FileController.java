package oldpig.helper.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.mkeasy.resolver.CommandMap;
import lombok.extern.slf4j.Slf4j;
import oldpig.helper.service.FileService;
import oldpig.utils.PropertiesUtil;

@Slf4j
@Controller
class FileController {
	
	@Resource 
	ApplicationContext ctx;
	
	@Autowired
	PropertiesUtil propertiesUtil;
	
	@Autowired
	FileService fileService;

	@RequestMapping(value= {"/dl.do"})
	public void download(HttpServletRequest request, HttpServletResponse response, CommandMap commandMap) throws Exception {
		fileService.download(request, response, commandMap);
	}

}
