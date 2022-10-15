import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTFrame extends JFrame{
    static String player = "X";
    JPanel mainPnl, titlePnl, btnPnl, quitPnl;
    static int moveCnt = 0;
    static TTTTile[][] board = new TTTTile[3][3];
    final int MOVES_FOR_WIN = 5;
    final int MOVES_FOR_TIE = 7;


    JButton quitBtn;
    JLabel titleLbl;


    public TTTFrame(){ //DONE
        setTitle("TicTacToe Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize((screenWidth /4) * 3 , screenHeight);
        setLocationRelativeTo(null); //centers

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        add(mainPnl);
        createTitlePanel();
        createButtonPanel();
        createQuitPanel();
        createButtonLayout();

        setVisible(true);

    }

    public void createButtonPanel() //DONE
    {
        btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout(3,3));

        mainPnl.add(BorderLayout.CENTER, btnPnl);
    }

    public void createButtonLayout()
    {
        for( int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                board[row][col] = new TTTTile(row, col);
                board[row][col].setText(" ");
                board[row][col].addActionListener(new ActionListener()
                {

                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        GameLogic.getBoard(board);
                        JButton clicked = (JButton) e.getSource();
                        clicked.setText(player);
                        clicked.setEnabled(false);
                        moveCnt++;
                        displayResult();
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
    public void displayResult()
    {
        GameLogic.getMoveCount(moveCnt);
        if(moveCnt >= MOVES_FOR_WIN)
        {
            if(GameLogic.isWin(player) == true)
            {
                System.out.println(player + "win");
                JOptionPane pane = new JOptionPane();

                int windowResult = JOptionPane.showConfirmDialog(pane, "Game Over.   " + player + "  wins!  Would you like to play again?", " ", JOptionPane.YES_NO_OPTION);

                if (windowResult == JOptionPane.YES_OPTION) {
                    clearBoard();
                }

                else{
                    System.exit(0);
                }
            }
        }

        if(moveCnt >= MOVES_FOR_TIE)
        {
            if(GameLogic.isTie() == true) {
                JOptionPane pane = new JOptionPane();
                int windowResult = JOptionPane.showConfirmDialog(pane, "Tie! Would you like to play again?", " ", JOptionPane.YES_NO_OPTION);

                if (windowResult == JOptionPane.YES_OPTION) {
                    clearBoard();
                }

                else{
                    System.exit(0);
                }
            }

        }



    }

    public static void clearBoard()//DONE
    {
        // sets all the board elements to a space
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col].setText(" ");
                board[row][col].setEnabled(true);
                moveCnt = 0;
                player = "X";
            }
        }
        if (player == "X") {
            player = "O";
        } else {
            player = "X";
        }
    }

    public void createQuitPanel(){ //DONE
        quitPnl = new JPanel();

        quitBtn = new JButton("QUIT");
        quitBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        quitPnl.add(quitBtn);

        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        mainPnl.add(BorderLayout.SOUTH, quitPnl);

    }
    public void createTitlePanel()//DONE
    {
        titlePnl = new JPanel();

        titleLbl = new JLabel("Let's Play TicTacToe");
        titleLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));

        titlePnl.add(titleLbl);
        mainPnl.add(titlePnl, BorderLayout.NORTH);
    }


}
