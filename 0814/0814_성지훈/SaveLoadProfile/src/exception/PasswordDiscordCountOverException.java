package exception;

/**
 * 비밀번호를 3회 틀림
 */
public class PasswordDiscordCountOverException extends Exception {

	public PasswordDiscordCountOverException() {}

	public PasswordDiscordCountOverException(String message) {
		super(message);
	}
	
}
