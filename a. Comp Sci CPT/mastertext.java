import arc.*;

public class mastertext{
	public static void main(String[] args){
		Console con = new Console();
		
		TextInputFile animes = new TextInputFile("popular animes.txt");
		TextInputFile boardgames = new TextInputFile("board games.txt");
		TextInputFile cartoons = new TextInputFile("cartoons.txt");
		TextInputFile artprograms = new TextInputFile("digital art programs.txt");
		
		int intcount = 0;
		intcount = cpttools.textcount(cartoons);
		con.println(intcount);
		
		animes.close();
		boardgames.close();
		cartoons.close();
		artprograms.close();
	}
	
}
