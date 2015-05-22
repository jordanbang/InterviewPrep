package prep;

import java.io.Console;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Arrays;
import java.util.logging.ConsoleHandler;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Stack<Integer> s = new Stack<Integer>();
//		for (int i = 0; i < 10; i++) {
//			s.push((int) (Math.random()*10));
//		}
//		System.out.print(s);
//		sortStack(s);
//		System.out.print(s.peek());
//		System.out.print(s);
		
		int a = (int) (Math.random()*100);
		int b = (int) (Math.random()*100);
		
		int array[] = {1,5,6,4};
		Arrays.sort(array);
		
//		System.out.print("a: " + a + "\n");
//		System.out.print("b: " + b + "\n");
		a = a+b;
		b = a-b;
		a = a-b;
//		System.out.print("a: " + a + "\n");
//		System.out.print("b: " + b + "\n");
		StringBuilder sb = new StringBuilder();
		System.out.print(sb.toString().length());
		
	}
	
	static void sortStack(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		while (!s1.isEmpty()) {
			if (s2.isEmpty() || s1.peek() <= s2.peek()) {
				s2.push(s1.pop());
			} else {
				int tmp = s1.pop();
				while(!s2.isEmpty() && tmp > s2.peek()) {
					s1.push(s2.pop());
				}
				s2.push(tmp);
			}
		}
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
}
