
import java.util.Scanner;


import javax.swing.JFileChooser;

public class Odpri2 {

	JFileChooser fileChooser2 = new JFileChooser();
	StringBuilder sb2 = new StringBuilder();
	String ime2;
	
	public void PickMe2() throws Exception {
		fileChooser2.setMultiSelectionEnabled(true);
		if (fileChooser2.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			java.io.File file2 = fileChooser2.getSelectedFile();

			ime2=file2.getName();
			Scanner input2 = new Scanner(file2,"UTF-8");

			
			while (input2.hasNext()) {
				sb2.append(input2.nextLine());
				sb2.append("\n");
			}
			input2.close();
		} else {
			sb2.append("Nobena datoteka ni bila izbrana!");
		}
	}
	}

