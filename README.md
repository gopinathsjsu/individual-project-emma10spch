# Class Diagram
<img width="1055" alt="classdiagram" src="https://user-images.githubusercontent.com/26152890/144736666-d3de2eaf-387a-4692-b8e9-b3ab6b277744.png">

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
<img width="1433" alt="IntelliJ-1" src="https://user-images.githubusercontent.com/26152890/144735585-b2b7d3f5-d5d2-4aed-821a-c42e975b5a41.png">

# Output screenshots
1. Run the application based on "Input1 - Sheet1.csv":
<img width="886" alt="IntelliJ-11" src="https://user-images.githubusercontent.com/26152890/144735866-80dd3317-378c-425d-978a-3137bacd6e4f.png">

<img width="563" alt="test1" src="https://user-images.githubusercontent.com/26152890/144735659-c0d38e82-46f2-4fe0-803c-6bd8cad23165.png">
<img width="810" alt="Output1" src="https://user-images.githubusercontent.com/26152890/144735686-b4b84892-9062-4242-a5ed-f5228c127bfc.png">

2. Run the application based on "Input2 - Sheet1.csv":
<img width="957" alt="IntelliJ-2" src="https://user-images.githubusercontent.com/26152890/144735725-474f2d9c-a0ef-4602-ae96-bf90559d1c58.png">
<img width="640" alt="Output2" src="https://user-images.githubusercontent.com/26152890/144735738-7a965150-07ce-483c-addd-b68147caa428.png">

3. Restore "Cards - Sheet1.csv" to the original two entries. Run the application based on "Input3 - Sheet1.csv":
<img width="888" alt="IntelliJ-3" src="https://user-images.githubusercontent.com/26152890/144736031-3a99f2d0-f7eb-4768-ab3b-226ae9373882.png">
<img width="647" alt="test3" src="https://user-images.githubusercontent.com/26152890/144736034-17290c87-685c-481c-aa72-ff667c4f7173.png">
<img width="703" alt="Output3" src="https://user-images.githubusercontent.com/26152890/144736039-7123ad91-e760-4fe2-94ac-536584c8ca14.png">

# Intermediate results
<img width="995" alt="InterRes" src="https://user-images.githubusercontent.com/26152890/144735984-df392f0c-6da4-41df-87ae-b145e5241f44.png">

