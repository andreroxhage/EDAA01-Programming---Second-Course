package Sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;


public class SudokuController {
	private JTextField[][] fields;
	private SudokuModel board;
	
	public SudokuController(SudokuModel board) {
		SwingUtilities.invokeLater(() -> createWindow ("Sudoku", 750, 750));
		this.board = new SudokuModel();
		fields = new JTextField[9][9];
	}

	private void createWindow(String title, int width, int height) {
		
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = frame.getContentPane();		
		container.setPreferredSize(new Dimension(width, height));
		
		//Panel with sudoku grid
		JPanel gridPanel =  new JPanel(new GridLayout(9,9,3,3));
		for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
            	JTextField field = new JTextField();
            	field.setFont(new Font("Times New Roman", Font.BOLD, 60));
            	field.setHorizontalAlignment(JTextField.CENTER);
            	
				if ((r / 3 + c / 3) % 2 == 0) {
					field.setBackground(Color.orange);
				}
				gridPanel.add(fields[r][c] = field);
            }
        }
		
		//Panel with buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.gray);
		//buttons
		JButton solveButton = new JButton("Solve");
		JButton clearButton = new JButton("Clear");
		
		//adds everything to container
		buttonPanel.add(solveButton);
		buttonPanel.add(clearButton);
		container.add(gridPanel, BorderLayout.NORTH);
		container.add(buttonPanel, BorderLayout.SOUTH);
		
		/*
		 * Solving sudoku, bu first
		 * Check if numbers are correctly inserted
		 * Is it posible to solve
		 * If all ok, update the board and update UI
		 */
		solveButton.addActionListener(event -> {
			if(checkBoard()) {
				if(board.solve()) {
					for(int r = 0; r < 9 ; r++) {
						for(int c = 0; c < 9 ; c++) {
							fields[r][c].setText(Integer.toString(board.get(r, c)));
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Sudoku saknar lösning!", "Sudoku saknar lösning",JOptionPane.CLOSED_OPTION);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Fel vid inmatning i rutorna. Endast en siffra 1-9", "Dålig indata",JOptionPane.CLOSED_OPTION);
			}
		});
		
		//Empty the fields
		clearButton.addActionListener(event -> {
			for (int r = 0; r < 9; r++) {
	            for (int c = 0; c < 9; c++) {
	            	fields[r][c].setText(null);
	            }
	        }
			board.clear();
		});
		
		frame.getRootPane().setDefaultButton(solveButton);
		frame.pack();
		frame.setVisible(true);
	}
	
	private boolean checkBoard(){
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
				
				String s = fields[r][c].getText();
				if(!s.isEmpty()) {
					int nbr;
					
					try {
						nbr = Integer.parseInt(s);
					} catch( Exception e) {
						return false;
					}
				
					try { 
						board.add(r, c, nbr);
					} catch (Exception e ) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
