package com.betterramon.model;

/**
 * 0-1 ������������Ʒ�����ݽṹ
 * @author meng.li
 *
 */
public class Merchandise {
	public int weight;	//����
	public int price;	//��ֵ
	public int status;	//0:δѡ�У�1:��ѡ�У�2:�Ѿ�����ѡ
	
	public Merchandise(int weight, int price, int status){
		this.weight = weight;
		this.price = price;
		this.status = status;
	}
}
