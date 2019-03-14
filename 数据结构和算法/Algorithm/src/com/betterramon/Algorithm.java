package com.betterramon;

import java.util.ArrayList;

import com.betterramon.arithmetic.*;
import com.betterramon.model.Item;
import com.betterramon.model.Merchandise;


public class Algorithm {
	 public static void main(String args[]){
		 /*//����1��˭��С͵
		 WhoIsThief whoIsThief = new WhoIsThief();
		 whoIsThief.isThief();
		 
		 Binomial dataModel = new Binomial();
		 //����2����� (16 + 5) * (16 + 5)
		 int result = 0;
		 Item items[] = dataModel.calculateModulus(2);
		 for(int i = 0; i < items.length; i ++){
			 result += items[i].c * Math.pow(16, items[i].am)*Math.pow(5, items[i].bm);
		 }
		 System.out.println(result);
		 
		 //����3��0-1 �������⣬̰���㷨
		 //�����ֱ��� wi=[35��30��60��50��40��10��25]
		 //��ֵ�ֱ��� pi=[10��40��30��50��35��40��30]
		 ArrayList<Merchandise> objs = new ArrayList<Merchandise>();
		 objs.add(new Merchandise(35, 10, 0));
		 objs.add(new Merchandise(30, 40, 0));
		 objs.add(new Merchandise(60, 30, 0));
		 objs.add(new Merchandise(50, 50, 0));
		 objs.add(new Merchandise(40, 35, 0));
		 objs.add(new Merchandise(10, 40, 0));
		 objs.add(new Merchandise(25, 30, 0));
		 KnapsackProblem  knapsackProblem = new KnapsackProblem(objs, 150);
		 //knapsackProblem.greedyAlgo(knapsackProblem, 0);
		 //knapsackProblem.greedyAlgo(knapsackProblem, 1);
		 knapsackProblem.greedyAlgo(knapsackProblem, 2);*/
		 
		 /*//����4�� �ַ���ȫ�������⣬���η�
		 Permutation  permutation= new Permutation();
		 int [] chList = {1,2,3};
		 permutation.permutation(chList, 0, chList.length);
		 
		 //����5�� ���ַ����ң����η�
		 BinarySearch binarySearch = new BinarySearch();
		 int[] arr = {1,6,23,56,80,100,300,500,1000,4322};
		 int index = binarySearch.binarySearch(arr, 500, 0, arr.length);
		 System.out.println("�ݹ�ʵ�� index = " + index);
		 int index2 = binarySearch.binarySearch(arr, 4322);
		 System.out.println("�ǵݹ�ʵ�� index2 = " + index2);
		 
		 //���� 6�� ��������һ������ƽ����
		 CalculateRoot calculateRoot = new CalculateRoot();
		 System.out.println(calculateRoot.clRoot(9.0, 0.0001));
		 
		 //����7����̬�滮���������������
		 DpLcs dpLcs = new DpLcs();
		 String str1 = "abcdefgh";
		 String str2 = "abdfh";
		 int maxLength = dpLcs.dPLcs(str1, str2, new int[str1.length()+1][str2.length()+1]);
		 System.out.println("Max length is " + maxLength);*/
		 
		 //����8�� ��Ǯ������
		 /*new BuyChickens().buyChickens();
		 new BuyChickens().chickensAndRabbits();*/
		 
		 //����9�� ��¥������
		 System.out.println("�߷�: " + GoStairs.goStairs2(4));
	 }
}
