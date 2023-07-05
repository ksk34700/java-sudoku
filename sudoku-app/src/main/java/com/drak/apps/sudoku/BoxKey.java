package com.drak.apps.sudoku;

public class BoxKey {

	public static final int ROWS = 9, COLS = 9;
	public static final int BOX = 3;

	private int row;
	private int col;

	public static BoxKey empty() {
		return new BoxKey(-1, -1);
	}

	public static BoxKey create(int row, int col) {
		return new BoxKey(row/BOX,col/BOX);
	}

	private BoxKey(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return "<" + row + "," + col + ">";
	}

	public static void main(String[] args) {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.println( "("+i+","+j+") -- "  +BoxKey.create(i, j));
			}
		}
	}

}
