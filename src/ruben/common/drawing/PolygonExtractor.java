package ruben.common.drawing;

/**
 * Class PolygonExtractor
 */
public class PolygonExtractor extends GraphicObjectVisitor {

	private Point _startingPoint = null;
	private Polygon _polygon = null;
	private boolean _polygonFound = false;

	public PolygonExtractor() {
		_polygon = new Polygon();
	};
	
	
	public Polygon GetResult() { return _polygon; }
	public boolean PolygonFound() { return _polygonFound; }


	/**
	 * @param g
	 */
	public void Visit(Point g) {

	}

	/**
	 * @param g
	 */
	public void Visit(Line g) {
		//PApplet.println("Line " + g.ToString());
		if (_startingPoint == null) {

			_polygonFound = false;
			_startingPoint = g.getP1();
			_polygon.Add(g);
//			PApplet.println("        startingPoint "
//					+ _startingPoint.ToString());
		} else {
			if (_startingPoint.CalcDistance(g.getP2()) == 0) {
//				PApplet.println("        PolygonFound");
				_polygon.Add(g);
				_polygonFound = true;
			} else {
//				PApplet.println("        Polygon.Add");
				_polygon.Add(g);
			}
		}
	}


	@Override
	public void Visit(Text g) {
		// TODO Auto-generated method stub
		
	}
}
