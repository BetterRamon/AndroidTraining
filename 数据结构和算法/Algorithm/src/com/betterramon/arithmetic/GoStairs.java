package com.betterramon.arithmetic;

/**
 * @author limeng
 * �� 100 ��¥�ݣ�ÿ��ֻ���� 1 ������ �� 2 �����ж������߷�
 * ������ 
 * ������ n ��̨�ף��� n ����ǰ�� 1������Ҫ�� n -1 ��̨���߷�
 * �� n ����ǰ�� 2 ������Ҫ�� n -2 ��̨�׵��߷�
 * ���� f(n) = f(n-1) + f(n-2)
 *
 */
public class GoStairs {
	// �ݹ��㷨ʵ��
	public static int goStairs(int n) {
		if(n ==1) {
			return 1;
		} else if(n == 2) {
			return 2;
		} else {
			return goStairs(n -1) + goStairs(n -2);
		}
	}
	
    // �ǵݹ��㷨ʵ�� 
	// https://blog.csdn.net/mlkiller/article/details/38422245
	public static int goStairs2(int n) {
		int a0 = 1;
		int a1 = 1;
		int a2 = 1;
		for (int i = 2; i <= n; i++ ) {
			a2 = a0 + a1;
			a0 = a1;
			a1 = a2;
		}
		return a2;
	}
}
