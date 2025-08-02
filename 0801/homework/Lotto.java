package ex0801.homework;

public class Lotto {
	private boolean[] isSelected = new boolean[ 46 ];
	private int[] selectedNum = new int[ 6  ];
	private int selectedCount = 0;
	
	public static void main(String[] args) {
		
	}
	
	public boolean isUnique ( int num)  {
		if ( isSelected[ num ] ) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public void select ( int num ) {
		isSelected[num] = true;
		selectedNum[ selectedCount ] = num;
	}
	
	public void LastInsertionsSort ( int lastInputIndex ) {
		for ( int i = lastInputIndex ; i > 0 ; i-- ) {
			if ( selectedNum[i] < selectedNum[ i - 1 ] ) {
				int temp = selectedNum[i];
				selectedNum[ i ] = selectedNum[ i - 1 ];
				selectedNum[ i - 1 ] = temp;
			}
			
			else {
				break;
			}
		}
	}
	
	public void 
	
}
