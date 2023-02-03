/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package backroom;

import java.awt.Font;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author qartigala
 */
public class Backroom {

    final static String oui = "$$$$$$$$\\  $$$$$$\\   $$$$$$\\ $$$$$$$$\\ $$$$$$$$\\ $$$$$$$\\        $$$$$$$$\\  $$$$$$\\   $$$$$$\\   $$$$$$\\   $$$$$$\\  \n"
            + "$$  _____|$$  __$$\\ $$  __$$\\\\__$$  __|$$  _____|$$  __$$\\       $$  _____|$$  __$$\\ $$  __$$\\ $$  __$$\\ $$  __$$\\ \n"
            + "$$ |      $$ /  $$ |$$ /  \\__|  $$ |   $$ |      $$ |  $$ |      $$ |      $$ /  $$ |$$ /  \\__|$$ /  \\__|$$ /  \\__|\n"
            + "$$$$$\\    $$$$$$$$ |\\$$$$$$\\    $$ |   $$$$$\\    $$$$$$$  |      $$$$$\\    $$$$$$$$ |$$ |$$$$\\ $$ |$$$$\\ \\$$$$$$\\  \n"
            + "$$  __|   $$  __$$ | \\____$$\\   $$ |   $$  __|   $$  __$$<       $$  __|   $$  __$$ |$$ |\\_$$ |$$ |\\_$$ | \\____$$\\ \n"
            + "$$ |      $$ |  $$ |$$\\   $$ |  $$ |   $$ |      $$ |  $$ |      $$ |      $$ |  $$ |$$ |  $$ |$$ |  $$ |$$\\   $$ |\n"
            + "$$$$$$$$\\ $$ |  $$ |\\$$$$$$  |  $$ |   $$$$$$$$\\ $$ |  $$ |      $$$$$$$$\\ $$ |  $$ |\\$$$$$$  |\\$$$$$$  |\\$$$$$$  |\n"
            + "\\________|\\__|  \\__| \\______/   \\__|   \\________|\\__|  \\__|      \\________|\\__|  \\__| \\______/  \\______/  \\______/ \n"
            + "                                                                                                                   \n"
            + "                                                                                                                   \n"
            + "                                                                                                                   \n";

    /**
     * Position x de la grenouille.
     */
    static int posX = 0;
    /**
     * Position y de la grenouille.
     */
    static int posY = 0;
    /**
     * Ancienne position x de la grenouille.
     */
    static int OldPosX;
    /**
     * Ancienne position y de la grenouille.
     */
    static int OldPosY;
    /**
     * Tableau sur lequel le personnage bouge.
     */
    static int[][] tabAct;
    /**
     * Tableau du niveau 2
     */
    static int[][] tabNiv2 = {
        {-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1},
        {-1, -1, 1, 2, -1},
        {-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1}
    };
    /**
     * Tableau du niveau 3
     */
    static int[][] tabNiv3 = {
        {-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1},
        {1, 0, 0, 2, -1},
        {-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1}
    };
    /**
     * Tableau du niveau 4
     */
    static int[][] tabNiv4 = {
        {-1, -1, -1, 2, -1},
        {-1, -1, -1, 0, -1},
        {1, 0, 0, 0, -1},
        {-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1}
    };
    /**
     * Tableau du niveau 5
     */
    static int[][] tabNiv5 = {
        {-1, -1, -1, -1, 2},
        {-1, -1, -1, -1, 0},
        {1, 0, 0, 0, 0},
        {-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1}
    };
    /**
     * Tableau du niveau 6
     */
    static int[][] tabNiv6 = {
        {0, -1, 1, -1, 0},
        {0, -1, 0, -1, 0},
        {0, -1, 0, -1, 0},
        {0, -1, 0, 2, 0},
        {0, -1, -1, -1, 0}
    };

    /**
     * Grenouille quand tu joues pas
     */
    final static String GRENOUILLE_PASJOUE = "TU JOUES PAS \n"
            + "    /     \\\n"
            + "      _(I)(I)_\n"
            + "     ( _ .. _ )\n"
            + "      `.`--'.'\n"
            + "       )    (\n"
            + "   ,-./      \\,-.\n"
            + "  ( _( ||  || )_ ) hjw\n"
            + " __\\ \\\\||--||'/ /__\n"
            + " `-._//||\\/||\\\\_.-'\n"
            + "      `--'`--'";

