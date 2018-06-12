package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import core.matrix.MatrixCalculator;
import core.matrix.MatrixParser;
import core.utils.StringUtils;

public class Program {

	public static void main(String[] args) {
		InputStreamReader isReader = new InputStreamReader(System.in);
		BufferedReader bufReader = new BufferedReader(isReader);

		String userInput = "";
		String inputLine = null;
		try { 
			while ((inputLine = bufReader.readLine()) != null)
				userInput += inputLine + "\n";

			String[] parsedLines = StringUtils.parseToArray(userInput);
			String[] matricesLines = Arrays.copyOfRange(parsedLines, 1, parsedLines.length);

			int matrixDimensions = Integer.parseInt(parsedLines[0]);

			List<double[][]> matrices = MatrixParser.parse(matricesLines, matrixDimensions);
			double[][] sumResult = MatrixCalculator.sum(matrices.get(0), matrices.get(1));
			
			for(int linha = 0; linha < sumResult.length; linha++)
				System.out.println(Arrays.toString(sumResult[linha]));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
