package com.li.ramon.list;

/***
 * ������Ļ�������
 * @author limeng
 * @param <E>
 */
public class MySinglyLinkedList<E> {
	private Entry<E> header = new Entry<E>(null); //ͷ���
	private int size = 0; // ��ǰ�ߴ�
	
	//���캯������ʼ��������
	public MySinglyLinkedList() {

	}
	
	/**
	 * ���Ԫ��
	 * @param e
	 */
	public void add(E e) {
		Entry temp = header;
	    while (temp.next != null) {
	        temp = temp.next;
	    }
	    temp.next = new Entry(e);
	    size++;
	}

	/**
	 * ��ָ��λ�ò���Ԫ��
	 * @param index
	 * @param e
	 */
	public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Add element failed,the index is out of bounds. index = " + index);
        } else {
        	Entry temp = header; // temp ��ʱ��㣬���� header ͷ���
            int counter = 0; //��¼���Ǳ������ĸ�λ����
            while (temp != null) {
            	/* index ���� counter��˵����������Ҫ�����λ�� 
            	 * ���� ��ǰ index Ϊ 0 ��һ��ѭ�� index ���� counter
            	 *    ���ʱ��Ҫ��Ԫ�� e ���뵽 0 λ��
            	 *    1. ����������Ҫ���浱ǰԪ�ص���һ����㣬Ҳ����  back ����
            	 *    2. �ѵ�ǰ���� next ָ�� ʹ�� e �����Ķ��� entry���½��
            	 *    3. �½�� entry �� next ָ�����Ǹղű���� back ���������������������������
            	 *    4. size ++
            	 */
                if (index == counter) {
                    Entry entry = new Entry(e);
                    Entry back = temp.next;
                    temp.next = entry;
                    entry.next = back;
                    size++;
                }
                temp = temp.next;
                counter++;
            }
        }
    }
	
	/**
	 * ��ȡԪ�ص�ֵ
	 * @param index
	 * @return
	 */
	public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Get element failed,the index is out of bounds. index = " + index);
        } else {
            //ʹ�� temp ������,�� 0 ��Ԫ��Ӧ���� header ����һ��Ԫ��
            Entry temp = header.next;
            //counter ��������
            int counter = 0;
            while (temp != null) {
                if (counter == index) {
                    return (E) temp.element;
                }
                temp = temp.next;
                counter++;
            }
        }
        return null;
    }
	
	/**
	 * ɾ��Ԫ��
	 * @param ind
	 */
	public void delete(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Delete element,the index is out of bounds. index = " + index);
        } else {
            Entry temp = header;
            int counter = 0;
            while (temp != null) {
                //�� index ǰ��Ľڵ�ָ�� index ����Ľڵ�
                if (index == counter) {
                    temp.next = temp.next.next;
                    size--;
                }
                counter++;
                temp = temp.next;
            }
        }
    }

	/**
	 * ����������
	 */
	public void display() {
		Entry temp = header.next;
		while(temp != null) {
			System.out.print(temp.element + " " );
			temp = temp.next;
		}
	}

	// ������Ľ�� Node������ʹ�÷��ͣ�ʹ�������չ��
	private static class Entry<E> {
		E element; // data Ԫ��
		Entry<E> next; // ָ����һ������ָ��

		@SuppressWarnings("unused")
		Entry(E element) {
			this.element = element;
		}
	}
}
