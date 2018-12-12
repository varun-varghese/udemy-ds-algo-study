package dsalgo.learning.io.algo;

import java.util.HashMap;
import java.util.Map;

public class Fib {
	
	private Map<Integer, Integer> mem;
	
	public Fib() {
		mem = new HashMap<Integer, Integer>();
	}
	
	// formulae: f(n -1) + f(n - 2)
	// 1, 1, 2, 3, 5, 8, 13...
	public int fibNaive(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibNaive(n - 1) + fibNaive(n - 2);
		}
	}
	
	public int fibMemoize(int n) {
		if (mem.containsKey(n)) {
			return mem.get(n);
		} else {
			if (n <= 0) {
				mem.put(0, 0);
				return 0;
			} else if (n == 1) {
				mem.put(1, 1);
				return 1;
			} else {
				int fib = fibMemoize(n - 1) + fibMemoize(n - 2);
				mem.put(n, fib);
				return fib;
			}
		}
	}

}
