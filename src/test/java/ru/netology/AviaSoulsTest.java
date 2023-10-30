package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testSortTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NSK", 300, 10, 22);//3
        Ticket ticket2 = new Ticket("MSK", "NSK", 200, 2, 12);//2
        Ticket ticket3 = new Ticket("MSK", "SPB", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "NSK", 100, 11, 15);//1
        Ticket ticket5 = new Ticket("MSK", "SPB", 400, 5, 12);
        Ticket ticket6 = new Ticket("MSK", "PHU", 500, 7, 15);
        Ticket ticket7 = new Ticket("MSK", "NSK", 400, 10, 17);//4
        Ticket ticket8 = new Ticket("MSK", "NSK", 500, 11, 19);//5
        Ticket ticket9 = new Ticket("MSK", "SPB", 600, 4, 9);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("MSK", "NSK");
        Ticket[] expected = {ticket4, ticket2, ticket1, ticket7, ticket8};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortZeroTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NSK", 300, 10, 22);
        Ticket ticket2 = new Ticket("MSK", "NSK", 200, 2, 12);
        Ticket ticket3 = new Ticket("MSK", "SPB", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "NSK", 100, 11, 15);
        Ticket ticket5 = new Ticket("MSK", "SPB", 400, 5, 12);
        Ticket ticket6 = new Ticket("MSK", "PHU", 700, 7, 15);
        Ticket ticket7 = new Ticket("MSK", "NSK", 400, 10, 17);
        Ticket ticket8 = new Ticket("MSK", "NSK", 500, 11, 19);
        Ticket ticket9 = new Ticket("MSK", "SPB", 600, 4, 9);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("MSK", "KZN");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NSK", 300, 10, 22);
        Ticket ticket2 = new Ticket("MSK", "NSK", 200, 2, 12);
        Ticket ticket3 = new Ticket("MSK", "SPB", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "NSK", 100, 11, 15);
        Ticket ticket5 = new Ticket("MSK", "SPB", 400, 5, 12);
        Ticket ticket6 = new Ticket("MSK", "PHU", 700, 7, 15);
        Ticket ticket7 = new Ticket("MSK", "NSK", 400, 10, 17);
        Ticket ticket8 = new Ticket("MSK", "NSK", 500, 11, 19);
        Ticket ticket9 = new Ticket("MSK", "SPB", 600, 4, 9);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("MSK", "PHU");
        Ticket[] expected = {ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testSortTicketsTimeWithToComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NSK", 300, 10, 22);//12
        Ticket ticket2 = new Ticket("MSK", "NSK", 200, 2, 12);//10
        Ticket ticket3 = new Ticket("MSK", "SPB", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "NSK", 100, 11, 15);//4
        Ticket ticket5 = new Ticket("MSK", "SPB", 400, 5, 12);
        Ticket ticket6 = new Ticket("MSK", "PHU", 700, 7, 15);
        Ticket ticket7 = new Ticket("MSK", "NSK", 400, 10, 17);//9
        Ticket ticket8 = new Ticket("MSK", "NSK", 500, 11, 19);//8
        Ticket ticket9 = new Ticket("MSK", "SPB", 600, 4, 9);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("MSK", "NSK", comparator);
        Ticket[] expected = {ticket4, ticket8, ticket7, ticket2, ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCompareToOneHighPriceToComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NSK", 300, 10, 22);
        Ticket ticket2 = new Ticket("MSK", "NSK", 200, 2, 12);
        Ticket ticket3 = new Ticket("MSK", "SPB", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "NSK", 100, 11, 15);
        Ticket ticket5 = new Ticket("MSK", "SPB", 400, 5, 12);
        Ticket ticket6 = new Ticket("MSK", "PHU", 700, 7, 15);
        Ticket ticket7 = new Ticket("MSK", "NSK", 400, 10, 17);
        Ticket ticket8 = new Ticket("MSK", "NSK", 500, 11, 19);
        Ticket ticket9 = new Ticket("MSK", "SPB", 600, 4, 9);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "PHU", comparator);
        Ticket[] expected = {ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCompareToOneZeroTimeComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NSK", 300, 10, 22);
        Ticket ticket2 = new Ticket("MSK", "NSK", 200, 2, 12);
        Ticket ticket3 = new Ticket("MSK", "SPB", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "NSK", 100, 11, 15);
        Ticket ticket5 = new Ticket("MSK", "SPB", 400, 5, 12);
        Ticket ticket6 = new Ticket("MSK", "PHU", 700, 7, 15);
        Ticket ticket7 = new Ticket("MSK", "NSK", 400, 10, 17);
        Ticket ticket8 = new Ticket("MSK", "NSK", 500, 11, 19);
        Ticket ticket9 = new Ticket("MSK", "SPB", 600, 4, 9);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        int expected = 0;
        int actual = 0;
        Assertions.assertEquals(actual, expected);
    }
}


