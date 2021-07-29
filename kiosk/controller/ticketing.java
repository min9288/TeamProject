package kiosk.controller;

import java.util.Scanner;


public class ticketing 
{
	movieInfo movie;
	Scanner sc;
	MovieProfile MovieFile;
	
	public ticketing()
	{
		movie = new movieInfo();
		sc = new Scanner(System.in);
		MovieFile =  new MovieProfile();
	}	
	
	public void main()
	{		
		while (true) {
			System.out.println("\n============= Ƽ�� ���� ������ ===========\n");
			System.out.println("1. ��ȭ ���� ");
			System.out.println("2. ���� ���� Ȯ��");			
			System.out.println("3. ���� ���");
			System.out.println("4. ����");
			System.out.printf("���� > ");
			int sel = sc.nextInt();

			switch (sel) 
			{
			case 1:
				Ticketing();
				break;
			case 2:
				TicketCheck();
				break;
			case 3:
				TicketCancel();
				break;			
			case 4:
				System.out.println("�������� �����մϴ�. ");
				return;

			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}
	
	public void Ticketing()
	{
		while(true)
		{
			System.out.println("\n============= Ƽ�� ���� ===========");
			movie.print_MovieName();
			System.out.printf("���� > ");
			int iMovie = sc.nextInt();
			
			if(iMovie <= 0 || iMovie > 5)
			{
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				continue;
			}			
				
			System.out.println("�ο� ���� ������ �ּ���.");
			int iPeople = sc.nextInt();			
	
			int iPhone = Input_PhoneNum("��ȭ ��ȣ ���ڸ� �Է����ּ���.");
			
			if(iPhone < 0)
			{
				System.out.println("��ȿ�� ��ȣ�� �ƴմϴ�.");
				break;
			}
			
			MovieFile.Set_Ticket(movie.get_MovieName(iMovie-1),iPeople, iPhone);
			System.out.println("��ȭ�� : " + movie.get_MovieName(iMovie-1));
			System.out.println("�μ� : " + iPeople);
			System.out.println("��ȣ ���ڸ� : " + iPhone);
			System.out.println("-------- ���� �Ϸ� ---------");
			break;
		}
	}
	
	public void TicketCheck()
	{		
		int iPhone = Input_PhoneNum("������ �޴��� ���ڸ��� �Է����ּ���.");	
		if(iPhone < 0)
		{
			System.out.println("��ȿ�� ��ȣ�� �ƴմϴ�.");
			return;
		}
		MovieFile.Check_Ticket(iPhone);
	}
	
	public void TicketCancel()
	{		
		int iPhone = Input_PhoneNum("������ �޴��� ���ڸ��� �Է����ּ���.");		
		
		if(iPhone < 0)
		{
			System.out.println("��ȿ�� ��ȣ�� �ƴմϴ�.");
			return;
		}
		MovieFile.TicketCancel(iPhone);
	}
	
	public int Input_PhoneNum(String _Notice)
	{
		System.out.println(_Notice);		
		System.out.printf("�Է� > ");
		int iPhone = sc.nextInt();
		
		if(iPhone > 10000 || iPhone < 1000)
			return -1;
		
		return iPhone;
	}
	
}