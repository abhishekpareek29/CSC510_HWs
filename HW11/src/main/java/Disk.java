public class Disk extends NamedObject {

	private String serialNo;
	private Movie movie;
	private DiskType diskType;

	public Disk(String serialNo, Movie movie, DiskType diskType) {
		super(serialNo);
		this.serialNo = serialNo;
		this.movie = movie;
		this.diskType = diskType;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public DiskType getDiskType() {
		return diskType;
	}

	public void setDiskType(DiskType diskType) {
		this.diskType = diskType;
	}

}
