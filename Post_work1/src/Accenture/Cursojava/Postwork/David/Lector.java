package Accenture.Cursojava.Postwork.David;

import java.util.Scanner;

public class Lector {

    private Scanner s = new Scanner(System.in);

    public byte leeOpcion() {
        System.out.print("Opcion: ");
        return s.nextByte();
    }

    public String leeCadena(){
        return s.nextLine();
    }

}
