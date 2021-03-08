package com.li.ramon.list;

import java.io.Serializable;
/**
 * ��ʽ����
 * @author meng.li
 *
 * @param <T>
 */
public class LinkQueue<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// ����һ���ڲ��� Node��Node ʵ��������ʽ���еĽڵ�
	
	private class Node {
		private T data;// ����ڵ�����
		private Node next;// ָ���¸��ڵ������
		
		// �޲ι��캯��
		public Node() {
			
		}
		
		// ��ʼ���������ԵĹ�����
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node front;// ����ö��е�ͷ�ڵ�
	private Node rear;// ����ö��е�β�ڵ�
	private int size;// ����ö������Ѱ����Ľڵ���
	
	// ����������
	public LinkQueue() {
		front = null;
		rear = null;
	}
	
	/**
	 * ��ָ������Ԫ�س�ʼ�������У���������ֻ��һ��Ԫ��
	 * @param element
	 */
	public LinkQueue(T element) {
		front = new Node(element, null);
		// ֻ��һ���ڵ㣬 front �� rear ��ִ��ýڵ�
		rear = front;
		size++;
	}
	
	/**
	 * 
	 * @return �������ӵĴ�С
	 */
	public int size() {
		return size;
	}
	
	public void join(T element) {
		// ��������ǿն���
		if (front == null) {
			front = new Node(element, null);
			rear = front;// ֻ��һ���ڵ㣬ָ��ͬһ��
		} else {
			Node newNode = new Node(element, null);// �����½ڵ�
			rear.next = newNode;// ��β�ڵ�� next ָ�������Ľڵ�
			rear = newNode;// ���½ڵ���Ϊ�µ�β�ڵ�
		}
		size++;
	}
	
	/**
	 * ���Ӳ�������ɾ��Ԫ��
	 * @return
	 */
	public T poll() {
		Node oldFront = front;
		front = front.next;
		oldFront.next = null;
		size--;
		return oldFront.data;
	}
	
	/**
	 * ���ض��ж���Ԫ�أ����ǲ�ɾ���ڵ�
	 * @return
	 */
	public T peek() {
		return front.data;
	}
	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * ��ն���
	 */
	public void clear() {
		// �� front��rear �����ڵ���Ϊ��
		front = null;
		rear = null;
		size = 0;
	}
	
	public String toString() {
		// ��ʽ����Ϊ��ʱ
		if (isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (Node current = front; current != null; current = current.next) {
				sb.append(current.data + ", ");
			}
			int len = sb.length();
			return sb.delete(len -2, len).append("]").toString();
		}
	}

}
