import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(242, 242, 242)); // Light background
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Header TextField (Title)
        textfield.setBackground(new Color(54, 57, 63));  // Darker background
        textfield.setForeground(new Color(248, 248, 248));  // Light font color
        textfield.setFont(new Font("Arial", Font.BOLD, 70));  // Sleeker font
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        // Title panel settings
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        // Button panel grid layout
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(210, 210, 210)); // Neutral color for the grid

        // Setup buttons with cleaner colors and fonts
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 100));  // Modern font
            buttons[i].setFocusable(false);
            buttons[i].setBackground(new Color(255, 255, 255));  // White button background
            buttons[i].setBorder(BorderFactory.createLineBorder(new Color(189, 189, 189), 2));  // Add a soft border
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(235, 87, 87));  // Soft red for 'X'
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O's Turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(56, 161, 240));  // Soft blue for 'O'
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X's Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X's Turn");
        } else {
            player1_turn = false;
            textfield.setText("O's Turn");
        }
    }

    public void check() {
        // Check X win conditions
        if ((buttons[0].getText().equals("X")) &&
                (buttons[1].getText().equals("X")) &&
                (buttons[2].getText().equals("X"))) {
            xWins(0, 1, 2);
        }
        if ((buttons[3].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[5].getText().equals("X"))) {
            xWins(3, 4, 5);
        }
        if ((buttons[6].getText().equals("X")) &&
                (buttons[7].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))) {
            xWins(6, 7, 8);
        }
        if ((buttons[0].getText().equals("X")) &&
                (buttons[3].getText().equals("X")) &&
                (buttons[6].getText().equals("X"))) {
            xWins(0, 3, 6);
        }
        if ((buttons[1].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[7].getText().equals("X"))) {
            xWins(1, 4, 7);
        }
        if ((buttons[2].getText().equals("X")) &&
                (buttons[5].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))) {
            xWins(2, 5, 8);
        }
        if ((buttons[0].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))) {
            xWins(0, 4, 8);
        }
        if ((buttons[2].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[6].getText().equals("X"))) {
            xWins(2, 4, 6);
        }

        // Check O win conditions
        if ((buttons[0].getText().equals("O")) &&
                (buttons[1].getText().equals("O")) &&
                (buttons[2].getText().equals("O"))) {
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[5].getText().equals("O"))) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText().equals("O")) &&
                (buttons[7].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))) {
            oWins(6, 7, 8);
        }
        if ((buttons[0].getText().equals("O")) &&
                (buttons[3].getText().equals("O")) &&
                (buttons[6].getText().equals("O"))) {
            oWins(0, 3, 6);
        }
        if ((buttons[1].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[7].getText().equals("O"))) {
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText().equals("O")) &&
                (buttons[5].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))) {
            oWins(2, 5, 8);
        }
        if ((buttons[0].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))) {
            oWins(0, 4, 8);
        }
        if ((buttons[2].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[6].getText().equals("O"))) {
            oWins(2, 4, 6);
        }

        chechDraw();

    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(new Color(129, 199, 132));  // Light green for win
        buttons[b].setBackground(new Color(129, 199, 132));
        buttons[c].setBackground(new Color(129, 199, 132));

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(new Color(129, 199, 132));  // Light green for win
        buttons[b].setBackground(new Color(129, 199, 132));
        buttons[c].setBackground(new Color(129, 199, 132));

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Wins");
    }

    public void chechDraw() {
        boolean isDraw = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                isDraw = false;  // If there is any empty button, it's not a draw yet
                break;
            }
        }

        if (isDraw) {
            textfield.setText("Draw!");
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }
        }
    }
}
