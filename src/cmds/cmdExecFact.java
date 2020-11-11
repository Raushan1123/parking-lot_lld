package cmds;

import Outprint.outPrint;
import exceptions.InvalidCom;
import model.command;
import service.parkingLotService;

import java.util.HashMap;
import java.util.Map;

public class cmdExecFact {
    private Map<String,cmdExec> commands = new HashMap<>();
    public cmdExecFact(final parkingLotService parkLotServ){
        final outPrint out = new outPrint();
        commands.put(CreateParkingExec.CMD,
                new CreateParkingExec(parkLotServ,out));

        commands.put(ParkCmdExec.CMD,
                new ParkCmdExec(parkLotServ,out));

        commands.put(LeaveCmdExec.CMD,
                new LeaveCmdExec(parkLotServ,out));

        commands.put(AgeToSlotExec.CMD,
                new AgeToSlotExec(parkLotServ,out));

        commands.put(AgeToRegNo.CMD,
                new AgeToRegNo(parkLotServ,out));

        commands.put(SlotForRegNoExec.CMD,
                new SlotForRegNoExec(parkLotServ,out));

        commands.put(ExitCmdExec.CMD,
                new ExitCmdExec(parkLotServ,out));
    }
    public cmdExec getCmdExec(final command cmd){
        final cmdExec cmdExe= commands.get(cmd.getCmdName());
        if(cmdExe==null){
            throw new InvalidCom();
        }
        return cmdExe;
    }
}
