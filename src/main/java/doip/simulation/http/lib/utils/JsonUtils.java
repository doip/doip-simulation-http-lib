package doip.simulation.http.lib.utils;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import com.networknt.schema.SpecVersionDetector;

/**
 * Got code from here:
 * https://www.baeldung.com/jackson-object-mapper-tutorial
 * https://www.baeldung.com/introduction-to-json-schema-in-java
 * 
 * @return 
 */
public class JsonUtils {
	
	private static Logger logger = LogManager.getLogger(JsonUtils.class);

	/**
	 * Performs a JSON schema validation
	 * @param jsonString The JSON as String
	 * @param schema The JSON schema as String
	 * @return If schema validation was successful it returns an empty set.
	 *         You can call function Set.isEmpty() to check if the set is empty.
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public static Set<ValidationMessage> checkSchema(String jsonString, String schema) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();  
		JsonNode jsonNode = objectMapper.readTree(jsonString);
		JsonNode schemaNode = objectMapper.readTree(schema);
		
		JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersionDetector.detect(schemaNode));
		JsonSchema jsonSchema = schemaFactory.getSchema(schema);
		
		Set<ValidationMessage> results = jsonSchema.validate(jsonNode);
		return results;
	}
	
	/**
	 * Converts a JSON string into an Java Object
	 * @param <T> Returns an object of the type which had been given in argument clazz.
	 * @param jsonString The JSON string which shall be converted to a Java object
	 * @param clazz The class of the Java object to which the string will be converted to
	 * @return
	 * @throws JsonProcessingException Will be thrown if there was a error in the JSON string
	 */
	public static <T> T deserialize(String jsonString, Class<T> clazz) throws JsonProcessingException {
		try {
			return new ObjectMapper().readValue(jsonString, clazz);
		} catch (JsonMappingException e) {
			throw logger.throwing(e);
		} catch (JsonProcessingException e) {
			throw logger.throwing(e);
		}
	}
	
	public static String serialize(Object obj) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(obj);
	}
}
