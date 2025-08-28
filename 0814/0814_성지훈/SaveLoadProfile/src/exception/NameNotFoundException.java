package exception;

/**
 * 이름을 찾을 수 없음
 */
public class NameNotFoundException extends Exception {

	public NameNotFoundException() {}

	public NameNotFoundException(String message) {
		super(message);
	}
}
