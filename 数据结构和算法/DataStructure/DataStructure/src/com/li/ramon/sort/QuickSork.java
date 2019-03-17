package com.li.ramon.sort;
/**
 * ��������
 * @author limeng
 *
 */
public class QuickSork {
	public static void main(String args[]){
		int[] a = {1, 3, 3, 4, 5,20,7};
		quickSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) 
			System.out.println(a[i]);
	}
	// ��ȡ�ؼ��ֵ�λ��
	private static int getMiddle(int arr[], int low, int high) {
		int temp = arr[low];// ����ĵ�һ����Ϊ����
		while (low < high) {
			while (low < high && arr[high] >= temp) {
				high--;
			}
			arr[low] = arr[high];// ������С���ƶ����Ͷ�
			
			while (low < high && arr[low] < temp) {
				low ++;
			}
			arr[high] = arr[low]; // ���������ƶ����ұ�
		}
		arr[low] = temp; // ����ŵ�����λ����
		return low;
	}
	
	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int middle = getMiddle(arr, low, high);
			// �ݹ����е�λ
			quickSort(arr, low, middle -1);
			quickSort(arr, middle + 1, high);
		}
	}
}
