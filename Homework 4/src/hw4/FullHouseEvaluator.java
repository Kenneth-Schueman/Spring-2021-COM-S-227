package hw4;

import api.Card;
import api.Hand;

/**
 * @author kenschue
 * 
 * Evaluator for a generalized full house.  The number of required
 * cards is equal to the hand size.  If the hand size is an odd number
 * n, then there must be (n / 2) + 1 cards of the matching rank and the
 * remaining (n / 2) cards must be of matching rank. In this case, when constructing
 * a hand, the larger group must be listed first even if of lower rank
 * than the smaller group</strong> (e.g. as [3 3 3 5 5] rather than [5 5 3 3 3]).
 * If the hand size is even, then half the cards must be of matching 
 * rank and the remaining half of matching rank.  Any group of cards,
 * all of which are the same rank, always satisfies this
 * evaluator.
 * 
 * The name of this evaluator is "Full House".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class FullHouseEvaluator extends AbstractEvaluator
{
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
	
  public FullHouseEvaluator(int ranking, int handSize) 
  {
	  super(ranking, handSize);
  }

	@Override
	public String getName() 
	{
		return ("Full House");
	}
	
	@Override
	public int cardsRequired() 
	{
		return (handSize());
	}
	
	@Override
	public boolean canSatisfy(Card[] mainCards) 
	{
		
		int firstRankCounter = 0, secondRankCounter = 0, secondRank = 0, secondRankIndex = 0;
		int firstRank = mainCards[0].getRank();
		boolean flag = false;
		
		if (mainCards.length == cardsRequired()) 
		{
			for (int i = 1; i < mainCards.length; i++)
				if (firstRank != mainCards[i].getRank() && !flag)
				{
					secondRank = mainCards[i].getRank();
					secondRankIndex = i;
					flag = true;
				}
				
				else
					++firstRankCounter;
		}
			
		//Finding # of second rank
		for (int i = secondRankIndex; i < mainCards.length; i++)
				if (secondRank == mainCards[i].getRank())
					++secondRankCounter;
			
			if (firstRankCounter + secondRankCounter != mainCards.length || secondRank == 0)
				return false;
			
			return true;
		}
	}

