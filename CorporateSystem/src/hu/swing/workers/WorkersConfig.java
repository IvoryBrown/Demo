package hu.swing.workers;

public class WorkersConfig {

	private int id;
	private String name;
	private float identification;
	private String entry_date;
	private String exit_date;
	private byte[] picture;

	public WorkersConfig(int pid, String pname, float pidentification, String pAddDate, String pExitDate, byte[] pimg) {
		this.id = pid;
		this.name = pname;
		this.identification = pidentification;
		this.entry_date = pAddDate;
		this.exit_date = pExitDate;
		this.picture = pimg;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getIdentification() {
		return identification;
	}

	public String getAddDate() {
		return entry_date;
	}

	public String getExitDate() {
		return exit_date;
	}

	public byte[] getImage() {
		return picture;
	}

}