
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nizar.Abubaker
 */
public class LMSHTTP {

    public static String queryLMS(String subno, String prepost_paid) throws UnsupportedEncodingException, IOException {
        String url = "http://10.123.105.243/eai_anon_enu/start.swe?SWEExtSource=SecureWebService&SWEExtCmd=Execute";
        String charset = "UTF-8";
        String query="<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://10.123.105.243\" xmlns:wsse=\"http://schemas.xmlsoap.org/ws/2002/07/secext\" xmlns:wsu=\"http://schemas.xmlsoap.org/ws/2002/07/utility\"><SOAP-ENV:Header><wsse:Security><wsse:UsernameToken><wsse:Username>SMUSTAQUIM</wsse:Username><wsse:Password>valencia2002$</wsse:Password></wsse:UsernameToken></wsse:Security></SOAP-ENV:Header><SOAP-ENV:Body><ns:Query_spcLOY_spcBalans><Account_spcName>"+subno+"</Account_spcName><Type>"+prepost_paid+"</Type></ns:Query_spcLOY_spcBalans></SOAP-ENV:Body></SOAP-ENV:Envelope>";
//        String param1 = URLEncoder.encode("param1", charset);
  //      String param2 = URLEncoder.encode("param2", charset);
    //    String query = String.format("param1=%s&param2=%s", param1, param2);

        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.setUseCaches(false);
        urlConnection.setDoOutput(true); // Triggers POST.
        urlConnection.setRequestProperty("Accept", "text/xml, text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2");
        urlConnection.setRequestProperty("SOAPAction", "\"rpc/http://10.123.105.243:Query_spcLOY_spcBalans\"");
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
        String res="";
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            res += inputLine;
        in.close();
        return res;
    }
}
