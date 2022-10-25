package lab9;

public class MaxArray {
    public static void main(String[] args) 
    {
       int[] array = {1, 323, 530, 199, 4, 251, 5, 0, -15, 77};

       System.out.println(arraySum(array));
    }

    public static int arraySum(int[] arr) 
    {
        return max(arr, 0, arr.length - 1);
    }

    private static int max(int[] arr, int start, int end) 
    {
        if (start == end) 
        {
            return arr[start];
        } 
        
        else 
        {
            int middle = (start + end) / 2;
            
            int leftMax = max(arr, start, middle);
            int rightMax = max(arr, middle + 1, end);
            
            return (Math.max(leftMax, rightMax));
        }
    }
}