public class Main {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        Department engineering = new Department("Engineering");
        Department sales = new Department("Sales");
        Department rd = new Department("R&D");

        company.addUnit(engineering);
        company.addUnit(sales);

        engineering.addUnit(rd);

        Employee ceo = new Employee("Armas CEO", 150000);
        Employee salesManager = new Employee("Ross Sales", 8500);
        Employee salesRep1 = new Employee("Rachel Sales", 6500);
        Employee engineeringManager = new Employee("Monica Engineering", 12000);
        Employee developer1 = new Employee("Joey Dev", 9000);
        Employee researcher1 = new Employee("Phoebe Research", 9500);
        Employee researcher2 = new Employee("Chandler Research", 9500);

        company.addUnit(ceo);
        sales.addUnit(salesManager);
        sales.addUnit(salesRep1);
        engineering.addUnit(engineeringManager);
        engineering.addUnit(developer1);
        rd.addUnit(researcher2);
        rd.addUnit(researcher1);

        System.out.println("=== SALARY INFORMATION ===");
        company.printSalary();

        System.out.println("\n=== ORGANIZATIONAL STRUCTURE (XML) ===");
        company.printXML(0);
        System.out.println("\n=== AFTER REMOVING A DEPARTMENT ===");
        company.removeUnit(sales);
        company.printXML(0);
    }
}
