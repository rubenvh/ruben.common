package ruben.common.datastructures;

public class Location {
	
	int _x, _y;
	
	public Location(int x, int y)
	{
		_x = x;
		_y = y;		
	}
	
	public int get_x() { return _x; }
	public int get_y() { return _y; }
	public Location set_x(int x) { _x = x; return this; }
	public Location set_y(int y) { _y = y; return this; }
	public boolean is_origin() { return _x == 0 && _y == 0; }
	

}
