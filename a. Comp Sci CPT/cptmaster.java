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
		// 88, 73, 110 = darker purple, dark font color
		
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
		boolean blnvalid = false;
		
		// setting textinputfiles
		// TextInputFile animes = new TextInputFile("popular animes.txt");
		// TextInputFile boardgames = new TextInputFile("board games.txt");
		// TextInputFile cartoons = new TextInputFile("cartoons.txt");
		// TextInputFile artprograms = new TextInputFile("digital art programs.txt");
		TextInputFile mastertext = new TextInputFile("themes.txt");
		
		// setting name
		con.println("Please enter your name:");
		strName = con.readLine();
		
		// getting theme choice
		while(blnerror == false){
			con.clear();
			if(blnvalid == true){
				con.println("Please enter a valid theme name.");
			}
			
			con.println("Hello, "+strName+"!");
			con.println("Which theme would you like to play today?");
			con.println("Please type in the theme name.");
			
			// drawing buttons			
			con.fillRoundRect(50,100,200,50,40,40);
			con.setDrawColor(new Color(88, 73, 110));
			con.drawString("Popular Animes",65,105);
			con.setDrawColor(new Color(241,235,250)); 
			
			con.fillRoundRect(260,100,200,50,40,40);
			con.setDrawColor(new Color(88, 73, 110));
			con.drawString("Popular Animes",65,105);
			con.setDrawColor(new Color(241,235,250));
			
			con.fillRoundRect(470,100,200,50,40,40);
			con.setDrawColor(new Color(88, 73, 110));
			con.drawString("Popular Animes",65,105);
			con.setDrawColor(new Color(241,235,250));
			
			con.fillRoundRect(680,100,200,50,40,40);
			con.setDrawColor(new Color(88, 73, 110));
			con.drawString("Popular Animes",65,105);
			con.setDrawColor(new Color(241,235,250));
			
			
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
				blnvalid = true;
			}
		}
		
		// closing files
	}
	
	public static int gameplay(String strName, String strArray[][], int intCols, Console con){
				
			con.clear();
			
			// setting variables
			int intScore = 0;
			int intCount;
			int intCount2;
			int intTemp;
			String strLeaderboard;
			// word variable
			String strWord;
			String strWordguess;
			int intWrongtries = 0;
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
			boolean blnrun2 = true;
			boolean blnGuess = false;
			boolean blnletter = false;
			boolean blnrunout = false;
			boolean blnyn = false;
			
			// loop to keep playing
			while(blnPlayagain == true){
				// loop to play until no more words
				for(intCount = 0; intCount < intCols; intCount++){
					if(blnPlayagain == true){
						
						blnPlayagain = true;
						intWrongtries = 0;
						
						// setting up word variable
						strWord = strArray[intCount][0];
						// con.println(strWord);
						
						// counting letter count in word
						intLettercount = strWord.length();
						// con.println(intLettercount);
											
						// transferring letters to array
						strWordarray = new String[intLettercount][3];
						for(intCount2 = 0; intCount2 < intLettercount; intCount2++){
							// setting letter variable
							strLetter = strWord.substring(intCount2, intCount2+1);
							strWordarray[intCount2][0] = strLetter;
							// setting order of letters
							strWordarray[intCount2][2] = Integer.toString(intCount2+1);
							// con.print(strWordarray[intCount2][0]);
						}
						
						blnGuess = false;
						
						// setting display word to null
						strGuessarray = new String[intLettercount][3];
						// setting order of letters
						for(intCount2 = 0; intCount2 < intLettercount; intCount2++){
							strGuessarray[intCount2][2] = Integer.toString(intCount2);
						}
						strWordarray = cpttools.letterbubblesort(strWordarray, intLettercount);
						for(intCount2 = 0; intCount2 < intLettercount; intCount2++){
							strGuessarray[intCount2][0] = "_ ";
							// con.print(strGuessarray[intCount2][0]);
						}
						
						// input guess
						while(blnGuess == false){
							con.clear();
							
							// TESTING: correct answer
							con.println(strWord);
							
							for(intCount2 = 0; intCount2 < intLettercount; intCount2++){
								con.print(strGuessarray[intCount2][0]);
							}
							con.println("");
							if(intWrongtries > 0){
								con.println("That's incorrect!");
							}
							con.println("What is your guess?");
							strWordguess = con.readLine();
							
							// checking if guess is correct
							if(strWordguess.equalsIgnoreCase(strWord)){
								con.println("That's correct!");
								blnGuess = true;
								intScore = intScore + 1;
							}else{
								intWrongtries = intWrongtries + 1;
								// con.println("wrong tries: "+intWrongtries);

								strGuessarray[Integer.parseInt(strWordarray[intWrongtries][2])-1][0] = strWordarray[intWrongtries][0] + " ";
								con.println(strGuessarray[Integer.parseInt(strWordarray[intWrongtries][2])-1][0]);
								
								if(intWrongtries >= 7){
									blnGuess = true;
									blnrunout = true;
								}
								
							}
						}
												
						// resetting boolean
						blnrun = false;
						
						// play again
						// WONT NEED BLNRUN WITH BUTTONS
						while(blnrun == false){
							con.clear();
							
							if(blnyn == true){
								con.println("Please type y or n.");
							}
							
							if(blnrunout == true){
								con.println("You have run out of guesses!");
							}else if(blnrunout == false){
								con.println("You guessed the word!");
							}
							
							con.println("The correct answer was: "+strWord);
							con.println("Would you like to play the next word? y or n");
							strPlayagain = con.readLine();
								if(strPlayagain.equalsIgnoreCase("y")){
								blnPlayagain = true;
								blnrun = true;
							}else if(strPlayagain.equalsIgnoreCase("n")){
								blnPlayagain = false;
								blnrun = true;
								blnrun2 = true;
								blnyn = false;
								con.println("Your final score: "+intScore);
								while(blnrun2 == true){
									if(blnyn == true){
										con.println("Please type in y or n.");
									}
									con.println("Would you like to put your name on the leaderboard? y or n");
									strLeaderboard = con.readLine();
									if(strLeaderboard.equalsIgnoreCase("y")){
										blnrun2 = false;
										TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt",true);
										leaderboard.println(strName);
										leaderboard.println(intScore);
										leaderboard.close();
										
										con.println("Your name has been added to the leaderboard!");
										con.println(strName + " - " + intScore);
									}else if(strLeaderboard.equalsIgnoreCase("n")){
										blnrun2 = false;
									}else{
										blnyn = true;
									}
								}
							}else{
								blnyn = true;
							}
						}
					}
				}
				
				blnPlayagain = false;
			}
			
			
			
		return intScore;
	}
}
