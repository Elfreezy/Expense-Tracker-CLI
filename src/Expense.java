import java.time.LocalDateTime ;


public class Expense {
    private int id;
    private static int nextId;
    private LocalDateTime createdDate;
    private String description;
    private int amount;

    Expense(String description, int amount) {
        Expense.nextId++;
        this.id = Expense.nextId;
        this.createdDate = LocalDateTime.now();
        this.setAmount(amount);
        this.description = description;
    }

    public void setAmount(int amount) {
        if (amount < 0) {
            throw new NotValidAmount("Amount " + amount + " less 0");
        }
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public String toString() {
        return String.valueOf(this.getId()) + "\t" + String.valueOf(this.getCreatedDate()) + "\t" + String.valueOf(this.getDescription()) + "\t" + String.valueOf(this.getAmount());
    }
}
