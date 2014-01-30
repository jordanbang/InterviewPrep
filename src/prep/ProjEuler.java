package prep;

import java.util.ArrayList;

public class ProjEuler {
	static int sumOfMultiples3and5(int num) {
		int total = 0;
		for (int i = 0; i < num; i++) {
			if (i%3 == 0 || i%5 == 0)
				total+= i;
		}
		return total;
	}
	
	static long sumOfEvenFibLessThan4Mil() {
		int sum = 0;
		int n = 0;
		long fib = fib(n);
		long check = 4000000;
		while (fib < check) {
			if (fib % 2 == 0)
				sum += fib;
			n++;
			fib = fib(n);
		}
		return sum;
	}
	
	static long fib(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fib(n-1) + fib(n-2);
	}
	
	static int largestPrime (long n) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int div = 2;
		for (;n > 1;) {
			if (n%div == 0) {
				factors.add(div);
				n = n/div;
			} else {
				div++;
			}
		}
		
		int max = 1;
		for (int i = 0; i < factors.size(); i++) {
			if (factors.get(i) > max)
				max = factors.get(i);
		}
		
		return max;
	}
	
	static int[] largestPalindrome() {
		int max = 0;
		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (isPalindrome(i*j) && i*j > max) {
					max = i*j;
					num1 = i;
					num2 = j;
				}
			}
		}
		return new int[]{max, num1, num2};
	}
	
	static boolean isPalindrome(int num) {
		char[] anum = String.valueOf(num).toCharArray();
		boolean isPal = true;
		for (int i = 0; i < anum.length/2; i++) {
			if (anum[i] != anum[anum.length-1-i])
				isPal = false;
		}
		return isPal;
	}
	
	static int smallestMultiples(int n) {
		int[] array = new int[n];
		int x = n;
		for (int i = 0; i < n; i++) {
			array[i] = x;
			x--;
		}
		
		for (int i = 0; i < array.length; i++) {
			if (i != -1) {
				for (int j = i+1; j < array.length; j++) {
					if (j != -1 && array[i]%array[j] == 0) {
						array[j] = -1;
					}
				}
			}
		}
		
		int min = 1;
		for (int i = 0; i < array.length; i++) {
			if (i != -1) {
				min = min*i; 
			}
		}
		return min;
		
//		int i = 1;
//		boolean isDivis;
//		do {
//			isDivis = true;
//			for (int j = 1; j < 21 || isDivis; j++) {
//				if (i % j != 0)
//					isDivis = false;
//			}
//			i++;
//		} while (!isDivis);
//		return i;
	}
}
