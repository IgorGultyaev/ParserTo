import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParserXMLToJson {

    public static final String fileName = "data.xml";

    private static List<Employee> read(Node node) {
        List<Employee> employees = new LinkedList<>();
        NodeList nodeList = node.getChildNodes();
        for (int nodeRun = 0; nodeRun < nodeList.getLength(); nodeRun++) {
            long id = 0;
            String firstName = "";
            String lastName = "";
            String country = "";
            int age = 0;

            Node node_ = nodeList.item(nodeRun);
            if (Node.ELEMENT_NODE == node_.getNodeType()) {
                System.out.println("Узел: " + node_.getNodeName() +
                        " Значение: " + node_.getChildNodes().item(0).getTextContent());

                if (node_.getNodeName().equals("id")) {
                    id = Long.parseLong(node_.getChildNodes().item(0).getTextContent());
                }
                if (node_.getNodeName().equals("firstName")) {
                    firstName = node_.getChildNodes().item(0).getTextContent();
                }
                if (node_.getNodeName().equals("lastName")) {
                    lastName = node_.getChildNodes().item(0).getTextContent();
                }
                if (node_.getNodeName().equals("country")) {
                    country = node_.getChildNodes().item(0).getTextContent();
                }
                if (node_.getNodeName().equals("age")) {
                    age = Integer.parseInt(node_.getChildNodes().item(0).getTextContent());
                    employees.add(new Employee(id, firstName, lastName, country, age));
                    System.out.println(employees);
                }
                read(node_);
            }
        }

        return employees;
    }

    private static List<Employee> parseXML(String fileName) throws ParserConfigurationException, IOException, SAXException {

        ArrayList<Employee> employees = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));

        Node root = doc.getDocumentElement();
        System.out.println("Корневой элемент: " + root.getNodeName());

        NodeList employeeElements = doc.getDocumentElement().getElementsByTagName("employee");
        System.out.println(employeeElements.getLength());
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node employee = employeeElements.item(i);

            System.out.println(employee.getChildNodes().item(3).getTextContent());


            employees.add(new Employee(Long.parseLong(employee.getChildNodes().item(1).getTextContent()),
                    employee.getChildNodes().item(3).getTextContent(),
                    employee.getChildNodes().item(5).getTextContent(),
                    employee.getChildNodes().item(7).getTextContent(),
                    Integer.parseInt(employee.getChildNodes().item(9).getTextContent())));

        }


        System.out.println(employees);


//        for (int nodeRun = 0; nodeRun < doc.; nodeRun++) {
//            long id = 0;
//
//            Node node_ = nodeList.item(nodeRun);
//            if (Node.ELEMENT_NODE == node_.getNodeType()) {
//                System. out.println("Узел: " + node_.getNodeName() +
//                        " Значение: " + node_.getChildNodes().item(0).getTextContent());
//
//
//                read(node_);
//            }
//        }


//        read(root);

        return null;
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        parseXML(fileName);

    }

}
