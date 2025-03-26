public class Employee extends Unit{
    private String name;
    private double salary;

    public Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    public void printSalary() {
        System.out.println("Employee " + name + " salary is : €" + salary);
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addUnit(Unit unit) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public void removeUnit(Unit unit) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public Unit getUnit(int index) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public void printXML(int indent) {
        printIndent(indent);
        System.out.println("<employee name=\"" + name + "\"  salary=\"" + salary + "\" />");
    }
}
