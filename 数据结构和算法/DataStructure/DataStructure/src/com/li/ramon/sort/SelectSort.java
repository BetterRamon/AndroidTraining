package com.li.ramon.sort;
/**
 * ѡ������
 * ��δ�����������ҵ���СԪ�أ���ŵ��������е���ʼλ��  
 * �ٴ�ʣ��δ����Ԫ���м���Ѱ����СԪ�أ�Ȼ��ŵ���������ĩβ�� 
 * �Դ����ƣ�ֱ������Ԫ�ؾ�������ϡ� 
 * @author limeng
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] a = {231, 122, 2, 5, 9, 10};
		SelectSort(a);
		for (int i = 0; i < a.length; i++) 
			System.out.println(a[i]);
	}
	private static void SelectSort(int[] arr) {
		int size = arr.length;//���鳤��
		int temp = 0; // �м����
		for (int i = 0; i < size; i++) {
			int k = i; //��ȷ����λ��
			for (int j = size -1; j > i; j--) {
				if(arr[j] < arr[k]) {
					k = j;//�ҵ���С�����±�
				}
			}
			// ����������
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}
	}
}
