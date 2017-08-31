package hu.swing.workers;

public class WorkersConfig {

	private Integer id;
	private String name;
	private float identification;
	private String entry_date;
	private String exit_date;
	private String home_address;
	private String id_card;
	private int tax_card;
	private int social_security_card;
	private byte[] picture;

	public WorkersConfig(int wId, String wName, float wIdentification, String wAddDate, String wExitDate, byte[] wImgage) {
		this.id = wId;
		this.name = wName;
		this.identification = wIdentification;
		this.entry_date = wAddDate;
		this.exit_date = wExitDate;
		this.picture = wImgage;
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

	public String getHome_address() {
		return home_address;
	}

	public String getId_card() {
		return id_card;
	}

	public int getTax_card() {
		return tax_card;
	}

	public int getSocial_security_card() {
		return social_security_card;
	}

	public byte[] getImage() {
		return picture;
	}

}