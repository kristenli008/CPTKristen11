import arc.*;

public class letterbubblesorttest{
	public static void main(String[] args){
		Console con = new Console();
		
		con.println("test");
		
		String strArray[][];
		String strReturnArray[][];
		int intCols = 5;
		int intCount;
		
		strArray = new String[5][2];
		strReturnArray = new String[5][2];
		for(intCount = 0; intCount < 5; intCount++){
			strArray[intCount][0] = Integer.toString(intCount);
			strArray[intCount][1] = Integer.toString(0);
		}
		
		strReturnArray = cpttools.letterbubblesort(strArray, intCols, con);
	}
}
