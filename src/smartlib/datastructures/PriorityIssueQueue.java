package smartlib.datastructures;

import java.util.PriorityQueue;
import smartlib.models.User;

public class PriorityIssueQueue {

    private PriorityQueue<User> pq = new PriorityQueue<>(
        (a, b) -> a.getRole().equals("Faculty") ? -1 : 1
    );

    public void addUser(User user) {
        pq.add(user);
    }

    public User nextUser() {
        return pq.poll();
    }
}
