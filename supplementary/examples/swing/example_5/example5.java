class example5
{
	private static int width = 400;
	private static int height = 400;
	
	public static void main(String[] args)
	{
		String[] formatNames = javax.imageio.ImageIO.getReaderFormatNames();
		System.out.println("input format names");
		for( int i = 0; i < formatNames.length; i++ )
		{
			System.out.println("formatNames[" + i + "] = " + formatNames[i]);
		}
		
		formatNames = javax.imageio.ImageIO.getWriterFormatNames();
		System.out.println("output format names");
		for( int i = 0; i < formatNames.length; i++ )
		{
			System.out.println("formatNames[" + i + "] = " + formatNames[i]);
		}
		
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
		javax.swing.JMenuItem fileSave = new javax.swing.JMenuItem("Save");
		javax.swing.JMenuItem editColor = new javax.swing.JMenuItem("Color");
		javax.swing.JMenuItem editColorRed = new javax.swing.JMenuItem("set line color red");
		javax.swing.JMenuItem editColorGreen = new javax.swing.JMenuItem("set line color green");
		javax.swing.JMenuItem editColorBlue = new javax.swing.JMenuItem("set line color blue");
		javax.swing.JMenuItem editColorYellow = new javax.swing.JMenuItem("set line color yellow");
		javax.swing.JMenuItem editPlot = new javax.swing.JMenuItem("plot");
		
		// add the two menus to the menu bar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		
		// add the two menu items to the two menus
		fileMenu.add(fileSave);
		fileMenu.add(fileExit);
		editMenu.add(editColor);
		editMenu.add(editColorRed);
		editMenu.add(editColorGreen);
		editMenu.add(editColorBlue);
		editMenu.add(editColorYellow);
		editMenu.add(editPlot);
		
		String filename = "";
		if( args.length > 0 )
		{
			filename = args[0];
		}
		
		DrawingArea da = new DrawingArea(filename);
		
		// create the panel and add the buttons and menu bar
		javax.swing.JPanel mainPanel = new javax.swing.JPanel();
		mainPanel.setLayout(new java.awt.BorderLayout());
		mainPanel.add(da, java.awt.BorderLayout.CENTER);
		mainPanel.add(menuBar, java.awt.BorderLayout.NORTH);
		
		// create the action listeners for the menu items
		MenuItemActionListener fileSaveMenuItemActionListener = new MenuItemActionListener(fileSave, da);
		MenuItemActionListener fileExitMenuItemActionListener = new MenuItemActionListener(fileExit, da);
		MenuItemActionListener editColorMenuItemActionListener = new MenuItemActionListener(editColor, da);
		MenuItemActionListener editColorRedMenuItemActionListener = new MenuItemActionListener(editColorRed, da);
		MenuItemActionListener editColorGreenMenuItemActionListener = new MenuItemActionListener(editColorGreen, da);
		MenuItemActionListener editColorBlueMenuItemActionListener = new MenuItemActionListener(editColorBlue, da);
		MenuItemActionListener editColorYellowMenuItemActionListener = new MenuItemActionListener(editColorYellow, da);
		MenuItemActionListener editPlotMenuItemActionListener = new MenuItemActionListener(editPlot, da);
		
		// add the action listeners to the menu items
		fileSave.addActionListener(fileSaveMenuItemActionListener);
		fileExit.addActionListener(fileExitMenuItemActionListener);
		editColor.addActionListener(editColorMenuItemActionListener);
		editColorRed.addActionListener(editColorRedMenuItemActionListener);
		editColorGreen.addActionListener(editColorGreenMenuItemActionListener);
		editColorBlue.addActionListener(editColorBlueMenuItemActionListener);
		editPlot.addActionListener(editPlotMenuItemActionListener);
		
		f.setContentPane(mainPanel);
		
		f.validate();
		f.setVisible(true);
		f.setVisible(true);
		f.addComponentListener(da);
		f.addKeyListener(da);
		f.addMouseListener(da);
		f.addMouseMotionListener(da);
	}
	
	// action listener for the menu items
	static class MenuItemActionListener implements java.awt.event.ActionListener
	{
		// the menu item associated with the action listener, so that we can
		// share this one class with multiple menu items
		private javax.swing.JMenuItem m;
		private DrawingArea drawingArea;
		
		MenuItemActionListener(javax.swing.JMenuItem m, DrawingArea drawingArea)
		{
			this.m = m;
			this.drawingArea = drawingArea;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
			System.out.println("action performed on " + m.getText() + " menu item");
			
			// if exit is selected from the file menu, exit the program
			if( m.getText().toLowerCase().equals("exit") )
			{
				System.exit(0);
			}
			
			if( m.getText().toLowerCase().equals("save") )
			{
				drawingArea.writeImage("output.png", "png");
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
			
			if( m.getText().toLowerCase().equals("set line color red") )
			{
				drawingArea.setLineColor(new java.awt.Color(255, 0, 0, 255));
			}
			
			if( m.getText().toLowerCase().equals("set line color green") )
			{
				drawingArea.setLineColor(new java.awt.Color(0, 255, 0, 255));
			}
			
			if( m.getText().toLowerCase().equals("set line color blue") )
			{
				drawingArea.setLineColor(new java.awt.Color(0, 0, 255, 255));
			}
			
			if( m.getText().toLowerCase().equals("set line color yellow") )
			{
				drawingArea.setLineColor(new java.awt.Color(255, 255, 0, 255));
			}
			
			if( m.getText().toLowerCase().equals("plot") )
			{
				drawingArea.plotSineAndCosineAndTangent();
			}
		}
	}
}
