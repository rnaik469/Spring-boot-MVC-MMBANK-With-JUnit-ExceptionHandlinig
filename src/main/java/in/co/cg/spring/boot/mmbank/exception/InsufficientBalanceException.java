package in.co.cg.spring.boot.mmbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="Insufficient Balance")  // 406
public class InsufficientBalanceException extends RuntimeException {
	public InsufficientBalanceException(String msg) {
			super(msg);
	}
}
