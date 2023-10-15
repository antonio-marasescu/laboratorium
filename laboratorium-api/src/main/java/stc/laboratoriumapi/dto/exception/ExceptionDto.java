package stc.laboratoriumapi.dto.exception;

import lombok.Builder;
import lombok.Data;
import stc.laboratoriumapi.domain.enums.ExceptionCode;

@Data
@Builder
public class ExceptionDto {
	private ExceptionCode code;
	private String reason;
}
