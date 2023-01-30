# commerceTest
End 2 End Automation Test Scripts

The Project model of Framework is Page Object Model, which stores all the element locators and it’s functionalities for each page and the Test’s are created by inheriting the Page objects.
All the Pages and it’s locators are created in the package PageClasses and all the Tests are created in the commerceTest package.
In PageClasses , we have created two pages like Register and Login.
In commerceTest, we have registered a user by automation script and we also had written few test cases for the Login and Post Login functionalities.
To see the results, we have configured the Allure Reports.
To Execute the Test Scripts:
 
![e2e_img4](https://user-images.githubusercontent.com/85029195/214897317-63938fcd-7f57-44c3-912e-242cfab44dc6.PNG)


After Execution of Scripts:
![image](https://user-images.githubusercontent.com/85029195/214897398-296486e5-4f55-4035-9578-e492aa18b07f.png)

 
To Generate the Allure Reports:
below is the command allure serve **path of allureresults folder in the project**

![image](https://user-images.githubusercontent.com/85029195/214897443-3cde6480-4d44-4486-802c-c621843be211.png)

 
**Allure Report:**

To Configure Allure Report, 
Go to https://docs.qameta.io/allure/
Click on Maven Central link in 2.1.4. Manual installation
Download allure-commandline-2.9.0 zip
Extract the zip file
copy the path till bin folder and add the path to Path variable in System variables
![image](https://user-images.githubusercontent.com/85029195/215442558-0e531dce-9596-447a-941e-2a7119d4d1a7.png)

After executing the suite, execute the below command to generate report
**allure serve path_of_allure_resutls_folder**
![image](https://user-images.githubusercontent.com/85029195/214897642-865709e0-fbc6-47b5-88e7-2a66082fc661.png)

 
