import arc.*;
import java.awt.Color;

public class cptmaster{
	public static void main(String[] args){
		Console con = new Console("Hangman",940,700);
		con.setBackgroundColor(new Color(150,122,158));
		con.setTextColor(new Color(241,235,250));
		con.setDrawColor(new Color(241,235,250));

		// color legend
		// 150,122,158 = middle gray purple, bg
		// 241,235,250 = extremely light purple, white font color
		// 97, 66, 143 = darker purple, dark font color
		
		// logo
		// con.println("insert logo");
		//con.sleep(500);
		//con.clear();
		// con.sleep(500);
		
		// setting variables
		String strName = "name";
		String strTheme;
		String strThemename;
		int intScore;
		boolean blnerror = false;
		
		// setting textinputfiles
		// TextInputFile animes = new TextInputFile("popular animes.txt");
		// TextInputFile boardgames = new TextInputFile("board games.txt");
		// TextInputFile cartoons = new TextInputFile("cartoons.txt");
		// TextInputFile artprograms = new TextInputFile("digital art programs.txt");
		TextInputFile mastertext = new TextInputFile("themes.txt");
		
		// setting name
		//con.println("Please enter your name:");
		//strName = con.readLine();
		
		// con.println("Hello, "+strName+"!");

		// getting theme choice
		while(blnerror == false){
			con.println("Which theme would you like to play today?");
			con.println("Please type in the theme name.");
			
			// drawing buttons			
			con.fillRoundRect(50,100,200,50,40,40);
			con.setDrawColor(new Color(97, 66, 143));
			con.drawString("Popular Animes",65,105);
			con.setDrawColor(new Color(241,235,250));
			
			con.fillRoundRect(260,100,200,50,40,40);
			
			con.fillRoundRect(470,100,200,50,40,40);
			
			con.fillRoundRect(680,100,200,50,40,40);
			
			con.println("Popular Animes || Board Games || Cartoons || Digital Art Programs");
			strTheme = con.readLine();
			String strArray[][];
			String strRead;
			int intCols = 0;
			
			// running theme gameplay
			if(strTheme.equalsIgnoreCase("popular animes")){
				strThemename = mastertext.readLine();
				TextInputFile animes = new TextInputFile(strThemename+".txt");
				while(animes.eof() == false){
					strRead = animes.readLine();
					intCols = intCols + 1;
				}
				strArray = cpttools.randomsort(strTheme, intCols);
				intScore = gameplay(strName, strArray, intCols, con);
				blnerror = true;
				
				animes.close();
			}else if(strTheme.equalsIgnoreCase("board games")){
				strThemename = mastertext.readLine();
				strThemename = mastertext.readLine();
				TextInputFile boardgames = new TextInputFile(strThemename+".txt");
				while(boardgames.eof() == false){
					strRead = boardgames.readLine();
					intCols = intCols + 1;
				}
				strThemename = "board games";
				strArray = cpttools.randomsort(strThemename, intCols);
				intScore = gameplay(strName, strArray, intCols, con);
				blnerror = true;
				
				boardgames.close();
			}else if(strTheme.equalsIgnoreCase("cartoons")){
				strThemename = mastertext.readLine();
				strThemename = mastertext.readLine();
				strThemename = mastertext.readLine();
				TextInputFile cartoons = new TextInputFile(strThemename+".txt");
				while(cartoons.eof() == false){
					strRead = cartoons.readLine();
					intCols = intCols + 1;
				}
				strThemename = "cartoons";
				strArray = cpttools.randomsort(strThemename, intCols);
				intScore = gameplay(strName, strArray, intCols, con);
				blnerror = true;
				
				cartoons.close();
			}else if(strTheme.equalsIgnoreCase("digital art programs")){
				strThemename = mastertext.readLine();
				strThemename = mastertext.readLine();
				strThemename = mastertext.readLine();
				strThemename = mastertext.readLine();
				TextInputFile artprograms = new TextInputFile(strThemename+".txt");
				while(artprograms.eof() == false){
					strRead = artprograms.readLine();
					intCols = intCols + 1;
				}
				strThemename = "digital art programs";
				strArray = cpttools.randomsort(strThemename, intCols);
				intScore = gameplay(strName, strArray, intCols, con);
				blnerror = true;
				
				artprograms.close();
			}else{
				con.println("Please enter a valid name.");
			}
		}
		
		// closing files
		con.clear();
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
