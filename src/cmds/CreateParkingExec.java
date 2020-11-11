package cmds;

import Outprint.outPrint;
import model.ParkLot;
import model.command;
import model.parkFund;
import service.parkingLotService;
import valid.IntValid;

import java.util.List;

public class CreateParkingExec extends cmdExec{
    public static String CMD="Create_parking_lot";
    parkingLotService parkinglotservice = new parkingLotService();
    outPrint out = new outPrint();
    public CreateParkingExec(final parkingLotService parkinglotservice, final outPrint out){
        super(parkinglotservice,out);
    }
    @Override
    public boolean validate(final command cmd){
        final List<String> params = cmd.getParameters();
        if(params.size()!=1)
            return false;
        return IntValid.isInteger(params.get(0));
    }

    @Override
    public void execute(final command cmd){
        final int parkingLotCapacity = Integer.parseInt(cmd.getParameters().get(0));
        final ParkLot parkLot = new ParkLot(parkingLotCapacity);
        parkinglotservice.createLot(parkLot,new parkFund());
        out.printWithNewLine("Created parking of "+parkLot.getCapacity()+" slots");
    }
}
