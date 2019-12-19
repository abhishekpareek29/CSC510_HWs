import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    private Rental rental;
    private Disk disk;
    private Movie movie;

    // @org.junit.jupiter.api.BeforeEach
    // void setUp() {
    //     movie = new Movie("Harry Potter", 1);
    //     disk = new Disk("C001", movie, DiskType.BLUERAY);
    //     rental = new Rental(disk, 10);
    // }

    // @org.junit.jupiter.api.AfterEach
    // void tearDown() {
    // }

    // @org.junit.jupiter.api.Test
    // void getDisk() {
    //     Disk d = rental.getDisk();
    //     assert(d.getMovie().getName() == "Harry Potter");
    //     assert(d.getSerialNo() == "C001");
    // }

    // @org.junit.jupiter.api.Test
    // void setDisk() {
    //     Disk d = new Disk("C002", movie, DiskType.BLUERAY);
    //     rental.setDisk(d);
    //     assert(d.getSerialNo() == "C002");
    // }

    // @org.junit.jupiter.api.Test
    // void getDays() {
    //     assert(rental.getDays() == 10);
    // }

    @org.junit.jupiter.api.Test
    void setDays() {
        rental.setDays(20);
        assert(rental.getDays() == 20);
    }
}