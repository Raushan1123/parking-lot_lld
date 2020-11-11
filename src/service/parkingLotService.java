package service;

import exceptions.parkLot;
import model.Car;
import model.ParkLot;
import model.Slot;
import model.parkFundamental;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class parkingLotService {
    private ParkLot parkLot;
    private parkFundamental parkFundament;

    public Integer park(final Car car){
    validateParking();
     final Integer nextFree = parkFundament.getNextSlot();
     parkLot.park(car,nextFree);
     parkFundament.removingSlot(nextFree);
     return nextFree;
    }
    public void createLot(final ParkLot parkLot,final parkFundamental parkFundament){
        if(this.parkLot!=null){
            throw new parkLot("Parking Lot already Exists");
        }
        this.parkLot=parkLot;
        this.parkFundament=parkFundament;
        for(int i=1;i<=parkLot.getCapacity();i++){
            parkFundament.addingSlot(i);
        }
    }

    public void makeSlotFree(final Integer slotNum){
        validateParking();
        parkLot.makeFreeSlot(slotNum);
        parkFundament.addingSlot(slotNum);
    }

    public List<Slot> getOccupiedSlots(){
        validateParking();
        final List<Slot> occupiedList = new ArrayList<>();
        final Map<Integer,Slot> allSlots=parkLot.getSlots();

        for(int i=1;i<=parkLot.getCapacity();i++)
        {
            if(allSlots.containsKey(i)){
                final Slot slot = allSlots.get(i);
                if(!slot.isSlotFree())
                {
                    occupiedList.add(slot);
                }
            }
        }
        return occupiedList;
    }
    private void validateParking(){
        if(parkLot==null)
        {
            throw new parkLot("Parking Lot does not exist to park");
        }
    }
    public List<Slot> getSlotForAge(final String age){
        final List<Slot> occupiedSlots = getOccupiedSlots();
        return occupiedSlots.stream()
                .filter(slot->slot.getParkCar().getAge().equals(age))
                .collect(Collectors.toList());
    }
}
