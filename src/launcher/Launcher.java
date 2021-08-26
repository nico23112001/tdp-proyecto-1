package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student nicolasMessina = new Student(130113,"Messina","Nicolas","nmessina@live.com.ar","https://github.com/nico23112001","/images/Foto 4.jpg");
				SimplePresentationScreen window = new SimplePresentationScreen(nicolasMessina);
				window.setVisible(true);
            }
        });
    }
}