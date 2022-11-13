class example1a
{
	private static int width = 400;
	private static int height = 400;
	
	public static void main(String[] args)
	{
		// create the frame (or window)
		javax.swing.JFrame f = new javax.swing.JFrame();
		
		// set the preferred and minimum sizes of the frame
		f.setPreferredSize(new java.awt.Dimension(width, height));
		f.setMinimumSize(new java.awt.Dimension(width, height));
		
		// specify that the program will exit when the frame is closed
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		// create the five buttons
		javax.swing.JButton westButton = new javax.swing.JButton("west");
		javax.swing.JButton eastButton = new javax.swing.JButton("east");
		javax.swing.JButton northButton = new javax.swing.JButton("north");
		javax.swing.JButton southButton = new javax.swing.JButton("south");
		javax.swing.JButton centerButton = new javax.swing.JButton("center");
				
		// create the panel with a border layout
		javax.swing.JPanel mainPanel = new javax.swing.JPanel();
		mainPanel.setLayout(new java.awt.BorderLayout());
		
		// add the five buttons to the panel
		mainPanel.add(centerButton, java.awt.BorderLayout.CENTER);
		mainPanel.add(westButton, java.awt.BorderLayout.WEST);
		mainPanel.add(eastButton, java.awt.BorderLayout.EAST);
		mainPanel.add(northButton, java.awt.BorderLayout.NORTH);
		mainPanel.add(southButton, java.awt.BorderLayout.SOUTH);
		
		// create the action listeners for the buttons
		ButtonActionListener centerButtonActionListener = new ButtonActionListener(centerButton);
		ButtonActionListener westButtonActionListener = new ButtonActionListener(westButton);
		ButtonActionListener eastButtonActionListener = new ButtonActionListener(eastButton);
		ButtonActionListener northButtonActionListener = new ButtonActionListener(northButton);
		ButtonActionListener southButtonActionListener = new ButtonActionListener(southButton);
		
		// add the action listeners to the buttons
		centerButton.addActionListener(centerButtonActionListener);
		westButton.addActionListener(westButtonActionListener);
		eastButton.addActionListener(eastButtonActionListener);
		northButton.addActionListener(northButtonActionListener);
		southButton.addActionListener(southButtonActionListener);
		
		// add the panel to the frame as the content pane
		f.setContentPane(mainPanel);
		
		// validate the frame and put it on the screen
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
}
