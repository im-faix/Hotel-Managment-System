package personal_project;

public interface Room {
    String getRoomType();
    double getRate();
}
class DeluxeRoom implements Room {
    @Override
    public String getRoomType() { return "Deluxe"; }
    @Override
    public double getRate() { return 7000; }
}

class BusinessRoom implements Room {
    @Override
    public String getRoomType() { return "Business"; }
    @Override
    public double getRate() { return 5000; }
}

class GeneralRoom implements Room {
    @Override
    public String getRoomType() { return "General"; }
    @Override
    public double getRate() { return 3500; }
}