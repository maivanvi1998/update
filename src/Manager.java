
public class Manager extends Staff implements ICalculator {
	private String position;

	public Manager() {

	}

	public Manager(String id, String fullName, int age, double coefficientSalary, String dateStart, String department,
			int numberOfDayOff, String position) {
		super(id, fullName, age, coefficientSalary, dateStart, department, numberOfDayOff);
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Hàm hiển thị thông tin nhân viên.
	 */
	public void displayInformation() {
		System.out.printf("%-10s%-20s%-10s%-25s%-15s%-15s%-10s%-15s%s\n", getId(), getFullName(), getAge(),
				getCoefficientSalary(), getDateStart(), getDepartment(), getNumberOfDayOff(), "-", getPosition());
	}

	/**
	 * Hàm tính lương.
	 */
	public long calculateSalary() {
		long responsibilitySalary = 0;
		if (getPosition().equalsIgnoreCase("Business Leader")) {
			responsibilitySalary = 8000000;
		} else if (getPosition().equalsIgnoreCase("Project Leader")) {
			responsibilitySalary = 5000000;
		} else if (getPosition().equalsIgnoreCase("Technical Leader")) {
			responsibilitySalary = 6000000;
		}
		return (long) (getCoefficientSalary() * 5000000 + responsibilitySalary);

	}
}
