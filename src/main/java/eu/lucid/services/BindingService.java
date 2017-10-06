package eu.lucid.services;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import eu.lucid.rest.response.GeneralResponseDTO;
import eu.lucid.rest.response.Status;

@Service
public class BindingService {

	public GeneralResponseDTO<?> getErrorResponse(BindingResult bindingResult) {
		return new GeneralResponseDTO<>().buildEmptyWithMessage(Status.ERROR, bindingResult.getFieldErrors().stream()
				.map(e -> e.getField() + " " + e.getDefaultMessage()).collect(Collectors.joining(",")));
	}

}
