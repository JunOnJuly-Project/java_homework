package ex0807.homework.sample02;

public class FullTime extends Employee {
	private int salary;
	private int bonus;
	
	// -------- constructor ---------//
	public FullTime() {}

	public FullTime(int empNo, String eName, String job, int mgr, String hiredate, String depName, int salary, int bonus) {
		super(empNo, eName, job, mgr, hiredate, depName);
		this.salary = salary;
		this.bonus = bonus;
	}
	// --------------- getter & setter ------------------ //
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	// ----------- toString -------------- //

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" | ");
		builder.append(salary);
		builder.append(" | ");
		builder.append(bonus);

		return builder.toString();
	}
	// ----------- else -------------//
		public void message() {
			super.message();
			System.out.println("정규직 입니다.");
		}
}
