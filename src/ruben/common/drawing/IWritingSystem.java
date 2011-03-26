package ruben.common.drawing;

public interface IWritingSystem 
{
	
	public abstract IWritingSystem Write(String text);
	
	public abstract IWritingSystem Backspace();

}
