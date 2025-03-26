public abstract class Unit {

    public abstract String getName();
    public abstract void addUnit (Unit unit);
    public abstract void removeUnit(Unit unit);
    public abstract Unit getUnit(int index);
    public abstract void printSalary();
    public abstract double getSalary();
    public abstract void printXML(int indent);
    protected void printIndent(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
    }
}
