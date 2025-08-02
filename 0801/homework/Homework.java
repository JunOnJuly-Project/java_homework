package ex0801.homework;

import java.util.Scanner;

public class Homework {
	public static void main(String[] args) {
		Homework hw = new Homework();
		
		System.out.println(hw.seven());
		hw.nine();
	}
	
	public int seven () {
		int[] array = {1, 5, 3, 8, 2 };
		
		int max = 0;
		for (int num :array) max = num>max ? num : max;
		
		return max;
	}
	
	public void nine () {
		int studentNum = 0;
		int[] scores = {};
		
		Scanner sc = new Scanner(System.in);
		
		
		
		while (true) {
			System.out.println("-".repeat(60));
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.print("선택> ");
			
			int menuSelected = Integer.parseInt(sc.nextLine());

			switch (menuSelected) {
				case 1 -> {
					System.out.print("학생수> ");
					
					studentNum = Integer.parseInt(sc.nextLine());
					scores = new int[studentNum];		
				}
				
				case 2 -> {
					for (int i=0;i<studentNum;i++) {
						System.out.printf("scores[%d]> ", i);
						scores[i] = Integer.parseInt(sc.nextLine());
						System.out.println();
					}	
				}
				
				case 3 -> {
					for (int i=0;i<studentNum;i++) {
						System.out.printf("scores[%d] : %d ", i, scores[i]);
						System.out.println();
					}
				}
				
				case 4 -> {
					int max = 0;
					int sum = 0;
					double mean = 0;
					
					for (int i=0;i<studentNum;i++) {
						int score = scores[i];
						
						max = scores[i]>max ? scores[i] : max;
						sum += score;
					}
					
					mean = (double) sum / studentNum;
					
					System.out.printf("최고 점수 : %d\n", max);
					System.out.printf("평균 점수 : %.2f\n", mean);
				}
				
				case 5 -> {
					System.out.println("프로그램 종료");
					System.out.println();		
					System.exit(0);
				}	
			}
		}
	}
}