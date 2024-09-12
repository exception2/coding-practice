package general;

import java.util.ArrayList;
import java.util.List;

public class ListThreadExample {

    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread t1 = new Thread(() -> {
            resource.add(1);
        });
        Thread t2 = new Thread(() -> resource.add(2));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(resource.list);
    }
}
class Resource {
    List<Integer> list;
    Resource() {
        list = new ArrayList<>();
    }
    public synchronized void add(int n) {
        list.add(n);
    }
}
