package com.li.ramon.list;

import java.util.Random;

/**
 * Լɪ������
 * 
 * @author limeng
 * 
 */
public class YueSeFu {

	public static void main(String[] args) {
		yuesefu(10, 3, 2);
	}

	public static void yuesefu(int totalNum, int countNum, int startNum) {
		// ��ʼ������
		CircularLinkedList<Integer> yueSeFu = new CircularLinkedList<Integer>();
		for (int i = 1; i <= totalNum; i++) {
			yueSeFu.add(i);
		}
		// ���±�Ϊ k ��ʼ����
		int k = startNum - 1;
		while (yueSeFu.size > 0) {
			// ��m�˵�����λ�� ,��һ����Ϊ�Ǵ� �� k ���˾Ϳ�ʼ��
			k = (k + countNum) % (yueSeFu.size) - 1;
			// ������β��ʱ��k ���� -1
			if (k < 0) {
				System.out.println("���Ϊ" + yueSeFu.get(yueSeFu.size - 1)
						+ " ���˳���");
				yueSeFu.delete(yueSeFu.size - 1);
				k = 0;
			} else {
				System.out.println("���Ϊ" + yueSeFu.get(k) + " ���˳���");
				yueSeFu.delete(k);
			}
		}
	}
}
