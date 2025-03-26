import java.util.ArrayList;
import java.util.List;

public class Company extends Unit{

    private String name;
    private List<Unit> units = new ArrayList<>();

    public Company (String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    @Override
    public void removeUnit(Unit unit) {
        this.units.remove(unit);
    }

    @Override
    public Unit getUnit(int index) {
        return this.units.get(index);
    }

    @Override
    public void printSalary() {
        System.out.println("Salary for " + name + ": € " + getSalary());
        for (Unit unit : this.units) {
            unit.printSalary();
        }
    }

    @Override
    public double getSalary() {
        double totalSalary=0;
        for (Unit unit : units) {
            totalSalary += unit.getSalary();
        }
        return totalSalary;
    }

    @Override
    public void printXML(int indent) {
        printIndent(indent);
        System.out.println("<company name=\"" + name + "\">");

        for (Unit unit : units) {
            unit.printXML(indent + 2);
        }

        printIndent(indent);
        System.out.println("</company>");
    }
}
