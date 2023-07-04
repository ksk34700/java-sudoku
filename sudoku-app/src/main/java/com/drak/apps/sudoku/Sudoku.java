package com.drak.apps.sudoku;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

	private int[][] sudoku;

	public static final int ROWS = 9, COLS = 9;
	public static final int BOX = 3;

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

	public int[][] box(int r, int c) {
		int[][] box = new int[BOX][];
		int row = BOX * (r);
		int col = BOX * (c);
		for (int i = 0; i < BOX; i++) {
			box[i] = new int[BOX];
			for (int j = 0; j < BOX; j++) {
				box[i][j] = sudoku[row + i][col + j];
			}
		}
		return box;
	}

	public static void print(int[][] box) {
		for (int i = 0; i < box.length; i++) {
			int[] cols = box[i];
			for (int j = 0; j < cols.length; j++) {
				System.out.print(box[i][j]);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
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
		boolean solved=true;
		for (int i = 0; i < ROWS; i++) {
			if (!checkRows(i)) {
				solved=false;
				System.out.println("Not solved for row " + i);
			}
		}
		for (int j = 0; j < ROWS; j++) {
			if (!checkCols(j)) {
				solved=false;
				System.out.println("Not solved for col " + j);
			}
		}
		for (int i = 0; i < BOX; i++) {
			for (int j = 0; j < BOX; j++) {
				int[][] box = box(i, j);
				if (!checkBox(box)) {
					solved=false;
					System.out.println("Not solved for Box " + i + "," + j);
				}
			}

		}
		return solved;
	}

	private boolean checkBox(int[][] box) {
		Set<Integer> values = new HashSet<>();
		values.add(0);
		for (int i = 0; i < BOX; i++) {
			for (int j = 0; j < BOX; j++) {
				if (values.contains(box[i][j])) {
					return false;
				} else {
					values.add(box[i][j]);
				}
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
				"123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789");
		//sudoku.print();
		System.out.println(" ");

		Sudoku sudoku1 = new Sudoku(
				  "326984157 "
				+ "981657423 "
				+ "475132968 "
				+ "258473619 "
				+ "764519382 "
				+ "193826745 "
				+ "642398571 "
				+ "819745236 "
				+ "537261894");
		//sudoku1.print();
		//System.out.println(sudoku1.isSolved());
		
		
		Sudoku s2 = new Sudoku(
				  "634100527 "
				+ "075032000 "
				+ "890500003 "
				+ "357080200 "
				+ "408000709 "
				+ "001020834 "
				+ "000006045 "
				+ "000470980 "
				+ "243009176");
		s2.print();
		System.out.println(s2.isSolved());

	}

}
