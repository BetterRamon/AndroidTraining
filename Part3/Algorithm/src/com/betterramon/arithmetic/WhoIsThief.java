package com.betterramon.arithmetic;

/**
 * ���� ����ץ�� A��B��C��D �����ﷸ������һ����С͵����Ѷ��ʱ��
	A˵�����Ҳ���С͵���� x !=0
	B˵����C ��С͵���� x = 2
	C˵����С͵�϶��� D���� x = 3 
	D˵����C ����ԩ���ˡ��� x != 3
	�����Ѿ�֪���ĸ�����������˵�����滰��һ����˵�˼ٻ������ж�һ�µ���˭��С͵��
 * @author meng.li
 *
 */
public class WhoIsThief {
	// �����������ֻ�
	public void isThief() {
		for (int x = 0; x < 4; x++) {
			int dis_a = (x != 0) ? 1 : 0;// A is not thief
			int dis_b = (x == 2) ? 1 : 0;// C is thief
			int dis_c = (x == 3) ? 1 : 0;// D is thief
			int dis_d = 1 - dis_c; // C is lying
			if ((dis_a + dis_b + dis_c + dis_d) == 3) {
				char thief = (char) ('A' + x);
				System.out.println(thief + " is thief");
				break;
			}

		}
	}
}
