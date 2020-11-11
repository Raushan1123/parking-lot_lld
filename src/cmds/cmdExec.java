package cmds;

import Outprint.outPrint;
import model.command;
import service.parkingLotService;

public abstract class cmdExec {
    protected parkingLotService parkingLotServ;
    protected outPrint outPri;

    public cmdExec(final parkingLotService parkingLotServ,final outPrint outPri)
    {
        this.parkingLotServ=parkingLotServ;
        this.outPri=outPri;
    }
    public abstract boolean validate(command cmd);
    public abstract void execute(command cmd);
}
