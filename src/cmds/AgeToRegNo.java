package cmds;

import Outprint.outPrint;
import model.Slot;
import model.command;
import service.parkingLotService;

import java.util.List;
import java.util.stream.Collectors;

public class AgeToRegNo extends cmdExec {
    public static String CMD="Vehicle_registration_number_for_driver_of_age";
    outPrint out=new outPrint();
    public AgeToRegNo(final parkingLotService parkinglotservice, final outPrint out)
    {
        super(parkinglotservice,out);
    }
    @Override
    public boolean validate(final command cmd)
    {
        return cmd.getParameters().size()==1;
    }
    @Override
    public void execute(final command cmd){
        parkingLotService parkinglotservice = new parkingLotService();
        final List<Slot> slotsForAge = parkinglotservice.getSlotForAge(cmd.getParameters().get(0));
        if(slotsForAge.isEmpty())
        {
            out.notFound();
        }
        else{
            final String result  = slotsForAge.stream().map(slot->slot.getParkCar().getRgdNo())
                    .collect(Collectors.joining(", "));
            out.printWithNewLine(result);
        }
    }
}
