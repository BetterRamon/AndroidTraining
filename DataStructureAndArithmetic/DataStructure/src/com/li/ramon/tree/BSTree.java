package com.li.ramon.tree;

import java.util.Stack;

/**
 * ���������
 * @author meng.li
 *
 */
public class BSTree<T extends Comparable<T>> {
	
	private BSTNode<T> mRoot;// ���ڵ�

	private class BSTNode<T extends Comparable<T>> {
		T key; // ��ֵ
		BSTNode<T> left; // ����
		BSTNode<T> right;// �Һ���
		BSTNode<T> parent;//���ڵ�
		boolean isFirst;// ����ǵݹ�ʹ��,���� 1
		boolean isVisited;// ����ǵݹ飬���� 2
		
		public BSTNode(T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
			this.key = key;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
	}
	
	// ǰ��������ݹ鷨
	private void preOrder(BSTNode<T> tree) {
		if (tree != null) {
			System.out.print(tree.key + " ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}
	
	public void preOrder() {
		preOrder(mRoot);
		preOrder2(mRoot);
	}
	
	// �ǵݹ�ǰ�����
	private void preOrder2(BSTNode<T> tree) {
		Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
		BSTNode<T> p = tree;
		while(p != null || !stack.empty()) {
			while (p != null) {
				System.out.print(p.key + " ");// ֱ�Ӵ�ӡ
				stack.push(p);// ��ջ
				p = p.left;// ��������
			}
			if (!stack.empty()) {
				p = stack.pop();
				p = p.right;// ����������
			}
		}
	}
	
	// ����������ݹ鷨
	private void inOrder(BSTNode<T> tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.print(tree.key + " ");
			inOrder(tree.right);
		}
	}
	
	// ����������ǵݹ鷨
	private void inOrder2(BSTNode<T> tree) {
		Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
		BSTNode<T> p = tree;
		while(p != null || !stack.empty()) {
			while (p != null) {
				stack.push(p);// ��ջ
				p = p.left;// ��������
			}
			if (!stack.empty()) {
				p = stack.pop();
				System.out.print(p.key + " ");
				p = p.right;// ����������
			}
		}
	}
	
	public void inOrder() {
		inOrder(mRoot);
		inOrder2(mRoot);
	}
	
	// �������
	private void postOrder(BSTNode<T> tree) {
		if (tree != null) {
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.key + " ");
		}
	}
	
	/*
	 * ����������ǵݹ�˼·һ��������һ���P��������ջ��Ȼ������������һֱ����������ֱ��������û�����ӵĽ�㣬
	 * ��ʱ�ý�������ջ�������Ǵ�ʱ���ܽ����ջ�����ʣ�������Һ��ӻ�δ�����ʡ�
	 * ���Խ�����������ͬ�Ĺ������������������ͬ�Ĵ��������������Һ���ʱ��
	 * �ý���ֳ�����ջ������ʱ���Խ����ջ�����ʡ������ͱ�֤����ȷ�ķ���˳��
	 * ���Կ���������������У�ÿ����㶼���γ�����ջ����ֻ���ڵڶ��γ�����ջ��ʱ��
	 * ���ܷ������������Ҫ������һ��������ʶ�ý���Ƿ��ǵ�һ�γ�����ջ����
	 */
	private void postOrder2(BSTNode<T> tree) {
		Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
		BSTNode<T> p = tree;
		BSTNode<T> temp;

		while(p != null || !stack.empty()) {
			while (p != null) {
				p.isFirst = true;
				stack.push(p);// ��ջ
				p = p.left;// ��������
			}
			if (!stack.empty()) {
				temp = stack.pop();
				if (temp.isFirst == true) { // ��ʾ�ǵ�һ�γ�����ջ��
					temp.isFirst = false;
					stack.push(temp); // ��isFirst ��Ϊ false���ٰ����Ž�ȥ
					p = temp.right;// ��ʼ��������������
				} else {// �ڶ��γ�����ջ��
					System.out.print(temp.key + " ");
					p = null; // �����ʹ��ˣ��ÿ�
				}
				
			}
		}
	}
	
	/* ����������ǵݹ鷨��˼·����Ҫ��֤����������Ӻ��Һ��ӷ���֮����ܷ��ʣ�
	 * ��˶�����һ���P���Ƚ�����ջ�����P���������Ӻ��Һ��ӣ������ֱ�ӷ�������
	 * ����P�������ӻ����Һ��ӣ����������Ӻ��Һ��Ӷ��ѱ����ʹ��ˣ�
	 * ��ͬ������ֱ�ӷ��ʸý�㡣�������������������P���Һ��Ӻ�����������ջ��
	 * �����ͱ�֤��ÿ��ȡջ��Ԫ�ص�ʱ���������Һ���ǰ�汻���ʣ�
	 * ���Ӻ��Һ��Ӷ��ڸ����ǰ�汻���ʡ�
	 * 
	 */
	private void postOrder3(BSTNode<T> tree) {
		Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
		BSTNode<T> cur; // ��ǰ�ڵ�
		BSTNode<T> pre = null; // ǰһ�η��ʵĽڵ�
		stack.push(tree); // ���Ƚ��ڵ���ջ
		while(!stack.empty()) {
			cur = stack.peek();
			if ((cur.left == null && cur.right == null) ||
					(pre != null && (pre == cur.left || pre == cur.right))) {
				System.out.print(cur.key + " ");// �����ǰ�ڵ�û�к��ӽڵ���ߺ��ӽڵ��Ѿ���������
				stack.pop();
				pre = cur;
			} else {
				if (cur.right != null)
					stack.push(cur.right);
				if (cur.left != null)
					stack.push(cur.left);
			}
		}
	}
	
	public void postOrder() {
		postOrder(mRoot);
		postOrder2(mRoot);
		postOrder3(mRoot);
	}
	
	/**
	 * �ݹ�ʵ�֣����Ҷ����� x ��ֵ Ϊ key �Ľڵ�
	 */
	private BSTNode<T> search(BSTNode<T> x, T key) {
		if (x == null) {
			return x;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return search(x.left, key);
		else if (cmp > 0)
			return search(x.right, key);
		else 
			return x;
	}
	
	public BSTNode<T> search(T key) {
		return search(mRoot, key);
	}
	
	/**
	 * �ǵݹ���Ҷ����� x ��ֵΪ key �Ľڵ�
	 */
	private BSTNode<T> iterativeSearch(BSTNode<T> x, T key) {
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else 
				return x;
		}
		return x;
	}
	
	public BSTNode<T> iterativeSearch(T key) {
		return iterativeSearch(mRoot, key);
	}
	
	/**
	 * �������ڵ㣺���� tree Ϊ���ڵ�Ķ����������ڵ�
	 */
	private BSTNode<T> maximum(BSTNode<T> tree) {
		if (tree == null) {
			return null;
		}
		while (tree.right != null) {
			tree = tree.right;
		}
		return tree;
	}
	public T maximum() {
		BSTNode<T> b = maximum(mRoot);
		if (b != null)
			return b.key;
		return null;
	}
	
	/**
	 * ������Сֵ������ tree Ϊ���ڵ����Сֵ
	 */
	private BSTNode<T> minmum(BSTNode<T> tree) {
		if (tree == null)
			return null;
		while (tree.left != null) {
			tree = tree.left;
		}
		return tree;
	}
	
	public T minmum() {
		BSTNode<T> p = minmum(mRoot);
		if (p != null)
			return p.key;
		return null;
	}
	
	/**
	 * ���ҽڵ� x ��ǰ���ڵ㡣�������ҡ�������������ֵС�ڸýڵ㲢��ֵ���Ľڵ㡱
	 */
	public BSTNode<T> predecessor(BSTNode<T> x) {
		// ��� x �������ӣ��� x ��ǰ���ڵ�����������Ϊ�������������ڵ�
		if (x.left != null)
			return maximum(x.left);
		
		// ��� x û�����ӣ��� x �����ֿ���
		// 1. x �ǡ�һ���Һ��ӡ����� x ��ǰ���ڵ�Ϊ �����ĸ��ڵ㡹
		// 2. x �ǡ�һ�����ӡ�������� ��x ����͵ĸ��ڵ㣬���Ҹø��ڵ�Ҫ�����Һ��ӡ�
		BSTNode<T> y = x.parent;
		while ((y != null) && (x == y.left)) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * ���� x �ĺ�̽ڵ㣬�������ҡ�����������ֵ���ڸýڵ㲢��ֵ��С�Ľڵ㡱
	 */
	public BSTNode<T> successor(BSTNode<T> x) {
		// ��� x �����Һ��ӣ���x �ĺ�̽ڵ�Ϊ �������Һ���Ϊ������������С�ڵ㡻��
		if (x.right != null) {
			return minmum(x.right);
		}
		// ��� x û���Һ��ӡ��� x �����ֿ���
		// 1. x �� ��һ�����ӡ�����x �ĺ�̽ڵ�Ϊ �����ĸ��ڵ㡻��
		// 2. x �� ��һ���Һ��ӡ�������� ��x ����͵ĸ��ڵ㣬���Ҹø��ڵ�Ҫ�������ӡ�
		BSTNode<T> y = x.parent;
		while ((y != null) && (x == y.right)) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * �����½ڵ�
	 */
	private void insert(BSTree<T> bst, BSTNode<T> z) {
		int cmp;
		BSTNode<T> y = null;
		BSTNode<T> x = bst.mRoot;
		
		// ���� z �Ĳ���λ��
		while (x != null) {
			y = x;
			cmp = z.key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else
				x = x.right;
		}
		
		z.parent = y;
		if (y == null) {
			bst.mRoot = z;// z �ǵ�һ���ڵ�
		} else {
			cmp = z.key.compareTo(y.key); // �ж��ǲ������ӻ��ǲ����Һ���
			if (cmp < 0) 
				y.left = z;
			else
				y.right = z;
		}
	}
	
	// ����ʵ�ֵ������������ͬ��ֵ�Ľڵ�
	public void insert(T key) {
		BSTNode<T> z = new BSTNode<T>(key, null, null, null);
		// ��������ڵ�ʧ�ܣ��򷵻�
		if (z != null)
			insert(this, z);
	}
}
