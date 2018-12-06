package com.betterramon.arithmetic;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 
 * @author meng.li
 *	�ַ���ȫ��������
 */

public class Permutation {
	private void swap(int[] chList, int pos1, int pos2) {
	    if (pos1 != pos2)
	    {
	        int tmp = chList[pos1]; 
	        chList[pos1] = chList[pos2];
	        chList[pos2] = tmp;
	    }
	}

	//���ַ���[begin, end]������Ӵ�ȫ����
	public void permutation(int[] chList, int begin, int end)
	{
	    if (begin == end)//��ʣһ���ַ��ˣ�����Ҫ�����ˣ�ֱ�������ǰ�Ľ��
	    {
	        System.out.println(Arrays.toString(chList));
	    }

	    for (int i = begin; i < end; i++)
	    {
	    	swap(chList, begin, i); //�ѵ�i���ַ�����beginλ�ã���begin+1λ�ÿ����µ��Ӵ���ʼ
	    	permutation(chList, begin + 1, end); //���������
	        swap(chList, begin, i); //����ѡ��һ���̶��ַ�֮ǰ����Ҫ������
	    }
	}
}
