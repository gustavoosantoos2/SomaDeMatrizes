package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		InputStreamReader isReader = new InputStreamReader(System.in);
		BufferedReader bufReader = new BufferedReader(isReader);

		String userInput = "";
		String inputLine = null;
		try { 
			while ((inputLine = bufReader.readLine()) != null)
				userInput += inputLine + "\n";

			String[] parsedLines = parseLines(userInput);
			String[] matricesLines = Arrays.copyOfRange(parsedLines, 1, parsedLines.length);

			int matrixDimensions = Integer.parseInt(parsedLines[0]);

			List<double[][]> matrices = parseMatrices(matricesLines, matrixDimensions);
			double[][] sumResult = sumMatrices(matrices.get(0), matrices.get(1));
			
			for(int linha = 0; linha < sumResult.length; linha++)
				System.out.println(Arrays.toString(sumResult[linha]));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String[] parseLines(String fullText) {
		return fullText.split("\\r?\\n");
	}

	private static List<double[][]> parseMatrices(String[] lines, int dimension) {
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

	private static double[][] sumMatrices(double[][] matrix1, double[][] matrix2) {
		ArrayList<Thread> threads = new ArrayList<>();
		double[][] sum = new double[matrix1.length][matrix1[0].length];

		for (int i = 0; i < sum.length; i++) {
			Thread t = new Thread(new ArraySumThread(matrix1[i], matrix2[i], i, sum));
			t.start();
			threads.add(t);
		}

		threads.forEach(e ->
		{
			try {
				e.join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		
		return sum;
	}
}
