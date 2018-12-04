package ss.week4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ss.week3.bill.Bill;
import ss.week4.hotel.PricedRoom;

public class PricedRoomTest {
    private Bill.Item item;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";

    @Before
    public void setUp() throws Exception {
        item = new PricedRoom(0, PRICE, 0);
    }

    @Test
    public void testGetAmount() throws Exception {
        assertEquals("GetAmount should return the price of the room.", PRICE, item.amount(), 0);
    }

    @Test
    public void testToString() throws Exception {
        assertTrue("The price per night should be included.", item.toString().matches(PRICE_PATTERN));
    }
}
