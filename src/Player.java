
import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    int shootX;
    int shootY;

    int doShootX() {
        System.out.println("����� ���������� �������� X �� 1 �� 10");
        while (true) {
            if (scanner.hasNextInt()) {
                int tmp = scanner.nextInt() - 1;
                if ((tmp > Cell.SIZE) || (tmp < 0)) {
                    System.out.println("����� ����� ������������� ����� �� 1 �� 10");
                } else {
                    shootX = tmp;
                    break;
                }
            } else {
                System.out.println("������� ����� ������������� ����� �� 1 �� 10");
                scanner.nextLine();
            }
        }
        return shootX;
    }

    int doShootY() {
        System.out.println("����� ���������� �������� Y �� 1 �� 10");
        while (true) {
            if (scanner.hasNextInt()) {
                int tmp = scanner.nextInt() - 1;
                if ((tmp > Cell.SIZE) || (tmp < 0)) {
                    System.out.println("����� ����� ������������� ����� �� 1 �� 10");
                } else {
                    shootY = tmp;
                    break;
                }
            } else {
                System.out.println("������� ����� ������������� ����� �� 1 �� 10");
                scanner.nextLine();
            }
        }
        return shootY;
    }
}
