package view;

import java.util.Scanner;

import controller.ProfileController;
import dto.Profile;

import exception.*;

/**
   사용자의 요청을 키보드로 입력받는 클래스 
*/
public class MenuView{
    private Scanner sc= new Scanner(System.in);
	private ProfileController controller = new ProfileController(); // 전역변수 초기화, 생성자 호출 
	/**
	  전체 메뉴를 출력하는 메소드
	*/
	public void printMenu(){
        
		 while(true){
			 System.out.println("-------------------------------------------------------------------------------------------------------------");
			 System.out.println("1. 몸무게 입력    2. 몸무게 검색     3. 몸무게 변경     4. 비밀번호 변경   5. 프로그램 종료");
			 System.out.println("-------------------------------------------------------------------------------------------------------------");
			 System.out.print("메뉴선택 > ");

			 String  menu = sc.nextLine();
			 switch(menu){
			 case "1" : 
				 insertProfile();
				 break;
			 case "2" : 
				 searchByName();
				 break;
			 case "3" : 
				 updateWeight();
				 break;
			 case "4" : 
				 updatePassword();
				 break;
			 case "5" : 
				 saveProfile();
				 System.exit(0);
			 default:
				 System.out.println("메뉴를 다시 선택해주세요!!!!");

			   }//switch문끝

			 }//while문끝
	
	}//메소드끝
	
	/**
	 * 상태 저장
	 */
	private void saveProfile() {
		controller.saveProfile();
	}
	
	/**
	 * 프로필 입력
	 */
	private void insertProfile() {
		try {
			System.out.print("이름을 입력해주세요 : ");
			String name = sc.nextLine();
			
			System.out.print("몸무게을 입력해주세요 : ");
			int weight = Integer.parseInt(sc.nextLine());
			
			System.out.print("비밀번호를 입력해주세요 : ");
			String password = sc.nextLine();
			
			controller.insert(new Profile(name, weight, password));
		} catch (Exception e) {
			// 몸무게가 string 으로 들어왔을 때
			FailView.printFailMessage("몸무게는 정수만 입력 가능합니다.");
		}
	}
	
	/**
	 * 이름으로 검색
	 */
	private void searchByName() {
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		System.out.print("비밀번호를 입력해주세요 : ");
		String password = sc.nextLine();
		
		try {
			controller.searchByName(name, password);
		} catch (PasswordDiscordException e) {
			// 비밀번호를 틀렸을 시 (3회 미만) 오류 메시지 출력 후 재귀
			FailView.printFailMessage(e.getMessage());
			searchByName();
		}
	}
	
	/**
	 * 몸무게 변경
	 */
	private void updateWeight() {
		try {
			System.out.print("이름을 입력해주세요 : ");
			String name = sc.nextLine();
			
			System.out.print("몸무게을 입력해주세요 : ");
			int weight = Integer.parseInt(sc.nextLine());
			
			System.out.print("비밀번호를 입력해주세요 : ");
			String password = sc.nextLine();
			
			controller.updateWeight(name, weight, password);
			
		} catch (PasswordDiscordException e) {
			// 비밀번호를 틀렸을 시 (3회 미만) 오류 메시지 출력 후 재귀
			FailView.printFailMessage(e.getMessage());
			updateWeight();
		} catch (Exception e) {
			// 몸무게가 string 으로 들어왔을 때
			FailView.printFailMessage("몸무게는 정수만 입력 가능합니다.");
		}
	}
	
	/**
	 * 비밀번호 변경
	 */
	private void updatePassword() {
		try {
			System.out.print("이름을 입력해주세요 : ");
			String name = sc.nextLine();
			
			System.out.print("현재 비밀번호를 입력해주세요 : ");
			String password = sc.nextLine();
			
			System.out.print("변경할 비밀번호를 입력해주세요 : ");
			String newPassword = sc.nextLine();
			
			controller.updatePassword(name, password, newPassword);
		} catch (PasswordDiscordException e) {
			// 비밀번호를 틀렸을 시 (3회 미만) 오류 메시지 출력 후 재귀
			FailView.printFailMessage(e.getMessage());
			updatePassword();
		}
	}
}