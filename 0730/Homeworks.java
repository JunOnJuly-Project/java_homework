package ex0730.homework;

import java.util.Scanner;

public class Homeworks {

	public static void main(String[] args) {
		
	}
	
	public void num1() {
		System.out.println("1 번 문제의 답은 2 번 입니다.");
	}
	
	public void num2() {
		String grade = "B";
		int score1 = switch(grade) {
			case "A" -> 100;
			case "B" -> {
				int result = 100-20;
				yield result; 
			}
			default -> 60;
		};
	}
	
	public void num3() {
		int result = 0;
		for (int i=3;i<=100;i+=3) {
			result += i;
		}
		
		System.out.println(result);
	}
	
	public void num4() {
		while (true) {
			int dice1, dice2;
			dice1 = 1 + (int)(Math.random()*6);
			dice2 = 1 + (int)(Math.random()*6);
			
			int sum = dice1 + dice2;
			
			if (sum==5) break;
		}
	}
	
	public void num5() {
		for (int i=1; i<=10;i++) {
			int x = 4*i;
			
			if ((60-x)%5==0) {
				int j = (60-x)/5;
				System.out.println("("+i+" ,"+j+")");
			}
		}
	}
	
	public void num6() {
		for (int i=0;i<5;i++) {
			for (int j=0;j<=i;j++) {
				System.out.print("*");
			}
			
			System.out.print("\n");
		}
	}
}
