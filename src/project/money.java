package project;

public class money {

	private String name;
	private int count;
	
	money(String name, int count)
	{
		this.name = name;
		this.count = count;
	}
	public String getMoneyName()
	{
		return this.name;
	}
	public int getMoneyCount()
	{
		return this.count;
	}
	public void setMoneyName(String name)
	{
		this.name = name;
	}
	public void setMoneyCount(int count)
	{
		this.count = count;
	}
}
