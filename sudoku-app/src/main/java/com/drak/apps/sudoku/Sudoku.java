package com.drak.apps.sudoku;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

	private int[][] sudoku;

	public static final int ROWS = 9;
	public static final int COLS = 9;

	private Sudoku() {
	}

	/*
	 * Construct sudoku with one string
	 */
	public Sudoku(String s) {

		String[] rows = s.split(" ");
		if (rows.length != ROWS) {
			System.err.println("Invalid rows " + rows.length);
		}
		sudoku = new int[9][];
		init(rows);
	}

	public void init(String[] rows) {
		for (int i = 0; i < rows.length; i++) {
			initColumn(i, rows[i]);
		}
	}

	private void initColumn(int i, String column) {
		if (column.length() != COLS) {
			System.err.println("Invalid column  " + column);
		}
		sudoku[i] = new int[9];
		for (int j = 0; j < COLS; j++) {
			sudoku[i][j] = Integer.parseInt("" + column.charAt(j));
		}
	}

	public Sudoku clone() {
		Sudoku clone = new Sudoku();

		clone.sudoku = new int[9][];

		for (int i = 0; i < ROWS; i++) {
			clone.sudoku[i] = new int[9];
			for (int j = 0; j < COLS; j++) {
				clone.sudoku[i][j] = sudoku[i][j];
			}
		}
		return clone;
	}
	
	public void transpose() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = i + 1; j < COLS; j++) {
				int temp = sudoku[i][j];
				sudoku[i][j] = sudoku[j][i];
				sudoku[j][i] = temp;
			}
		}
	}

	public void print() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (sudoku[i][j] != 0) {
					System.out.print(sudoku[i][j]);
				} else {
					System.out.print(" ");
				}
				if ((j + 1) % 3 == 0) {
					System.out.print(" ");
				}
				System.out.print(" ");
			}
			if ((i + 1) % 3 == 0) {
				System.out.println(" ");
			}
			System.out.println(" ");
		}
	}

	public boolean isSolved() {
		/*for (int i = 0; i < ROWS; i++) {
			if (!checkRows(i)) {
				System.out.println("Not solved for row " + i);
			}
		}*/
		for (int j = 0; j < ROWS; j++) {
			if (!checkCols(j)) {
				System.out.println("Not solved for col " + j);
			}
		}

		return true;
	}

	private boolean checkCols(int j) {
		Set<Integer> values = new HashSet<>();
		values.add(0);
		for (int i = 0; i < ROWS; i++) {
			if (values.contains(sudoku[i][j])) {
				return false;
			} else {
				values.add(sudoku[i][j]);
			}
		}
		return true;
	}

	private boolean checkRows(int i) {
		Set<Integer> values = new HashSet<>();
		values.add(0);
		for (int j = 0; j < COLS; j++) {
			if (values.contains(sudoku[i][j])) {
				return false;
			} else {
				values.add(sudoku[i][j]);
			}
		}
		return true;
	}

	public static void main(String[] s) {
		Sudoku sudoku = new Sudoku(
				"123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 ");
		sudoku.print();
		System.out.println(" ");
		 
		Sudoku clone = sudoku.clone();
		
		clone.transpose();
		clone.print();
		
		System.out.println(clone.isSolved());
		
	}

}
