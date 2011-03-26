package ruben.common.drawing;


public class FindPolygon extends GraphicObjectVisitor
{
	private Point _ref;
	private int _delta = 0;
	private Point _neighbour;
	
	private Polygon _result;
	public Polygon GetResult() { return _result; }
	
	public FindPolygon(int delta, Point ref)
	{
		this._ref = ref;
		_delta = delta;
	}
	
	/**
	 * @param g
	 */
	public void Visit(Point g)
	{
		double d = _ref.CalcDistance(g);
		if (d < _delta)
		{
			if (_neighbour != null)
			{
				if (_neighbour.CalcDistance(_ref) > d)
				{
					_neighbour = g;
				}
			}
			else
			{
				_neighbour = g;
			}
		}
		
			
		
	}

	/**
	 * @param g
	 */
	public void Visit(Line g) 
	{
		Visit(g.getP1());
		Visit(g.getP2());
	}

	

	/**
	 * @param g
	 */
	public void Visit(Polygon g) {
		if (_result == null)
		{
			super.Visit(g);
			
			if (_neighbour != null)
			{
				_result = g;
			}
			
		}
	}

	@Override
	public void Visit(Text g) {
		// TODO Auto-generated method stub
		
	}

}
