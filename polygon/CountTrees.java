// package com.harish.test;

import com.harish.polygon.Point;
import com.harish.polygon.Polygon;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class CountTrees
{
	public static void main(String[] args)
	{
		countTrees();
	}

	public static void countTrees()
	{
		int minX=Integer.MAX_VALUE,maxX=Integer.MIN_VALUE,minY=Integer.MAX_VALUE,maxY=Integer.MIN_VALUE;

		Polygon polygon =null;
		Polygon.Builder builder=Polygon.Builder();


		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N no of sides of polygon");
		int N=sc.nextInt();
	
		

		for(int i=1;i<=N;i++){
			System.out.println("Enter (x,y) cordinate of "+i+"th side");
			int x=sc.nextInt();
			minX=min(minX,x);
			maxX=max(maxX,x);

			//System.out.println("Enter y cordinate "+i+"th side");
			int y=sc.nextInt();
			minY=min(minY,y);
			maxY=max(maxY,y);
			builder=builder.addVertex(new Point(x,y));
		}
		polygon=builder.build();

		System.out.println("Enter a");
		int a=sc.nextInt();
		System.out.println("Enter b");
		int b=sc.nextInt();
		System.out.println("Enter c");
		int c=sc.nextInt();
		System.out.println("Enter d");
		int d=sc.nextInt();
		System.out.println("Enter F0");
		int f0=sc.nextInt();
		System.out.println("Enter F1");
		int f1=sc.nextInt();
		System.out.println("Enter F2");
		int f2=sc.nextInt();
		System.out.println("Enter F3");
		int f3=sc.nextInt();

		UtilityClass uc=new UtilityClass(a,b,c,d,f0,f1,f2,f3);
		// System.out.println(" minx "+minX+" maxx "+maxX+" miny "+minY+" maxy "+maxY);
		for(int i=minX;i<=maxX;i++){
			for(int j=minY;j<=maxY;j++){
				if(isInside(polygon,new Point(i,j))){
					
					uc.addTree(i,j);
				}
			}
		}
		System.out.println("Total no of trees="+uc.totalTrees());
	}
	
	/**
	 * Check if point inside the polygon
	 * 
	 * @param polygon
	 * @param point
	 */
	private static boolean isInside(Polygon polygon, Point point)
	{
		boolean contains = polygon.contains(point);
		// System.out.println("The point:" + point.toString() + " is " + (contains ? "" : "not ") + "inside the polygon");
		return contains;
	}
		static int min(int a,int b){
			if(a<b)
				return a;
			return b;
		}
		static int max(int a,int b){
			if(a>b)
				return a;
			return b;
		}

}


class UtilityClass{
	public int a,b,c,d,f0,f1,f2,f3,f4;
	public UtilityClass(int a,int b,int c, int d, int f0, int f1, int f2, int f3){
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.f0=f0;
		this.f1=f1;
		this.f2=f2;
		this.f3=f3;
	}

	 Hashtable<Integer,Integer> array=new Hashtable<Integer,Integer>();  

	void addItem(int key,int value)
	{
		if(!array.containsKey(new Integer(key)))
			array.put(new Integer(key),new Integer(value));
	}

	void addTree(int x,int y){
		this.addItem((x+y),this.calculateValue(x+y));
	}

	int calculateValue(int xysum){
		 if(xysum<4){
			return this.baseSum(xysum);
		}else if(array.containsKey(new Integer(xysum))){
			return array.get(new Integer(xysum)).intValue();
		}
		else{
			int sum=this.a*this.calculateValue(xysum-1)+this.b*this.calculateValue(xysum-2)+this.c*this.calculateValue(xysum-3)+this.d*this.calculateValue(xysum-4);
			return sum;
		}
	}
	int baseSum(int sum){
		if(sum==0)
			return this.f0;
		if(sum==1)
			return this.f1;
		if(sum==2)
			return this.f2;
		if(sum==3)
			return this.f3;
		return 0;
	}

	int totalTrees(){
		int sum=0;
		for(Map.Entry m:array.entrySet()){  
		   // System.out.println(m.getKey()+" "+m.getValue());  
			int a=(int)m.getValue();
		   sum+=a;
		  }  
		return sum;
	}

}

