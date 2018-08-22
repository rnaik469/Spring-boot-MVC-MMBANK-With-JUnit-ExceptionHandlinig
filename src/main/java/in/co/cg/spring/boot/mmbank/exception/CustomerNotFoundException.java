package in.co.cg.spring.boot.mmbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Account not Found!!!")  // 404
public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException(String msg) {
			super(msg);
	}
}
