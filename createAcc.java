import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class createAcc extends JPanel implements ActionListener{

    private JButton back, signUp;
    private JLabel prompt, userField, passField, emailField, passConfirm, blank1, blank2;
    private JTextField username, email, password, passwordConfirm;
    
    public createAcc(){

        //Panel for template
        JPanel main = new JPanel();
        JPanel title = new JPanel();
        JPanel userName = new JPanel();
        JPanel emailAcc = new JPanel();
        JPanel passWord = new JPanel();
        JPanel confirm = new JPanel();
        JPanel button = new JPanel();
        JPanel space1 = new JPanel();
        JPanel space2 = new JPanel();
    
        //buttons needed
        back = new JButton("Back");
        back.addActionListener(this);

        signUp = new JButton("Sign Up");
        signUp.addActionListener(this);

        prompt = new JLabel("Create Account");
        prompt.setFont(new Font("Arial", Font.PLAIN, 20));//resizing text within label
        userField = new JLabel("Username: ");
        userField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailField = new JLabel("Email: ");
        emailField.setFont(new Font("Arial", Font.PLAIN, 15));
        passField = new JLabel("Password: ");
        passField.setFont(new Font("Arial", Font.PLAIN, 15));
        passConfirm = new JLabel("Confirm Password: ");
        passConfirm.setFont(new Font("Arial", Font.PLAIN, 15));
        blank1 = new JLabel("");
        blank2 = new JLabel("");

        //creating textFields
        username = new JTextField(20);
        email = new JTextField(20);
        password = new JTextField(20);
        passwordConfirm = new JTextField(20);

        signUp.setEnabled(false);

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
                Boolean filled = !username.getText().trim().isEmpty() && !email.getText().trim().isEmpty() && !password.getText().trim().isEmpty() && !passwordConfirm.getText().trim().isEmpty();
                if(filled){
                    if(password.getText().equals(passwordConfirm.getText())){
                        signUp.setEnabled(filled);
                    }
                    else {
                        signUp.setEnabled(false);
                    }
                }
            }
        };

        //adding document listener to both username and password fields 
        username.getDocument().addDocumentListener(docListener);
        email.getDocument().addDocumentListener(docListener);
        password.getDocument().addDocumentListener(docListener);
        passwordConfirm.getDocument().addDocumentListener(docListener);

       //creating grid layout for middle panels format
       title.add(prompt);
       space1.add(blank1);
       space2.add(blank2);

       userName.setLayout(new GridLayout());
       userName.add(userField);
       userName.add(username);

       emailAcc.setLayout(new GridLayout());
       emailAcc.add(emailField);
       emailAcc.add(email);

       passWord.setLayout(new GridLayout());
       passWord.add(passField);
       passWord.add(password);

       confirm.setLayout(new GridLayout());
       confirm.add(passConfirm);
       confirm.add(passwordConfirm);

       button.add(back);
       button.add(signUp);

       main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
       main.add(title);
       main.add(space1);
       main.add(userName);
       main.add(emailAcc);
       main.add(passWord);
       main.add(confirm);
       main.add(space2);
       main.add(button);

        //for displaying 
        add(main);

        //displaying panel
        setVisible(true);
        setSize(500, 500);
        
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == signUp){
            controller.getInstance().changeCard("Main Page");
        }
        else if(e.getSource() == back){
            controller.getInstance().changeCard("Login");
        }
        //resetting entered fields to empty 
        username.setText("");
        email.setText("");
        password.setText("");
        passwordConfirm.setText("");
        signUp.setEnabled(false);//set signup button to false after leaving panel to do
    }

}


