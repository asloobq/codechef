import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int testCases;
		try {
			testCases = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		for(int testIndex = 1; testIndex <= testCases; testIndex ++) {
			try {
				String ans = computePi(Integer.parseInt(br.readLine()));
				if(ans.length() > 1) {
					//add a period after 3
				 ans  = "3." + ans.substring(1);
				}
				System.out.println(ans);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static String computePi(final int digits) {
		StringBuffer ans = new StringBuffer("");
		int dividend = 103993;
		final int divisor = 33102;					
		
		//do remaining iterations
		while(ans.length() <= (digits)) {
			if(dividend > divisor) {
				//divide and store result in ans
				
				int quotient = dividend /divisor;
				ans.append(quotient);				
				//find remainder
				dividend = dividend%divisor;
				dividend = dividend * 10;
				//System.out.println("ans = " + ans + "| dividend = " + dividend);
			} 
			else {
				// 
				ans.append(0);
				dividend = dividend * 10;
			}	
		}				
		
		return ans.toString();
	}

}
