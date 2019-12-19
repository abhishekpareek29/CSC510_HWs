import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiskTest {

    private Disk disk;
    private Movie movie;

    // @BeforeEach
    // void setUp() {
    //     movie = new Movie("Harry Potter", 0);
    //     disk = new Disk("C001", movie, DiskType.BLUERAY);
    // }

    // @AfterEach
    // void tearDown() {
    // }

    // @Test
    // void getSerialNo() {
    //     assert(disk.getSerialNo() == "C001");
    // }

    // @Test
    // void setSerialNo() {
    //     disk.setSerialNo("C002");
    //     assert(disk.getSerialNo() == "C002");
    // }

    // @Test
    // void getMovie() {
    //     Movie m = disk.getMovie();
    //     assert(m.getName() == "Harry Potter");
    // }

    // @Test
    // void setMovie() {
    //     Movie m = new Movie("Lord of the Rings", 1);
    //     disk.setMovie(m);
    //     assert(disk.getMovie().getName() == "Lord of the Rings");
    // }

    // @Test
    // void getDiskType() {
    //     assert(disk.getDiskType() == DiskType.BLUERAY);
    // }

    @Test
    void setDiskType() {
        disk.setDiskType(DiskType.DVD);
        assert(disk.getDiskType() == DiskType.DVD);
    }
}