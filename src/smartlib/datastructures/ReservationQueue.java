package smartlib.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class ReservationQueue {

    private Queue<String> queue = new LinkedList<>();

    public void reserve(String userId) {
        queue.add(userId);
    }

    public String nextUser() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
