package ruben.common.state;

public interface IParameter<T extends Number & Comparable<T>> {
	
	IParameter<T> set_value(T value);
	T get_value();
	
}
