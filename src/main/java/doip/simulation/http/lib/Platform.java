package doip.simulation.http.lib;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Platform {
    private String name;
    private String url;
    private String status;
    private List<Gateway> gateways;
			
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Gateway> getGateways() {
		return gateways;
	}
	public void setGateways(List<Gateway> gateways) {
		this.gateways = gateways;
	}
}
