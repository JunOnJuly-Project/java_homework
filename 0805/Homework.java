package ex0805.homework;

/**
 * 0805 과제
 * 5~6 장 확인문제
 * 성지훈
 */
public class Homework {

	public static void main(String[] args) {
		
	}

	public void FiveOneToFive() {
		int [] results = {4, 3, 2, 2, 3};
		for (int i = 0; i < 5; i++) {
			System.out.printf("%d 번의 답은 %d 입니다.", i + 1, results[i]);
		}
	}
	
	public void FiveSix() {
		System.out.printf("6 번의 답은 %d, %d 입니다.", 3, 5);
	}
	
	public int FiveSeven() {
		int[] array = {1, 5, 3, 8, 2};
		
		int max = 0;
		for (int num : array) {
			max = num > max ? num : max;
		}
		
		return max;
	}
	
	public void FiveEight() {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		int cnt = 0;
		
		for (int[] row : array) {
			for (int num : row) {
				sum += num;
				cnt += 1;
			}
		}
		
		int average = sum / cnt;
		
		System.out.printf("sum : %d / average : %d", sum, average);
	}
	
	public void SixOneToEleven() {
		int[] results = {3, 4, 4, 3, 1, 4, 2, 2, 2, 4, 3};
		for (int i = 0; i < 5; i++) {
			System.out.printf("%d 번의 답은 %d 입니다.", i + 1, results[i]);
		}
	}
	
	public void SixTwelve() {
		System.out.println("필드");
		System.out.println("생성자");
		System.out.println("메소드");
	}
	
	public void SixThirteen() {
		Member m = new Member("성지훈", "A01", "0717", 30);
		System.out.println(m);
	}
	
	public void SixFourteen() {
		Member m = new Member("홍길동", "hong");
		System.out.println(m);
	}
}

// 6-13, 14
class Member {
	String name;
	String id;
	String password;
	int age;
	
	Member(String name, String id, String password, int age) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
	}
	
	Member(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

// 6-15
class MemberService {
	private String id = "hong";
	private String password = "12345";
	
	public boolean login (String id, String password) {
		if (this.id == id && this.password == password) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public void logout(String id) {
		System.out.printf("%s 님이 로그아웃 되었습니다.", id);
	}
}
// 6-16, 17
class Printer {
	public static void println(){};
	
	public static void println(int i){};
	
	public static void println(boolean b){};
	
	public static void println(double d){};
}

// 6-18
class ShopService {
	private static ShopService ss = new ShopService();
	
	private ShopService () {};
	
	public ShopService getInstance() {
		return ss;
	}
}

// 6-19
class Account {
	private static int MIN_BALANCE = 0;
	private static int MAX_BALANCE = 1000000;
	
	private int balance;
	
	public void setBalance(int balance) {
		if (balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
			this.balance = balance;
		}
	}
	
	public int getBalance() {
		return this.balance;
	}
}

// 6-20
class AccountHW {
	String accountNumber;
	String name;
	int balance;
	
	AccountHW(String accountNumber, String name, String balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = Integer.parseInt(balance);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = Integer.parseInt(balance);
	}
}

class BankApplication {
	private Account[] accountList = new Account[100];
	private int accountCnt = 0;
	
	public void addAccount(Account account) {
		accountList[accountCnt++] = account;
	}
}