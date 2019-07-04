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
		
		System.out.println("Napi�ite ime �ifrirane datoteke: ");
		Scanner scanner = new Scanner(System.in);
		String ime_datoteke = scanner.nextLine();
		
		String datoteka = "C:/D DISK/3. letnik/VarnostIKT/Naloga3/TestneDatoteke/" + ime_datoteke + ".txt";
		String test = readFile(datoteka);
		
		System.out.println("�ifrirana datoteka: " + test);
		String nova = test;
		
		System.out.println("Napi�ite ime referen�ne datoteke: ");
		Scanner scanner5 = new Scanner(System.in);
		String ime_datoteke1 = scanner5.nextLine();
		
		
		String datoteka1 = "C:/D DISK/3. letnik/VarnostIKT/Naloga3/TestneDatoteke/" + ime_datoteke1 + ".txt";
		String test1 = readFile(datoteka1);
		
		System.out.println("Referen�na datoteka: " + test1);
		
		
		boolean konec = false;
		
		while(konec==false) {
		   System.out.println("Katere dve �rke bi radi zamenjali pri �ifrirani datoteki?");
		   System.out.println("Prva �rka: ");
		   Scanner scanner1 = new Scanner(System.in);
		   String prva = scanner1.nextLine();
		   System.out.println("Druga �rka: ");
		   Scanner scanner2 = new Scanner(System.in);
		   String druga = scanner2.nextLine();
		   nova = zamenjaj(nova,prva,druga);
		   System.out.println(nova);
		   
		   System.out.println("�elite pogledati referen�no datoteko? (y, n): ");
		   Scanner scanner6 = new Scanner(System.in);
		   String bool2 = scanner6.nextLine();
		   if(bool2.equals("y")) {
			   System.out.println("Va�a referen�na datoteka je: " + test1);
		   }
		   System.out.println("Ho�ete zamenjati �e kak�ne dve �rki? (y, n): ");
		   Scanner scanner3 = new Scanner(System.in);
		   String bool = scanner3.nextLine();
		   if(bool.equals("n")) {
			   System.out.println("Va�e de�ifrirano besedilo je: " + nova);
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
        	System.out.println("Prva od ni� je " + prva1[0]);
            letters[i] = druga1[0];
            preveril = true;
        }
        if (letters[i] == druga1[0] && preveril==false) {
        	System.out.println("Prva od ni� je " + druga1[0]);
            letters[i] = prva1[0];
        }
    }
    

    return new String(letters);
}

}
