package graph

import util.KeyedItem;

public class Vertex extends KeyedItem
{
	private string item;   
	private Vertex previous;
	private Vertex next;
	private double total;
        
    public Vertex(string item) {
		super(0);
		this.item = item;
	}
		
	public string vertexName()
	{
		return item;
	}
	
	public Vertex previous()
	{
		return previous;
	}
	
	public Vertex next()
	{
		return next;
	}
	
	public double getTotal()
	{
		return total;
	}
	
	public void setPrevious(Vertex v)
	{
		previous = v;
	}
	
	public void setNext(Vertex v)
	{
		next = v;
	}
	
	public void setTotal(double t)
	{
		total = t;
	}
}