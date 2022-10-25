package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel
{
  // TODO - add instance variables as needed
	private int rabbitPop;
	private int lastYearPop = 0;
	private int yearBeforePop = 1;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel()
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
    rabbitPop = ((lastYearPop) + (yearBeforePop));
    lastYearPop = yearBeforePop;
    yearBeforePop = rabbitPop;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	  rabbitPop = 0;
	  lastYearPop = 0;
	  yearBeforePop = 1;
  }
}


