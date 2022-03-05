package Sudoku;

public class SudokuApplication {
	public static void main(String[] args)  {
		SudokuModel model = new SudokuModel();
		new SudokuController(model);
	}

}
