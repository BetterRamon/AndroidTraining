package com.betterramon.arithmetic;
/**
 * 
 * @author meng.li
 * ���η�˼��ʵ�ֶ��ֲ���
 */
public class BinarySearch {
	//�ݹ�ʵ��
	public int binarySearch(int[] arr, int target, int low, int high) {
		if(low > high)
			return -1;
		int middle = (high + low)/2;
		if(arr[middle] == target)
			return middle;
		if(arr[middle] < target){
			return binarySearch(arr, target, middle + 1, high);
		}else {
			return binarySearch(arr, target, low, middle -1);
		}
	}
	
	//�ǵݹ�ʵ��
	public int binarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length;
		while(low <= high){
			int middle = (low + high)/2;
			if(arr[middle] ==target )
				return middle;
			if(target > arr[middle]){
				low = middle + 1;
			}else {
				high = middle -1;
			}
		}
		return -1;
	}
}
