import arc.*;

public class cpttools{
	public static void main(String[] args){
	
	}
	
	public static int textcount(TextInputFile textfile){
			
		String strLine;
		int intcount = 0;
	
		while(textfile.eof() == false){
			strLine = textfile.readLine();
			intcount = intcount + 1;
		}
				
		return intcount;
	}
	
	public static String[][] randomsort(TextInputFile textfile, int intCol, int intRow){
		String strArray[][];
		strArray = new String[intRow][intCol];
		
		int intCount;
		while(textfile.eof() == false){
			for(intCount = 0; intCount <= int
		}
		
		textfile.close();
		
		return strArray;
	}
}
