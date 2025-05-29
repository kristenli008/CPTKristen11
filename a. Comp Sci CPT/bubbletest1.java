import arc.*;

public class bubbletest1{
	public static void main(String[] args){
		Console con = new Console();
		
		TextInputFile animes = new TextInputFile("popular animes.txt");
		
		String strFileName = "popular animes";
		
		String strArray[][];
		String strRead;
		int intCols = 0;
		int intCount;
				
		while(animes.eof() == false){
			strRead = animes.readLine();
			con.println(strRead);
			intCols = intCols + 1;
		}
		
		con.println(intCols);
				
		strArray = new String[intCols][1];
		strArray = cpttools.randomsort(animes,intCols);
		
		for(intCount = 0; intCount < intCols; intCount++){
			con.println(strArray[intCount][0] + " - " + strArray[intCount][1]);
		}
	}
}
