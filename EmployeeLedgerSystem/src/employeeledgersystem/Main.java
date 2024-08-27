package employeeledgersystem;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeLog emp = new EmployeeLog();
        Scanner scanner = new Scanner(System.in);
        exit:
        while (true) {

            System.out.println("Welcome to the Employee Ledger System");
            System.out.println("Please select an option:");
            System.out.println("1. Check-In");
            System.out.println("2. Check-Out");
            System.out.println("3. View");
            System.out.println("4. Apply Leave");
            System.out.println("5. EXIT");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter your Employee ID:");
                    int checkInId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter your Name:");
                    String name = scanner.nextLine();

                    emp.logArrival(checkInId, name);
                    break;

                case 2:
                    System.out.println("Enter your Employee ID:");
                    int checkOutId = scanner.nextInt();

                    emp.logDeparture(checkOutId);
                    break;

                case 3:
                    emp.logAll();
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    int leaveId = scanner.nextInt();
                    System.out.println("Select Leave Type: 1. Paid Leave 2. Earned Leave 3. Compensatory Leave");
                    int leaveChoice = scanner.nextInt();
                    LeaveType leaveType;
                    switch (leaveChoice) {
                        case 1:
                            leaveType = LeaveType.PAID_LEAVE;
                            break;
                        case 2:
                            leaveType = LeaveType.EARNED_LEAVE;
                            break;
                        case 3:
                            leaveType = LeaveType.COMPENSATORY_LEAVE;
                            break;
                        default:
                            System.out.println("Invalid leave type selected.");
                            continue;
                    }
                    emp.applyForLeave(leaveId, leaveType);
                    break;

                case 5:
                    System.out.println("Thank you,Have a nice day");
                    break exit;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println("----------------------------------------------------------------");
        }
    }
}
