package doip.simulation.http.lib;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerInfo {
    public List<Platform> platforms;
    
    public List<Platform> getPlatforms() {
    	return platforms;
    }
    
    public void setPlatforms(List<Platform> platforms) {
    	this.platforms = platforms;
    }
}
