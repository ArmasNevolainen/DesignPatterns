package org.example;

class SportsCar extends Vehicle {
    public SportsCar(Workshop workShop1, Workshop workShop2, Workshop workShop3)
    {
        super(workShop1, workShop2, workShop3);
    }

    @Override
    public void manufacture()
    {
        System.out.print("SportsCar ");
        workShop1.work();
        workShop2.work();
        if (workShop3 != null) {
            workShop3.work();
        }
    }
}
