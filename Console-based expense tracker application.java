import java.time.LocalDate;
import java.util.*;

class Expense {
    private static int nextId = 1;

    private int id;
    private LocalDate date;
    private double amount;
    private String category;
    private String description;

    public Expense(LocalDate date, double amount, String category, String description) {
        this.id = nextId++;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%d\t%s\t%.2f\t%s\t%s", id, date, amount, category, description);
    }
}

class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class ExpenseTracker {
    private Map<Integer, Expense> expenses;
    private Map<String, Category> categories;

    public ExpenseTracker() {
        this.expenses = new HashMap<>();
        this.categories = new HashMap<>();
    }

    public void addExpense(LocalDate date, double amount, String category, String description) {
        Expense expense = new Expense(date, amount, category, description);
        expenses.put(expense.getId(), expense);
        System.out.println("Expense recorded successfully.");
    }

    public void addCategory(String name) {
        if (!categories.containsKey(name)) {
            categories.put(name, new Category(name));
            System.out.println("Category added successfully.");
        } else {
            System.out.println("Category already exists.");
        }
    }

    public void viewExpenses() {
        System.out.println("ID\tDate\t\tAmount\tCategory\tDescription");
        System.out.println("-----------------------------------------------------");
        expenses.values().forEach(System.out::println);
    }

    public void viewCategories() {
        System.out.println("Categories:");
        categories.values().forEach(category -> System.out.println(category.getName()));
    }

    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Add Category");
            System.out.println("3. View Expenses");
            System.out.println("4. View Categories");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    expenseTracker.addExpense(date, amount, category, description);
                    break;
                case 2:
                    System.out.print("Enter category name: ");
                    String categoryName = scanner.nextLine();
                    expenseTracker.addCategory(categoryName);
                    break;
                case 3:
                    expenseTracker.viewExpenses();
                    break;
                case 4:
                    expenseTracker.viewCategories();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
