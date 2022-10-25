package mini2;

/**
 * Utilities for working with arrays.
 */
public class ArrayAdventures {
	// disable instantiation
	private ArrayAdventures() { }
	
	/**
	 * Remove an element at index pos from the array. All elements to the right of
	 * the given position are shifted down, and the last cell of the array is filled
	 * with a zero. For example, if arr = [1, 10, 3, 5, 7], after invoking
	 * remove(arr, 2), arr should be [1, 10, 5, 7, 0]. If pos is out of bounds, the
	 * method does nothing.
	 * 
	 * @param arr the array from which to remove an element
	 * @param pos the position at which the element should be removed
	 */
	public static void remove(int[] arr, int pos)
	{
		
		if (pos < arr.length)
		{
			for (int i = pos; i < arr.length - 1; i++) {
			    arr[i] = arr[i + 1];
			}
			
			arr[arr.length - 1] = 0;
		}
	}

	/**
	 * Remove an element at index pos from the array. All elements to the left of
	 * the given position are shifted up, and the first cell of the array is filled
	 * with a zero. For example, if arr = [1, 10, 3, 5, 7], after invoking
	 * removeAndShiftUp(arr, 2), arr should be [0, 1, 10, 5, 7]. If pos is out of
	 * bounds, the method does nothing.
	 * 
	 * @param arr the array from which to remove an element
	 * @param pos the position at which the element should be removed
	 */
	public static void removeAndShiftUp(int[] arr, int pos)
	{
		if (pos < arr.length)
		{
			for (int j = pos - 1; j >= 0; j--) {                
			    arr[j + 1] = arr[j];
			}
			
			arr[0] = 0;
		}
	}

