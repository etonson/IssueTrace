package exception;

public class ReferenceExceptionError extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Throwable exceptionCode;
	private Throwable message;

	public ReferenceExceptionError() {
		super();
	}

	public ReferenceExceptionError(Throwable message) {
		super(message);
		this.message = message;
	}
	public ReferenceExceptionError(Throwable exceptionCode,Throwable message) {
		super();
		this.exceptionCode = exceptionCode;
		this.message = message;
	}
	public String getExceptionCode() {
		return exceptionCode.fillInStackTrace().toString();
	}
	public String getMsg() {
		return message.getCause().toString();
	}

}
