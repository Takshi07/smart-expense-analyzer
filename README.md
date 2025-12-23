Smart Expense Analyzer (Java)

Overview

Smart Expense Analyzer is a simple Java-based application that helps analyze personal expenses using clean object-oriented design and Java Collections. 

This is a logic-driven system, not a UI-heavy application (only console based).

⸻

Features
	•	Add daily expenses with category, amount, date, and description
	•	Calculate total expenses
	•	View category-wise expense breakdown
	•	Identify the highest spending category
	•	Filter expenses by a given date range

⸻

Project Structure

smart-expense-analyzer/
│
├── src/
│   ├── model/
│   │   └── Expense.java
│   │
│   ├── service/
│   │   └── ExpenseAnalyzer.java
│   │
│   ├── util/
│   │   └── DateUtils.java
│   │
│   └── Main.java
│
└── README.md


⸻

Technologies Used
	•	Java
	•	Java Collections (List, Map)
	•	java.time.LocalDate

⸻

How to Run
	1.	Clone or download the project
	2.	Open it in any Java IDE (Eclipse / IntelliJ / VS Code)
	3.	Run Main.java
	4.	The program will execute using predefined sample expenses and print analysis results to the console

No user input is required.

⸻

Sample Output (Example)

Total Expenses: 2070.0

Category-wise Expenses:
Food: 550.0
Transport: 120.0
Entertainment: 500.0
Utilities: 900.0

Highest Spending Category: Utilities

Expenses from 2025-01-11 to 2025-01-13:
Expense{category='Transport', amount=120.0, date=2025-01-11, description='Bus fare'}
Expense{category='Entertainment', amount=500.0, date=2025-01-12, description='Movie'}
Expense{category='Food', amount=300.0, date=2025-01-13, description='Dinner'}

⸻

