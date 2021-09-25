import java.util.InputMismatchException;
import java.util.Scanner;

class Login
{
    public static void loginMethod()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("<<<<LOGIN>>>>");
        System.out.println("Press\n1.Customer login \n2.Owner login \n3.Signup \n4.Exit the application");
        System.out.println("\nEnter your choice: ");
        try
        {
            int ch = s.nextInt();
            switch (ch)
            {
                case 1:
                    Customer cust = new Customer();
                    cust.loginPage();
                    break;
                case 2:
                    Boss b = new Boss();
                    b.loginPage();
                    break;
                case 3:
                    System.out.println("Press\n1.Create Customer Account \n2.Create Owner Account");
                    int c = s.nextInt();
                    switch (c)
                    {
                        case 1:
                            CreateCust cc = new CreateCust();
                            cc.signupPage();
                            break;
                        case 2:
                            CreateOwner co = new CreateOwner();
                            co.signupPage();
                            break;
                    }
                    break;
                case 4:
                    System.exit(0);

            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Enter Valid Choice!");
            loginMethod();
        }
    }
}
