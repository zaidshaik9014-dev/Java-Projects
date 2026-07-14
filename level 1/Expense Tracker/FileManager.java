import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class FileManager {
    private static final String FILE_NAME = "expenses.txt";

    public static void saveExpenses(ArrayList<Expense> expenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense expense : expenses) {
                writer.write (
                    expense.getId() + "," +
                    expense.getTitle() + "," +
                    expense.getCategory() + "," +
                    expense.getAmount() + "," +
                    expense.getDate()
                );

                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses.");
        }
    }

    public static ArrayList<Expense> loadExpenses() {
        ArrayList<Expense> expenses = new ArrayList<>();
         try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String category = data[2];
                double amount = Double.parseDouble(data[3]);
                LocalDate date = LocalDate.parse(data[4]);

                Expense expense = new Expense(
                        id,
                        title,
                        category,
                        amount,
                        date
                );

                expenses.add(expense);
            }
        } catch (IOException e) {

        }

        return expenses; 
    }
}
