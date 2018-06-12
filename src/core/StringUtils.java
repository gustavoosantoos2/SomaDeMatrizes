package core;

public class StringUtils {
	public static String[] parseToArray(String fullText) {
		return fullText.split("\\r?\\n");
	}
}	
