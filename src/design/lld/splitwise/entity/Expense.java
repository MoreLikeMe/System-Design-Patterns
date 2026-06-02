package design.lld.splitwise.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Expense {
    private final String expenseId;
    private double amount;
    private User paidBy;
    private SplitType splitType;
    private List<Split> splits;
    private LocalDateTime timestamp;

    public Expense(double amount, User paidBy, SplitType splitType, List<Split> splits) {
        this.expenseId = UUID.randomUUID().toString();
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.splits = splits;
        this.timestamp = LocalDateTime.now();
    }

    public String getExpenseId() {
        return expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
