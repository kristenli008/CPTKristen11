import arc.*;

public class gameplaytest1{
	public static void main(String[] args){
		Console con = new Console();
		
		String strName = "madoka";
		String strArray[][];
		strArray = new String[19][2];
		int intCols = 19;

		TextInputFile textfile = new TextInputFile("popular animes.txt");
		
		int intCount;
		while(textfile.eof() == false){
			
			for(intCount = 0; intCount < intCols; intCount++){					
				strArray[intCount][0] = textfile.readLine();
				strArray[intCount][1] = Integer.toString((int)(Math.random() * 100000));
			}
		}
		
		// these textfiles are not randomized and bubble sorted; they will be if using cpttools
		
		int intScore = cptmaster.gameplay(strName, strArray, intCols);
		
		con.println(intScore);
		
	}
}
