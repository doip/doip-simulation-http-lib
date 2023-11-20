package doip.simulation.http.lib;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ecu {
    public String name;
    public String url;
    public List<LookupEntry> configuredLookupTable;
    public List<LookupEntry> runtimeLookupTable;
}

