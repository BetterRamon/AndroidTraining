package com.li.ramon.sort;
/**
 * ð�������㷨
 * @author limeng
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {23, 122, 2, 5, 9, 10};
		bubbleSort(a);
		//bubbleSortFine(a);
		for (int i = 0; i < a.length; i++) 
			System.out.println(a[i]);
	}
	
	// ð������һ��д��
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i< arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j +1]) {
					// ���÷����㽻��
					arr[j] = arr[j] ^ arr[j + 1];
					arr[j + 1] = arr[j] ^ arr[j + 1];
					arr[j] = arr[j + 1] ^ arr[j];
				}
			}
		}
	}
	
	// ð��������Ż��������һ�α���������û�н��н�������֤�������Ѿ��������������ѭ��
	public static void bubbleSortFine(int[] arr) {
		boolean flag = true;
		int k = arr.length;
		while (flag) {
			flag = false;
			for (int i = 1; i < k; i++) {
				if (arr[i-1] > arr[i]) {
					// ���ü���
					arr[i-1] = arr[i] - arr[i-1];
					arr[i] = arr[i] - arr[i - 1];
					arr[i - 1] = arr[i -1] + arr[i];
					flag = true;
				}
			}
			k--;
		}
	}
}
