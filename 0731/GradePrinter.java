package ex0731.homework;

import java.util.Scanner;

class  ScoreCalculator {
	private int sumScores(int korScore, int engScore, int mathScore) {
		return korScore + engScore + mathScore;
	}
	
	private double meanScores(int scoreSum, int subjectNum) {
		return (double) scoreSum / subjectNum;
	}
	
	private char gradeScore(double scoreMean) {
		return switch((int) scoreMean/10) {
			case 10, 9 -> 'A';
			case 8 -> 'B';
			case 7 -> 'C';
			case 6 -> 'D';
			default -> 'F';
		};
	}
	
	public void printResult(int korScore, int engScore, int mathScore) {
		int scoreSum = sumScores(korScore, engScore, mathScore);
		System.out.println(String.format("총점은 %d 점 입니다.", scoreSum));
		
		double scoreMean = meanScores(scoreSum, 3) ;
		System.out.println(String.format("평균 점수는 %.2f 점 입니다.", scoreMean));
		
		char grade = gradeScore(scoreMean);
		System.out.println(String.format("등급은 %c 입니다.", grade));
	}
}

public class GradePrinter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int korScore=0;
		int engScore=0;
		int mathScore=0;
		
		while(true) {
			System.out.println("--------------------------------------------------");
			System.out.println("-----------메뉴를 선택해 주세요-------------");
			System.out.println("--------------------------------------------------");
			System.out.println("--------1. 성적표구하기---- 2. 종료---------");
			System.out.println("--------------------------------------------------");
			
			System.out.print("  >> ");
			String menuSelected = sc.nextLine();
			System.out.println();
			
			switch (menuSelected) {
				case "1" -> {
					System.out.println("--차례로 세 과목의 점수를 입력해주세요-");
					
					System.out.print("-국어점수 : ");
					korScore = Integer.parseInt(sc.nextLine());
					
					System.out.print("-영어점수 : ");
					engScore = Integer.parseInt(sc.nextLine());
					
					System.out.print("-수학점수 : ");
					mathScore = Integer.parseInt(sc.nextLine());
				}
				case "2" -> {System.exit(0);}
				default -> {System.out.println("-메뉴를 다시 골라주세요-");}
			}
			
			ScoreCalculator scc = new ScoreCalculator();
			scc.printResult(korScore, engScore, mathScore);
			System.out.println();
		}
	}
}