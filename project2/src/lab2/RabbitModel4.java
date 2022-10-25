package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel4
{
  // TODO - add instance variables as needed
	private int rabbitPop;
	private int lastYearPop = 1;
	private int yearBeforePop = 0;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel4()
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
    rabbitPop = ((lastYearPop - 1) + (yearBeforePop - 2));
    yearBeforePop = lastYearPop;
    lastYearPop = rabbitPop;
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


