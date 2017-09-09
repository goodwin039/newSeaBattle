
public class Cell {

    static final int SIZE = 10;
    char cell[][] = new char[SIZE][SIZE];
    static final int PATTERN_DECK[] = {4, 3,3, 2, 2, 2, 1, 1, 1, 1};//};  // Как только ставлю колличество кораблей большее 2 игра не запускается
    Ship ships[] = new Ship[PATTERN_DECK.length];

    void fillField(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cell[i][j] = '~';
            }
        }
    }

    void viewField() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(cell[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void initShip() {
        for (int i = 0; i < PATTERN_DECK.length; i++) {
            Ship tmpShip = new Ship(PATTERN_DECK[i]);//здесь можно будет переменную добавить отвечающцю за вертикальный или горизонтальный корабль
            boolean isIntersect;

            do {
                isIntersect = false;
                tmpShip.initWithRandom();
                for (int j = 0; j < i; j++) {
                    if (coincideShip(tmpShip)) {
                        isIntersect = true;
                    }
                }
            }while (isIntersect);

            drawnShip(tmpShip);
            ships[i] = tmpShip;
        }
    }


    boolean coincideShip(Ship ship) {

        if (ship.rnd == 0) {
            for (int i = 0; i < ship.size; i++) {
                for (int dy = -1; dy < 2; dy++) {
                    for (int dx = -1; dx < 2; dx++) {
                        if (ship.positionY + dy  + i < 0 || ship.positionY + dy  + i >= SIZE || ship.positionX + dx < 0 || ship.positionX + dx >= SIZE) {
                            continue;
                        }
                        if (cell[ship.positionY + dy + i][ship.positionX + dx] == '#') {
                            return true;
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < ship.size; i++) {
                for (int dy = -1; dy < 2; dy++) {
                    for (int dx = -1; dx < 2; dx++) {
                        if (ship.positionY + dy < 0 || ship.positionY + dy >= SIZE || ship.positionX + dx + i < 0 || ship.positionX + dx + i >= SIZE) {
                            continue;
                        }
                        if (cell[ship.positionY + dy][ship.positionX + dx + i] == '#') {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        return false;
    }

    void drawnShip(Ship tmpShip) {
        if (tmpShip.rnd == 0) {
            for (int i = 0; i < tmpShip.size; i++) {
                cell[tmpShip.positionY + i][tmpShip.positionX] = '#';
            }
        } else {
            for (int i = 0; i < tmpShip.size; i++) {
                cell[tmpShip.positionY][tmpShip.positionX + i] = '#';
            }
        }


    }

    void checkShoot(int shootY, int shootX) {
        switch (cell[shootY][shootX]) {
            case '~':
                System.out.println("Промах, пробуй ещё");
                cell[shootY][shootX] = '*';
                break;
            case '#':
                cell[shootY][shootX] = 'X';
                hitShip(shootY, shootX);
                break;
            case 'X':
                System.out.println("Сюда уже стрелял");
                break;
            case '*':
                System.out.println("Сюда уже стрелял");
                break;
        }
    }

    void hitShip(int shootY, int shootX) {
        for (Ship ship : ships) {
            if (ship.shipArr[shootY][shootX] == '#') {
                ship.lives--;
                if (ship.lives == 0) {
                    System.out.println("Корабль потоплен");
                } else {
                    System.out.println("Ранил");
                }
            }

        }
    }

    boolean isNotGameOver() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cell[i][j] == '#') {
                    return  true;
                }
            }
        }
        return false;
    }
}
