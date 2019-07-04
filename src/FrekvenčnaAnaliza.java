import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrekvenčnaAnaliza {

	private JFrame frame;
	private JTextField prvaCrka;
	private JTextField drugaCrka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrekvenčnaAnaliza window = new FrekvenčnaAnaliza();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrekvenčnaAnaliza() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String abeceda = "abcčdefghijklmnoprsštuvzžxyqw";
		ArrayList<Črka> polje = new ArrayList<>();
		ArrayList<Črka> polje2 = new ArrayList<>();
		ArrayList<Zamenjava> polje3 = new ArrayList<>();

		for (int ee = 0; ee < abeceda.length(); ee++) {
			polje.add(new Črka(String.valueOf(abeceda.charAt(ee))));

		}

		for (int ee = 0; ee < abeceda.length(); ee++) {
			polje2.add(new Črka(String.valueOf(abeceda.charAt(ee))));

		}

		frame = new JFrame();
		frame.setBounds(100, 100, 863, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 284, 195);
		frame.getContentPane().add(scrollPane);

		JTextArea sifriranaTekst = new JTextArea();
		scrollPane.setViewportView(sifriranaTekst);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(421, 11, 282, 193);
		frame.getContentPane().add(scrollPane_1);

		JTextArea referencnaTekst = new JTextArea();
		scrollPane_1.setViewportView(referencnaTekst);

		JButton odpriSifrirano = new JButton("Odpri šifrirano ");
		odpriSifrirano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Odpri of = new Odpri();

				try {
					of.PickMe();
				} catch (Exception e) {
					e.printStackTrace();
				}
				sifriranaTekst.setText(of.sb.toString());

				// sifriranaTekst.setText(of.ime1);
				// String tekst = sifriranaTekst.getText();

			}

		});
		odpriSifrirano.setBounds(20, 217, 149, 43);
		frame.getContentPane().add(odpriSifrirano);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(438, 269, 280, 191);
		frame.getContentPane().add(scrollPane_2);

		JTextArea zamenjani = new JTextArea();
		scrollPane_2.setViewportView(zamenjani);

		
		JButton odpriReferencno = new JButton("Odpri Referencno");
		odpriReferencno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Odpri2 odpri = new Odpri2();

				try {
					odpri.PickMe2();
				} catch (Exception e) {
					e.printStackTrace();
				}
				referencnaTekst.setText(odpri.sb2.toString());

			}
		});
		odpriReferencno.setBounds(501, 215, 149, 43);
		frame.getContentPane().add(odpriReferencno);

		JLabel prva = new JLabel("Prva črka");
		prva.setBounds(10, 288, 65, 24);
		frame.getContentPane().add(prva);

		JLabel druga = new JLabel("Druga črka");
		druga.setBounds(10, 347, 65, 24);
		frame.getContentPane().add(druga);

		prvaCrka = new JTextField();
		prvaCrka.setBounds(10, 323, 65, 24);
		frame.getContentPane().add(prvaCrka);
		prvaCrka.setColumns(10);

		drugaCrka = new JTextField();
		drugaCrka.setColumns(10);
		drugaCrka.setBounds(10, 382, 65, 24);
		frame.getContentPane().add(drugaCrka);

		JButton btnZamenjaj = new JButton("Zamenjaj");
		btnZamenjaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checked;
				String sifriran = zamenjani.getText();
				String prvaC = prvaCrka.getText();
				String drugaC = drugaCrka.getText();
				char[] tekst = sifriran.toCharArray();
				char[] prva = prvaC.toCharArray();
				char[] druga = drugaC.toCharArray();

				for (int i = 0; i < tekst.length; i++) {
					checked = false;
					if (tekst[i] == prva[0]) {
						tekst[i] = druga[0];
						checked = true;
					}
					if (tekst[i] == druga[0] && checked == false) {
						tekst[i] = prva[0];
					}
				}

				String spremenjen = String.copyValueOf(tekst);
				zamenjani.setText(spremenjen);

			}
		});
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 464, 847, 18);
		frame.getContentPane().add(scrollPane_3);
		
		

		JLabel menjava = new JLabel("");
		scrollPane_3.setViewportView(menjava);

		btnZamenjaj.setBounds(10, 417, 97, 36);
		frame.getContentPane().add(btnZamenjaj);

		JButton btnAvtomatsko = new JButton("Avtomatsko");
		btnAvtomatsko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String zamenjano;

				String sif = sifriranaTekst.getText();
				String ref = referencnaTekst.getText();
				for (int ee = 0; ee < ref.length(); ee++) {
					for (int i = 0; i < polje.size(); i++) {
						if (polje.get(i).getČrka().equalsIgnoreCase(String.valueOf(ref.charAt(ee))))
							polje.get(i).seštej();
					}

				}

				for (int ee = 0; ee < sif.length(); ee++) {
					for (int i = 0; i < polje2.size(); i++) {
						if (polje2.get(i).getČrka().equalsIgnoreCase(String.valueOf((sif.charAt(ee)))))
							polje2.get(i).seštej();
					}

				}

				for (int ee = 0; ee < polje.size(); ee++) {
					for (int ef = 0; ef < polje2.size(); ef++) {
						if (polje.get(ee).getŠtevilo() == polje2.get(ef).getŠtevilo()) {
							polje3.add(new Zamenjava(polje.get(ee).getČrka().charAt(0),
									polje2.get(ef).getČrka().charAt(0)));
							polje2.remove(ef);
							break;
						}
					}

				}
				zamenjano = "";
				for (int i = 0; i < polje3.size(); i++) {
					zamenjano += polje3.get(i);
				}
				menjava.setText(zamenjano);

				char[] sifrirano = sif.toCharArray();
				for (int ee = 0; ee < sifrirano.length; ee++) {

					for (int i = 0; i < polje3.size(); i++) {
						if (sifrirano[ee] == polje3.get(i).getČrka()) {
							sifrirano[ee] = (polje3.get(i).getZamenjava());

							break;
						}

					}

				}

			//	ena.setText(ref);
			//	dva.setText(sif);
				zamenjani.setText(String.valueOf(sifrirano));

			}
		});
		btnAvtomatsko.setBounds(748, 36, 89, 23);
		frame.getContentPane().add(btnAvtomatsko);

		JButton bttnShrani = new JButton("Shrani");
		bttnShrani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String sb = sifriranaTekst.getText();
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File("/home/me/Documents"));
				int retrival = chooser.showSaveDialog(null);
				if (retrival == JFileChooser.APPROVE_OPTION) {
					try (FileWriter fw = new FileWriter(chooser.getSelectedFile() + ".txt")) {
						fw.write(sb.toString());

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}

		});
		bttnShrani.setBounds(748, 82, 89, 23);
		frame.getContentPane().add(bttnShrani);
		
		
	}
}
