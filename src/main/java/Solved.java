import java.util.ArrayList;
import java.util.List;

public class Solved {
    private int COUNT = 0;

    private int size;
    private OtherMethod om = new OtherMethod();

    private List<int[]> MovePosible = new ArrayList();

    private List<int[]> buffAllMoveposibleState = new ArrayList();

    private List<int[]> buffMovePosible = new ArrayList<>();

    void play(boolean[] boardState) {

        BoardState sBoardState = new BoardState(boardState);

        for (boolean[] nextBoard : possibleState(boardState)) {
            BoardState nextNode = new BoardState(nextBoard);
            if (solved(nextBoard, nextNode)) {
                sBoardState.addNextBoardState(nextNode);
            }
        }
        System.out.println();
        printWinningWay(sBoardState);
    }


    boolean solved(boolean[] boardState, BoardState node) {

        if (bSolved(boardState))
            return true;

        List<boolean[]> nextBoards = possibleState(boardState);

        boolean foundSolved = false;

        for (boolean[] nextBoard : nextBoards) {
            BoardState nextNode = new BoardState(nextBoard);
            if (solved(nextBoard, nextNode)) {
                foundSolved = true;
                node.addNextBoardState(nextNode);
            }

        }
        return foundSolved;
    }


    private void printWinningWay(BoardState boardState) {
        om.print(boardState.getBoardState(),size);
        System.out.println();

        if (boardState.numNextBoardState() > 0) {
            BoardState nextNode  = boardState.getFirstNextBoardState();
            printWinningWay(nextNode);
            if(nextNode.numNextBoardState()== 0 )
                boardState.removeFirstNextBoardState();
        } else {
            System.out.println("******************************************************");
        }
    }

    public List<boolean[]> possibleState(boolean[] boardState) {
        List<boolean[]> state = new ArrayList();

        List<int[]> sBuffAllMoveposibleState = AllMoveposibleState(boardState);

        for (int[] jump : sBuffAllMoveposibleState) {
            state.add(jump(boardState, jump));
        }

        return state;
    }

    private boolean bSolved(boolean[] BoardState) {
        int count = 0;
        for (boolean b : BoardState) {
            if (b) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    private List<int[]> AllMoveposibleState(boolean[] BoardState) {

        buffAllMoveposibleState.clear();
        MovePosible.clear();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (BoardState[om.index(i, j, size)]) {

                    MovePosible = movePosible(i, j, BoardState);
                    if (MovePosible.size() != 0) {
                        for (int[] q: MovePosible) {
                            buffAllMoveposibleState.add(q);
                        }
                    }
                }
            }
        }

        return buffAllMoveposibleState;
    }

    private List<int[]> movePosible(int pos_x, int pos_y, boolean[] BoardState) {

        buffMovePosible.clear();

        int mSPos_x;
        int mSPos_y;
        int mEPos_x;
        int mEPos_y;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i != j) {

                    mSPos_x = pos_x + i;
                    mSPos_y = pos_y + j;

                    int iX = mSPos_x - pos_x;
                    int iY = mSPos_y - pos_y;

                    mEPos_x = pos_x - iX;
                    mEPos_y = pos_y - iY;

                    if (bPointExist(mSPos_x, mSPos_y) && bPointExist(mEPos_x, mEPos_y)) {
                        if (BoardState[om.index(mSPos_x, mSPos_y, size)] != BoardState[om.index(mEPos_x, mEPos_y, size)]) {
                            if (BoardState[om.index(mSPos_x, mSPos_y, size)]) {
                                buffMovePosible.add(new int[]{mSPos_x, mSPos_y, mEPos_x, mEPos_y, pos_x, pos_y});
                            }
                        }
                    }
                }
            }
        }

        return buffMovePosible;
    }

    private boolean bPointExist(int mPos_x, int mPos_y) {
        return (mPos_x >= 0 && mPos_y >= 0 && mPos_x < size && mPos_y < size - mPos_x);
    }

    private void printMove(int x1, int y1, int x2, int y2, int x3, int y3) {
        System.out.println("move" + "(" + x1 + "," + y1 + ")" + "to " + "(" + x2 + "," + y2 + ")" + "over " + "(" + x3 + "," + y3 + ")");
    }

    void setSize(int size) {
        this.size = size;
    }

    private boolean[] jump(boolean[] state, int[] points) {

        boolean[] buffState = state.clone();
        buffState[om.index(points[0], points[1], size)] = false;
        buffState[om.index(points[2], points[3], size)] = true;
        buffState[om.index(points[4], points[5], size)] = false;
        return buffState;
    }

}
