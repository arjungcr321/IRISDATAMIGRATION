package ExcelReader;

import InputModel.RawInputData;
import InputModel.RawInputData1;
import InputModel.RawInputData2;

public class FinalRawInputDataReader extends RawInputDataReader {
    @Override
    public RawInputData2 readFromAAtoZZ() {

        return null;
    }

    @Override
    public RawInputData1 readFromAtoZ() {
    RawInputData1 rawInputData1 = new RawInputData1();
     for(int count=columnA;count<=columnZ;count++){
     initializeSetter(rawInputData1,count,"Fetched Column value");}
     return  rawInputData1;
    }

    public RawInputData readFile() {
        //   for(row1 to row.size()){

    //}
        return new RawInputData();
    }
}
