package com.li.ramon.list;

public class QueueTest {

	public static void main(String[] args) {
		// ˳�����
		ArrayQueue<Integer> arrayQueue= new ArrayQueue<Integer>();
		arrayQueue.join(3);
		arrayQueue.join(4);
		arrayQueue.join(5);
		arrayQueue.join(6);
		
		System.out.println(arrayQueue.toString());
		arrayQueue.poll();
		arrayQueue.poll();
		System.out.println(arrayQueue.toString());
		System.out.println("invoke peek : " + arrayQueue.peek());
		
		// ��ʽ����
		LinkQueue<Integer> linkQueue = new LinkQueue<Integer>();
		linkQueue.join(1);
		linkQueue.join(2);
		linkQueue.join(3);
		System.out.println(linkQueue.toString());
		System.out.println("poll: " + linkQueue.poll()); // �Ƚ��ȳ�
		System.out.println(linkQueue.toString());
		
		// ѭ������
		LoopQueue<String> queue = new LoopQueue<String>("aaa", 3);
		// �������Ԫ��
		queue.add("bbb");
		queue.add("ccc");
		System.out.println(queue.toString());
		// ɾ��һ��Ԫ��
		queue.remove();
		System.out.println(queue.toString());
		
	}

}
