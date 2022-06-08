import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Bungalow extends JFrame {

	private JPanel contentPane;

	private JTextField textBungalowNr;
	private JTextField textStartWoche;
	private JTextField textEndWoche;
	private JTextField textAnzahlPersonen;
	private JTextArea textRueckmeldung;

	private JButton btnBungalow_1, btnBungalow_2, btnBungalow_3, btnBungalow_4, btnBungalow_5, btnBungalow_6,
			btnBungalow_7, btnBungalow_8, btnBungalow_9, btnBungalow_10, btnReservierungDurchfuehren;

	private JLabel lblBungalowNr, lblStartWoche, lblEndWoche, lblAnzahlPersonen;

	private int[][] buchungen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bungalow frame = new Bungalow();
					frame.setVisible(true);
					frame.setSize(800, 1000);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					// frame.setIconImage(null); FensterIcon festlegen
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bungalow() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		buchungen = new int[11][4]; // textBungalowNr, textStartWoche, textEndWoche, textAnzahlPersonen
		getContentPane().setLayout(null);

		// Button, um die Reservierung abzuschließen

		btnReservierungDurchfuehren = new JButton("Reservierung Durchf\u00FChren");
		btnReservierungDurchfuehren.setBounds(27, 250, 200, 60);
		contentPane.add(btnReservierungDurchfuehren);
		btnReservierungDurchfuehren.addActionListener(new ActionListener() { // wenn button gedrückt wird, ...

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
						

						if (Integer.parseInt(textBungalowNr.getText()) <= 0
								|| Integer.parseInt(textBungalowNr.getText()) > 10) {
							throw new Exception();											//Fehler Bungalow-Nummer abfangen
						}else {
							buchungen[Integer.parseInt(textBungalowNr.getText())][0] = Integer
									.parseInt(textBungalowNr.getText()); // [x] -> Bungalow Nummer; [y] -> Variable 1
						}

						
						
						if (Integer.parseInt(textStartWoche.getText()) < 1|| Integer.parseInt(textStartWoche.getText()) > 51 ||
								Integer.parseInt(textEndWoche.getText()) < 1 || Integer.parseInt(textEndWoche.getText()) > 52 ||
								Integer.parseInt(textStartWoche.getText()) >= Integer.parseInt(textEndWoche.getText())){
							throw new Exception();												//Fehler Start- und Endwoche abfangen
						}else {
							buchungen[Integer.parseInt(textBungalowNr.getText())][1] = Integer
									.parseInt(textStartWoche.getText()); // [x] -> Bungalow Nummer; [y] -> Variable 2
							buchungen[Integer.parseInt(textBungalowNr.getText())][2] = Integer
									.parseInt(textEndWoche.getText()); // [x] -> Bungalow Nummer; [y] -> Variable 3
						}
						


					buchungen[Integer.parseInt(textBungalowNr.getText())][3] = Integer
							.parseInt(textAnzahlPersonen.getText()); // [x] -> Bungalow Nummer; [y] -> Variable 4

					textRueckmeldung.setText(
							"Bungalow-Nummer: " + buchungen[Integer.parseInt(textBungalowNr.getText())][0] + "\n" + // Reservierung
																													// wird
																													// in
																													// der
																													// TextRückmeldung
																													// bestätigt
									"Start-Woche: " + buchungen[Integer.parseInt(textBungalowNr.getText())][1] + "\n"
									+ "End-Woche: " + buchungen[Integer.parseInt(textBungalowNr.getText())][2] + "\n"
									+ "Anzahl Personen: " + buchungen[Integer.parseInt(textBungalowNr.getText())][3]);
				} catch (Exception exception) {
					textRueckmeldung.setText("Diese Eingabe war fehlerhaft!");
				}

				textBungalowNr.setText(""); // Fenster TextRückmeldung wird geleert
				textStartWoche.setText("");
				textEndWoche.setText("");
				textAnzahlPersonen.setText("");

			}
		});

		// Eingabetexte für die Reservierung
		textBungalowNr = new JTextField();
		textBungalowNr.setBounds(200, 21, 164, 40);
		contentPane.add(textBungalowNr);
		textBungalowNr.setColumns(10);

		textStartWoche = new JTextField();
		textStartWoche.setBounds(200, 72, 164, 40);
		textStartWoche.setColumns(10);
		contentPane.add(textStartWoche);

		textEndWoche = new JTextField();
		textEndWoche.setColumns(10);
		textEndWoche.setBounds(200, 123, 164, 40);
		contentPane.add(textEndWoche);

		textAnzahlPersonen = new JTextField();
		textAnzahlPersonen.setColumns(10);
		textAnzahlPersonen.setBounds(200, 173, 164, 40);
		contentPane.add(textAnzahlPersonen);

		// Label zu den Eingabetexten

		lblBungalowNr = new JLabel("Bungalow-Nummer:");
		lblBungalowNr.setBounds(27, 21, 150, 40);
		contentPane.add(lblBungalowNr);

		lblStartWoche = new JLabel("Start-Woche:");
		lblStartWoche.setBounds(27, 72, 150, 40);
		contentPane.add(lblStartWoche);

		lblEndWoche = new JLabel("End-Woche:");
		lblEndWoche.setBounds(27, 123, 150, 40);
		contentPane.add(lblEndWoche);

		lblAnzahlPersonen = new JLabel("Anzahl Personen:");
		lblAnzahlPersonen.setBounds(27, 174, 150, 40);
		contentPane.add(lblAnzahlPersonen);

		// Rückmeldungstext der Reservierung
		textRueckmeldung = new JTextArea();
		textRueckmeldung.setRows(4);
		textRueckmeldung.setLineWrap(true); // Zeilenumbruch
		textRueckmeldung.setWrapStyleWord(true); // Zeilenumbruch nur nach ganzen Wörtern
		textRueckmeldung.setBounds(26, 550, 675, 400);
		textRueckmeldung.setEditable(false);
		contentPane.add(textRueckmeldung);

		// Funktionsweise der Buttons für die Bungalows

		btnBungalow_1 = new JButton("Bungalow 1");
		btnBungalow_1.addActionListener(new ActionListener() { // wenn Button "Bungalow 1" gedrückt
			public void actionPerformed(ActionEvent e) {
				textRueckmeldung.setText("Bungalow-Nummer: 1" + "\n" + "Start-Woche: " + buchungen[1][1] + "\n"
						+ "End-Woche: " + buchungen[1][2] + "\n" + "Anzahl Personen: " + buchungen[1][3]);

			}
		});
		btnBungalow_1.setBounds(500, 21, 201, 40);
		contentPane.add(btnBungalow_1);

		btnBungalow_2 = new JButton("Bungalow 2");
		btnBungalow_2.addActionListener(new ActionListener() { // wenn Button "Bungalow 2" gedrückt
			public void actionPerformed(ActionEvent e) {
				textRueckmeldung.setText("Bungalow-Nummer: 2" + "\n" + "Start-Woche: " + buchungen[2][1] + "\n"
						+ "End-Woche: " + buchungen[2][2] + "\n" + "Anzahl Personen: " + buchungen[2][3]);
			}
		});
		btnBungalow_2.setBounds(500, 72, 201, 40);
		contentPane.add(btnBungalow_2);

		btnBungalow_3 = new JButton("Bungalow 3");
		btnBungalow_3.addActionListener(new ActionListener() { // wenn Button "Bungalow 3" gedrückt
			public void actionPerformed(ActionEvent e) {
				textRueckmeldung.setText("Bungalow-Nummer: 3" + "\n" + "Start-Woche: " + buchungen[3][1] + "\n"
						+ "End-Woche: " + buchungen[3][2] + "\n" + "Anzahl Personen: " + buchungen[3][3]);
			}
		});
		btnBungalow_3.setBounds(500, 123, 201, 40);
		contentPane.add(btnBungalow_3);

		btnBungalow_4 = new JButton("Bungalow 4");
		btnBungalow_4.addActionListener(new ActionListener() { // wenn Button "Bungalow 4" gedrückt
			public void actionPerformed(ActionEvent e) {
				textRueckmeldung.setText("Bungalow-Nummer: 4" + "\n" + "Start-Woche: " + buchungen[4][1] + "\n"
						+ "End-Woche: " + buchungen[4][2] + "\n" + "Anzahl Personen: " + buchungen[4][3]);
			}
		});
		btnBungalow_4.setBounds(500, 173, 201, 40);
		contentPane.add(btnBungalow_4);

		btnBungalow_5 = new JButton("Bungalow 5");
		btnBungalow_5.addActionListener(new ActionListener() { // wenn Button "Bungalow 5" gedrückt
			public void actionPerformed(ActionEvent e) {
				textRueckmeldung.setText("Bungalow-Nummer: 5" + "\n" + "Start-Woche: " + buchungen[5][1] + "\n"
						+ "End-Woche: " + buchungen[5][2] + "\n" + "Anzahl Personen: " + buchungen[5][3]);
			}
		});
		btnBungalow_5.setBounds(500, 224, 201, 40);
		contentPane.add(btnBungalow_5);

		btnBungalow_6 = new JButton("Bungalow 6");
		btnBungalow_6.addActionListener(new ActionListener() { // wenn Button "Bungalow 6" gedrückt
			public void actionPerformed(ActionEvent e) {
				textRueckmeldung.setText("Bungalow-Nummer: 6" + "\n" + "Start-Woche: " + buchungen[6][1] + "\n"
						+ "End-Woche: " + buchungen[6][2] + "\n" + "Anzahl Personen: " + buchungen[6][3]);
			}
		});
		btnBungalow_6.setBounds(500, 275, 201, 40);
		contentPane.add(btnBungalow_6);

		btnBungalow_7 = new JButton("Bungalow 7");
		btnBungalow_7.addActionListener(new ActionListener() { // wenn Button "Bungalow 7" gedrückt
			public void actionPerformed(ActionEvent e) {
				textRueckmeldung.setText("Bungalow-Nummer: 7" + "\n" + "Start-Woche: " + buchungen[7][1] + "\n"
						+ "End-Woche: " + buchungen[7][2] + "\n" + "Anzahl Personen: " + buchungen[7][3]);
			}
		});
		btnBungalow_7.setBounds(500, 326, 201, 40);
		contentPane.add(btnBungalow_7);

		btnBungalow_8 = new JButton("Bungalow 8");
		btnBungalow_8.addActionListener(new ActionListener() { // wenn Button "Bungalow 8" gedrückt
			public void actionPerformed(ActionEvent e) {
				textRueckmeldung.setText("Bungalow-Nummer: 8" + "\n" + "Start-Woche: " + buchungen[8][1] + "\n"
						+ "End-Woche: " + buchungen[8][2] + "\n" + "Anzahl Personen: " + buchungen[8][3]);
			}
		});
		btnBungalow_8.setBounds(500, 377, 201, 40);
		contentPane.add(btnBungalow_8);

		btnBungalow_9 = new JButton("Bungalow 9");
		btnBungalow_9.addActionListener(new ActionListener() { // wenn Button "Bungalow 9" gedrückt
			public void actionPerformed(ActionEvent e) {
				textRueckmeldung.setText("Bungalow-Nummer: 9" + "\n" + "Start-Woche: " + buchungen[9][1] + "\n"
						+ "End-Woche: " + buchungen[9][2] + "\n" + "Anzahl Personen: " + buchungen[9][3]);
			}
		});
		btnBungalow_9.setBounds(500, 428, 201, 40);
		contentPane.add(btnBungalow_9);

		btnBungalow_10 = new JButton("Bungalow 10");
		btnBungalow_10.addActionListener(new ActionListener() { // wenn Button "Bungalow 10" gedrückt
			public void actionPerformed(ActionEvent e) {
				textRueckmeldung.setText("Bungalow-Nummer: 10" + "\n" + "Start-Woche: " + buchungen[10][1] + "\n"
						+ "End-Woche: " + buchungen[10][2] + "\n" + "Anzahl Personen: " + buchungen[10][3]);
			}
		});
		btnBungalow_10.setBounds(500, 479, 201, 40);
		contentPane.add(btnBungalow_10);
	}

}
