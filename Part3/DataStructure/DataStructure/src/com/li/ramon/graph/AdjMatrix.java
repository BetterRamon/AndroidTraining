package com.li.ramon.graph;

import java.util.Scanner;

//��Ȩ�ڽӾ���
public class AdjMatrix {
	private static final int MaxVertices = 100; // ������ 100 ������
	private static final int MAXWEIGHT = 32767; // ���ڽ�ʱΪ32767�������ʱ�� "��"

	public int[] Vertices = new int[MaxVertices]; // ������Ϣ������
	public int[][] Edge = new int[MaxVertices][MaxVertices]; // �ߵ�Ȩ��Ϣ������
	public int numV; // ��ǰ�Ķ�����
	public int numE; // ��ǰ�ı���

	void CreateGraph(AdjMatrix G) //ͼ�����ɺ���
    {
        int n,e,vi,vj,w,i,j;
        
        Scanner sc = new Scanner(System.in);
        System.out.printf("������ͼ�Ķ�����");
        n = sc.nextInt();
        System.out.printf("������ͼ�ı���");
        e = sc.nextInt();
        G.numV = n;
        G.numE = e;
        for(i = 0;i < n;i++) //ͼ�ĳ�ʼ��
            for(j = 0;j < n;j++)
                {
                if(i == j)
                    G.Edge[i][j] = 0;
                else
                    G.Edge[i][j] = 32767;
                }
        for(i = 0;i < G.numV;i++) //���������������
        {
            System.out.printf("�������" + (i+1) +"���������Ϣ(����):");
            G.Vertices[i] = sc.nextInt();
        }
        System.out.println();

        for(i = 0;i < G.numE;i++)
        {
            System.out.println("������ߵ���Ϣi,j,w(�Ի��зָ�):");
            vi = sc.nextInt();
            vj = sc.nextInt();
            w = sc.nextInt();
            //��Ϊ����Ȩֵ��ͼ����w����1
            //��Ϊ��Ȩֵ��ͼ����w�����ӦȨֵ

            G.Edge[vi-1][vj-1]=w;//��
            G.Edge[vj-1][vi-1]=w;//��
            //����ͼ���жԳ��ԵĹ��ɣ�ͨ���٢�ʵ��
            //����ͼ���߱������ʣ�����ֻ��Ҫ��
        }
    }

	void DispGraph(AdjMatrix G) // ����ڽӾ������Ϣ
	{
		int i, j;
		System.out.println("\n����������Ϣ�����ͣ�:\n");
		for (i = 0; i < G.numV; i++)
			System.out.printf("%8d", G.Vertices[i]);

		System.out.println("\n����ڽӾ���:\n");
		System.out.printf("\t");
		for (i = 0; i < G.numV; i++)
			System.out.printf("%8d", G.Vertices[i]);

		for (i = 0; i < G.numV; i++) {
			System.out.printf("\n%8d", G.Vertices[i]);
			for (j = 0; j < G.numV; j++) {
				if (G.Edge[i][j] == 32767)
					// ����֮��������ʱȨֵΪĬ�ϵ�32767��������ͼ��һ����"0"��ʾ��������ͼ��һ����"��",����Ϊ�˷���ͳһ���
					// "��"
					System.out.printf("%8s", "��");
				else
					System.out.printf("%8d", G.Edge[i][j]);
			}
			System.out.printf("\n");
		}
	}
	
	public static void main(String args[]){
		AdjMatrix adjMatrix = new AdjMatrix();
		adjMatrix.CreateGraph(adjMatrix);
		adjMatrix.DispGraph(adjMatrix);
	}
}
