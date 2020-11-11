package cmds;

import Outprint.outPrint;
import model.Slot;
import model.command;
import service.parkingLotService;

import java.util.List;
import java.util.Optional;

public class SlotForRegNoExec extends cmdExec{
    public static String CMD="Slot_number_for_car_with_number";
    parkingLotService park = new parkingLotService();
    outPrint out = new outPrint();
    public SlotForRegNoExec(final parkingLotService park, outPrint out)
    {
        super(park,out);
    }
    @Override
    public boolean validate(final command cmd){
        return cmd.getParameters().size()==1;
    }

    @Override
    public void execute(final command cmd){
        final List<Slot> occupiedSlots = park.getOccupiedSlots();
        final String regNumToFind = cmd.getParameters().get(0);
        final Optional<Slot> foundSlot = occupiedSlots.stream()
                .filter(slot->slot.getParkCar().getRgdNo().equals(regNumToFind)).findFirst();
        if(foundSlot.isPresent())
            out.printWithNewLine(foundSlot.get().getSlotNum().toString());
        else
            out.notFound();
    }
}
