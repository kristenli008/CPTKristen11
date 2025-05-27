import arc.*;

public class cpttools{
	public static void main(String[] args){
	
	}
	
	public static int textcount(TextInputFile textfile){
			
		String strLine;
		int intcount = 0;
	
		while(textfile.eof() == false){
			strLine = textfile.readLine();
			intcount = intcount + 1;
		}
				
		return intcount;
	}
}
