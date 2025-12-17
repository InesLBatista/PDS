package Práticas.lab03.lab03_old;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JGaloInterface jogo = new JGaloImplementation();
        Scanner sc = new Scanner(System.in);

        System.out.println("Jogo do Galo");

        while (!jogo.isFinished()) {
            char jogador = jogo.getActualPlayer();
            System.out.println("\nVez do jogador: " + jogador);

            int linha, coluna;
            boolean jogadaValida;

            do {
                System.out.print("Escolhe linha (1-3): ");
                linha = sc.nextInt();
                System.out.print("Escolhe coluna (1-3): ");
                coluna = sc.nextInt();

                jogadaValida = jogo.setJogada(linha, coluna);
                if (!jogadaValida)
                    System.out.println("Jogada inválida, tenta outra posição!");
            } while (!jogadaValida);
        }

        char vencedor = jogo.checkResult();
        System.out.println("\nFim do jogo");
        if (vencedor != ' ')
            System.out.println("O jogador " + vencedor + " ganhou!");
        else
            System.out.println("Empate!");

        sc.close();
    }
}
