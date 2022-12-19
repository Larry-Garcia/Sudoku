 
import java.awt.CardLayout;
import javax.swing.*;
import java.awt.*;

public class controller extends JPanel{
    
    private static controller instance;

    JPanel cardLayout; //create panel of cards
    
    login loginPanel;
    Main mainPanel;
    createAcc createAccPanel;

    public controller(){
        setSize(500,500);
        cardLayout = new JPanel(new CardLayout());

        loginPanel = new login();
        mainPanel = new Main();
        createAccPanel = new createAcc();

        cardLayout.add(loginPanel, "Login");
        cardLayout.add(mainPanel, "Main Page");
        cardLayout.add(createAccPanel, "Create Account");

        add(cardLayout);
        setVisible(true);
    }

    private static void displayPanel(){
        JFrame title = new JFrame("Project");

        instance = new controller();

        title.getContentPane().add(instance);
        title.setSize(500,500);
        title.setVisible(true);
    }

    public void changeCard(String cards){
        CardLayout card = (CardLayout)(cardLayout.getLayout());
        card.show(cardLayout, cards);
    }


    public static controller getInstance(){
        return instance;
    }
    public static void main(String[] args){
        displayPanel();
    }
}