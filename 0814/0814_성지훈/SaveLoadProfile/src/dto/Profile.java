package dto;

import java.io.Serializable;

/**
 * 프로필
 */
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int weight;
	private String password;
	
	///////////////////////////// 생성자 /////////////////////////////
	public Profile() {}
	
	public Profile(String name, int weight, String password) {
		super();
		this.name = name;
		this.weight = weight;
		this.password = password;
	}
	
	public Profile(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	///////////////////////////// toString /////////////////////////////
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append("님의 몸무게는 ");
		builder.append(weight);
		builder.append("kg 입니다. ");
		return builder.toString();
	}

	////////////////////////// getter / setter //////////////////////////
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
