package br.com.mentorama.webfluxtest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private long balance;

    @JsonIgnore
    private List<PointEntry> entryHistory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<PointEntry> getEntryHistory() {
        return entryHistory;
    }

    public void setEntryHistory(List<PointEntry> entryHistory) {
        this.entryHistory = entryHistory;
    }
}
