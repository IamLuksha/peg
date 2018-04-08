import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;


public class OtherMethodTest {


    @Test
    public void convert_index_ij_to_i() throws FileNotFoundException {

        // arrange
        OtherMethod om = new OtherMethod();
        File file = new File("src/testData/convert_index_ij_to_i.txt");
        Scanner input = new Scanner(file);
        List<int[]> data = new ArrayList<>();

        while (input.hasNextLine()) {
            int[] ij_i = new int[3];
            ij_i[0] = input.nextInt();
            ij_i[1] = input.nextInt();
            ij_i[2] = input.nextInt();

            data.add(ij_i);
        }
        input.close();
        input.close();

        // act
        int res;

        // assert
        for (int[] buff:data) {
            res = om.index(buff[0], buff[1],5);

            assertEquals(buff[2], res);
        }
    }

}