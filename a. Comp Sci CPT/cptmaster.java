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
			
			if(strTheme.equalsIgnoreCase("popular animes")){
				intScore = gameplay(strName, animes);
				blnerror = true;
			}else if(strTheme.equalsIgnoreCase("board games")){
				intScore = gameplay(strName, boardgames);
				blnerror = true;
			}else if(strTheme.equalsIgnoreCase("cartoons")){
				intScore = gameplay(strName, cartoons);
				blnerror = true;
			}else if(strTheme.equalsIgnoreCase("digital art programs")){
				intScore = gameplay(strName, boardgames);
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
	
	public static int gameplay(String strName, TextInputFile textfile){
		int intScore = 0;
		
		return intScore;
	}
}
