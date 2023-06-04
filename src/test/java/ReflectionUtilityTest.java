import InputModel.RawInputData1;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtilityTest {
    public static void main(String[] args) {
        RawInputData1 rawInputData1 = new RawInputData1();
        Field[] inputVar1= RawInputData1.class.getDeclaredFields();
        System.out.println(inputVar1[0].getName());
        String propertyName= inputVar1[0].getName();

        try{
            PropertyDescriptor pd = new PropertyDescriptor(propertyName,rawInputData1.getClass());
            Method setter = pd.getWriteMethod();
            setter.invoke(rawInputData1,"Some Value for Var1");
            System.out.println(rawInputData1.getVar1());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
