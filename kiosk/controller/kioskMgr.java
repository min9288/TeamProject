package kiosk.controller;
import kiosk.controller.*;
import kiosk.vo.ticket;

import java.util.Scanner;

public class kioskMgr {

	public Scanner sc;
	ticketing Ticket = new ticketing();
	
	public kioskMgr() {
		sc = new Scanner(System.in);
	}


	public void main() {
		while (true) {
			System.out.println("\n============= ����Ʈ ���� ���α׷�v1 ===========\n");
			System.out.println("1. ī�� �ֹ� ");
			System.out.println("2. ȸ�� ��ȸ");
			System.out.println("3. ȸ�� ���� ");
			System.out.println("4. Ƽ�� ���� ");
			System.out.println("5. ����");
			System.out.printf("���� > ");
			int sel = sc.nextInt();

			switch (sel) {
			case 1:
				Order.orderMenu();
				break;
			case 2:
				Methods.printMember();
				break;
			case 3:
				Methods.signUP();
				break;
			case 4:
				Ticket.main();
				break;
			case 5:
				System.out.println("���α׷� ���� ~~ ");
				return;

			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}
}
