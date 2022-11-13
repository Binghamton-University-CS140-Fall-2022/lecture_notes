class DrawingArea extends javax.swing.JPanel implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, java.awt.event.KeyListener, java.awt.event.ComponentListener
{
	private int maxWidth, maxHeight;
	private java.awt.image.BufferedImage bi;
	private java.awt.image.BufferedImage bi2;
	private java.awt.Color backgroundColor, lineColor, defaultLineColor, axisLineColor, sinLineColor, cosLineColor, tanLineColor;
	private java.awt.Graphics2D biG;
	private int imageWidth;
	private int imageHeight;
	private int lastX;
	private int lastY;
	private String filename;
	double scaleX = 100.0;
	double scaleY = 100.0;
	
	public DrawingArea(String filename)
	{
		this.filename = filename;
		java.awt.Dimension maxDim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("maxDim = " + maxDim);
		maxWidth = (int) Math.max(2592, maxDim.getWidth());
		maxHeight = (int) Math.max(1944, maxDim.getHeight());
		setPreferredSize(new java.awt.Dimension(maxWidth, maxHeight));
		bi = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(maxWidth, maxHeight, java.awt.image.BufferedImage.TYPE_INT_ARGB);
		biG = bi.createGraphics();
		
		defaultLineColor = new java.awt.Color(0, 0, 0, 255);
		lineColor = defaultLineColor;
		backgroundColor = new java.awt.Color(255, 255, 255, 255);
		axisLineColor = new java.awt.Color(255, 0, 0, 255);
		sinLineColor = new java.awt.Color(0, 255, 0, 255);
		cosLineColor = new java.awt.Color(0, 0, 255, 255);
		tanLineColor = new java.awt.Color(100, 255, 255, 255);
		
		lastX = -1;
		lastY = -1;
		
		biG.setColor(backgroundColor);
		biG.fillRect(0, 0, maxWidth, maxHeight);
		biG.setColor(lineColor);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		bi2 = null;
		if( filename.length() > 0 )
		{
			try
			{
				bi2 = javax.imageio.ImageIO.read(new java.io.File(filename));
				biG.drawImage(bi2, 0, 0, null);
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
				System.exit(0);
			}
		}
		
		repaint(0);		
	}
	
	public void setLineColor(java.awt.Color color)
	{
		lineColor = color;
		biG.setColor(lineColor);
	}
	
	public void writeImage(String filename, String imageType)
	{	
		try
		{
			javax.imageio.ImageIO.write(bi, imageType, new java.io.File(filename));
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	// plot the sin, cos, and tan value in [-2i, 2pi]
	// we will treat each pixel as a 100th of a unit 100 pixels = 1 on the "real" line
	public void plotSineAndCosineAndTangent()
	{
		biG.setColor(backgroundColor);
		biG.fillRect(0, 0, maxWidth, maxHeight);
		biG.setColor(lineColor);
		
		// the x origin for the x-axis
		int originX = 700;
		
		// the y origin for the y-axis
		int originY = 400;
		
		// the x-axis length (in each direction)
		int graphWidth = 630;
		
		// the y-axis height (in each direction)
		int graphHeight = (int) (1*scaleY);
		
		// how often we will calculate the various functions
		double dX = 0.01;
		
		// change the line color to the axis line color
		biG.setColor(axisLineColor);
		
		// draw the right half of the x-axis
		biG.drawLine(originX,  originY,  originX+graphWidth,  originY);
		
		// draw the left half of the x-axis
		biG.drawLine(originX,  originY,  originX-graphWidth,  originY);
		
		// draw the upper half of the y-axis
		biG.drawLine(originX,  originY,  originX,  originY-graphHeight);
		
		// draw the lower half of the y-axis
		biG.drawLine(originX,  originY,  originX,  originY+graphHeight);
		
		// set the line color for the sine graph
		biG.setColor(sinLineColor);
		
		// x0 is -2pi (in pixels), the other are to define a lines segment of sine, cosine, or tangent
		double x0 = -628.31853072;
		double y0 = 0.0;
		double x1 = 0.0;
		double y1 = 0.0;
		
		// loop over the values of x in [-2pi, 2pi]
		while( x0 <= 628.31853072 )
		{
			// calulate sin of the current x value, scale the result by 100 (to pixels), and negate since up is negative
			y0 = -Math.sin(x0/scaleX)*scaleY;
			
			// get the x endpoint of the line segment
			x1 = x0+dX;
			
			// compute the y endpoint of the line segment 
			y1 = -Math.sin(x1/scaleX)*scaleY;
			
			// convert the line segment coordinate to int and translate to the origin ((originX, originY))
			int px0 = (int) x0+originX;
			int px1 = (int) x1+originX;
			int py0 = (int) y0+originY;
			int py1 = (int) y1+originY;
			
			// draw the current line segment
			biG.drawLine(px0,  py0,  px1,  py1);
			
			// update x0 to be the start of the next line segment
			x0 = x0+dX;
		}
		
		biG.setColor(cosLineColor);
				
		x0 = -628.31853072;
		
		while( x0 <= 628.31853072 )
		{
			y0 = -Math.cos(x0/scaleX)*scaleY;
			x1 = x0+dX;
			y1 = -Math.cos(x1/scaleX)*scaleY;
			
			int px0 = (int) x0+originX;
			int px1 = (int) x1+originX;
			int py0 = (int) y0+originY;
			int py1 = (int) y1+originY;
			
			biG.drawLine(px0,  py0,  px1,  py1);
			
			if( Math.abs(y0) < dX )
			{
				//System.out.println("x0 = " + (x0/scaleX));
			}
			
			x0 = x0+dX;
		}
			
		biG.setColor(tanLineColor);
		
		x0 = -628.31853072;
		
		while( x0 <= 628.31853072 )
		{
			y0 = -Math.tan(x0/scaleX)*scaleY;
			x1 = x0+dX;
			y1 = -Math.tan(x1/scaleX)*scaleY;
			
			int px0 = (int) x0+originX;
			int px1 = (int) x1+originX;
			int py0 = (int) y0+originY;
			int py1 = (int) y1+originY;
			
			//if( (Math.abs((x0/scaleX)-(Math.PI/2.0)) > 0.001) && (Math.abs((x0/scaleX)-(-Math.PI/2.0)) > 0.001)
			//		&& (Math.abs((x0/scaleX)-(3.0*Math.PI/2.0)) > 0.001) && (Math.abs((x0/scaleX)-(-3.0*Math.PI/2.0)) > 0.001) )
			//if( Math.abs(Math.cos(x0/scaleX)*scaleY) > 0.5 )
			if( Math.abs(Math.cos(x0/scaleX)) > 0.01 )
			{
				biG.drawLine(px0,  py0,  px1,  py1);
			}
			else
			{
				//System.out.println("x0 = " + x0);
			}
			
			x0 = x0+dX;
		}
		
		biG.setColor(lineColor);
		
		repaint(0);
	}
				
	public void componentHidden(java.awt.event.ComponentEvent e)
	{
	}
	
	public void componentShown(java.awt.event.ComponentEvent e)
	{
	}
	
	public void componentMoved(java.awt.event.ComponentEvent e)
	{
	}
	
	public void componentResized(java.awt.event.ComponentEvent e)
	{
	}
	
	public void mouseEntered(java.awt.event.MouseEvent e)
	{
	}
	
	public void mouseExited(java.awt.event.MouseEvent e)
	{
	}
	
	public void mousePressed(java.awt.event.MouseEvent e)
	{
		lastX = e.getX();
		lastY = e.getY();
	}
	
	public void mouseReleased(java.awt.event.MouseEvent e)
	{
	}
	
	public void mouseClicked(java.awt.event.MouseEvent e)
	{
	}
	
	public void mouseDragged(java.awt.event.MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		
		if( (lastX >= 0) && (lastY >= 0) )
		{
			biG.drawLine(lastX, lastY, x, y);
			lastX = x;
			lastY = y;
			repaint(0);
		}
		else
		{
			lastX = x;
			lastY = y;
		}
	}
	
	public void mouseMoved(java.awt.event.MouseEvent e)
	{
	}
	
	public void keyPressed(java.awt.event.KeyEvent e)
	{
		if( e.getKeyCode() == e.VK_C )
		{
			biG.setColor(backgroundColor);
			biG.fillRect(0, 0, maxWidth, maxHeight);
			if( filename.length() > 0 )
			{
				biG.drawImage(bi2, 0, 0, null);
			}
			biG.setColor(lineColor);
			lastX = -1;
			lastY = -1;
			
			repaint(0);	
		}
		
		if( e.getKeyCode() == e.VK_R )
		{
			biG.setColor(backgroundColor);
			biG.fillRect(0, 0, maxWidth, maxHeight);
			if( filename.length() > 0 )
			{
				biG.drawImage(bi2, 0, 0, null);
			}
			lineColor = defaultLineColor;
			biG.setColor(lineColor);
			lastX = -1;
			lastY = -1;
			
			repaint(0);	
		}
		
		if( e.getKeyCode() == e.VK_X )
		{
			if( e.isShiftDown() )
			{
				scaleX = scaleX+1.0;
			}
			else
			{
				scaleX = scaleX-1.0;
			}
			plotSineAndCosineAndTangent();
		}
		
		if( e.getKeyCode() == e.VK_Y )
		{
			if( e.isShiftDown() )
			{
				scaleY = scaleY+1.0;
			}
			else
			{
				scaleY = scaleY-1.0;
			}
			plotSineAndCosineAndTangent();
		}
	}
	
	public void keyReleased(java.awt.event.KeyEvent e)
	{
	}
	
	public void keyTyped(java.awt.event.KeyEvent e)
	{
	}
	
	public void paintComponent(java.awt.Graphics g)
	{
		super.paintComponent(g);
		if( bi == null )
		{
			return;
		}
		g.drawImage(bi, 0, 0, null);
	}
}
