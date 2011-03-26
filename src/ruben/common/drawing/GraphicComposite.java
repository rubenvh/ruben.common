package ruben.common.drawing;

import java.util.ArrayList;
import java.util.List;

public class GraphicComposite extends GraphicObject implements IGraphicObject {

	//
	// Fields
	//

	private ArrayList<IGraphicObject> _graphicObjects;

	//
	// Constructors
	//
	public GraphicComposite() 
	{
		_graphicObjects = new ArrayList<IGraphicObject>();
	};

	/**
	 * @param g
	 */
	public void Add(IGraphicObject g) 
	{
		_graphicObjects.add(g);
	}

	/**
	 * @param g
	 */
	public void Remove(IGraphicObject g) 
	{
		_graphicObjects.remove(g);
	}

	/**
	 * 
	 */
	public void RemoveLast()
	{
		if (_graphicObjects.size() > 0)
			_graphicObjects.remove(_graphicObjects.size() - 1);
	}

	public List<IGraphicObject> GetChildren() 
	{
		return _graphicObjects;
	}

	/**
	 * @param v
	 */
	public void Accept(IGraphicObjectVisitor v) 
	{
		v.Visit(this);
	}

	public int Count() 
	{
		int count = 0;
		for (int i = _graphicObjects.size() - 1; i >= 0; i--) 
		{
			IGraphicObject g = _graphicObjects.get(i);
			count += g.Count();
		}
		return count;
	}

	@Override
	public IGraphicObject Clone()
	{
		GraphicComposite g = new GraphicComposite();
		
		for (int i = 0; i <= g.GetChildren().size() - 1; i++) 
		{
			IGraphicObject child = g.GetChildren().get(i);
			g.Add(child.Clone());
		}
		return g;
	}

}