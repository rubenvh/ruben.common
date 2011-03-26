package ruben.common.drawing;


public class TranslationVisitor extends GraphicObjectVisitor 
{

	//
	// Fields
	//
	private Point _from;
	private Point _to;

	//
	// Constructors
	//
	public TranslationVisitor(Point from, Point to) {
		_from = from;
		_to = to;		
	};

	/**
	 * @param g
	 */
	public void Visit(Point g) {
		
		g.setX(g.getX()-(_from.getX()-_to.getX()));
		g.setY(g.getY()-(_from.getY()-_to.getY()));
	}

	/**
	 * @param g
	 */
	public void Visit(Line g) {
		
		Visit(g.getP1());
		Visit(g.getP2());
	}

	@Override
	public void Visit(Text g) {
		// TODO Auto-generated method stub
		
	}

}

