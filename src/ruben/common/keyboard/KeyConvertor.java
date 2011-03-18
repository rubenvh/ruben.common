package ruben.common.keyboard;

public class KeyConvertor {

	public static char get_char(String value) {
		if (value.startsWith("\\")) {
			return (char) Integer.parseInt(value.substring(2), 16);
		} else {
			return value.charAt(0);
		}
	}
}
