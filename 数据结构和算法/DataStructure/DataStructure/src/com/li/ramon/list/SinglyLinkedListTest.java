package com.li.ramon.list;

import java.util.Random;

public class SinglyLinkedListTest {
	final int MAX = 20;
	Random random = new Random();
	SinglyLinkedList<Integer> mySinglyLinkedList;

	public SinglyLinkedListTest() {
		initMySinglyLinkedList();
	}

	/*
	 * �����������ʼ������
	 */
	public void initMySinglyLinkedList() {
		mySinglyLinkedList = new SinglyLinkedList<Integer>();
		// �������һ������Ҫ���������������ֵ
		int size = random.nextInt(MAX);
		System.out.println("�����������Ϊ " + size);
		for (int i = 0; i < size; i++) {
			int value = random.nextInt(MAX);
			// ���һ������
			mySinglyLinkedList.add(value);
		}
		mySinglyLinkedList.display();
		System.out.println();
	}

	/*
	 * �����ȡ����
	 */
	public void getElemTest() {
		int i = random.nextInt(MAX);
		System.out.println("\n��ȡ���ݵ�����±�Ϊ: " + i);
		System.out.println("��ȡ��������Ϊ: " + mySinglyLinkedList.get(i));
	}

	/*
	 * ���λ�ò�������
	 */
	public void addElemTest() {
		int i = random.nextInt(MAX);
		System.out.println("\n��������λ��Ϊ�� " + i);
		int value = random.nextInt(MAX);
		System.out.println("������������Ϊ��" + value);
		mySinglyLinkedList.add(i, value);
		System.out.println("�������ݺ���б�Ϊ��");
		mySinglyLinkedList.display();
		System.out.println();
	}

	/*
	 * ���ɾ������
	 */
	public void deleteElemTest() {
		int i = random.nextInt(MAX);
		System.out.println("\n���ɾ����λ��Ϊ��" + i);
		mySinglyLinkedList.delete(i);
		System.out.println("ɾ�����ݺ���б�Ϊ: ");
		mySinglyLinkedList.display();
	}

	public static void main(String[] args) {
		SinglyLinkedListTest mySinglyLinkedListTest = new SinglyLinkedListTest();
		mySinglyLinkedListTest.addElemTest();
		mySinglyLinkedListTest.getElemTest();
		mySinglyLinkedListTest.deleteElemTest();
	}
}
