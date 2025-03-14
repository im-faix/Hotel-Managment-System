package personal_project;

// import java.io.Serializable;

class InformationOfCustomer {
    private String name;
    private long phone;
    private String validId;
    private Room room;
    private int numDays;
    private double payment;

    // Constructor
    public InformationOfCustomer(String name, long phone, String validId, Room room, int numDays) {
        this.name = name;
        this.phone = phone;
        this.validId = validId;
        this.room = room;
        this.numDays = numDays;
        this.payment = room.getRate() * numDays;
    }

    // Getter methods (Encapsulation)
    public String getName() { return name; }
    public long getPhone() { return phone; }
    public String getValidId() { return validId; }
    public String getRoomType() { return room.getRoomType(); }
    public int getNumDays() { return numDays; }
    public double getPayment() { return payment; }
    
    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phone + " | ID: " + validId + " | Room: " + room.getRoomType() + " | Days: " + numDays + " | Payment: " + payment;
    }
}