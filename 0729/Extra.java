package ex0729.homework;

public class Extra {

	public static void main(String[] args) {
		String name = "성지훈";
		
		int kor, eng, math;
		kor = 45 + (int) (Math.random()*56);
		eng = 45 + (int) (Math.random()*56);
		math = 45 + (int) (Math.random()*56);
		
		int sum;
		double mean;
		char unit = 'F';
		
		sum = kor + eng + math;
		mean = (double) sum/3;
		
		// if
		if (mean>=90) unit = 'A';
		else if (mean>=80) unit = 'B';
		else if (mean>=70) unit = 'C';
		else if (mean>=60) unit = 'D';
		
		System.out.println("이름 : " + name);
		System.out.println("국어 점수 : " + kor);
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수: " + math);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + mean);
		System.out.println("학점 : " + unit);
		
		System.out.println("===================");
		
		// switch
		int initialMean = (int) mean/10;
		
		unit = switch (initialMean) {
			case 10, 9 -> 'A';
			case 8 -> 'B';
			case 7 -> 'C';
			case 6 -> 'D';
			default -> 'F';
		};
		
		System.out.println("이름 : " + name);
		System.out.println("국어 점수 : " + kor);
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수: " + math);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + mean);
		System.out.println("학점 : " + unit);
	}
}
