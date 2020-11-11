package model;

public class Car {
    private String rgdNo;
    private String age;

    public String getRgdNo(){
        return rgdNo;
    }
    public String getAge(){
        return age;
    }
    public Car(String rgdNo,String age)
    {
        this.age=age;
        this.rgdNo=rgdNo;
    }
}
