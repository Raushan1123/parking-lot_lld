package model;

public class Slot {
    private Car parkCar;
    final Integer slotNum;

    public Slot(final Integer slotNum){
        this.slotNum=slotNum;
    }
    public Integer getSlotNum(){
        return slotNum;
    }
    public Car getParkCar(){
        return parkCar;
    }
    public boolean isSlotFree(){
       return parkCar==null;
    }
    public void assignCar(Car car){
        this.parkCar=car;
    }
    public void nonassignableCar()
    {
        this.parkCar=null;
    }
}
