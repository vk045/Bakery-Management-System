import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class CreateCust extends Customer
{
    public void signupPage()
    {
        Login l1 = new Login();
        Scanner s = new Scanner(System.in);
        System.out.println("Create Your Account");
        Customer cust2 = new Customer();
        cust2.setCust();
        cust2.show();
        System.out.println("\n\n\n");
        System.out.println("Enter 1: Confirm Details and Create Your Account!"); //Send to the Database!!! and then directly login!!!
        System.out.println("Enter 2: Discard and redirect to Create Customer Page: ");
        System.out.println("Enter 2: Exit the application: ");
        System.out.print("Enter your choice: ");
        int ch = s.nextInt();
        switch (ch)
        {
            case 1:
                try
                {
                    FileWriter fw = new FileWriter("C:\\Users\\Awesome\\Desktop\\jv\\BAKERY12345\\src\\cred.txt",true);
                    String inst;
                    inst = cust2.insertionstatement();
                    for (int i = 0; i < inst.length(); i++) {
                        fw.write(inst.charAt(i));
                    }
                    fw.write("\n");
                    fw.close();
                    l1.loginMethod();
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