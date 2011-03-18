package ruben.common.datastructures;

import java.util.ArrayDeque;
import java.util.Iterator;


public class WindowedStack<T> implements IWindowedStack<T> {

	private int _windowSize;
	private ArrayDeque<T> _arrayDeque;
	
	public WindowedStack(int windowSize)
	{
		if (windowSize <= 0) windowSize = 1;
		_windowSize = windowSize;
		_arrayDeque = new ArrayDeque<T>(windowSize);
	}
	
	
	public T get(int index) {
		
		if (index >= _arrayDeque.size()) return null;
		if (index < 0) return null;
		
		Iterator<T> it = _arrayDeque.descendingIterator();
		int temp = index-1;
		while (temp >= 0)
		{
			it.next();
			temp--;
		}
		
		return it.next();
	}

	
	public T current() {
		
		return _arrayDeque.peekLast();
	}

	
	public void push(T el) {
		
		if (_arrayDeque.size() >= _windowSize)
		{
			_arrayDeque.pollFirst();
		}
		
		_arrayDeque.addLast(el);		
	}

	
	public int window_size() {

		return _windowSize;
	}

	
	public int size() {
		
		return _arrayDeque.size();
	}

}
