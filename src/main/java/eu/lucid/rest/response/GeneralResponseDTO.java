package eu.lucid.rest.response;

public class GeneralResponseDTO<T> {

	private Status status;
	private String message;
	private T data;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public GeneralResponseDTO<T> buildEmptyWithMessage(String message) {
		return new Builder<T>().status(Status.OK).message(message).build();
	}

	public GeneralResponseDTO<T> buildEmptyWithError(String error) {
		return new Builder<T>().status(Status.ERROR).message(error).build();
	}

	public GeneralResponseDTO<T> buildWithData(T data) {
		return new Builder<T>().status(Status.OK).data(data).build();
	}

	public static class Builder<T> {
		private Status status;
		private String message;
		private T data;

		public Builder<T> status(Status status) {
			this.status = status;
			return this;
		}

		public Builder<T> message(String message) {
			this.message = message;
			return this;
		}

		public Builder<T> data(T data) {
			this.data = data;
			return this;
		}

		public GeneralResponseDTO<T> build() {
			GeneralResponseDTO<T> generalResponseDTO = new GeneralResponseDTO<>();
			generalResponseDTO.status = status;
			generalResponseDTO.message = message;
			generalResponseDTO.data = data;
			return generalResponseDTO;
		}
	}
}
