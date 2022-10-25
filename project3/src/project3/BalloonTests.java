package project3;
	import balloon4.Balloon;
	import org.junit.Test;
	import org.junit.Before;
	import static org.junit.Assert.*;

public class BalloonTests {
	private Balloon bb;
    
    @Before
    public void setup() //runs before every test
    {
    	bb = new Balloon(10);
    }
    
    @Test
    public void testInitial() //A new balloon should not be popped
    {
      assertEquals(false, bb.isPopped());
      assertEquals(0, bb.getRadius());
    }

    @Test
    public void testBlow() //Radius should become 10
    {
    bb.blow(5);
    assertEquals(5, bb.getRadius());
    }
    
    @Test
    public void testTwoBlows()
    {
    	bb.blow(5);
        assertEquals(5, bb.getRadius());
        bb.blow(5);
        assertEquals(10, bb.getRadius());
    }
    

    @Test
    public void testDeflate() //Radius should become 0 again
    {
      bb.deflate();
      assertEquals(0, bb.getRadius());
      assertEquals(false, bb.isPopped());
    }
    
    @Test
    public void testOverinflation() //Balloon Should not be popped after Deflated
    {
      bb.blow(11);
      assertEquals(0, bb.getRadius());
      assertEquals(true, bb.isPopped());
    }
    
    @Test
    public void testPoppedBlow()
    {
    	bb.pop();
    	bb.blow(10);
    	assertEquals(0, bb.getRadius());
    	assertEquals(true, bb.isPopped());
    }
    
    @Test
    public void testAfterPop() //Tests that balloon popped after being popped
    {
      String msg ="The balloon didnt pop after pop()";
      bb.pop();
      assertEquals(msg, true, bb.isPopped());
      assertEquals(msg, 0, bb.getRadius());
    }
  }