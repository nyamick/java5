package nyamick.data;

public class ShipbuildingCompany extends Organization {

    public ShipbuildingCompany(String name) {super(name); }

    public String getShip() {
        return getObjetName();
    }

    @Override
    public String processOperation() {
        return (" Судостроительная компнания под названием " + getName() + " построила корабль: " + getShip());
    }
}
