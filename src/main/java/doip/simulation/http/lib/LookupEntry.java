package doip.simulation.http.lib;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LookupEntry {
    public String regex;
    public String result;
    public List<Modifier> modifiers;
}
