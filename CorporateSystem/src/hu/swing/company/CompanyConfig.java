package hu.swing.company;

public class CompanyConfig {
	private Integer id_partner_code;
	private String partner_name;
	private String company_name;
	private String country;
	private Integer zip_code;
	private String city;
	private String street;
	private Integer house_number;
	private String email;
	private Integer landline_phone;
	private Integer mobile_phone;
	private Integer account_number;
	private String banks_name;
	private String administrator_name;
	private String comment;

	public CompanyConfig(Integer cIdPartnerCode, String cPartnerName, String cCompanyName, String cCountry,
			Integer cZipCode, String cCity, String cStreet, Integer cHouseNumber, String cEmail, Integer cLandlinePhone,
			Integer cMobilePhone, Integer cAccountNumber, String cBanksName, String cAdministratorName,
			String cComment) {
		this.id_partner_code = cIdPartnerCode;
		this.partner_name = cPartnerName;
		this.company_name = cCompanyName;
		this.country = cCountry;
		this.zip_code = cZipCode;
		this.city = cCity;
		this.street = cStreet;
		this.house_number = cHouseNumber;
		this.email = cEmail;
		this.landline_phone = cLandlinePhone;
		this.mobile_phone = cMobilePhone;
		this.account_number = cAccountNumber;
		this.banks_name = cBanksName;
		this.administrator_name = cAdministratorName;
		this.comment = cComment;
	}

	public Integer getId_partner_code() {
		return id_partner_code;
	}

	public String getPartner_name() {
		return partner_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public String getCountry() {
		return country;
	}

	public Integer getZip_code() {
		return zip_code;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public Integer getHouse_number() {
		return house_number;
	}

	public String getEmail() {
		return email;
	}

	public Integer getLandline_phone() {
		return landline_phone;
	}

	public Integer getMobile_phone() {
		return mobile_phone;
	}

	public Integer getAccount_number() {
		return account_number;
	}

	public String getBanks_name() {
		return banks_name;
	}

	public String getAdministrator_name() {
		return administrator_name;
	}

	public String getComment() {
		return comment;
	}

}
