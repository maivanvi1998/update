
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HumanResources {
	private static List<Staff> staffs = new ArrayList<>();
	private static List<Department> departments = new ArrayList<>();

	public static void main(String[] args) {
		init();
		char arr[] = {'a','b','c'};
		String str = new String(arr);
		System.out.println(str);
		Scanner sc = new Scanner(System.in);
		int select = 0;
		do {
			System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty.");
			System.out.println("2. Hiển thị các bộ phận trong công ty.");
			System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
			System.out.println("4. Thêm nhân viên mới vào công ty: bao gồm 2 loại.");
			System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
			System.out.println("6. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
			System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
			System.out.println("8. Thoát chương trình.");
			select = inputInteger();
			switch (select) {
			case 1:
				displayStaff();
				break;
			case 2:
				displayDepartment();
				break;
			case 3:
				displayStaffByDepartment();
				break;
			case 4:
				addStaff();
				break;
			case 5:
				findStaff();
				break;
			case 6:
				sortSalaryaDecrease();
				;
				break;
			case 7:
				sortSalaryAscending();
				;
			}

		} while (select != 8);
	}

	/**
	 * Hàm hiển thị thông tin các bộ phận công ty.
	 */
	private static void displayDepartment() {
		System.out.printf("%-20s%-20s%s\n", "ID_Deparment", "Name_Department", "Number_Employee");
		for (Department department : departments) {
			department.displayInformation();
		}
	}

	/**
	 * Hàm khai báo và add các đối tượng vào List.
	 */
	private static void init() {
		Staff employee = new Employee("nv111", "Mai van vi", 24, 1.5, "1/12/2021", "IT", 3, 1.5);
		Staff manager = new Manager("nv123", "Mai van dai", 25, 2, "1/2/2021", "Sale", 4, "project leader");
		Department it = new Department("IT", "IT", 1);
		Department kd = new Department("KD", "Sale", 1);
		Department ns = new Department("NS", "HR", 0);
		departments.add(it);
		departments.add(kd);
		departments.add(ns);
		staffs.add(employee);
		staffs.add(manager);

	}

	/**
	 * Hàm hiển thị thông tin nhân viên toàn công ty.
	 */
	private static void displayStaff() {
		System.out.printf("%-10s%-20s%-10s%-25s%-15s%-15s%-10s%-15s%s\n", "ID", "NAME", "AGE", "Coefficient_Salary",
				"Date_Start", "Department", "DayOff", "Over_Time", "Position");
		for (Staff staff : staffs) {
			staff.displayInformation();
		}
	}

	/**
	 * Hàm hiển thị nhân viên theo từng bộ phận.
	 */
	private static void displayStaffByDepartment() {
		for (Department department : departments) {
			System.out.println("Phòng " + department.getName() + ":");
			System.out.printf("%-10s%-20s%-10s%-25s%-15s%-15s%-10s%-15s%s\n", "ID", "NAME", "AGE", "Coefficient_Salary",
					"Date_Start", "Department", "DayOff", "Over_Time", "Position");
			for (Staff staff : staffs) {
				if (staff.getDepartment().equalsIgnoreCase(department.getName())) {
					staff.displayInformation();
				}
			}
		}
	}

	/**
	 * Hàm thêm nhân viên.
	 */
	private static void addStaff() {
		Scanner sc = new Scanner(System.in);
		int select;
		do {
			System.out.println("Add staff (1 = Employee or 2 = Manager).");
			select = inputInteger();

		} while (!(select == 1 || select == 2));
		System.out.print("Id: ");
		String id = sc.nextLine();
		System.out.print("Full name: ");
		String name = sc.nextLine();
		System.out.print("Age: ");
		int age = inputInteger();
		System.out.println("Coefficient Salary: ");
		double coefficientSalary = inputDouble();
		System.out.println("Day start: ");
		String dayStart = sc.nextLine();
		System.out.println("Department: ");
		String department = inputDepartment();
		System.out.println("Number of day off: ");
		int numberOfDayOff = inputInteger();

		// Thêm nhân viên thường.
		if (select == 1) {
			System.out.println("Over time: ");
			double overTime = inputDouble();
			Staff employee = new Employee(id, name, age, coefficientSalary, dayStart, department, numberOfDayOff,
					overTime);
			staffs.add(employee);
			updateNumberOfStaff(employee.getDepartment());

			// Thêm nhân viên cấp quản lý.
		} else if (select == 2) {
			System.out.println("Position: ");
			String position = inputPosition();
			Staff manager = new Manager(id, name, age, coefficientSalary, dayStart, department, numberOfDayOff,
					position);
			staffs.add(manager);
			updateNumberOfStaff(manager.getDepartment());
		}
	}

	/**
	 * Hàm kiểm tra nhập liệu của người dùng.
	 * 
	 * @return 1 trong 3 bộ phận của công ty.
	 */
	private static String inputDepartment() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		while (!(input.equalsIgnoreCase("IT") || input.equalsIgnoreCase("Sale") || input.equalsIgnoreCase("HR"))) {
			System.out.println("Vui lòng chọn 1 trong 3 bộ phận sau: IT, Sale, HR");
			input = sc.nextLine();
		}
		return input;

	}

	/**
	 * Hàm kiểm tra nhập liệu người dùng.
	 * 
	 * @return 1 trong 3 chức danh quản lý.
	 */
	private static String inputPosition() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		while (!(input.equalsIgnoreCase("Business Leader") || input.equalsIgnoreCase("Project Leader")
				|| input.equalsIgnoreCase("Technical Leader"))) {
			System.out.println(
					"Vui lòng chọn 1 trong 3 chức danh sau: Business Leader, Project Leader, Technical Leader");
			input = sc.nextLine();
		}
		return input;
	}

	/**
	 * Hàm kiểm tra nhập liệu người dùng số nguyên.
	 */
	private static int inputInteger() {
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextInt()) {
			System.out.println("Vui lòng nhập số");
			sc.nextLine();
		}
		return sc.nextInt();
	}

	/**
	 * Hàm kiểm tra nhập liệu người dùng số thực.
	 */
	private static double inputDouble() {
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextDouble()) {
			System.out.println("Vui lòng nhập số");
			sc.nextLine();
		}
		return sc.nextDouble();
	}

	/**
	 * Hàm tìm nhân viên theo tên hoặc id.
	 */
	private static void findStaff() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên hoặc id nhân viên: ");
		String keyWord = sc.nextLine().toLowerCase();
		boolean isFound = false;
		System.out.printf("%-10s%-20s%-10s%-25s%-15s%-15s%-10s%-15s%s\n", "ID", "NAME", "AGE", "Coefficient_Salary",
				"Date_Start", "Department", "DayOff", "Over_Time", "Position");
		for (Staff staff : staffs) {
			if (staff.getFullName().toLowerCase().contains(keyWord) || staff.getId().equalsIgnoreCase(keyWord)) {
				staff.displayInformation();
				isFound = true;
			}
		}
		if (!isFound) {
			System.out.printf("%-10s%-20s%-10s%-25s%-15s%-15s%-10s%-15s%s\n", "-", "-", "-", "-", "-", "-", "-", "-",
					"-");
			System.out.println("Không tìm thấy nhân viên nào!!!");
		}

	}

	/**
	 * Hàm hiển thị lương nhân viên theo thứ tự tăng dần.
	 */
	private static void sortSalaryAscending() {
		List<Staff> list = new ArrayList<Staff>(staffs);
		list.sort(new StaffOrder());
		System.out.printf("%-10s%-20s%s\n", "ID", "FULL_NAME", "SALARY");
		for (Staff staff : list) {
			System.out.printf("%-10s%-20s%s\n", staff.getId(), staff.getFullName(), staff.calculateSalary());
		}
	}

	/**
	 * Hàm hiển thị lương nhân viên theo thứ tự giảm dần.
	 */
	private static void sortSalaryaDecrease() {
		List<Staff> list = new ArrayList<Staff>(staffs);
		list.sort(new StaffOrder());
		Collections.reverse(list);
		System.out.printf("%-10s%-20s%s\n", "ID", "FULL_NAME", "SALARY");
		for (Staff staff : list) {
			System.out.printf("%-10s%-20s%s\n", staff.getId(), staff.getFullName(), staff.calculateSalary());
		}
	}

	/**
	 * Hàm thêm số lượng nhân viên theo từng bộ phận.
	 * 
	 * @param nameDepartment
	 */
	private static void updateNumberOfStaff(String nameDepartment) {
		for (Department department : departments) {
			if (department.getName().equalsIgnoreCase(nameDepartment)) {
				department.setNumberOfEmployees(department.getNumberOfEmployees() + 1);
				System.out.println("Thêm thành công!!!");
			}
		}
	}
}
