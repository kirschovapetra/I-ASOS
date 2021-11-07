package asos;

import java.util.Date;


public class Transfer {
    private int id;
    private Date createdAt;
    private Date deletedAt;
    private BankAccount source;
    private BankAccount target;
    private double amount;
    private Currency currency;

    public Transfer(int id, Date createdAt, BankAccount source, BankAccount target, double amount, Currency currency) {
        this.id = id;
        this.createdAt = createdAt;
        this.source = source;
        this.target = target;
        this.amount = amount;
        this.currency = currency;
    }

    public Transfer(){}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public BankAccount getSource() {
        return source;
    }

    public void setSource(BankAccount source) {
        this.source = source;
    }

    public BankAccount getTarget() {
        return target;
    }

    public void setTarget(BankAccount target) {
        this.target = target;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transfer other = (Transfer) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
