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
     * Tableau des 4 derniers mouvements
     */
    int[] tabMouv = new int[4];

    /**
     * Time pour le temps d'affichage entre deux plateaux
     */
    static int time = 750;

    /**
     * Niveau de jeu
     */
    static int niveau;

    /**
     * Libellule
     */
    static boolean libellule = false;

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
        {-1, -1, -1, 1, -1},
        {-1, -1, -1, 0, -1},
        {0, 0, 0, 0, 0},
        {0, -1, -1, -1, 0},
        {2, -1, -1, 8, 0}
    };
    /**
     * Tableau du niveau 5
     */
    static int[][] tabNiv5 = {
        {-1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
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
     * Grenouille quand tu ne joues pas
     */
    final static String GRENOUILLE_PASJOUE = oui + "easter eggs 1/6 \n" + "\n"
            + "TU JOUES PAS \n"
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
    final static String GRENOUILLE_ESTPERDU = oui + "easter eggs  4/6 \n" + "\n"
            + "TU ES ALLE.E TROP LOIN ? \n"
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
            + "TU AS QUITTE(E) LE PLATEAU ET TU ES TOMBE(E) ? \n";

    /**
     * Grenouille quand tu te tapes le mur
     */
    final static String GRENOUILLE_MUR = oui + "easter eggs  3/6 \n" + "\n"
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
     * Message perdu
     */
    final static String PERDU = oui + "easter eggs 2/6 \n" + "\n"
            + "$$$$$$$\\  $$$$$$$$\\ $$$$$$$\\  $$$$$$$\\  $$\\   $$\\ \n"
            + "$$  __$$\\ $$  _____|$$  __$$\\ $$  __$$\\ $$ |  $$ |\n"
            + "$$ |  $$ |$$ |      $$ |  $$ |$$ |  $$ |$$ |  $$ |\n"
            + "$$$$$$$  |$$$$$\\    $$$$$$$  |$$ |  $$ |$$ |  $$ |\n"
            + "$$  ____/ $$  __|   $$  __$$< $$ |  $$ |$$ |  $$ |\n"
            + "$$ |      $$ |      $$ |  $$ |$$ |  $$ |$$ |  $$ |\n"
            + "$$ |      $$$$$$$$\\ $$ |  $$ |$$$$$$$  |\\$$$$$$  |\n"
            + "\\__|      \\________|\\__|  \\__|\\_______/  \\______/ \n"
            + "                                                  \n"
            + "                                                  \n"
            + "                                                  ";

    /**
     * Grenouille quand tu manges la libellule
     */
    final static String GRENOUILLE_LIBELLULE = oui + "easter eggs  5/6 \n" + "\n" 
            + "Bien mangé la libellule?"
            + "          ,-.___.-.\n"
            + "       ,-.(|)   (|),-.\n"
            + "       \\_*._ ' '_.* _/\n"
            + "        /`-.`--' .-'\\\n"
            + "   ,--./    `---'    \\,--.\n"
            + "   \\   |(  )     (  )|   /\n"
            + "    \\  | ||       || |  /\n"
            + "     \\ | /|\\     /|\\ | /\n"
            + "     /  \\-._     _,-/  \\\n"
            + "    //| \\\\  `---'  // |\\\\\n"
            + "   /,-.,-.\\       /,-.,-.\\\n"
            + "  o   o   o      o   o    o";

    final static String GRENOUILLE_ROND = oui + "easter eggs 6/6\n" + "\n"
            + "         o  o   o  o\n"
            + "         |\\/ \\^/ \\/|\n"
            + "         |,-------.|\n"
            + "       ,-.(|)   (|),-.\n"
            + "       \\_*._ ' '_.* _/\n"
            + "        /`-.`--' .-'\\\n"
            + "   ,--./    `---'    \\,--.\n"
            + "   \\   |( )       ( )|   /\n"
            + "    \\  ||M\\d8888b /M||  /\n"
            + "     \\ |  ###MMMMA   | /\n"
            + "     /  \\-vMM8888y,-/  \\\n"
            + "    //| \\\\ QMyWWy  // |\\\\\n"
            + "   /,-.,-.\\       /,-.,-.\\\n"
            + "  o   o   o      o   o    o";

    /**
     * Affiche l'interface du menu
     */
    static void afficherMenu() {
        System.out.println("            ,-.___.-.\n"
                + "         ,-.(|)   (|),-.\n"
                + "         \\_*._ ' '_.* _/\n"
                + "    ______oOOo____oOOo___________\n"
                + "\n"
                + "              \n"
                + "\t (2) niveau 2 " + "\n"
                + "\t (3) niveau 3" + "\n"
                + "\t (4) niveau 4 " + "\n"
                + "\t (5) niveau 5" + "\n"
                + "\t (6) niveau 6 " + "\n"
                + "\t (7) Visualiser " + "\n"
                + "\t (8) Indice " + "\n"
                + "\t (9) quitter " + "\n"
                + "\n"
                + "    ______________________________\n"
                + "       /  \\-._     _,-/  \\\n"
                + "      //| \\\\  `---'  // |\\\\\n"
                + "     /,-.,-.\\       /,-.,-.\\\n"
                + "    o   o   o      o   o    o");
    }

    /**
     * Permet de choisir une des fonctionnalités parmi les différents niveaux et
     * de visualiser les indices
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
            niveau = 0;
            int numeroNiveau = saisirNombreIntervalle(2, 9);
            switch (numeroNiveau) {
                case 2:
                    Backroom back2 = new Backroom(tabNiv2);
                    back2.creerPlateau();
                    back2.niveau2();
                    back2.afficheFin();
                    break;
                case 3:
                    Backroom back3 = new Backroom(tabNiv3);
                    back3.creerPlateau();
                    back3.niveau3();
                    back3.afficheFin();
                    break;
                case 4:
                    Backroom back4 = new Backroom(tabNiv4);
                    back4.creerPlateau();
                    back4.niveau4();
                    back4.afficheFin();
                    break;
                case 5:
                    Backroom back5 = new Backroom(tabNiv5);
                    niveau = 5;
                    back5.creerPlateau();
                    back5.niveau5();
                    back5.afficheFin();
                    break;
                case 6:
                    Backroom back6 = new Backroom(tabNiv6);
                    niveau = 6;
                    back6.creerPlateauNiveau6();
                    back6.niveau6();
                    back6.afficheFin();
                    break;
                case 7:
                    Visualiser();
                    break;
                case 8:
                    System.out.println("Indice easter eaggs 1 : Ne joue pas");
                    System.out.println("Indice easter eaggs 2 : L'arrivée est trop loin");
                    System.out.println("Indice easter eaggs 3 : Berlin");
                    System.out.println("Indice easter eaggs 4 : Va sur le banc");
                    System.out.println("Indice easter eaggs 5 : `*\u00b4");
                    System.out.println("Indice easter eaggs 6 : Touches directionnelles");
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Erreur de saisie");
                    break;
            }
            jeuTermine = false;
        }
    }

    /**
     * Permet de visualiser tous les plateaux
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
    }

    /**
     * Demande de saisir un nombre valide pour lancer un jeu ou quitter (1-6)
     *
     * @param min jeu numéro 1
     * @param max boutton quitter
     * @return le numéro saisi pour le jeu ou quitter
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
        ajouteMouv(0);
        update();
    }

    /**
     * Déplace la grenouille vers le bas
     */
    void bas() {
        OldPosX = posX;
        OldPosY = posY;
        posX = posX + 1;
        ajouteMouv(1);
        update();
    }

    /**
     * Déplace la grenouille vers la gauche
     */
    void gauche() {
        OldPosY = posY;
        OldPosX = posX;
        posY = posY - 1;
        ajouteMouv(2);
        update();
    }

    /**
     * Déplace la grenouille vers la droite
     */
    void droite() {
        OldPosY = posY;
        OldPosX = posX;
        posY = posY + 1;
        ajouteMouv(3);
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
     * Niveau 2 Ecrire les déplacements ici
     */
    void niveau2() {
        droite();
    }

    /**
     * Niveau 3 Ecrire les déplacements ici
     */
    void niveau3() {
        for (int i = 0; i < 3; i++) {
            droite();
        }
    }

    /**
     * Niveau 4 Ecrire les déplacements ici
     */
    void niveau4() {

        for (int i = 0; i < 2; i++) {
            bas();
        }
        
        droite();
        bas();
        bas();
        gauche();
        droite();
        haut();
        haut();
        gauche();
         

 /*
        haut();
        bas();
        gauche();
        droite();
        droite();
   */      
        for (int j = 0; j < 3; j++) {
            gauche();
        }
        for (int k = 0; k < 2; k++) {
            bas();
        }

    }

    /**
     * Niveau 5 Ecrire les déplacements ici
     */
    void niveau5() {

        while (tabAct[posX][posY - 1] == 0) {
            gauche();
        }
        haut();
        haut();

    }

    /**
     * Niveau 6 Ecrire les déplacements ici
     */
    void niveau6() {
        for (int i = 0; i < 5; i++) {
            droite();

        }
        for (int y = 0; y < 4; y++) {
            haut();
        }
        for (int j = 0; j < 4; j++) {
            gauche();
        }
    }

    /**
     * Teste si la grenouille est arrivée sur le nénuphar
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
     * Message de fin en fonction du déroulement de la partie
     */
    void afficheFin() {
        if (estArrive()) {
            System.out.println(GRENOUILLE_GAGNE);
        } else if (estRond()) {
            System.out.println(GRENOUILLE_ROND);
        } else if (!estArrive() && niveau != 6) {
            System.out.println(PERDU);
        }
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
                            case 8:
                                plateau.append("|`*\u00b4");
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
        attendre();
        System.out.println(plateau);
        attendre();
    }

    /**
     * Permet de crée un plateau pour le niveau 6
     */
    void creerPlateauNiveau6() {
        StringBuilder plateau = new StringBuilder();
        int zoonL = posX;
        int zoonU = posY;
        int zoonR = posX + 2;
        int zoonD = posY + 2;
        if (posX >= 2) {
            zoonL = posX - 2;
        } else {
            zoonL = posX + (0 - posX);
        }
        if (posY >= 2) {
            zoonU = posY - 2;
        } else {
            zoonU = posY + (0 - posY);
        }
        if (posX + 2 >= tabAct.length) {
            zoonR = tabAct.length;
        }
        if (posY + 2 >= tabAct[0].length) {
            zoonD = tabAct[0].length;
        }

        for (int i = zoonL; i < zoonR; i++) {
            for (int z = 0; z < 2; z++) {
                for (int j = zoonU; j < zoonD; j++) {
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
                            case 8:
                                plateau.append("|`*" + '\u00E9');
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
        for (int p = zoonU; p < zoonD; p++) {
            plateau.append("+---");
        }
        plateau.append("+");
        attendre();
        System.out.println(plateau);
        attendre();
    }

    /**
     * Lance le jeu de la grenouille
     *
     * @return true pour lancer le jeu et false sinon
     */
    static boolean start() {
        boolean demarrer = true;
        return demarrer;
    }

    /**
     * Mets à jour tous les délacements dans le tableau et d'afficher les
     * plateaux
     */
    void update() {
        if (!estRond()) {
            boolean jeuFin = false;
            if (estDansPlateau() && !jeuFin) {
                if (tapeMur()) {
                    System.out.println(GRENOUILLE_MUR);
                    System.exit(0);
                } else if (estArrive()) {
                    tabAct[OldPosX][OldPosY] = 0;
                    tabAct[posX][posY] = 3;
                    creerPlateau();
                    jeuFin = true;
                    if (libellule) {
                        attendre();
                        afficheFin();
                        System.out.println(GRENOUILLE_LIBELLULE);
                        attendre();
                        System.exit(0);
                    }
                } else {
                    if (tabAct[posX][posY] == 8) {
                        libellule = true;
                    }
                    tabAct[OldPosX][OldPosY] = 0;
                    tabAct[posX][posY] = 1;
                    if (niveau == 6) {
                        creerPlateauNiveau6();
                    } else {
                        creerPlateau();
                        jeuFin = true;
                    }
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
        } else {
            afficheFin();
            System.exit(0);
        }
    }

    /**
     * Décale vers la droite tous les élements du tableau tabMouv
     */
    void decalageDroite() {
        for (int i = tabMouv.length - 1; i > 0; i--) {
            tabMouv[i] = tabMouv[i - 1];
        }
    }

    /**
     * Test si l'entier passé en paramètre se trouve dans le tableau tabMouv
     *
     * @param a
     * @return
     */
    boolean existe(int a) {
        boolean res = false;
        for (int i = 0; i < tabMouv.length; i++) {
            if (tabMouv[i] == a) {
                res = true;
            }
        }
        return res;
    }

    /**
     * Permet d'ajouter un mouvement (int) dans le tableau tabMouv
     *
     * @param a
     */
    void ajouteMouv(int a) {
        decalageDroite();
        tabMouv[0] = a;
    }

    /**
     * Test si la grenouille tourne en rond
     *
     * @return
     */
    boolean estRond() {
        boolean res = false;
        if (tabMouv[0] == 3 && tabMouv[1] == 2 && tabMouv[2] == 1 && tabMouv[3] == 0) {
            res = true;
        }
        return res;
    }

    /**
     * Initialise les posX et posY selon où se trouve la grenouille
     *
     * @param plateau la matrice du niveau
     */
    public Backroom(int[][] plateau) {
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
     * Mets un temps entre chaque affichage du plateau
     */
    public static void attendre() {
        if (niveau == 5) {
            time = 300;
        }
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (start()) {
            choixNiveau();
        } else {
            System.out.println(GRENOUILLE_PASJOUE);
        }

    }

}
