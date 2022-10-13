import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTBoard {

    JPanel mainPnl, btnPnl;
    static TicTacToeTile[][] board = new TicTacToeTile[3][3];
    static String player = "X";

    static int moveCnt = 0;

    private void createButtonPanel() //DONE
    {
        btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout(3,3));

        mainPnl.add(BorderLayout.CENTER, btnPnl);
    }


    private void createButtonLayout()
    {
        for( int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                board[row][col] = new TicTacToeTile(row, col);
                board[row][col].setText(" ");
                board[row][col].addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        JButton clicked = (JButton) e.getSource();
                        clicked.setText(player);
                        clicked.setEnabled(false);
                        moveCnt++;
                        //displayResult(); // Game Results
                        if (player == "X") {
                            player = "O";
                        } else {
                            player = "X";
                        }
                    }
                });
                board[row][col].setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
                btnPnl.add(board[row][col]);
            }

        }
    }

    public class TicTacToeTile extends JButton
    {
        private int row;
        private int col;

        public TicTacToeTile(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }
    }



}
