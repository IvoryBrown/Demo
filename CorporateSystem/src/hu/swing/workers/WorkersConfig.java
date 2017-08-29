package hu.swing.workers;

public class WorkersConfig {
	private Integer id_workers;
	private String last_name;
	private String first_name;
	private Integer year_of_birth;
	private String post;
	private Integer phone_number;
	private Integer shift;
	private String home_address;

	public Integer getId_workers() {
		return id_workers;
	}

	public void setId_workers(Integer id_workers) {
		this.id_workers = id_workers;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public Integer getYear_of_birth() {
		return year_of_birth;
	}

	public void setYear_of_birth(Integer year_of_birth) {
		this.year_of_birth = year_of_birth;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Integer getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Integer phone_number) {
		this.phone_number = phone_number;
	}

	public Integer getShift() {
		return shift;
	}

	public void setShift(Integer shift) {
		this.shift = shift;
	}

	public String getHome_address() {
		return home_address;
	}

	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}

	@Override
	public String toString() {
		return "WorkersConfig [id_workers=" + id_workers + ", last_name=" + last_name + ", first_name=" + first_name
				+ ", year_of_birth=" + year_of_birth + ", post=" + post + ", phone_number=" + phone_number + ", shift="
				+ shift + ", home_address=" + home_address + "]";
	}

}
