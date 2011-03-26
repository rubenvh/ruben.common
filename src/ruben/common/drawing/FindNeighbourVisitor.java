package ruben.common.drawing;


public class FindNeighbourVisitor extends GraphicObjectVisitor
{

	//
	// Fields
	//
	private int _delta = 0;
	private Point _ref;
	private Point _result;

	public Point GetResult() {
		return _result;
	}

	//
	// Constructors
	//
	public FindNeighbourVisitor(int delta, Point ref) {
		_ref = ref;
		_delta = delta;
		_result = null;
	};

	/**
	 * @param g
	 */
	public void Visit(Point g) {
		double d = _ref.CalcDistance(g);
		if (d < _delta)
			_result = g;
	}

	/**
	 * @param g
	 */
	public void Visit(Line g) 
	{
		Visit(g.getP1());
		Visit(g.getP2());

	}

	@Override
	public void Visit(Text g)
	{
		// DO NOTHING
		
	}

}
