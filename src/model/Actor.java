package model;

public class Actor {
	private int id;
	private String lastname;
	private String firstname;
	private String gender;

	// Construtor
	public Actor(int id, String firstname, String lastname, String gender) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;

	}

	public Actor(String firstname, String lastname, String gender) {
		super();
		
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;

	}

	public Actor() {

	}

	// Getters setters

	public String getGender() {
		return gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Override
	public String toString() {
		return "Actor [lastname=" + lastname + ", firstname=" + firstname + ", gender=" + gender + "]";
	}

}
