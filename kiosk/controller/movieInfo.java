package kiosk.controller;

public class movieInfo 
{
	private String[] movieName;
	private int iMoveNum;
	
	public movieInfo()
	{
		iMoveNum = 5;
		movieName = new String[5];
		
		int i = 0;
		movieName[i++] = "저수지의개들";
		movieName[i++] = "이퀼리브리엄";
		movieName[i++] = "매트릭스";
		movieName[i++] = "분노의쟝고";
		movieName[i++] = "브루스올마이티";
	}
	
	public void print_MovieName()
	{
		for(int i = 0; i < movieName.length; ++i)
			System.out.println((i+1) + "번 : " + movieName[i]);			
	}
	
	public String get_MovieName(int _index)
	{
		return movieName[_index];
	}
	
}