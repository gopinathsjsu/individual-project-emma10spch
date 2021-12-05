package com.company;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class CheckoutSystem {
    private HashMap<String, Integer> itemQuantMap = new HashMap<String, Integer>();
    private HashMap<Category, Integer> categoryCapMap = new HashMap<Category, Integer>();
    private HashMap<String, Double> itemPriceMap = new HashMap<String, Double>();
    private HashMap<String, String> itemToCategoryMap = new HashMap<String, String>();
    private HashSet<String> creditCardSet = new HashSet<String>();
    private String COMMA_DELIMITER = ",";

    public void loadDB() {
        loadDataSet();
        loadConfig();
        loadCreditCard();
    }

    private void loadDataSet(){
        System.out.println("Please input the file name of dataset:\n(Press [Enter] to load the default \"Dataset - Sheet1.csv\")");
        Scanner in = new Scanner(System.in);
        boolean foundFile = false;
        while(!foundFile) {
            String fileName = in.nextLine();

            if(fileName.isEmpty()) {
                fileName = "Dataset - Sheet1.csv";
            }

            try {
                File myFile = new File(fileName);
                Scanner fileInput = new Scanner(myFile);
                foundFile = true;

                fileInput.nextLine();   //skip the header
                while(fileInput.hasNextLine()) {
                    try (Scanner rowScanner = new Scanner(fileInput.nextLine())) {
                        rowScanner.useDelimiter(COMMA_DELIMITER);
                        ArrayList<String> tmpArr = new ArrayList<>();
                        while(rowScanner.hasNext()) {
                            tmpArr.add(rowScanner.next());
                        }

                        itemToCategoryMap.put(tmpArr.get(1), tmpArr.get(0));
                        itemQuantMap.put(tmpArr.get(1), Integer.valueOf(tmpArr.get(2)));
                        itemPriceMap.put(tmpArr.get(1), Double.valueOf(tmpArr.get(3)));
                    }
                }
            } catch(FileNotFoundException e){
                System.out.println("No such file. Please enter the correct file name:");
            }
        }
    }

    private void loadConfig() {
        System.out.println("Loading default config from \"config.csv\"\n");
        try {
            File myFile = new File("config.csv");
            Scanner fileInput = new Scanner(myFile);

            while (fileInput.hasNextLine()) {
                try (Scanner rowScanner = new Scanner(fileInput.nextLine())) {
                    rowScanner.useDelimiter(COMMA_DELIMITER);
                    ArrayList<String> tmpArr = new ArrayList<>();
                    while (rowScanner.hasNext()) {
                        tmpArr.add(rowScanner.next());
                    }
                    Item curItem;
                    if (tmpArr.get(0).equals("Essential")) {
                        categoryCapMap.put(Category.Essential, Integer.valueOf(tmpArr.get(1)));
                    } else if (tmpArr.get(0).equals("Luxury")) {
                        categoryCapMap.put(Category.Luxury, Integer.valueOf(tmpArr.get(1)));
                    } else {
                        categoryCapMap.put(Category.Misc, Integer.valueOf(tmpArr.get(1)));
                    }
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("No such file. Please make sure config file \"config.csv\" is located properly.");
        }
    }

    private void loadCreditCard() {
        System.out.println("Please input the file name of credit cards:\n(Press [Enter] to load the default \"Cards - Sheet1.csv\")");
        Scanner in = new Scanner(System.in);
        boolean foundFile = false;
        while(!foundFile) {
            String creditCardDB = in.nextLine();

            if(creditCardDB.isEmpty()) {
                creditCardDB = "Cards - Sheet1.csv";
            }

            try {
                File myFile = new File(creditCardDB);
                Scanner fileInput = new Scanner(myFile);
                foundFile = true;

                fileInput.nextLine();   //skip the header
                while(fileInput.hasNextLine()) {
                    creditCardSet.add(fileInput.nextLine());
                }
            } catch(FileNotFoundException e){
                System.out.println("No such file. Please enter the correct file name:");
            }
        }
    }

    public void processOrder() {
        System.out.println("Please input the file name of orders:\n(Press [Enter] to load the default \"Input1 - Sheet1.csv\")");
        Scanner in = new Scanner(System.in);
        ArrayList<Item> itemArrayList = new ArrayList<>();
        boolean foundFile = false;

        while(!foundFile) {
            String fileName = in.nextLine();

            if(fileName.isEmpty()) {
                fileName = "Input1 - Sheet1.csv";
            }

            try {
                File myFile = new File(fileName);
                Scanner fileInput = new Scanner(myFile);
                foundFile = true;
                ArrayList<String> errRes = new ArrayList<>();
                double totalAmount = 0.0;

                fileInput.nextLine();   //skip the header
                while(fileInput.hasNextLine()) {
                    try (Scanner rowScanner = new Scanner(fileInput.nextLine())) {
                        rowScanner.useDelimiter(COMMA_DELIMITER);
                        ArrayList<String> tmpArr = new ArrayList<>();
                        while(rowScanner.hasNext()) {
                            tmpArr.add(rowScanner.next());
                        }

                        if(itemToCategoryMap.get(tmpArr.get(0)).equals("Essential")) {
                            itemArrayList.add(new EssentialItem(Integer.valueOf(tmpArr.get(1)), itemPriceMap.get(tmpArr.get(0)), tmpArr.get(0), itemQuantMap.get(tmpArr.get(0))));
                        } else if(itemToCategoryMap.get(tmpArr.get(0)).equals("Luxury")) {
                            itemArrayList.add(new LuxuryItem(Integer.valueOf(tmpArr.get(1)), itemPriceMap.get(tmpArr.get(0)), tmpArr.get(0), itemQuantMap.get(tmpArr.get(0))));
                        } else if(itemToCategoryMap.get(tmpArr.get(0)).equals("Misc")) {
                            itemArrayList.add(new MiscItem(Integer.valueOf(tmpArr.get(1)), itemPriceMap.get(tmpArr.get(0)), tmpArr.get(0), itemQuantMap.get(tmpArr.get(0))));
                        }

                        if(!creditCardSet.contains(tmpArr.get(2))){
                            creditCardSet.add(tmpArr.get(2));
                            try {
                                System.out.println("New card found. Adding to Cards - Sheet1.csv");
                                FileWriter pw = new FileWriter("Cards - Sheet1.csv", true);
                                pw.append("\n");
                                pw.append(tmpArr.get(2));

                                pw.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                errRes = checkErr(itemArrayList);
                if(!errRes.isEmpty()) {
                    ErrorHandler errorHandler = new ErrorHandler(errRes);
                    errorHandler.process();
                    return;
                }

                totalAmount = calculateTotal(itemArrayList);
                outputResult(totalAmount);

            } catch(FileNotFoundException e){
                System.out.println("No such file. Please enter the correct file name:");
            }
        }
    }

    private double calculateTotal(ArrayList<Item> items) {
        double res = 0.0;
        for(Item item : items) {
            res += item.getPrice() * item.getQuantity();
        }
        return res;
    }

    private ArrayList<String> checkErr(ArrayList<Item> items) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<Category, Integer> curCateCapMap = new HashMap<>();
        curCateCapMap.put(Category.Essential, 0);
        curCateCapMap.put(Category.Luxury, 0);
        curCateCapMap.put(Category.Misc, 0);

        for(Item item : items) {
            curCateCapMap.put(item.getCategory(), item.getQuantity() + curCateCapMap.get(item.getCategory()));
            if(item.getQuantity() > item.getQuantityCap() || curCateCapMap.get(item.getCategory()) > categoryCapMap.get(item.getCategory())) {
                res.add(item.getName() + "~" + item.getQuantity());
            }
        }
        return res;
    }

    private void outputResult(double amount) {
        try{
            FileWriter myWriter = new FileWriter("Output.csv");
            myWriter.write("Amt Paid\n");
            myWriter.write("" + amount);

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
