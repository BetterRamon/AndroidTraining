package com.betterramon.arithmetic;

import java.util.ArrayList;

import com.betterramon.model.Merchandise;

/**
 * ��һ������������ܳ�������Ϊ C=150 ����Ʒ�� ������ 7 ����Ʒ����Ʒ���ָܷ�������С���� ���Ϊ 1~7�������ֱ���
 * wi=[35��30��60��50��40��10��25]�� ��ֵ�ֱ��� pi=[10��40��30��50��35��40��30]�� ���ڴ��� 7
 * ����Ʒ��ѡ��һ������װ�뱳���� Ҫ������Ʒ������������ C ��ǰ���£���װ�����Ʒ�ܼ�ֵ��ߡ�
 * 
 * @author meng.li
 * 
 */
public class KnapsackProblem {
	ArrayList<Merchandise> objs; // ��ѡ�����б�
	int totalC;// �����ܳ���

	public KnapsackProblem(ArrayList<Merchandise> objs, int totalC) {
		this.objs = objs;
		this.totalC = totalC;
	}
	
	/**
	 * 
	 * @param problem �������ⶨ�壺������������������ԣ�һ���ǿ�ѡ��Ʒ�б���һ���Ǳ����ܵĳ�������
	 * @param ploy ѡ����һ������
	 */
	public void greedyAlgo(KnapsackProblem problem, int ploy) {
		int idx;
		int ntc = 0;

		// Choosefunc ÿ��ѡ����ϲ��Ե��Ǹ���Ʒ��ѡ���ټ���Ƿ���
		while ((idx = choosefunc(objs, ploy)) != -1) {
			// ��ѡ��Ʒ�Ƿ����㱳������Ҫ��
			if ((ntc + objs.get(idx).weight) <= totalC) {
				objs.get(idx).status = 1;
				ntc += objs.get(idx).weight;
				System.out.print((idx + 1) + " ");
			} else {
				// �����ˣ�����ѡ�����Ʒ�ˣ�������Ǻ�����ѡ
				objs.get(idx).status = 2;
			}
		}
	}

	/**
	 * ̰���㷨ѡ�����
	 * 
	 * @param objs ��ѡ�����б�
	 * @param ploy ѡ�����
	 * @return ���ϵ�ǰ���Ե��±�
	 */
	int choosefunc(ArrayList<Merchandise> objs, int ploy) {
		int index = -1; // -1��ʾ������������
		switch (ploy) {
		case 0: // ̰������1�� ÿ����ѡ���ֵ������Ʒ
			int maximumPrice = 0;
			for (int i = 0; i < objs.size(); i++) {
				if ((objs.get(i).status == 0) && (objs.get(i).price > maximumPrice)) {
					maximumPrice = objs.get(i).price;
					index = i;
				}
			}
			break;
		case 1://̰������2: ÿ��ѡ�������������Ʒ
			int mininumWeight = Integer.MAX_VALUE;
			for (int i = 0; i < objs.size(); i++) {
				if ((objs.get(i).status == 0) && (objs.get(i).weight < mininumWeight)) {
					mininumWeight = objs.get(i).weight;
					index = i;
				}
			}
			break;
		case 2://̰������3��ÿ��ѡ���ֵ�ܶ�������Ʒ
			float maxmumDesityPrice = 0;
			for (int i = 0; i < objs.size(); i++) {
				if (objs.get(i).status == 0){
					//�����ֵ�ܶ�,����ע���������ͣ���Ҫ������תΪfloat�������û��С��λ
					float tempDesityPrice = (float)objs.get(i).price/objs.get(i).weight;
					if(tempDesityPrice > maxmumDesityPrice) {
						maxmumDesityPrice = tempDesityPrice;
						index = i;
					}
				}
			}
			break;
		default:
			break;
		}
		return index;
	}
}
