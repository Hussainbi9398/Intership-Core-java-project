package com.jsp.Week1Assignment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Employee {
    private String id;
    private String name;
    private String department;
    private String designation;
    private String address;

    public Employee(String id, String name, String department,String designation,String address) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation=designation;
        this.address=address;
    }

    public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Department: " + department+",Designation:"+designation+",Address:"+address;
    }
}

class HRMS {
    private Map<String, Employee> employees = new HashMap<>();
    private Map<String, String> attendance = new HashMap<>();
    private Map<String, String> leaveRequests = new HashMap<>();

    public void addEmployee(String id, String name, String department,String designation,String address) {
        Employee employee = new Employee(id, name, department,designation,address);
        employees.put(id, employee);
        System.out.println("Employee added successfully.");
    }

    public void viewEmployee(String id) {
        Employee employee = employees.get(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void updateEmployee(String id, String name, String department,String designation,String address) {
        Employee employee = employees.get(id);
        if (employee != null) {
            employee = new Employee(id, name, department,designation,address);
            employees.put(id, employee);
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void deleteEmployee(String id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void markAttendance(String id, String status, String date) {
        attendance.put(id + "-" + date, status);
        System.out.println("Attendance marked successfully.");
    }

    public void viewAttendance(String id, String date) {
        String status = attendance.get(id + "-" + date);
        if (status != null) {
            System.out.println("Attendance for " + date + ": " + status);
        } else {
            System.out.println("No attendance record found for " + date);
        }
    }

    public void addLeaveRequest(String id, String startDate, String endDate) {
        String request = id + "-" + startDate + "-" + endDate;
        leaveRequests.put(request, "pending");
        System.out.println("Leave request added successfully.");
    }

    public void approveLeaveRequest(String requestId) {
        if (leaveRequests.containsKey(requestId)) {
            leaveRequests.put(requestId, "approved");
            System.out.println("Leave request approved.");
        } else {
            System.out.println("Leave request not found.");
        }
    }

    public void rejectLeaveRequest(String requestId) {
        if (leaveRequests.containsKey(requestId)) {
            leaveRequests.put(requestId, "rejected");
            System.out.println("Leave request rejected.");
        } else {
            System.out.println("Leave request not found.");
        }
    }

    public void searchEmployee(String query) {
        List<Employee> results = new ArrayList<>();
        for (Employee employee : employees.values()) {
            if (employee.getName().contains(query) || employee.getId().contains(query) || employee.getDepartment().contains(query) || employee.getDesignation().contains(query)|| employee.getAddress().contains(query)) {
                results.add(employee);
            }
        }
        if (!results.isEmpty()) {
            System.out.println("Search results for '" + query + "':");
            for (Employee employee : results) {
                System.out.println(employee);
            }
        } else {
            System.out.println("No matching employees found.");
        }
    }
}

public class Test {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HRMS hrms = new HRMS();

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Mark Attendance");
            System.out.println("6. View Attendance");
            System.out.println("7. Add Leave Request");
            System.out.println("8. Approve Leave Request");
            System.out.println("9. Reject Leave Request");
            System.out.println("10. Search Employee");
            System.out.println("11. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Employee Designation: ");
                    String designation= scanner.nextLine();
                    System.out.print("Enter Employee Address: ");
                    String address= scanner.nextLine();
                    hrms.addEmployee(id, name, department,designation,address);
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    id = scanner.nextLine();
                    hrms.viewEmployee(id);
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter New Employee Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter New Employee Department: ");
                    department = scanner.nextLine();
                    System.out.print("Enter Employee Designation: ");
                     designation= scanner.nextLine();
                    System.out.print("Enter Employee Address: ");
                     address= scanner.nextLine();
                    
                    hrms.updateEmployee(id, name, department,designation,address);
                    break;
                case 4:
                    System.out.print("Enter Employee ID: ");
                    id = scanner.nextLine();
                    hrms.deleteEmployee(id);
                    break;
                case 5:
                    System.out.print("Enter Employee ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter Attendance Status (present/absent/on leave): ");
                    String status = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    hrms.markAttendance(id, status, date);
                    break;
                case 6:
                    System.out.print("Enter Employee ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    date = scanner.nextLine();
                    hrms.viewAttendance(id, date);
                    break;
                case 7:
                    System.out.print("Enter Employee ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter End Date (YYYY-MM-DD): ");
                    String endDate = scanner.nextLine();
                    hrms.addLeaveRequest(id, startDate, endDate);
                    break;
                case 8:
                    System.out.print("Enter Leave Request ID: ");
                    String requestId = scanner.nextLine();
                    hrms.approveLeaveRequest(requestId);
                    break;
                case 9:
                    System.out.print("Enter Leave Request ID: ");
                    requestId = scanner.nextLine();
                    hrms.rejectLeaveRequest(requestId);
                    break;
                case 10:
                    System.out.print("Enter Search Query: ");
                    String query = scanner.nextLine();
                    hrms.searchEmployee(query);
                    break;
                case 11:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
