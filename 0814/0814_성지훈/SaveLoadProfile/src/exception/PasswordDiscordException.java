package exception;

/**
 * 비밀번호를 틀림 (3회 미만)
 */
public class PasswordDiscordException extends Exception {

	public PasswordDiscordException() {}
	
	public PasswordDiscordException(String message) {
		super(message);
	}
}
