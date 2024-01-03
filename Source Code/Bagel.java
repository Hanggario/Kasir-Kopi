import java.util.ArrayList;

import javax.swing.ButtonGroup;


public class Bagel 
{
	private ArrayList<String> string;
	private ArrayList<Integer> price;
	
	Bagel()
	{
		string = new ArrayList<String>();
		price = new ArrayList<Integer>();
	}

	public void getSelectedButton(ButtonGroup group, ButtonGroup group2)
	{
		string.add("Bagel");
		String product = group.getSelection().getActionCommand();
		string.add(product);
		if(group2.getSelection() != null)
		{
			product = group2.getSelection().getActionCommand();
			string.add(product);
		}
	}
	
	public void clear()
	{
		string.clear();
		price.clear();
	}
	
	public void pricing()
	{
		for(int x = 0; x < string.size(); x++)
		{
			if(string.get(x).startsWith("Bagel Coklat Kental"))
			{
				price.add(2500000);
			}
			else if(string.get(x).equals("Bagel Keju Klasik"))
			{
				price.add(2800000);
			}
			else if(string.get(x).equals("Bagel Lautan Asin"))
			{
				price.add(2300000);
			}
			else if(string.get(x).equals("Bagel Kacang Karamel"))
			{
				price.add(2600000);
			}
			else if(string.get(x).equals("Bagel Beri"))
			{
				price.add(3000000);
			}
			else if(string.get(x).endsWith(" "))
			{
				price.add(700000);
			}
			else if(string.get(x).equals("Ekstra Krim")||string.get(x).equals("Ekstra Topping"))
			{
				price.add(400000);
			}
		}
	}
	
	public ArrayList<String> getString() {
		return string;
	}
	public void setString(ArrayList<String> string) {
		this.string = string;
	}
	public ArrayList<Integer> getPrice() {
		return price;
	}
	public void setPrice(ArrayList<Integer> price) {
		this.price = price;
	}
}
