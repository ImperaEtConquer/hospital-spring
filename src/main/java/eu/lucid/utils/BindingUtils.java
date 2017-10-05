package eu.lucid.utils;

import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

import eu.lucid.rest.response.GeneralResponseDTO;
import eu.lucid.rest.response.Status;

public class BindingUtils {

	public static GeneralResponseDTO<?> getErrorResponse(BindingResult bindingResult) {
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, bindingResult.getAllErrors().stream()
				.map(e -> e.getDefaultMessage().toString()).collect(Collectors.joining(",\n")));
	}

}
