import javax.swing.*;
import java.awt.*;

public class test2 extends JFrame
{
	 JPanel container = new JPanel();
	 JTextField jtf = new JTextField("");
	 JTextField jtf2 = new JTextField("");
	 JTextField jtf3 = new JTextField("");
	 JLabel NomDossier = new JLabel("Dossier contenant les fichiers");
	 JLabel MotifFichier = new JLabel("Motif des fichiers");
	 JLabel Remplace = new JLabel("à remplacer par");
    public test2()
    {
    	 	this.setTitle("Qui que c'est ?");
    	    this.setSize(300, 300);
    	    this.setLocationRelativeTo(null);  
    	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	    JPanel pan = new JPanel();
    	    pan.setBackground(Color.white);        
    	    this.setContentPane(pan);
            jtf.setPreferredSize(new Dimension(150, 30));
            jtf2.setPreferredSize(new Dimension(150, 30));
            jtf3.setPreferredSize(new Dimension(150, 30));
    	    pan.add(NomDossier);
            pan.add(jtf);
            pan.add(MotifFichier);
            pan.add(jtf2);
            pan.add(Remplace);
            pan.add(jtf3);
            getContentPane().add(new JButton("xShogo"));
            getContentPane().add(new JButton("Shetesh"));
            getContentPane().add(new JButton("An ahir"));
    }

    public void affiche()
    {
        setVisible(true);
    }

    public static void main(String[] args)
    {
        test2 f = new test2();
        f.affiche();
    }
}