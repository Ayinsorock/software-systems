package ss.week6.voteMachine;

import java.util.*;

public class PartyList extends Observable {
    private List<String> partyList;

    public PartyList(List<String> partyList) {
        this();
        this.partyList.addAll(partyList);
    }

    public PartyList () {
        this.partyList = new ArrayList<>();
    }

    public List<String> getParties() {
        return this.partyList;
    }

    public void addParty (String party) {
        if (this.hasParty(party)) {
            return;
        }


        this.partyList.add(party);
        this.setChanged();
        this.notifyObservers("party");
    }

    public boolean hasParty (String party) {
        return this.partyList.contains(party);
    }
}
