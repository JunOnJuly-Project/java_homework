package view;

import dto.Profile;

/**
 * 성공 시 뷰
 */
public class SuccessView {
	private final static int PAD = 5;
	
	public static void printSuccessMessage (String message) {
		System.out.println();
		System.out.println(" ".repeat(PAD) + message);
		System.out.println();
	}
	
	public static void printSearchByName (Profile profile) {
		System.out.println();
		System.out.printf(" ".repeat(PAD) + profile, profile.getName(), profile.getWeight());
		System.out.println();
		System.out.println();
	}
}
