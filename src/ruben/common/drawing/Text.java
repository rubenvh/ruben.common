package ruben.common.drawing;


public class Text extends GraphicObject implements IGraphicObject {
	
	private int _x;
	private int _y;
	private int _formatWidth;
	private int _formatHeight;
	
	private String _text;
	
	public Text(String t, int x, int y)
	{
		_x = x;
		_y = y;
		_formatHeight = 0;
		_formatWidth = 0;
		_text = t;
	}
	
	public Text(String t, int x, int y, int w, int h)
	{
		_x = x;
		_y = y;
		_formatHeight = h;
		_formatWidth = w;
		_text = t;
	}
	
	/**
	 * Set the value of x
	 * 
	 * @param newVar
	 *            the new value of x
	 */
	public void setX(int newVar) {
		_x = newVar;
	}

	/**
	 * Get the value of x
	 * 
	 * @return the value of x
	 */
	public int getX() {
		return _x;
	}

	/**
	 * Set the value of y
	 * 
	 * @param newVar
	 *            the new value of y
	 */
	public void setY(int newVar) {
		_y = newVar;
	}

	/**
	 * Get the value of y
	 * 
	 * @return the value of y
	 */
	public int getY() {
		return _y;
	}
	
	public String getText()
	{
		return _text;
	}
	
	public int getFormatWidth(){return _formatWidth;}
	public int getFormatHeight(){return _formatHeight;}
	
	public Text setText(String text)
	{
		_text = text;
		return this;
	}
	/* (non-Javadoc)
	 * @see autoperspective.gobjects.GraphicObject#Accept(autoperspective.visitors.IGraphicObjectVisitor)
	 */
	@Override
	public void Accept(IGraphicObjectVisitor v) 
	{
		v.Visit(this);
	}

	/* (non-Javadoc)
	 * @see autoperspective.gobjects.GraphicObject#Clone()
	 */
	@Override
	public IGraphicObject Clone() 
	{
		return new Text(_text, _x,_y);
	}

}