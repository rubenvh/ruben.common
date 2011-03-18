package ruben.common.datastructures;

public interface IWindowedStack<T> {
	
	int window_size();
	int size();
	void push(T el);
	T get(int index);
	T current();
	
}
