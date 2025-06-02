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
				intScore = gameplay(strName, strArray, intCols, con);
				blnerror = true;
				
			}else if(strTheme.equalsIgnoreCase("board games")){
				while(boardgames.eof() == false){
					strRead = boardgames.readLine();
					intCols = intCols + 1;
				}
				strThemename = "board games";
				strArray = cpttools.randomsort(strThemename, intCols);
				intScore = gameplay(strName, strArray, intCols, con);
				blnerror = true;
				
			}else if(strTheme.equalsIgnoreCase("cartoons")){
				while(cartoons.eof() == false){
					strRead = cartoons.readLine();
					intCols = intCols + 1;
				}
				strThemename = "cartoons";
				strArray = cpttools.randomsort(strThemename, intCols);
				intScore = gameplay(strName, strArray, intCols, con);
				blnerror = true;
				
			}else if(strTheme.equalsIgnoreCase("digital art programs")){
				while(artprograms.eof() == false){
					strRead = artprograms.readLine();
					intCols = intCols + 1;
				}
				strThemename = "digital art programs";
				strArray = cpttools.randomsort(strThemename, intCols);
				intScore = gameplay(strName, strArray, intCols, con);
				blnerror = true;
				
			}else{
				con.println("Please enter a valid name.");
			}
		}
		
		// closing files
		con.clear();
		animes.close();
		boardgames.close();
		cartoons.close();
		artprograms.close();
	}
	
	public static int gameplay(String strName, String strArray[][], int intCols, Console con){
				
			// setting variables
			int intScore = 0;
			int intCount;
			int intCount2;
			// word variable
			String strWord;
			String strWordguess;
			int intWrongtries;
			String strLetter;
			int intGuesslettercount;
			int intLettercount;
			String strPlayagain;
			// word variable but with indiv letters
			String strWordarray[][];
			String strGuessarray[][];
			
			// boolean loops
			boolean blnPlayagain = true;
			boolean blnrun = false;
			boolean blnGuess = false;
			
			// loop to keep playing
			while(blnPlayagain == true){
				// loop to play until no more words
				for(intCount = 0; intCount < intCols; intCount++){
					if(blnPlayagain == true){
						// setting up word variable
						strWord = strArray[intCount][0];
						// con.println(strWord);
						
						// counting letter count in word
						intLettercount = strWord.length();
						// con.println(intLettercount);
											
						// transferring letters to array
						strWordarray = new String[intLettercount][2];
						for(intCount2 = 1; intCount2 <= intLettercount; intCount2++){
							// setting letter variable
							strLetter = strWord.substring(intCount2-1, intCount2);
							strWordarray[intCount2-1][0] = strLetter;
							// con.print(strWordarray[intCount2-1][0]);
						}
						
						// TESTING: correct answer
						con.println(strWord);
						blnGuess = false;
						
						// input guess
						while(blnGuess == false){
							con.println("What is your guess?");
							strWordguess = con.readLine();
							
							// transferring guess string to array
							// ALERT: not sure if necesssary
							intGuesslettercount = strWordguess.length();
							strGuessarray = new String[intLettercount][2];
							for(intCount2 = 1; intCount2 <= intGuesslettercount; intCount2++){
								strLetter = strWordguess.substring(intCount2-1, intCount2);
								strGuessarray[intCount2-1][0] = strLetter;
								// con.println(strGuessarray[intCount2-1][0]);
							}
							
							// checking if guess is correct
							if(strWordguess.equalsIgnoreCase(strWord)){
								con.println("That's correct!");
								blnGuess = true;
								intScore = intScore + 1;
							}else{
								con.println("That's wrong!");
							}
						}
																			
						// resetting boolean
						blnrun = false;
						
						// play again
						// WONT NEED BLNRUN WITH BUTTONS
						while(blnrun == false){
							con.println("Would you like to play the next word? y or n");
							strPlayagain = con.readLine();
								if(strPlayagain.equalsIgnoreCase("y")){
								blnPlayagain = true;
								blnrun = true;
							}else if(strPlayagain.equalsIgnoreCase("n")){
								blnPlayagain = false;
								blnrun = true;
								con.println("Your final score: "+intScore);
							}else{
								con.println("Please type in y or n.");
							}
						}
					}
				}
				
				blnPlayagain = false;
			}
			
			
			
		return intScore;
	}
}
