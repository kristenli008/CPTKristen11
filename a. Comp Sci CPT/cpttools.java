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
		
	public static String[][] randomsort(String strFileName, int intCol){
			String strArray[][];
			strArray = new String[intCol][2];
			
			TextInputFile textfile = new TextInputFile(strFileName + ".txt");
			
			// converting text file to string array + random doubles
			int intCount;
			while(textfile.eof() == false){
				
				for(intCount = 0; intCount < intCol; intCount++){					
					strArray[intCount][0] = textfile.readLine();
					strArray[intCount][1] = Integer.toString((int)(Math.random() * 100000));
					
				}
			}
			
			
			int intCount2;
			String strTemp;
			
			// bubble sorting
			for(intCount2 = 0; intCount2 < intCol-1; intCount2++){
				for(intCount = 0; intCount < intCol-1; intCount++){
					if(Integer.parseInt(strArray[intCount][1]) > Integer.parseInt(strArray[intCount + 1][1])){
						strTemp = strArray[intCount][0];
						strArray[intCount][0] = strArray[intCount+1][0];
						strArray[intCount+1][0] = strTemp;
						
						strTemp = strArray[intCount][1];
						strArray[intCount][1] = strArray[intCount+1][1];
						strArray[intCount+1][1] = strTemp;
					}
				}
			}
			
			textfile.close();
			return strArray;
	}
	
	public static String[][] letterbubblesort(String strArray[][], int intCol){
		// Console con = new Console();
		int intCount;
		int intCount2;
		double dblRandom;
		String strTemp;
				
		for(intCount = 0; intCount < intCol; intCount++){
			strArray[intCount][1] = Integer.toString((int)(Math.random() * 100000));
		}
		
		for(intCount2 = 0; intCount2 < intCol-1; intCount2++){
			for(intCount = 0; intCount < intCol-1; intCount++){
				if(Integer.parseInt(strArray[intCount][1]) > Integer.parseInt(strArray[intCount + 1][1])){
					strTemp = strArray[intCount][0];
					strArray[intCount][0] = strArray[intCount+1][0];
					strArray[intCount+1][0] = strTemp;
					
					strTemp = strArray[intCount][1];
					strArray[intCount][1] = strArray[intCount+1][1];
					strArray[intCount+1][1] = strTemp;
					
					strTemp = strArray[intCount][2];
					strArray[intCount][2] = strArray[intCount+1][2];
					strArray[intCount+1][2] = strTemp;
				}
			}
		}
		
		
		
		for(intCount = 0; intCount < intCol; intCount++){
			strArray[intCount][1] = Integer.toString(intCount);
		}
		
		return strArray;
	}
}
