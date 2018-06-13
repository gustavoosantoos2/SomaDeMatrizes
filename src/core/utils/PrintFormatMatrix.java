package core.utils;

public class PrintFormatMatrix {
	public static void printMatrix(double[][] m) {
		for(int linha = 0; linha < m.length; linha++)
			for(int coluna = 0; coluna < m[linha].length; coluna++)
			{
				if(coluna == 0 )
					System.out.print("|");
				if(coluna < (m[linha].length-1))
					System.out.print(m[linha][coluna]+" ");
				else
					System.out.print(m[linha][coluna]);
				if(coluna == (m[linha].length-1))
					System.out.print("|\n");
			}
	}
}
