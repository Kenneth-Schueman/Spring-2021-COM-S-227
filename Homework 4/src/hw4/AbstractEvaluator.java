package hw4;

import api.IEvaluator;

import java.util.ArrayList;

import api.Card;
import api.Hand;
import api.Suit;
import util.SubsetFinder;

/**
 * The class AbstractEvaluator includes common code for all evaluator types.
 * @author kennschue
 * TODO: Expand this comment with an explanation of how your class hierarchy
 * is organized.
 * 
 * The hierarchy is structured similar to how a real player would go about playing this game of poker,
 * the only exception being the accessor's because once written rarely do you have to go back and edit.
 * All logic heavy code excluding the <code>canSatisfy()</code> has been located to this interface.
 */
public abstract class AbstractEvaluator implements IEvaluator
{  
	private int givenRanking;
	private int givenHandSize;
	
	protected AbstractEvaluator(int ranking, int handSize) 
	{
		givenRanking = ranking;
		givenHandSize = handSize;
	}

	@Override
	public Hand createHand(Card[] allCards, int[] subset) 
	{
		int mainCounter = 0, sideCounter = 0, pointBreak = 0;
	
		if (subset.length == cardsRequired()) 
		{
			Card[] mainCards = new Card[subset.length];
			Card[] sideCards = new Card[allCards.length - subset.length];
			
			//Fill mainCards[]
			for (int i = 0; i < subset.length; i++) 
				for (int j = 0; j < allCards.length; j++)
					if (j == subset[i])
					{
						mainCards[mainCounter] = allCards[subset[i]];
						++mainCounter;
					}
			
			//Fill sideCards[]
			for (int i = 0; i < subset.length; i++)
				for (int j = pointBreak; j < allCards.length; j++)
					if (j == subset[i])
					{
						pointBreak = j + 1;
						break;
					}
			
					else
					{
						sideCards[sideCounter] = allCards[j];
						++sideCounter;
					}
		
			return new Hand(mainCards, sideCards, this);
		}
		
		return null;
	}

	@Override
	public boolean canSubsetSatisfy(Card[] allCards) 
	{
		if (allCards.length >= cardsRequired()) 
		{
			ArrayList<int[]> subsets = SubsetFinder.findSubsets(allCards.length, cardsRequired());
			
			for (int i = 0; i < subsets.size(); i++) 
			{
				int[] subset = subsets.get(i);
				Card[] mainCards = new Card[cardsRequired()];
				
				for (int j = 0; j < subset.length; j++)
					mainCards[j] = allCards[subset[j]];
				
				if (canSatisfy(mainCards))
					return true;
			}
		}
		
		return false;
	}
	
	@Override
	public Hand getBestHand(Card[] allCards) 
	{
		if (allCards.length <= handSize()) 
		{
			ArrayList<int[]> subsets = SubsetFinder.findSubsets(allCards.length, cardsRequired());
			Hand bestHand = createHand(allCards, subsets.get(0));
			
			for (int i = 1; i < subsets.size(); i++) 
			{
				int[] subset = subsets.get(i);
				
				if (createHand(allCards, subset).compareTo(bestHand) > 0)
					bestHand = createHand(allCards, subset);
			}
			
			return bestHand;
		}
		
		return null;	
	}
	
	@Override
	public int getRanking() 
	{
		return (givenRanking);
	}
	
	@Override
	public int handSize() 
	{
		return (givenHandSize);
	}
}
