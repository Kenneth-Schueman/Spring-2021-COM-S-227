package lab9;

public class Mason {
	
	public static void main(String[] args) 
	{	
		System.out.println(countPatterns(5));
	}

	public static int countPatterns(int n) 
	{
		int numPatterns = 0;
		
		if (n == 1 || n == 2) 
		{
			return (1 + numPatterns);
		} 
		if (n == 3)
		{
			return (2 + numPatterns);
		}
		else
		{
			numPatterns += 4;
			countPatterns(n -3);
		}
		
		return (numPatterns);
	}
}

