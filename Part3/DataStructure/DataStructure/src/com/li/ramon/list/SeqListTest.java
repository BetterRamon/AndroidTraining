package com.li.ramon.list;

import java.util.Random;

import com.li.ramon.list.impls.SeqList;

/**
 * �������Ա��˳���ʾ��ʵ��
 * @author meng.li
 *
 */
public class SeqListTest {
	final int MAX = 25;
	Random random = new Random();
	SeqList<Integer> seqList;
	
	public SeqListTest(){
		initSeqList();
	}
	
	/*
	 *�����������ʼ������ 
	 */
	public void initSeqList(){
		seqList = new SeqList<Integer>();
		int length = random.nextInt(MAX);
		System.out.println("�����������������Ϊ "+length);
		if(length > SeqList.MAXSIZE){
			System.out.println("���Ȳ��Ϸ�");
		}
		for(int i = 1;i <= length; i++ ){
			int value = random.nextInt(MAX);
			System.out.print(value+" ");
			if(!seqList.insertElem(i, value)){
				System.exit(0);
			}
		}
		System.out.println("\nԭʼ����Ϊ�� ");
		displayList(seqList);
	}
	/*
	 * �����ȡ����
	 */
	public void getElemTest(){
		int i = random.nextInt(MAX);
		System.out.println("\n��ȡ���ݵ�����±�Ϊ: " + i);
		System.out.println("��ȡ��������Ϊ: " + seqList.getElem(i));
	}
	/*
	 * �����������
	 */
	public void insertElemTest(){
		int i = random.nextInt(MAX);
		System.out.println("\n��������λ��Ϊ�� " + i);
		int value = random.nextInt(MAX);
		System.out.println("������������Ϊ��" + value);
		seqList.insertElem(i, value);
		System.out.println("�������ݺ���б�Ϊ��");
		displayList(seqList);
	}
	/*
	 * ���ɾ������
	 */
	public void deleteElemTest(){
		int i = random.nextInt(MAX);
		System.out.println("\n���ɾ����λ��Ϊ��" + i);
		Integer value = seqList.deleteElem(i);
		if(value == null){
			System.exit(0);
		}else{
			System.out.println("ɾ��������Ϊ�� " + value);
			System.out.println("ɾ�����ݺ���б�Ϊ: " );
			displayList(seqList);
		}
	}
	
	/*
	 * չʾ����
	 */
	public void displayList(SeqList seqList){
		for(int i = 1;i <= seqList.getLength();i++){
			if(seqList.getElem(i) != null){
				System.out.print(seqList.getElem(i) + " ");
			}
		}
		System.out.println("\n����ĳ���Ϊ�� "+ seqList.getLength());
	}
	
	public static void main(String args[]){
		SeqListTest seqListTest = new SeqListTest();
		seqListTest.insertElemTest();
		seqListTest.getElemTest();
		seqListTest.deleteElemTest();
	}
}
