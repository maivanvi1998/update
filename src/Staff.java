
public abstract class Staff implements ICalculator {
	private String id;
	private String fullName;
	private int age;
	private double coefficientSalary;
	private String dateStart;
	private String department;
	private int numberOfDayOff;

	public Staff() {

	}

	public Staff(String id, String fullName, int age, double coefficientSalary, String dateStart, String department,
			int numberOfDayOff) {
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.coefficientSalary = coefficientSalary;
		this.dateStart = dateStart;
		this.department = department;
		this.numberOfDayOff = numberOfDayOff;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getCoefficientSalary() {
		return coefficientSalary;
	}

	public void setCoefficientSalary(double coefficientSalary) {
		this.coefficientSalary = coefficientSalary;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getNumberOfDayOff() {
		return numberOfDayOff;
	}

	public void setNumberOfDayOff(int numberOfDayOff) {
		this.numberOfDayOff = numberOfDayOff;
	}

	public abstract void displayInformation();
}
