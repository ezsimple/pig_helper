package oldpig.helper.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import io.mkeasy.resolver.CommandMap;
import lombok.extern.slf4j.Slf4j;
import oldpig.utils.PropertiesUtil;

@Slf4j
@Controller
class HelperController {
	
	@Resource 
	ApplicationContext ctx;
	
	@Autowired
	PropertiesUtil propertiesUtil;

	@RequestMapping(value= {"/"})
	public String index(ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		return "index";
	}

}
