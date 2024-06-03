package pctTabuleiro;

import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {
    public static void main(String[] args) {

        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);
        int[] sorte = {4, 7, 11, 14, 16, 19, 23, 25, 28, 30};
        int[] azar = {5, 9, 13, 15, 17, 21, 24, 26, 29, 32};
        int opcao, dado1, dado2, j1 = 1, j2 = 1;

        System.out.println("Sejam bem-vindos ao Reino de Sonorium, um antigo reino mágico e misterioso.");
        System.out.println("Akira (Jogador 1), em meio a guerras, um sábio ancião, conhecido como o Grande Mestre Miyamoto, designou a você uma missão crucial: ");
        System.out.println("Recuperar a lágrima da lua, um poderoso e lendário cristal que protege o reino de terríveis maldições.");
        System.out.println("Entretanto, Kenji (Jogador 2) o espião de Trover, o perseguirá para roubar o cristal! Tome cuidado.");

        while (j1 < 32 && j2 < 32) {
            System.out.println("\nJogador 1, pressione a tecla Enter para rolar o dado.");
            scn.nextLine();
            dado1 = rnd.nextInt(6);
            System.out.println("Dado: " + (dado1 + 1));
            j1 += (dado1 + 1);
            System.out.println("Jogador 1, avance " + (dado1 + 1) + " casas.");
            System.out.println("Jogador 1, você está na casa: " + j1);
            Verificar(j1, sorte, azar);
            System.out.println("\nJogador 2, pressione a tecla Enter para rolar o dado.");
            scn.nextLine();
            dado2 = rnd.nextInt(6 + 1);
            System.out.println("Dado: " + (dado2 + 1));
            j2 += (dado2 + 1);
            System.out.println("Jogador 2, avance " + (dado2 + 1) + " casas.");
            System.out.println("Jogador 2, você está na casa: " + j2);
            Verificar(j2, sorte, azar);
        }
        if (j1 >= 32){
            System.out.println("\nParabéns, Akira! Você recuperou o cristal e salvou o Reino de Sonorium!");
        } if (j2 >= 32){
            System.out.println("\nParabéns, Kenji! Você roubou o cristal e trouxe o poder para Trover novamente.");
        }

    }
    private static void Verificar(int posicao, int [] sorte, int [] azar){
        if (posicao >= 1 && posicao <= 32) {
            if (DescontarSorteReves(sorte, posicao)) {
                System.out.println("SORTE! Avance 2 casas.");
                System.out.println("Posição atual: casa " + (posicao + 2));
            } else if (DescontarSorteReves(azar, posicao)) {
                System.out.println("REVÉS! Volte 2 casas.");
                System.out.println("Posição atual: casa " + (posicao - 2));
            }
        }
        
    }
    private static boolean DescontarSorteReves (int[] vetorSR, int posicao) {
        for (int item : vetorSR) {
            if (item == posicao) {
                return true;
            }
        }
        return false;
    }
}