import java.io.Serializable;

public abstract class User implements Serializable
{
    private String name, LocationCity, address;
    private int age;
    User(){}
    User(String name, String LocationCity, String address, int age)
    {
        if (name!=null&&LocationCity!=null&&address!=null&&age>18) 
        {
            this.name = name; this.LocationCity = LocationCity;
            this.address = address; this.age = age;
        }
        else
        {
            System.out.println("Parent: Can't Initialize values with Invalid Data");
        }
    }

    //setters
    public void setName(String name) 
    {
        this.name = name;
    }
    public void setLocationCity(String locationCity) 
    {
        LocationCity = locationCity;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }
    public void setAge(int age) 
    {
        this.age = age;
    }

    //getters
    public String getName() 
    {
        return name;
    }
    public String getLocationCity() 
    {
        return LocationCity;
    }
    public String getAddress() 
    {
        return address;
    }
    public int getAge() 
    {
        return age;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return ("User Name: "+getName()+"\n"+
                "User Age: "+getAge()+"\n"+
                "User Address: "+getAddress()+"\n"+
                "User City: "+getLocationCity()+"\n");
    }
}
