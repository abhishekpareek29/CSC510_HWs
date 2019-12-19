public class Rental extends NamedObject {
	private Disk disk;
	private int days;

	public Rental(Disk disk, int days) {
		super(disk.getName());
		this.disk = disk;
		this.days = days;
	}

	public Disk getDisk() {
		return disk;
	}

	public void setDisk(Disk serialNo) {
		this.disk = disk;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
}
