import arc.*;
import java.awt.Color;

public class cptmaster{
	public static void main(String[] args){
		Console con = new Console();
		con.setBackgroundColor(new Color(150,122,158));
		
		// setting variables
		String strName;
		String strTheme;
		String strThemename;
		int intScore;
		boolean blnerror = false;
		
		// setting textinputfiles
		TextInputFile animes = new TextInputFile("popular animes.txt");
		TextInputFile boardgames = new TextInputFile("board games.txt");
		TextInputFile cartoons = new TextInputFile("cartoons.txt");
		TextInputFile artprograms = new TextInputFile("digital art programs.txt");
		
		// setting name
		con.println("Please enter your name:");
		strName = con.readLine();
		
		// getting theme choice
		while(blnerror == false){
			con.println("Which theme would you like to play today?");
			con.println("Please type in the theme name.");
			con.println("Popular Animes || Board Games || Cartoons || Digital Art Programs");
			strTheme = con.readLine();
			String strArray[][];
			String strRead;
			int intCols = 0;
			
			// running theme gameplay
			if(strTheme.equalsIgnoreCase("popular animes")){
				while(animes.eof() == false){
					strRead = animes.readLine();
					intCols = intCols + 1;
				}
				strThemename = "popular animes";
				strArray = cpttools.randomsort(strThemename, intCols);
				intScore = gameplay(strName, strArray, intCols);
				blnerror = true;
				
			}else if(strTheme.equalsIgnoreCase("board games")){
				while(boardgames.eof() == false){
					strRead = boardgames.readLine();
					intCols = intCols + 1;
				}
				strThemename = "board games";
				strArray = cpttools.randomsort(strThemename, intCols);
				intScore = gameplay(strName, strArray, intCols);
				blnerror = true;
				
			}else if(strTheme.equalsIgnoreCase("cartoons")){
				while(cartoons.eof() == false){
					strRead = cartoons.readLine();
					intCols = intCols + 1;
				}
				strThemename = "cartoons";
				strArray = cpttools.randomsort(strThemename, intCols);
				intScore = gameplay(strName, strArray, intCols);
				blnerror = true;
				
			}else if(strTheme.equalsIgnoreCase("digital art programs")){
				while(artprograms.eof() == false){
					strRead = artprograms.readLine();
					intCols = intCols + 1;
				}
				strThemename = "digital art programs";
				strArray = cpttools.randomsort(strThemename, intCols);
				intScore = gameplay(strName, strArray, intCols);
				blnerror = true;
				
			}else{
				con.println("Please enter a valid name.");
			}
		}
		
		animes.close();
		boardgames.close();
		cartoons.close();
		artprograms.close();
	}
	
	public static int gameplay(String strName, String strArray[][], int intCols){
		Console con = new Console();
		
			// setting variables
			int intScore = 0;
			int intCount;
			int intCount2;
			String strWord;
			int intWrongtries;
			String strLetter;
			int intLettercount;
			String strWordarray[][];
			
			boolean blnPlayagain = true;
			
			// loop to keep playing
			while(blnPlayagain == true){
				// loop to play until no more words
				for(intCount = 0; intCount < intCols; intCount++){
					
					// setting up word variable
					strWord = strArray[intCount][0];
					
					// counting letter count in word
					intLettercount = strWord.length();
					con.println(strWord + " - " + intLettercount);
					
					// transferring letters to array
					strWordarray = new String[intLettercount][2];
					for(intCount2 = 1; intCount2 <= intLettercount; intCount++){
						
					}
					
				}
				
				blnPlayagain = false;
			}
			
			
			
		return intScore;
	}
}
