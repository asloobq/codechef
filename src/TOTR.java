import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TOTR {
	//5 qwertyuiopasdfghjklzxcvbnm
	private static final String ALPHABET_UPP = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String ALPHABET_LOW = "abcdefghijklmnopqrstuvwxyz";
	private static String KEY_LOW, KEY_UPP;
	public static void main(String[] args) {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int testCases;
		
		try {
			String line = br.readLine();
			testCases = Integer.parseInt(line.substring(0, line.indexOf(" ")));
			KEY_LOW = line.substring(line.indexOf(" ")+1);
			KEY_UPP = KEY_LOW.toUpperCase();
//			System.out.println("test=" + testCases);
//			System.out.println("key=" + key);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		for(int testCount = 0;testCount < testCases; testCount++) {
			try {
				String code = br.readLine();
				System.out.println(decode(code));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static String decode(final String code) {
		StringBuffer decoded = new StringBuffer("");
		//go letter by letter
		for(int index=0; index < code.length(); index++) {
			//get current letter
			char c = code.charAt(index);
			
			//find index of letter in key
			int alphaIndex = ALPHABET_LOW.indexOf(c);						
			if(alphaIndex != -1) {
				decoded.append(KEY_LOW.charAt(alphaIndex));
			} else {
				alphaIndex = ALPHABET_UPP.indexOf(c);
				if(alphaIndex != -1) {
					decoded.append(KEY_UPP.charAt(alphaIndex));
				} else if(c == '_'){
					decoded.append(' ');
				} else {
					decoded.append(c);
				}
			}
		}
		return decoded.toString();
	}

}
