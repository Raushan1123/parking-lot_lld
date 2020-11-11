package mode;

import Outprint.outPrint;
import cmds.cmdExec;
import cmds.cmdExecFact;
import exceptions.InvalidCom;
import model.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileMode {
    private final String fileName;
    private final cmdExecFact cmdexecfact;
    protected outPrint out;
    public FileMode(
    final cmdExecFact cmdexecfact,
    final outPrint out,final String fileName){
        this.cmdexecfact=cmdexecfact;
        this.out=out;
        this.fileName=fileName;
    }
    protected void processCommand(final command command) {
        final cmdExec commandExecutor = cmdexecfact.getCmdExec(command);
        if (commandExecutor.validate(command)) {
            commandExecutor.execute(command);
        } else {
            throw new InvalidCom();
        }
    }

    public void process() throws IOException{
        final File file = new File(fileName);
        final BufferedReader reader= new BufferedReader(new FileReader(file));
//        try{
//            reader=new BufferedReader(new FileReader(file));
//        }
//        catch(FileNotFoundException e){
//        System.out.println("Invalid File");
//        }
        String input = reader.readLine();
        while (input!=null){
            final command cmd = new command(input);
            processCommand(cmd);
            input = reader.readLine();
        }
    }
}