    /**
     * Grenouille quand t'as perdu
     */
    final static String GRENOUILLE_ESTPERDU = oui + "\n"
            + "TU T'ES PRIS POUR ZORO A TE PERDRE ? \n"
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
    final static String GRENOUILLE_MUR = oui + "\n"
            + "EH BEN ALORS, FAUT PAS SE PRENDRE LES MURS \n"
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
    final static String GRENOUILLE_GAGNE = "VOUS AVEZ GAGNE! BRAVO \n"
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
            + "VOUS AVEZ GAGNE! BRAVO \n";

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
                + "\t (2) niveau 2 " + "\n"
                + "\t (3) niveau 3" + "\n"
                + "\t (4) niveau 4 " + "\n"
                + "\t (5) niveau 5" + "\n"
                + "\t (6) niveau 6 " + "\n"
                + "\t (7) quitter " + "\n"
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
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Backroom.class.getName()).log(Level.SEVERE, null, ex);
            }
            afficherMenu();
            int numeroNiveau = saisirNombreIntervalle(2, 7);
            switch (numeroNiveau) {
                case 2:
                    tabAct = tabNiv2;
                    Initialiser();
                    creerPlateau();
                    niveau2();
                    jeuTermine = estArrive();
                    break;
                case 3:
                    tabAct = tabNiv3;
                    Initialiser();
                    creerPlateau();
                    niveau3();
                    jeuTermine = estArrive();
                    break;
                case 4:
                    tabAct = tabNiv4;
                    Initialiser();
                    creerPlateau();
                    niveau4();
                    jeuTermine = estArrive();
                    break;
                case 5:
                    tabAct = tabNiv5;
                    Initialiser();
                    creerPlateau();
                    niveau5();
                    jeuTermine = estArrive();
                    break;
                case 6:
                    tabAct = tabNiv6;
                    Initialiser();
                    creerPlateau();
                    niveau6();
                    jeuTermine = estArrive();
                    break;
                case 7:
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
        OldPosX = posX;
        posX--;
        update();
    }

    /**
     * Déplace la grenouille vers le bas
     */
    static void bas() {
        OldPosX = posX;
        posX++;
        update();
    }

    /**
     * Déplance la grenouille vers la gauche
     */
    static void gauche() {
        OldPosY = posY;
        posY--;
        update();
    }

    /**
     * Déplace la grenouille vers la droite
     */
    static void droite() {
        OldPosY = posY;
        posY++;
        update();
    }

    /**
     * Test si la grenouille se déplace dans un mur
     *
     * @return true si la grenouille est dans un mur et false sinon
     */
    static boolean tapeMur() {
        boolean res = false;
        if (tabAct[posX][posY] == -1) {
            res = true;
        }
        return res;
    }

    static void niveau2() {
        droite();
    }

    static void niveau3() {
        droite();
        droite();
        droite();
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

    static void niveau6() {
        System.out.println(tabNiv6);
        //

    }

    /**
     * Test si la grenouille est arrivé sur le nénuphar
     *
     * @return true si elle est sur le nénuphar et false sinon
     */
    static boolean estArrive() {
        boolean res = false;
        if (tabAct[posX][posY] == 2 || tabAct[posX][posY] == 3) {
            res = true;
        }
        return res;
    }

    /**
     * Test si la grenouille est sur une case vide
     *
     * @return true si elle est sur une case vide et false sinon
     */
    static boolean estDansPlateau() {
        boolean res = false;
        if (tabAct[posX][posY] == 0) {
            res = true;
        }
        return res;
    }

    /**
     * Créer le plateau en fonction du tableau
     *
     */
    static void creerPlateau() {
        StringBuilder plateau = new StringBuilder();
        for (int i = 0; i < tabAct.length; i++) {
            for (int z = 0; z < 2; z++) {
                for (int j = 0; j < tabAct[0].length; j++) {
                    if (z == 0) {
                        plateau.append("+---");
                    } else {
                        switch (tabAct[i][j]) {
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
                                plateau.append("|(_)");
                                break;
                            case 3:
                                plateau.append("|YES");
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
        for (int p = 0; p < tabAct.length; p++) {
            plateau.append("+---");
        }
        plateau.append("+");
        try {
            Thread.sleep(750);
        } catch (InterruptedException ex) {
        }
        System.out.println(plateau);
        try {
            Thread.sleep(750);
        } catch (InterruptedException ex) {
        }
    }

    /**
     * Lance le jeu de la grenouille
     *
     * @return true pour lancer le jeu et false sinon
     */
    static boolean start() { //ENELEVER
        boolean demarrer = true;
        return demarrer;
    }

    static void update() {
        if (tapeMur()) {
            System.out.println(GRENOUILLE_MUR);
        } else if (estArrive()) {
            tabAct[OldPosX][OldPosY] = 0;
            tabAct[posX][posY] = 3;
            creerPlateau();
            System.out.println(GRENOUILLE_GAGNE);
        } else if (!estDansPlateau()) {
            System.out.println(GRENOUILLE_ESTPERDU);
        } else {
            tabAct[OldPosX][OldPosY] = 0;
            tabAct[posX][posY] = 1;
            creerPlateau();
        }
    }

    /**
     * Initialise les posX et posY selon où se trouve la grenouille
     *
     * @param tab le tableau
     */
    static void Initialiser() {
        boolean stop = false;
        int i = 0;
        int j = 0;
        posX=0;
        posY=0;
        OldPosX=0;
        OldPosY=0;
        while (i < tabAct.length && stop == false) {
            while (j < tabAct[0].length && stop == false) {
                if (tabAct[i][j] == 1) {
                    posX = i;
                    posY = j;
                    OldPosX = i;
                    OldPosY = j;
                    stop = true;
                }
                j++;
            }
            j = 0;
            i++;

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (start()) {

            choixNiveau();
        } else {
            System.out.println(oui + "\n" + GRENOUILLE_PASJOUE);
        }

    }

}
