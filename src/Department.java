
public class Department {
	private String id;
	private String name;
	private int numberOfEmployees;

	public Department() {

	}

	public Department(String id, String name, int numberOfEmployee) {
		this.id = id;
		this.name = name;
		this.numberOfEmployees = numberOfEmployee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	/**
	 * Hàm hiển thị thông tin các bộ phận công ty.
	 */
	public void displayInformation() {
		System.out.printf("%-20s%-20s%s\n", getId(), getName(), getNumberOfEmployees());
	}

}
