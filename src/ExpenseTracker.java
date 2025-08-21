import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

public class ExpenseTracker {
    private ArrayList<Expense> expenses = null;

    ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }
    void addExpense(Expense ex) {
        this.expenses.add(ex);
    }

    void updateExpense(int id, String desc, int amount) {
        if (id < 0 && id >= this.expenses.toArray().length) {
            System.out.println("Not correct id");
        }

        Optional<Expense> op = this.getExpense(id);

        if (op.isEmpty()) {
            System.out.printf("Id: %d not found\n", id);
            return;
        }
        Expense ex = op.get();
        ex.setAmount(amount);
        ex.setDescription(desc);
        System.out.printf("Record %d updated\n", ex.getId());
    }

    Optional<Expense> getExpense(int id) {
        Expense ex = null;
        for (Expense exLoop: this.expenses) {
            if (exLoop.getId() == id) {
                ex = exLoop;
                break;
            }
        }
        return Optional.ofNullable(ex);
    }

    public void getExpenseList() {
        System.out.println("ID\tDate\tDescription\tAmount");
        for (Expense exLoop: this.expenses) {
            System.out.println(exLoop);
        }
    }

    public static void main(String[] args) {
        ExpenseTracker et = new ExpenseTracker();

        et.addExpense(new Expense("Descr", 15));
        et.addExpense(new Expense("Sad descr", 35));
        et.getExpenseList();
    }
}


