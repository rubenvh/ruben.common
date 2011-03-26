/**
 * 
 */
package ruben.common.drawing;


/**
 * @author ruben
 *
 */
public class FaderVisitor extends GraphicObjectVisitor
{
	private int _decay_time1 = 0;
	private int _decay_time2 = 0;
	private int _lower_bound = 0;
	
	public FaderVisitor(int decay_time1, int decay_time2, int lower_bound)
	{
		_decay_time1 = decay_time1;
		_decay_time2 = decay_time2;
		_lower_bound = lower_bound;
	}
	
	
	private void Fade(IGraphicObject g)
	{
		if (g.GetAge()<=_decay_time1)
		{
			
			double angle = Math.min(g.GetAge(), _decay_time1) * Math.PI / (2 * _decay_time1);
			double cos_angle = Math.cos(angle);
			int newColor = (int) Math.max(Math.round(255 * cos_angle), _lower_bound);
			g.SetColor(newColor);
			
//			PApplet.println("AGE: " + g.GetAge()+"  COS: "+ cos_angle + "  NEWCOLOR: " + newColor);
		}
		else if (g.GetAge()-_decay_time1 <=  _decay_time2)
		{
			int x = (int) Math.max(g.GetAge()-_decay_time1, 0);
			int y = _lower_bound - ((_lower_bound * x)/_decay_time2);
			g.SetColor(y);
			
			//PApplet.println("AGE: " + g.GetAge()+"  X: "+ x + "  NEWCOLOR: " + y);
		}

		g.Age();
	}
	
	/* (non-Javadoc)
	 * @see autoperspective.visitors.GraphicObjectVisitor#Visit(autoperspective.gobjects.Point)
	 */
	@Override
	public void Visit(Point g)
	{		
		Fade(g);
	}

	/* (non-Javadoc)
	 * @see autoperspective.visitors.GraphicObjectVisitor#Visit(autoperspective.gobjects.Line)
	 */
	@Override
	public void Visit(Line g)
	{
		Fade(g);
	}


	@Override
	public void Visit(Text g) 
	{
		Fade(g);		
	}
	
}
