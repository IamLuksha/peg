import java.util.ArrayList;
import java.util.List;

public class BoardState {

    private boolean [] BoardState;

    private List<int[]> Leap = new ArrayList();
    List<BoardState> NextBoardState = new ArrayList();

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
        NextBoardState.add(nbs);
    }

    public int numNextBoardState(){
        return NextBoardState.size();
    }
    public BoardState getFirstNextBoardState(){
        return NextBoardState.get(0);
    }
    public void removeFirstNextBoardState(){
        NextBoardState.remove(0);
    }

}
