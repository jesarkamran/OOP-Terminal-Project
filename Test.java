import java.io.*;;
public class Test 
{
    public static void main(String[] args) 
    {
    //     BankAccounts b1 = new BankAccounts("Kamran", 1111222233334444L, 10000);
    //     BankAccounts b2= new BankAccounts("Kamran", 2222333344445555L, 10000);
    //     BankAccounts b3 = new BankAccounts("Kamran", 3333444455557777L, 10000);
        BankAccounts b3 = new BankAccounts("Ali", 4444555577778888L, 10000);
        BillData b = new BillData(33333, "Utility Bill");
        Serialization<BillData> ser = new Serialization<>(new File("BillID.ser"));
        // ser.dataWriting(b1, true);
        // ser.dataWriting(b2, true);
        ser.dataWriting(b, true);

        // b3.dataReading();
    }
}
