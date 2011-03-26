package ruben.common.drawing;


public interface IDrawingSystem {

	/**
	 * @param x
	 * @param y
	 */
	public abstract void SetDrawingPen(Point p);

	public abstract void DrawingAid(Point target);

	public abstract Point AddPoint(Point target);

	public abstract Text AddText(String text, Point target);

	public abstract Text AddText(Text text);

	/**
	 * @param x1
	 * @param y1
	 */
	public abstract Point AddLine(Point target);

	public abstract void Wipe(Point target);
	
	public abstract void Remove(IGraphicObject g);

	public abstract void Undo();
	
	public abstract IGraphicObject GetGraphics();
	
	public abstract Point GetPen();

}