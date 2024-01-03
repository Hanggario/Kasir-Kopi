import java.util.ArrayList;


public class Pastry 
{
	private ArrayList<String> string;
	private ArrayList<Integer> price = new ArrayList<Integer>();;
	
	Pastry()
	{
		string = new ArrayList<String>();
	}

	public void getSelectedButton(int[] i, String[] k)
	{
		string.add("Pastry");
		for(int x = 0; x < i.length; x++)
        {
        	string.add(k[i[x]]);
        }
	}
	
	public void pricing()
	{
		for(int x = 0; x < string.size(); x++)
		{
			if(string.get(x).equals("Tiramisu Truffle"))
			{
				price.add(3000000);
			}
			else if(string.get(x).equals("Lemon Zest Treats"))
			{
				price.add(3200000);
			}
			else if(string.get(x).equals("Golden Crust Confections"))
			{
				price.add(2900000);
			}
			else if(string.get(x).equals("Berries & Cream Delights"))
			{
				price.add(3500000);
			}
			else if(string.get(x).equals("Blueberry Muffin"))
			{
				price.add(3200000);
			}
		}
	}
	
	public void clear()
	{
		string.clear();
		price.clear();
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
