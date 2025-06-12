import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Image;

public class cptmaster{
	public static void main(String[] args){
		
				
		Console con = new Console("Hangman",940,700);
		con.setBackgroundColor(new Color(150,122,158));
		con.setTextColor(new Color(241,235,250));
		con.setDrawColor(new Color(241,235,250));
		
		BufferedImage studiologo = con.loadImage("Studio Logo.png");
		BufferedImage gamelogo = con.loadImage("Hangman Logo.png");

		// color legend
		// 150,122,158 = middle gray purple, bg
		// 241,235,250 = extremely light purple, white font color
		// 88, 73, 110 = darker purple, dark font color
		
		
		con.setTextColor(new Color(150,122,158));
		
		// studio logo
		con.sleep(200);
		con.drawImage(studiologo, 5,10);
		con.println("hello");
		con.sleep(2000);
		con.setBackgroundColor(new Color(150,122,158));
		con.sleep(500);
		
		// game logo
		con.clear();
		con.drawImage(gamelogo, 5,10);
		con.repaint();
		con.sleep(2000);
		con.setBackgroundColor(new Color(150,122,158));
		con.sleep(500);
		
		con.clear();
		con.setTextColor(new Color(241,235,250));
		
		
		
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
		
		// setting menu loop
		int intmenuloop = 1;
		
		// getting theme choice
		while(intmenuloop == 1){
			blnerror = false;
			con.setBackgroundColor(new Color(150,122,158));
			con.clear();
			while(blnerror == false){
				con.clear();
				
				con.println("Hello, "+strName+"!");
				con.println("Which theme would you like to play today?");
				
				// drawing buttons
				// themes			
				con.setDrawColor(new Color(241,235,250)); 
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
				
				// other buttons
				// custom themes
				con.fillRoundRect(50,160,200,50,40,40);
				con.setDrawColor(new Color(88, 73, 110));
				con.drawString("Custom Themes",70,167);
				con.setDrawColor(new Color(241,235,250));
				
				// add custom theme
				con.fillRoundRect(260,160,230,50,40,40);
				con.setDrawColor(new Color(88, 73, 110));
				con.drawString("Add Custom Theme",280,167);
				con.setDrawColor(new Color(241,235,250));
				
				// leaderboard
				con.fillRoundRect(50,240,170,50,40,40);
				con.setDrawColor(new Color(88, 73, 110));
				con.drawString("Leaderboard",70,247);
				con.setDrawColor(new Color(241,235,250));
				
				//quit
				con.fillRoundRect(240,240,70,50,40,40);
				con.setDrawColor(new Color(88, 73, 110));
				con.drawString("Quit",250,247);
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
				
					String strArray[][];
					String strRead;
					int intCols = 0;
					
					// running theme gameplay
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
						
						num = 0;
						blnerror = true;
						
						con.println("Returning to main menu...");
						con.sleep(2000);
						
						animes.close();
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
						
						num = 0;
						blnerror = true;
						
						con.println("Returning to main menu...");
						con.sleep(2000);
						
						boardgames.close();
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
						
						num = 0;
						blnerror = true;
						
						con.println("Returning to main menu...");
						con.sleep(2000);
						
						cartoons.close();
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
						
						num = 0;
						blnerror = true;
						
						con.println("Returning to main menu...");
						con.sleep(2000);
						
						artprograms.close();
					}else if(intCursorx > 50 && intCursorx < 250 && intCursory > 160 && intCursory < 210 && intMousebutton == 1){
						
						// custom themes
						con.clear();
						con.setBackgroundColor(new Color(150,122,158));
						
						TextInputFile customthemes = new TextInputFile("custom themes.txt");
						String strCustomarray[][];
						int intnumcustom = 0;
						int intCount3;
						int intLettercount;
						boolean blncustom = false;
						
						// counting number of custom themes
						while(customthemes.eof() == false){
							strRead = customthemes.readLine();
							intnumcustom++;
							System.out.println("number of themes: "+intnumcustom);
						}
						
						System.out.println("finished counting");
						
						customthemes.close();
						TextInputFile customthemes2 = new TextInputFile("custom themes.txt");
						
						// transferring theme names to array
						strCustomarray = new String[intnumcustom][1];
						for(intCount3 = 0; intCount3 < intnumcustom; intCount3++){
							strRead = customthemes2.readLine();
							strCustomarray[intCount3][0] = strRead;
							System.out.println("intcount3: "+intCount3);
						}
						
						System.out.println("finished transferring");
						
						customthemes2.close();
						
						boolean blnyn = true;
						blncustom = false;
						
						while(blncustom == false){
							System.out.println("in loop");
							con.clear();
							if(blnyn = false){
								con.println("This custom theme does not exist.");
							}
							con.println("These are the custom themes available:");
							for(intCount3 = 0; intCount3 < intnumcustom; intCount3++){
								con.println(strCustomarray[intCount3][0]);
							}
							con.println("Please type in the custom theme name you would like to play,");
							con.println("or type 'return' to go back to the main menu.");
							strRead = con.readLine();
													
							for(intCount3 = 0; intCount3 < intnumcustom; intCount3++){
								if(strRead.equalsIgnoreCase(strCustomarray[intCount3][0])){
									blncustom = true;
									TextInputFile customtheme = new TextInputFile(strCustomarray[intCount3][0]+".txt");
										while(customtheme.eof() == false){
											strRead = customtheme.readLine();
											intCols = intCols + 1;
										}
										strThemename = strCustomarray[intCount3][0];
										strArray = cpttools.randomsort(strThemename, intCols);
										con.setBackgroundColor(new Color(150,122,158));
										intScore = gameplay(strName, strArray, intCols, con);
										
										num = 0;
										blnerror = true;
										
										customtheme.close();
								}else if(strRead.equalsIgnoreCase("return")){
									num = 0;
									blnerror = true;
								}else{
									blncustom = false;
									blnyn = false;
								}
							}
						}
						/*
						
						// drawing buttons
						String strLengtharray[][] = new String[intnumcustom][1];
						con.setDrawColor(new Color(241,235,250)); 
						for(intCount3 = 0; intCount3 < intnumcustom; intCount3++){
							intLettercount = strCustomarray[intCount3][0].length();
							strLengtharray[intCount3][0] = Integer.toString(intLettercount);
							
							con.fillRoundRect(50,300+intCount3*60,30+13*intLettercount,50,40,40);
							con.setDrawColor(new Color(88, 73, 110));
							con.drawString(strCustomarray[intCount3][0],65,307+intCount3*60);
							con.setDrawColor(new Color(241,235,250)); 
						}
						
						// drawing back button
						con.fillRoundRect(50,50,120,50,40,40);
						con.setDrawColor(new Color(88, 73, 110));
						con.drawString("Back",60,57);
						con.setDrawColor(new Color(241,235,250)); 
						
						// button interaction
						
							for(intCount3 = 0; intCount3 < intnumcustom; intCount3++){
								if(intCursorx > 50 && intCursorx < 30+50+13*Integer.parseInt(strLengtharray[intCount3][0]) && intCursory > 300+intCount3*60 && intCursory < 300+50+intCount3*60 && intMousebutton == 1){
									TextInputFile customtheme = new TextInputFile(strCustomarray[intCount3][0]+".txt");
									
									while(customtheme.eof() == false){
										strRead = customtheme.readLine();
										intCols = intCols + 1;
									}
									strThemename = strCustomarray[intCount3][0];
									strArray = cpttools.randomsort(strThemename, intCols);
									con.setBackgroundColor(new Color(150,122,158));
									intScore = gameplay(strName, strArray, intCols, con);
									
									num = 0;
									blnerror = true;
									
									customtheme.close();
								}else if(intCursorx > 50 && intCursorx < 170 && intCursory > 50 && intCursory < 50 && intMousebutton == 1){
									num = 0;
									blnerror = true;
									
									con.println("Returning to main menu...");
									con.sleep(2000);
								}
							}
							* 
							*/
						
					}else if(intCursorx > 260 && intCursorx < 490 && intCursory > 160 && intCursory < 210 && intMousebutton == 1){
						// add custom theme
						
						con.setBackgroundColor(new Color(150,122,158));
						con.clear();
						
						String strCustomname;
						int strclength = 0;
						boolean blnadd = true;
						boolean blnyn = false;
						boolean blnlength = false;
						
						con.println("What will be your theme's name?");
						strCustomname = con.readLine();
						
						TextOutputFile newtheme = new TextOutputFile(strCustomname+".txt");
						while(blnadd == true){
							while(blnlength == false){
								con.clear();
								if(strclength < 7 && strclength != 0){
									con.println("Your word has less than 7 letters.");
								}
								con.println("Please type a word related to your chosen theme.");
								con.println("Minimum: 7 letters");
								strRead = con.readLine();
								strclength = strRead.length();
								if(strclength < 7){
									blnlength = false;
								}else{
									newtheme.println(strRead);
									blnlength = true;
								}
							}
							if(blnlength == true){
								con.println("Would you like to keep adding words?");
								blnyn = false;
								while(blnyn == false){
									con.println("Please type 'y' for yes and 'n' for no.");
									strRead = con.readLine();
									if(strRead.equalsIgnoreCase("y")){
										blnadd = true;
										blnyn = true;
										blnlength = false;
									}else if(strRead.equalsIgnoreCase("n")){
										blnadd = false;
										blnyn = true;
										
										con.println("Returning to main menu...");
										con.sleep(2000);
									}else{
										blnyn = false;
									}
								}
							}
						}
						
						num = 0;
						blnerror = true;
						
					}else if(intCursorx > 50 && intCursorx < 220 && intCursory > 240 && intCursory < 290 && intMousebutton == 1){
						// leaderboard
						leaderboard(con);
						num = 0;
						blnerror = true;
						con.println("Returning to main menu...");
						con.sleep(2000);
					}else if(intCursorx > 240 && intCursorx < 310 && intCursory > 240 && intCursory < 290 && intMousebutton == 1){
						// quit
						con.closeConsole();
					}
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
							
							// counting letter count in word
							intLettercount = strWord.length();
												
							// transferring letters to array
							strWordarray = new String[intLettercount][3];
							for(intCount2 = 0; intCount2 < intLettercount; intCount2++){
								strLetter = strWord.substring(intCount2, intCount2+1);
								strWordarray[intCount2][0] = strLetter;
								strWordarray[intCount2][2] = Integer.toString(intCount2+1);
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
									blnrunout = false;
									intScore = intScore + 1;
								}else{
									intWrongtries = intWrongtries + 1;

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
									
									if(intmousex > 50 && intmousex < 150 && intmousey < 140 && intmousey > 90 && intmousebut == 1){
										blnPlayagain = true;
										blnrun = true;
										con.setBackgroundColor(new Color(150,122,158));
										intnum = 0;
										
									}else if(intmousex > 260 && intmousex < 360 && intmousey < 140 && intmousey > 90 && intmousebut == 1){
										blnPlayagain = false;
										blnrun = true;
										blnrun2 = true;
										intnum = 1;
										
										con.println("");
										con.setBackgroundColor(new Color(150,122,158));

										con.println("Your final score: "+intScore);
										String strRead;
										while(blnrun2 == true){
											if(intnum == 0){
												con.println("Please type y or n.");
											}
											con.println("Would you like to put your name on the leaderboard? y or n");
											strRead = con.readLine();
											if(strRead.equalsIgnoreCase("y")){
												blnrun2 = false;
												TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt",true);
												leaderboard.println(strName);
												leaderboard.println(intScore);
												leaderboard.close();
												
												con.println("Your name has been added to the leaderboard!");
												con.println(strName + " - " + intScore);
												
												return intScore;
											}else if(strRead.equalsIgnoreCase("n")){
												blnrun2 = false;
												return intScore;
											}else{
												intnum = 0;
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
		
		strArray = new String[intRows][2];
		
		// resetting file
		leaderbd.close();
		TextInputFile leaderbd2 = new TextInputFile("leaderboard.txt");
		
		// transferring text file to array
		for(intCount = 1; intCount <= intRows/2; intCount++){
			strArray[intCount-1][0] = leaderbd2.readLine();
			strArray[intCount-1][1] = leaderbd2.readLine();
		}
		
		leaderbd2.close();
		
		// bubble sorting array
		for(intCount = 0; intCount < (intRows/2)-1; intCount++){
			for(intCount2 = 0; intCount2 < (intRows/2)-1; intCount2++){
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
		con.println("");
		con.println("  Current leaderboard:");
		while(leaderbd3.eof() == false){
			intRank = intRank + 1;
			strLine = leaderbd3.readLine();
			con.println("  #"+intRank+": "+strLine);
			intScore2 = Integer.parseInt(leaderbd3.readLine());
			con.println("  Score: "+intScore2);
		}
		
		// return buttons
		// variables
		int intMousex;
		int intMousey;
		int intMousebut;
		int intnum = 1;
		
		// buttons
		con.setDrawColor(new Color(241,235,250));
		con.fillRoundRect(10,10,250,50,40,40);
		con.setDrawColor(new Color(88, 73, 110));
		con.drawString("Back to Main Menu",20,18);
		con.setDrawColor(new Color(241,235,250));
		
		// button interaction
		while(intnum == 1){
			intMousex = con.currentMouseX();
			intMousey = con.currentMouseY();
			intMousebut = con.currentMouseButton();
			
			if(intMousex > 10 && intMousex < 260 && intMousey > 10 && intMousey < 60 && intMousebut == 1){
				return con;
			}
		}
		
		return con;
	}
}
