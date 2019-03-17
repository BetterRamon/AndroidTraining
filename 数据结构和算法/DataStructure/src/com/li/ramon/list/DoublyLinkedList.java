package com.li.ramon.list;

/**
 * ˫������
 * @author limeng
 *
 */
public class DoublyLinkedList<E> {
	private Entry<E> head = new Entry<E>(null); //ͷ���
	private Entry<E> tail = new Entry<E>(null); //ͷ���
	private int size = 0;
	
	// ��ʼ��˫������
	public DoublyLinkedList() {
		// ��һ���ܹؼ����� head �� prior ָ��ָ��գ� tail �� next ָ��ָ���
		head.prior = null;
		tail.next = null;
		// ��ͷ���ָ��β���
		head.next = tail;
		// ��β���ָ��ͷ���
		tail.prior = head;
	}
	
	// �ж������Ƿ�Ϊ��
	public boolean isDoublyLinedListEmpty() {
		if(head.next == tail) {
			return true;
		}
		return false;
	}
	
	// β�巨������һ�����
	public void insertFromTail(E e) {
		// �������
		Entry<E> data = new Entry<E>(e);

		tail.prior.next = data;
		data.prior = tail.prior;
		data.next = tail;
		tail.prior = data;
		size++;
	}
	
	// ͷ���룬��ͷ������һ�����
	public void insertFromHead(E e) {
		// �������
		Entry<E> data = new Entry<E>(e);
		
		head.next.prior = data;
		data.next = head.next;
		data.prior = head;
		head.next = data;
		size++;
	}
	
	// ɾ�� index λ�õ�Ԫ��
	public E deleteAtIndex(int index) {
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("Delete element,the index is out of bounds. index = " + index);
		} else {
			int counter = 0;
			Entry<E> temp = head.next;
			while(temp != tail) {
				if(index == counter) {
					// ɾ��Ԫ��
					temp.prior.next = temp.next;
					temp.next.prior = temp.prior;
					E data = temp.element;
					temp = null;
					return data;
				}
				counter ++;
				temp = temp.next;
			}
			return null;
		}
	}
	
	// ��ӡ˫������
	public void print() {
		if(isDoublyLinedListEmpty()) {
			System.out.println("˫������Ϊ�գ�");
		}
		Entry<E> temp = head.next;
		while(temp != tail) {
			System.out.print(temp.element + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	// ��ȡָ�� index ��Ԫ��
	public E getElementByIndex(int index) {
		if(index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("Delete element,the index is out of bounds. index = " + index);
		}
		int counter = 0;
		Entry<E> temp = head.next;
		while(counter < index) {
			temp = temp.next;
			counter++;
		}
		return temp.element;
	}
	
	// ��ȡ����� size
	public int getSize() {
		return size;
	}
	
	// ˫������Ľ�� Node������ʹ�÷��ͣ�ʹ�������չ��
	private static class Entry<E> {
		E element; // data Ԫ��
		Entry<E> prior;// ָ��ǰһ������ָ��
		Entry<E> next; // ָ����һ������ָ��

		@SuppressWarnings("unused")
		Entry(E element) {
			this.element = element;
		}
	}
}
