package ex0807.homework.sample02;

public class Employee {
	private int empNo;
	private String eName;
	private String job;
	private int mgr;
	private String hiredate;
	private String depName;
	
	// -------- constructor ---------//
	public Employee() {};
	public Employee(int empNo, String eName, String job, int mgr, String hiredate, String depName) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.depName = depName;
	}
	// --------------- getter & setter ------------------ //
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	// ----------- toString -------------- //
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(empNo);
		builder.append(" | ");
		builder.append(eName);
		builder.append(" | ");
		builder.append(job);
		builder.append(" | ");
		builder.append(mgr);
		builder.append(" | ");
		builder.append(hiredate);
		builder.append(" | ");
		builder.append(depName);
	
		return builder.toString();
	}
	// ----------- else -------------//
	public void message() {
		System.out.print(eName + " 사원은 ");
	}
}
