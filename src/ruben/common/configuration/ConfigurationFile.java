package ruben.common.configuration;

import java.util.Iterator;
import java.util.TreeMap;

import processing.core.PApplet;

public class ConfigurationFile implements IConfigurationFile {

	private String _fileName;
	private PApplet _pApplet;
	private TreeMap<String, String> _map;
	
	public ConfigurationFile(PApplet pApplet, String file) {
		_fileName = file;
		_pApplet = pApplet;
		Init();
	}

	private void Init() {
		String[] lines = _pApplet.loadStrings(_fileName);
		_map = new TreeMap<String, String>();

		for (int i = 0; i < lines.length; i++) {
			int sep = lines[i].indexOf("=");

			if (sep > 0) {
				String key = lines[i].substring(0, sep).trim();
				String value = lines[i].substring(sep + 1, lines[i].length())
						.trim();
				_map.put(key, value == "" ? " " : value);

			}
		}
	}
	
	public String get(String key) {

		return _map.get(key);
	}
	
	public Iterator<String> keys() {
		return _map.keySet().iterator();
	}

}
