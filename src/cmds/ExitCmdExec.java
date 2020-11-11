package cmds;

import Outprint.outPrint;
import model.command;
import service.parkingLotService;

public class ExitCmdExec extends cmdExec{
    public static String CMD="exit";
    parkingLotService park=new parkingLotService();
    outPrint out = new outPrint();
    public ExitCmdExec(final parkingLotService parkinglotservice, final outPrint out){
        super(parkinglotservice,out);
    }

    @Override
    public boolean validate(final command cmd){
        return cmd.getParameters().isEmpty();
    }
    @Override
    public void execute(final command cmd){
        out.end();
    }
}
