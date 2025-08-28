package exception;

/**
 * 이름 중복
 */
public class DuplicateException extends Exception {

	public DuplicateException() {}

	public DuplicateException(String message) {
		super(message);
	}
}
