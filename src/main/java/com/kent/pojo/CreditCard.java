package com.kent.pojo;

import java.time.LocalDate;

public class CreditCard {
    private int id;
    private String card_name;
    private LocalDate actBillDate;
    private boolean fix_date;
    private LocalDate actDueDate;

    public CreditCard(int id, String card_name, int bill_date, boolean fix_date, int due_date) {
        this.id = id;
        this.card_name = card_name;
        this.fix_date = fix_date;
        setActBillDate(bill_date);
        setActDueDate(due_date);
    }

    public void setActDueDate(int due_date) {
        if (isFix_date()) {
            if (due_date < getActBillDate().getDayOfMonth())
                actDueDate = getActBillDate().withDayOfMonth(due_date).plusMonths(1);
            else
                actBillDate = getActBillDate().withDayOfMonth(due_date);
        }else
            actDueDate = getActBillDate().plusDays(due_date);
    }

    public LocalDate getActDueDate() {
        return actDueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public LocalDate getActBillDate() {
        return actBillDate;
    }

    public void setActBillDate(int bill_date) {
        actBillDate = LocalDate.now().withDayOfMonth(bill_date);
    }

    public boolean isFix_date() {
        return fix_date;
    }

    public void setFix_date(boolean fix_date) {
        this.fix_date = fix_date;
    }
}
