package Sudoku;
import java.util.Set;
import java.util.TreeSet;


public class SudokuModel implements SudokuSolver {
	private int[][] board;
	
	public SudokuModel() {
		board = new int[9][9];
	}
	
	//Recursive method of solving sudoku
	@Override
	public boolean solve() {
		   if (isValid()) {
			   return solve(0,0);
	       }
	       return false;  
	}
	private boolean solve(int r, int c) {
		//Change row when necessary
		if(c == 9) {
			c = 0;
			r++;
		}
		//Base case. All fields are ok, sudoku is solved!
		if(r == 9) {
			return true;
		}
		 //Case 1. First field is 0: Try add a number 1-9 in this field
		if( board[r][c] == 0 ) {
			for(int i = 1; i < 10 ; i++) {
				board[r][c] = i;
				if(isValid()) {
					if(solve(r, c+1)) {
						return true;
					}
				}
				remove(r,c);
			}
		} 
		 //Case 2. First field is a number 1-9. Check if its ok according to the rules
		if( board[r][c] != 0) {
			if(solve(r, c+1)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public void add(int r, int c, int digit) {
		if(0 < digit && digit < 10) {
			board[r][c] = digit;
		} else {
			throw new IllegalArgumentException("Add: Value should be 1 - 9.");
		}
	}

	@Override
	public void remove(int row, int col) {
		board[row][col] = 0;
	}

	@Override
	public int get(int row, int col) {
		return board[row][col];
	}

	@Override
	public boolean isValid() {
		Set<Integer> set = new TreeSet<Integer>();
		
		//check for duplicates in row
		for(int r = 0; r < 9 ; r++) {
			for(int v : board[r]) {
				if(v != 0 && !set.add(v)) {
					return false;
				}
			}
			set.clear();
		}
		
		//check for duplicates in column
		for(int c = 0; c < 9 ; c++) {
			for(int r = 0 ; r < 9; r++) {
				if(board[r][c] != 0 && !set.add(board[r][c])) {
					return false;
				}
			}
			set.clear();
		}
		
		//check for duplicates in quadrant
		for(int sRow = 0; sRow < 9; sRow += 3 ) {
			for(int sCol = 0; sCol < 9 ; sCol += 3) {
				
				for(int r = sRow; r < sRow + 3; r++) {
					for(int c = sCol; c < sCol + 3; c++) {
		
						if(board[r][c] != 0 && !set.add(board[r][c])) {
							return false;							
						}
					}
				}
				set.clear();
			}
		}
		return true;
	}

	@Override
	public void clear() {
		board = new int[9][9];
	}

	@Override
	public void setMatrix(int[][] m) {
		for(int r = 0; r <9 ; r++) {
			for( int c = 0; c < 9; c++) {
				board[r][c] = m[r][c];
			}
		}
	}
	
	//return board but not able to manipulate it from outside of class
	@Override
	public int[][] getMatrix() {
		int[][] temp = new int[9][9];
		for(int r = 0; r <9 ; r++) {
			for( int c = 0; c < 9; c++) {
				temp[r][c] = board[r][c];
			}
		}
		
		return temp;
	}
}
