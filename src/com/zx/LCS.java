package com.zx;

public class LCS {
	
	private static final char[] X = new char[] {' ','A','B','C','B','D','A','B'};
	private static final char[] Y = new char[] {' ','B','D','C','A','B','A'};
	private static final int X_len = X.length;
	private static final int Y_len = Y.length;
	private static int[][] c = new int[X_len][Y_len];
	private static char[][] b = new char[X_len][Y_len];

	public static void main(String[] args) {
		
		getLength(X, Y, c, b);
		
		for (int i = 0; i < X_len; i++) {
			
			for (int j = 0; j < Y_len; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.print("\n");
		}
		
		System.out.println("最长公共子串的长度为：" + c[X_len-1][Y_len-1] + "\n最长公共子串为：");
		printLCS(b, X, X_len-1, Y_len-1);
	}
	
	public static void getLength(char[] X, char[] Y, int[][] c, char[][] b) {
		
		for (int i = 0; i < X_len; i++) {
			c[i][0] = 0;
		}
		
		for (int j = 0; j < Y_len; j++) {
			c[0][j] = 0;
		}
		
		for (int i = 1; i < X_len; i++) {
			
			for (int j = 1; j < Y_len; j++) {
				
				if (X[i] == Y[j]) {
					c[i][j] = c[i-1][j-1] + 1;
					b[i][j] = '\\';
				} else if (c[i-1][j] >= c[i][j-1]) {
					c[i][j] = c[i-1][j];
					b[i][j] = '|';
				} else {
					c[i][j] = c[i][j-1];
					b[i][j] = '-';
				}
			}
		}
	}
	
	public static void printLCS(char[][] b, char[] X, int i, int j) {
		
		if (i == 0 || j == 0) {
			return;
		}
		
		if (b[i][j] == '\\') {
			printLCS(b, X, i-1, j-1);
			System.out.print(X[i] + " ");
		} else if (b[i][j] == '|') {
			printLCS(b, X, i-1, j);
		} else {
			printLCS(b, X, i, j-1);
		}
	}

}
