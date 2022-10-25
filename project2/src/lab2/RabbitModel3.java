package lab2;
import java.util.Random;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel3
{
  // TODO - add instance variables as needed
	private int rabbitPop;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel3()
  {
    rabbitPop = 0;
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    // TODO - returns a dummy value so code will compile
    return rabbitPop;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	Random rand = new Random();
    rabbitPop += (rand.nextInt(6));
    }
  
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	  rabbitPop = 0;
  }
}


