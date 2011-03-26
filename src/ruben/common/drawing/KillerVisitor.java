/**
 * 
 */
package ruben.common.drawing;

import java.util.ArrayList;

/**
 * @author ruben
 *
 */
public class KillerVisitor extends GraphicObjectVisitor
{

	//
	// Fields
	//
	private int _delta = 0;
	private Point _ref;
	private ArrayList<IGraphicObject> _purgeList;

	//
	// Constructors
	//
	public KillerVisitor(int delta, Point ref) {
		_ref = ref;
		_delta = delta;
		_purgeList = new ArrayList<IGraphicObject>(); 
	};
	
	/**
	 * @param g
	 */
	public void Visit(Point g) 
	{
		if (KillCheck(g))
		{
			_purgeList.add(g);
		}
	}

	/**
	 * @param g
	 */
	public void Visit(Line g) 
	{		
		if (KillCheck(g))
		{
			_purgeList.add(g);
		}
	}
	
	private boolean KillCheck(Point p)
	{
		double d = _ref.CalcDistance(p);
		return d < _delta;
	}
	private boolean KillCheck(Line l)
	{
//		boolean check_p1 = KillCheck(l.getP1());
//		boolean check_p2 = KillCheck(l.getP1());
//		double distance = l.CalcDistance(_ref);
//		boolean check_line = distance < _delta;
		return KillCheck(l.getP1())||KillCheck(l.getP2())||(l.CalcDistance(_ref) < _delta);
	}
	
	/**
	 * @param g
	 */
	public void Visit(GraphicComposite g)
	{
		super.Visit(g);
		
		g.GetChildren().removeAll(_purgeList);
		_purgeList.clear();
	}

	@Override
	public void Visit(Text g) {
		// TODO Auto-generated method stub
		
	}

}
