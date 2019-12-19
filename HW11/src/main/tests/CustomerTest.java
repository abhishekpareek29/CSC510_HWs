import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    // @BeforeEach
    // void setUp() {
    //     customer = new Customer("Alex");
    // }

    // @AfterEach
    // void tearDown() {
    // }

    // @Test
    // void getStatement() {
    //     Movie movie = new Movie("Harry Potter", 0);
    //     Disk disk = new Disk("C001", movie, DiskType.BLUERAY);
    //     Rental rental = new Rental(disk, 10);
    //     String s = customer.getStatement();
    //     String expectedOutput = "Rental statement for Alex\n\tHarry Potter 23\nBalance is 23\nYou earned 1 reward points";
    //     assert(s == expectedOutput);
    // }

    @Test
    void getHTMLStatement() {
        Movie movie = new Movie("Lord of the rings", 1);
        Disk disk = new Disk("C002", movie, DiskType.DVD);
        Rental rental = new Rental(disk, 20);
        String s = customer.getHTMLStatement();
        String expectedOutput = "Rental statement for Alex\n\tLord of the rings 60\nBalance is 60\nYou earned 2 reward points";
        assert(s == expectedOutput);
    }

}