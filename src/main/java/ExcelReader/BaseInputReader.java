package ExcelReader;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseInputReader {

    public void invokeSetter(Object obj, String propertyName, Object variableValue)
    {
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(propertyName, obj.getClass());
            Method setter = pd.getWriteMethod();
            try {
                setter.invoke(obj,variableValue);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch ( IntrospectionException e) {
            e.printStackTrace();
        }

    }

}
