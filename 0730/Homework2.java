package ex0730.homework;

import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = 0;
		while (true) {
			System.out.println("-----------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------------------");
			
			System.out.print("선택> ");
			String select = sc.nextLine();
			
			switch(select) {
				case  "1" -> {
					System.out.print("예금액> ");
					money += Integer.parseInt(sc.nextLine());
					break;
				}
				case "2" -> {
					System.out.print("출금액> ");
					int getMoney = Integer.parseInt(sc.nextLine());
					
					if (getMoney > money) System.out.println("예금액> " + money + "\n잔액이 부족합니다.");
					else money -= getMoney;
					
					break;
				}
				case "3" -> {
					System.out.println("잔액> " + money + "\n");
				}
				case "4" -> {
					System.out.println("\n프로그램 종료");
					System.exit(0);
				}
			}
		}
	}

}
