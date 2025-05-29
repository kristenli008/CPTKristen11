import arc.*;

public class cptmaster{
	public static void main(String[] args){
		Console con = new Console();
		
		String strName;
		String strTheme;
		int intScore;
		boolean blnerror = false;
		
		TextInputFile animes = new TextInputFile("popular animes.txt");
		TextInputFile boardgames = new TextInputFile("board games.txt");
		TextInputFile cartoons = new TextInputFile("cartoons.txt");
		TextInputFile artprograms = new TextInputFile("digital art programs.txt");
		
		con.println("Please enter your name:");
		strName = con.readLine();
		
		while(blnerror == false){
			con.println("Which theme would you like to play today?");
			con.println("Please type in the theme name.");
			con.println("Popular Animes || Board Games || Cartoons || Digital Art Programs");
			strTheme = con.readLine();
			String strArray[][];
			String strRead;
			int intCols = 0;
			
			if(strTheme.equalsIgnoreCase("popular animes")){
				while(animes.eof() == false){
					strRead = animes.readLine();
					intCols = intCols + 1;
				}
				strArray = cpttools.randomsort(animes, intCols);
				intScore = gameplay(strName, strArray);
				blnerror = true;
			}else if(strTheme.equalsIgnoreCase("board games")){
				while(boardgames.eof() == false){
					strRead = boardgames.readLine();
					intCols = intCols + 1;
				}
				strArray = cpttools.randomsort(boardgames, intCols);
				intScore = gameplay(strName, strArray);
				blnerror = true;
			}else if(strTheme.equalsIgnoreCase("cartoons")){
				while(cartoons.eof() == false){
					strRead = cartoons.readLine();
					intCols = intCols + 1;
				}
				strArray = cpttools.randomsort(cartoons, intCols);
				intScore = gameplay(strName, strArray);
				blnerror = true;
			}else if(strTheme.equalsIgnoreCase("digital art programs")){
				while(artprograms.eof() == false){
					strRead = artprograms.readLine();
					intCols = intCols + 1;
				}
				strArray = cpttools.randomsort(artprograms, intCols);
				intScore = gameplay(strName, strArray);
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
	
	public static int gameplay(String strName, String strArray[][]){
		int intScore = 0;
		
		
		
		return intScore;
	}
}
