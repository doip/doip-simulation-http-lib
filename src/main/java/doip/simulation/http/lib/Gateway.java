package doip.simulation.http.lib;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Gateway {
	public String name;
	public String url;
	public String status;
	public String error;
	public List<Ecu> ecus;

}
