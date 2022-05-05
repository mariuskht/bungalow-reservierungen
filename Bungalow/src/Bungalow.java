import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Bungalow extends JFrame {

	private JPanel contentPane;
	
	private JFrame frame;
	private JTextField textBungalowNr;
	private JTextField textStartWoche;
	private JTextField textEndWoche;
	private JTextField textAnzahlPersonen;
	private JTextField textRueckmeldung;
	
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
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		buchungen = new int[11][4]; // 11 -> 10 houses; 4 -> textBungalowNr, textStartWoche, textEndWoche, textAnzahlPersonen
		getContentPane().setLayout(null);
		JButton btnReservierungDurchfuehren = new JButton("Reservierung Durchf\u00FChren");
		btnReservierungDurchfuehren.setBounds(27, 250, 200, 60);
		contentPane.add(btnReservierungDurchfuehren);
		btnReservierungDurchfuehren.addActionListener(new ActionListener() { // wenn button gedrückt wird, ...
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		textBungalowNr = new JTextField();
		textBungalowNr.setBounds(200, 21, 164, 40);
		contentPane.add(textBungalowNr);
		textBungalowNr.setColumns(10);
		
		textStartWoche = new JTextField();
		textStartWoche.setBounds(200, 72, 164, 40);
		textStartWoche.setColumns(10);
		contentPane.add(textStartWoche);
		
		JLabel lblBungalowNr = new JLabel("Bungalow-Nummer:");
		lblBungalowNr.setBounds(27, 21, 150, 40);
		contentPane.add(lblBungalowNr);
		
		JLabel lblStartWoche = new JLabel("Start-Woche:");
		lblStartWoche.setBounds(27, 72, 150, 40);
		contentPane.add(lblStartWoche);
		
		JLabel lblEndWoche = new JLabel("End-Woche:");
		lblEndWoche.setBounds(27, 123, 150, 40);
		contentPane.add(lblEndWoche);
		
		textEndWoche = new JTextField();
		textEndWoche.setColumns(10);
		textEndWoche.setBounds(200, 123, 164, 40);
		contentPane.add(textEndWoche);
		
		textAnzahlPersonen = new JTextField();
		textAnzahlPersonen.setColumns(10);
		textAnzahlPersonen.setBounds(200, 173, 164, 40);
		contentPane.add(textAnzahlPersonen);
		
		JLabel lblAnzahlPersonen = new JLabel("Anzahl Personen:");
		lblAnzahlPersonen.setBounds(27, 174, 150, 40);
		contentPane.add(lblAnzahlPersonen);
		
		textRueckmeldung = new JTextField();
		textRueckmeldung.setColumns(10);
		textRueckmeldung.setBounds(26, 550, 675, 400);
		contentPane.add(textRueckmeldung); 
		
		
		
		
		JButton btnBuchungsDatenAnzeigen = new JButton("Buchungsdaten anzeigen");
		btnBuchungsDatenAnzeigen.addActionListener(new ActionListener() { // wenn Button "Buchungsdaten anzeigen" gedrückt wird
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == btnReservierungDurchfuehren) {
					buchungen[Integer.parseInt(textBungalowNr.getText())][0] = Integer.parseInt(textBungalowNr.getText()); // [x] -> Bungalow Nummer; [y] -> Variable 1
					buchungen[Integer.parseInt(textBungalowNr.getText())][1] = Integer.parseInt(textStartWoche.getText()); // [x] -> Bungalow Nummer; [y] -> Variable 2
					buchungen[Integer.parseInt(textBungalowNr.getText())][2] = Integer.parseInt(textEndWoche.getText()); // [x] -> Bungalow Nummer; [y] -> Variable 3
					buchungen[Integer.parseInt(textBungalowNr.getText())][3] = Integer.parseInt(textAnzahlPersonen.getText()); // [x] -> Bungalow Nummer; [y] -> Variable 4
				}
			}
		});
		btnBuchungsDatenAnzeigen.setBounds(236, 250, 200, 60);
		contentPane.add(btnBuchungsDatenAnzeigen);
		
		
		
		
		
		JButton btnBungalow_1 = new JButton("Bungalow 1");
		btnBungalow_1.addActionListener(new ActionListener() { // wenn Button "Bungalow 1" gedrückt
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnBungalow_1.setBounds(500, 21, 201, 40);
		contentPane.add(btnBungalow_1);
		
		JButton btnBungalow_2 = new JButton("Bungalow 2");
		btnBungalow_2.addActionListener(new ActionListener() { // wenn Button "Bungalow 2" gedrückt
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBungalow_2.setBounds(500, 72, 201, 40);
		contentPane.add(btnBungalow_2);
		
		JButton btnBungalow_3 = new JButton("Bungalow 3");
		btnBungalow_3.addActionListener(new ActionListener() { // wenn Button "Bungalow 3" gedrückt
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBungalow_3.setBounds(500, 123, 201, 40);
		contentPane.add(btnBungalow_3);
		
		JButton btnBungalow_4 = new JButton("Bungalow 4");
		btnBungalow_4.addActionListener(new ActionListener() { // wenn Button "Bungalow 4" gedrückt
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBungalow_4.setBounds(500, 173, 201, 40);
		contentPane.add(btnBungalow_4);
		
		JButton btnBungalow_5 = new JButton("Bungalow 5");
		btnBungalow_5.addActionListener(new ActionListener() { // wenn Button "Bungalow 5" gedrückt
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBungalow_5.setBounds(500, 224, 201, 40);
		contentPane.add(btnBungalow_5);
		
		JButton btnBungalow_6 = new JButton("Bungalow 6");
		btnBungalow_6.addActionListener(new ActionListener() { // wenn Button "Bungalow 6" gedrückt
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBungalow_6.setBounds(500, 275, 201, 40);
		contentPane.add(btnBungalow_6);
		
		JButton btnBungalow_7 = new JButton("Bungalow 7");
		btnBungalow_7.addActionListener(new ActionListener() { // wenn Button "Bungalow 7" gedrückt
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBungalow_7.setBounds(500, 326, 201, 40);
		contentPane.add(btnBungalow_7);
		
		JButton btnBungalow_8 = new JButton("Bungalow 8");
		btnBungalow_8.addActionListener(new ActionListener() { // wenn Button "Bungalow 8" gedrückt
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBungalow_8.setBounds(500, 377, 201, 40);
		contentPane.add(btnBungalow_8);
		
		JButton btnBungalow_9 = new JButton("Bungalow 9");
		btnBungalow_9.addActionListener(new ActionListener() { // wenn Button "Bungalow 9" gedrückt
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBungalow_9.setBounds(500, 428, 201, 40);
		contentPane.add(btnBungalow_9);
		
		JButton btnBungalow_10 = new JButton("Bungalow 10");
		btnBungalow_10.addActionListener(new ActionListener() { // wenn Button "Bungalow 10" gedrückt
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBungalow_10.setBounds(500, 479, 201, 40);
		contentPane.add(btnBungalow_10);
	}

}
