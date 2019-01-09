package ss.week7.multiclientchat;

public enum Command {
    REQUEST_USERNAME("request_username"),
    PROVIDE_USERNAME("provide_username");

    private String tag;

    Command (String tag) {
        this.tag = tag;
    }

    public String tag () {
        return tag;
    }
}
