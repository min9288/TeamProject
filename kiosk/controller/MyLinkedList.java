package kiosk.controller;

public class MyLinkedList {

	Node head;
	Node tail;
	int size = 0;

	public void add(String name) {

		Node node = new Node(name);

		if (tail == null) {
			head = node;
			tail = node;

		} else {
			tail.nextNode = node;
			tail = node;

		}
		size ++;

	}

	public Node delete(String name) {
		
		
		if(size==0) {
			return null;
		}
		if(size==1) {
			head = null;
			tail = null;
			size--;
			return null;
		}

		Node nodeBeforeNodetoDelete = findNodeBefore(name);
		
		if(nodeBeforeNodetoDelete.name==null) {
			head = head.nextNode;
			size--;
		}
		else if (nodeBeforeNodetoDelete != null) {

			if (tail.name.equalsIgnoreCase(name)) {
				nodeBeforeNodetoDelete.nextNode=null;
				tail = nodeBeforeNodetoDelete;

			}else {
				nodeBeforeNodetoDelete.nextNode = nodeBeforeNodetoDelete.nextNode.nextNode;
			}
			size--;

		}
		return null;
	}
	
	
	
	public Node findNodeBefore(String name) {

		if (head.name.equalsIgnoreCase(name)) {
			return new Node();
		}

		Node node = head;

		while (node.nextNode != null) {

			if(node.nextNode.name.equalsIgnoreCase(name)) {
				return node;
			}
			node = node.nextNode;

		}
		System.out.println("Ȯ�ε��� �ʴ� ȸ�� �Դϴ�.");
		return null;
	}

	
	
	public Node find(String name) {

		if (head == null) {
			return null;
		}

		if (head.name.equalsIgnoreCase(name)) {
			return head;
		}

		Node node = head;

		while (node.nextNode != null) {

			node = node.nextNode;
			if (node.name.equalsIgnoreCase(name)) {
				return node;
			}

		}
		return null;
	}


	public boolean printMember(String name) {
		Node node = find(name);
		if (node == null) {
			System.out.println("Ȯ�ε��� �ʴ� ȸ�� �Դϴ�.");
			System.out.println("�ٽ� �Է� ���ּ���.");
			return false;
		} else {
			System.out.println(node.name + "\t" + node.point);
			return true;
		}
	}

	public boolean addPoint(String name, double point) {
		Node node = find(name);
		if (node == null) {
			System.out.println("Ȯ�ε��� �ʴ� ȸ�� �Դϴ�.");
			return false;
		} else {
			node.addPoint(point);
			return true;
		}

	}

	public boolean signUp(String name) {
		Node node = find(name);

		if (node == null) {
			add(name);
			return false;
		} else {
			System.out.println("�̹� �ִ� ȸ�� �Դϴ�.");
			System.out.println("�ٽ� �Է� ���ּ���.");
			return true;
		}

	}
	
	public void deleteMember(String name) {
		delete(name);
	}

}