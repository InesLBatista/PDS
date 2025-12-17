package Práticas.lab03.lab03_new.Galo;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JGaloPainel extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;            // Identificador da classe
    private final JToggleButton[] buttons;                      // Botões do tabuleiro
    private final JGaloInterface jogo;                          // Lógica do jogo

    public JGaloPainel(JGaloInterface jogo) {
        super("Jogo da Galinha");                              // Título da janela
        this.jogo = jogo;                                       // Atribui instância do jogo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         // Fecha ao sair
        setSize(300, 300);                                      // Define tamanho da janela
        setLocationRelativeTo(null);                            // Centraliza janela

        JPanel panel = new JPanel(new GridLayout(3, 3));        // Cria grelha 3x3
        buttons = new JToggleButton[9];                         // Inicializa vetor de botões

        for (int i = 0; i < buttons.length; i++) {              // Cria e adiciona botões
            buttons[i] = createButton();                        // Cria botão configurado
            panel.add(buttons[i]);                              // Adiciona ao painel
        }

        setContentPane(panel);                                  // Define painel principal
        setVisible(true);                                       // Torna janela visível
    }

    private JToggleButton createButton() {
        JToggleButton button = new JToggleButton();             // Cria novo botão
        button.setFont(new Font("Tahoma", Font.BOLD, 50));      // Define fonte grande
        button.setForeground(Color.BLUE);                       // Define cor azul
        button.addActionListener(this);                         // Adiciona ouvinte de evento
        return button;                                          // Retorna botão criado
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton sourceButton = (JToggleButton) e.getSource(); // Obtém botão clicado
        sourceButton.setText(String.valueOf(jogo.getActualPlayer())); // Define símbolo
        sourceButton.setEnabled(false);                          // Desativa botão

        for (int i = 0; i < buttons.length; i++)                 // Procura índice clicado
            if (e.getSource() == buttons[i])                     // Encontra botão correspondente
                jogo.setJogada(i / 3 + 1, i % 3 + 1);            // Regista jogada

        if (jogo.isFinished())                                   // Verifica fim do jogo
            showResultDialog(jogo.checkResult());                // Mostra resultado
    }

    private void showResultDialog(char result) {
        if (result == ' ')                                       // Verifica empate
            JOptionPane.showMessageDialog(this, "Empate!");      // Mostra empate
        else
            JOptionPane.showMessageDialog(this, "Venceu o jogador " + result + "!"); // Mostra vencedor
        System.exit(0);                                          // Fecha aplicação
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JGaloPainel(new JGalo())); // Inicia jogo na thread gráfica
    }
}
