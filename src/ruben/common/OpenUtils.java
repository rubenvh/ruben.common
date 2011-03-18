package ruben.common;

import javax.swing.JFileChooser;

public class OpenUtils {

	private static OpenUtils _instance = null;
	public static OpenUtils get_instance() {
		if (_instance == null) _instance = new OpenUtils();
		return _instance;
	}
	
	private JFileChooser _dialog;
	
	private OpenUtils() {
	
		_dialog = new JFileChooser(".");
	}
	
	public String open_file() {
		return open(JFileChooser.FILES_ONLY);
	}
	
	public String open_dir() {
		
		return open(JFileChooser.DIRECTORIES_ONLY);
	}
	
	private String open(int fileSelectionMode){
	
		_dialog.setFileFilter(_dialog.getAcceptAllFileFilter());
		_dialog.setFileSelectionMode(fileSelectionMode);
		
		String result = "";
		int returnVal = _dialog.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			result = _dialog.getSelectedFile().getAbsolutePath();
		}
		
		return result;
	
	}
}
