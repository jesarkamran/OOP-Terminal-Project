import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class BillData implements Serializable
{
    private int billId;
    private String billType;

    BillData(){}
    BillData(int billId, String billType)
    {
        if ((""+billId).length() == 5 && billType != null) 
        {
            this.billId = billId; this.billType = billType;
        }
        else
        {
            System.out.println("Invalid Data given!! to Initialize Data");
        }
    }

    public int getBillId() 
    {
        return billId;
    }
    public void setBillId(int billId) 
    {
        if ((""+billId).length() == 5)
        {
            this.billId = billId;
        }
        else
        {
            System.out.println("Invalid Data given!! to Initialize Data");
        }
    }

    public String getBillType() 
    {
        return billType;
    }
    public void setBillType(String billType) 
    {
        if (billType != null)
        {
            this.billType = billType;
        }
        else
        {
            System.out.println("Invalid Data given!! to Initialize Data");
        }
    }

    @Override
    public String toString() {
        return ("Bill ID: "+getBillId()+"\n"+
                "BIll Type: "+getBillType()+"\n");
    }

    ObjectInputStream objectInputStream;
    public ArrayList<BillData> readInFile()
    {
        ArrayList<BillData> list = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("BillID.ser"));
            while (true) 
            {
                list.add((BillData) objectInputStream.readObject());
            }
        }catch (Exception e)
        {
            return list;
        }
    }
    
}
