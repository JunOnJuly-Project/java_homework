package ex0807.homework.sample02;

public class PartTime extends Employee {
	private int timePay;
	
	// -------- constructor ---------//
	public PartTime() {};

	public PartTime(int empNo, String eName, String job, int mgr, String hiredate, String depName, int timePay) {
		super(empNo, eName, job, mgr, hiredate, depName);
		this.timePay = timePay;
	}
	// --------------- getter & setter ------------------ //
	public int getTimePay() {
		return timePay;
	}
	
	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}
	// ----------- toString -------------- //
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" | ");
		builder.append(timePay);

		return builder.toString();
	}
	// ----------- else -------------//
	public void message() {
		super.message();
		System.out.println("비정규직 입니다.");
	}
}
