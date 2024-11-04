import javax.swing.JOptionPane; //JOptionPane used to take user input and display messages
import java.util.Objects;


public class App
{

    public static void main(String[] args)
    {

        //Ask user for their name
        String Name = JOptionPane.showInputDialog("Enter your first name:");
        //Ask user for their username
        String Surname = JOptionPane.showInputDialog("Enter your last name:");
        //lets me get username variable's input later for login
        String username; //lets me take input for later

        boolean checkUserName;
        do
        {

            username = JOptionPane.showInputDialog("Create username that contains: \nAn underscore_ \n5 characters");
            int userSize = username.length(); //get user length

            boolean checkUserLength = userSize >= 5; //make sure user is 5 characters long
            boolean checkUserSpecial = false; //set the character is _ condition to false so the base state is false

            for (char UsernameCharacters : username.toCharArray()) //goes over each character in the username
            {
                if ("_".contains(String.valueOf(UsernameCharacters))) //checks if the character in the username is an _ by converting each character to a string
                {
                    checkUserSpecial = true;
                    break;
                }
            }

            checkUserName = checkUserLength && checkUserSpecial;


            if (checkUserName)
            {
                String registerUser = "Username successfully captured";
                //When the username is right then say success message
                JOptionPane.showMessageDialog(null, registerUser);
            }
            else
            {
                String registerUser = "Username is not correctly formatted.\nPlease ensure that your username contains: \nAn underscore \n5 characters";
                //When the username isn't right then say fail message
                JOptionPane.showMessageDialog(null, registerUser);
            }
        }
        while (!checkUserName);





        String password; //So I can grab the password for later
        boolean checkPasswordComplexity;

         do
         {

            password = JOptionPane.showInputDialog("""
                    Create password, your password must be:
                    8 characters
                    a capital letter
                    a number
                    a special character.""");
            int passwordSize = password.length();

            boolean checkPasswordLength = passwordSize >= 8; //checks password length
            boolean checkPasswordSpecial = false;
            boolean checkPasswordCapital = false;
            boolean checkPasswordNumber = false;

            for (char PasswordCharacters : password.toCharArray())
            {
                if ("!@#$%^&*<>?".contains(String.valueOf(PasswordCharacters)))
                { //check for special characters that can be typed by a computer keyboard
                    checkPasswordSpecial = true;
                }
                else if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(String.valueOf(PasswordCharacters)))
                { //check for capital letter
                    checkPasswordCapital = true;
                }
                else if ("1234567890".contains(String.valueOf(PasswordCharacters)))
                { //check for number
                    checkPasswordNumber = true;
                }
            }

            checkPasswordComplexity = checkPasswordLength && checkPasswordSpecial && checkPasswordCapital && checkPasswordNumber;

            if (checkPasswordComplexity)
            {
                String registerUser = "Password successfully captured";
                //if password is good show success message
                JOptionPane.showMessageDialog(null, registerUser);
            }
            else
            {
                String registerUser = """
                        Password is not correctly formatted,\s
                        please ensure that the password contains at least:
                        8 characters
                        a capital letter
                        a number
                        a special character.""";
                //if password isn't good show fail message
                JOptionPane.showMessageDialog(null, registerUser);
            }
         }
         while (!checkPasswordComplexity);






        boolean checkLogIn = false;
        do //do while loop so that the user only has to redo the incorrect thing and not everything
        {
            String UsernameLogin = JOptionPane.showInputDialog("Welcome! Please enter your username to log in:");
            boolean UsernameCorrect = Objects.equals(UsernameLogin, username);

            if (!UsernameCorrect)
            {
                String LoginFail = "Your Username is incorrect. Please try again.";
                JOptionPane.showMessageDialog(null, LoginFail);
                continue;
            }

            String PasswordLogin = JOptionPane.showInputDialog("Welcome! Please enter your password to log in");
            boolean PasswordCorrect = Objects.equals(PasswordLogin, password);

            if (!PasswordCorrect)
            {
                String LoginFail = "Your password is incorrect. Please try again.";
                JOptionPane.showMessageDialog(null, LoginFail);
                continue;
            }

            checkLogIn = UsernameCorrect && PasswordCorrect;

        }
        while (!checkLogIn);

        String LoginSuccess = "Welcome " + Name + " " + Surname + "! Good to see you again!";
        JOptionPane.showMessageDialog(null, LoginSuccess);

    }

}
