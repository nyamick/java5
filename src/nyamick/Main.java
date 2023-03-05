package nyamick;

import nyamick.data.AircraftFactory;
import nyamick.data.InsuranceCompany;
import nyamick.data.ShipbuildingCompany;
import nyamick.view.MainWindow;

public class Main {

    public static void main(String[] args) {
        State.organizations.add(new InsuranceCompany("aee"));
        State.organizations.add(new ShipbuildingCompany("wow"));
        State.organizations.add(new AircraftFactory("asprl"));
        new MainWindow();
    }
}