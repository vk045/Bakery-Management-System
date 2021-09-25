import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Boss
{
    String bname;
    String badd;
    String bphno;
    String bloginid;
    String bpass;

    public void loginPage()
    {
        String Username;
        String Password;
        boolean found = false;
        String tempUsername = "";
        String password1 = "";

        Boss b1 = new Boss();
        Scanner s;
        Scanner s1 = new Scanner(System.in);
        System.out.println("<<<<Owner Login>>>>");
        System.out.println("Enter ID: ");
        Username = s1.nextLine();
        System.out.println("Enter Password: ");
        Password = s1.nextLine();
        try
        {
            s = new Scanner(new File("C:\\Users\\Awesome\\Desktop\\jv\\BAKERY12345\\src\\ownercred.txt"));
            s.useDelimiter("[,,]");
            while (s.hasNext() && !found)
            {
                tempUsername = s.next();
                password1 = s.next();
                if (tempUsername.trim().equals(Username.trim()) && password1.trim().equals(Password.trim()))
                {
                    found = true;
                }
            }
            s.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if (found == true)
        {
            menu(Username,Password);
        }
        else
            {
            System.out.println("INVALID LOGIN CREDENTIALS!!!! TRY AGAIN");
            b1.loginPage();
        }
    }

    public void menu(String username, String password)
    {
        Scanner s;
        try
        {
            s = new Scanner(new File("C:\\Users\\Awesome\\Desktop\\jv\\BAKERY12345\\src\\Orders.txt"));
            s.useDelimiter("[,,,]");
            while (s.hasNext())
            {
                String data = s.next();
                System.out.println(data);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setBoss()
        {
            try {
                boolean flag = false;
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your name: ");
                bname = sc.nextLine();
                System.out.println("Enter your address: ");
                badd = sc.nextLine();
                System.out.println("Enter your contact number: ");
                bphno = sc.nextLine();
                System.out.println("Enter your login id: ");
                bloginid = sc.nextLine();
                System.out.println("Enter your password: ");
                bpass = sc.nextLine();
                if (isValid(bphno))
                {
                    flag = true;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        public static boolean isValid(String bphno)
        {
            Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
            Matcher m = p.matcher(bphno);
            return (m.find() && m.group().equals(bphno));
        }

        public String insertionstatement ()
        {
            String inst = bloginid + "," + bpass + "," + bname + "," + badd + "," + bphno;
            return inst;
        }
        public void show ()
        {
            System.out.println("Your details are as followed: ");
            System.out.println("Name: " + bname + "\nAddress: " + badd + "\nContact number: " + bphno + "\nLogin id: " + bloginid + "\nPassword: " + bpass);
        }
    }

