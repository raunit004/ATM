# ATM System

This ATM System is a Java-based application that mimics a real-world ATM interface. It allows users to perform essential banking transactions such as deposits, withdrawals, balance enquiries, and PIN changes. The system utilizes a graphical user interface (GUI) built with `Swing` and interacts with a MySQL database to store and retrieve account-related information.

---

## Features

1. **Account Creation**  
   - Multi-page form for creating a new account with personal and financial details (e.g., religion, category, PAN, Aadhaar, etc.).

2. **Transaction Options**  
   - Deposit Money
   - Withdraw Money
   - Fast Cash (Quick Withdrawal Options)
   - Mini Statement (View last few transactions)
   - PIN Change
   - Balance Enquiry

3. **Login Authentication**  
   - User authentication based on a card number and PIN.

4. **Database Interaction**  
   - The system uses MySQL to store user account information, transaction history, and other details.
   
5. **User-Friendly GUI**  
   - Interactive GUI with buttons and fields for user input, providing a smooth user experience.

---

## Files Overview

### 1. **Signuptwo.java**  
   This class represents the second page of the account creation process. It collects additional personal details like religion, category, income, PAN, Aadhaar number, etc.

### 2. **Transactions.java**  
   Provides a user interface for performing transactions such as deposits, withdrawals, mini statements, PIN change, and balance enquiry.

### 3. **Withdraw.java**  
   Handles the withdrawal functionality. It ensures the user has enough balance before allowing a withdrawal.

### 4. **Deposit.java**  
   Allows the user to deposit money into their account.

### 5. **MiniStatement.java**  
   Displays the user's recent transactions (mini statement) for review.

### 6. **PinChange.java**  
   Allows the user to change their PIN.

### 7. **BalanceEnquiry.java**  
   Displays the balance in the user's account.

### 8. **Conn.java**  
   Contains the JDBC connection logic used to interact with the MySQL database.

### 9. **Images**  
   Stores the images used in the GUI, such as background images (`atm.jpg`).

---

## Technologies Used

- **Java Swing**: For creating the graphical user interface.
- **JDBC**: To connect to the MySQL database.
- **MySQL**: Database for storing account and transaction information.

---

## Acknowledgments

- Thanks to the open-source community for making resources like Java and MySQL accessible.
- Thanks to all the contributors to the project.
