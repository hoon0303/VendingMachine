package project;

public class item {

	private String name;
	private int count, price, sale;

	item(String name, int count,int price)
	{
		this.name = name;//아이템 이름
		this.count = count;//아이템 개수
		this.price = price;//아이템 가격
		this.sale = 0;//아이템 판매 개수
	}
	public String getItemName()
	{
		return this.name;
	}
	public int getItemCount()
	{
		return this.count;
	}
	public int getItemPrice()
	{
		return this.price;
	}
	public int getItemSale()
	{
		return this.sale;
	}
	public void setItemName(String name)
	{
		this.name = name;
	}
	public void setItemCount(int count)
	{
		this.count = count;
	}
	public void setItemPrice(int price)
	{
		this.price = price;
	}
	public void setItemSale(int sale)
	{
		this.sale = sale;
	}
}