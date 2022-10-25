package hw4;

import api.Card;
import api.Hand;
import api.Suit;

/**
 * @author kenns
 * 
 * Evaluator for a hand containing (at least) three cards of the same rank.
 * The number of cards required is three.
 * 
 * The name of this evaluator is "Three of a Kind".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class ThreeOfAKindEvaluator extends AbstractEvaluator 
{
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
	
	private int givenHandSize;
	
	public ThreeOfAKindEvaluator(int ranking, int handSize)
	{
		super(ranking, handSize);
		
		givenHandSize = handSize;
	}

	@Override
	public String getName() 
	{
		return ("ThreeOfAKindEvaluator");
	}
	
	@Override
	public int cardsRequired() 
	{
		return (3);
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
