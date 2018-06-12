package core;

import java.util.ArrayList;

public class MatrixCalculator {
	public static double[][] sum(double[][] matrix1, double[][] matrix2) {
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
