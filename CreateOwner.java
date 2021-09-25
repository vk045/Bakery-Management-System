import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class CreateOwner extends Boss
{
    public void signupPage()
    {
        Login l2 = new Login();
        Scanner s = new Scanner(System.in);
        System.out.println("Create Your Account");
        Boss b2 = new Boss();
        b2.setBoss();
        b2.show();
        System.out.println("\n\n\n");
        System.out.println("Enter 1: Confirm Details and Create Your Account!"); //Send to the Database!!! and then directly login!!!
        System.out.println("Enter 2: Discard and redirect to Create Customer Page: ");
        System.out.println("Enter 3: Exit the application: ");
        System.out.print("Enter your choice: ");
        int ch = s.nextInt();
        switch (ch)
        {
            case 1:
                try
                {
                    FileWriter fw = new FileWriter("C:\\Users\\Awesome\\Desktop\\jv\\BAKERY12345\\src\\ownercred.txt",true);
                    String inst;
                    inst = b2.insertionstatement();
                    for (int i = 0; i < inst.length(); i++) {
                        fw.write(inst.charAt(i));

                    }
                    fw.write("\n");
                    fw.close();
                    l2.loginMethod();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 2:
                signupPage();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}