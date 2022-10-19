package sorting;

import com.beust.jcommander.Parameter;

public class CommandLineArgs {

    @Parameter(names = {"-dataType", "--d"}, description = "datatype to be sorted", arity = 1)
    private String type;


    public String getType() {
        return type;
    }


}
