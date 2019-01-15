package com.li.ramon.list;

/**
 * ���Ա��˳���ʾ��ʵ��
 * 
 * @author meng.li
 * @param <T>
 */
public class MyArrayList<T> {

	private static final int DEFAULT_CAPACITY = 10;// Ĭ������

	private Object[] elementData;// �����洢���ݵ�����
	private int size;// ���Ա���
	private int maxSize;// ����Ĵ�С

	// �޲ι��캯��
	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	// ���г�ʼ�����Ĺ��캯��
	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: "
					+ initialCapacity);
		this.maxSize = initialCapacity;
		this.elementData = new Object[maxSize];
	}

	// ����������ȡ��ӦԪ��
	public T getElem(int index) {
		if (index < 0 || index >= size)
			return null;
		// ����ȡֵ
		return (T) elementData[index];
	}

	// ����������������
	public boolean insertElem(int index, T element) {
		if (index < 0) {
			System.out.println("�����±겻��С�� 0 ");
			return false;
		}
		if (index > size) {
			System.out.println("��ǰ���Ա��СΪ�� " + size + " �±겻�ܳ��� " + size);
			return false;
		}
		// ȷ����������
		ensureCapacity();
		// ���뵽ĩβ�Ĵ���
		if (index == size) {
			elementData[index] = element;
			size++;
			return true;
		}
		// ���뵽�м䣬��Ҫ�ƶ�Ԫ��
		for (int j = size; j > index; j--) {
			elementData[j] = elementData[j - 1];
		}

		// ��������
		elementData[index] = element;
		size++;
		return true;
	}

	// ɾ����Ӧ������Ԫ��
	public T removeElem(int index) {
		if (size == 0) {
			System.out.println("��ǰ���Ա�Ϊ�գ�����ɾ��");
			return null;
		}
		if (index < 0 || index >= size) {
			System.out.println("ɾ��λ�ò��ڷ�Χ��");
			return null;
		}
		T delVal = (T) elementData[index];
		// �Ƴ�����
		elementData[index] = null;
		// ĩβ�Ĵ���,ɾ���������һλ
		if (index == size - 1) {
			size--;
			return delVal;
		}
		// һ������Ĵ���,ɾ�������м�Ԫ�أ�������Ҫǰ��
		for (int j = index; j < size - 1; j++) {
			elementData[j] = elementData[j + 1];
		}
		// ���һλ�ÿ�
		elementData[size - 1] = null;
		size--;
		return delVal;
	}

	// ȷ�������Ƿ���
	private void ensureCapacity() {
		Object[] newArrs;
		if (size == maxSize) {
			System.out.println("\n�����Ѿ�����,����������");
			// ����Ϊԭ���� 1.5 ��
			maxSize = maxSize + (maxSize >> 1);
			newArrs = new Object[maxSize];
			for (int j = 0; j < size; j++) {
				newArrs[j] = elementData[j];
			}
			elementData = newArrs;
			System.out.println("���ݺ�Ĵ�СΪ��" + maxSize);
		}
	}

	// չʾ���ǵ����Ա�����
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.print(" " + elementData[i]);
		}
		System.out.println();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
}
