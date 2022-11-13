class example4b
{
	private static int width = 400;
	private static int height = 200;
	
	public static void main(String[] args)
	{
		// create the window and specify the size and what to do when the window is closed
		javax.swing.JFrame f = new javax.swing.JFrame();
		f.setPreferredSize(new java.awt.Dimension(width, height));
		f.setMinimumSize(new java.awt.Dimension(width, height));
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
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
		
		// create the panel to hold the four buttons
		javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
		java.awt.GridBagLayout gridBagLayout = new java.awt.GridBagLayout();
		buttonPanel.setLayout(gridBagLayout);
		java.awt.GridBagConstraints buttonPanelConstraints = new java.awt.GridBagConstraints();
		
		// create the buttons
		javax.swing.JButton r0c0Button = new javax.swing.JButton("row 0 column 0");
		javax.swing.JButton r0c1Button = new javax.swing.JButton("row 0 column 1");
		javax.swing.JButton r0c2Button = new javax.swing.JButton("row 0 column 2");
		javax.swing.JButton r1c01Button = new javax.swing.JButton("row 1 column 0 - 1");
		javax.swing.JButton r1c2Button = new javax.swing.JButton("row 1 column 2");
		javax.swing.JButton r2c0Button = new javax.swing.JButton("row 2 column 0");
		javax.swing.JButton r2c12Button = new javax.swing.JButton("row 2 column 1 - 2");
		javax.swing.JButton r3c0Button = new javax.swing.JButton("row 3 column 0");
		javax.swing.JButton r3c1Button = new javax.swing.JButton("row 3 column 1");
		javax.swing.JButton r3c2Button = new javax.swing.JButton("row 3 column 2");
		javax.swing.JButton r4c0Button = new javax.swing.JButton("row 4 column 0");
		javax.swing.JButton r4c2Button = new javax.swing.JButton("row 4 column 2");
		
		// make the weights non zero so that the components spread out 
		buttonPanelConstraints.weightx = 1;
		buttonPanelConstraints.weighty = 1;
		
		// have the components fill all of the cells that they occupy 
		buttonPanelConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		
		// button row 1
		// put button at (0, 0)
		buttonPanelConstraints.gridx = 0;
		buttonPanelConstraints.gridy = 0;
		buttonPanelConstraints.gridwidth = 1;
		gridBagLayout.setConstraints(r0c0Button, buttonPanelConstraints);
		
		// put button at (0, 1)
		buttonPanelConstraints.gridx = 1;
		buttonPanelConstraints.gridy = 0;
		buttonPanelConstraints.gridwidth = 1;
		gridBagLayout.setConstraints(r0c1Button, buttonPanelConstraints);
		
		// put button at (0, 2)
		buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 0;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(r0c2Button, buttonPanelConstraints);
		
		// button row 2
		// put button at (1, 0)
		buttonPanelConstraints.gridx = 0;
		buttonPanelConstraints.gridy = 1;
		buttonPanelConstraints.gridwidth = 2;
		gridBagLayout.setConstraints(r1c01Button, buttonPanelConstraints);
		
		// put button at (1, 1)
		buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 1;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(r1c2Button, buttonPanelConstraints);
		
		// button row 3
		// put button at (2, 0)
		buttonPanelConstraints.gridx = 0;
		buttonPanelConstraints.gridy = 2;
		buttonPanelConstraints.gridwidth = 1;
		gridBagLayout.setConstraints(r2c0Button, buttonPanelConstraints);
		
		// put button at (2, 1)
		buttonPanelConstraints.gridx = 1;
		buttonPanelConstraints.gridy = 2;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(r2c12Button, buttonPanelConstraints);
		
		// button row 4
		// put button at (3, 0)
		buttonPanelConstraints.gridx = 0;
		buttonPanelConstraints.gridy = 3;
		buttonPanelConstraints.gridwidth = 1;
		gridBagLayout.setConstraints(r3c0Button, buttonPanelConstraints);
		
		// put button at (3, 1)
		buttonPanelConstraints.gridx = 1;
		buttonPanelConstraints.gridy = 3;
		buttonPanelConstraints.gridwidth = 1;
		gridBagLayout.setConstraints(r3c1Button, buttonPanelConstraints);
		
		// put button at (3, 2)
		buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 3;
		buttonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagLayout.setConstraints(r3c2Button, buttonPanelConstraints);
		
		// button row 5
		// put button at (4, 0)
		buttonPanelConstraints.gridx = 0;
		buttonPanelConstraints.gridy = 4;
		buttonPanelConstraints.gridwidth = 1;
		gridBagLayout.setConstraints(r4c0Button, buttonPanelConstraints);
		
		// put button at (4, 2)
		buttonPanelConstraints.gridx = 2;
		buttonPanelConstraints.gridy = 4;
		buttonPanelConstraints.gridwidth = 1;
		gridBagLayout.setConstraints(r4c2Button, buttonPanelConstraints);

		
		// add the buttons to the panel
		buttonPanel.add(r0c0Button);
		buttonPanel.add(r0c1Button);
		buttonPanel.add(r0c2Button);
		buttonPanel.add(r1c01Button);
		buttonPanel.add(r1c2Button);
		buttonPanel.add(r2c0Button);
		buttonPanel.add(r2c12Button);
		buttonPanel.add(r3c0Button);
		buttonPanel.add(r3c1Button);
		buttonPanel.add(r3c2Button);
		buttonPanel.add(r4c0Button);
		buttonPanel.add(r4c2Button);
								
		// create the panel
		javax.swing.JPanel mainPanel = new javax.swing.JPanel();
		mainPanel.setLayout(new java.awt.BorderLayout());
		mainPanel.add(menuBar, java.awt.BorderLayout.NORTH);
		mainPanel.add(buttonPanel, java.awt.BorderLayout.CENTER);
		
		// create the action listeners for the buttons
		ButtonActionListener r0c0ButtonActionListener = new ButtonActionListener(r0c0Button);
		ButtonActionListener r0c1ButtonActionListener = new ButtonActionListener(r0c1Button);
		ButtonActionListener r0c2ButtonActionListener = new ButtonActionListener(r0c2Button);
		ButtonActionListener r1c01ButtonActionListener = new ButtonActionListener(r1c01Button);
		ButtonActionListener r1c2ButtonActionListener = new ButtonActionListener(r1c2Button);
		ButtonActionListener r2c0ButtonActionListener = new ButtonActionListener(r2c0Button);
		ButtonActionListener r2c12ButtonActionListener = new ButtonActionListener(r2c12Button);		
		ButtonActionListener r3c0ButtonActionListener = new ButtonActionListener(r3c0Button);
		ButtonActionListener r3c1ButtonActionListener = new ButtonActionListener(r3c1Button);
		ButtonActionListener r3c2ButtonActionListener = new ButtonActionListener(r3c2Button);
		ButtonActionListener r4c0ButtonActionListener = new ButtonActionListener(r4c0Button);
		ButtonActionListener r4c2ButtonActionListener = new ButtonActionListener(r4c2Button);
		
		// create the action listeners for the menu items
		MenuItemActionListener fileExitMenuItemActionListener = new MenuItemActionListener(fileExit);
		MenuItemActionListener editColorMenuItemActionListener = new MenuItemActionListener(editColor);
		
		// add the action listeners to the buttons
		r0c0Button.addActionListener(r0c0ButtonActionListener);
		r0c1Button.addActionListener(r0c1ButtonActionListener);
		r0c2Button.addActionListener(r0c2ButtonActionListener);
		r1c01Button.addActionListener(r1c01ButtonActionListener);
		r1c2Button.addActionListener(r1c2ButtonActionListener);
		r2c0Button.addActionListener(r2c0ButtonActionListener);
		r2c12Button.addActionListener(r2c12ButtonActionListener);		
		r3c0Button.addActionListener(r3c0ButtonActionListener);
		r3c1Button.addActionListener(r3c1ButtonActionListener);
		r3c2Button.addActionListener(r3c2ButtonActionListener);
		r4c0Button.addActionListener(r4c0ButtonActionListener);
		r4c2Button.addActionListener(r4c2ButtonActionListener);
		
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
