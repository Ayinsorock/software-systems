package ss.week6.voteMachine;

import java.util.*;

public class VoteTUIView implements Observer, VoteView{
    Scanner inStream;
    VoteMachine voteMachine;

    public VoteTUIView (VoteMachine voteMachine) {
        this.voteMachine = voteMachine;
        this.inStream = new Scanner(System.in);
    }

    public static void main (String[] args) {
        System.out.println("Hallo allemaal".replaceFirst("Hallo", ""));

    }


    @Override
    public void start() {
        this.printInstructions();

        while (inStream.hasNextLine()) {
            String command = inStream.nextLine();
            mapCommand(command);
            System.out.print("\nPlease provide a command: ");

        }
    }

    public void mapCommand(String command) {
        Scanner scanner = new Scanner(command);

        if(scanner.hasNext()) {
            String firstWord = scanner.next();

            System.out.println(firstWord);

            switch (firstWord) {
                case "VOTE":
                    this.vote(command);
                    break;

                case "ADD":
                    this.addParty(command);
                    break;

                case "VOTES":
                    this.showVotes(this.voteMachine.getVotes());
                    break;

                case "PARTIES":
                    this.showParties(this.voteMachine.getParties());
                    break;

                case "EXIT":
                    this.inStream.close();
                    break;

                case "HELP":
                    this.printInstructions();
                    break;

                default:
                    this.showError("You did it wrong..");
                    this.printInstructions();
            }
        }
    }

    public void printInstructions () {
        System.out.println(
                "Command: " +
                "\n VOTE [party]" +
                "\n ADD PARTY [party]" +
                "\n VOTES" +
                "\n PARTIES" +
                "\n EXIT" +
                "HELP"
        );
    }

    private void vote(String command) {
        String party  = command.replaceFirst("VOTE ", "");

        this.voteMachine.vote(party);
    }

    private void addParty (String command) {
        String[] tokens = command.split(" ");
        if(tokens[1].equals("PARTY")) {
            String party = command.replaceFirst("ADD PARTY ", "");
            this.voteMachine.addParty(party);
            return;
        }
    }

    @Override
    public void showVotes(Map<String, Integer> votes) {
        System.out.print(votes.toString());
        System.out.flush();
    }

    @Override
    public void showParties(List<String> parties) {
        System.out.print(parties.toString());
        System.out.flush();
    }

    @Override
    public void showError(String message) {
        System.out.println(message);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg.toString());
    }

}
