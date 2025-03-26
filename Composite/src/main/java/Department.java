import java.util.ArrayList;
import java.util.List;

public class Department extends Unit{
    private List<Unit> units = new ArrayList<>();
    private String name;

    public Department(String name){
        this.name=name;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addUnit(Unit unit) {
        units.add(unit);
    }

    @Override
    public void removeUnit(Unit unit) {
        units.remove(unit);
    }

    @Override
    public Unit getUnit(int index) {
        return units.get(index);
    }

    @Override
    public void printSalary() {
        System.out.println("Total salary for department " + name + " € : " + getSalary());
    }

    @Override
    public double getSalary() {
        double totalSalary = 0;
        for (Unit unit : units) {
            totalSalary += unit.getSalary();
        }
        return totalSalary;
    }

    @Override
    public void printXML(int indent) {
        printIndent(indent);
        System.out.println("<department name=\"" + name + "\">");

        for (Unit unit : units) {
            unit.printXML(indent + 2);
        }

        printIndent(indent);
        System.out.println("</department>");
    }
}
