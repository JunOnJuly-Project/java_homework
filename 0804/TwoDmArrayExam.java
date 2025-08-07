package ex0804.homework;

//TwoDmArrayExam.java

class TwoDmArray{
	//String을 저장하는 twoDmArray 배열선언
	String [][] strings;
	//메소드 make2DmArray
	public void make2DmArray() {
		//twoDmArray 배열에  값을 할당
		strings = new String[10][];
		for (int i = 0;  i <10; i++) {
			strings[i] = new String[i+1];
			for (int j = 0; j < i+1; j++) {
				strings[i][j] = String.format("| %d동 %d호 ", i+1, j+1);
			}
		}
	}
	
	//메소드 print2DmArray
	public void print2DmArray() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j < i) {
					System.out.print("\t\t");
				}
				
				else {
					System.out.print(strings[j][i] + "\t");
				}
			}
			
			System.out.println();
		}
	}
	//	twoDmArray 배열의 값을 주어진형식으로 출력
		
}

public class TwoDmArrayExam{
	//main메소드에서
		public static void main(String[] args) {
			//TwoDmArray객체생성
			TwoDmArray tda = new TwoDmArray();
			//TwoDmArray객체의 make2DmArray메소드 호출
			tda.make2DmArray();
			//TwoDmArray객체의 print2DmArray메소드 호출
			tda.print2DmArray();
		}
	
}
