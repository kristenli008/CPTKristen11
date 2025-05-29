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
	
	public static String[][] randomsort(TextInputFile textfile, int intCol){
		Console con2 = new Console();
			String strArray[][];
			strArray = new String[intCol][2];
			con2.println("hi outside");
			
			String strRead = textfile.readLine();
			con2.println(strRead);
			
			// converting text file to string array + random doubles
			int intCount;
			while(textfile.eof() == false){
				con2.println("hi while");
				
				for(intCount = 0; intCount < intCol; intCount++){					
					strArray[intCount][0] = textfile.readLine();
					strArray[intCount][1] = Integer.toString((int)(Math.random() * 1000));
					
					con2.println("hi for");
					con2.println(strArray[intCount][0] + " - " + strArray[intCount][1]);
				}
			}
			
			
			// test printing
			//for(intCount = 0; intCount < intCol; intCount++){
			//	con2.println(strArray[intCount][0] + " - " + strArray[intCount][1]);
			// }
			
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
			
			// for(intCount = 0; intCount < intCol; intCount++){
			// 	con.println(strArray[intCount][0] + " - " + strArray[intCount][1]);
			// }
			
			textfile.close();
			return strArray;
	}
}
