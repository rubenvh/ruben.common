package ruben.common.drawing;

import java.util.ArrayList;
import java.util.List;

abstract public class GraphicObject implements IGraphicObject {

	private boolean _isSelected = false;
	private int _color = 255;
	private int _lineSize = 1;
	private long _age = 0;
	
	public abstract IGraphicObject Clone();
	
	/**
	 * @param v
	 */
	public abstract void Accept(IGraphicObjectVisitor v);

	/**
	 * @param g
	 */
	public void Add(IGraphicObject g) 	{	}

	/**
	 * @param g
	 */
	public void Remove(IGraphicObject g) {	}

	public int Count() 
	{
		return 1;
	};

	public String ToString()
	{
		return "TOSTRING_NOT_IMPLEMENTED";
	}

	public List<IGraphicObject> GetChildren() 
	{
		return new ArrayList<IGraphicObject>();
	}
	
	public boolean GetSelected() { return _isSelected; }
	public void SetSelected(boolean s)	{ _isSelected = s;	}
	
	public int GetColor() { return _color; }
	public IGraphicObject SetColor(int color) { _color = color; return this; }
	
	public int GetLineSize() { return _lineSize; }
	public IGraphicObject SetLineSize(int size) { _lineSize = size; return this; }
	
	public long GetAge() { return _age; }
	public IGraphicObject Age() { _age++; return this; }

}
