package models;

import java.util.Date;

public class Loan {
    private long id;
    private Date loanDate;
    private Date returnDate;
    private long bookID;
    private long memberID;

    public Loan(long id, Date loanDate, Date returnDate, long bookID, long memberID) {
        this.id = id;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.bookID = bookID;
        this.memberID = memberID;
    }

    // Getters và Setters
    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public long getBookID() {
        return bookID;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }

    public long getMemberID() {
        return memberID;
    }

    public void setMemberID(long memberID) {
        this.memberID = memberID;
    }

    @Override
    public String toString() {
        return "Loan ID: " + id + ", Loan Date: " + loanDate +
                ", Return Date: " + returnDate + ", Book ID: " + bookID +
                ", Member ID: " + memberID;
    }
}