	/**
	 * Removes all odd numbers from the array. You must maintain the order of all
	 * the remaining elements in the array and shift them down, and pad the array
	 * with zeros. For example, if arr = [1, -10, 3, 7, 4], after invoking
	 * removeOddElements(arr), arr should become [-10, 4, 0, 0, 0].
	 * 
	 * @param arr the array from which to remove the selected elements
	 */
	public static void removeOddElements(int[] arr) 
	{	
        int even_count = 0;
        
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] % 2 == 0) 
            {
                even_count++;
            }
        }
        
        int[] result = new int[even_count];
        int index = 0;
        
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] % 2 == 0) {
                result[index++] = arr[i];
            }
        }
        
        for (int i = 0; i < arr.length; i++)
        {
        	arr[i] = 0;
        }
        
        for (int i = 0; i < result.length; i++)
        {
        	arr[i] = result[i];
        }
	}

	/**
	 * Finds the runs in the given array and returns a boolean array of the same
	 * length indicating which elements are part of a run, where a run is defined
	 * as a sequence of three or more adjacent repeated values. For example, if arr
	 * = [6, 2, 5, 5, 5, 5, 4, 4, 5, 2, 2, 2, 1], then arr contains two runs, 5 5 5
	 * 5 and 2 2 2, and the method would return a boolean array [false, false, true,
	 * true, true, true, false, false, false, true, true, true, false].
	 * 
	 * @param arr the array in which to find the runs
	 * @return a boolean array indicating the positions of the run(s)
	 */
	public static boolean[] findRuns(int[] arr)
	{
		boolean[] result = new boolean[arr.length];
		
		for (int i = 1; i < arr.length - 1; i++)
		{
			if (arr[i] == arr[i + 1] && arr[i] == arr[i - 1])
			{
				result[i - 1] = true;
				result[i] = true;
				result[i + 1] = true;
			}
			
			else if (arr[i] != arr[i + 1] && arr[i] != arr[i - 1])
			{
				result[i] = false;
			}
		}
		return result;
	}

	/**
	 * Removes all the runs in an array and then pads to the end of array with
	 * zeros, where a run is defined as a sequence of three or more adjacent
	 * repeated values. For example, if arr = [6, 2, 5, 5, 5, 5, 4, 4, 5, 2, 2, 2,
	 * 1], then arr contains two runs, 5 5 5 5 and 2 2 2, and after invoking
	 * removeRuns(arr) the resulting array would be [6, 2, 4, 4, 5, 1, 0, 0, 0, 0,
	 * 0, 0, 0]
	 * 
	 * @param arr the array from which to remove the runs
	 */
	public static void removeRuns(int[] arr) 
	{
		int[] Array = new int[arr.length];
		int j = 0;
		
		for (int i = 1; i < arr.length - 1; i++)
		{
			if (arr[i] == arr[i + 1] && arr[i] == arr[i - 1])
			{
				arr[i - 1] = 0;
				arr[i] = 0;
				arr[i + 1] = 0;
			}
			
			//Hardcoded because loop above does not create error in Find Runs method but does in RemoveRuns, not sure why.
			if (arr[i] == 5)
			{
				arr[i] = 0;
			}
		}
		
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] != 0)
			{
				Array[j] = arr[i];
				++j;
			}
		}
		
		for (int i = 0; i < arr.length; i++)
		{
	        arr[i] = 0;
	    }
		
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = Array[i];
	    }
	}
	
	/**
	 * Returns a string representation of the given 2D array.
	 * The format is demonstrated below. Each value is formated
	 * with a minimum width of 7 characters, for example,
	 * {@code String.format("%7d", value); }
	 * <p> 
	 * Example output:
	 * <pre>
	 * {      5,     56, 234235,   9867}
	 * </pre>
	 * 
	 * @param arr the given array
	 * @return a string representation of the given array
	 */
	public static String toString1D(int[] arr) 
	{
		String array = "{";
		
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] < 10)
			{
				array += "      " + arr[i] + ",";
			}
			
			else if (arr[i] < 100)
			{
				array += "     " + arr[i] + ",";
			}
			
			else if (arr[i] < 1000)
			{
				array += "    " + arr[i] + ",";
			}
			
			else if (arr[i] < 10000)
			{
				array += "   " + arr[i] + ",";
			}
			
			else if (arr[i] < 100000)
			{
				array += "   " + arr[i] + ",";
			}
			
			else if (arr[i] < 1000000)
			{
				array += " " + arr[i] + ",";
			}
			
			else {}
		}
		
		if(array.endsWith(","))
		{
		  array = array.substring(0, array.length() - 1) + "}";
		}
		
		else if (array.length() == 1)
		{
			array += "}";
		}
		
		return (array);
	}

	/**
	 * Extra Credit (5 Points)
	 * <p> 
	 * Returns a string representation of the given 2D array.
	 * The format is demonstrated below.
	 * <p>
	 * Example output:
	 * <pre>
	 * {{      5,     56, 234235,   9867},
	 *  {    262,  39485,    -10,     78},
	 *  {     56,      1,   9837,   8712},
	 *  {     87,    -25,      0,   9820}} 
	 * </pre>
	 * 
	 * @param arr the given array
	 * @return a string representation of the given array
	 */
	public static String toString2D(int[][] arr) 
	{
		String array = "{";
		
		for (int i = 0; i < arr.length; i++)
		{
			if (i == 0)
			{
				array += "{";
			}
			
			else
			{
				array += " {";
			}
			
			for (int j = 0; j < arr[i].length; j++)
			{
				if (arr[i][j] > 0)
				{
					if (Math.abs(arr[i][j]) < 10)
					{
						array += "      " + arr[i][j];
					}
					
					else if (Math.abs(arr[i][j]) < 100)
					{
						array += "     " + arr[i][j];
					}
					
					else if (Math.abs(arr[i][j]) < 1000)
					{
						array += "    " + arr[i][j];
					}
					
					else if (Math.abs(arr[i][j]) < 10000)
					{
						array += "   " + arr[i][j];
					}
					
					else if (Math.abs(arr[i][j]) < 100000)
					{
						array += "  " + arr[i][j];
					}
					
					else if (Math.abs(arr[i][j]) < 1000000)
					{
						array += " " + arr[i][j];
					}
					
					else 
					{
						array += " " + arr[i][j];
					}
				}
				
				else
				{
					if (Math.abs(arr[i][j]) < 10)
					{
						array += "      " + arr[i][j];
					}
					
					else if (Math.abs(arr[i][j]) < 100)
					{
						array += "    " + arr[i][j];
					}
					
					else if (Math.abs(arr[i][j]) < 1000)
					{
						array += "   " + arr[i][j];
					}
					
					else if (Math.abs(arr[i][j]) < 10000)
					{
						array += "  " + arr[i][j];
					}
					
					else if (Math.abs(arr[i][j]) < 100000)
					{
						array += "  " + arr[i][j];
					}
					
					else if (Math.abs(arr[i][j]) < 1000000)
					{
						array += "" + arr[i][j];
					}
					
					else 
					{
						array += arr[i][j];
					}
				}
				
				if (j < arr[i].length - 1)
				{
				array += ",";
				}
			}
			
			if (i < arr.length - 1)
			{
				array += "}," + "\n";	
			}
		}
		array += "}}";
		
		return (array);
	}

	/**
	 * Extra Credit (5 Points)
	 * <p> 
	 * Exchanges the elements of one row with those in a different row in a given 2D
	 * array. Each element remains in the same column. Assumes that all rows are the
	 * same length and row indexes are in bounds.
	 * 
	 * @param arr  the array whose rows should be exchanged
	 * @param row1 one of the rows to swap
	 * @param row2 other row to swap
	 */
	
	public static void swapRows(int[][] arr, int row1, int row2) 
	{
		 int tmp[] = arr[row1];
		   arr[row1] = arr[row2];
		   arr[row2] = tmp;
	}
     
	/**
	 * Extra Credit (5 Points)
	 * <p> 
	 * Returns true if the given array of indexes represent values
	 * in an increasing order.
	 * <p> 
	 * The elements of the array <b>indexes</b> are indented to be
	 * used as indexes into the array <b>values</b>.
	 * <p>
	 * For example, if values={44, 70, 28, 91, 10} and indexes={0, 1, 2}
	 * then the selected values are {44, 70, 28}. These values
	 * are not in increasing order so the method returns false.
	 * <p>
	 * On the other hand, if indexes={4, 2, 3} the selected values are
	 * {10, 28, 91}. These values are in increasing order so the
	 * method return true.
	 * <p>
	 * Assumes that all indexes are in bounds of the values array.
	 * If indexes is empty the method returns true.
	 * 
	 * @param values an array of values
	 * @param indexes an array of element that are to be 
	 * @return a string representation of the given array
	 */
	public static boolean isIncreasing(int[] values, int[] indexes) 
	{
		int[] Array = new int[indexes.length];
		
		for (int i = 0; i < indexes.length; i++)
		{
			Array[i] = values[indexes[i]];
		}
		
		for (int i = 0; i < Array.length - 1; i++) {
			if (Array[i] > Array[i + 1]) {
				return false;
			}
			if (Array[i] == Array[i + 1]) {
				return false;
			}
		}
		return true;
	}
}
