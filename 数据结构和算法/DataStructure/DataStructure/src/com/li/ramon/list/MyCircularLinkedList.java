package com.li.ramon.list;

/**
 * ѭ��������
 * @author limeng
 *
 */
public class MyCircularLinkedList<E> {
	private Entry<E> header = new Entry<E>(null); //ͷ���
	public int size = 0; // ��ǰ�ߴ�
	
	//���캯������ʼ��������
	public MyCircularLinkedList() {
		// ��ʼ��ѭ������ͷ���� next ָ��ָ�� header
		header.next = header;
	}
	
	/**
	 * ���Ԫ��
	 * @param e
	 */
	public void add(E e) {
		Entry temp = header;
	    while (temp.next != header) {
	        temp = temp.next;
	    }
	    Entry addEntry = new Entry(e); 
	    temp.next = addEntry;
	    addEntry.next = header;
	    size++;
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
            while (temp.next != header) {
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
            while (temp != header) {
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
	 * ����������
	 */
	public void display() {
		Entry temp = header.next;
		while(temp.next != header) {
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
