package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {
    private Map<String, Integer> votes;

    public VoteList () {
        this.votes = new HashMap<>();
    }

    public void addVote(String party) {
        votes.put(party, this.votes.keySet().contains(party) ? votes.get(party) + 1 : 1);
        this.setChanged();
        this.notifyObservers("vote");
    }

    public Map<String, Integer> getVotes () {
        return this.votes;
    }
}
