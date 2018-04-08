import java.util.Scanner;

public class OtherMethod {

    boolean[] init(int size) {
        boolean BoardState[] = new boolean[size * (1 + size) / 2];
        Scanner in = new Scanner(System.in);
        int nHole = size * (1 + size) / 2;
        System.out.println("enter hole number (1 - " + nHole + ")");
        int qwe;

        do {
            qwe = in.nextInt();
        } while (qwe < 0 || qwe > nHole);

        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                count++;
                if (count == qwe) {
                    BoardState[index(i, j, size)] = false;
                } else {
                    BoardState[index(i, j, size)] = true;
                }
            }
        }

        return BoardState;
    }

    void print(boolean BoardState[], int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if(BoardState[index(i, j, size)])
                    System.out.print(1 + "  ");
                else
                    System.out.print(0 + "  ");
            }
            System.out.println();
        }
    }

    int index(int x, int y, int size) {
        int count = 0;
        int sh = size;
        for (int i = 0; i < x; i++) {
            count += sh;
            sh -= 1;
        }
        count += y;
        return count;
    }
}
