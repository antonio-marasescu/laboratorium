package stc.laboratoriumapi.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import stc.laboratoriumapi.domain.enums.ExceptionCode;
import stc.laboratoriumapi.dto.exception.ExceptionDto;
import stc.laboratoriumapi.exception.ApiException;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ApiException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ExceptionDto> handleApiException(
			ApiException apiException
	) {
		ExceptionDto dto = ExceptionDto.builder().code(apiException.getCode()).build();
		return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ExceptionDto> handleDefaultException(
			Exception exception
	) {
		ExceptionDto dto = ExceptionDto.builder()
		                               .code(ExceptionCode.TECHNICAL_DEFAULT)
		                               .reason(exception.getMessage())
		                               .build();
		return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
