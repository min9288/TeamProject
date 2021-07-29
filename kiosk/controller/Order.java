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

		m[index++] = new Coffee("에스프레소", "coffee", 3000);
		m[index++] = new Coffee("아메리카노", "coffee", 4100);
		m[index++] = new Coffee("카페라떼", "coffee", 4400);
		m[index++] = new Coffee("바닐라라떼", "coffee", 5000);
		m[index++] = new Coffee("카라멜마키아또","coffee", 5500);
		m[index++] = new Coffee("바닐라라떼", "coffee", 5000);
		m[index++] = new Coffee("콜드브루", "coffee", 5000);
		m[index++] = new Coffee("콜드브루라떼","coffee", 5500);
		m[index++] = new Beverage("콜라", "beverage", 2000);
		m[index++] = new Beverage("레몬에이드", "beverage", 4500);
		m[index++] = new Beverage("자몽에이드", "beverage", 4500);
		m[index++] = new Beverage("오미자차", "beverage", 4000);
		m[index++] = new Beverage("하비스커스", "beverage", 4200);
		m[index++] = new Dessert("치즈케이크", "dessert", 5000);
		m[index++] = new Dessert("초콜릿케이크", "dessert", 5000);
		m[index++] = new Dessert("멜론빙수", "dessert", 12000);
		m[index++] = new Dessert("망고빙수", "dessert", 12000);

		while (true) {
			System.out.println("====== 주문 ======");
			System.out.println("1. 커피");
			System.out.println("2. 음료");
			System.out.println("3. 디저트");
			System.out.println("4. 메인 메뉴로 전환");
			int select = sc.nextInt();
			
			
			switch (select) {
			case 1:
			case 2:
			case 3:				
				printMenu(select);
				break;
			case 4:
				System.out.println("메인 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘 못 입력하셨습니다, 다시 입력해주세요.");
				break;
			}
		}
	}

	public static void printMenu(int menu) {
		System.out.println("가격\t메뉴");
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
		System.out.print("\n구매할 제품의 이름을 입력해주세요 : ");
		String orderName = sc.next();
		int searchIndex = searchProduct(orderName);

		while (true) {
			System.out.println("구매할 제품은 " + m[searchIndex].getName() + " 이고, 가격은" + m[searchIndex].getPrice() + "원 입니다.");
			System.out.print("구매 하시겠습니까? [ y / n ] : ");
			char select = sc.next().charAt(0);

			if (select == 'y') {
				System.out.println("구매완료");
				System.out.print("포인트 적립 하시겠습니까? [ y / n ] : ");
				char sel = sc.next().charAt(0);
				
				if(sel == 'y') {
					System.out.print("고객님 성함을 입력해주세요 : ");
					String name = sc.next();
				
					if(true == Methods.addPoint(name, (double)(m[searchIndex].getPrice() * 0.05))) {
					System.out.println("적립이 완료되었습니다.");
					
					}else {
						System.out.println("적립이 실패했습니다.");	
					}
					System.out.println("구매메뉴로 돌아갑니다.");
				}else {
					System.out.println("구매메뉴로 돌아갑니다.");
					return;
				}
				return;
			} else if (select == 'n') {
				System.out.println("구매취소");
				return;
			} else {
				System.out.println("잘 못 입력하셨습니다, 다시 입력해주세요.");
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
