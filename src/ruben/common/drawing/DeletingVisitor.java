package ruben.common.drawing;

import java.util.ArrayList;

public class DeletingVisitor extends GraphicObjectVisitor
{
	private ArrayList<IGraphicObject> _purgeList;

	public DeletingVisitor()
	{
		_purgeList = new ArrayList<IGraphicObject>();
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

	public void Visit(Point g)
	{
		if (g.IsDeleted())
		{
			_purgeList.add(g);
		}
	}

	public void Visit(Line g)
	{
		if (g.IsDeleted() || g.getP1().IsDeleted() || g.getP2().IsDeleted())
		{
			_purgeList.add(g);
		}

	}

	public void Visit(Text g)
	{

	}

}
