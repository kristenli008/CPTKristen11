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
			
			// drawing buttons			
			con.fillRoundRect(50,100,200,50,40,40);
			con.setDrawColor(new Color(88, 73, 110));
			con.drawString("Popular Animes",65,107);
			con.setDrawColor(new Color(241,235,250)); 
			
			con.fillRoundRect(260,100,200,50,40,40);
			con.setDrawColor(new Color(88, 73, 110));
			con.drawString("Board Games",297,107);
			con.setDrawColor(new Color(241,235,250));
			
			con.fillRoundRect(470,100,200,50,40,40);
			con.setDrawColor(new Color(88, 73, 110));
			con.drawString("Cartoons",520,107);
			con.setDrawColor(new Color(241,235,250));
			
			con.fillRoundRect(680,100,200,50,40,40);
			con.setDrawColor(new Color(88, 73, 110));
			con.drawString("Art Programs",710,107);
			con.setDrawColor(new Color(241,235,250));
			
			// button interaction
			
			int num = 1;
			
			while(num == 1){
				int intCursorx;
				int intCursory;
				int intMousebutton;
				
				intCursorx = con.currentMouseX();
				intCursory = con.currentMouseY();
				intMousebutton = con.currentMouseButton();
				System.out.println("x: "+intCursorx);
				System.out.println("y: "+intCursory);
				System.out.println("button: "+intMousebutton);
			
			
			
				// con.println("Popular Animes || Board Games || Cartoons || Art Programs");
				// strTheme = con.readLine();
				String strArray[][];
				String strRead;
				int intCols = 0;
				
				// running theme gameplay
				// if(strTheme.equalsIgnoreCase("popular animes")){
				if(50 < intCursorx && intCursorx < 250 && 100 < intCursory && intCursory < 150 && intMousebutton == 1){
					strTheme = "popular animes";
					strThemename = mastertext.readLine();
					TextInputFile animes = new TextInputFile(strThemename+".txt");
					while(animes.eof() == false){
						strRead = animes.readLine();
						intCols = intCols + 1;
					}
					strArray = cpttools.randomsort(strTheme, intCols);
					con.setBackgroundColor(new Color(150,122,158));
					intScore = gameplay(strName, strArray, intCols, con);
					blnerror = true;
					
					animes.close();
				// }else if(strTheme.equalsIgnoreCase("board games")){
				}else if(260 < intCursorx && intCursorx < 460 && 100 < intCursory && intCursory < 150 && intMousebutton == 1){
					strThemename = mastertext.readLine();
					strThemename = mastertext.readLine();
					TextInputFile boardgames = new TextInputFile(strThemename+".txt");
					while(boardgames.eof() == false){
						strRead = boardgames.readLine();
						intCols = intCols + 1;
					}
					strThemename = "board games";
					strArray = cpttools.randomsort(strThemename, intCols);
					con.setBackgroundColor(new Color(150,122,158));
					intScore = gameplay(strName, strArray, intCols, con);
					blnerror = true;
					
					boardgames.close();
				// }else if(strTheme.equalsIgnoreCase("cartoons")){
				}else if(470 < intCursorx && intCursorx < 670 && 100 < intCursory && intCursory < 150 && intMousebutton == 1){
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
					con.setBackgroundColor(new Color(150,122,158));
					intScore = gameplay(strName, strArray, intCols, con);
					blnerror = true;
					
					cartoons.close();
				// }else if(strTheme.equalsIgnoreCase("digital art programs")){
				}else if(680 < intCursorx && intCursorx < 880 && 100 < intCursory && intCursory < 150 && intMousebutton == 1){
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
					con.setBackgroundColor(new Color(150,122,158));
					intScore = gameplay(strName, strArray, intCols, con);
					blnerror = true;
					
					artprograms.close();
				}else{
					blnvalid = true;
				}
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
						
			// loop to track mouse
			int intmousex = 0;
			int intmousey = 0;
			int intmousebut = 0;
			int intnum = 1;
				
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
								
								// drawing hangman
								con.setDrawColor(new Color(241,235,250));
								// hanging pole
								con.drawLine(800,90,800,70);
								con.drawLine(800,70,710,70);
								con.drawLine(710,70,710,350);
								con.drawLine(660,350,880,350);
								
								// stickman ----
								if(intWrongtries == 1){
									// head
									con.drawOval(770,90,60,60);
								}else if(intWrongtries == 2){
									// body
									con.drawLine(800,150,800,250);
								}else if(intWrongtries == 3){
									// left leg
									con.drawLine(800,250,750,320);
								}else if(intWrongtries == 4){
									// right leg
									con.drawLine(800,250,850,320);
								}else if(intWrongtries == 5){
									// left arm
									con.drawLine(800,160,750,200);
								}else if(intWrongtries == 6){
									// right arm
									con.drawLine(800,160,850,200);
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
								
								if(blnrunout == true){
									con.println("You have run out of guesses!");
									// dead face
									con.drawLine(782,110,790,118);
									con.drawLine(790,110,782,118);
									con.drawLine(818,110,810,118);
									con.drawLine(810,110,818,118);
									con.drawLine(787,132,813,132);
								}else if(blnrunout == false){
									con.println("You guessed the word!");
									// happy face
									con.fillOval(780,107,5,5);
									con.fillOval(815,107,5,5);
									con.fillArc(779,109,43,28,180,180);
								}
								
								con.println("The correct answer was: "+strWord);
								con.println("Would you like to play the next word?");
								
								// buttons
								con.setDrawColor(new Color(241,235,250));
								con.fillRoundRect(50,90,100,50,40,40);
								con.setDrawColor(new Color(88, 73, 110));
								con.drawString("Yes",73,100);
								con.setDrawColor(new Color(241,235,250)); 
								
								con.fillRoundRect(260,90,100,50,40,40);
								con.setDrawColor(new Color(88, 73, 110));
								con.drawString("No",283,100);
								con.setDrawColor(new Color(241,235,250));
								
								// strPlayagain = con.readLine();
								intnum = 1;
								while(intnum == 1){
										intmousex = con.currentMouseX();
										intmousey = con.currentMouseY();
										intmousebut = con.currentMouseButton();
										
										System.out.println("x: "+intmousex);
										System.out.println("y: "+intmousey);
										System.out.println("button: "+intmousebut);
									
									if(intmousex > 50 && intmousex < 150 && intmousey < 140 && intmousey > 90 && intmousebut == 1){
										blnPlayagain = true;
										blnrun = true;
										con.setBackgroundColor(new Color(150,122,158));
										System.out.println("clicked yes");
										intnum = 0;
										System.out.println("intnum: "+intnum);
									}else if(intmousex > 260 && intmousex < 360 && intmousey < 140 && intmousey > 90 && intmousebut == 1){
										blnPlayagain = false;
										blnrun = true;
										blnrun2 = true;
										intnum = 1;
										
										con.clear();
										
										con.println("Your final score: "+intScore);
										while(blnrun2 == true){
											con.println("Would you like to put your name on the leaderboard? y or n");
											if(intmousex > 50 && intmousex < 150 && intmousey < 140 && intmousey > 90 && intmousebut == 1){
												System.out.println("clicked yes leaderboard");
												blnrun2 = false;
												TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt",true);
												leaderboard.println(strName);
												leaderboard.println(intScore);
												leaderboard.close();
												
												con.println("Your name has been added to the leaderboard!");
												con.println(strName + " - " + intScore);
											}else if(intmousex > 260 && intmousex < 360 && intmousey < 140 && intmousey > 90 && intmousebut == 1){
												blnrun2 = false;
											}
										}
									}
								}
							}
						}
					}
					
					blnPlayagain = false;
				}
			
			
			
		return intScore;
	}

	public static Console leaderboard(Console con){
		// clearing
		con.clear();
		con.setBackgroundColor(new Color(150,122,158));
		
		// variables (sorting);
		TextInputFile leaderbd = new TextInputFile("leaderboard.txt");
		String strArray[][];
		String strName;
		String strLine;
		int intScore;
		int intCount;
		int intCount2;
		int intRows = 0;
		String strTemp;
		
		// setting array
		while(leaderbd.eof() == false){
			strLine = leaderbd.readLine();
			intRows++;
		}
		
		// System.out.println(intRows);
		strArray = new String[intRows][2];
		
		// resetting file
		leaderbd.close();
		TextInputFile leaderbd2 = new TextInputFile("leaderboard.txt");
		
		// transferring text file to array
		for(intCount = 1; intCount <= intRows/2; intCount++){
			strArray[intCount-1][0] = leaderbd2.readLine();
			strArray[intCount-1][1] = leaderbd2.readLine();
			System.out.println(strArray[intCount-1][0]+" - "+strArray[intCount-1][1]);
		}
		
		leaderbd2.close();
		
		// bubble sorting array
		for(intCount = 0; intCount < (intRows/2)-1; intCount++){
			for(intCount2 = 0; intCount2 < (intRows/2)-1; intCount2++){
				System.out.println("Current count: "+intCount2);
				System.out.println(strArray[intCount2][1]);
				System.out.println(strArray[intCount2+1][1]);
				if(Integer.parseInt(strArray[intCount2][1]) < Integer.parseInt(strArray[intCount2+1][1])){
					strTemp = strArray[intCount2+1][0];
					strArray[intCount2+1][0] = strArray[intCount2][0];
					strArray[intCount2][0] = strTemp;
					
					strTemp = strArray[intCount2+1][1];
					strArray[intCount2+1][1] = strArray[intCount2][1];
					strArray[intCount2][1] = strTemp;
				}
			}
		}
		
		// printing array back to leaderboard text file
		TextOutputFile leaderbdout = new TextOutputFile("leaderboard.txt");
		
		for(intCount = 0; intCount < intRows/2; intCount++){
			System.out.println(strArray[intCount][0]+" - "+strArray[intCount][1]);
			leaderbdout.println(strArray[intCount][0]);
			leaderbdout.println(strArray[intCount][1]);
		}
		
		leaderbdout.close();
		
		// variables (printing)
		int intScore2;
		int intRank = 0;
		TextInputFile leaderbd3 = new TextInputFile("leaderboard.txt");
		
		con.println("");
		con.println("");
		con.println("Current leaderboard:");
		while(leaderbd3.eof() == false){
			intRank = intRank + 1;
			strLine = leaderbd3.readLine();
			con.println("#"+intRank+": "+strLine);
			intScore2 = Integer.parseInt(leaderbd3.readLine());
			con.println("Score: "+intScore2);
		}
		
		// return buttons
		// variables
		int intMousex;
		int intMousey;
		int intMousebut;
		
		// buttons
		
		
		return con;
	}
}
