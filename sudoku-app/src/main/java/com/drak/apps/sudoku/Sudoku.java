package com.drak.apps.sudoku;

public class Sudoku {
	
	private int [] [] sudoku;
	
	public static final int ROWS=9;
	public static final int COLS=9;
	
	/*
	 * Construct sudoku with one string 
	 */
	public Sudoku(String s) {
		
		String[] rows = s.split(" ");
		if(rows.length != ROWS) {
			System.err.println("Invalid rows "+rows.length );
		}
		
		sudoku = new int[9][];
		init(rows);
		
	}
	
	public void init(String[] rows) {
		for(int i=0;i<rows.length;i++) {
			String column = rows[i];
			initColumn(i,column);
		}
		
	}
	
	private void initColumn(int i, String column) {
		if(column.length() != COLS) {
			System.err.println("Invalid column  "+ column );
		}
		sudoku[i] = new int[9];
		for(int j=0;j<COLS;j++) {
			sudoku[i][j] =Integer.parseInt(""+ column.charAt(j));
		}
		
	}

	public void print() {
		for(int i=0;i<ROWS;i++) {
			for(int j=0;j<COLS;j++) {
				if(sudoku[i][j] != 0) {
					System.out.print(sudoku[i][j]);	
				}else {
					System.out.print(" ");
				}
				System.out.print(" ");
			}
			System.out.println(" ");
		}
	}
	
	
	public static void main(String [] s) {
		Sudoku sudoku = new Sudoku("123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 ");
		sudoku.print();
	}
	
	

}
