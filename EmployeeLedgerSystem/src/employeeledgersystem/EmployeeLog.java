package employeeledgersystem;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class EmployeeLog {

    public void logArrival(int employeeId, String name) {
        String checkQuery = "SELECT COUNT(*) FROM employee2 WHERE employee_id = ?";

        String insertQuery = "INSERT INTO employees1 (employee_id, arrival_time) VALUES (?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             // Check if the employee_id exists
             PreparedStatement checkPs = conn.prepareStatement(checkQuery)) {

            checkPs.setInt(1, employeeId);
            try (ResultSet rs = checkPs.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    try (PreparedStatement insertPs = conn.prepareStatement(insertQuery)) {
                        insertPs.setInt(1, employeeId);
                        insertPs.setTimestamp(2, new Timestamp(new Date().getTime()));

                        insertPs.executeUpdate();
                        System.out.println("Check-In successful!");
                    }
                } else {
                    System.out.println("Employee ID not found in employee1 table.");
                }
            }

        } catch (SQLException e) {
            System.out.println("There was an error while checking the employee ID or logging arrival.");
        }
    }


    public void applyForLeave(int employeeId, LeaveType leaveType) {
        String leaveQuery = "INSERT INTO employees1 (employee_id, arrival_time, status) VALUES (?, ?, 'ON_LEAVE')";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(leaveQuery)) {

            ps.setInt(1, employeeId);
            ps.setTimestamp(2, new Timestamp(new Date().getTime()));

            ps.executeUpdate();
            System.out.println("Leave applied successfully for employee ID: " + employeeId + " with leave type: " + leaveType);

        } catch (SQLException e) {
            System.out.println("Error applying leave for employee ID: " + employeeId);
        }
    }

    public void logAll() {
        String selectQuery = "SELECT e.employee_id AS employee_id, e.name, l.arrival_time, l.departure_time, l.status FROM employees1 l JOIN employee2 e ON l.employee_id = e.employee_id";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(selectQuery);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String name = rs.getString("name");
                Timestamp arrivalTime = rs.getTimestamp("arrival_time");
                Timestamp departureTime = rs.getTimestamp("departure_time");
                String status = rs.getString("status");

                if (status == "ON_LEAVE") {
                    System.out.println("Employee ID: " + employeeId + ", Name: " + name + ", Status:" + status);
                } else if (arrivalTime != null && departureTime == null) {
                    System.out.println("Employee ID: " + employeeId + ", Name: " + name + ", Arrival Time: " + arrivalTime + ", Status:" + status);
                } else if (arrivalTime != null && departureTime != null) {
                    LocalDateTime arrival = arrivalTime.toLocalDateTime();
                    LocalDateTime departure = departureTime.toLocalDateTime();
                    Duration duration = Duration.between(arrival, departure);
                    System.out.println("Employee ID: " + employeeId + ", Name: " + name + ", Arrival Time: " + arrivalTime + ", Leaving Time:" + departureTime + ", Status:" + status + ", Total Time Worked:" + duration.toHours() + "h:" + duration.toMinutesPart() + "m:" + duration.toSecondsPart() + "s");
                }
                System.out.println("============================================================");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void logDeparture(int employeeId) {
        String updateQuery = "UPDATE employees1 SET departure_time = ?,status = 'ABSENT' WHERE employee_id = ? AND departure_time IS NULL";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(updateQuery)) {

            ps.setTimestamp(1, new Timestamp(new Date().getTime()));
            ps.setInt(2, employeeId);

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                System.out.println("No records found for the employee ID: " + employeeId + " or the employee has already checked out.");
                return;
            }
            System.out.println("Checked-out Successfully");
        } catch (SQLException e) {
            System.out.println("An error occurred while logging the departure.");
        }
    }
}

