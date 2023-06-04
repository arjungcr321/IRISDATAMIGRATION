package ExcelReader;

import InputModel.RawInputData;
import InputModel.RawInputData1;

import java.lang.reflect.Field;

public abstract class RawInputDataReader extends BaseInputReader implements AtoZ,AAtoAZ {
    public abstract RawInputData readFile();
    Field[] inputRawData1Variables;
    Field[] inputRawData2Variables;

    {
         inputRawData1Variables = RawInputData1.class.getDeclaredFields();
         inputRawData2Variables = RawInputData1.class.getDeclaredFields();

    }

        public void initializeSetter(Object obj, Integer propertyId, Object variableValue) {
        String propertyName = inputRawData1Variables[propertyId].getName();
        super.invokeSetter(obj, propertyName, variableValue);
    }
}