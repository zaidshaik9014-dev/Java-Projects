import java.util.ArrayList;
public class ExpenseManager {

    private ArrayList<Expense> expenses;
    private int nextId;
    
    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public ExpenseManager() {
        expenses = FileManager.loadExpenses();
        nextId = 1;

        for (Expense expense : expenses) {
            if (expense.getId() >= nextId) {
                nextId = expense.getId() + 1;
            }
        }
    }

    public int generateId() {
        return nextId++;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Expense Added Successfully!");
    }

    public void viewExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No Expenses Found.");
            return;
        }
        for (Expense expense : expenses) {
            System.out.println(expense);
            System.out.println("------------------------");
        }
    }

    public boolean updateExpense(int id, String title, String category, double amount) {
        Expense expense = searchExpense(id);

        if (expense != null) {
            expense.setTitle(title);
            expense.setCategory(category);
            expense.setAmount(amount);

            return true;
        }

        return false;
    }

    public Expense searchExpense(int id) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                return expense;
            }
        }

        return null;
    }

    public boolean deleteExpense(int id) {
        Expense expense = searchExpense(id);
        if (expense != null) {
            expenses.remove(expense);
            return true;
        }

        return false;
    }

    public double getTotalExpense() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    public void categoryReport(String category) {
    double total = 0;
    for (Expense expense : expenses) {
        if (expense.getCategory().equalsIgnoreCase(category)) {
            total += expense.getAmount();
        }
    }
    System.out.println(category + " : ₹" + total);
    }
    
}
