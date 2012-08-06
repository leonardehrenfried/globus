package info.lenni;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class PostalCodeValidator {

    public static Map<String, Pattern> postalCodes = new HashMap<>();

    public static boolean isValid(String postalCode, String country){
        country = country.toUpperCase();
        if (!postalCodes.containsKey(country)){
            throw new RuntimeException(String.format("No postal code information for country iso code %s available.", country));
        }
        return postalCodes.get(country).matcher(postalCode).matches();
    }

    static {
        try {
            InputStream in = PostalCodeValidator.class.getResourceAsStream("postalCodeData.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = null;
            //ignore the dtd
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            builder = factory.newDocumentBuilder();
            NodeList regexen = builder.parse(in).getElementsByTagName("postCodeRegex");
            for(int i=0; i < regexen.getLength(); i++){
                Node node = regexen.item(i);
                // org.w3c.dom has to be the most awkward API ever
                postalCodes.put(node.getAttributes().getNamedItem("territoryId").getTextContent(),
                        Pattern.compile(node.getTextContent()));
            }
        } catch (ParserConfigurationException | SAXException | IOException ignored) {
            throw new RuntimeException(ignored);
        }
    }
}
