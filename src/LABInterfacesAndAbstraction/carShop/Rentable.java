package LABInterfacesAndAbstraction.carShop;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}
