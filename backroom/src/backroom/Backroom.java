/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package backroom;

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
    int posX;
    /**
     * Position y de la grenouille.
     */
    int posY;
    /**
     * Ancienne position x de la grenouille.
     */
    int OldPosX;
    /**
     * Ancienne position y de la grenouille.
     */
    int OldPosY;
    /**
     * Tableau sur lequel le personnage bouge.
     */
    int[][] tabAct;

    /**
     * Tableau du niveau 2
     */
    final static int[][] tabNiv2 = {
        {-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1},
        {-1, -1, 1, 2, -1},
        {-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1}
    };
    /**
     * Tableau du niveau 3
     */
    final static int[][] tabNiv3 = {
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
        {-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1},
        {1, 0, 0, 0, 0},
        {-1, -1, -1, -1, 0},
        {-1, -1, -1, -1, 2}
    };
    /**
     * Tableau du niveau 6
     */
    static int[][] tabNiv6 = {
        {-1, -1, -1, -1, 2, 0, 0, 0, 0},
        {-1, -1, -1, -1, -1, -1, -1, -1, 0},
        {-1, 0, -1, 0, -1, -1, -1, -1, 0},
        {-1, 0, -1, 0, -1, -1, -1, -1, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0},
        {-1, -1, -1, 0, -1, -1, -1, -1, -1},
        {-1, -1, -1, 0, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1}
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

    final static String affiche = ""
            + "███   ▄█ ▄███▄      ▄       ▄   ▄███▄      ▄     ▄   ▄███▄       ██▄   ██      ▄      ▄▄▄▄▄       █     ▄███▄     ▄▄▄▄▄       ███   ██   ▄█▄    █  █▀ █▄▄▄▄ ████▄ ████▄ █▀▄▀█     \n"
            + "█  █  ██ █▀   ▀      █       █  █▀   ▀      █     █  █▀   ▀      █  █  █ █      █    █     ▀▄     █     █▀   ▀   █     ▀▄     █  █  █ █  █▀ ▀▄  █▄█   █  ▄▀ █   █ █   █ █ █ █     \n"
            + "█ ▀ ▄ ██ ██▄▄    ██   █ █     █ ██▄▄    ██   █ █   █ ██▄▄        █   █ █▄▄█ ██   █ ▄  ▀▀▀▀▄       █     ██▄▄   ▄  ▀▀▀▀▄       █ ▀ ▄ █▄▄█ █   ▀  █▀▄   █▀▀▌  █   █ █   █ █ ▄ █     \n"
            + "█  ▄▀ ▐█ █▄   ▄▀ █ █  █  █    █ █▄   ▄▀ █ █  █ █   █ █▄   ▄▀     █  █  █  █ █ █  █  ▀▄▄▄▄▀        ███▄  █▄   ▄▀ ▀▄▄▄▄▀        █  ▄▀ █  █ █▄  ▄▀ █  █  █  █  ▀████ ▀████ █   █     \n"
            + "███    ▐ ▀███▀   █  █ █   █  █  ▀███▀   █  █ █ █▄ ▄█ ▀███▀       ███▀     █ █  █ █                    ▀ ▀███▀                 ███      █ ▀███▀    █     █                  █      \n"
            + "                 █   ██    █▐           █   ██  ▀▀▀                      █  █   ██                                                    █          ▀     ▀                  ▀       \n"
            + "                           ▐                                            ▀                                                            ▀                                            ";
    /**
     * Grenouille quand t'as perdu
     */
    final static String GRENOUILLE_ESTPERDU = oui + "\n"
            + "TU EST ALLE.E TROP LOIN ? \n"
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
            + "TU AS QUITTE.E LE PLATEAU ET TU EST TOMBE.E ? \n";

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
     * Grenouille quand tu manga la libellule
     */
    final static String GRENOUILLE_LIBELLULE = oui + "          ,-.___.-.\n"
            + "       ,-.(|)   (|),-.\n"
            + "       \\_*._ ' '_.* _/\n"
            + "        /`-.`--' .-'\\\n"
            + "   ,--./    `---'    \\,--.\n"
            + "   \\   |(  )     (  )|   /\n"
            + "hjw \\  | ||       || |  /\n"
            + "`97  \\ | /|\\     /|\\ | /\n"
            + "     /  \\-._     _,-/  \\\n"
            + "    //| \\\\  `---'  // |\\\\\n"
            + "   /,-.,-.\\       /,-.,-.\\\n"
            + "  o   o   o      o   o    o";

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
                + "\t (7) Visualiser " + "\n"
                + "\t (8) quitter " + "\n"
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
            int numeroNiveau = saisirNombreIntervalle(2, 8);
            switch (numeroNiveau) {
                case 2:
                    Backroom back2 = new Backroom(tabNiv2);
                    back2.creerPlateau();
                    back2.niveau2();
                    jeuTermine = back2.estArrive();
                    break;
                case 3:
                    Backroom back3 = new Backroom(tabNiv3);
                    back3.creerPlateau();
                    back3.niveau3();
                    jeuTermine = back3.estArrive();
                    break;
                case 4:
                    Backroom back4 = new Backroom(tabNiv4);
                    back4.creerPlateau();
                    back4.niveau4();
                    jeuTermine = back4.estArrive();
                    break;
                case 5:
                    Backroom back5 = new Backroom(tabNiv5);
                    back5.creerPlateau();
                    niveau5();
                    jeuTermine = back5.estArrive();
                    break;
                case 6:
                    Backroom back6 = new Backroom(tabNiv6);
                    back6.creerPlateau();
                    niveau6();
                    jeuTermine = back6.estArrive();
                    break;
                case 7:
                    Visualiser();
                    jeuTermine = false;
                case 8:
                    jeuTermine = false;
                    break;
                default:
                    System.out.println("Erreur de saisie");
                    break;
            }
        }
    }

    /**
     * Permet de visualiser touts les plateaux
     */
    static void Visualiser() {
        System.out.println("Plateau niveau 2");
        Backroom back2 = new Backroom(tabNiv2);
        back2.creerPlateau();
        System.out.println("Plateau niveau 3");
        Backroom back3 = new Backroom(tabNiv3);
        back3.creerPlateau();
        System.out.println("Plateau niveau 4");
        Backroom back4 = new Backroom(tabNiv4);
        back4.creerPlateau();
        System.out.println("Plateau niveau 5");
        Backroom back5 = new Backroom(tabNiv5);
        back5.creerPlateau();
        System.out.println("Plateau niveau 6");
        Backroom back6 = new Backroom(tabNiv6);
        back6.creerPlateau();
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
    void haut() {
        OldPosX = posX;
        OldPosY = posY;
        posX = posX - 1;
        update();
    }

    /**
     * Déplace la grenouille vers le bas
     */
    void bas() {
        OldPosX = posX;
        OldPosY = posY;
        posX = posX + 1;
        update();
    }

    /**
     * Déplance la grenouille vers la gauche
     */
    void gauche() {
        OldPosY = posY;
        posY = posY - 1;
        update();
    }

    /**
     * Déplace la grenouille vers la droite
     */
    void droite() {
        OldPosY = posY;
        posY = posY + 1;
        update();
    }

    /**
     * Test si la grenouille se déplace dans un mur
     *
     * @return true si la grenouille est dans un mur et false sinon
     */
    boolean tapeMur() {
        boolean res = false;
        if (tabAct[posX][posY] == -1) {
            res = true;
        }
        return res;
    }

    /**
     * Niveau 2 
     * Ecrire les déplacements ici
     */
    void niveau2() {
        droite();
    }

    /**
     * Niveau 3 
     * Ecrire les déplacements ici
     */
    void niveau3() {
        for (int i = 0; i < 3; i++) {
            droite();
        }
    }

    /**
     * Niveau 4 
     * Ecrire les déplacements ici
     */
    void niveau4() {
        for (int i = 0; i < 3; i++) {
            droite();
        }
        for (int j = 0; j < 2; j++) {
            haut();

        }

    }

        /**
     * Niveau 5
     * Ecrire les déplacements ici
     */
    static void niveau5() {
        System.out.println(tabNiv5);
        //
    }

    /**
     * Niveau 6
     * Ecrire les déplacements ici
     */
    static void niveau6() {
        System.out.println(tabNiv6);
        //

    }

    /**
     * Test si la grenouille est arrivé sur le nénuphar
     *
     * @return true si elle est sur le nénuphar et false sinon
     */
    boolean estArrive() {
        boolean res = false;
        if (estDansPlateau()) {
            if (tabAct[posX][posY] == 2 || tabAct[posX][posY] == 3) {
                res = true;
            }
        }
        return res;
    }

    /**
     * Test si la grenouille est sur une case vide
     *
     * @return true si elle est sur une case vide et false sinon
     */
    boolean estDansPlateau() {
        boolean res = false;
        if (posX >= 0 && posY >= 0 && posX < tabAct.length && posY < tabAct[0].length) {
            res = true;
        }
        return res;
    }

    /**
     * Créer le plateau en fonction du tableau
     *
     */
    void creerPlateau() {
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
        for (int p = 0; p < tabAct[0].length; p++) {
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
    static boolean start() {
        boolean demarrer = false;
        return demarrer;
    }

    void update() {
        if (estDansPlateau()) {
            if (tapeMur()) {
                System.out.println(GRENOUILLE_MUR);
                System.exit(0);
            } else if (estArrive()) {
                tabAct[OldPosX][OldPosY] = 0;
                tabAct[posX][posY] = 3;
                creerPlateau();
                System.out.println(GRENOUILLE_GAGNE);
            } else {
                tabAct[OldPosX][OldPosY] = 0;
                tabAct[posX][posY] = 1;
                creerPlateau();
            }
        } else {
            try {
                Thread.sleep(750);
            } catch (InterruptedException ex) {
            }
            System.out.println(GRENOUILLE_ESTPERDU);
            try {
                Thread.sleep(750);
            } catch (InterruptedException ex) {
            }
            System.out.println(affiche);
            System.exit(0);
        }
    }

    /**
     * Initialise les posX et posY selon où se trouve la grenouille
     *
     * @param plateau la matrice du niveau
     */
    Backroom(int[][] plateau) {
        boolean stop = false;
        int i = 0;
        int j = 0;
        posX = 0;
        posY = 0;
        OldPosX = 0;
        OldPosY = 0;
        int[][] tab = new int[plateau.length][plateau[0].length];
        for (int r = 0; r < tab.length; r++) {
            for (int n = 0; n < tab[0].length; n++) {
                tab[r][n] = plateau[r][n];
            }
        }
        tabAct = tab;
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
