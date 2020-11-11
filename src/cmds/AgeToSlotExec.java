package cmds;

import Outprint.outPrint;
import model.Slot;
import model.command;
import service.parkingLotService;

import java.util.List;
import java.util.stream.Collectors;

public class AgeToSlotExec extends cmdExec{
    public static String CMD="Slot_numbers_for_driver_of_age";
    parkingLotService parkinglotservice = new parkingLotService();
    outPrint out=new outPrint();
    public AgeToSlotExec(final parkingLotService parklotservice, final outPrint out){
        super(parklotservice,out);
    }
    @Override
    public boolean validate(final command cmd){
        return cmd.getParameters().size()==1;
    }

    @Override
    public void execute(final command cmd){
        final List<Slot> slotForAge = parkinglotservice.getSlotForAge(cmd.getParameters().get(0));
        if(slotForAge.isEmpty()){
            out.notFound();
        }
        else
        {
            final String result = slotForAge.stream()
                    .map(slot -> slot.getSlotNum().toString())
                    .collect(Collectors.joining(","));
            out.printWithNewLine(result);
        }
    }
}
