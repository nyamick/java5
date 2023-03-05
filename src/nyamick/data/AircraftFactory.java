package nyamick.data;

public class AircraftFactory extends Organization {

    public AircraftFactory(String name) {super(name); }

    private String craftAirPlane() {

        return getObjetName();
    }


    @Override
    public String processOperation() {
        return ("Авиастроительная компания под названием " + getName() + " построила самолет с ID: " + craftAirPlane());
    }
}
