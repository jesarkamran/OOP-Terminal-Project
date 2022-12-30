import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Accounts extends User implements Serializable
{   
    private int password; private double amountInAccount;
    private long phoneNo, cnic;
    Accounts(){super();}
    Accounts(String name, String LocationCity, String address, int age, long phoneNo, long cnic, int password, double amountInAccount)
    {
        super(name,LocationCity,address,age);
        String strPhone = ""+phoneNo;
        String strCnic = ""+cnic;
        String strPassword = ""+password;
        if (strPhone.length() == 10 && strCnic.length() == 13 && strPassword.length()==4 && amountInAccount > 0)
        {
            this.phoneNo = phoneNo; this.cnic = cnic;
            this.password = password; this.amountInAccount = amountInAccount;
        }
        else
        {
            System.out.println("Can't Initialize values with Ivalid Data");
        }
    }
    //setters
    public void setPhoneNo(long phoneNo) 
    {
        this.phoneNo = phoneNo;
    }
    public void setPassword(int password) 
    {
        this.password = password;
    }
    public void setCnic(long cnic) 
    {
        this.cnic = cnic;
    }
    public void setAmountInAccount(double amountInAccount) 
    {
        this.amountInAccount = amountInAccount;
    }
    
    //getters
    public long getPhoneNo() 
    {
        return phoneNo;
    }
    public int getPassword() 
    {
        return password;
    }
    public long getCnic() 
    {
        return cnic;
    }
    public double getAmountInAccount() 
    {
        return amountInAccount;
    }

    @Override
    public String toString() {
        return (super.toString()+
                "Amount in Account: "+getAmountInAccount()+"\n"+
                "Account No: "+getPhoneNo()+"\n"+
                "CNIC No: "+getCnic()+"\n");
    }
    
    ObjectInputStream objectInputStream;
    public ArrayList<Accounts> readInFile()
    {
        ArrayList<Accounts> list = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("EasyAccounts.ser"));
            while (true)
            {
                list.add((Accounts) objectInputStream.readObject());
            }
        }catch (ClassNotFoundException e){
            return  list;
        }catch (EOFException e){
            return list;
        }
        catch (Exception e)
        {
            return list;
        }
    }
}
