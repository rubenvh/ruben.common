package ruben.common.drawing;

public class Point extends GraphicObject implements IGraphicObject {

	private int _id;
	private int _x;
	private int _y;

	//
	// Constructors
	//
	public Point(int x, int y) {
		this._x = x;
		this._y = y;
	};

	public Point(Point point) {
		_x = point.getX();
		_y = point.getY();
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
	
	public int get_id() { return _id; }
	public Point set_id(int id) { _id = id; return this; }
	

	//
	// Other methods
	//

	/**
	 * @param v
	 */
	public void Accept(IGraphicObjectVisitor v) 
	{
		v.Visit(this);
	}

	public double CalcDistance(Point p)
	{
		return Math.sqrt(Math.pow(this.getX() - p.getX(), 2)
				+ Math.pow(this.getY() - p.getY(), 2));
	}

	public String ToString() {
		return "Point(" + _x + "," + _y + ")";
	}

	@Override
	public IGraphicObject Clone()
	{
		return new Point(_x, _y);
	}

}