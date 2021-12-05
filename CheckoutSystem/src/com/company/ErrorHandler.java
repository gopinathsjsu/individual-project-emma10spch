package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

public class ErrorHandler {
    private ArrayList<String> errRes;

    public ErrorHandler(ArrayList<String> arrayList) {
        errRes = arrayList;
    }

    public void process(){
        try{
            FileWriter myWriter = new FileWriter("Errors.txt");
            myWriter.write("Please correct quantities.\n");

            for(String s : errRes) {
                String[] strArr = s.split("~");
                myWriter.write(strArr[0] + ", " + strArr[1] + "\n");
            }

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
