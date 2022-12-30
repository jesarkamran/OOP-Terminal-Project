import java.io.*;

public class Serialization <T> 
{
    private File file;
    Serialization(File file)
    {
        this.file = file;
    }
    public File getFile() {
        return file;
    }
    public  void dataWriting(T obj, boolean append)
    {
        ObjectOutputStream objOut = null;
        try 
        {
            File file = getFile();
            if (file.exists()) 
            {
                objOut = new MyObjectOutputStream(new FileOutputStream(file, append));
                objOut.writeObject(obj);
            }
            else
            {
                objOut = new ObjectOutputStream(new FileOutputStream(file, append));
                objOut.writeObject(obj);
            }
        } catch (IOException e) {
            //TODO: handle exception
            System.out.println(e); e.printStackTrace();
        }
        finally
        {
            try
            {
                objOut.close();
            }catch (Exception e) {
            //TODO: handle exception
            System.out.println(e); e.printStackTrace();
            }
        }
    }
   
    public boolean deleteFile()
    {
        boolean del = getFile().delete();
        if (del) 
        {
            return true;
        }
        return false;
    }
}
