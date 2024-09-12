package arintra;

public class TestRandomSet {

    public static void main(String[] args) {
        RandomSet randomSet = new RandomSetImpl();
        // test case 1
        randomSet.initialize();
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.insert(1));
        randomSet.insert(2);
        randomSet.insert(3);
        randomSet.insert(4);
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
        System.out.println((randomSet.delete(1)));
        System.out.println((randomSet.delete(1)));
        System.out.println((randomSet.delete(2)));
        System.out.println((randomSet.delete(3)));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());

    }
}
