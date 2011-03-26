package ruben.common.drawing;

public interface IGraphicObjectVisitor {
	/**
	 * @param g
	 */
	public void Visit(Point g);

	/**
	 * @param g
	 */
	public void Visit(Line g);

	/**
	 * @param g
	 */
	public void Visit(Text g);
	
	/**
	 * @param g
	 */
	public void Visit(GraphicComposite g);

	/**
	 * @param g
	 */
	public void Visit(Polygon g);
}
