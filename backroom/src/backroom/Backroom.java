/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package backroom;

import java.awt.Font;
import java.util.Scanner;

/**
 *
 * @author qartigala
 */
public class Backroom {

    /**
     * Position x de la grenouille
     */
    static int posX = 0;
    /**
     * Position y de la grenouille
     */
    static int posY = 0;

    /**
     * Grenouille quand t'as perdu
     */
    final static String GRENOUILLE_PERDU = "          .--._.--.\n"
            + "          ( O     O )\n"
            + "          /   . .   \\\n"
            + "         .`._______.'.\n"
            + "        /(           )\\\n"
            + "      _/  \\  \\   /  /  \\_\n"
            + "   .~   `  \\  \\ /  /  '   ~.\n"
            + "  {    -.   \\  V  /   .-    }\n"
            + "_ _`.    \\  |  |  |  /    .'_ _\n"
            + ">_       _} |  |  | {_       _<\n"
            + " /. - ~ ,_-'  .^.  `-_, ~ - .\\\n"
            + "         '-'|/   \\|`-`";

    /**
     * Grenouille quand tu te tapes le mur
     */
    final static String GRENOUILLE_MUR = "            _____________________\n"
            + "            |###################|\n"
            + "            |###################|\n"
            + "            |###################|\n"
            + "            |###################|\n"
            + "((-----------------------------------------\n"
            + "| \\         /  /@@ \\      /@@ \\  \\\n"
            + " \\ \\,      /  (     )    (     )  \\            _____\n"
            + "  \\ \\      |   \\___/      \\___/   |           /  __ \\\n"
            + "   \\ \"\"*-__/                      \\           | |  | |\n"
            + "    \"\"*-_                         \"-_         | |  \"\"\"\n"
            + "         \\    -.  _________   .-   __\"-.__.-((  ))\n"
            + "          \\,    \\^    U    ^/     /  \"-___--((  ))\n"
            + "            \\,   \\         /    /'            | |\n"
            + "             |    \\       /   /'              | |\n"
            + "             |     \"-----\"    \\               | |\n"
            + "            /                  \"*-._          | |\n"
            + "           /   /\\          /*-._    \\         | |\n"
            + "          /   /  \"\\______/\"     /   /         | |\n"
            + "         /   /                 /   /          | |\n"
            + "        /. ./                  |. .|          \"\"\"\n"
            + "       /  | |                  / | \\\n"
            + "      /   |  \\                /  |  \\\n"
            + "     /.-./.-.|               /.-.|.-.\\";

    /**
     * Grenouille quand tu gagnes
     */
    final static String GRENOUILLE_GAGNE = "       ____  __.---\"\"---.__  ____\n"
            + "      /####\\/              \\/####\\\n"
            + "     (   /\\ )              ( /\\   )\n"
            + "      \\____/                \\____/\n"
            + "    __/                          \\__\n"
            + " .-\"    .                      .    \"-.\n"
            + " |  |   \\.._                _../   |  |\n"
            + "  \\  \\    \\.\"-.__________.-\"./    /  /\n"
            + "    \\  \\    \"--.________.--\"    /  /\n"
            + "  ___\\  \\_                    _/  /___\n"
            + "./    )))))                  (((((    \\.\n"
            + "\\                                      /\n"
            + " \\           \\_          _/           /\n"
            + "   \\    \\____/\"\"-.____.-\"\"\\____/    /\n"
            + "     \\    \\                  /    /\n"
            + "      \\.  .|                |.  ./\n"
            + "    .\" / |  \\              /  | \\  \".\n"
            + " .\"  /   |   \\            /   |   \\   \".\n"
            + "/.-./.--.|.--.\\          /.--.|.--.\\.-.|";

    /**
     * Affiche l'interface du menu
     */
    static void afficherMenu() {
        System.out.println("           \\\\\\||||||////\n"
                + "            \\\\  ~ ~  //\n"
                + "             (  @ @  )\n"
                + "    ______ oOOo-(_)-oOOo___________\n"
                + "\n"
                + "              \n"
                + "\t (1) niveau 1 " + "\n"
                + "\t (2) niveau 2" + "\n"
                + "\t (3) niveau 3 " + "\n"
                + "\t (4) niveau 4" + "\n"
                + "\t (5) niveau 5 " + "\n"
                + "\t (5) niveau bonus " + "\n"
                + "\t (6) quitter " + "\n"
                + "\n"
                + "    _____________Oooo._____________\n"
                + "       .oooO     (   )\n"
                + "        (   )     ) /\n"
                + "         \\ (     (_/\n"
                + "          \\_)");
    }

    static int[][] tab;//

    /**
     * Fonction principal du jeu_Aventure
     */
    static void choixNiveau() {
        boolean jeuTermine = false;
        while (jeuTermine == false) {
            afficherMenu();
            int numeroNiveau = saisirNombreIntervalle(1, 6);
            switch (numeroNiveau) {
                case 1:
                    niveau1();
                    jeuTermine = estArrive(tab);
                    break;
                case 2:
                    niveau2();
                    jeuTermine = estArrive(tab);
                    break;
                case 3:
                    niveau3();
                    jeuTermine = estArrive(tab);
                    break;
                case 4:
                    niveau4();
                    jeuTermine = estArrive(tab);
                    break;
                case 5:
                    niveau5();
                    jeuTermine = estArrive(tab);
                    break;
                case 6:
                    niveauBonus();
                    jeuTermine = estArrive(tab);
                    break;
                case 7:
                    jeuTermine = true;
                    break;
                default:
                    System.out.println("Erreur de saisie");
                    break;
            }
        }
    }

    /**
     * Demande de saisir un nombre valide pour lancer un jeu ou quitter (1-6)
     *
     * @param min jeu numéro 1
     * @param max boutton quitter
     * @return le numéro saisie pour le jeu ou quitter
     */
    static int saisirNombreIntervalle(int min, int max) {
        System.out.println("Saisir un nombre entre " + min + " et " + max);
        Scanner sc = new Scanner(System.in);
        int nombre = sc.nextInt();
        if (nombre < min || nombre > max) {
            return saisirNombreIntervalle(min, max);
        } else {
            return nombre;
        }
    }

    /**
     * Déplace la grenouille vers le haut
     */
    static void haut() {
        posX--;
    }

    /**
     * Déplace la grenouille vers le bas
     */
    static void bas() {
        posX++;
    }

    /**
     * Déplance la grenouille vers la gauche
     */
    static void gauche() {
        posY--;
    }

    /**
     * Déplace la grenouille vers la droite
     */
    static void droite() {
        posY++;
    }

    /**
     * Test si la grenouille se déplace sur une case vide
     *
     * @param tab plateau de jeu
     * @return true si la grenouille est sur une case vide et false sinon
     */
    static boolean estSurChemin(int[][] tab) {
        boolean res = true;
        if (tab[posX][posY] != 0) {//
            res = false;
        }
        return res;
    }

    static void niveau1() {

    }

    static void niveau2() {

    }

    static void niveau3() {

    }

    static void niveau4() {

    }

    static void niveau5() {

    }

    static void niveauBonus() {

    }

    /**
     * Test si la grenouille est arrivé sur le nénuphar
     *
     * @param tab plateau de jeu
     * @return true si il est sur le nénuphar et false sinon
     */
    static boolean estArrive(int[][] tab) {
        boolean res = false;
        if (tab[posX][posY] == 2) {
            res = true;
        }
        return res;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        afficherMenu();
        System.out.println(GRENOUILLE_GAGNE);
        System.out.println(GRENOUILLE_PERDU);
        System.out.println(GRENOUILLE_MUR);
    }
}