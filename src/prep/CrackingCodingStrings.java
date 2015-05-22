package prep;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Queue;

public class CrackingCodingStrings {
	static boolean perm(String a, String b) {
		if (a.length() != b.length())
			return false;
		
		char[] chart = a.toCharArray();
		Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
		for (char c : chart) {
			int val = hash.get((int) c) == null ? 0 : hash.get((int) c);
			hash.put((int) c, val++);
		}
		
		chart = b.toCharArray();
		for (char c : chart) {
			int val = hash.get((int) c);
			hash.put((int) c, val--);
		}
		Enumeration<Integer> e = hash.elements();
		while(e.hasMoreElements()) {
			if (e.nextElement() != 0)
				return false;
		}
		return true;
	}
	
	static String trimSpace(String s, int trueLen) {
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				c = shiftback2(c, i);
				c[i] = '%';
				c[i+1] = '2';
				c[i+2] = '0';
				i= i+2;
			}
		}
		return String.valueOf(c);
	}
	
	static char[] shiftback2(char[] c, int start) {
		return shiftback(shiftback(c, start), start);
	}
	
	static char[] shiftback(char[] c, int start) {
		for (int i = c.length-1; i > start; i--) {
			c[i] = c[i-1];
		}
		return c;
	}
	
	static String comp (String s) {
		char[] c = s.toCharArray();
		StringBuffer buf = new StringBuffer();
		
		int i = 0;
		int j = 0;
		int count = 0;
		while (j < c.length) {
			while (i < c.length && c[i] == c[j]) {
				count ++;
				i ++;
			}
			buf.append(c[j]);
			buf.append(count);
			count = 0;
			j = i;
		}
		String ret = buf.toString();
		return ret.length() <= s.length() ? ret : s;
	}
}
