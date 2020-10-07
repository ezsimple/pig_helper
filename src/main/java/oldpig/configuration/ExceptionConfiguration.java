package oldpig.configuration;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionConfiguration {
	
	@ExceptionHandler(Exception.class)
    protected ResponseEntity<String> handleException(Exception e) {
        JSONObject message = new JSONObject();
		message.put("error", e.getMessage());
        return new ResponseEntity<>(message.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
