package controller;

import dto.Profile;

import service.ProfileService;
import service.ProfileServiceIMPL;

import view.FailView;
import view.SuccessView;
import exception.*;

/**
 * 컨트롤러
 */
public class ProfileController {
	private ProfileService service = ProfileServiceIMPL.getInstance();
	/**
	 * 파일 저장
	 */
	public void saveProfile() {
		service.saveProfile();
	}
	
	/** 
	 * 파일 로드
	 */
	public void loadProfile() {
		service.loadProfile();
	}
	
	/**
	 * 프로필 생성
	 * @param profile 프로필 정보 [Profile]
	 */
	public void insert(Profile profile) {
		try {
			service.insert(profile);
			SuccessView.printSuccessMessage("프로필 저장 완료");
		} catch (DuplicateException e) {
			// 이름 중복
			FailView.printFailMessage(e.getMessage());
		}
	}
	
	/**
	 * 이름과 비밀번호로 유효성 검사 후 프로필 출력
	 * @param name 이름 [String]
	 * @param password 비밀번호 [String]
	 * @throws PasswordDiscordException 비밀번호가 틀렸을 시 이름과 비밀번호를 재 입력받기 위한 Exception
	 */
	public void searchByName(String name, String password) throws PasswordDiscordException {
		try {
			Profile p = service.searchByName(name, password);
			SuccessView.printSearchByName(p);
		} catch (NameNotFoundException | PasswordDiscordCountOverException e) {
			// 이름 중복 혹은 비밀번호를 3번 틀림
			// 비밀번호가 3번 틀리면 새로 시작
			FailView.printFailMessage(e.getMessage());
		}
	}
	
	/**
	 * 이름과 비밀번호로 유효성 검사 후 무게를 변경
	 * @param name 이름 [String]
	 * @param weight 무게 [int]
	 * @param password 비밀번호 [String]
	 * @throws PasswordDiscordException 비밀번호가 틀렸을 시 이름과 비밀번호를 재 입력받기 위한 Exception
	 */
	public void updateWeight(String name, int weight, String password) throws PasswordDiscordException {
		try {
			service.updateWeight(name, weight, password);
			SuccessView.printSuccessMessage("몸무게 변경 완료");
		} catch (NameNotFoundException | PasswordDiscordCountOverException e) {
			// 이름 중복 혹은 비밀번호를 3번 틀림
			// 비밀번호가 3번 틀리면 새로 시작
			FailView.printFailMessage(e.getMessage());
		}
	}
	
	/**
	 * 비밀번호와 새로운 비밀번호가 같으면 Exception
	 * 이름과 비밀번호로 유효성 검사 후 비밀번호를 변경
	 * @param name 이름 [String]
	 * @param password 비밀번호 [String]
	 * @param newPassword 새로운 비밀번호 [String]
	 * @throws PasswordDiscordException 비밀번호가 틀렸을 시 이름과 비밀번호를 재 입력받기 위한 Exception
	 */
	public void updatePassword(String name, String password, String newPassword) throws PasswordDiscordException {
		try {
			service.updatePassword(name, password, newPassword);
			SuccessView.printSuccessMessage("비밀번호 변경 완료");
		} catch (PasswordUnchangedException e) {
			// 새로운 비밀번호가 이전 비밀번호와 같음
			FailView.printFailMessage(e.getMessage());
		} catch (NameNotFoundException | PasswordDiscordCountOverException e) {
			// 이름 중복 혹은 비밀번호를 3번 틀림
			// 비밀번호가 3번 틀리면 새로 시작
			FailView.printFailMessage(e.getMessage());
		}
	}
}
