package com.li.ramon.list;

import java.util.Random;

public class DoublyLinkedListTest {

	final int MAX = 10;
	Random random = new Random();
	DoublyLinkedList<Integer> myDoublyLinkedList;

	public DoublyLinkedListTest() {
		initMyDoublyLinkedList();
	}

	/*
	 * �����������ʼ������
	 */
	public void initMyDoublyLinkedList() {
		myDoublyLinkedList = new DoublyLinkedList<Integer>();
		for (int i = 0; i < MAX; i++) {
			int value = random.nextInt(MAX);
			// ���һ������
			myDoublyLinkedList.insertFromHead(value);
		}
		System.out.println("���ɵ�˫����������Ϊ��");
		myDoublyLinkedList.print();
	}

	/*
	 * �����ȡ����
	 */
	public void getElemTest() {
		int i = random.nextInt(MAX);
		System.out.println("\n��ȡ���ݵ�����±�Ϊ: " + i);
		System.out.println("��ȡ��������Ϊ: " + myDoublyLinkedList.getElementByIndex(i));
	}

	/*
	 * ���ɾ������
	 */
	public void deleteElemTest() {
		int i = random.nextInt(MAX);
		System.out.println("\n���ɾ����λ��Ϊ��" + i);
		int data = myDoublyLinkedList.deleteAtIndex(i);
		System.out.println("ɾ��������Ϊ: " + data + " ɾ�����ݺ���б�Ϊ: ");
		myDoublyLinkedList.print();
	}

	public static void main(String[] args) {
		DoublyLinkedListTest myDoublyLinkedListTest = new DoublyLinkedListTest();
		myDoublyLinkedListTest.getElemTest();
		myDoublyLinkedListTest.deleteElemTest();
	}
}
