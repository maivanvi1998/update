import java.util.Comparator;

public class StaffOrder implements Comparator<Staff> {

	/**
	 * Hàm sắp sếp lương theo thứ tự tăng dần.
	 */
	@Override
	public int compare(Staff o1, Staff o2) {
		long salary1 = 0;
		long salary2 = 0;
		if (o1 instanceof Employee) {
			salary1 = o1.calculateSalary();
		} else if (o1 instanceof Manager) {
			salary1 = o1.calculateSalary();
		}
		if (o2 instanceof Employee) {
			salary2 = o2.calculateSalary();
		} else if (o2 instanceof Manager) {
			salary2 = o2.calculateSalary();
		}
		if (salary1 < salary2) {
			return -1;
		} else if (salary1 > salary2) {
			return 1;
		}
		return 0;
	}

}
