package com.li.ramon.list;

import java.io.Serializable;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class LinkStack<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private class Node {
		private T data;// ����ڵ������
		private Node next; // ָ���¸���������
		
		public Node() {
			
		}
		
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private Node top;// ������ջ��ջ��Ԫ��
	private int size = 0;// ������ջ���Ѱ����Ľڵ�������ջ�ĳ���
	
	public LinkStack() {
		top = null;
	}
	
	public LinkStack(T element) {
		top = new Node(element, null);
		size++;
	}
	
	// ջ�ĳ���
	public int size() {
		return size;
	}
	
	// ��ջ
	public void push(T element) {
		// ע������Ĳ��� top���൱�ڰѵ�ǰ�� top.next ָ����һ�� top
		top = new Node(element, top);
		size++;
	}
	
	// ��ջ
	public T pop() {
		if( top != null) {
			Node oldTop = top;
			top = top.next;
			oldTop.next = null;// �ͷ������õ�Ԫ��
			size--;
			return oldTop.data;
		} else {
			return null;
		}
	}
	
	// ����ջ��Ԫ��
	public T peek() {
		return top.data;
	}
	
	// �ж�˳��ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return size == 0;
	}
	
	// ��ӡջ��Ϣ
	public String toString() {
		// ����ջΪ����ջʱ
		if (isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (Node current = top; current != null; current = current.next) {
				sb.append(current.data + ", ");
			}
			int len = sb.length();
			return sb.delete(len -2 , len).append("]").toString();
		}
	}
}
