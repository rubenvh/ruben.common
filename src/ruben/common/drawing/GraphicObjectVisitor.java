package ruben.common.drawing;

public abstract class GraphicObjectVisitor implements IGraphicObjectVisitor
{
	/**
	 * @param g
	 */
	public abstract void Visit(Point g);

	/**
	 * @param g
	 */
	public abstract void Visit(Line g);

	/**
	 * @param g
	 */
	public void Visit(GraphicComposite g)
	{
		VisitChildren(g);
	}

	/**
	 * @param g
	 */
	public void Visit(Polygon g)
	{
		VisitChildren(g);
	}
	
	
	protected void VisitChildren(GraphicComposite g)
	{
		// TODO: make subclasses use this helper method for visiting their children
		for (int i = 0; i <= g.GetChildren().size() - 1; i++) {
			IGraphicObject child = (IGraphicObject) g.GetChildren().get(i);
			child.Accept(this);
		}
	}

}
