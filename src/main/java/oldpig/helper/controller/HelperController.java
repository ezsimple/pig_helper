package oldpig.helper.controller;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import io.mkeasy.resolver.CommandMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
class HelperController {
	
	@Resource 
	ApplicationContext ctx;

	@RequestMapping(value= {"/"})
	public String hello(ModelMap model, CommandMap commandMap) throws Exception {
		commandMap.debugParams();
		return "hello";
	}

}
