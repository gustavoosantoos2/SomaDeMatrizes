package core;

public class ArraySumThread implements Runnable {
	
	private double[] linha1;
	private double[] linha2;
	private int lineNumber;
	private double[][] target;

	public ArraySumThread(double[] linha1, double[] linha2, int lineNumber, double[][] target) {
		this.linha1 = linha1;
		this.linha2 = linha2;
		this.lineNumber = lineNumber;
		this.target = target;
		
	}
	
	@Override
	public void run() {
		double[] arraySum = sumArrays(linha1, linha2);
		target[lineNumber] = arraySum; 
	}
	
	private double[] sumArrays(double[] matrix1, double[] matrix2) {
		double[] sum = new double[matrix1.length];

		for (int i = 0; i < matrix1.length; i++)
			sum[i] = matrix1[i] + matrix2[i];

		return sum;
	}
}
