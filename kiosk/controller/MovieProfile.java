package kiosk.controller;

import java.util.LinkedList;

import kiosk.vo.ticket;

public class MovieProfile 
{
	private LinkedList<ticket> ticketList;
	
	public MovieProfile()
	{
		ticketList = new LinkedList<ticket>();
	}
	
	public void Set_Ticket(String _MovieName, int _ipeople , int _iphone)
	{
		ticket Temp = new ticket(_MovieName, _ipeople, _iphone);
		ticketList.add(Temp);
	}
	
	public void Check_Ticket(int _iPhone)
	{
		for(int i = 0; i < ticketList.size(); ++i)
		{
			if(ticketList.get(i).getiPhone() == _iPhone)
			{
				System.out.println("��ȭ �̸� : " + ticketList.get(i).getsMoiveName());
				System.out.println("�ο��� : " + ticketList.get(i).getiPeople());
				System.out.println("��ȭ �̸� : " + ticketList.get(i).getiPhone());
				return;				
			}			
		}
		
		System.out.println("��ȿ�� ��ȣ�� �ƴմϴ�.");
	}
	
	public void TicketCancel(int _iPhone)
	{
		for(int i = 0; i < ticketList.size(); ++i)
		{
			if(ticketList.get(i).getiPhone() == _iPhone)
			{
				ticketList.remove(i);
				System.out.println("���� ��� �Ϸ�.");
				return;				
			}
		}
		
		System.out.println("��ȿ�� ��ȣ�� �ƴմϴ�.");
	}
	
}