package project3;

public class Balloon 
{
	private boolean isPopped;
	private int radius = 0;
	private int max;

	public Balloon(int givenRadius)
	{
		isPopped = false;
		max = givenRadius;
	}
	
	public int getRadius()
	{
		return radius;
	}

	public boolean isPopped()
	{
		return isPopped;
	}
	
	public void blow(int amount)
	{
		radius += amount;
		if (radius > max) {
			isPopped = true;
			radius = 0;
		}
	}

	public void deflate()
	{
		radius = 0;
	}
	
	public void pop()
	{
		isPopped = true;
	}

}

