package lab8;

public class IntListTest {

	   public static void main(String[] args) {
	      
	      IntListSorted list1 = new IntListSorted();
	      
//	      list1.add(7);
//	      list1.add(3);
//	      list1.add(8);
	      list1.add(2);
	      list1.add(1);
	      list1.add(9);
	      list1.add(10);
	      System.out.println(list1);
	      System.out.println("Size: " + list1.size());
	      System.out.println("Min: " + list1.getMinimum());
	      System.out.println("Max: " + list1.getMaximum());
	      System.out.println("Median: " + list1.getMedian());
	   }
	}