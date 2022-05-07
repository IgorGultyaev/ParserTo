import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    @org.junit.jupiter.api.Test
    public void testParserCsvToJson_success() {

        // given:
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "John", "Smith", "USA", 25));
        list.add(new Employee(2, "Inav", "Petrov", "RU", 23));

        String expected = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\"," +
                "\"country\":\"USA\",\"age\":25},{\"id\":2,\"firstName\":\"Inav\"," +
                "\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";
        // when:

        String result = ParserCsvToJson.listToJson(list);

        // then:
        Assertions.assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    public void testParserJsonToClass_success() throws ParseException {


        String json = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\"," +
                "\"country\":\"USA\",\"age\":25},{\"id\":2,\"firstName\":\"Inav\"," +
                "\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";

        List<Employee> expected = new ArrayList<>();
        expected.add(new Employee(1, "John", "Smith", "USA", 25));
        expected.add(new Employee(2, "Inav", "Petrov", "RU", 23));

        // when:

        List<Employee> result = ParserJsonToClass.jsonToList(json);

        // then:
        Assertions.assertEquals(expected, result);

    }

    @org.junit.jupiter.api.Test
    public void testParserXMLTOJSON_success() throws ParserConfigurationException, IOException, SAXException {


        String fileName = "data.xml";

        List<Employee> expected = new ArrayList<>();
        expected.add(new Employee(1, "John", "Smith", "USA", 25));
        expected.add(new Employee(2, "Inav", "Petrov", "RU", 23));

        // when:

        List<Employee> result = ParserXMLToJson.parseXML(fileName);

        // then:
        Assertions.assertEquals(expected, result);

    }
}
