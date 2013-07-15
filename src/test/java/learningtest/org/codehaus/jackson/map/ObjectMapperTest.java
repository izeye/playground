package learningtest.org.codehaus.jackson.map;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.izeye.playground.support.ua.domain.device.DeviceType;

public class ObjectMapperTest {

	@Test
	public void writeValueAsString() throws JsonGenerationException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(DeviceType.MACINTOSH);
		System.out.println(json);
	}

}
