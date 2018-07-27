package com.mak;

import java.util.Scanner;

class UserMainCode {
	public static boolean checkTripplets(int a[])	{
		if(a.length<0)
			return false;
		int flag=0;
		int prev=a[0];
		for(int i=1;i<a.length;i++) {
			if(a[i]==prev) {
				flag++;
				if(flag==2)
					return true;
			}
			else {
				prev=a[i];	
				flag=0;
			}
		}
		return false;
	}
}

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Values: ");
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		System.out.println(UserMainCode.checkTripplets(a));
		sc.close();
	}
}