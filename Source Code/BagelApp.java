import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BagelApp extends JFrame{

	/* 
	 *	  Declarations
	 */
	
	private int width = 800;
	private int height = 600;
	private JPanel parent;
	private JPanel panel1;
	private JPanel panel2a;
	private JPanel panel2b;
	private JPanel panel2c;
	private JPanel panel3;
	private JLabel title;
	private JPanel buttons;
	
	private JRadioButton product1;
	private JRadioButton product2;
	private JRadioButton product3;
	private ButtonGroup productgroup;
	
	private JPanel subpanel1;
	private JPanel subpanel2;
	private JPanel subpanel3;
	private JPanel subpanel4;
	private JPanel subpanel5;
	private JPanel subpanel6;
	private JPanel subpanel7;
	private JPanel subpanel8;
	private JPanel subpanel9;
	
	private JTextArea text;

	private JScrollPane scroll;
	
	//	PANEL 2A
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
	private JRadioButton small;
	private JRadioButton medium;
	private JRadioButton large;
	private ButtonGroup group1;
	
	private JRadioButton decafe;
	private JRadioButton regular;
	private JRadioButton roast;
	private ButtonGroup group2;
	
	private JCheckBox cream;
	private JCheckBox sugar;
	
	// PANEL 2B
	
	private JRadioButton white;
	private JRadioButton wheat;
	private JRadioButton salt;
	private JRadioButton seseme;
	private JRadioButton popy;
	private ButtonGroup group4;
	
	private JRadioButton cc;
	private JRadioButton lcc;
	private JRadioButton gc;
	private JRadioButton butter;
	private JRadioButton jam;
	private ButtonGroup group5;
	
	private JCheckBox lox;
	private JCheckBox novalox;
	
	// PANEL 2C
	
	private String[] pastrylist = {"Tiramisu Truffle", "Lemon Zest Treats", "Golden Crust Confections", "Berries & Cream Delights", "Blueberry Muffin"};
	private JList list;
	private int[] indices = {};
	
	// OTHERS
	
	private JLabel quantitylabel;
	private JTextField quantity;
	private JRadioButton membery;
	private JRadioButton membern;
	private ButtonGroup membergroup;
	private JButton delete;
	private int q = 1;
	
	private BorderLayout layout;
	
	private boolean isMember;

	private Order order;
	private Coffee coffee;
	private Bagel bagel;
	private Pastry pastry;
	
	private BagelApp()
	{
		setTitle("KOPICONG Order Application");
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10,10));
		setBackground(Color.LIGHT_GRAY);
		
		buildPanel();
		add(panel3, BorderLayout.CENTER);
		add(title, BorderLayout.NORTH);
		add(buttons, BorderLayout.SOUTH);
		add(parent, BorderLayout.WEST);
		
		setVisible(true);
		
		// CALL CLASSES
		order = new Order();
		coffee = new Coffee();
		bagel = new Bagel();
		pastry = new Pastry();
	}
	
	private void buildPanel()
	{
		/* Metode pembuatan yang sangat besar karena semua panel
         * sudah dibuat sebelumnya
         */
		
		// PARENT PANEL
		
		parent = new JPanel();
		parent.setLayout(new BorderLayout(10,10));
		
		title = new JLabel("Layar Entri Pesanan");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel1 = new JPanel();
		panel2a = new JPanel();
		panel2b = new JPanel();
		panel2c = new JPanel();
		panel3 = new JPanel();
		
		// PANEL1
		
		panel1.setBorder(BorderFactory.createTitledBorder("Produk"));
		panel1.setLayout(new GridLayout(3,1));
		
		product1 = new JRadioButton("Kopi");
		product2 = new JRadioButton("Bagel");
		product3 = new JRadioButton("Pastry");
		productgroup = new ButtonGroup();
		
		productgroup.add(product1);
		productgroup.add(product2);
		productgroup.add(product3);
		
		product1.addActionListener(new ButtonListener());
		product2.addActionListener(new ButtonListener());
		product3.addActionListener(new ButtonListener());
		
		panel1.add(product1);
		panel1.add(product2);
		panel1.add(product3);
		
		panel2a.setLayout(new GridLayout(3,1));
		panel2a.setPreferredSize(new Dimension(180, 650));
		panel2b.setLayout(new GridLayout(3,1));
		panel2b.setPreferredSize(new Dimension(180, 650));
		panel2c.setLayout(new GridLayout(2,1));
		panel2c.setPreferredSize(new Dimension(180, 650));
		
		subpanel1 = new JPanel();
		subpanel2 = new JPanel();
		subpanel3 = new JPanel();
		
		// PANEL3
		
		panel3.setLayout(new BorderLayout());
		
		subpanel8 = new JPanel();
		subpanel9 = new JPanel();
		subpanel9.setLayout(new BorderLayout());
		
		quantitylabel = new JLabel("Quantity: ");
		quantity = new JTextField(5);
		membery = new JRadioButton("Member");
		membern = new JRadioButton("Not Member");
		membergroup = new ButtonGroup();
		delete = new JButton("Delete Previous");
		
		membery.setActionCommand("Member");
		membern.setActionCommand("Not Member");
		
		delete.addActionListener(new ButtonListener());
		quantity.addActionListener(new ButtonListener());
		membern.addActionListener(new ButtonListener());
		membery.addActionListener(new ButtonListener());
		
		membergroup.add(membery);
		membergroup.add(membern);
		
		text = new JTextArea();
		scroll = new JScrollPane(text);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEditable(false);
        
        subpanel8.add(quantitylabel);
        subpanel8.add(quantity);
        subpanel8.add(membery);
        subpanel8.add(membern);
		subpanel8.add(delete);
        subpanel9.add(scroll, BorderLayout.CENTER);
        
        panel3.add(subpanel8, BorderLayout.SOUTH);
		panel3.add(subpanel9, BorderLayout.CENTER);
		
		// BUTTON PANEL
		
		buttons = new JPanel();
		button1 = new JButton("Enter Item");
		button2 = new JButton("Total");
		button3 = new JButton("New Order");
		buttons.setBackground(Color.black);
		
		button1.addActionListener(new ButtonListener());
		button2.addActionListener(new ButtonListener());
		button3.addActionListener(new ButtonListener());
		
		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		
		//panel2a
		
		subpanel1.setLayout(new GridLayout(3,1));
		subpanel2.setLayout(new GridLayout(3,1));
		subpanel3.setLayout(new GridLayout(2,1));
		
		subpanel1.setBorder(BorderFactory.createTitledBorder("Ukuran"));
		
		small = new JRadioButton("Kecil");
		medium = new JRadioButton("Sedang");
		large = new JRadioButton("Besar");
		group1 = new ButtonGroup();
		
		small.setActionCommand("Kecil");
		medium.setActionCommand("Sedang");
		large.setActionCommand("Besar");
		
		small.addActionListener(new ButtonListener());
		medium.addActionListener(new ButtonListener());
		large.addActionListener(new ButtonListener());
		
		group1.add(small);
		group1.add(medium);
		group1.add(large);
		
		subpanel1.add(small);
		subpanel1.add(medium);
		subpanel1.add(large);
		
		subpanel2.setBorder(BorderFactory.createTitledBorder("Jenis Kopi"));
		
		regular = new JRadioButton("Kopi Reguler");
		decafe = new JRadioButton("Kopi Gula Aren");
		roast = new JRadioButton("Kopi Alpukat");
		group2 = new ButtonGroup();
		
		regular.setActionCommand("Kopi Reguler");
		decafe.setActionCommand("Kopi Gula Aren");
		roast.setActionCommand("Kopi Alpukat");
		
		regular.addActionListener(new ButtonListener());
		decafe.addActionListener(new ButtonListener());
		roast.addActionListener(new ButtonListener());
		
		group2.add(regular);
		group2.add(decafe);
		group2.add(roast);
		
		subpanel2.add(regular);
		subpanel2.add(decafe);
		subpanel2.add(roast);
		
		subpanel3.setBorder(BorderFactory.createTitledBorder("Tambahan"));
		
		cream = new JCheckBox("Ekstra Gula");
		sugar = new JCheckBox("Lebih Sedikit Gula");
		
		cream.addActionListener(new ButtonListener());
		sugar.addActionListener(new ButtonListener());
		
		subpanel3.add(cream);
		subpanel3.add(sugar);
		
		panel2a.add(subpanel1);
		panel2a.add(subpanel2);
		panel2a.add(subpanel3);
		
		//panel2b
		
		subpanel4 = new JPanel();
		subpanel5 = new JPanel();
		subpanel6 = new JPanel();
		
		subpanel4.setLayout(new GridLayout(5,1));
		subpanel5.setLayout(new GridLayout(5,1));
		subpanel6.setLayout(new GridLayout(2,1));
		
		subpanel4.setBorder(BorderFactory.createTitledBorder("Bagel"));
		
		white = new JRadioButton("Bagel Coklat Kental");
		wheat = new JRadioButton("Bagel Keju Klasik");
		salt = new JRadioButton("Bagel Lautan Asin");
		seseme = new JRadioButton("Bagel Kacang Karamel");
		popy = new JRadioButton("Bagel Beri");
		group4 = new ButtonGroup();
		
		white.setActionCommand("Bagel Coklat Kental");
		wheat.setActionCommand("Bagel Krim Keju Klasik");
		salt.setActionCommand("Bagel Lautan Asin");
		seseme.setActionCommand("Bagel Kacang Karamel");
		popy.setActionCommand("Bagel Beri");
		
		white.addActionListener(new ButtonListener());
		wheat.addActionListener(new ButtonListener());
		salt.addActionListener(new ButtonListener());
		seseme.addActionListener(new ButtonListener());
		popy.addActionListener(new ButtonListener());
		
		group4.add(white);
		group4.add(wheat);
		group4.add(salt);
		group4.add(seseme);
		group4.add(popy);
		
		subpanel4.add(white);
		subpanel4.add(wheat);
		subpanel4.add(salt);
		subpanel4.add(seseme);
		subpanel4.add(popy);
		
		subpanel5.setBorder(BorderFactory.createTitledBorder("Olesan"));
		
		cc = new JRadioButton("Krim Keju ");
		lcc = new JRadioButton("Krim Keju (Sedikit) ");
		gc = new JRadioButton("Krim Bawang Putih ");
		butter = new JRadioButton("Mentega ");
		jam = new JRadioButton("Selai ");
		group5 = new ButtonGroup();
		
		cc.setActionCommand("Krim Keju ");
		lcc.setActionCommand("Krim Keju (Sedikit) ");
		gc.setActionCommand("Krim Bawang putih ");
		butter.setActionCommand("Mentega ");
		jam.setActionCommand("Selai ");
		
		cc.addActionListener(new ButtonListener());
		lcc.addActionListener(new ButtonListener());
		gc.addActionListener(new ButtonListener());
		butter.addActionListener(new ButtonListener());
		jam.addActionListener(new ButtonListener());
		
		group5.add(cc);
		group5.add(lcc);
		group5.add(gc);
		group5.add(butter);
		group5.add(jam);
		
		subpanel5.add(cc);
		subpanel5.add(lcc);
		subpanel5.add(gc);
		subpanel5.add(butter);
		subpanel5.add(jam);
		
		subpanel6.setBorder(BorderFactory.createTitledBorder("Toppings"));
		
		lox = new JCheckBox("Ekstra Krim");
		novalox = new JCheckBox("Ekstra Topping");
		
		lox.addActionListener(new ButtonListener());
		novalox.addActionListener(new ButtonListener());
		
		subpanel6.add(lox);
		subpanel6.add(novalox);
		
		panel2b.add(subpanel4);
		panel2b.add(subpanel5);
		panel2b.add(subpanel6);
		
		//panel2c
		
		subpanel7 = new JPanel();
		
		subpanel7.setLayout(new GridLayout());
		subpanel7.setBorder(BorderFactory.createTitledBorder("Pastries"));
		
		list = new JList(pastrylist);
		
		list.addListSelectionListener(new ListListener());
		
		subpanel7.add(list);
		panel2c.add(subpanel7);
		
		parent.add(panel1, BorderLayout.WEST);
		parent.add(panel2a, BorderLayout.CENTER);
		layout = (BorderLayout)parent.getLayout();
		
		product1.doClick();
		membern.doClick();
	}
	
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			if(product1.isSelected())
			{					
				parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
				parent.add(panel2a, BorderLayout.CENTER);
				parent.revalidate();
				parent.repaint();
				if(group1.getSelection() == null)
				{
					small.doClick();
				}
				if(group2.getSelection() == null)
				{
					regular.doClick();
				}
			}
			else if(product2.isSelected())
			{				
				parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
				parent.add(panel2b, BorderLayout.CENTER);
				parent.revalidate();
				parent.repaint();
				if(group4.getSelection() == null)
				{
					white.doClick();
				}
			}
			else if(product3.isSelected())
			{				
				parent.remove(layout.getLayoutComponent(BorderLayout.CENTER));
				parent.add(panel2c, BorderLayout.CENTER);
				parent.revalidate();
				parent.repaint();
			}
			if(arg0.getActionCommand() == "Enter Item")
			{
				if(!quantity.getText().isEmpty())
				{
					try
					{
						q = Integer.parseInt(quantity.getText());
					}
					catch(NumberFormatException e)
					{
						q = 1;
					}
				}
				else
				{
					q = 1;
				}
				
				if(product1.isSelected())
				{
					coffee.getSelectedButton(group1, group2);
					if(sugar.isSelected())
					{
						coffee.getString().add("Lebih Sedikit Gula");
						sugar.doClick();
					}
					if(cream.isSelected())
					{
						coffee.getString().add("Ekstra Gula");
						cream.doClick();
					}
					coffee.pricing();
					for(int x = 0; x < q; x++)
					{
						order.getOrder(coffee.getPrice(), coffee.getString());
					}
					q = 1;
					coffee.clear();
					small.doClick();
					regular.doClick();
				}
				else if(product2.isSelected())
				{
					bagel.getSelectedButton(group4, group5);
					if(lox.isSelected())
					{
						bagel.getString().add("Ekstra Krim");
						lox.doClick();
					}
					if(novalox.isSelected())
					{
						bagel.getString().add("Ekstra Topping");
						novalox.doClick();
					}
					bagel.pricing();
					for(int x = 0; x < q; x++)
					{
						order.getOrder(bagel.getPrice(), bagel.getString());
					}
					q = 1;
					bagel.clear();
					white.doClick();
					group5.clearSelection();
				}
				else if(product3.isSelected())
				{
					pastry.getSelectedButton(indices, pastrylist);
					pastry.pricing();
					for(int x = 0; x < q; x++)
					{
						order.getOrder(pastry.getPrice(), pastry.getString());
					}
					q = 1;
					pastry.clear();
				}
				
				printOrder(order.getOrder(), order.getOrderprice());
				quantity.setText("");
				
			}
			else if(arg0.getActionCommand() == "New Order")
			{
				order.clear();
				product1.doClick();
				small.doClick();
				regular.doClick();
				white.doClick();
				group5.clearSelection();
				text.setText("");
			}
			else if(arg0.getActionCommand() == "Total")
			{
				text.append(String.format("%n%100s%2s%.2f", "Subtotal: ","Rp.", (float)order.calculateSubtotal()/100));
				text.append(String.format("%n%102s%2s%.2f", "Total: ","Rp.", (float)order.calculateTotal(isMember)/100));
			}
			if(arg0.getActionCommand() == "Delete Previous")
			{
				int i = order.getOrder().size()-1;
				int k = order.getOrderprice().size()-1;
				boolean yes = false;
				int y = i;
				int x = k;
				
				while(!yes && !(i == -1 && k == -1))
				{
					if(order.getOrder().get(y).equals("Kopi")||order.getOrder().get(y).equals("Bagel")||order.getOrder().get(y).equals("Pastry"))
					{
						order.getOrder().remove(y);
						yes = true;
					}
					else
					{
						order.getOrder().remove(y);
						order.getOrderprice().remove(x);
						y--;
						x--;
					}
				}
				printOrder(order.getOrder(), order.getOrderprice());
				
			}
			if(membern.isSelected())
			{
				isMember = false;
			}
			else if(membery.isSelected())
			{
				isMember = true;
			}
		}
	}
		
	private class ListListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent arg0) 
		{
			JList source;
			if (!arg0.getValueIsAdjusting())
			{
	            source = (JList)arg0.getSource();
	            indices = source.getSelectedIndices();
	        }
		}
	}
	
	private void printOrder(ArrayList<String> list, ArrayList<Integer> list2)
	{
		int y = 0;
		text.setText("");
		for(int x = 0; x < list.size(); x++)
		{
			if(list.get(x).equals("Kopi")||list.get(x).equals("Bagel")||list.get(x).equals("Pastry"))
			{
				text.append(list.get(x)+"\n");
			}
			else
			{
				text.append("           "+list.get(x)+"\n");
				text.append(String.format("%107s%.2f\n","Rp.", (float)list2.get(y)/100));
				y++;
			}
		}
	}

	public static void main(String[] args)
	{
		BagelApp app = new BagelApp();
	}
	
	//Getters and Setters
	public JTextArea getText() {
		return text;
	}

	public void setText(JTextArea text) {
		this.text = text;
	}
	
	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
}