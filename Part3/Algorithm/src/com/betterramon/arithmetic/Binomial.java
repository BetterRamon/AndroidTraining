package com.betterramon.arithmetic;

import com.betterramon.model.Item;

/**
 * ��: n �ζ���ʽ��չ����ʽ
 * @author meng.li
 *
 */
public class Binomial {
	// ��ѧ��ʽ��ģ
	public Item[] calculateModulus(int n) {
		Item[] items = new Item[n+1];

		if (n == 0) {
			items[0] = new Item();
			items[0].c = 1;
			items[0].am = 0;
			items[0].bm = 0;
			return items;
		}
		// �ӵ�1�׿�ʼ���Ƶ���n��
		for (int i = 1; i <= n; i++) {
			int nc = i + 1; // ÿһ�׵�����,����������ǣ�n + 1
			// ĩ�� ϵ��Ϊ 1��am �� bm ��һ���Ǵ� n �� 0 �ݼ���һ���Ǵ� 0 �� n ������
			items[nc -1] = new Item();
			items[nc - 1].c = 1;// ĩ��
			items[nc - 1].am = 0;
			items[nc - 1].bm = i;
			// ���ŵ��Ƶ�2���n-1���ֵ��ʵ���±귶Χ��[1, nc-2],����Ҫ����Ĵ洢�ռ�ת��items����
			for (int j = nc - 2; j > 0; j--) {
				int c = items[j].c + items[j - 1].c;
				items[j].c = c;
				items[j].am = i - j;
				items[j].bm = j;
			}
			items[0] = new Item();
			items[0].c = 1;// ����
			items[0].am = i;
			items[0].bm = 0;
		}
		return items;
	}
}
