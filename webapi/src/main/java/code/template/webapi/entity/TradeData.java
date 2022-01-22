package code.template.webapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tradedata")
public class TradeData {
    
    private int id;
    private String date;
    private String account;
    private String side;
    private int amount;

    public TradeData(){}

    public TradeData(String date, String account, String side, int amount) {
        this.date = date;
        this.account = account;
        this.side = side;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id", nullable = false)
        public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "date", nullable = false)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "account", nullable = false)
    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "side", nullable = false)
    public String getSide() {
        return this.side;
    }

    public String setSide(String side) {
        return this.side = side;
    }

    @Column(name = "amount", nullable = true)
    public int getAmount() {
        return this.amount;
    }

    public int setAmount(int amount) {
        return this.amount = amount;
    }

    @Override
    public String toString() {
        return "TradeData [date=" + date + ", account=" + account + ", side=" + side + ", amount=" + amount + "]";
    }

}
