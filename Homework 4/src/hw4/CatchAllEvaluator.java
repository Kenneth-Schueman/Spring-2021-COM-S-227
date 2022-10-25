package hw4;

import api.Card;
import api.Hand;

/**
 * @author kennschue
 * 
 * Evaluator satisfied by any set of cards.  The number of
 * required cards is equal to the hand size.
 * 
 * The name of this evaluator is "Catch All".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class CatchAllEvaluator extends AbstractEvaluator
{
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
	private int givenHandSize;
	
  public CatchAllEvaluator(int ranking, int handSize)
  {
	  super(ranking, handSize);
		
		givenHandSize = handSize;
  }

	@Override
	public String getName() 
	{
		return ("Catch All");
	}
	
	@Override
	public int cardsRequired() 
	{
		return (handSize());
	}
	
	@Override
	public boolean canSatisfy(Card[] mainCards) 
	{
		if (mainCards.length == cardsRequired())
			return true;
		else
			return false;
	}
}
