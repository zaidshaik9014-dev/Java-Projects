import java.util.ArrayList;

public class CalculatorHistory {
    
    private ArrayList<String> history;

    public CalculatorHistory() {
        history = new ArrayList<>();
    }

    public void addHistory(String operation) {
        history.add(operation);
    }

    public void viewHistory() {

        if (history.isEmpty()) {
            System.out.println("\nNo History Available.");
            return;
        }

        System.out.println("\n========== CALCULATOR HISTORY ==========");

        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }

        System.out.println("========================================");
    }

    public void clearHistory() {
        history.clear();

        System.out.println("History Cleared Successfully");
    }

    public ArrayList<String> getHistory() {
        return history;
    }
}
