package com.li.ramon.list;

import java.io.Serializable;

import org.w3c.dom.Node;

/**
 * ѭ������
 * @author meng.li
 *
 */
public class LoopQueue<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int DEFAULT_SIZE = 10;
	private int capacity;// ��������ĳ���
	private Object[] elementData;// ����һ���������ڱ���ѭ�����е�Ԫ��
	private int front = 0;// ��ͷ
	private int rear = 0;// ��β
	
	/**
	 * ��Ĭ�����鳤�ȹ�����ѭ������
	 */
	public LoopQueue() {
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	
	/**
	 * ��һ��Ԫ��������ѭ������
	 * @param element
	 */
	public LoopQueue(T element) {
		this();
		elementData[0] = element;
		rear++;
	}
	
	/**
	 * ��ָ������������ѭ������
	 * @param element
	 * @param initSize
	 */
	public LoopQueue(T element, int initSize) {
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		rear++;
	}
	
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		// ѭ�����п��� front ���� rear
		return rear > front ? rear - front : capacity - (front - rear);
	}
	
	/**
	 * �������
	 * @param element
	 */
	public void add(T element) {
		if (rear == front && elementData[front] != null) {
			throw new IndexOutOfBoundsException("the queue is full");
		}
		elementData[rear++] = element;
		// ��� rear �Ѿ���ͷ����תͷ
		rear = rear == capacity ? 0 : rear;
	}
	
	/**
	 * �Ƴ�����
	 * @return
	 */
	public T remove() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("empty queue exception.");
		}
		// �������� front ��Ԫ�ص�ֵ
		T value = (T)elementData[front];
		// �ͷŶ��� front �˵�Ԫ��
		elementData[front++] = null;
		// ��� front �Ѿ���ͷ���Ǿ�תͷ
		front = front == capacity ? 0 : front;
		return value;
	}
	
	/**
	 * ���ض���ջ��Ԫ�أ���ɾ��Ԫ��
	 * @return
	 */
	public T element() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("empty queue exception");
		}
		return (T)elementData[front];
	}

	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return rear == front && elementData[rear] == null;// rear ���� front ������������
	}
	
	/**
	 * ���ѭ������
	 */
	public String toString() {
		if (isEmpty()) {
			return "[]";
		} else {
			// ��� front < rear,��ЧԪ�ؾ��� front �� rear ֮���Ԫ��
			if (front < rear) {
				StringBuilder sb = new StringBuilder("[");
				for (int i = front; i < rear; i ++) {
					sb.append(elementData[i] + ", ");
				}
				int len = sb.length();
				return sb.delete(len -2, len).append("]").toString();
			}
			// ��� front >= rear����ЧԪ��Ϊ front �� capacity ֮�䣬 0 - rear ��Ԫ��
			else {
				StringBuilder sb = new StringBuilder("[");
				for (int i = front; i < capacity; i ++) {
					sb.append(elementData[i] + ", ");
				}
				for (int j = 0; j < rear; j++) {
					sb.append(elementData[j] + ", ");
				}
				int len = sb.length();
				return sb.delete(len -2, len).append("]").toString();
			}
		}
	}
}
