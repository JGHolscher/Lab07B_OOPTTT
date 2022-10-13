import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTFrame extends JFrame{

    JPanel mainPnl, titlePnl, btnPnl, quitPnl;

    JButton quitBtn;

    JLabel titleLbl;

    private TTTBoard board;

    public TTTFrame()
    {
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
        board = new TTTBoard();
        createQuitPanel();
        //createButtonLayout();

        setVisible(true);

    }

    private void createQuitPanel()
    {
        quitPnl = new JPanel();

        quitBtn = new JButton("QUIT");
        quitBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        quitPnl.add(quitBtn);

        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        mainPnl.add(BorderLayout.SOUTH, quitPnl);
    }

    private void createTitlePanel()
    {
        titlePnl = new JPanel();

        titleLbl = new JLabel("Let's Play TicTacToe");
        titleLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));

        titlePnl.add(titleLbl);
        mainPnl.add(titlePnl, BorderLayout.NORTH);
    }


}
