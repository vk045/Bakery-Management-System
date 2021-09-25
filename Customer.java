import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Customer
{
    String cname;
    String cadd;
    String cphno;
    String cloginid;
    String cpass;
    public void loginPage()
    {
        String Username;
        String Password;
        boolean found = false;
        String tempUsername="";
        String password1="";

        Customer cust1 = new Customer();
        Scanner s;
        Scanner s1 = new Scanner(System.in);
        System.out.println("<<<<Customer Login>>>>");
        System.out.println("Enter ID: ");
        Username = s1.nextLine();
        System.out.println("Enter Password: ");
        Password = s1.nextLine();
        try
        {
            s = new Scanner(new File("C:\\Users\\Awesome\\Desktop\\jv\\BAKERY12345\\src\\cred.txt"));
            s.useDelimiter("[,,]");
            while(s.hasNext()&&!found)
            {
                tempUsername=s.next();
                password1=s.next();
                if(tempUsername.trim().equals(Username.trim())&&password1.trim().equals(Password.trim()))
                {
                    found=true;
                }
            }
            s.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if(found == true)
        {
            menu(Username,Password);
        }
        else
        {
            System.out.println("INVALID LOGIN CREDENTIALS!!!! TRY AGAIN");
            cust1.loginPage();
        }

    }

    public void menu(String username, String password)
    {
        try {
            int choice;
            int id;
            int quantity;

            Scanner s = new Scanner(System.in);
            do
                {
                System.out.println("PRESS 1 TO PLACE ORDER");
                System.out.println("PRESS 2 TO EXIT");

                choice = s.nextInt();
                if (choice == 1)
                {
                    System.out.println("PLEASE PLACE YOUR ORDER BY LOOKING AT THE MENU");
                    System.out.println("ID    NAME OF THE ITEM           PRICE");
                    System.out.println("1     CHOCOLATE  CAKE             400");
                    System.out.println("2     STRAWBERRY CAKE             350");
                    System.out.println("3     PINEAPPLE  CAKE             300");
                    System.out.println("4     CHOCOLATE  COOKIES          100/KG");
                    System.out.println("5     STRAWBERRY COOKIES           80/KG");
                    System.out.println("6     BUTTERSCOTCH COOKIES          60/KG");
                    System.out.println("7     WHITE BREAD                 40");
                    System.out.println("8     BROWN BREAD                 30");
                    System.out.println("Enter the ID of the item: ");
                    id = s.nextInt();
                    System.out.println("Enter the quantity: ");
                    quantity = s.nextInt();
                    int bill = 0;
                    if (id == 1)
                    {
                        bill = 400 * quantity;
                    }
                    if (id == 2)
                    {
                        bill = bill + 350 * quantity;
                    }
                    if (id == 3)
                    {
                        bill = bill + 300 * quantity;
                    }
                    if (id == 4)
                    {
                        bill = bill + 100 * quantity;
                    }
                    if (id == 5)
                    {
                        bill = bill + 80 * quantity;
                    }
                    if (id == 6)
                    {
                        bill = bill + 60 * quantity;
                    }
                    if (id == 7)
                    {
                        bill = bill + 40 * quantity;
                    }
                    if (id == 8)
                    {
                        bill = bill + 30 * quantity;
                    }
                    System.out.println("Your bill is: "+bill);
                    File f = new File("C:\\Users\\Awesome\\Desktop\\jv\\BAKERY12345\\src\\Orders.txt");
                    FileWriter fw = new FileWriter("C:\\Users\\Awesome\\Desktop\\jv\\BAKERY12345\\src\\Orders.txt",true);
                    fw.write(username+","+id+","+quantity+","+bill);
                    fw.write("\r\n");
                }

                if (choice == 2)
                {
                    Login l3 = new Login();
                    l3.loginMethod();
                    break;
                }
            } while (choice != 3);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void setCust()
    {
        try
        {
            boolean flag = false;
            Scanner s = new Scanner(System.in);
            System.out.println("Enter your name: ");
            cname = s.nextLine();
            System.out.println("Enter your address: ");
            cadd = s.nextLine();
            System.out.println("Enter your contact number: ");
            cphno = s.nextLine();
            System.out.println("Enter your login id: ");
            cloginid = s.nextLine();
            System.out.println("Enter your password: ");
            cpass = s.nextLine();
            if(isValid(cphno))
            {
                flag = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void show()
    {
        System.out.println("Your details are as followed: ");
        System.out.println("Name: "+cname+"\nAddress: "+cadd+"\nContact number: "+cphno+"\nLogin id: "+cloginid+"\nPassword: "+cpass);
    }
    public static boolean isValid(String s)
    {
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }

    protected String insertionstatement()
    {
        String inst = cloginid+","+cpass+","+cname+","+cadd+","+cphno;
        return inst;
    }
}
