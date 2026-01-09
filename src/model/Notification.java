package model;

import java.util.Date;

public class Notification {

    private Date date;
    private String message;
    private boolean estLue;

    public Notification(Date date, String message) {
        this.date = date;
        this.message = message;
        this.estLue = false;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public boolean EstLue() {
        return estLue;
    }

    public void setEstLue(boolean estLue) {
        this.estLue = estLue;
    }
}
