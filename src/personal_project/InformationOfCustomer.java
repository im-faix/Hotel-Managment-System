package personal_project;

// import java.io.Serializable;

class InformationOfCustomer {
    private String name;
    private long phone;
    private String validId;
    private String roomType;
    private int numDays;
    private double payment;

    public InformationOfCustomer(String name, long phone, String validId, String roomType, int numDays, double payment) {
        this.name = name;
        this.phone = phone;
        this.validId = validId;
        this.roomType = roomType;
        this.numDays = numDays;
        this.payment = payment;
    }

    public String getName() { return name; }
    public long getPhone() { return phone; }
    public String getValidId() { return validId; }
    public String getRoomType() { return roomType; }
    public int getNumDays() { return numDays; }
    public double getPayment() { return payment; }
    
    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phone + " | ID: " + validId + " | Room: " + roomType + " | Days: " + numDays + " | Payment: " + payment;
    }
}