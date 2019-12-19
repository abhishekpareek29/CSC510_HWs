import com.company.RedBlackTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {

    RedBlackTree<Integer> t;

    @BeforeEach
    void setUp() {
        t = new RedBlackTree<Integer>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insert() {
        t.insert(12);
        t.insert(13);
        t.insert(11);
        assert(t.contains(11));
        assert(t.contains(31) == false);
    }

    @Test
    void remove() {
        try {
            t.insert(12);
            t.insert(13);
            t.insert(14);
            t.insert(11);
            t.remove(14);
        }
        catch (Exception exc) {
            assert (true);
        }
    }

    @Test
    void findMin() {
        try {
            int min_item = t.findMin();
        } catch (Exception exc) {
            assert (true);
        }
        try {
            t.insert(10);
            t.insert(20);
            t.insert(30);
            int min_item = t.findMin();
            assert (min_item == 10);
        } catch (Exception exc) {
            assert (false);
        }

    }

    @Test
    void findMax() {
        try {
            int max_item = t.findMax();
        } catch (Exception exc) {
            assert (true);
        }
        try {
            t.insert(10);
            t.insert(20);
            t.insert(30);
            int max_item = t.findMax();
            assert (max_item == 30);
        } catch (Exception exc) {
            assert (false);
        }
    }

    @Test
    void contains() {
        boolean notexists = t.contains(20);
        assert (notexists == false);
        t.insert(10);
        t.insert(20);
        t.insert(30);
        boolean exists = t.contains(20);
        assert (exists == true);
    }

    @Test
    void makeEmpty() {
        t.insert(10);
        t.insert(20);
        t.insert(30);
        boolean notempty = t.isEmpty();
        assert (notempty == false);
        t.makeEmpty();
        boolean empty = t.isEmpty();
        assert (empty == true);
    }

    @Test
    void isEmpty() {
        boolean empty = t.isEmpty();
        assert (empty == true);
        t.insert(20);
        t.insert(30);
        boolean notempty = t.isEmpty();
        assert (notempty == false);
    }
}