import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    Deque<Integer> d;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        d = new Deque<Integer>();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
        d.addFront(10);
        d.addFront(20);
        d.addFront(30);
        d.clear();
        int size = d.size();
        assert (size == 0);
    }

    @org.junit.jupiter.api.Test
    void size() {
        d.addFront(10);
        d.addFront(20);
        d.addFront(30);
        int res = d.size();
        assert (res == 3);
    }

    @org.junit.jupiter.api.Test
    void addFront() {
        assert (d.peekFront() == null);
        d.addFront(10);
        d.addFront(20);
        int front_item = d.peekFront();
        assert (front_item == 20);
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        assert (d.peekBack() == null);
        d.addBack(10);
        d.addBack(20);
        int back_item = d.peekBack();
        assert (back_item == 20);
    }

    @org.junit.jupiter.api.Test
    void peekFront() {
        d.addFront(10);
        d.addFront(20);
        int front_item = d.peekFront();
        assert (front_item == 20);
    }

    @org.junit.jupiter.api.Test
    void peekBack() {
        d.addBack(10);
        d.addBack(20);
        int back_item = d.peekBack();
        assert (back_item == 20);
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        try {
            d.removeFront();
            int size = d.size();
            assert (size == 0);
        } catch (Exception exc) {
            assert (false);
        }
        d.addFront(10);
        d.addFront(20);
        d.addFront(30);
        d.removeFront();
        int front_item = d.peekFront();
        assert (front_item == 20);
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        try {
            d.removeBack();
            int size = d.size();
            assert (size == 0);
        } catch (Exception exc) {
            assert (false);
        }
        d.addFront(10);
        d.addFront(20);
        d.addFront(30);
        d.removeBack();
        int back_item = d.peekBack();
        assert (back_item == 20);
    }

    @org.junit.jupiter.api.Test
    void contains() {
        assert (d.contains(20) == false);
        d.addFront(10);
        d.addFront(20);
        d.addFront(30);
        boolean res_true = d.contains(20);
        assert (res_true == true);
        boolean res_false = d.contains(40);
        assert (res_false == false);
    }
}