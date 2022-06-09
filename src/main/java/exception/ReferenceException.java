package exception;

public class ReferenceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String exceptionCode;
	private String message;

	public ReferenceException() {
		super();
	}

	public ReferenceException(String message) {
		super(message);
		this.message = message;
	}
	public ReferenceException(String exceptionCode,String message) {
		super();
		this.exceptionCode = exceptionCode;
		this.message = message;
	}
	public String getExceptionCode() {
		return exceptionCode;
	}
	public String getMsg() {
		return message.toString();
	}

}
