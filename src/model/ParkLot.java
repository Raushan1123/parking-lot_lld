package model;

import exceptions.InvalidSlot;
import exceptions.parkLot;
import exceptions.slotOccupied;

import java.util.Map;
import java.util.HashMap;

public class ParkLot {
    private static final int MX=100000;
    private final int capacity;
    private final Map<Integer,Slot> slots;

    public int getCapacity(){
        return capacity;
    }

    public ParkLot( int capacity){
        if(capacity>MX || capacity<=0)
        {
            throw new parkLot("Invalid Capacity");
        }
        this.capacity=capacity;
        this.slots=new HashMap<>();
    }
    public Map<Integer,Slot> getSlots(){
        return slots;
    }
    public Slot getSlot(final Integer slotNum){
        if(slotNum>getCapacity() || slotNum<=0){
            throw new InvalidSlot();
        }
        final Map<Integer,Slot> alSlots = getSlots();
        if(!alSlots.containsKey(slotNum)){
            alSlots.put(slotNum,new Slot(slotNum));
        }
        return alSlots.get(slotNum);
    }
    public Slot park(final Car car,final Integer slotNum)
    {
        final Slot slot=getSlot(slotNum);
        if(!slot.isSlotFree()) {
            throw new slotOccupied();
        }
        slot.assignCar(car);
        return slot;
    }
    public Slot makeFreeSlot(final Integer slotNum){
        final Slot slot=getSlot(slotNum);
        slot.nonassignableCar();
        return slot;
    }
}
