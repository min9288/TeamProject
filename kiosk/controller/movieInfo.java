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
		movieName[i++] = "�������ǰ���";
		movieName[i++] = "�������긮��";
		movieName[i++] = "��Ʈ����";
		movieName[i++] = "�г�������";
		movieName[i++] = "��罺�ø���Ƽ";
	}
	
	public void print_MovieName()
	{
		for(int i = 0; i < movieName.length; ++i)
			System.out.println((i+1) + "�� : " + movieName[i]);			
	}
	
	public String get_MovieName(int _index)
	{
		return movieName[_index];
	}
	
}