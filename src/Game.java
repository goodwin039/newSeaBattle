public class Game {
    public void startGame() {
        Player player = new Player();
        Cell cell = new Cell();
        cell.fillField();
//        cell.autoInitField();
        cell.initShip();
        cell.viewField();


        while (cell.isNotGameOver()) {

            int shootX = player.doShootX();
            int shootY = player.doShootY();
            cell.checkShoot(shootY,shootX);
            //
            cell.viewField();
        }

        System.out.println("Игра окончена.");


    }
}
