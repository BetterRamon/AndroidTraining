package com.li.ramon.list.impls;

import com.li.ramon.list.interfaces.ISeqList;
/**
 * ���Ա��˳��ʵ��
 * @author meng.li
 *
 * @param <T>
 */
public class SeqList<T> implements ISeqList<T> {
	public static final int MAXSIZE = 30;//��ʼ�������С
	
	private T[] data;//����洢����
	private int length;//��ǰ���ݳ���
	
	public SeqList(){
		data = (T[]) new Object[MAXSIZE];
	}
	/**
	 *	����Ԫ��
	 * @param i ��Ҫ�����Ԫ�ص�λ��
	 * @param value ��Ҫ�����Ԫ�ص�ֵ
	 * @return
	 */
	public boolean insertElem(int i, T value) {
		//���Ա�����
		if(length == MAXSIZE){
			System.out.println("�����Ա��Ѿ�����");
			return false;
		}
		//����λ�ò��ڷ�Χ��
		if(i < 1 || i > MAXSIZE){
			System.out.println("�����λ�ò��ڷ�Χ��");
			return false;
		}
		//�����λ�ò��ڱ�β,��Ҫ��Ԫ�غ����ڳ�λ��
		if(i < length){
			for(int j = length;j >= i;j--){
				data[j] = data[j-1];
			}
		}
		//�����λ�ô��ڵ�ǰ length ���ȣ����뵽ĩβ
		if(i >= length){
			i = length +1;
		}
		//���Ա��Ǵ�1��ʼ���������Ǵ�0��ʼ�����Բ�������λ��Ϊi-1
		data[i-1] = value;
		length ++;
		return true;
	}
	
	/**
	 *  ��ȡԪ��
	 * @param i ��Ҫ��õ�Ԫ�ص��±�
	 * @return
	 */
	public T getElem(int i) {
		if(i < 1 || i > MAXSIZE){
			return null;
		}
		return data[i-1];
	}

	/**
	 * ɾ��Ԫ��
	 * @param i ��Ҫɾ����Ԫ�ص��±�
	 * @return
	 */
	public T deleteElem(int i) {
		//���Ա�Ϊ��
		if(length == 0){
			System.out.println("���Ա�Ϊ��");
			return null;
		}
		//ɾ�������ݲ��ڷ�Χ��
		if(i < 1 || i> length){
			System.out.println("ɾ�������ݲ��ڷ�Χ��");
			return null;
		}
		T t = data[i-1];
		//������ɾ��λ��ǰ��
		for(int j = i;j < length;j++){
			data[j-1] = data[j];
		}
		length--;
		return t;
	}
	public T[] getData() {
		return data;
	}
	public void setData(T[] data) {
		this.data = data;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		if(length < 0 || length > MAXSIZE){
			System.out.println("���Ȳ��Ϸ�");
		}
		this.length = length;
	}

}
