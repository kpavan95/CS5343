package com.lectures;

public class Lec0826 {

	public static void main(String args[]) {
		
//		Array Reversal
//		String[] arr = "abcdefgh".split(""); 
//		reverseArray(arr,0,arr.length-1);
//		for(String s: arr) {
//			System.out.print(s);
//		}
		
		
//		Powers of a number
//		int x = 2, n=30;
//		long currentTime = System.currentTimeMillis();
//		System.out.println(powerOofN(x,n));
//		long firstTime = System.currentTimeMillis();
//		System.out.println(firstTime - currentTime);
//		System.out.println(powerOofLogN(x,n));
//		long secondTime = System.currentTimeMillis();
//		System.out.println(secondTime - firstTime);
		
		
//		fibonacci O(2ˆn)
//		int x = 3;
//		int val = fibonacci(x);
//		System.out.print(val);
		
//		GCD log(n)
//		int x = 10, y=3;
//		int val = gcd(x,y);
//		System.out.print(val);
		
//		Prime O(n)
//		int b,n=14;
//		b=  isPrime(n,2);
//		System.out.println(b);
		
//		Palindrome
//		String str[] = new String[]{"d","a","d", "a", "d"};
//		System.out.println(isPalindrome(str,0, str.length-1));

	}
	
	static boolean isPalindrome(String str[], int i, int n) {
		if(i>=n) {
			return true;
		} else if(str[i]==str[n]) {
			return isPalindrome(str, ++i, --n);	
		} else {
			return false;
		}
	}
	
	static int isPrime(int n, int i) {
		if(i>=n) {
			return 1;
		} else if(n%i==0) {
			return 0;
		}else {
			return isPrime(n, i+1);
		}
	}
	
	static int gcd(int x,int y) {
		if(x%y==0) {
			return y;
		} else {
			return gcd(x, x%y);
		}
	}
	
	static int fibonacci(int x) {
		if(x==0) {
			return 0;
		} else if (x==1) {
			return 1;
		} else {
			return 1 + fibonacci(x-1)+fibonacci(x-2);
		}
	}
	
	static long powerOofLogN(int x, int n) {
		if (n==0) {
			return 1;
		} else if(n%2==0) {
			long val = powerOofLogN(x, n/2);
			return val*val;
		} else {
			long val = powerOofLogN(x, (n-1)/2);
			return x*val*val;
		}
	}
	
	static int powerOofN(int x,int n) {
		return (n==0)?1:x*powerOofN(x, n-1);
		
	}
	
	static void reverseArray(String[] arr, int i, int j) {
		if(i<j) {
			String c = arr[i];
			arr[i] = arr[j];
			arr[j] = c;
			reverseArray(arr, i+1,j-1);
		}
	}
}
