
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nizar.Abubaker
 */
public class EMAHTTPServer {

    static String session_id;
    static String sequence_id;

    public static void main(String[] args) throws Exception {
        /*EMAHTTPServer inst = new EMAHTTPServer();
         inst.getSession();
         ServerSocket serv = new ServerSocket(2312);
         while (true) {
         new Thread(new ReqHandler(serv.accept(), inst)).start();
         }*/
        System.out.println(test());
        System.out.println(padRight("592445955"));
    }

    public static String test() throws ParserConfigurationException, SAXException, IOException {
        String res = "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                + "   <S:Header>\n"
                + "      <SessionId xmlns=\"http://schemas.ericsson.com/cai3g1.2/\">04c0040504c00405000000001411561551603</SessionId>\n"
                + "      <TransactionId xmlns=\"http://schemas.ericsson.com/cai3g1.2/\">BALA</TransactionId>\n"
                + "   </S:Header>\n"
                + "   <S:Body>\n"
                + "      <GetResponse xmlns=\"http://schemas.ericsson.com/cai3g1.2/\">\n"
                + "         <MOAttributes>\n"
                + "            <getResponseSubscription xmlns=\"http://schemas.ericsson.com/ema/UserProvisioning/ZainKSASV/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
                + "               <msisdn>592446278</msisdn>\n"
                + "               <imsi>420040104920399</imsi>\n"
                + "               <hlrSub imsi=\"420040104920399\" msisdn=\"966592446278\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <msisdn>966592446278</msisdn>\n"
                + "                  <sam>ALL</sam>\n"
                + "                  <homecc>N</homecc>\n"
                + "                  <ndc>N</ndc>\n"
                + "                  <rp>6</rp>\n"
                + "                  <act>A</act>\n"
                + "                  <emlppMax>N</emlppMax>\n"
                + "                  <emlppDef>N</emlppDef>\n"
                + "                  <rou>2</rou>\n"
                + "                  <bservcode>T11</bservcode>\n"
                + "                  <nbr>000</nbr>\n"
                + "               </hlrSub>\n"
                + "               <hlrBasicSub imsi=\"420040104920399\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <sam>ALL</sam>\n"
                + "                  <bservcode>T21,000</bservcode>\n"
                + "               </hlrBasicSub>\n"
                + "               <hlrBasicSub imsi=\"420040104920399\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <sam>ALL</sam>\n"
                + "                  <bservcode>T22,000</bservcode>\n"
                + "               </hlrBasicSub>\n"
                + "               <hlrBasicSub imsi=\"420040104920399\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <sam>ALL</sam>\n"
                + "                  <bservcode>B1F,000</bservcode>\n"
                + "               </hlrBasicSub>\n"
                + "               <hlrBasicSub imsi=\"420040104920399\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <sam>ALL</sam>\n"
                + "                  <bservcode>T62,000</bservcode>\n"
                + "               </hlrBasicSub>\n"
                + "               <hlrOdbSub imsi=\"420040104920399\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <odb>\n"
                + "                     <cbo>\n"
                + "                        <baoc>Y</baoc>\n"
                + "                        <boic>N</boic>\n"
                + "                        <boih>N</boih>\n"
                + "                        <boro>N</boro>\n"
                + "                        <boz>N</boz>\n"
                + "                        <bozh>N</bozh>\n"
                + "                        <bozih>N</bozih>\n"
                + "                     </cbo>\n"
                + "                     <cbi>\n"
                + "                        <baic>N</baic>\n"
                + "                        <biro>N</biro>\n"
                + "                        <birn>N</birn>\n"
                + "                        <birz>N</birz>\n"
                + "                     </cbi>\n"
                + "                     <bass>N</bass>\n"
                + "                     <bmsp>\n"
                + "                        <baps>Y</baps>\n"
                + "                        <bpsh>N</bpsh>\n"
                + "                        <bpsv>N</bpsv>\n"
                + "                        <bpsr>N</bpsr>\n"
                + "                     </bmsp>\n"
                + "                     <bapr>\n"
                + "                        <bapre>N</bapre>\n"
                + "                        <bapri>N</bapri>\n"
                + "                     </bapr>\n"
                + "                     <bosCf>\n"
                + "                        <bosCf1>Y</bosCf1>\n"
                + "                        <bosCf2>N</bosCf2>\n"
                + "                        <bosCf3>N</bosCf3>\n"
                + "                        <bosCf4>N</bosCf4>\n"
                + "                     </bosCf>\n"
                + "                  </odb>\n"
                + "               </hlrOdbSub>\n"
                + "               <hlrSsCfCrSub imsi=\"420040104920399\" msisdn=\"966592446278\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <msisdn>966592446278</msisdn>\n"
                + "                  <suppService>\n"
                + "                     <mpty>Y</mpty>\n"
                + "                     <cfb>Y,D</cfb>\n"
                + "                     <cfna>Y,AQ,966591700</cfna>\n"
                + "                     <noReplyTime>30</noReplyTime>\n"
                + "                     <cfnr>Y,AQ,966591700</cfnr>\n"
                + "                     <cfu>Y,D</cfu>\n"
                + "                     <ch>Y</ch>\n"
                + "                     <clip>Y</clip>\n"
                + "                     <colp>N</colp>\n"
                + "                     <colr>N</colr>\n"
                + "                     <cw>Y,A</cw>\n"
                + "                     <fm>N</fm>\n"
                + "                     <cd>N,D</cd>\n"
                + "                     <biro>Y,D</biro>\n"
                + "                     <boic>Y,D</boic>\n"
                + "                     <boro>Y,D</boro>\n"
                + "                     <baic>Y,D</baic>\n"
                + "                     <baoc>Y,D</baoc>\n"
                + "                     <psw>1234</psw>\n"
                + "                  </suppService>\n"
                + "               </hlrSsCfCrSub>\n"
                + "               <hlrGprsPdpSub imsi=\"420040104920399\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <gprs>\n"
                + "                     <grp>56</grp>\n"
                + "                     <nwAcc>NONGPRS</nwAcc>\n"
                + "                     <gprsSam>ALL</gprsSam>\n"
                + "                  </gprs>\n"
                + "                  <pdp>\n"
                + "                     <pdpContextId>1</pdpContextId>\n"
                + "                     <pdpType>IPv4</pdpType>\n"
                + "                     <apn>zain</apn>\n"
                + "                     <pcharg>PREP</pcharg>\n"
                + "                     <qosProfile>3</qosProfile>\n"
                + "                     <vplmn>N</vplmn>\n"
                + "                     <alloc>2</alloc>\n"
                + "                     <fun>A</fun>\n"
                + "                  </pdp>\n"
                + "                  <pdp>\n"
                + "                     <pdpContextId>6</pdpContextId>\n"
                + "                     <pdpType>IPv4</pdpType>\n"
                + "                     <apn>zainmms</apn>\n"
                + "                     <pcharg>PREP</pcharg>\n"
                + "                     <qosProfile>3</qosProfile>\n"
                + "                     <vplmn>N</vplmn>\n"
                + "                     <alloc>2</alloc>\n"
                + "                     <fun>A</fun>\n"
                + "                  </pdp>\n"
                + "                  <pdp>\n"
                + "                     <pdpContextId>7</pdpContextId>\n"
                + "                     <pdpType>IPv4</pdpType>\n"
                + "                     <apn>zainwap</apn>\n"
                + "                     <pcharg>PREP</pcharg>\n"
                + "                     <qosProfile>3</qosProfile>\n"
                + "                     <vplmn>N</vplmn>\n"
                + "                     <alloc>2</alloc>\n"
                + "                    <fun>A</fun>\n"
                + "                  </pdp>\n"
                + "               </hlrGprsPdpSub>\n"
                + "               <hlrCamelDuprSub imsi=\"420040104920399\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <camel>\n"
                + "                     <ussd>41</ussd>\n"
                + "                     <tif>Y</tif>\n"
                + "                     <scpAddr>966591947010</scpAddr>\n"
                + "                     <serviceKey>100</serviceKey>\n"
                + "                     <capHand>2</capHand>\n"
                + "                     <lowac>A</lowac>\n"
                + "                     <lowph>2</lowph>\n"
                + "                     <detectionPoint>OCI</detectionPoint>\n"
                + "                     <act>A</act>\n"
                + "                     <defCh>R</defCh>\n"
                + "                     <fcc>ALL</fcc>\n"
                + "                     <nbrTriCri>N</nbrTriCri>\n"
                + "                     <locInfo>Y</locInfo>\n"
                + "                     <statusInfo>Y</statusInfo>\n"
                + "                     <htc>N</htc>\n"
                + "                  </camel>\n"
                + "               </hlrCamelDuprSub>\n"
                + "               <hlrCamelOcsiSub imsi=\"420040104920399\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <camel>\n"
                + "                     <ussd>41</ussd>\n"
                + "                     <tif>Y</tif>\n"
                + "                     <scpAddr>966591947010</scpAddr>\n"
                + "                     <serviceKey>100</serviceKey>\n"
                + "                     <capHand>2</capHand>\n"
                + "                     <lowac>A</lowac>\n"
                + "                     <lowph>2</lowph>\n"
                + "                     <detectionPoint>OCI</detectionPoint>\n"
                + "                     <act>A</act>\n"
                + "                     <defCh>R</defCh>\n"
                + "                     <fcc>ALL</fcc>\n"
                + "                     <nbrTriCri>N</nbrTriCri>\n"
                + "                     <locInfo>Y</locInfo>\n"
                + "                     <statusInfo>Y</statusInfo>\n"
                + "                     <htc>N</htc>\n"
                + "                  </camel>\n"
                + "               </hlrCamelOcsiSub>\n"
                + "               <hlrCamelTcsiSub imsi=\"420040104920399\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <camel>\n"
                + "                     <ussd>41</ussd>\n"
                + "                     <tif>Y</tif>\n"
                + "                     <scpAddr>966591947012</scpAddr>\n"
                + "                     <serviceKey>200</serviceKey>\n"
                + "                     <capHand>2</capHand>\n"
                + "                     <lowac>C</lowac>\n"
                + "                     <lowph>2</lowph>\n"
                + "                     <detectionPoint>TTTAA</detectionPoint>\n"
                + "                     <act>A</act>\n"
                + "                     <defCh>R</defCh>\n"
                + "                     <locInfo>Y</locInfo>\n"
                + "                     <statusInfo>Y</statusInfo>\n"
                + "                     <htc>HPLMN</htc>\n"
                + "                  </camel>\n"
                + "               </hlrCamelTcsiSub>\n"
                + "               <hlrCamelMosmsSub imsi=\"420040104920399\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <camel>\n"
                + "                     <scpAddr>966591947010</scpAddr>\n"
                + "                     <serviceKey>100</serviceKey>\n"
                + "                     <capHand>3</capHand>\n"
                + "                     <lowac>C</lowac>\n"
                + "                     <lowph>3</lowph>\n"
                + "                     <lowacSgsn>C</lowacSgsn>\n"
                + "                     <lowphSgsn>0</lowphSgsn>\n"
                + "                     <detectionPoint>CI</detectionPoint>\n"
                + "                     <act>A</act>\n"
                + "                     <defSms>R</defSms>\n"
                + "                  </camel>\n"
                + "               </hlrCamelMosmsSub>\n"
                + "               <hlrInCs1Sub imsi=\"420040104920399\">\n"
                + "                  <imsi>420040104920399</imsi>\n"
                + "                  <camel>\n"
                + "                     <scpAddr>N</scpAddr>\n"
                + "                     <serviceKey>0</serviceKey>\n"
                + "                     <detectionPoint>N</detectionPoint>\n"
                + "                     <act>D</act>\n"
                + "                  </camel>\n"
                + "                  <inCs1>\n"
                + "                     <insp>FULL</insp>\n"
                + "                     <sset>N</sset>\n"
                + "                  </inCs1>\n"
                + "               </hlrInCs1Sub>\n"
                + "            </getResponseSubscription>\n"
                + "         </MOAttributes>\n"
                + "      </GetResponse>\n"
                + "   </S:Body>\n"
                + "</S:Envelope>";
        String ret = "";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(res));
        Document doc = builder.parse(is);
        PrintStream out = System.out;
        Element root = doc.getDocumentElement();
        Element hlrSub = (Element) root.getElementsByTagName("hlrSub").item(0);
        out.println(padRight("IMSI: " )+ hlrSub.getElementsByTagName("imsi").item(0).getTextContent());
        out.println(padRight("MSISDN: " )+ hlrSub.getElementsByTagName("msisdn").item(0).getTextContent());
        out.println(padRight("Roaming Profile: " )+ hlrSub.getElementsByTagName("rp").item(0).getTextContent());
        out.println(padRight("Routing Category: " )+ hlrSub.getElementsByTagName("rou").item(0).getTextContent());
        Element hlrCamelOcsiSub = (Element) root.getElementsByTagName("hlrCamelOcsiSub").item(0);
        out.println(padRight("USSD profile: " )+ hlrCamelOcsiSub.getElementsByTagName("ussd").item(0).getTextContent());
        if (hlrCamelOcsiSub.getElementsByTagName("serviceKey").getLength() > 0) {
            out.println(padRight("O_CSI_SKEY: " )+ hlrCamelOcsiSub.getElementsByTagName("serviceKey").item(0).getTextContent());
        }
        out.println(padRight("Camel Parameter O_CSI_SCP: " )+ hlrCamelOcsiSub.getElementsByTagName("scpAddr").item(0).getTextContent());
        Element hlrCamelTcsiSub = (Element) root.getElementsByTagName("hlrCamelTcsiSub").item(0);
        if (hlrCamelTcsiSub.getElementsByTagName("serviceKey").getLength() > 0) {
            out.println(padRight("Termination Call SKEY: " )+ hlrCamelTcsiSub.getElementsByTagName("serviceKey").item(0).getTextContent());
        }
        out.println(padRight("Camel Parameter T_CSI_SCP: " )+ hlrCamelTcsiSub.getElementsByTagName("scpAddr").item(0).getTextContent());
        Element hlrCamelMosmsSub = (Element) root.getElementsByTagName("hlrCamelMosmsSub").item(0);
        if (hlrCamelMosmsSub.getElementsByTagName("serviceKey").getLength() > 0) {
            out.println(padRight("Camel SMS MO Call SKEY: " )+ hlrCamelMosmsSub.getElementsByTagName("serviceKey").item(0).getTextContent());
        }
        out.println(padRight("Camel SMS MO O_CSI_SCP: " )+ hlrCamelMosmsSub.getElementsByTagName("scpAddr").item(0).getTextContent());
        Element hlrOdbSub = (Element) root.getElementsByTagName("hlrOdbSub").item(0);
        Element cbo = (Element) hlrOdbSub.getElementsByTagName("cbo").item(0);
        out.println(padRight("Barring all outgoing calls: " )+ cbo.getElementsByTagName("baoc").item(0).getTextContent());
        out.println(padRight("Barring all outgoing international calls: " )+ cbo.getElementsByTagName("boic").item(0).getTextContent());
        out.println(padRight("Barring all outgoing roaming calls: " )+ cbo.getElementsByTagName("boro").item(0).getTextContent());
        Element cbi = (Element) hlrOdbSub.getElementsByTagName("cbi").item(0);
        out.println(padRight("Barring all incoming call: " )+ cbi.getElementsByTagName("baic").item(0).getTextContent());
        out.println(padRight("Barring all incoming roaming call: " )+ cbi.getElementsByTagName("biro").item(0).getTextContent());
        Element bosCf = (Element) hlrOdbSub.getElementsByTagName("bosCf").item(0);
        out.println(padRight("Barring data sessions: " )+ bosCf.getElementsByTagName("bosCf1").item(0).getTextContent());
        Element hlrGprsPdpSub = (Element) root.getElementsByTagName("hlrGprsPdpSub").item(0);
        out.println(padRight("GPRS roaming profile: " )+ hlrGprsPdpSub.getElementsByTagName("grp").item(0).getTextContent());
        out.println(padRight("Gprs barring paramater: " )+ hlrGprsPdpSub.getElementsByTagName("nwAcc").item(0).getTextContent());
        NodeList pdps = hlrGprsPdpSub.getElementsByTagName("pdp");
        for(int i=0; i<pdps.getLength(); i++){
            out.println(padRight("APN"+(i+1)+": ")+((Element) pdps.item(i)).getElementsByTagName("apn").item(0).getTextContent());
            out.println(padRight("APN"+(i+1)+" Context ID: ")+((Element) pdps.item(i)).getElementsByTagName("pdpContextId").item(0).getTextContent());
            out.println(padRight("APN"+(i+1)+" PDP Type: ")+((Element) pdps.item(i)).getElementsByTagName("pdpType").item(0).getTextContent());
            out.println(padRight("APN"+(i+1)+" QoS Profile: ")+((Element) pdps.item(i)).getElementsByTagName("qosProfile").item(0).getTextContent());
        }
        return ret;
    }

    public void getSession() throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        String url = "http://10.135.3.104:8998/";
        String charset = "UTF-8";
        String sessreq = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cai3=\"http://schemas.ericsson.com/cai3g1.2/\"><soapenv:Header/><soapenv:Body><cai3:Login><cai3:userId>tabscai3g</cai3:userId><cai3:pwd>tabscai3g123</cai3:pwd></cai3:Login></soapenv:Body></soapenv:Envelope>";

        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.setUseCaches(false);
        urlConnection.setDoOutput(true); // Triggers POST.
        urlConnection.setRequestProperty("Accept", "*/*");
        urlConnection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

        OutputStreamWriter writer = null;
        try {
            writer = new OutputStreamWriter(urlConnection.getOutputStream(), charset);
            writer.write(sessreq);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException logOrIgnore) {
                }
            }
        }
        String res = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            res += inputLine;
        }
        in.close();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(res));
        Document doc = builder.parse(is);
        Element root = doc.getDocumentElement();
        Node ss = root.getElementsByTagName("sessionId").item(0);
        Node sq = root.getElementsByTagName("baseSequenceId").item(0);
        System.out.println("Session ID: " + ss.getTextContent());
        session_id = ss.getTextContent();
        System.out.println("Sequence ID: " + sq.getTextContent());
        sequence_id = sq.getTextContent();
    }

    public void queryHLR(String subno, PrintWriter out) throws UnsupportedEncodingException, IOException, ParserConfigurationException, SAXException {
        String url = "http://10.135.3.104:8998/";
        String charset = "UTF-8";
        String query = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cai3=\"http://schemas.ericsson.com/cai3g1.2/\" xmlns:zain=\"http://schemas.ricsson.com/ema/UserProvisioning/ZainKSASV/\"><soapenv:Header><cai3:SequenceId>" + sequence_id + "</cai3:SequenceId><cai3:TransactionId>BALA</cai3:TransactionId><cai3:SessionId>" + session_id + "</cai3:SessionId></soapenv:Header><soapenv:Body><cai3:Get><cai3:MOType>Subscription@http://schemas.ericsson.com/ema/UserProvisioning/ZainKSASV/</cai3:MOType><cai3:MOId><zain:msisdn>966" + subno + "</zain:msisdn></cai3:MOId><cai3:MOAttributes><zain:getSubscription><zain:msisdn>966" + subno + "</zain:msisdn><zain:requestType>QUERY_BASIC_HLR</zain:requestType></zain:getSubscription></cai3:MOAttributes></cai3:Get></soapenv:Body></soapenv:Envelope>";

        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.setUseCaches(false);
        urlConnection.setDoOutput(true); // Triggers POST.
        urlConnection.setRequestProperty("Accept", "*/*");
        urlConnection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

        OutputStreamWriter writer = null;
        try {
            writer = new OutputStreamWriter(urlConnection.getOutputStream(), charset);
            writer.write(query); // Write POST query string (if any needed).
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException logOrIgnore) {
                }
            }
        }
        String res = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            res += inputLine;
        }
        in.close();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(res));
        Document doc = builder.parse(is);
        Element root = doc.getDocumentElement();
        Element hlrSub = (Element) root.getElementsByTagName("hlrSub").item(0);
        out.println(padRight("IMSI: " )+ hlrSub.getElementsByTagName("imsi").item(0).getTextContent());
        out.println(padRight("MSISDN: " )+ hlrSub.getElementsByTagName("msisdn").item(0).getTextContent());
        out.println(padRight("Roaming Profile: " )+ hlrSub.getElementsByTagName("rp").item(0).getTextContent());
        out.println(padRight("Routing Category: " )+ hlrSub.getElementsByTagName("rou").item(0).getTextContent());
        Element hlrCamelOcsiSub = (Element) root.getElementsByTagName("hlrCamelOcsiSub").item(0);
        out.println(padRight("USSD profile: " )+ hlrCamelOcsiSub.getElementsByTagName("ussd").item(0).getTextContent());
        if (hlrCamelOcsiSub.getElementsByTagName("serviceKey").getLength() > 0) {
            out.println(padRight("O_CSI_SKEY: " )+ hlrCamelOcsiSub.getElementsByTagName("serviceKey").item(0).getTextContent());
        }
        out.println(padRight("Camel Parameter O_CSI_SCP: " )+ hlrCamelOcsiSub.getElementsByTagName("scpAddr").item(0).getTextContent());
        Element hlrCamelTcsiSub = (Element) root.getElementsByTagName("hlrCamelTcsiSub").item(0);
        if (hlrCamelTcsiSub.getElementsByTagName("serviceKey").getLength() > 0) {
            out.println(padRight("Termination Call SKEY: " )+ hlrCamelTcsiSub.getElementsByTagName("serviceKey").item(0).getTextContent());
        }
        out.println(padRight("Camel Parameter T_CSI_SCP: " )+ hlrCamelTcsiSub.getElementsByTagName("scpAddr").item(0).getTextContent());
        Element hlrCamelMosmsSub = (Element) root.getElementsByTagName("hlrCamelMosmsSub").item(0);
        if (hlrCamelMosmsSub.getElementsByTagName("serviceKey").getLength() > 0) {
            out.println(padRight("Camel SMS MO Call SKEY: " )+ hlrCamelMosmsSub.getElementsByTagName("serviceKey").item(0).getTextContent());
        }
        out.println(padRight("Camel SMS MO O_CSI_SCP: " )+ hlrCamelMosmsSub.getElementsByTagName("scpAddr").item(0).getTextContent());
        Element hlrOdbSub = (Element) root.getElementsByTagName("hlrOdbSub").item(0);
        Element cbo = (Element) hlrOdbSub.getElementsByTagName("cbo").item(0);
        out.println(padRight("Barring all outgoing calls: " )+ cbo.getElementsByTagName("baoc").item(0).getTextContent());
        out.println(padRight("Barring all outgoing international calls: " )+ cbo.getElementsByTagName("boic").item(0).getTextContent());
        out.println(padRight("Barring all outgoing roaming calls: " )+ cbo.getElementsByTagName("boro").item(0).getTextContent());
        Element cbi = (Element) hlrOdbSub.getElementsByTagName("cbi").item(0);
        out.println(padRight("Barring all incoming call: " )+ cbi.getElementsByTagName("baic").item(0).getTextContent());
        out.println(padRight("Barring all incoming roaming call: " )+ cbi.getElementsByTagName("biro").item(0).getTextContent());
        Element bosCf = (Element) hlrOdbSub.getElementsByTagName("bosCf").item(0);
        out.println(padRight("Barring data sessions: " )+ bosCf.getElementsByTagName("bosCf1").item(0).getTextContent());
        Element hlrGprsPdpSub = (Element) root.getElementsByTagName("hlrGprsPdpSub").item(0);
        out.println(padRight("GPRS roaming profile: " )+ hlrGprsPdpSub.getElementsByTagName("grp").item(0).getTextContent());
        out.println(padRight("Gprs barring paramater: " )+ hlrGprsPdpSub.getElementsByTagName("nwAcc").item(0).getTextContent());
        NodeList pdps = hlrGprsPdpSub.getElementsByTagName("pdp");
        for(int i=0; i<pdps.getLength(); i++){
            out.println(padRight("APN"+(i+1)+" Context ID: ")+((Element) pdps.item(i)).getElementsByTagName("pdpContextId").item(0).getTextContent());
        }
    }

    public static String padRight(String s) {
        return String.format("%1$-" + 42 + "s", s).replace(" ", ".");
    }
}

class ReqHandler implements Runnable {

    Socket soc;
    EMAHTTPServer EMAInst;

    public ReqHandler(Socket soc, EMAHTTPServer inst) {
        this.soc = soc;
        this.EMAInst = inst;
    }

    public void run() {
        BufferedReader in
                = null;
        try {
            PrintWriter out
                    = new PrintWriter(soc.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(soc.getInputStream()));
            String subno, res;
            do {
                subno = in.readLine();
                if (!subno.equals("q")) {
                    EMAInst.queryHLR(subno, out);
                    out.println("$");
                }
            } while (!subno.equals("q"));
            soc.close();
        } catch (IOException ex) {
            Logger.getLogger(ReqHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ReqHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ReqHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
                soc.close();
            } catch (IOException ex) {
                Logger.getLogger(ReqHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
