package ss.week6.voteMachine;

import ss.week6.voteMachine.gui.VoteGUIView;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class VoteMachine {
    private VoteList voteList;
    private PartyList partyList;
    private VoteView voteView;

    public static void main (String args[]) {
        VoteMachine voteMachine = new VoteMachine();

        voteMachine.start();
    }

    public VoteMachine() {
        this.voteList = new VoteList();
        this.partyList = new PartyList();
        this.voteView = new VoteGUIView(this);

        this.voteList.addObserver(this.voteView);
        this.partyList.addObserver(this.voteView);
    }

    public void start () {
        this.voteView.start();
    }

    public void addParty(String party) {
        this.partyList.addParty(party);
    }

    public void vote (String party) {
        this.voteList.addVote(party);
    }

    public List<String> getParties() {
        return this.partyList.getParties();
    }

    public Map<String, Integer> getVotes() {
        return this.voteList.getVotes();
    }

}
