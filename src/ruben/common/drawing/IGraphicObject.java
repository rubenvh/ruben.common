package ruben.common.drawing;

import java.util.List;

public interface IGraphicObject
{

	/**
	 * @param v
	 */
	public void Accept(IGraphicObjectVisitor v);

	/**
	 * @param g
	 */
	public void Add(IGraphicObject g);

	/**
	 * @param g
	 */
	public void Remove(IGraphicObject g);

	/**
	 * 
	 * @return
	 */
	public int Count();

	public boolean GetSelected();
	
	public void SetSelected(boolean s);
	
	public String ToString();

	public List<IGraphicObject> GetChildren();
	
	public IGraphicObject Clone();
	
	public int GetColor();
	public IGraphicObject SetColor(int color);
	
	public long GetAge();
	public IGraphicObject Age();
	
	public int GetLineSize();
	public IGraphicObject SetLineSize(int size);
	
	// public ArrayList<IGraphicObject> GetChildren();

}
