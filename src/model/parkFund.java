package model;

import exceptions.noFreeSlot;

import java.util.TreeSet;

public class parkFund implements parkFundamental {
    TreeSet<Integer> slotSet;

    public parkFund(){
        this.slotSet = new TreeSet<>();
    }

    @Override
    public void addingSlot(Integer slotNum) {
        this.slotSet.add(slotNum);
    }

    @Override
    public void removingSlot(Integer slotNum) {
        this.slotSet.remove(slotNum);
    }


    @Override
    public Integer getNextSlot() {
        if(!slotSet.isEmpty())
        {
            return this.slotSet.first();
        }
        throw new noFreeSlot();
    }
}
