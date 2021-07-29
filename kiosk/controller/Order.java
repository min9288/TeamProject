package kiosk.controller;

import java.util.LinkedList;
import java.util.Scanner;

import kiosk.vo.Beverage;
import kiosk.vo.Coffee;
import kiosk.vo.Dessert;
import kiosk.vo.Menu;



public class Order {//extends MyLinkedList{
	static Scanner sc = new Scanner(System.in);
	static Menu[] m = new Menu[30];
	static int index = 0;
	
	public static void orderMenu() {

		m[index++] = new Coffee("����������", "coffee", 3000);
		m[index++] = new Coffee("�Ƹ޸�ī��", "coffee", 4100);
		m[index++] = new Coffee("ī���", "coffee", 4400);
		m[index++] = new Coffee("�ٴҶ��", "coffee", 5000);
		m[index++] = new Coffee("ī��ḶŰ�ƶ�","coffee", 5500);
		m[index++] = new Coffee("�ٴҶ��", "coffee", 5000);
		m[index++] = new Coffee("�ݵ���", "coffee", 5000);
		m[index++] = new Coffee("�ݵ����","coffee", 5500);
		m[index++] = new Beverage("�ݶ�", "beverage", 2000);
		m[index++] = new Beverage("�����̵�", "beverage", 4500);
		m[index++] = new Beverage("�ڸ����̵�", "beverage", 4500);
		m[index++] = new Beverage("��������", "beverage", 4000);
		m[index++] = new Beverage("�Ϻ�Ŀ��", "beverage", 4200);
		m[index++] = new Dessert("ġ������ũ", "dessert", 5000);
		m[index++] = new Dessert("���ݸ�����ũ", "dessert", 5000);
		m[index++] = new Dessert("��к���", "dessert", 12000);
		m[index++] = new Dessert("�������", "dessert", 12000);

		while (true) {
			System.out.println("====== �ֹ� ======");
			System.out.println("1. Ŀ��");
			System.out.println("2. ����");
			System.out.println("3. ����Ʈ");
			System.out.println("4. ���� �޴��� ��ȯ");
			int select = sc.nextInt();
			
			
			switch (select) {
			case 1:
			case 2:
			case 3:				
				printMenu(select);
				break;
			case 4:
				System.out.println("���� �޴��� ���ư��ϴ�.");
				return;
			default:
				System.out.println("�� �� �Է��ϼ̽��ϴ�, �ٽ� �Է����ּ���.");
				break;
			}
		}
	}

	public static void printMenu(int menu) {
		System.out.println("����\t�޴�");
		for (int i = 0; i < index; i++) {
			if (menu == 1) {
				if (m[i].getSpecies().equalsIgnoreCase("coffee")) {
					System.out.printf("%d\t%s\t%n", m[i].getPrice(),m[i].getName());
				}
			}
			if (menu == 2) {
				if (m[i].getSpecies().equalsIgnoreCase("beverage")) {
					System.out.printf("%d\t%s\t%n", m[i].getPrice(),m[i].getName());
				}
			}
			if (menu == 3) {
				if (m[i].getSpecies().equalsIgnoreCase("dessert")) {
					System.out.printf("%d\t%s\t%n", m[i].getPrice(),m[i].getName());
				}
			}
		}
		System.out.println();
		orderProcess();

	}

	public static void orderProcess() {
		System.out.print("\n������ ��ǰ�� �̸��� �Է����ּ��� : ");
		String orderName = sc.next();
		int searchIndex = searchProduct(orderName);

		while (true) {
			System.out.println("������ ��ǰ�� " + m[searchIndex].getName() + " �̰�, ������" + m[searchIndex].getPrice() + "�� �Դϴ�.");
			System.out.print("���� �Ͻðڽ��ϱ�? [ y / n ] : ");
			char select = sc.next().charAt(0);

			if (select == 'y') {
				System.out.println("���ſϷ�");
				System.out.print("����Ʈ ���� �Ͻðڽ��ϱ�? [ y / n ] : ");
				char sel = sc.next().charAt(0);
				
				if(sel == 'y') {
					System.out.print("���� ������ �Է����ּ��� : ");
					String name = sc.next();
				
					if(true == Methods.addPoint(name, (double)(m[searchIndex].getPrice() * 0.05))) {
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					
					}else {
						System.out.println("������ �����߽��ϴ�.");	
					}
					System.out.println("���Ÿ޴��� ���ư��ϴ�.");
				}else {
					System.out.println("���Ÿ޴��� ���ư��ϴ�.");
					return;
				}
				return;
			} else if (select == 'n') {
				System.out.println("�������");
				return;
			} else {
				System.out.println("�� �� �Է��ϼ̽��ϴ�, �ٽ� �Է����ּ���.");
				break;
			}
		}

	}

	public static int searchProduct(String name) {
		for (int i = 0; i < m.length; i++) {
			if (m[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
}
