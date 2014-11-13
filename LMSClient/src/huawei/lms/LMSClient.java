/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.xml.soap.*;

/**
 *
 * @author Nizar.Abubaker
 */
public class LMSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SOAPException, IOException {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        String url = "http://10.123.105.243/eai_anon_enu/start.swe?SWEExtSource=SecureWebService&SWEExtCmd=Execute";
        SOAPMessage soapResponse = soapConnection.call(createLMSRequest(args[0],args[1]), url);
      //  System.out.print("Response SOAP Message:");
        soapResponse.writeTo(System.out);

        soapConnection.close();
    }

    private static SOAPMessage createLMSRequest(String subno, String prepost_paid) throws SOAPException, IOException{
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        
        String serverURI = "http://10.123.105.243";
        
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("ns", serverURI);
        envelope.addNamespaceDeclaration("wsse", "http://schemas.xmlsoap.org/ws/2002/07/secext");
        envelope.addNamespaceDeclaration("wsu", "http://schemas.xmlsoap.org/ws/2002/07/utility");

        SOAPHeader header = envelope.getHeader();
        SOAPElement sec = header.addChildElement("Security", "wsse");
        SOAPElement token = sec.addChildElement("UsernameToken", "wsse");
        token.addChildElement("Username","wsse").addTextNode("SMUSTAQUIM");
        token.addChildElement("Password","wsse").addTextNode("valencia2002$");
        SOAPBody soapBody = envelope.getBody();
        SOAPElement spcBalans = soapBody.addChildElement("Query_spcLOY_spcBalans", "ns");
        spcBalans.addChildElement("Account_spcName").addTextNode(subno);
        spcBalans.addChildElement("Type").addTextNode(prepost_paid);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", "\"rpc/"+serverURI + ":Query_spcLOY_spcBalans\"");

        soapMessage.saveChanges();

        /* Print the request message */
//        System.out.print("Request SOAP Message:");
  //      soapMessage.writeTo(System.out);
    //    System.out.println();

        return soapMessage;
    }
}
