package ss.week7.multiclientchat;

import ss.week5.ComputerPlayer;

public class ChatProtocol {
    public static String requestUsername () {
        return formatCommand(Command.PROVIDE_USERNAME);
    }

    public static String provideUsername (String username) {
        return formatCommand(Command.PROVIDE_USERNAME, username);
    }

    public static String handleUsernameRequested () {
        return "Please provide a username: ";
    }

    private static String formatCommand(Command command) {
        return "[" + command.tag() + "];";
    }

    private static String formatCommand(Command command, String payload) {
        return "[" + command.tag() + "];" + payload;
    }

    private static void handleInboundMessage (String message) {
        //
    }

}
