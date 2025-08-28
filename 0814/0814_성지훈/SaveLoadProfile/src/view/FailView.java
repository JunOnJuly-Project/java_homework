package view;

/**
 * 틀렸을 시 뷰
 */
public class FailView {
	private final static int PAD = 5;
	
	public static void printFailMessage (String message) {
		System.out.println();
		System.out.println(" ".repeat(PAD) + message);
		System.out.println();
	}
}
