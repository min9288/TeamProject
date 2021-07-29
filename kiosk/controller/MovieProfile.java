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
				System.out.println("영화 이름 : " + ticketList.get(i).getsMoiveName());
				System.out.println("인원수 : " + ticketList.get(i).getiPeople());
				System.out.println("영화 이름 : " + ticketList.get(i).getiPhone());
				return;				
			}			
		}
		
		System.out.println("유효한 번호가 아닙니다.");
	}
	
	public void TicketCancel(int _iPhone)
	{
		for(int i = 0; i < ticketList.size(); ++i)
		{
			if(ticketList.get(i).getiPhone() == _iPhone)
			{
				ticketList.remove(i);
				System.out.println("예매 취소 완료.");
				return;				
			}
		}
		
		System.out.println("유효한 번호가 아닙니다.");
	}
	
}