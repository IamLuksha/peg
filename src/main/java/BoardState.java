import java.util.ArrayList;
import java.util.List;

public class BoardState {

    private boolean [] BoardState;

    private List<int[]> Leap = new ArrayList();

    List<BoardState> NextBoardStates = new ArrayList();

    public BoardState (boolean[] boardState) {
        this.BoardState = boardState;
    }

    public void setLeap(List<int[]>  leap) {
        Leap = leap;
    }

    public List<int[]> getLeap() {
        return Leap;
    }

    public boolean[] getBoardState() {
        return BoardState;
    }

    public void addNextBoardState(BoardState nbs) {
        NextBoardStates.add(nbs);
    }

    public int numNextBoardState(){
        return NextBoardStates.size();
    }
    public BoardState getFirstNextBoardState(){
        return NextBoardStates.get(0);
    }
    public void removeFirstNextBoardState(){
        NextBoardStates.remove(0);
    }

}
