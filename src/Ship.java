

public class Ship {
    int size;
    char shipArr[][] = new char[10][10];
    int lives;
    int positionX;
    int positionY;
    int rnd;

    Ship(int patternDeck) {
        size = patternDeck;
        lives = patternDeck;
    }


    void initWithRandom() {
        positionX = (int) (Math.random() * (Cell.SIZE - size)) + 1;
        positionY = (int) (Math.random() * (Cell.SIZE - size)) + 1;
        ////////////////////////////////////
        rnd = (int) (Math.random() * 2);


        if (rnd == 0) {///////////////////////////////////////////////////
            for (int i = 0; i < size; i++) {
                shipArr[positionY + i][positionX] = '#';

            }
        } else {//////////////////////////////////////////////////////////
            for (int i = 0; i < size; i++) {////////////////////////////////
                shipArr[positionY][positionX + i] = '#';
                //////////////////////
            }/////////////////////////////////////////////////////////////////
        }

        
    }
}
