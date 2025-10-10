package com.frederickschubert.utils;

import java.util.ArrayList;

public class TwodArray<T> {
    private final ArrayList<ArrayList<T>> data = new ArrayList<>();

    public void addRow() {
        data.add(new ArrayList<>());
    }

    public void addColumn(int rowIndex, T value) {
        if (rowIndex < 0) {
            throw new IndexOutOfBoundsException("Row index cannot be negative: " + rowIndex);
        }
        while (rowIndex >= data.size()) {
            data.add(new ArrayList<>());
        }

        data.get(rowIndex).add(value);
    }

    public T get(int row, int col) {
        if (row >= data.size() || col >= data.get(row).size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: (" + row + ", " + col + ")");
        }
        return data.get(row).get(col);
    }

    public void set(int row, int col, T value) {
        if (row >= data.size() || col >= data.get(row).size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: (" + row + ", " + col + ")");
        }
        data.get(row).set(col, value);
    }

    public int getRowCount() {
        return data.size();
    }
    public int getColumnCount() {
        return data.isEmpty() ? 0 : data.get(0).size();
    }
}
