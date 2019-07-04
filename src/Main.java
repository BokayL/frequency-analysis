import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Napišite ime šifrirane datoteke: ");
		Scanner scanner = new Scanner(System.in);
		String ime_datoteke = scanner.nextLine();
		
		String datoteka = "C:/D DISK/3. letnik/VarnostIKT/Naloga3/TestneDatoteke/" + ime_datoteke + ".txt";
		String test = readFile(datoteka);
		
		System.out.println("Šifrirana datoteka: " + test);
		String nova = test;
		
		System.out.println("Napišite ime referenène datoteke: ");
		Scanner scanner5 = new Scanner(System.in);
		String ime_datoteke1 = scanner5.nextLine();
		
		
		String datoteka1 = "C:/D DISK/3. letnik/VarnostIKT/Naloga3/TestneDatoteke/" + ime_datoteke1 + ".txt";
		String test1 = readFile(datoteka1);
		
		System.out.println("Referenèna datoteka: " + test1);
		
		
		boolean konec = false;
		
		while(konec==false) {
		   System.out.println("Katere dve èrke bi radi zamenjali pri šifrirani datoteki?");
		   System.out.println("Prva èrka: ");
		   Scanner scanner1 = new Scanner(System.in);
		   String prva = scanner1.nextLine();
		   System.out.println("Druga èrka: ");
		   Scanner scanner2 = new Scanner(System.in);
		   String druga = scanner2.nextLine();
		   nova = zamenjaj(nova,prva,druga);
		   System.out.println(nova);
		   
		   System.out.println("Želite pogledati referenèno datoteko? (y, n): ");
		   Scanner scanner6 = new Scanner(System.in);
		   String bool2 = scanner6.nextLine();
		   if(bool2.equals("y")) {
			   System.out.println("Vaša referenèna datoteka je: " + test1);
		   }
		   System.out.println("Hoèete zamenjati še kakšne dve èrki? (y, n): ");
		   Scanner scanner3 = new Scanner(System.in);
		   String bool = scanner3.nextLine();
		   if(bool.equals("n")) {
			   System.out.println("Vaše dešifrirano besedilo je: " + nova);
			   konec=true;
		   }
		
		   
		}
		   System.out.println("Kako bi radi poimenovali datoteko? Ime: ");
		   Scanner scanner4 = new Scanner(System.in);
		   String poimenovanje = scanner4.nextLine();
		   PrintWriter writer = new PrintWriter("C:/D DISK/3. letnik/VarnostIKT/Naloga3/TestneDatoteke/" + poimenovanje + ".txt", "UTF-8");
		   writer.println(nova + System.getProperty("line.separator"));
		   writer.close();
		
		   System.out.println("Shranjeno... Adijo!");
		
	}
	

static String readFile(String fileName) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        return sb.toString();
    } finally {
        br.close();
    }
}

public static String zamenjaj(String text, String prva, String druga){
    char[] letters = text.toCharArray();
    char[] prva1 = prva.toCharArray();
    char[] druga1 = druga.toCharArray();
    boolean preveril;

    for (int i = 0; i < letters.length; i++){
    	preveril = false;
        if (letters[i] == prva1[0]) {
        	System.out.println("Prva od niè je " + prva1[0]);
            letters[i] = druga1[0];
            preveril = true;
        }
        if (letters[i] == druga1[0] && preveril==false) {
        	System.out.println("Prva od niè je " + druga1[0]);
            letters[i] = prva1[0];
        }
    }
    

    return new String(letters);
}

}
