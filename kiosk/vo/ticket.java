package kiosk.vo;

public class ticket 
{
	private int iPhone;
	private int iPeople;
	private String sMoiveName;
	
	public ticket(String _Movie, int _iPeople, int _iPhone)
	{
		sMoiveName = _Movie;
		iPeople = _iPeople;
		iPhone = _iPhone;
	}
	
	public int getiPhone() 
	{
		return iPhone;
	}
	public void setiPhone(int iPhone) 
	{
		this.iPhone = iPhone;
	}
	public String getsMoiveName() 
	{
		return sMoiveName;
	}
	public void setsMoiveName(String sMoiveName) 
	{
		this.sMoiveName = sMoiveName;
	}

	public int getiPeople() 
	{
		return iPeople;
	}

	public void setiPeople(int iPeople) 
	{
		this.iPeople = iPeople;
	}
}