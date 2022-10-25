package hw4;

import api.Card;
import api.Hand;
import api.Suit;

/**
 * @author kenschue
 * 
 * Evaluator for a hand containing (at least) two cards of the same rank.
 * The number of cards required is two.
 * 
 * The name of this evaluator is "One Pair".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class OnePairEvaluator extends AbstractEvaluator
{
  /**
   * Constructs the evaluator.

   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
	
	private int givenHandSize;
	
	public OnePairEvaluator(int ranking, int handSize) 
	{
		super(ranking, handSize);
		
		givenHandSize = handSize; 
	}

	@Override
	public String getName() 
	{
		return ("OnePairEvaluator");
	}
	
	@Override
	public int cardsRequired() 
	{
		return (2);
	}
	
	@Override
	public boolean canSatisfy(Card[] mainCards) 
	{
		if (mainCards.length == cardsRequired())
			for (int i = 0; i < givenHandSize; i++)
				for (int j = 0; j < givenHandSize; j++)
					if (mainCards[i] == mainCards[j])
						return (true);
		
		return false;
	}
}
