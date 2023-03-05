package nyamick;

import nyamick.data.Organization;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.random.RandomGenerator;

public class State {
    public static final ArrayList<Organization> organizations = new ArrayList<>();

    public Organization getOrganization(int index) {
        return organizations.get(index);
    }

    public static void deleteSelectedCompany(int ind) {
        organizations.remove(ind);
    }
    public static String doSelectedActivity(int ind) {
        Organization org = organizations.get(ind);
        String name = org.getName();
        for (Organization company: organizations) {
            if (company.getName() == null ? name == null : company.getName().equals(name)) {
                return company.processOperation();
            }
        }
        return null;
    }
    public static void doAllActivities(){
        if(organizations.isEmpty()){
            System.out.println("бом бом...");
            return;
        }
        System.out.println();
        for (Organization organization: organizations) { organization.processOperation();}
        System.out.println();
    }

    public static void getOrganizationsList(){
        System.out.println();
        for(int i = 0; i < organizations.size(); i++) { System.out.println((i + 1) + " - " + organizations.get(i).getName()); }
        System.out.println();
    }


}


