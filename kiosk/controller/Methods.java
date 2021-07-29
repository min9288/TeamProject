package kiosk.controller;
import java.util.Scanner;

public class Methods {
	static public MyLinkedList ml = new MyLinkedList();
	static Scanner sc = new Scanner(System.in);

	public static void signUP() {
		System.out.println("============ ȸ�� ���� =============");
		signUpLoop();
		System.out.println();
		System.out.println("���� �Ϸ�!");
		System.out.println();

	}

	public static void printMember() {
		System.out.println("============ ȸ��  ���� ���  =============");
		boolean isMember = false;
		String name = "";
		do {
			System.out.printf("�̸� �Է� : ");
			name = sc.next();
			System.out.println();
			isMember = 	ml.printMember(name);
		} while (!isMember);
			System.out.println();
			System.out.println("1. ȸ�� ���� ����");
			System.out.println("2. ȸ�� ����");
			System.out.println("0. ���α׷� ����");
			System.out.printf("���� > ");
			int sel = sc.nextInt();
			System.out.println();
			
			switch (sel) {
			case 1:
				ml.delete(name);
				signUpLoop();
				System.out.println("���� �Ϸ�!");
				return;
			case 2:
				ml.delete(name);
				System.out.println("���� �Ϸ�!");
				return;
			case 3:
				return;
			}
			
		
	}
	
	  public static boolean addPoint(String name, double point) {
		  return ml.addPoint(name, point);

	   }
	
	
	public static void signUpLoop() {
		boolean isMember = false;
		do {
			System.out.printf("�̸� �Է� : ");
			isMember = ml.signUp(sc.next());
		} while (isMember);
	}

}
