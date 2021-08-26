package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(618, 275));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 211);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Informacion del alumno", null, tabInformation, "Muestra la informacion declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setBounds(14, 15, 46, 14);
		lblLU.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(14, 47, 46, 14);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(14, 78, 46, 14);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabInformation.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(14, 112, 46, 14);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabInformation.add(lblEmail);
		
		JLabel lblUrl = new JLabel("Github URL");
		lblUrl.setBounds(14, 144, 69, 14);
		lblUrl.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabInformation.add(lblUrl);
		
		JEditorPane editorPaneLU = new JEditorPane();
		editorPaneLU.setBounds(93, 11, 322, 20);
		editorPaneLU.setText(studentData.getId() + "");
		tabInformation.add(editorPaneLU);
		
		JEditorPane editorPaneApellido = new JEditorPane();
		editorPaneApellido.setBounds(93, 43, 322, 20);
		editorPaneApellido.setText(studentData.getFirstName());
		tabInformation.add(editorPaneApellido);
		
		JEditorPane editorPaneNombre = new JEditorPane();
		editorPaneNombre.setBounds(93, 74, 322, 20);
		editorPaneNombre.setText(studentData.getLastName());
		tabInformation.add(editorPaneNombre);
		
		JEditorPane editorPaneEmail = new JEditorPane();
		editorPaneEmail.setBounds(93, 108, 322, 20);
		editorPaneEmail.setText(studentData.getMail());
		tabInformation.add(editorPaneEmail);
		
		JEditorPane editorPaneUrl = new JEditorPane();
		editorPaneUrl.setBounds(93, 140, 322, 20);
		editorPaneUrl.setText(studentData.getGithubURL());
		tabInformation.add(editorPaneUrl);
		contentPane.add(tabbedPane);
		
		JLabel labelFoto = new JLabel("New label");
		labelFoto.setBounds(450, 25, 159, 191);
		ImageIcon foto = new ImageIcon(this.getClass().getResource(studentData.getPathPhoto()));
		ImageIcon imagen =new ImageIcon(foto.getImage().getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_SMOOTH));
		labelFoto.setIcon(imagen);
		contentPane.add(labelFoto);
		
		JLabel lblFecha = new JLabel("");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(5, 215, 272, 14);
		contentPane.add(lblFecha);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(7, 220, 428, 14);
        DateTimeFormatter day = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hrs = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        lblFecha.setText("Esta ventana fue generada el " + day.format(now) + " a las " + hrs.format(now));
        contentPane.add(lblFecha);
	}

}
