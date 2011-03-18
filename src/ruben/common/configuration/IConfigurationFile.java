package ruben.common.configuration;

import java.util.Iterator;

public interface IConfigurationFile {
	 Iterator<String> keys();
	String get(String key);

}
