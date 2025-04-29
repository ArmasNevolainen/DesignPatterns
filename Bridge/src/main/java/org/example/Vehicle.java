package org.example;

abstract class Vehicle {
    protected Workshop workShop1;
    protected Workshop workShop2;
    protected Workshop workShop3;

    protected Vehicle(Workshop workShop1, Workshop workShop2)
    {
        this.workShop1 = workShop1;
        this.workShop2 = workShop2;
        this.workShop3 = null;
    }

    protected Vehicle(Workshop workShop1, Workshop workShop2, Workshop workShop3)
    {
        this.workShop1 = workShop1;
        this.workShop2 = workShop2;
        this.workShop3 = workShop3;
    }

    abstract public void manufacture();
}
