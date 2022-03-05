package Sudoku;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SudokuTest {
	/*
	 * Sudoku test cases vid JUnit
	 */
	private SudokuModel s;

	@BeforeEach
	void setUp() throws Exception {
		s = new SudokuModel();
	}

	@AfterEach
	void tearDown() throws Exception {
		s.clear();
	}

	@Test
	void solveEmpty() {
		assertTrue(s.solve(), "solved");
	}
	@Test 
	void solveFig() {
		int[][] fig = {
				{0,0,8,0,0,9,0,6,2},
				{0,0,0,0,0,0,0,0,5},
				{1,0,2,5,0,0,0,0,0},
				{0,0,0,2,1,0,0,9,0},
				{0,5,0,0,0,0,6,0,0},
				{6,0,0,0,0,0,0,2,8},
				{4,1,0,6,0,8,0,0,0},
				{8,6,0,0,3,0,1,0,0},
				{0,0,0,0,0,0,4,0,0},
		};
		s.setMatrix(fig);
		assertEquals(s.get(3, 3),fig[3][3],"Should be 2");
		assertTrue(s.solve(),"solved");
	}
	@Test
	void isValid() {
		int[][] fig = {
				{0,0,8,0,0,9,0,6,2},
				{0,0,0,0,0,0,0,0,5},
				{1,0,2,5,0,0,0,0,0},
				{0,0,0,2,1,0,0,9,0},
				{0,5,0,0,0,0,6,0,0},
				{6,0,0,0,0,0,0,2,8},
				{4,1,0,6,0,8,0,0,0},
				{8,6,0,0,3,0,1,0,0},
				{0,0,0,0,0,0,4,0,0},
		};
		s.setMatrix(fig);
		assertTrue(s.isValid(),"is valid and should be : True");		
	}
	@Test
	void sameNbrOnRow() {
		int[][] fig = {
				{0,0,8,0,0,9,0,6,2},
				{0,0,0,0,0,0,0,0,5},
				{1,0,2,5,0,0,0,0,0},
				{0,0,0,2,1,0,0,9,2},
				{0,5,0,0,0,0,6,0,0},
				{6,0,0,0,0,0,0,2,8},
				{4,1,0,6,0,8,0,0,0},
				{8,6,0,0,3,0,1,0,0},
				{0,0,4,0,0,0,4,0,0},
		};
		s.setMatrix(fig);
		assertEquals(s.get(3, 3),fig[3][3],"Should be 2");
		assertFalse(s.solve(),"Should not be solveble");
	}
	@Test
	void sameNbrOnCol() {
		int[][] fig = {
				{0,0,8,0,0,9,0,6,2},
				{0,0,0,0,0,0,0,0,5},
				{1,0,2,5,0,0,0,0,0},
				{0,0,0,2,1,0,0,9,0},
				{0,5,0,0,0,0,6,0,0},
				{6,0,0,0,0,0,0,2,8},
				{4,1,0,6,0,8,0,0,0},
				{8,6,0,2,3,0,1,0,0},
				{0,0,2,0,0,0,4,0,0},
		};
		s.setMatrix(fig);
		assertEquals(s.get(3, 3),fig[3][3],"Should be 2");
		assertFalse(s.solve(),"Should not be solveble");
	}
	@Test
	void sameNbrInBox() {
		int[][] fig = {
				{0,0,8,0,0,9,0,6,2},
				{0,0,0,0,0,0,0,0,5},
				{1,0,2,5,0,0,0,0,0},
				{0,0,0,2,1,0,0,9,0},
				{0,5,0,0,2,0,6,0,0},
				{6,0,0,0,0,0,0,2,8},
				{4,1,0,6,0,8,0,0,0},
				{8,6,0,0,3,0,1,0,0},
				{0,8,6,0,0,0,4,0,0},
		};
		s.setMatrix(fig);
		assertEquals(s.get(3, 3),fig[3][3],"Should be 2");
		assertFalse(s.solve(),"Should not be solveble");
	}
	@Test
	void sameNbrMulti() {
		int[][] fig = {
				{8,0,8,0,0,9,0,6,2},
				{0,8,0,0,0,0,0,0,5},
				{1,0,2,5,0,0,0,0,0},
				{0,0,0,2,1,0,0,9,0},
				{0,5,0,0,8,0,6,0,0},
				{6,0,0,0,0,0,0,2,8},
				{4,1,0,6,0,8,0,0,0},
				{8,6,0,0,3,0,1,0,0},
				{0,0,2,0,0,0,4,0,0},
		};
		s.setMatrix(fig);
		assertEquals(s.get(3, 3),fig[3][3],"Should be 2");
		assertFalse(s.solve(),"Should not be solveble");
	}
	@Test
	void clearSingle() {
		s.add(4, 4, 4);
		assertEquals(s.get(4, 4),4,"Should be 4");
		s.remove(4, 4);
		assertEquals(s.get(4, 4), 0, "Should be 0");
	}
	@Test
	void clearAll() {
		int[][] fig = {
				{8,0,8,0,0,9,0,6,2},
				{0,8,0,0,0,0,0,0,5},
				{1,0,2,5,0,0,0,0,0},
				{0,0,0,2,1,0,0,9,0},
				{0,5,0,0,8,0,6,0,0},
				{6,0,0,0,0,0,0,2,8},
				{4,1,0,6,0,8,0,0,0},
				{8,6,0,0,3,0,1,0,0},
				{0,0,2,0,0,0,4,0,0},
		};
		s.setMatrix(fig);
		s.clear();
		for(int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				assertEquals(s.get(r, c),0, "should be empty");
			}
		}
	}
}