# 🏦 Bank Account Simulator (Java)

## 📌 Project Overview
This project is a **Bank Account Simulator** developed using **Java** and **Object-Oriented Programming (OOP)** concepts.  
It simulates basic banking operations such as account management, deposits, withdrawals, balance inquiry, and transaction reporting through a console-based interface.

The main goal of this project is to apply OOP fundamentals in a practical and structured way.

---

## 🎯 Project Features
- User registration with personal details
- Secure authentication using **Password** and **PIN**
- Deposit and withdraw money with validation
- Balance inquiry
- Transaction history tracking
- Final account report generation
- Menu-driven console interaction

---

## 🧱 System Architecture

### 1️⃣ `Bankacc_simulator`
The **main class** of the system.
- Handles user input and menus
- Controls application flow
- Performs authentication checks
- Calls methods from other classes
- Integrates all system components

---

### 2️⃣ `User_Details`
Represents the **bank account owner**.

**Responsibilities:**
- Stores user information (username, email, password, PIN, ID)
- Validates password and PIN
- Provides getters and setters
- Applies encapsulation using private fields

---

### 3️⃣ `Operations`
Handles all **financial transactions**.

**Responsibilities:**
- Deposit money
- Withdraw money
- Validate transaction amounts
- Maintain account balance
- Store transaction history using `ArrayList`

---

### 4️⃣ `report`
Generates a **final report** for the user.

**Displays:**
- Account number
- Username
- Email
- Transaction history (operations and values)

Sensitive data such as passwords are not displayed.

---

### 5️⃣ `Show_DetailsAfterregisteration`
Displays user details immediately after registration to confirm entered information.

---

## 🔐 Security & Validation
- Password verification for sensitive actions
- PIN verification for financial operations
- Prevention of invalid transactions
- Encapsulation to protect user data

---

## 🧠 Programming Concepts Used
- Object-Oriented Programming (OOP)
- Encapsulation
- Constructors
- Access Modifiers
- ArrayList
- Conditional Statements
- Loops
- Input Validation
- Menu-driven Programming

---

## 🧪 Testing & Debugging
The system was tested using:
- Valid and invalid inputs
- Boundary cases (zero and negative values)
- Incorrect password and PIN attempts

All issues were resolved through **manual analysis, logical reasoning, and testing**.

---

## 🤖 Artificial Intelligence Notice
> **Important Note**

- This **README file was generated using Artificial Intelligence** to clearly explain the project and its structure.
- **The system itself (design, logic, and source code) was fully developed by a human**, through:
  - Analysis
  - Debugging
  - Logical thinking
  - Testing and validation

Artificial Intelligence was **not used to generate or write the project code**.

---

## 🎓 Academic Information
- **Student Level:** Semester 1
- **Language:** Java
- **Type:** Console-based application
- **Course:** Introduction to Object-Oriented Programming

This project demonstrates a strong understanding of OOP concepts for a first-semester student.

---

## ✅ Conclusion
The Bank Account Simulator is a complete and functional Java application that applies OOP principles in a real-world scenario.  
It serves as a solid foundation for more advanced projects in future semesters.
