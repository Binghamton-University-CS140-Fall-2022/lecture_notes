class example2a
{
	private static int width = 400;
	private static int height = 400;
	
	public static void main(String[] args)
	{
		// create the window and specify the size and what to do when the window is closed
		javax.swing.JFrame f = new javax.swing.JFrame();
		f.setPreferredSize(new java.awt.Dimension(width, height));
		f.setMinimumSize(new java.awt.Dimension(width, height));
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
				
		// create the buttons
		javax.swing.JButton westButton = new javax.swing.JButton("west");
		javax.swing.JButton eastButton = new javax.swing.JButton("east");
		javax.swing.JButton southButton = new javax.swing.JButton("south");
		javax.swing.JButton centerButton = new javax.swing.JButton("center");
		
		// create the menu bar
		javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
		
		// create the two menus
		javax.swing.JMenu fileMenu = new javax.swing.JMenu("File");
		javax.swing.JMenu editMenu = new javax.swing.JMenu("Edit");
		
		// create the menu items for the two menus
		javax.swing.JMenuItem fileExit = new javax.swing.JMenuItem("Exit");
		javax.swing.JMenuItem editColor = new javax.swing.JMenuItem("Color");
		
		// add the two menus to the menu bar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		
		// add the two menu items to the two menus
		fileMenu.add(fileExit);
		editMenu.add(editColor);
		
		// create the panel and add the buttons and menu bar
		javax.swing.JPanel mainPanel = new javax.swing.JPanel();
		mainPanel.setLayout(new java.awt.BorderLayout());
		mainPanel.add(centerButton, java.awt.BorderLayout.CENTER);
		mainPanel.add(westButton, java.awt.BorderLayout.WEST);
		mainPanel.add(eastButton, java.awt.BorderLayout.EAST);
		mainPanel.add(southButton, java.awt.BorderLayout.SOUTH);
		mainPanel.add(menuBar, java.awt.BorderLayout.NORTH);
		
		// create the action listeners for the buttons
		ButtonActionListener centerButtonActionListener = new ButtonActionListener(centerButton);
		ButtonActionListener westButtonActionListener = new ButtonActionListener(westButton);
		ButtonActionListener eastButtonActionListener = new ButtonActionListener(eastButton);
		ButtonActionListener southButtonActionListener = new ButtonActionListener(southButton);
		
		// create the action listeners for the menu items
		MenuItemActionListener fileExitMenuItemActionListener = new MenuItemActionListener(fileExit);
		MenuItemActionListener editColorMenuItemActionListener = new MenuItemActionListener(editColor);
		
		// add the action listeners to the buttons
		centerButton.addActionListener(centerButtonActionListener);
		westButton.addActionListener(westButtonActionListener);
		eastButton.addActionListener(eastButtonActionListener);
		southButton.addActionListener(southButtonActionListener);
		
		// add the action listeners to the menu items
		fileExit.addActionListener(fileExitMenuItemActionListener);
		editColor.addActionListener(editColorMenuItemActionListener);
		
		f.setContentPane(mainPanel);
		
		f.validate();
		f.setVisible(true);
	}
	
	// action listener for the buttons
	static class ButtonActionListener implements java.awt.event.ActionListener
	{
		// the button associated with the action listener, so that we can
		// share this one class with multiple buttons
		private javax.swing.JButton b;
		
		ButtonActionListener(javax.swing.JButton b)
		{
			this.b = b;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
			System.out.println("action performed on " + b.getText() + " button");
		}
	}
	
	// action listener for the menu items
	static class MenuItemActionListener implements java.awt.event.ActionListener
	{
		// the menu item associated with the action listener, so that we can
		// share this one class with multiple menu items
		private javax.swing.JMenuItem m;
		
		MenuItemActionListener(javax.swing.JMenuItem m)
		{
			this.m = m;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
			System.out.println("action performed on " + m.getText() + " menu item");
			
			// if exit is selected from the file menu, exit the program
			if( m.getText().toLowerCase().equals("exit") )
			{
				System.exit(0);
			}
			
			// if color is selected from the edit menu, put a popup on the screen 
			// saying something 
			if( m.getText().toLowerCase().equals("color") )
			{
				Object[] options = {"OK"};
				javax.swing.JOptionPane.showOptionDialog(null, "This is unimplemented,\nclick OK to continue", 
						"Warning", javax.swing.JOptionPane.DEFAULT_OPTION, 
						javax.swing.JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			}
		}
	}
}
