import java.time.LocalDate;
public class Expense {
    private int id;
    private String title;
    private String category;
    private double amount;
    private LocalDate date;

    public Expense(int id, String title, String category, double amount, LocalDate date) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Title: " + title +
                ", Category: " + category +
                ", Amount: ₹" + amount +
                ", Date: " + date;
    }
}
