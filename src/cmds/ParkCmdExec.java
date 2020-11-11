package cmds;

import Outprint.outPrint;
import exceptions.noFreeSlot;
import model.Car;
import model.command;
import service.parkingLotService;

public class ParkCmdExec extends cmdExec{
    public static String CMD="Park";
    parkingLotService park=new parkingLotService();
    outPrint out = new outPrint();
    public ParkCmdExec(final parkingLotService park, outPrint out)
    {
        super(park,out);
    }
    @Override
    public boolean validate(final command cmd)
    {
        return cmd.getParameters().size()==3;
    }
    @Override
    public void execute(final command cmd){
        final Car car=new Car(cmd.getParameters().get(0),cmd.getParameters().get(2));
        try{
            final Integer slot = park.park(car);
            out.printWithNewLine("Car with vehicle registration number "+cmd.getParameters().get(0)
            +"  has been parked at slot number "+slot);
        }
        catch (noFreeSlot exception){
            {
                out.parkingFull();
            }
        }
    }
}
