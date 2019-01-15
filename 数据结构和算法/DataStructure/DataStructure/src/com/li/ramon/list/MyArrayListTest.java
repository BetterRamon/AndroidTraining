package com.li.ramon.list;

import java.util.Random;

/**
 * �������Ա��˳���ʾ��ʵ��
 * @author meng.li
 *
 */
public class MyArrayListTest {
	final int MAX = 60;
	Random random = new Random();
	MyArrayList<Integer> myArrayList;
	
	public MyArrayListTest(){
		initmyArrayList();
	}
	
	/*
	 *�����������ʼ������ 
	 */
	public void initmyArrayList(){
		myArrayList = new MyArrayList<Integer>();
		//�������һ������Ҫ���������������ֵ
		int size = random.nextInt(MAX);
		System.out.println("�����������Ϊ "+size);
		for(int i = 0;i < size; i++ ){
			int value = random.nextInt(MAX);
			if(!myArrayList.insertElem(i, value)){
				System.exit(0);
			}
		}
		System.out.println("\n��ʼ�����Ա�Ϊ�� ");
		myArrayList.display();
	}
	/*
	 * �����ȡ����
	 */
	public void getElemTest(){
		int i = random.nextInt(MAX);
		System.out.println("\n��ȡ���ݵ�����±�Ϊ: " + i);
		System.out.println("��ȡ��������Ϊ: " + myArrayList.getElem(i));
	}
	/*
	 * �����������
	 */
	public void insertElemTest(){
		int i = random.nextInt(MAX);
		System.out.println("\n��������λ��Ϊ�� " + i);
		int value = random.nextInt(MAX);
		System.out.println("������������Ϊ��" + value);
		myArrayList.insertElem(i, value);
		System.out.println("�������ݺ���б�Ϊ��");
		myArrayList.display();
	}
	/*
	 * ���ɾ������
	 */
	public void deleteElemTest(){
		int i = random.nextInt(MAX);
		System.out.println("\n���ɾ����λ��Ϊ��" + i);
		Integer value = myArrayList.removeElem(i);
		if(value == null){
			System.exit(0);
		}else{
			System.out.println("ɾ��������Ϊ�� " + value);
			System.out.println("ɾ�����ݺ���б�Ϊ: " );
			myArrayList.display();
		}
	}
	
	
	public static void main(String args[]){
		MyArrayListTest myArrayListTest = new MyArrayListTest();
		myArrayListTest.insertElemTest();
		myArrayListTest.getElemTest();
		myArrayListTest.deleteElemTest();
	}
}
