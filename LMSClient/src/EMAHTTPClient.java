
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nizar.Abubaker
 */
public class EMAHTTPClient {

    public static void main(String[] args) throws Exception {
        Socket soc = new Socket("10.123.109.53", 2312);
        PrintWriter socout = new PrintWriter(soc.getOutputStream(), true);
        BufferedReader socin = new BufferedReader(
                    new InputStreamReader(soc.getInputStream()));
        Scanner in = new Scanner(System.in);
        String subno, resp, line;
        do {
            System.out.print("Subno (q to quit)>");
            subno = in.next();
            if(!subno.equals("q")){
                socout.println(subno);
                resp = "";
                do{
                    line = socin.readLine();
                    if(!line.equals("$"))
                        System.out.println(line);
                }while(!line.equals("$"));
            }
        } while (!subno.equals("q"));
        soc.close();
    }

}
