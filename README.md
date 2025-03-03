# 🚀 Appium Mobile Test Automation

![Appium](https://img.shields.io/badge/Appium-Mobile%20Testing-blueviolet)  
![Java](https://img.shields.io/badge/Java-11-blue)  
![TestNG](https://img.shields.io/badge/TestNG-Framework-green)  
![Status](https://img.shields.io/badge/Status-Completed-success)  

🔹 **Automated Testing of a Mobile Application using Appium & TestNG**  

This project focuses on automating key mobile application functionalities using **Appium**, **Java**, and **TestNG**. It covers UI interactions, gestures, and form handling with robust test execution.

---

## 📂 **Project Structure**
```
📺 Appium-Mobile-Test-Automation
 ┗ 📂 src/test/java
   ┗ 📂 testcases        # Test scripts
   ┗ 📂 utils            # Utility methods & helper functions
   ┗ 📄 BaseTest.java    # WebDriver setup & teardown
   ┗ 📄 LoginTest.java   # Successful Login 
   ┗ 📄 LoginFailureTest.java    # Locked User tries to login
   ┗ 📄 ItemOperations.java    # Adding & Removing items from the cart
   ┗ 📄 CartFlow.java    # Verifying the application flow
   ┗ 📄 EndToEndTest.java    # Simulating user placing an order

┗ 📂 src/main/resources
   ┗ 📄 config.properties # Configuration file (App package, Activity, etc.)
   ┗ 📄 pom.xml            # Maven dependencies
   ┗ 📄 testng.xml         # TestNG Suite configuration
   ┗ 📄 README.md          # Project Documentation
```

---

## 🚀 **Features Automated**
✅ Login (Valid & Invalid Scenarios)  
✅ Menu Navigation & Click Actions  
✅ Form Filling & Alerts Handling  
✅ TestNG Annotations & Assertions  
✅ Extent Reports Integration for Execution Reports  

---

## 🛠️ **Tech Stack Used**
- **Programming Language:** Java  
- **Testing Framework:** TestNG  
- **Automation Tool:** Appium  
- **Build Tool:** Maven  
- **Reporting:** Extent Reports  

---

## ⚙ **Setup & Installation**
### **1️⃣ Prerequisites**
Make sure you have the following installed:  
- **Java (JDK 11 or later)**  
- **Maven**  
- **Node.js & Appium Server**  
- **Android Studio (for Emulator/Real Device Testing)**  

### **2️⃣ Clone the Repository**
```sh
git clone https://github.com/yourusername/Appium-Mobile-Test-Automation.git
cd Appium-Mobile-Test-Automation
```

### **3️⃣ Install Dependencies**
```sh
mvn clean install
```

### **4️⃣ Start Appium Server**
```sh
appium
```

### **5️⃣ Run Tests**
```sh
mvn test
```
or  
```sh
testng testng.xml
```

---

## 📊 **Test Execution Reports**
📌 **Extent Reports** are generated after each test run.  
To view the report:  
```sh
open test-output/ExtentReports.html
```

---

## 🔥 **Screenshots & Logs**
📌 Test execution screenshots are automatically captured on failure and stored in the `screenshots/` folder.  
📌 Log files are stored in `logs/` for debugging.  

---

## 💡 **Customization**
Modify the `config.properties` file to update:
- **App Package & Activity**
- **Device Configuration**
- **Timeouts & Waits**  

---

## 📌 **Future Enhancements**
🔹 Integrate with CI/CD (Jenkins/GitHub Actions)  
🔹 Implement API Testing with REST Assured  
🔹 Extend Tests for iOS Automation  

---

## 🤝 **Contributing**
🚀 Feel free to fork, enhance, and contribute! Submit a Pull Request with improvements.  

---

## 🐜 **License**
This project is licensed under the **MIT License**.  

---

### 🎯 **Connect with Me**
💼 **LinkedIn:** [linkedin.com/in/vrishank  ](https://www.linkedin.com/in/vrishank/)
📧 **Email:** vrishank1991@gmail.com  

---

### 🎉 **Happy Testing! 🚀**
