package ru.netology;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        // int time1 = o1.getTimeTo() - o1.getTimeTo();
        //  int time2 = t2.getTimeTo() - o2.getTimeTo();

        if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
