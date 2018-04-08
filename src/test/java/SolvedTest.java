import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class SolvedTest {


    Solved solved = new Solved();

    @Test
    public void bPointExist() throws FileNotFoundException {

        solved.setSize(5);
        File file = new File("src/testData/pointExist.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            int x = input.nextInt();
            int y = input.nextInt();
            boolean b = input.nextBoolean();
            assertEquals(b, solved.bPointExist(x, y));
        }
        input.close();

    }


    @Test
    public void bSolvedTest() {

        List<boolean[]> buff = new ArrayList<>();

        buff.add(new boolean[]{true, true, true, true, true, true, true, false});
        buff.add(new boolean[]{true, true, true, true, true, true, true, false});
        buff.add(new boolean[]{true, true, false, true, true, true, true, false});
        buff.add(new boolean[]{false, false, false, false, false, false, true, false});
        buff.add(new boolean[]{true, false, true, false, true, false, true, false});
        buff.add(new boolean[]{true, true, true, true, true, true, true, false});
        buff.add(new boolean[]{false, false, false, true, false, false, false, false});
        buff.add(new boolean[]{true, true, true, false, true, true, true, false});

        boolean[] expected = new boolean[]{false, false, false, true, false, false, true, false};
        int index = 0;

        for (boolean[] b : buff) {
            assertEquals(expected[index], solved.bSolved(b));
            index++;
        }
    }


    @Test
    public void possibleStateTest() {

        solved.setSize(5);

        boolean[] state = new boolean[]{
                true, true, true, true, true,
                false, true, true, true,
                true, true, true,
                true, true,
                true};

        List<boolean[]> AllnextState = new ArrayList<>();

        AllnextState.add(new boolean[]{
                true, true, true, true, true,
                true, false, false, true,
                true, true, true,
                true, true,
                true});
        AllnextState.add(new boolean[]{
                true, true, true, true, true,
                true, true, true, true,
                false, true, true,
                false, true,
                true});

        List<boolean[]> buff = solved.possibleState(state);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals((AllnextState.get(i)[j]) ? 1 : 0,(buff.get(i)[j]) ? 1 : 0);
            }
        }
    }
}
