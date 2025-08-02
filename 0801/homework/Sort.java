package ex0801.homework;

/**
 * 정렬 함수를 담은 클래스
 * 버블 정렬 / 선택 정렬 / 삽입 정렬 
 */
public class Sort {
	public static void main ( String[] args ) {
		int[] arr = { 5, 7, 1, 2, 4, 3, 8, 9, 6, 10 };	// 주어진 어레이 , call by reference 를 막기위해 복제해서 삽입할 것
		int[][] arrs = {											// 정렬된 어레이들을 담을 어레이
				bubbleSort( arr.clone() ) ,					// 버블 정렬
				selectSort( arr.clone() ) ,					// 선택 정렬
				insertionSort( arr.clone() )					// 선택 정렬
		};
		
		Tools.prettyPrintAll( arrs );						// 어레이들을 이쁘게 출력하는 메서드
	}

	/**
	 * 						버블 정렬 / 인접한 값들끼리 비교하며 순차적으로 정렬
	 * @param arr		정렬할 어레이 int[]
	 * @return			정렬된 어레이 int[]
	 */
	public static int[] bubbleSort ( int[] arr ) {
		int arrLen = arr.length;								// 어레이의 길이
		
		for ( int i = 0 ; i < arrLen ; i++ ) {				// 어레이를 순회할 횟수
			for ( int j = 0 ; j < arrLen - 1 ; j++ ) {		// 비교 / 스왑 할 위치 ( j , j+1 )
				if ( arr[ j ] > arr [ j+1 ] ) {					// 앞의 값이 뒤의 값보다 크면
					Tools.swap(arr, j, j+1);					// 스왑
				}
			}
		}
		
		return arr;													// 정렬된 어레이 리턴
	}
	
	/**
	 * 						선택 정렬 / 어레이를 탐색해 최솟값을 앞에서 부터 정렬
	 * @param arr		정렬할 어레이 int[]
	 * @return			정렬된 어레이 int[]
	 */
	public static int[] selectSort(int[] arr) {
		int arrLen = arr.length;								// 어레이의 길이
		
		for ( int i = 0 ; i < arrLen - 1 ; i++ ) {			// 최솟값을 찾기 시작할 위치
			int min = Integer.MAX_VALUE;			// 최솟값을 비교하기 위해 최댓값으로 설정
			int minIdx = -1;										// 최솟값의 위치
			for ( int j = i ; j < arrLen ; j++ ) {			// 최솟값 탐색
				int num = arr[ j ];								// 현재값
				
				if ( num < min ) {								// 최솟값 보다 현재값이 작으면
					min = num;									// 최솟값 갱신
					minIdx = j;									// 최솟값 위치 갱신
				}
			}
			
			Tools.swap(arr, i, minIdx);						// 스왑
		}
		
		return arr;													// 리턴
	}
	
	/**
	 * 					삽입 정렬 / 키값을 순서대로 정해 해당 키값보다 앞선 위치를 순차적으로 정렬
	 * @param arr	정렬할 어레이 int[]
	 * @return		정렬된 어레이 int[]
	 */
	public static int[] insertionSort(int[] arr) {
		int arrLen = arr.length;								// 어레이의 길이
		
		for ( int i = 1 ; i < arrLen ; i++ ) {				// 탐색을 시작할 위치 / 0 은 앞선 위치가 없으므로 생략
			for ( int j = i ; j > 0 ; j-- ) {						// 키값의 위치
				if ( arr[ j ] <= arr[ j-1 ] ) {					// 키값이 앞선 위치의 값보다 작으면
					Tools.swap(arr, j, j-1);					// 스왑
				}
				
				else {													// 키값이 앞선 위치의 값보다 크면
					break;											// 종료 / 앞에서부터 정렬하기 때문에
				}														// 해당 위치보다 앞선 위치는 이미 정렬되어 있음
			}
		}
		
		return arr;													// 리턴
	}
}

/**
 * 도구 모음 클래스
 */
class Tools {
	/**
	 * 						어레이의 두 인덱스에 해당하는 값을 바꿔주는 메서드
	 * @param arr		입력된 어레이 int[]
	 * @param idx1	바꿀 위치 1 int
	 * @param idx2  	바꿀 위치 2 int
	 */
	public static void swap ( int[] arr, int idx1, int idx2 ) {
		int temp = arr[ idx1 ];								// 임시 변수에 값 저장
		arr[ idx1 ] = arr[ idx2 ];								// 저장된 값이 존재했던 위치에 다른 값 저장
		arr[ idx2 ] = temp;									// 다른 위치에 임시 변수에 저장된 값 저장
	}
	
	/**
	 * 						어레이를 이쁘게 출력하는 메서드
	 * @param arr		입력된 메서드 int[]
	 */
	public static void prettyPrint ( int[] arr ) {
		System.out.print("{ ");								// 앞 괄호
		for (int num : arr) {									// 순회하며
			System.out.print(num +  " ");				// 차례로 출력
		}
		System.out.println("}");								// 뒷 괄호
	}
	
	/**
	 * 						여러 어레이를 차례로 이쁘게 출력하는 메서드
	 * @param args	어레이들이 담긴 어레이 int[][]
	 */
	public static void prettyPrintAll ( int[] ... args) {
		for ( int[] arr : args ) {								// 어레이를 순회하며
			prettyPrint(arr);										// 이쁘게 출력
		}
	}
}