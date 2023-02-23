/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backroom;

import org.junit.Test;

/**
 *
 * @author legraziani
 */
public class BackroomTest {

    @Test
    public void tapeMurTest() {
        int[][] tabpartie = {{-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1},
        {1, 0, 0, 2, -1},
        {-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1}};
        Backroom partie = new Backroom(tabpartie);
        assert (!partie.tapeMur());
        partie.posX = 2;
        partie.posY = 3;
        assert (!partie.tapeMur());
        partie.posX = 0;
        partie.posY = 0;
        assert (partie.tapeMur());
    }

    @Test
    public void estArriveTest() {
        int[][] tabpartie = {{-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1},
        {1, 0, 0, 2, -1},
        {-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1}};
        Backroom partie = new Backroom(tabpartie);
    }

    @Test
    public void estDansPlateauTest() {
int[][] tabpartie = {{-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1},
        {1, 0, 0, 2, -1},
        {-1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1}};
        Backroom partie = new Backroom(tabpartie);
    }
}
