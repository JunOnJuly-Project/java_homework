package service;

import exception.*;

import dto.Profile;

public interface ProfileService {
	/**
	 * 프로필을 저장하는 메서드
	 * @param savePath 프로필이 저장될 경로 [String]
	 */
	void saveProfile();
	
	/**
	 * 프로필을 불러오는 메서드
	 * @param savePath 프로필이 저장되어 있는 경로 [String]
	 */
	void loadProfile();
	
	/**
	 * 프로필을 입력받아 저장하는 메서드
	 * @param profile 저장할 프로필 오브젝트 [Profile]
	 */
	void insert(Profile profile) throws DuplicateException;
	

	/**
	 * 이름과 비밀번호를 입력받아 프로필을 검색하는 메서드
	 * @param name 이름 [String]
	 * @param password 비밀번호 [String[
	 */
	Profile searchByName(String name, String password) 
			throws NameNotFoundException, PasswordDiscordException, PasswordDiscordCountOverException;
	
	/**
	 * 이름과 비밀번호를 입력받아 몸무게를 수정하는 메서드
	 * @param name 이름  [String]
	 * @param password 비밀번호 [String]
	 * @param weight [int]
	 */
	void updateWeight(String name, int weight, String password)
			throws NameNotFoundException, PasswordDiscordException, PasswordDiscordCountOverException;
	
	/**
	 * 이름과 비밀번호를 입력받아 비밀번호를 수정하는 메서드
	 * @param name 이름 [String]
	 * @param password 기존 비밀번호 [String]
	 * @param newPassword 변경할 비밀번호 [String]
	 */
	void updatePassword(String name, String password, String newPassword) 
			throws NameNotFoundException, PasswordDiscordException,
					PasswordUnchangedException, PasswordDiscordCountOverException;
}
