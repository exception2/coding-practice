package arintra;

public interface RandomSet {

    void initialize();

    boolean insert(int val);
    boolean delete(int val);

    int getRandom();
}
