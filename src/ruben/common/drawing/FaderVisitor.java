/**
 * 
 */
package ruben.common.drawing;

import java.util.Random;

/**
 * @author ruben
 * 
 */
public class FaderVisitor extends GraphicObjectVisitor
{
	private int _decay_time1 = 0;
	private int _decay_time2 = 0;
	private int _decay_time3 = -1;
	private int _lower_bound1 = 0;
	private int _lower_bound2 = 0;
	private Random _randomizer;

	public FaderVisitor(int decay_time1, int decay_time2, int lower_bound1)
	{
		_decay_time1 = decay_time1;
		_decay_time2 = decay_time2;
		_lower_bound1 = lower_bound1;
		_randomizer = new Random();
	}

	public FaderVisitor(int decay_time1, int decay_time2, int decay_time3,
			int lower_bound1, int lower_bound2)
	{
		this(decay_time1, decay_time2, lower_bound1);
		_decay_time3 = decay_time3;
		_lower_bound2 = lower_bound2;
	}

	private void Fade(IGraphicObject g)
	{
		if (!g.IsDeleted())
		{
			if (g.GetAge() <= _decay_time1)
			{
				// sinoid descend
				double angle = Math.min(g.GetAge(), _decay_time1) * Math.PI
						/ (2 * _decay_time1);
				double cos_angle = Math.cos(angle);
				int newColor = (int) Math.max(Math.round(255 * cos_angle),
						_lower_bound1);
				g.SetColor(newColor);
			}
			else if (g.GetAge() - _decay_time1 <= _decay_time2)
			{
				// linear descend
				int x = (int) Math.max(g.GetAge() - _decay_time1, 0);
				int y = _lower_bound1 + (x * (_lower_bound2 - _lower_bound1))
						/ _decay_time2;
				g.SetColor(y);
			}
			else if (_decay_time3 > 0
					&& (g.GetAge() - _decay_time1 - _decay_time2) <= _decay_time3
					&& g.GetColor() > 0)
			{
				// fluctuate until zero
				g.SetColor(Math.max(0, g.GetColor() + _randomizer.nextInt(6)
						- 2)); // [-2,3]
			}
			else
			{
				g.MarkAsDeleted(true);
				g.SetColor(0);
			}
		}

		g.Age();
	}

	@Override
	public void Visit(Point g)
	{
		Fade(g);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * autoperspective.visitors.GraphicObjectVisitor#Visit(autoperspective.gobjects
	 * .Line)
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
