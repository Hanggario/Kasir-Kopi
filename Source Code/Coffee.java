import java.util.ArrayList;
import javax.swing.ButtonGroup;


public class Coffee 
{
	private ArrayList<String> string;
	private ArrayList<Integer> price;
	
	Coffee()
	{
		string = new ArrayList<String>();
		price = new ArrayList<Integer>();
	}

	public void getSelectedButton(ButtonGroup group, ButtonGroup group2)
	{
		String product = "";
		product = group.getSelection().getActionCommand()+" "+group2.getSelection().getActionCommand();
		
		string.add("Kopi");
		string.add(product);
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
			if(string.get(x).startsWith("Kecil"))
			{
				price.add(2000000);
			}
			else if(string.get(x).startsWith("Sedang"))
			{
				price.add(2300000);
			}
			else if(string.get(x).startsWith("Besar"))
			{
				price.add(2500000);
			}
			else if(string.get(x).equals("Ekstra Gula"))
			{
				price.add(200000);
			}
			else if(string.get(x).equals("Lebih Sedikit Gula"))
			{
				price.add(0);
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
