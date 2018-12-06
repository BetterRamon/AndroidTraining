package com.betterramon.arithmetic;
/**
 * 
 * @author meng.li
 * ʹ�õ�������һ������ƽ����
 */
public class CalculateRoot {
	private static final int LOOP_LIMIT = 100;
	/**
	 * 
	 * @param a ����ƽ��������
	 * @param eps ����
	 * @return
	 */
	public double clRoot(double a, double eps) {
		double xi = a/2.0;//��ʼֵ�� a ��һ�룬����ѡ��
		double xt;
		int count = 0;
		do{
			xt = xi;
			xi = (xt + (a/xt))/2.0;
			count++; //���ڼ���Ƿ������ļ�����
			if(count >= LOOP_LIMIT){
				return -1;//����������ʧ��
			}
		}while(Math.abs(xi - xt) > eps);//����ֵС�ھ�����ѭ������
		return xi;
	}
}
