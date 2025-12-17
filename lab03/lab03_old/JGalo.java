package Práticas.lab03.lab03_old;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JGalo extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel jPanel;
    private JToggleButton[] bt;
    private JGaloInterface jogo;

    public JGalo(JGaloInterface myGreatGame) {
        super("Jogo do Galo");
        this.jogo = myGreatGame;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        jPanel = new JPanel(new GridLayout(3, 3));
        bt = new JToggleButton[9];

        for (int i = 0; i < 9; i++) {
            bt[i] = new JToggleButton();
            bt[i].setFont(new Font("Tahoma", Font.BOLD, 50));
            bt[i].setForeground(Color.BLUE);
            bt[i].addActionListener(this);
            jPanel.add(bt[i]);
        }

        setContentPane(jPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == bt[i]) {
                char player = jogo.getActualPlayer();
                bt[i].setText(String.valueOf(player));
                bt[i].setEnabled(false);
                jogo.setJogada(i / 3 + 1, i % 3 + 1);
                break;
            }
        }

        if (jogo.isFinished()) {
            char result = jogo.checkResult();
            if (result == ' ')
                JOptionPane.showMessageDialog(this, "Empate!");
            else
                JOptionPane.showMessageDialog(this, "Venceu o jogador " + result);
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JGalo(new JGaloImplementation()));
    }
}
