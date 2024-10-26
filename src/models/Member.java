package models;

public class Member {
    public int getPhone;
    private long id;
    private String name;
    private int phone;
    private String address;

    public Member(long id, String name, int phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    // Getters và Setters
    public long getid() { return id; }
    public void setid(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPhone() { return phone; }
    public void setPhone(int phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public static String toStringHeader() {
        return String.format(
                "ID\tName\tPhone\tAddress"
        );
    }

    @Override
    public String toString() {
        return "Member ID: " + id + ", Name: " + name + ", Phone: " + phone +
                ", Address: " + address;
    }
}
