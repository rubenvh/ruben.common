package ruben.common.drawing;


public class Polygon extends GraphicComposite implements IGraphicObject, Cloneable {

	
	public Polygon() 
	{
	};

	
	/**
	 * @param v
	 */
	public void Accept(IGraphicObjectVisitor v) {

		v.Visit(this);
	}

	/**
	 * only allow lines to be added
	 * 
	 * @param g
	 */
	public void Add(IGraphicObject g) 
	{
		// TODO: check if type of g is line

		super.Add(g);
	}

	public int Count() {

		return 1;
	}
	
	@Override
	public IGraphicObject Clone()
	{
		GraphicComposite g = new Polygon();
		
		for (int i = 0; i <= this.GetChildren().size() - 1; i++) 
		{
			IGraphicObject child = this.GetChildren().get(i);
			g.Add(child.Clone());
		}
		return g;
	}
	
	
}
