package com.li.ramon.list;

import java.io.Serializable;
import java.util.Arrays;

/**
 * ˳�����
 * @author limeng
 *
 */
public class ArrayQueue<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int DEFAULT_SIZE = 10;
	
	private int capacity;// �������鳤��
	
	private Object[] elementData;// ����һ���������ڱ���˳�����Ԫ��
	
	private int count = 0;// ���д�С
	
	// ��Ĭ�����鳤�ȴ�����˳�����
	public ArrayQueue() {
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	
	// ��һ����ʼ��Ԫ�ش�������
	public ArrayQueue(T element) {
		this();
		elementData[0] = element;
		count++;
	}
	
	// ��ָ�����ȳ�ʼ������
	public ArrayQueue(int initSize) {
		elementData = new Object[initSize];
	}
	
	/**
	 * ��ָ�����ȵ�����������˳�����
	 * @param element ָ��˳����еĵ�һ��Ԫ��
	 * @param initSize ָ��˳����еײ�����ĳ���
	 */
	public ArrayQueue(T element, int initSize) {
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		count++;
	}
	
	/**
	 * size
	 * @return ����˳����еĴ�С
	 */
	public int size() {
		return count;
	}
	
	/**
	 * ���
	 * @param element
	 */
	public void join(T element) {
		ensureCapacity(count + 1);
		elementData[count++] = element; // ��ʹ�� count ��ֵ��Ȼ����ִ�� ++ ����
	}
	
	private void ensureCapacity(int minCapacity) {
		// ��������ԭ�г���С��Ŀǰ����ĳ���
		int oldCapacity = elementData.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
	
	/**
	 * poll
	 * @return ���Ӳ�ɾ��Ԫ��
	 */
	public T poll() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("the queue is empty");
		}
		// ȡ������ֵ
		T value = (T) elementData[0];
		count--;
		for (int i = 1; i <= count; i++) {
			elementData[i-1] = elementData[i];// ����Ԫ����ǰ�ƶ�һλ
		}
		return value;
	}
	
	/**
	 * peek
	 * @return ���ض���Ԫ�أ����ǲ�ɾ������Ԫ��
	 */
	public T peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("the queue is empty");
		}
		return (T)elementData[0];
	}
	
	/**
	 * ˳�����Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return 0 == count;
	}
	
	public void clear() {
		// ������Ԫ�ظ�ֵΪ null
		Arrays.fill(elementData, null);
		count = 0;
	}
	
	public String toString() {
		if (isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (int i = 0; i < count; i++) {
				sb.append((T)elementData[i] + ", ");
			}
			int len = sb.length();
			return sb.delete(len -2, len).append("]").toString();
		}
	}
}
