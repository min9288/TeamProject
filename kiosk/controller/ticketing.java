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
			System.out.println("\n============= 티켓 예메 컨텐츠 ===========\n");
			System.out.println("1. 영화 예매 ");
			System.out.println("2. 예매 정보 확인");			
			System.out.println("3. 예매 취소");
			System.out.println("4. 종료");
			System.out.printf("선택 > ");
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
				System.out.println("메인으로 복귀합니다. ");
				return;

			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}
	
	public void Ticketing()
	{
		while(true)
		{
			System.out.println("\n============= 티켓 예메 ===========");
			movie.print_MovieName();
			System.out.printf("선택 > ");
			int iMovie = sc.nextInt();
			
			if(iMovie <= 0 || iMovie > 5)
			{
				System.out.println("잘못입력하셨습니다.");
				continue;
			}			
				
			System.out.println("인원 수를 설정해 주세요.");
			int iPeople = sc.nextInt();			
	
			int iPhone = Input_PhoneNum("전화 번호 뒷자리 입력해주세요.");
			
			if(iPhone < 0)
			{
				System.out.println("유효한 번호가 아닙니다.");
				break;
			}
			
			MovieFile.Set_Ticket(movie.get_MovieName(iMovie-1),iPeople, iPhone);
			System.out.println("영화명 : " + movie.get_MovieName(iMovie-1));
			System.out.println("인수 : " + iPeople);
			System.out.println("번호 뒷자리 : " + iPhone);
			System.out.println("-------- 예매 완료 ---------");
			break;
		}
	}
	
	public void TicketCheck()
	{		
		int iPhone = Input_PhoneNum("예약한 휴대폰 뒷자리를 입력해주세요.");	
		if(iPhone < 0)
		{
			System.out.println("유효한 번호가 아닙니다.");
			return;
		}
		MovieFile.Check_Ticket(iPhone);
	}
	
	public void TicketCancel()
	{		
		int iPhone = Input_PhoneNum("예약한 휴대폰 뒷자리를 입력해주세요.");		
		
		if(iPhone < 0)
		{
			System.out.println("유효한 번호가 아닙니다.");
			return;
		}
		MovieFile.TicketCancel(iPhone);
	}
	
	public int Input_PhoneNum(String _Notice)
	{
		System.out.println(_Notice);		
		System.out.printf("입력 > ");
		int iPhone = sc.nextInt();
		
		if(iPhone > 10000 || iPhone < 1000)
			return -1;
		
		return iPhone;
	}
	
}