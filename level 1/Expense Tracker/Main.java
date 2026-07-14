import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) { 
            System.out.println("\n========== Expense Tracker ==========");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Search Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Total Spending");
            System.out.println("7. Category Report");
            System.out.println("8. Exit");

            System.out.println("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:

                    int id = manager.generateId();

                    System.out.print("Enter Title : ");
                    String title = sc.nextLine();

                    if (title.trim().isEmpty()) {
                        System.out.println("Title cannot be empty. ");
                        break;
                    }

                    if (title.length() < 2) {
                        System.out.println("Title must contain atleast 2 char");
                        break;
                    }

                    System.out.print("Enter Category : ");
                    String category = sc.nextLine();

                    if (category.trim().isEmpty()) {
                        System.out.println("Category cannot be empty.");
                       break;
                    }

                    if (category.length() < 2) {
                        System.out.println("Category must contain at least 2 characters.");
                        break;
                    }

                    System.out.print("Enter Amount : ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    if (amount <= 0) {
                        System.out.println("Amount must be greater than 0.");
                        break;
                    }

                    LocalDate date = LocalDate.now();

                    Expense expense = new Expense(id, title, category, amount, date);

                    manager.addExpense(expense);

                    FileManager.saveExpenses(manager.getExpenses());

                    break;

                case 2:
                    manager.viewExpense();
                    break;
                
                case 3:

                    System.out.print("Enter Expense ID : ");
                    int searchId = sc.nextInt();

                    Expense found = manager.searchExpense(searchId);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Expense Not Found.");
                    }

                    break;


                case 4:

                    System.out.print("Enter Expense ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Expense existingExpense = manager.searchExpense(updateId);

                    if (existingExpense == null) {
                        System.out.println("Expense Not Found.");
                    break;
                    }

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter New Category: ");
                    String newCategory = sc.nextLine();

                    System.out.print("Enter New Amount: ");
                    double newAmount = sc.nextDouble();
                    sc.nextLine();

                    if (manager.updateExpense(updateId, newTitle, newCategory, newAmount)) {
                        System.out.println("Expense Updated Successfully!");
                        FileManager.saveExpenses(manager.getExpenses());
                    } else {
                        System.out.println("Expense Not Found.");
                    }

                    break;

                case 5:

                    System.out.print("Enter Expense ID : ");
                    int deleteId = sc.nextInt();

                    if (manager.deleteExpense(deleteId)) {
                        System.out.println("Expense Deleted Successfully.");
                        FileManager.saveExpenses(manager.getExpenses());
                    } else {
                        System.out.println("Expense Not Found.");
                    }

                    break;

                case 6:

                    System.out.println("Total Spending : ₹" + manager.getTotalExpense());

                    break;

                case 7:

                    System.out.print("Enter Category : ");
                    String cat = sc.nextLine();

                    manager.categoryReport(cat);

                    break;

                case 8:

                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}