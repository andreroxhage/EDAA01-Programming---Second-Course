package Sudoku;

public interface SudokuSolver {
	/**
	 * Solves the sudoku.
	 * @return true	 if the sudoku has a solution
	 */
	boolean solve();

	/**
	 * Puts digit in the box row, col.
	 * 
	 * @param row   The row
	 * @param col   The column
	 * @param digit The digit to insert in box row, col
	 * @throws IllegalArgumentException if row, col or digit is outside the range
	 *                                  [0..9]
	 */
	void add(int row, int col, int digit);

	/**
	 * Removes the digit in the box row, col.
	 * 
	 * @param row   The row
	 * @param col   The column
	 * @throws IllegalArgumentException if row, col or digit is outside the range
	 *                             
	 */
	void remove(int row, int col);

	/**
	 * Return the digit in the box row, col.
	 * 
	 * @param row   The row
	 * @param col   The column
	 * @return int		The integer in the matrix
	 * @throws IllegalArgumentException if row, col or digit is outside the range
	 *                            
	 */
	int get(int row, int col);

	/**
	 * Checks that all filled in digits follows the the sudoku rules.
	 * One digit from 1-9 per row and column
	 * One digit from 1-9 in square of 9 digits
	 * 
	 * @return true 	If the digit follows the sudoku rules
	 */
	boolean isValid();

	/**
	 * Clears the board matrix m[][] 
	 */
	void clear();

	/**
	 * Fills the grid with the digits in m. The digit 0 represents an empty box.
	 * 
	 * @param m the matrix with the digits to insert
	 * @throws IllegalArgumentException if m has the wrong dimension or contains
	 *                                  values outside the range [0..9]
	 */
	void setMatrix(int[][] m);

	/**
	 * Get the matrix of all the digits
	 * 
	 * @return int[][]		this matrix represents the board of numbers
	 */
	int[][] getMatrix();
}