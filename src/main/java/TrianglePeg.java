public class TrianglePeg {

    public static void main(String[] args) {

        int size = 5;
        Solved solved = new Solved();
        OtherMethod om = new OtherMethod();
        boolean BoardState[];

        BoardState = om.init(size);
        om.print(BoardState, size);

        solved.setSize(size);
        solved.play(BoardState);
        
    }

}
