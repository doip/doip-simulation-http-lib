package doip.simulation.http.lib;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Modifier {
    public String regex;
    public String result;
}



