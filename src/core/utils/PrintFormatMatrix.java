package core.utils;

public class PrintFormatMatrix {
	
	public static void printMatrix(double[][] m) {
		for (int linha = 0; linha < m.length; linha++) {
			System.out.print("|");
			printLinha(m[linha]);
			System.out.println("|");
		}
	}
	
	private static void printLinha(double[] linha) {
		for (int coluna = 0; coluna < linha.length; coluna++) {
			if (coluna < (linha.length - 1))
				System.out.print(linha[coluna] + " ");
			else
				System.out.print(linha[coluna]);
		}
	}
}
