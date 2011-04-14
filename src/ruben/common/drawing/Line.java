package ruben.common.drawing;

public class Line extends GraphicObject implements IGraphicObject {

	//
	// Fields
	//
	
	private Point _p1;
	private Point _p2;

	public Line(int x1, int y1, int x2, int y2) 
	{
		_p1 = new Point(x1, y1);
		_p2 = new Point(x2, y2);
	}
	
	public Line(Point p1, Point p2)
	{
		this._p1 = p1;
		this._p2 = p2;
	}


	/**
	 * Set the value of p1
	 * 
	 * @param newVar
	 *            the new value of p1
	 */
	public void setP1(Point newVar) {
		_p1 = newVar;
	}

	/**
	 * Get the value of p1
	 * 
	 * @return the value of p1
	 */
	public Point getP1() {
		return _p1;
	}

	/**
	 * Set the value of p2
	 * 
	 * @param newVar
	 *            the new value of p2
	 */
	public void setP2(Point newVar) {
		_p2 = newVar;
	}

	/**
	 * Get the value of p2
	 * 
	 * @return the value of p2
	 */
	public Point getP2() {
		return _p2;
	}

	//
	// Other methods
	//
	
	
	public IGraphicObject SetColor(int color) {
		
		_p1.SetColor(color);
		_p2.SetColor(color);
		
		return super.SetColor(color);
	}
	
	
	public IGraphicObject SetLineSize(int size) { 
		_p1.SetLineSize(size);
		_p2.SetLineSize(size);
		return super.SetLineSize(size);
	}

	/**
	 * @param v
	 */
	public void Accept(IGraphicObjectVisitor v) {
		v.Visit(this);
	}

	public String ToString() {
		return "Line " + _p1.ToString() + "+" + _p2.ToString();
	}

	@Override
	public IGraphicObject Clone()
	{
		return new Line((Point)_p1.Clone(), (Point)_p2.Clone());
	}
	
	public double CalcDistance(Point p)
	{
		
		int x = p.getX();
		int y = p.getY();
		int x1 = getP1().getX();
		int y1 = getP1().getY();
		int x2 = getP2().getX();
		int y2 = getP2().getY();
		
		if (x1 == x2 || y1 == y2) return 0;
		double dist = (y - y1)/(y2 - y1) - (x - x1)/(x2-x1);
		return dist;
//			(getP2().getX()-getP1().getX())*(p.getY()-getP1().getY()) - 
//			(getP2().getY()-getP1().getY())*(p.getX()-getP1().getX());
			
	}
	
	

}