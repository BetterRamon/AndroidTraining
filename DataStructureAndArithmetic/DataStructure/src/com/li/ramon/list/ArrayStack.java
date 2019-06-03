package com.li.ramon.list;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * @author limeng
 *	ջ��˳��ʵ�֣���������
 */
public class ArrayStack<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_SIZE = 12;
	
	private T[] mArray;// ����һ���������ڱ���˳��ջ��Ԫ��
	
	private int count;// ��¼ջ��Ԫ�صĸ���
	
	public ArrayStack(Class<T> type) {
		this(type, DEFAULT_SIZE);
	}
	
	public ArrayStack(Class<T> type, int size) {
		// ����ֱ�ӵ��� mArray = new T[DEFAULT_SIZE]
		mArray = (T[]) Array.newInstance(type, size);
		count = 0;
	}
	
	// �� val ��ӵ�ջ
	public void push(T val) {
		// ��ǰ���ȼ� 1���жϳ����Ƿ��㹻
		ensureCapacity(count + 1);
		mArray[count++] = val;
	}
	
	// ����ջ��Ԫ��ֵ
	public T peek() {
		if(!isEmpty()) {
			return mArray[count -1];
		} else {
			return null;
		}
	}
	
	// ����ջ��Ԫ�أ���ɾ��ջ��Ԫ��
	public T pop() {
		if(!isEmpty()) {
			T ret = mArray[count -1];
			// �ͷ�ջ��Ԫ��
			mArray[--count] = null;
			return ret;
		} else {
			return null;
		}
	}
	
	// ����ջ�Ĵ�С
	public int size() {
		return count;
	}
	
	// ����ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return size() ==0;
	}
	
	// ��ӡջ
	public void printArrayStack() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
		}
		System.out.printf("stack size() = %d",size());
		
		int i = size() -1;
		while (i >= 0) {
			System.out.println(mArray[i]);
			i--;
		}
	}
	
	// ���˳��ջ
	public void clear() {
		// ���ײ���������Ԫ�ظ�Ϊ null
		Arrays.fill(mArray, null);
		count = 0;
	}
	private void ensureCapacity(int minCapcity) {
		// ��������ԭ�г���С��Ŀǰ����ĳ���
		int oldCapcity = mArray.length;
		if (minCapcity > oldCapcity) {
			int newCapcity = (oldCapcity * 3) / 2 +1;
			// ���������鲢��ԭ�������ݸ��ƹ�ȥ
			mArray = Arrays.copyOf(mArray, newCapcity);
		}
	}
}
