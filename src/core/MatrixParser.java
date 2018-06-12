package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixParser {
	public static List<double[][]> parse(String[] lines, int dimension) {
		List<double[][]> wrapper = new ArrayList<>();

		int collumnsNumber = lines[0].split(" ").length;
		double[][] firstMatrix = new double[dimension][collumnsNumber];
		double[][] secondMatrix = new double[dimension][collumnsNumber];

		String[] firstMatrixLines = Arrays.copyOfRange(lines, 0, dimension);
		String[] secondMatrixLines = Arrays.copyOfRange(lines, dimension, lines.length);

		firstMatrix = parseLinesToMatrix(firstMatrixLines, dimension, collumnsNumber);
		secondMatrix = parseLinesToMatrix(secondMatrixLines, dimension, collumnsNumber);

		wrapper.add(firstMatrix);
		wrapper.add(secondMatrix);
		return wrapper;
	}
	
	private static double[][] parseLinesToMatrix(String[] firstMatriceLines, int lines, int collumns) {
		double[][] matrice = new double[lines][collumns];

		for (int line = 0; line < firstMatriceLines.length; line++) {
			List<String> lineNumbers = Arrays.asList(firstMatriceLines[line].split(" "));
			matrice[line] = lineNumbers.stream().mapToDouble(e -> Double.parseDouble(e)).toArray();
		}

		return matrice;
	}
}
