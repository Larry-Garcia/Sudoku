import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class login extends JPanel implements ActionListener{

    private JButton loginButton, newAccount;
    private JTextField user, pass;
    private JLabel name, userField, passField;

    public login(){

        JPanel main = new JPanel();
        JPanel title = new JPanel();
        JPanel userName = new JPanel();
        JPanel password = new JPanel();
        JPanel button = new JPanel();
        JPanel space = new JPanel();

        loginButton = new JButton("Login");//creating login button 
        loginButton.addActionListener(this);//monitor if clicked
        newAccount = new JButton("Create new account");
        newAccount.addActionListener(this);

        name = new JLabel("Login");
        name.setFont(new Font("Arial", Font.BOLD, 40));//resizing text within label
        userField = new JLabel("Username: ");
        userField.setFont(new Font("Arial", Font.PLAIN, 15));
        passField = new JLabel("Password: ");
        passField.setFont(new Font("Arial", Font.PLAIN, 15));

        user = new JTextField(20);//create text field for username
        pass = new JTextField(20);//create text field for password

         //adding elements into the panels
         title.add(name);
         userName.add(userField);
         userName.add(user);
         password.add(passField);
         password.add(pass);
         button.add(loginButton);
         button.add(newAccount);

         //panel layout
         main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
         main.add(title);
         main.add(space);
         main.add(userName);
         main.add(password);
         main.add(space);
         main.add(button);

         //blocks user from clicking login when username and password fields are empty 
        loginButton.setEnabled(false);

         //for checking jtextfields 
         DocumentListener docListener = new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e){
                checkForText();
            }
            @Override
            public void insertUpdate(DocumentEvent e){
                checkForText();
            }
            @Override
            public void changedUpdate(DocumentEvent e){
                checkForText();
            }

            private void checkForText(){
                boolean filled = !user.getText().trim().isEmpty() && !pass.getText().trim().isEmpty();
                loginButton.setEnabled(filled);
            }
        };
        //adding document listener to both username and password fields 
        user.getDocument().addDocumentListener(docListener);
        pass.getDocument().addDocumentListener(docListener);

        //for displaying 
        add(main);

        //displaying panel
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        //if press login button, transfers to Main Page
        if(e.getSource() == loginButton){
            controller.getInstance().changeCard("Main Page");
        }
        //if press new account button, transfers to account creation page
        else if(e.getSource() == newAccount){
            controller.getInstance().changeCard("Create Account");
        }
        //clearing textfields when ever leaving screen
        user.setText("");
        pass.setText("");
    }//end of action preformed
}


