package service;

import dto.Profile;
import exception.*;
import config.Config;

import java.io.*;
import java.util.*;

public class ProfileServiceIMPL implements ProfileService {
	private final static String SAVE_PATH = Config.get("data.file.path"); // 프로필 정보 로드 경로
	private static ProfileService instance = new ProfileServiceIMPL();
	private List<Profile> profiles;
	private int errorCnt = 0;
	
	/**
	 * 인스턴스 내보내기
	 * @return 인스턴스
	 */
    public static ProfileService getInstance() {
		return instance;
	}
    
	/**
	 * 저장된 객체 불러오기
	 */
	public ProfileServiceIMPL(){
		loadProfile();
	}
	
	/**
	 * 프로필 외부 경로에 저장
	 */
	@Override
	public void saveProfile() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH))) {
			oos.writeObject(profiles);
		} catch (Exception e) {}
	}
	
	/**
	 * 프로필 외부 경로에서 로드
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void loadProfile() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_PATH))) {
			Object obj = ois.readObject();
			profiles = (ArrayList<Profile>) ois.readObject();
		} catch (Exception e) {
			profiles = new ArrayList<Profile>();
		}
	}
	
	/**
	 * 프로필 리스트에 저장
	 */
	@Override
	public void insert(Profile profile) throws DuplicateException {
		for (Profile p : profiles) {
			if (p.getName().equals(profile.getName())) {
				throw new DuplicateException("중복된 이름은 사용할 수 없습니다.");
			}
		}
		
		profiles.add(profile);
	}
	
	/**
	 * 프로필을 이름으로 검색
	 */
	@Override
	public Profile searchByName(String name, String password)
			throws NameNotFoundException, PasswordDiscordException, PasswordDiscordCountOverException {
		
		Profile p = checkIsValid(name, password);
		return p;
	}
	
	/**
	 * 프로필에서 몸무게만 업데이트
	 */
	@Override
	public void updateWeight(String name, int weight, String password)
			throws NameNotFoundException, PasswordDiscordException, PasswordDiscordCountOverException {
		
		Profile p = checkIsValid(name, password);
		p.setWeight(weight);
	}
	
	/**
	 *  프로필에서 비밀번호만 업데이트
	 */
	@Override
	public void updatePassword(String name, String password, String newPassword)
			throws NameNotFoundException, PasswordDiscordException,
					PasswordUnchangedException, PasswordDiscordCountOverException {
		
		if (password.equals(newPassword)) {
			throw new PasswordUnchangedException("비밀번호가 이전과 같습니다.");
		}
		
		Profile p = checkIsValid(name, password);
		p.setPassword(newPassword);
	}
	
	/**
	 * 입력으로 받은 이름과 비밀번호가 유효한지 체크
	 * @param name 이름 [String]
	 * @param password 비밀번호 [String]
	 * @return 유효한 객체 [Profile]
	 * @throws PasswordDiscordCountOverException 비밀번호 3회 틀림
	 * @throws PasswordDiscordException 비밀번호 틀림 (3회 미만)
	 * @throws NameNotFoundException 이름을 찾을 수 없음
	 */
	private Profile checkIsValid(String name, String password) 
			throws PasswordDiscordCountOverException, PasswordDiscordException, NameNotFoundException {
		for (Profile p : profiles) {
			if (p.getName().equals(name)) {
				if (p.getPassword().equals(password) != true) {
					if (errorCnt >= 2) {
						errorCnt = 0;
						throw new PasswordDiscordCountOverException("비밀번호를 3회 틀렸습니다. 처음으로 돌아갑니다.");
					}
					
					else {
						throw new PasswordDiscordException("비밀번호를 틀렸습니다. 다시 입력해주세요 " + (++errorCnt) + "/3");
					}
				}
				errorCnt = 0;
				return p;
			}
		}
		
		throw new NameNotFoundException("일치하는 이름이 없습니다.");
	}
}
