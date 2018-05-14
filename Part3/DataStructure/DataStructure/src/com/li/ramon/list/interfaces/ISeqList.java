package com.li.ramon.list.interfaces;
/**
 * ���Ա��˳��洢�ṹ�ӿ�
 * @author meng.li
 * ������������
 * ����һ��Ԫ��
 * ��ȡһ��Ԫ��
 * ɾ��һ��Ԫ��
 */
public interface ISeqList<T> {
	/**
	 * ����Ԫ��
	 * @param i ��Ҫ�����Ԫ�ص�λ��
	 * @param value ��Ҫ�����Ԫ�ص�ֵ
	 * @return
	 */
	public boolean insertElem(int i,T value);
	
	/**
	 * ��ȡԪ��
	 * @param i ��Ҫ��õ�Ԫ�ص��±�
	 * @return
	 */
	public T getElem(int i);
	
	/**
	 * ɾ��Ԫ��
	 * @param i ��Ҫɾ����Ԫ�ص��±�
	 * @return
	 */
	public T deleteElem(int i);
}
