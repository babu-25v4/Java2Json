import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json2Java {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		CustomerInfoAppium cust = mapper.readValue("D:\\AutomationWorkspace\\Java2Json\\JsonFiles\\CustomerInfoAppium.json", CustomerInfoAppium.class);
		
		System.out.println("Course Name: "+cust.getCourseName());
	}

}
