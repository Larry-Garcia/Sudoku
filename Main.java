import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

public class Main extends JPanel implements ActionListener{
 private JLabel welcome;
 private JButton play;
 
    public Main(){
        //creating welcome label
        JPanel titlePanel = new JPanel();

       welcome = new JLabel("Sudoku");
       welcome.setFont(new Font("Arial", Font.BOLD, 40));
       welcome.setForeground(Color.white);

play = new JButton("Play Sudoku!");
play.addActionListener(this);
play.setPreferredSize(new Dimension(150, 35));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
} 