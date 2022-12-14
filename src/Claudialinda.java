import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

public class Claudialinda extends JFrame {

    private ImageIcon imageIcon = new ImageIcon("crud/claudia.png");
    private JRadioButton linda, clamaisMenos, sim, nao;
    private ButtonGroup grupo1, grupo2;
    private RadioButtonHandler handler;
    private JLabel myLabel, myLabel2;

    public Claudialinda() {
        super("Testando JRadioButton");
        setLayout(new FlowLayout());
        handler = new RadioButtonHandler();
        myLabel = new JLabel("Essa professora é ?");
        myLabel2 = new JLabel("\nVocê tem certeza disso?");
        linda = new JRadioButton("Linda", false);
        clamaisMenos = new JRadioButton("mias ou menos", false);
        sim = new JRadioButton("Sim", false);
        nao = new JRadioButton("Não", false);

        Container pane1 = this.getContentPane();
        pane1.setLayout(new GridLayout(3, 1));

        JPanel pane3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        imageIcon = new ImageIcon(newimg);
        JLabel label = new JLabel(imageIcon);

        pane1.add(pane3);
        pane1.add(label);

        add(myLabel);
        add(linda);
        add(clamaisMenos);
        add(myLabel2);
        add(sim);
        add(nao);
            
        grupo1 = new ButtonGroup();
        grupo1.add(linda);
        grupo1.add(clamaisMenos);
            
        grupo2 = new ButtonGroup();
        grupo2.add(sim);
        grupo2.add(nao);
            
        linda.addItemListener((ItemListener) handler);
        clamaisMenos.addItemListener((ItemListener)handler);
        sim.addItemListener((ItemListener) handler);
        nao.addItemListener((ItemListener)handler);

    }

    private class RadioButtonHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent event) {
         if(linda.isSelected() && sim.isSelected())
          JOptionPane.showMessageDialog(null,"Parabéns, você é o cara");
         if(clamaisMenos.isSelected() && sim.isSelected())
          JOptionPane.showMessageDialog(null,"Sabe de nada, inocente!");
        }
        
       }

    

    public static void main(String[] args) {
        Claudialinda janela = new Claudialinda();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(500, 5);
        janela.setResizable(true);
        janela.setVisible(true);
    }
}