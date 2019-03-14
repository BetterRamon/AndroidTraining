package com.li.ramon.list;
/**
 * ջ��Ӧ��
 * @author limeng
 *
 */
public class ArrayStackTest {

	public static void main(String[] args) {
		ArrayStackTest myArrayStackTest = new ArrayStackTest();
		// �� 6  ת��Ϊ 2 ����
		System.out.println(myArrayStackTest.conversion(10000, 2));
		System.out.println("LinkStack test: " + myArrayStackTest.conversionByLinkStack(10, 2));
		// �б༭
		System.out.println(myArrayStackTest.lineEdit("abcd#dsa@fafda#fdafa#k9"));
		// ����ƥ��
		System.out.println(myArrayStackTest.isMatch("[[([]([])()[])]]"));
	}

	/**ջ��Ӧ�� 1: ����ת��
	 * �� 10 ����������ת��Ϊ n ����
	 */
	private String conversion(int num, int n) {
		ArrayStack<Integer> myStack = new ArrayStack<Integer>(Integer.class);
		Integer result = num;
		while(true) {
			// ��������ջ
			myStack.push(result % n);
			result = result / n;
			if (result == 0) {
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		// ����ջ˳��������
		while ((result = myStack.pop()) != null) {
			sb.append(result + " ");
		}
		return sb.toString();
	}
	
	/**ջ��Ӧ�� 1: ����ת��,������ʽջ
	 * �� 10 ����������ת��Ϊ n ����
	 */
	private String conversionByLinkStack(int num, int n) {
		LinkStack<Integer> myStack = new LinkStack<Integer>();
		Integer result = num;
		while(true) {
			// ��������ջ
			myStack.push(result % n);
			result = result / n;
			if (result == 0) {
				break;
			}
		}
		System.out.println("Print stack : " + myStack.toString());
		StringBuilder sb = new StringBuilder();
		// ����ջ˳��������
		while ((result = myStack.pop()) != null) {
			sb.append(result + " ");
		}
		return sb.toString();
	}
	
	/**
	 * ջ��Ӧ��2��
	 * �б༭�����������ַ� # ��ʾ�˸�@ ��ʾ֮ǰ������ȫ����Ч
	 */
	private String lineEdit(String input) {
		ArrayStack<Character> myStack = new ArrayStack<Character>(Character.class);
		char[] arr = input.toCharArray();
		for (char c : arr) {
			if (c == '#') {
				myStack.pop();
			} else if(c == '@') {
				myStack.clear();
			} else {
				myStack.push(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		Character temp = null;
		while ((temp = myStack.pop()) != null) {
			sb.append(temp);
		}
		// ��ת�ַ���
		sb.reverse();
		return sb.toString();
	}
	
	/**
	 * ջ��Ӧ��3��
	 * ��������Ƿ�ƥ�� '['��']'�ɶԳ���ʱ�ַ����Ϸ�
	 * ���磺"[][]()"��"[[([]([])()[])]]"�ǺϷ���
	 * "([(])","[())"�ǲ��Ϸ���
	 */
	private boolean isMatch(String str) {
		ArrayStack<Character> myStack = new ArrayStack<Character>(Character.class);
		char[] arr = str.toCharArray();
		for (char c : arr) {
			Character temp = myStack.pop();
			// ���ջΪ�գ��������ַ�����
			if(temp == null) {
				myStack.push(c);
			} else if(temp == '[' && c == ']') {
				// ƥ��ʱ c ����ջ
			} else if(temp == '(' && c == ')') {
				
			} else {// ��ƥ��ʱ�� temp ���룬c û��ƥ���Ҳ��ջ
				myStack.push(temp);
				myStack.push(c);
			}
		}
		return myStack.isEmpty();
	}
}
