package ruben.common.drawing;

import java.io.File;
import java.util.Stack;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

public class MaterializingVisitor implements IGraphicObjectVisitor
{
	Document _document;
	Stack<Element> _stack;
	
	public void print(File file) {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer;
		try
		{
			transformer = transformerFactory.newTransformer();
		}
		catch (TransformerConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
        DOMSource source = new DOMSource(_document);
        StreamResult result =  new StreamResult(file);
        try
		{
			transformer.transform(source, result);
		}
		catch (TransformerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MaterializingVisitor() {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		try
		{
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		}
		catch (ParserConfigurationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		_document = documentBuilder.newDocument();
		Element rootElement = _document.createElement("graphic_objects");
		_document.appendChild(rootElement);
		
		_stack = new Stack<Element>();
		_stack.push(rootElement);
	}

	public void Visit(Point g)
	{
		Element newChild = _document.createElement("point");
		newChild.setAttribute("x", String.valueOf(g.getX()));
		newChild.setAttribute("y", String.valueOf(g.getY()));
		
		
		_stack.peek().appendChild(newChild);
		

	}

	public void Visit(Line g)
	{
		Element newChild = _document.createElement("line");
		newChild.setAttribute("color", String.valueOf(g.GetColor()));
		newChild.setAttribute("size", String.valueOf(g.GetLineSize()));
		_stack.peek().appendChild(newChild);

		_stack.push(newChild);
		
		Visit(g.getP1());
		Visit(g.getP2());
		
		_stack.pop();
	}

	public void Visit(Text g)
	{
		Element newChild = _document.createElement("text");		
		newChild.setAttribute("color", String.valueOf(g.GetColor()));
		newChild.setAttribute("size", String.valueOf(g.GetLineSize()));
		newChild.appendChild(_document.createTextNode(g.getText()));
		_stack.peek().appendChild(newChild);

	}

	public void Visit(GraphicComposite g)
	{
		Element newChild = _document.createElement("graphic_composite");
		_stack.peek().appendChild(newChild);
		_stack.push(newChild);
		VisitChildren(g);
		_stack.pop();
	}

	/**
	 * @param g
	 */
	public void Visit(Polygon g)
	{
		Element newChild = _document.createElement("polygon");
		_stack.peek().appendChild(newChild);
		_stack.push(newChild);
		VisitChildren(g);
		_stack.pop();
	}
	
	
	protected void VisitChildren(GraphicComposite g)
	{
		for (int i = 0; i <= g.GetChildren().size() - 1; i++) {
			IGraphicObject child = (IGraphicObject) g.GetChildren().get(i);
			child.Accept(this);
		}
	}

}
