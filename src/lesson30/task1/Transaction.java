package lesson30.task1;

import java.util.Date;

public class Transaction implements Comparable<Transaction> {
    private long id;
    private Date dateCreated;
    private Date dateConfirmed;

    private TransactionType type;

    private int amound;

    private String description;

    public Transaction(long id, Date dateCreated, Date dateConfirmed, TransactionType type, int amound, String description) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateConfirmed = dateConfirmed;
        this.type = type;
        this.amound = amound;
        this.description = description;
    }

    @Override
    public int compareTo(Transaction tr) {
        return tr.dateCreated.compareTo(this.dateCreated);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", dateConfirmed=" + dateConfirmed +
                ", type=" + type +
                ", amound=" + amound +
                ", description='" + description + '\'' +
                '}';
    }
}
