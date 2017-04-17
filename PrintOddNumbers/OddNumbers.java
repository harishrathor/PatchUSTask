import java.io.*;
import java.util.*;

class OddNumbers{
	void PrintOdds(int n){
		for(int i=1;i<=n;i++){
			if((i%3)==0 && (i%7)!=0){
				System.out.println("1");
				continue;
			}
			if((i%7)==0 && (i%3)!=0){
				System.out.println("0");
				continue;
			}
			if((i%7)==0 && (i%3)==0){
			System.out.println("12");
			}
		}
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the limit:");
		int n=sc.nextInt();
		
		OddNumbers on=new OddNumbers();
		on.PrintOdds(n);
	}
}