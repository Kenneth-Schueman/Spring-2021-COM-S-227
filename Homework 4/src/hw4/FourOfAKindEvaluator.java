package hw4;

import api.Card;
import api.Hand;

/**
 * @author kenschue
 * 
 * Evaluator for a hand containing (at least) four cards of the same rank.
 * The number of cards required is four.
 * 
 * The name of this evaluator is "Four of a Kind".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class FourOfAKindEvaluator extends AbstractEvaluator
{
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
	
	private int givenHandSize;
	
  public FourOfAKindEvaluator(int ranking, int handSize)
  {
	  super(ranking, handSize);
		
		givenHandSize = handSize;
  }

	@Override
	public String getName() 
	{
		return ("Four of a Kind");
	}
	
	@Override
	public int cardsRequired() 
	{
		return (4);
	}
	
	@Override
	public boolean canSatisfy(Card[] mainCards) 
	{
		int count = 0;
		
		if (mainCards.length == cardsRequired())
			for (int i = 0; i < givenHandSize; i++)
				for (int j = 0; j < givenHandSize; j++)
					if (mainCards[i] == mainCards[j])
						++count;
			
			if (count == cardsRequired())
				return true;
			
			else
				return false;
	}
}
