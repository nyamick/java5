package nyamick;

import nyamick.data.AircraftFactory;
import nyamick.data.InsuranceCompany;
import nyamick.data.Organization;
import nyamick.data.ShipbuildingCompany;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
    private final Organization data;
    public MyTableModel(Organization organization){ this.data = organization; }
    @Override
    public int getRowCount() { return this.data.getCount(); }

    @Override
    public int getColumnCount() { return 2; }
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Organization name";
            case 1:
                return "Organization type";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return this.data.getOrganization(rowIndex).getName();
            case 1:
                Organization org = this.data.getOrganization(rowIndex);
                if ( org instanceof InsuranceCompany){ return  "Insurance Company";}
                else {
                    if (org instanceof ShipbuildingCompany) { return "Shipbuilding Company";}
                    return "Aircraft Factory";
                }
            default: return "default";
            }
        }

      public void delete (int ind) {
        State.deleteSelectedCompany(ind);
        this.fireTableDataChanged();
      }

      public void add(String name, String ind){
          switch (ind) {
              case "Shipbuilding Company" -> State.organizations.add(new ShipbuildingCompany(name));
              case "Insurance Company" -> State.organizations.add(new InsuranceCompany(name));
              case "Aircraft Factory" -> State.organizations.add(new AircraftFactory(name));
              default -> State.organizations.add(new AircraftFactory("default"));
          }
          this.fireTableDataChanged();
      }
      public String find(String name) {
          return State.findAct(name);
      }

      public String doActivity(int ind) {return State.doSelectedActivity(ind);

    }

    }


