package model;

import exceptions.InvalidCom;
//import exceptions.InvalidSlot;
//
//import javax.smartcardio.CommandAPDU;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class command {
//    private static final String SPC=" ";
    private final List<String> parameters;
    private final String cmdName;

    public List<String> getParameters(){
        return parameters;
    }
    public String getCmdName(){
        return cmdName;
    }

    public command(final String str)
    {
        final List<String> tokens=Arrays.stream(str.trim().split(" ")).map(String::trim)
                .filter(token->(token.length()>0)).collect(Collectors.toList());

        if(tokens.size()==0)
        {
            throw new InvalidCom();
        }
        cmdName = tokens.get(0).toLowerCase();
        tokens.remove(0);
        parameters=tokens;
    }
}
