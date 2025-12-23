package service;

import model.Expense;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseAnalyzer {

    private final List<Expense> expenses;

    public ExpenseAnalyzer() {
        this.expenses = new ArrayList<>();
    }

    // Add a new expense
    public void addExpense(Expense expense) {
        if (expense == null) {
            throw new IllegalArgumentException("Expense cannot be null");
        }
        expenses.add(expense);
    }

    // Total of all expenses
    public double getTotalExpenses() {
        double total = 0.0;

        for(Expense e : expenses) { //Iterate thru the expense list 
        	total += e.getAmount(); // get the amount from each object 
        }
        return total;
    }

    // Category-wise expense totals
    public Map<String, Double> getCategoryWiseExpenses() {
        Map<String, Double> categoryTotals = new HashMap<>();

        for(Expense e : expenses ) {
        	String category = e.getCategory();
        	double amount = e.getAmount();
        	
        	//If the item is already there 
        	if(categoryTotals.containsKey(category)) {
        		double currentTotal = categoryTotals.get(category);
        		categoryTotals.put(category, currentTotal + amount); 
        	}else { 
        		categoryTotals.put(category, amount);	// If it is not there 
        	}
        }
        
        return categoryTotals;
    }

    // Highest spending category
    public String getHighestSpendingCategory() {
        if (expenses.isEmpty()) {
            return "N/A";
        }

        Map<String, Double> categoryTotals = getCategoryWiseExpenses();

        String highestCategory = "N/A";
        double maxAmount = 0.0;

        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            if (entry.getValue() > maxAmount) {
                maxAmount = entry.getValue();
                highestCategory = entry.getKey();
            }
        }

        return highestCategory;
    }

    // Filter expenses by date range (inclusive)
    public List<Expense> filterByDate(LocalDate start, LocalDate end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        List<Expense> filteredExpenses = new ArrayList<>();


        for (Expense expense : expenses) {
            LocalDate expenseDate = expense.getDate();

            if (!expenseDate.isBefore(start) && !expenseDate.isAfter(end)) {
                filteredExpenses.add(expense);
            }
        }

        return filteredExpenses;
    }
}