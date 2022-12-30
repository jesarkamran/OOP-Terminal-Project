import java.io.*;
import java.util.ArrayList;

public class BankAccounts implements Serializable
{
    private String accountHolderName;
    private long accountNo; private double amountInAccount;
    BankAccounts(){}
    BankAccounts(String accountHolderName, long accountNo, double amountInAccount)
    {
        String strAccountNo = ""+accountNo;
        if (accountHolderName != null && strAccountNo.length() == 16 && amountInAccount > 0) 
        {
            this.accountHolderName = accountHolderName;
            this.accountNo = accountNo; this.amountInAccount = amountInAccount;
        }
        else
        {
            System.out.println("Can't Initialize values with Ivalid Data");
        }
    }

    //getters
    public String getAccountHolderName() 
    {
        return accountHolderName;
    }
    public long getAccountNo() 
    {
        return accountNo;
    }public double getAmountInAccount() 
    {
        return amountInAccount;
    }
    public void setAmountInAccount(Double amountInAccount) {
        this.amountInAccount = amountInAccount;
    }
    @Override
    public String toString() {
        return ("Account Holder Name: "+getAccountHolderName()+"\n"+
                "Account Number: "+getAccountNo()+"\n"+
                "Amount In Account"+getAmountInAccount());
    }
   
    public ArrayList<BankAccounts> dataReading() 
    {        
        ArrayList<BankAccounts> list = readInFile();
        for (BankAccounts obj : list) 
        {
            System.out.println(obj.toString());
        }
        return list;
    }
    ObjectInputStream objectInputStream;
    public ArrayList<BankAccounts> readInFile()
    {
        ArrayList<BankAccounts> list = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("Accounts.ser"));
            while (true) 
            {
                list.add((BankAccounts) objectInputStream.readObject());
            }
        }catch (Exception e)
        {
            return list;
        }
    }
    
}
