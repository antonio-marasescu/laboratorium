package stc.laboratoriumapi.exception;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import stc.laboratoriumapi.domain.enums.ExceptionCode;

@Builder
@EqualsAndHashCode(callSuper = true)
@Data
public class ApiException extends RuntimeException {
	private ExceptionCode code;
}
