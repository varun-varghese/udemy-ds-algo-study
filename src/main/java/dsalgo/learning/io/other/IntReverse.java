package dsalgo.learning.io.other;

import java.util.Stack;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
public class IntReverse {
	
	public int reverse(int input) {
		if (input == 0) {
			return input;
		} else {
			Stack<Integer> intStack = new Stack<Integer>();
			
			int modInput = input < 0 ? -1 * input : input;
			while (modInput > 0) {
				int carry = modInput % 10;
				intStack.push(carry);
				modInput = modInput / 10;
				//log.info("| modInput:{}, carry:{}", modInput, carry);
			}
			
			//log.info("| intStack:{}", intStack);
			
			int result = 0;
			int tenthsPow = 0;
			while (!intStack.empty()) {
				double zeroes = Math.pow(10, tenthsPow);
				int topOfStack = intStack.pop();
				result += (zeroes * topOfStack);
				//log.info("| tenthsPow:{}, zeroes:{}, topOfStack:{}, result:{}", tenthsPow, zeroes, topOfStack, result);
				tenthsPow++;
			}
			
			return input < 0 ? (-1 * result) : result;
		}
	}
	
	public int reverse2(int input) {
		boolean isNegative = input < 0;
		
		if (isNegative) {
			input = -1 * input;
		}
		
		int reverse = 0;
		while (input > 0)  {
			int lastDigit  = input % 10;
			reverse = (reverse * 10) + lastDigit;
			input = input / 10;
		}
		
		return isNegative ? (-1 * reverse) : reverse;
	}

}
