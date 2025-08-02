package ex0730.homework;

public class MakeStars {

	public static void main(String[] args) {
		for (int i=0;i<5;i++) {
			for (int j=0;j<=i;j++) {
				System.out.print("*");
			}
			
			System.out.print("\n");
		}

		System.out.println("-----------------------------------");
		
		for (int i=4;i>=0;i--) {
			for (int j=0;j<=i;j++) {
				System.out.print("*");
			}
			
			System.out.print("\n");
		}
		
		System.out.println("-----------------------------------");
		
		for (int i=0;i<5;i++) {
			for (int j=0;j<5;j++) {
				if (j>=4-i) System.out.print("*");
				else System.out.print("  ");
			}
			
			System.out.print("\n");
		}
		
		System.out.println("-----------------------------------");
		
		for (int i=0;i<5;i++) {
			for (int j=0;j<5;j++) {
				if (j>=i) System.out.print("*");
				else System.out.print("  ");
			}
			
			System.out.print("\n");
		}
	}

}
