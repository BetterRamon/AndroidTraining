package com.betterramon.arithmetic;
/**
 * 
 * @author meng.li
 *һ�ٸ�Ǯ��һ��ֻ�����Ǹ����͵���ٷ�Ӧ�á�
 *����������ÿֻ�󹫼�ֵ 5 ��Ǯ��ÿֻĸ��ֵ 3 ��Ǯ��ÿ 3 ֻС��ֵ 1 ��Ǯ�������� 100 ��Ǯ������ 100 ֻ������������ж����ַ�����
 */

public class BuyChickens {
	public void buyChickens() {
		for(int roosters = 1; roosters <= 20; roosters++) { //���򹫼���100 Ǯ��������20ֻ
			for(int hens = 1; hens <= 33; hens++){ //��ĸ�������ֻ���� 33ֻ 
				int chicks = 100 - roosters - hens;//С���������� 100 ��ȥ ������ĸ������������С�������� 3 �ı���
				if(chicks % 3 == 0 
						&& ((5*roosters + 3 * hens + chicks/3) == 100)){//С�������ǲ��� 3 �ı��������ǵĻ�ֱ�ӽ�����ǰѭ��
					System.out.println("�򹫼� " + roosters + " ֻ��ĸ�� " + hens + " ֻ��С�� " + chicks +" ֻ");
				}
			}
		}
	}
	
	/**
	 * �����⣺ �м�������һ�������У���ͷ�� 50 ��ͷ�����Ź� 120 ֻ�ţ��ʣ������÷ֱ��ж���ֻ��
	 */
	public void chickensAndRabbits() {
		for(int rabbits = 1; rabbits <= 40; rabbits ++) {
			int chickens = 50 - rabbits;
			if((rabbits * 4 + chickens * 2) == 120) {
				System.out.println("������ " + rabbits + " ֻ ������ "+ chickens + " ֻ");
			}
		}
	}
}
