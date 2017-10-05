package eu.lucid.utils;

import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

import eu.lucid.rest.response.GeneralResponseDTO;
import eu.lucid.rest.response.Status;

public class BindingUtils {

	public static GeneralResponseDTO<?> getErrorResponse(BindingResult bindingResult) {
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, bindingResult.getFieldErrors().stream()
				.map(e -> e.getField() + " " + e.getDefaultMessage()).collect(Collectors.joining(",")));
	}

}
