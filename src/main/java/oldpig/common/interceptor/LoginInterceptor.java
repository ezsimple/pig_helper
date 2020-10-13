package oldpig.common.interceptor;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import io.mkeasy.utils.NetUtil;
import lombok.extern.slf4j.Slf4j;
import oldpig.utils.PropertiesUtil;


@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter
{	
	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	final String BASE_MAPPING = "/egg/api";

	@Autowired
	PropertiesUtil propertiesUtil;

	@Autowired
	private Environment env;

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception  {
		
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("X-Frame-Option", "DENY");

		HttpServletRequest req = ((HttpServletRequest) request);
	    HttpSession session = req.getSession();

	    long _ms = System.currentTimeMillis();
	    LocalDateTime _now = LocalDateTime.now();
	    String _adminlte = propertiesUtil.getProperty("adminlte");

	    session.setAttribute("_adminlte", _adminlte);
	    session.setAttribute("_dateFormat", "yyyy-MM-dd");
	    session.setAttribute("_now", _now.toDate());
	    session.setAttribute("_ms", _ms);
	    
		return isIpAllowed();
	}
	
	private String getProfile() {
		String[] profiles = env.getActiveProfiles();
		
		if(profiles.length == 0)
			profiles = env.getDefaultProfiles();
		
		log.debug("profiles => {}", profiles[0]);
		
		return profiles[0];
	}

	private boolean isIpAllowed() {
		String clientIp = NetUtil.getClientIP();
		String env = getProfile();

		if (StringUtils.equals(env, "local"))
			return true;

		// ezfarm 사무실에서만 접근 가능
		if (!(StringUtils.startsWith(clientIp, "192.168.3")     	// 3층
				|| StringUtils.startsWith(clientIp, "192.168.4")   	// 4층
				)) {
			log.warn("clientIp : {} is rejected", clientIp);
			return false;
		}
		return true;
	}

}