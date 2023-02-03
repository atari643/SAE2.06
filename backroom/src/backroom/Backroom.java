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
     * Tableau du niveau 1
     */
    static int[][] tabNiv1 = {
        {0, -1, 1, -1, 0},
        {0, -1, 0, -1, 0},
        {0, -1, 0, -1, 0},
        {0, -1, 0, 2, 0},
        {0, -1, -1, -1, 0}
    };
    /**
     * Tableau du niveau 1
     */
    static int[][] tabNiv2 = {
        {0, -1, 1, -1, 0},
        {0, -1, 0, -1, 0},
        {0, -1, 0, -1, 0},
        {0, -1, 0, 2, 0},
        {0, -1, -1, -1, 0}
    };
    /**
     * Tableau du niveau 1
     */
    static int[][] tabNiv3 = {
        {0, -1, 1, -1, 0},
        {0, -1, 0, -1, 0},
        {0, -1, 0, -1, 0},
        {0, -1, 0, 2, 0},
        {0, -1, -1, -1, 0}
    };
    /**
     * Tableau du niveau 1
     */
    static int[][] tabNiv4 = {
        {0, -1, 1, -1, 0},
        {0, -1, 0, -1, 0},
        {0, -1, 0, -1, 0},
        {0, -1, 0, 2, 0},
        {0, -1, -1, -1, 0}
    };
    /**
     * Tableau du niveau 1
     */
    static int[][] tabNiv5 = {
        {0, -1, 1, -1, 0},
        {0, -1, 0, -1, 0},
        {0, -1, 0, -1, 0},
        {0, -1, 0, 2, 0},
        {0, -1, -1, -1, 0}
    };

    /**
     * Grenouille quand t'as perdu
     */
    final static String GRENOUILLE_ESTPERDU =  "BRAVO TU AS TROUVÉ UN EASTER EGSS"+
            "TU T'ES PRIS POUR ZORO A TE PERDRE ? \n"
            + "          .--._.--.\n"
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
            + "         '-'|/   \\|`-`\n"
            + "TU T'ES PRIS POUR ZORO A TE PERDRE ? \n";

    /**
     * Grenouille quand tu te tapes le mur
     */
    final static String GRENOUILLE_MUR = "BRAVO TU AS TROUVÉ UN EASTER EGSS"+
            "EH BEN ALORS, FAUT PAS SE PRENDRE LES MURS \n"
            + "            _____________________\n"
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
            + "     /.-./.-.|               /.-.|.-.\\ \n"
            + "EH BEN ALORS, FAUT PAS SE PRENDRE LES MURS \n";

    /**
     * Grenouille quand tu gagnes
     */
    final static String GRENOUILLE_GAGNE = "VOUS AVEZ GAGNEZ! BRAVO \n"
            + "       ____  __.---\"\"---.__  ____\n"
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
            + "/.-./.--.|.--.\\          /.--.|.--.\\.-.| \n"
            + "VOUS AVEZ GAGNEZ! BRAVO \n";

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
                + "\t (6) quitter " + "\n"
                + "\n"
                + "    _____________Oooo._____________\n"
                + "       .oooO     (   )\n"
                + "        (   )     ) /\n"
                + "         \\ (     (_/\n"
                + "          \\_)");
    }

    /**
     * Fonction principal du jeu_Aventure
     */
    static void choixNiveau() {
        boolean jeuTermine = true;
        while (jeuTermine == true) {
            afficherMenu();
            int numeroNiveau = saisirNombreIntervalle(1, 6);
            switch (numeroNiveau) {
                case 1:
                    niveau1();
                    jeuTermine = estArrive(tabNiv1);
                    break;
                case 2:
                    niveau2();
                    jeuTermine = estArrive(tabNiv2);
                    break;
                case 3:
                    niveau3();
                    jeuTermine = estArrive(tabNiv3);
                    break;
                case 4:
                    niveau4();
                    jeuTermine = estArrive(tabNiv4);
                    break;
                case 5:
                    niveau5();
                    jeuTermine = estArrive(tabNiv5);
                    break;
                case 6:
                    jeuTermine = false;
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
     * Test si la grenouille se déplace dans un mur
     *
     * @param tab plateau de jeu
     * @return true si la grenouille est dans un mur et false sinon
     */
    static boolean tapeMur(int[][] tab) {
        boolean res = false;
        if (tab[posX][posY] == -1) {
            res = true;
        }
        return res;
    }

    static void niveau1() {
        System.out.println(tabNiv1);
        //
    }

    static void niveau2() {
        System.out.println(tabNiv2);
        //
    }

    static void niveau3() {
        System.out.println(tabNiv3);
        //

    }

    static void niveau4() {
        System.out.println(tabNiv4);
        //
    }

    static void niveau5() {
        System.out.println(tabNiv5);
        //

    }

    /**
     * Test si la grenouille est arrivé sur le nénuphar
     *
     * @param tab plateau de jeu
     * @return true si elle est sur le nénuphar et false sinon
     */
    static boolean estArrive(int[][] tab) {
        boolean res = false;
        if (tab[posX][posY] == 2) {
            res = true;
        }
        return res;
    }

    /**
     * Test si la grenouille est sur une case vide
     *
     * @param tab plateau de jeu
     * @return true si elle est sur une case vide et false sinon
     */
    static boolean estDansPlateau(int[][] tab) {
        boolean res = false;
        if (tab[posX][posY] == 0) {
            res = true;
        }
        return res;
    }

    /**
     * Créer le plateau en fonction du tableau
     *
     * @param tab tableau en question pour créer le plateau
     */
    static void creePlateau(int[][] tab) {
        StringBuilder plateau = new StringBuilder();
        for (int i = 0; i < tab.length; i++) {
            for (int z = 0; z < 2; z++) {
                for (int j = 0; j < tab[0].length; j++) {
                    if (z == 0) {
                        plateau.append("+---");
                    } else {
                        switch (tab[i][j]) {
                            case -1:
                                plateau.append("|###");
                                break;
                            case 0:
                                plateau.append("|   ");
                                break;
                            case 1:
                                plateau.append("|moi");
                                break;
                            case 2:
                                plateau.append("|'-'");
                                break;
                            default:
                                break;
                        }
                    }
                }
                if (z == 0) {
                    plateau.append("+");
                } else {
                    plateau.append("|");
                }
                plateau.append("\n");
            }
        }
        for (int p = 0; p < tab.length; p++) {
            plateau.append("+---");
        }
        plateau.append("+");
        System.out.println(plateau);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        afficherMenu();
        System.out.println(GRENOUILLE_GAGNE);
        System.out.println(GRENOUILLE_ESTPERDU);
        System.out.println(GRENOUILLE_MUR);
        creePlateau(tabNiv1);
        choixNiveau();
    }
}
