package br.com.vida.TratamentoErrosException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHadler extends ResponseEntityExceptionHandler{

	public final ResponseEntity<VidaExceptions> hadleAllExceptions(Exception ex, WebRequest request){
		VidaExceptions vidaExceptions = 
				new VidaExceptions(
						new Date(),
						ex.getMessage(),
						request.getDescription(false));
		return new ResponseEntity<>(vidaExceptions, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
}
