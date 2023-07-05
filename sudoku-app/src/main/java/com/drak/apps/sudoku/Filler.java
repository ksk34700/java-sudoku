package com.drak.apps.sudoku;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Filler {
	private static final int[] NUMBERS = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	private Set<Integer> values;

	private int row;
	private int col;
	private BoxKey boxKey;

	private void init() {
		values = Arrays.stream(NUMBERS).boxed().collect(Collectors.toSet());
		row = -1;
		col = -1;
		boxKey = BoxKey.empty();
	}

	private Filler() {
		init();
	}

	public static Filler createRow(int row) {
		Filler f = new Filler();
		f.row = row;
		return f;
	}

	public static Filler createCol(int col) {
		Filler f = new Filler();
		f.col = col;
		return f;
	}

	public static Filler create(BoxKey boxKey) {
		Filler f = new Filler();
		f.boxKey = boxKey;
		return f;
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

	public void setCol(int column) {
		this.col = column;
	}

	public BoxKey getBoxKey() {
		return boxKey;
	}

	public void setBoxKey(BoxKey boxKey) {
		this.boxKey = boxKey;
	}

	public Set<Integer> getValues() {
		return values;
	}

	boolean isRow() {
		return row > 0;
	}

	boolean isCol() {
		return col > 0;
	}

	boolean isBoxKey() {
		return boxKey.getRow() > 0 && boxKey.getCol() > 0;
	}

	@Override
	public String toString() {

		return isRow() ? "R" : isCol() ? "C" : "BK" + "::" + values;
	}

}
