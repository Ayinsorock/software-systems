package ss.week1.hotel;

/**
 * Guest with a name and possibly a room
 * @author Gerjan Wielink
 */
public class Guest {
    private String name;
    private Room room;

    /**
     * Creates a <code>Guest</code> with a given name, without a room.
     * @param name name of the <code>Guest</code>
     */
    public Guest (String name) {
        this.name = name;
    }

    /**
     *
     * Returns the name of this <code>Guest</code>
     */
    public String getName () {
        return this.name;
    }

    /**
     * Returns the current <code>Room</code> this <code>Guest</code> is living in
     * @return the room this <code>Guest</code> resides in.
     *         <code>null</code> if this <code>Guest</code> is not checked into a room
     */
    public Room getRoom () {
        return this.room;
    }

    /**
     * Checks the <code>Guest</code> into a room
     * @param room the <code>Room</code> we want to check this <code>Guest</code> in to.
     * @return <code>true</code> if the check-in was successful, <code>false</code> if not.
     */
    public boolean checkin (Room room) {
        if (room.getGuest() == null) {
            this.room = room;
            room.setGuest(this);
            return true;
        }
        return false;
    }

    /**
     * Checks the guest out of a room
     * @return <code>true</code> if the <code>Guest</code> was checked out.
     *         <code>false</code> if the <code>Guest</code> was not check in in the first place
     */
    public boolean checkout () {
        if (this.room != null) {
            this.room.setGuest(null);
            this.room = null;
            return true;
        }
        return false;
    }

    /**
     * Converts the <code>Guest</code> into a readable string
     * @return A <code>String</code> containing human readable information about the <code>Guest</code>
     */
    public String toString () {
        return "Guest: " + name;
    }
}
