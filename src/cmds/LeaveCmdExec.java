package cmds;

import Outprint.outPrint;
import model.Slot;
import model.command;
import service.parkingLotService;
import valid.IntValid;

import java.util.List;

public class LeaveCmdExec extends cmdExec{
    public static String CMD="leave";
    parkingLotService park = new parkingLotService();
    outPrint out = new outPrint();
    public LeaveCmdExec(final parkingLotService park, final outPrint out){
        super(park,out);
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
        final int slotNum = Integer.parseInt(cmd.getParameters().get(0));
        park.makeSlotFree(slotNum);
        out.printWithNewLine("Slot number "+slotNum+" vacated");
    }
}
