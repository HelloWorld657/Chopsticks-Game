import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class main {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, player1LeftPanel, player1RightPanel, player2LeftPanel, 
    player2RightPanel, player1LeftButtonPanel, player1RightButtonPanel, player2LeftButtonPanel, player2RightButtonPanel, GameOverPanel, 
    player1TransferPanel, player2TransferPanel, player1TitlePanel, player2TitlePanel;
    JLabel titleNameLabel, player1LeftLabel, player1RightLabel, player2LeftLabel, player2RightLabel, GameOverLabel, player1TitleLabel, player2TitleLabel;
    Font titleFont = new Font("Consolas", Font.PLAIN, 90);
    Font normalFont = new Font("Consolas", Font.PLAIN, 20);
    JButton startButton, oneLeft_TwoLeft, oneLeft_TwoRight, oneRight_TwoLeft, oneRight_TwoRight, twoLeft_OneLeft, twoLeft_OneRight, 
    twoRight_OneLeft, twoRight_OneRight, player1TransferButton, player2TransferButton, one_LtoR, one_RtoL, two_LtoR, two_RtoL, one_endTurn, 
    two_endTurn;
    hand player1LeftHand = new hand(1);
    hand player1RightHand = new hand(1);
    hand player2LeftHand = new hand(2);
    hand player2RightHand = new hand(2);
    int temp1, temp2;

    public static void main(String[] args){
        new main();
    }

    public main(){
        window = new JFrame();
        window.setSize(800,600);
        window.setResizable(false);
        window.setTitle("Chopsticks");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.DARK_GRAY);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setAlwaysOnTop(true);
        window.setIconImage(new ImageIcon("Counting1.png").getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.DARK_GRAY);
        titleNameLabel = new JLabel("CHOPSTICKS");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.DARK_GRAY);
        startButton = new JButton("Start 2P");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(e -> createGameScreen());

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

        window.setVisible(true);
        window.repaint();
    }

    public void createGameScreen(){
        startButtonPanel.setVisible(false);
        titleNamePanel.setVisible(false);

        player1TitlePanel = new JPanel();
        player1TitlePanel.setBounds(350, 0, 100, 50);
        player1TitlePanel.setBackground(Color.DARK_GRAY);
        player1TitleLabel = new JLabel("Player 1");
        player1TitleLabel.setForeground(Color.white);
        player1TitleLabel.setFont(normalFont);
        player1TitlePanel.add(player1TitleLabel);
        con.add(player1TitlePanel);

        player2TitlePanel = new JPanel();
        player2TitlePanel.setBounds(350, 525, 100, 50);
        player2TitlePanel.setBackground(Color.DARK_GRAY);
        player2TitleLabel = new JLabel("Player 2");
        player2TitleLabel.setForeground(Color.white);
        player2TitleLabel.setFont(normalFont);
        player2TitlePanel.add(player2TitleLabel);
        con.add(player2TitlePanel);

        player1LeftPanel = new JPanel();
        player1LeftPanel.setBounds(100, 50, 200, 200);
        player1LeftPanel.setBackground(Color.DARK_GRAY);
        player1LeftLabel = new JLabel(new ImageIcon(player1LeftHand.getImage()));
        player1LeftPanel.add(player1LeftLabel);
        con.add(player1LeftPanel);

        player1RightPanel = new JPanel();
        player1RightPanel.setBounds(500, 50, 200, 200);
        player1RightPanel.setBackground(Color.DARK_GRAY);
        player1RightLabel = new JLabel(new ImageIcon(player1RightHand.getImage()));
        player1RightPanel.add(player1RightLabel);
        con.add(player1RightPanel);

        player2LeftPanel = new JPanel();
        player2LeftPanel.setBounds(100, 310, 200, 200);
        player2LeftPanel.setBackground(Color.DARK_GRAY);
        player2LeftLabel = new JLabel(new ImageIcon(player2LeftHand.getImage()));
        player2LeftPanel.add(player2LeftLabel);
        con.add(player2LeftPanel);

        player2RightPanel = new JPanel();
        player2RightPanel.setBounds(500, 310, 200, 200);
        player2RightPanel.setBackground(Color.DARK_GRAY);
        player2RightLabel = new JLabel(new ImageIcon(player2RightHand.getImage()));
        player2RightPanel.add(player2RightLabel);
        con.add(player2RightPanel);
        
        player1LeftButtonPanel = new JPanel();
        player1LeftButtonPanel.setBounds(50, 0, 300, 50);
        player1LeftButtonPanel.setBackground(Color.BLACK);
        oneLeft_TwoLeft= new JButton("Hit Left");
        oneLeft_TwoLeft.setBackground(Color.black);
        oneLeft_TwoLeft.setForeground(Color.white);
        oneLeft_TwoLeft.setFont(normalFont);
        oneLeft_TwoLeft.addActionListener(e -> {
            player2LeftHand.addFingers(player1LeftHand.getFingers());
            player2LeftLabel.setIcon(new ImageIcon(player2LeftHand.getImage()));
            switchTurn(1);
        });
        oneLeft_TwoRight= new JButton("Hit Right");
        oneLeft_TwoRight.setBackground(Color.black);
        oneLeft_TwoRight.setForeground(Color.white);
        oneLeft_TwoRight.setFont(normalFont);
        oneLeft_TwoRight.addActionListener(e -> {
            player2RightHand.addFingers(player1LeftHand.getFingers());
            player2RightLabel.setIcon(new ImageIcon(player2RightHand.getImage()));
            switchTurn(1);
        });
        player1LeftButtonPanel.add(oneLeft_TwoLeft);
        player1LeftButtonPanel.add(oneLeft_TwoRight);
        con.add(player1LeftButtonPanel);

        player1RightButtonPanel = new JPanel();
        player1RightButtonPanel.setBounds(450, 0, 300, 50);
        player1RightButtonPanel.setBackground(Color.BLACK);
        oneRight_TwoLeft= new JButton("Hit Left");
        oneRight_TwoLeft.setBackground(Color.black);
        oneRight_TwoLeft.setForeground(Color.white);
        oneRight_TwoLeft.setFont(normalFont);
        oneRight_TwoLeft.addActionListener(e -> {
            player2LeftHand.addFingers(player1RightHand.getFingers());
            player2LeftLabel.setIcon(new ImageIcon(player2LeftHand.getImage()));
            switchTurn(1);
        });
        oneRight_TwoRight= new JButton("Hit Right");
        oneRight_TwoRight.setBackground(Color.black);
        oneRight_TwoRight.setForeground(Color.white);
        oneRight_TwoRight.setFont(normalFont);
        oneRight_TwoRight.addActionListener(e -> {
            player2RightHand.addFingers(player1RightHand.getFingers());
            player2RightLabel.setIcon(new ImageIcon(player2RightHand.getImage()));
            switchTurn(1);
        });
        player1RightButtonPanel.add(oneRight_TwoLeft);
        player1RightButtonPanel.add(oneRight_TwoRight);
        con.add(player1RightButtonPanel);

        player2LeftButtonPanel = new JPanel();
        player2LeftButtonPanel.setBounds(50, 510, 300, 50);
        player2LeftButtonPanel.setBackground(Color.BLACK);
        twoLeft_OneLeft= new JButton("Hit Left");
        twoLeft_OneLeft.setBackground(Color.black);
        twoLeft_OneLeft.setForeground(Color.white);
        twoLeft_OneLeft.setFont(normalFont);
        twoLeft_OneLeft.addActionListener(e -> {
            player1LeftHand.addFingers(player2LeftHand.getFingers());
            player1LeftLabel.setIcon(new ImageIcon(player1LeftHand.getImage()));
            switchTurn(2);
        });
        twoLeft_OneRight= new JButton("Hit Right");
        twoLeft_OneRight.setBackground(Color.black);
        twoLeft_OneRight.setForeground(Color.white);
        twoLeft_OneRight.setFont(normalFont);
        twoLeft_OneRight.addActionListener(e -> {
            player1RightHand.addFingers(player2LeftHand.getFingers());
            player1RightLabel.setIcon(new ImageIcon(player1RightHand.getImage()));
            switchTurn(2);
        });
        player2LeftButtonPanel.add(twoLeft_OneLeft);
        player2LeftButtonPanel.add(twoLeft_OneRight);
        con.add(player2LeftButtonPanel);

        player2RightButtonPanel = new JPanel();
        player2RightButtonPanel.setBounds(450, 510, 300, 50);
        player2RightButtonPanel.setBackground(Color.BLACK);
        twoRight_OneLeft= new JButton("Hit Left");
        twoRight_OneLeft.setBackground(Color.black);
        twoRight_OneLeft.setForeground(Color.white);
        twoRight_OneLeft.setFont(normalFont);
        twoRight_OneLeft.addActionListener(e -> {
            player1LeftHand.addFingers(player2RightHand.getFingers());
            player1LeftLabel.setIcon(new ImageIcon(player1LeftHand.getImage()));
            switchTurn(2);
        });
        twoRight_OneRight= new JButton("Hit Right");
        twoRight_OneRight.setBackground(Color.black);
        twoRight_OneRight.setForeground(Color.white);
        twoRight_OneRight.setFont(normalFont);
        twoRight_OneRight.addActionListener(e -> {
            player1RightHand.addFingers(player2RightHand.getFingers());
            player1RightLabel.setIcon(new ImageIcon(player1RightHand.getImage()));
            switchTurn(2);
        });
        player2RightButtonPanel.add(twoRight_OneLeft);
        player2RightButtonPanel.add(twoRight_OneRight);
        con.add(player2RightButtonPanel);

        GameOverPanel = new JPanel();
        GameOverPanel.setBounds(150, 237, 500, 100);
        GameOverPanel.setBackground(Color.DARK_GRAY);
        GameOverLabel = new JLabel("GAME OVER");
        GameOverLabel.setForeground(Color.white);
        GameOverLabel.setFont(titleFont);
        GameOverPanel.add(GameOverLabel);
        con.add(GameOverPanel);

        player1TransferPanel = new JPanel();
        player1TransferPanel.setBounds(300, 100, 200, 50);
        player1TransferPanel.setBackground(Color.BLACK);
        player1TransferButton = new JButton("Transfer");
        player1TransferButton.setBackground(Color.black);
        player1TransferButton.setForeground(Color.white);
        player1TransferButton.setFont(normalFont);
        player1TransferButton.addActionListener(e -> {
            temp1 = player1LeftHand.getFingers();
            temp2 = player1RightHand.getFingers();
            player1Transfer();
        });
        player1TransferPanel.add(player1TransferButton);
        con.add(player1TransferPanel);

        player2TransferPanel = new JPanel();
        player2TransferPanel.setBounds(300, 415, 200, 50);
        player2TransferPanel.setBackground(Color.BLACK);
        player2TransferButton = new JButton("Transfer");
        player2TransferButton.setBackground(Color.black);
        player2TransferButton.setForeground(Color.white);
        player2TransferButton.setFont(normalFont);
        player2TransferButton.addActionListener(e -> {
            temp1 = player2LeftHand.getFingers();
            temp2 = player2RightHand.getFingers();
            player2Transfer();
        });
        player2TransferPanel.add(player2TransferButton);
        con.add(player2TransferPanel);

        one_LtoR = new JButton("->");
        one_LtoR.setBackground(Color.black);
        one_LtoR.setForeground(Color.white);
        one_LtoR.setFont(normalFont);
        one_LtoR.setMargin(new Insets(0, 0, 0, 0));
        player1TransferPanel.add(one_LtoR);
        one_LtoR.setVisible(false);

        one_endTurn = new JButton("End Turn");
        one_endTurn.setBackground(Color.black);
        one_endTurn.setForeground(Color.white);
        one_endTurn.setFont(normalFont);
        one_endTurn.setMargin(new Insets(0, 0, 0, 0));
        player1TransferPanel.add(one_endTurn);
        one_endTurn.setVisible(false);

        one_RtoL = new JButton("<-");
        one_RtoL.setBackground(Color.black);
        one_RtoL.setForeground(Color.white);
        one_RtoL.setFont(normalFont);
        one_RtoL.setMargin(new Insets(0, 0, 0, 0));
        player1TransferPanel.add(one_RtoL);
        one_RtoL.setVisible(false);

        two_LtoR = new JButton("->");
        two_LtoR.setBackground(Color.black);
        two_LtoR.setForeground(Color.white);
        two_LtoR.setFont(normalFont);
        two_LtoR.setMargin(new Insets(0, 0, 0, 0));
        player2TransferPanel.add(two_LtoR);
        two_LtoR.setVisible(false);

        two_endTurn = new JButton("End Turn");
        two_endTurn.setBackground(Color.black);
        two_endTurn.setForeground(Color.white);
        two_endTurn.setFont(normalFont);
        two_endTurn.setMargin(new Insets(0, 0, 0, 0));
        player2TransferPanel.add(two_endTurn);
        two_endTurn.setVisible(false);

        two_RtoL = new JButton("<-");
        two_RtoL.setBackground(Color.black);
        two_RtoL.setForeground(Color.white);
        two_RtoL.setFont(normalFont);
        two_RtoL.setMargin(new Insets(0, 0, 0, 0));
        player2TransferPanel.add(two_RtoL);
        two_RtoL.setVisible(false);

        one_endTurn.addActionListener(e -> {
            player1TransferButton.setVisible(true);
            one_LtoR.setVisible(false);
            one_endTurn.setVisible(false);
            one_RtoL.setVisible(false);
            player1TransferPanel.setVisible(false);
            switchTurn(1);
        });

        one_LtoR.addActionListener(e -> {
            if (player1LeftHand.getFingers() > 0) {
                player1LeftHand.addFingers(-1);
                player1RightHand.addFingers(1);
                player1LeftLabel.setIcon(new ImageIcon(player1LeftHand.getImage()));
                player1RightLabel.setIcon(new ImageIcon(player1RightHand.getImage()));
            }
            one_endTurn.setVisible((player1LeftHand.getFingers() != temp2 || player1RightHand.getFingers() != temp1) && (player1LeftHand.getFingers() != temp1 || player1RightHand.getFingers() != temp2));
            one_LtoR.setVisible(player1LeftHand.getFingers() > 0 && player1RightHand.getFingers() != 4);
            one_RtoL.setVisible(player1RightHand.getFingers() > 0 && player1LeftHand.getFingers() != 4);
        });

        one_RtoL.addActionListener(e -> {
            if (player1RightHand.getFingers() > 0) {
                player1RightHand.addFingers(-1);
                player1LeftHand.addFingers(1);
                player1LeftLabel.setIcon(new ImageIcon(player1LeftHand.getImage()));
                player1RightLabel.setIcon(new ImageIcon(player1RightHand.getImage()));
            }
            one_endTurn.setVisible((player1LeftHand.getFingers() != temp2 || player1RightHand.getFingers() != temp1) && (player1LeftHand.getFingers() != temp1 || player1RightHand.getFingers() != temp2));
            one_LtoR.setVisible(player1LeftHand.getFingers() > 0 && player1RightHand.getFingers() != 4);
            one_RtoL.setVisible(player1RightHand.getFingers() > 0 && player1LeftHand.getFingers() != 4);
        });

        two_endTurn.addActionListener(e -> {
            player2TransferButton.setVisible(true);
            two_LtoR.setVisible(false);
            two_endTurn.setVisible(false);
            two_RtoL.setVisible(false);
            player2TransferPanel.setVisible(false);
            switchTurn(2);
        });

        two_LtoR.addActionListener(e -> {
            if (player2LeftHand.getFingers() > 0) {
                player2LeftHand.addFingers(-1);
                player2RightHand.addFingers(1);
                player2LeftLabel.setIcon(new ImageIcon(player2LeftHand.getImage()));
                player2RightLabel.setIcon(new ImageIcon(player2RightHand.getImage()));
            }
            two_endTurn.setVisible((player2LeftHand.getFingers() != temp1 || player2RightHand.getFingers() != temp2) && (player2LeftHand.getFingers() != temp2 || player2RightHand.getFingers() != temp1));
            two_LtoR.setVisible(player2LeftHand.getFingers() > 0 && player2RightHand.getFingers() != 4);
            two_RtoL.setVisible(player2RightHand.getFingers() > 0 && player2LeftHand.getFingers() != 4);
        });

        two_RtoL.addActionListener(e -> {
            if (player2RightHand.getFingers() > 0) {
                player2RightHand.addFingers(-1);
                player2LeftHand.addFingers(1);
                player2LeftLabel.setIcon(new ImageIcon(player2LeftHand.getImage()));
                player2RightLabel.setIcon(new ImageIcon(player2RightHand.getImage()));
            }
            two_endTurn.setVisible((player2LeftHand.getFingers() != temp1 || player2RightHand.getFingers() != temp2) && (player2LeftHand.getFingers() != temp2 || player2RightHand.getFingers() != temp1));
            two_LtoR.setVisible(player2LeftHand.getFingers() > 0 && player2RightHand.getFingers() != 4);
            two_RtoL.setVisible(player2RightHand.getFingers() > 0 && player2LeftHand.getFingers() != 4);
        });

        player2LeftButtonPanel.setVisible(false);
        player2RightButtonPanel.setVisible(false);
        GameOverPanel.setVisible(false);
        player2TransferPanel.setVisible(false);

        window.repaint();
    }

    public void switchTurn(int i) {
        if (i == 1) {
            player1LeftButtonPanel.setVisible(false);
            player1RightButtonPanel.setVisible(false);
            player1TransferPanel.setVisible(false);
            if (player2LeftHand.getFingers() == 0 && player2RightHand.getFingers() == 1) {
                player2TransferPanel.setVisible(false);
             }
            else if (player2LeftHand.getFingers() == 1 && player2RightHand.getFingers() == 0) {
                player2TransferPanel.setVisible(false);
            } 
            else if (player2LeftHand.getFingers() == 3 && player2RightHand.getFingers() == 4) {
                player2TransferPanel.setVisible(false);
            }
            else if (player2LeftHand.getFingers() == 4 && player2RightHand.getFingers() == 3) {
                player2TransferPanel.setVisible(false);
            }
            else {
            player2TransferPanel.setVisible(true);}

            player2LeftButtonPanel.setVisible(player2LeftHand.getFingers() > 0);
            player2RightButtonPanel.setVisible(player2RightHand.getFingers() > 0);
            twoLeft_OneLeft.setVisible(player1LeftHand.getFingers() > 0);
            twoLeft_OneRight.setVisible(player1RightHand.getFingers() > 0);
            twoRight_OneLeft.setVisible(player1LeftHand.getFingers() > 0);
            twoRight_OneRight.setVisible(player1RightHand.getFingers() > 0);
        } else if (i == 2) {
            player1LeftButtonPanel.setVisible(player1LeftHand.getFingers() > 0);
            player1RightButtonPanel.setVisible(player1RightHand.getFingers() > 0);
            
            if (player1LeftHand.getFingers() == 0 && player1RightHand.getFingers() == 1) {
                player1TransferPanel.setVisible(false);
             }
            else if (player1LeftHand.getFingers() == 1 && player1RightHand.getFingers() == 0) {
                player1TransferPanel.setVisible(false);
            } 
            else if (player1LeftHand.getFingers() == 3 && player1RightHand.getFingers() == 4) {
                player1TransferPanel.setVisible(false);
            }
            else if (player1LeftHand.getFingers() == 4 && player1RightHand.getFingers() == 3) {
                player1TransferPanel.setVisible(false);
            }
            else {
            player1TransferPanel.setVisible(true);}

            player2LeftButtonPanel.setVisible(false);
            player2RightButtonPanel.setVisible(false);
            player2TransferPanel.setVisible(false);
            oneLeft_TwoLeft.setVisible(player2LeftHand.getFingers() > 0);
            oneLeft_TwoRight.setVisible(player2RightHand.getFingers() > 0);
            oneRight_TwoLeft.setVisible(player2LeftHand.getFingers() > 0);
            oneRight_TwoRight.setVisible(player2RightHand.getFingers() > 0);
        }

        if ((player1LeftHand.getFingers() == 0 && player1RightHand.getFingers() == 0)
                || (player2LeftHand.getFingers() == 0 && player2RightHand.getFingers() == 0)) {
            player1LeftButtonPanel.setVisible(false);
            player1RightButtonPanel.setVisible(false);
            player2LeftButtonPanel.setVisible(false);
            player2RightButtonPanel.setVisible(false);
            player1TransferPanel.setVisible(false);
            player2TransferPanel.setVisible(false);
            GameOverPanel.setVisible(true);
        } else {
            GameOverPanel.setVisible(false);
        }

        window.repaint();
    }

    public void player1Transfer() {
        player1TransferButton.setVisible(false);
        player1LeftButtonPanel.setVisible(false);
        player1RightButtonPanel.setVisible(false);
        one_LtoR.setVisible(player1LeftHand.getFingers() > 0 && player1RightHand.getFingers() != 4);
        one_endTurn.setVisible(false);
        one_RtoL.setVisible(player1RightHand.getFingers() > 0 && player1LeftHand.getFingers() != 4);
        window.repaint();
    }

    public void player2Transfer() {
        player2TransferButton.setVisible(false);
        player2LeftButtonPanel.setVisible(false);
        player2RightButtonPanel.setVisible(false);
        two_LtoR.setVisible(player2LeftHand.getFingers() > 0 && player2RightHand.getFingers() != 4);
        two_endTurn.setVisible(false);
        two_RtoL.setVisible(player2RightHand.getFingers() > 0 && player2LeftHand.getFingers() != 4);
        window.repaint();
    }
}