package exception;

/**
 * 새로운 비밀번호가 이전 비밀번호와 일치
 */
public class PasswordUnchangedException extends Exception {

	public PasswordUnchangedException() {}

	public PasswordUnchangedException(String message) {
		super(message);
	}
}
