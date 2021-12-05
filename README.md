# Instructions
1. Clone the repo
2. Open IntelliJ and from top menu click “File” -> “Open”. 
3. Open the “CheckoutSystem” in the popup window to load the project into IntelliJ
4. You are supposed to put all your test files, db files and input files under the root directory. By default, the folder already provides all the sample files that released by instructor.
5. Go to top right corner of IntelliJ and click the Run Main button to start the application.
6. Input console will be launched with instructions on input. 
7. The application will read "Dataset - Sheet1.csv" if you don’t type anything but [Enter]. You can also specify any other dataset name as long as the corresponding file is located under the same root directory.
8. After press [Enter] or specify another file in step 7, the application will automatically load the “config.csv” file by default. This file comes with the setting for the cap on different categories. Currently it’s set to [Essential:5, Luxury:3, Misc:6] as indicated by instructor. Then another prompt will show up asking for the credit card db.
9. Like in step 7, either press [Enter] or type in a different file name, the application or load the credit card db.
10. Another prompt will show up asking for input data. Same as the previous steps, either press [Enter] to load the default file or specify another one.
11. After pressing [Enter] in step 10, the application will start to run and exit automatically. If there is no error detected in the input, an output file named “Output.csv” will be created under the root directory, which comes with the total amount paid. If a new credit card is detected, the file “Cards - Sheet1.csv” will be updated. If some errors occur, a file named “Errors.txt” will be created, which will provide which item exceeds the quantity.
