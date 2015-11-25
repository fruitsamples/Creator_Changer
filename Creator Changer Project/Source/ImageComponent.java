import java.awt.Dimension;import java.awt.Component;import java.awt.Image;import java.awt.Graphics;/** * ImageComponent * * @author Levi Brown * @version 1.0 11/2/98 */public class ImageComponent extends Component{    /**     * Constructs a default ImageComponent.     */	public ImageComponent()	{		image = null;	}    /**     * Returns the image being displayed.     */	public Image getImage()	{		return image;	}    /**     * Sets the image being displayed.     */	public void setImage(Image image)	{		this.image = image;		repaint();	}	/**	 * Paints this component using the given graphics context.     * This is a standard Java AWT method which typically gets called     * by the AWT to handle painting this component. It paints this component     * using the given graphics context. The graphics context clipping region     * is set to the bounding rectangle of this component and its [0,0]     * coordinate is this component's top-left corner.     *     * @param g the graphics context used for painting     * @see java.awt.Component#repaint     * @see java.awt.Component#update	 */	public void paint(Graphics g)	{		if (image != null)		{			g.drawImage(image, 0, 0, this);		}	}		/**      * Returns the preferred size of this component.     * @see java.awt.Component#getMinimumSize     * @see LayoutManager     */    public Dimension getPreferredSize()    {    	if (image == null)    		return super.getPreferredSize();    	else    		return new Dimension(image.getWidth(this), image.getHeight(this));	}	protected Image image;}