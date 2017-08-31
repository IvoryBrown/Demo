package hu.swing.workers;

public class WorkersConfig {

	private Integer id;
	private String name;
	private float identification;
	private String entry_date;
	private String exit_date;
	private String home_address;
	private String id_card;
	private Integer tax_card;
	private Integer social_security_card;
	private byte[] picture;

	public WorkersConfig(Integer wId, String wName, float wIdentification, String wAddDate, String wExitDate,
			String wHomeAddress, String wIdCard, Integer wTaxCard, Integer wSocialSecurityCard, byte[] wImgage) {
		this.id = wId;
		this.name = wName;
		this.identification = wIdentification;
		this.entry_date = wAddDate;
		this.exit_date = wExitDate;
		this.home_address = wHomeAddress;
		this.id_card = wIdCard;
		this.tax_card = wTaxCard;
		this.social_security_card = wSocialSecurityCard;
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

	public String getHomeAddress() {
		return home_address;
	}

	public String getIdCard() {
		return id_card;
	}

	public int getTaxCard() {
		return tax_card;
	}

	public int getSocialSecurityCard() {
		return social_security_card;
	}

	public byte[] getImage() {
		return picture;
	}

}