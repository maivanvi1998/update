
public class Employee extends Staff implements ICalculator {
	private double overTime;

	public Employee() {

	}

	public Employee(String id, String fullName, int age, double coefficientSalary, String dateStart, String department,
			int numberOfDayOff, double overTime) {
		super(id, fullName, age, coefficientSalary, dateStart, department, numberOfDayOff);
		this.overTime = overTime;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}

	public double getOverTime() {
		return overTime;
	}

	/**
	 * Hàm hiển thị thông tin nhân viên.
	 */
	public void displayInformation() {
		System.out.printf("%-10s%-20s%-10s%-25s%-15s%-15s%-10s%-15s%s\n", getId(), getFullName(), getAge(),
				getCoefficientSalary(), getDateStart(), getDepartment(), getNumberOfDayOff(), getOverTime(), "-");

	}

	/**
	 * Hàm tính lương.
	 */
	public long calculateSalary() {
		return (long) (getCoefficientSalary() * 3000000 + getOverTime() * 200000);
	}

}
