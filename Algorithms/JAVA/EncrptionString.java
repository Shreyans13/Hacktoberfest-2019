// Java implementation of the above approach: 
public class GFG { 

	static final int MAX = 26; 

	// Function to return the encrypted string 
	static String encryptStr(String str, int n, int x) 
	{ 

		// Reduce x because rotation of 
		// length 26 is unnecessary 
		x = x % MAX; 
		char arr[] = str.toCharArray(); 

		// calculate the frequency of characters 
		int freq[] = new int[MAX]; 
		for (int i = 0; i < n; i++) 
			freq[arr[i] - 'a']++; 

		for (int i = 0; i < n; i++) { 

			// If the frequency of current character 
			// is even then increment it by x 
			if (freq[arr[i] - 'a'] % 2 == 0) { 
				int pos = (arr[i] - 'a' + x) % MAX; 
				arr[i] = (char)(pos + 'a'); 
			} 

			// Else decrement it by x 
			else { 
				int pos = (arr[i] - 'a' - x); 
				if (pos < 0) 
					pos += MAX; 
				arr[i] = (char)(pos + 'a'); 
			} 
		} 

		// Return the count 
		return String.valueOf(arr); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		String s = "abcda"; 
		int n = s.length(); 
		int x = 3; 
		System.out.println(encryptStr(s, n, x)); 
	} 
} 
