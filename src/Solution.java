import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution. */
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    	String line = null;
//		try {
//			line = br.readLine();
//		} catch (IOException e) {
//			e.printStackTrace();
//			return;
//		}
//		final int numbers = Integer.parseInt(line.substring(0, line.indexOf(" ")));
//		final int diff = Integer.parseInt(line.substring(line.indexOf(" ")+1));
    	int diff = 0;
    	int numbers = 0;
    	try {
			numbers = nextInt(br);
		
			diff = nextInt(br);
    	} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//			System.out.println("test=" + testCases);
//			System.out.println("key=" + key);
//		try {
//			line = br.readLine();
//		} catch (IOException e) {
//			e.printStackTrace();
//			return;
//		}
		//get all numbers in an array
//		String[] numStrings = line.split(" ");
//		int[] nums = new int[numStrings.length];
    	int[] nums = new int[numbers];
    	int pairCount = 0;
    	int rightIndex;
		for(int index =0; index < numbers; index++) {
//			nums[index] = Integer.parseInt(numStrings[index]);
			try {
				nums[index] = nextInt(br);
				//compare this number with all previous nums
				
				for(rightIndex = index ; rightIndex >= 1; rightIndex--) {
	    			if( Math.abs(nums[index] - nums[rightIndex]) == diff) {
	    				pairCount ++;
	    			}
	    		}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(pairCount);
//		int answer = getPairs(nums, diff);
//		System.out.println(answer);
    }
    
//    private static int getPairs(final int[] nums, final int K) {
//    	/*
//    	 * Most straight forward method.
//    	 * Compare each number with every other number to see if the diff is equal to K
//    	 * */
//    	int pairCount = 0;
//    	int leftIndex;
//    	int rightIndex;
//    	for(leftIndex = 0 ; leftIndex < (nums.length -1) ; leftIndex ++) {
//    		for(rightIndex = leftIndex +1; rightIndex < nums.length ; rightIndex++) {
//    			if( Math.abs(nums[leftIndex] - nums[rightIndex]) == K) {
//    				pairCount ++;
//    			}
//    		}
//    	}
//    	return pairCount;
//    }
    
    /**
     * This method is not written by me. Just using it to make the program run faster.
     * @param in
     * @return
     * @throws IOException
     */
    public static int nextInt(BufferedReader in) throws IOException {
		int c;
		for (;;) {
			c = in.read();
			if (!isWhitespace(c))
				break;
			if (c == -1)
				throw new RuntimeException();
		}

		boolean neg = false;
		int val = 0;
		if (c == '-')
			neg = true;
		else
			val = c - '0';

		for (;;) {
			c = in.read();
			if (isWhitespace(c) || c == -1)
				break;

			val = val * 10 + (c - '0');
		}

		if (neg)
			return -val;

		return val;
	}

	public static boolean isWhitespace(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' ? true : false;
	}
}