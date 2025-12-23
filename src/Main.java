import model.Expense;
import service.ExpenseAnalyzer;
import util.DateUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ExpenseAnalyzer analyzer = new ExpenseAnalyzer();

        // Sample expenses
        analyzer.addExpense(new Expense(
                "Food",
                250.0,
                DateUtils.parseDate("2025-01-10"),
                "Lunch"
        ));

        analyzer.addExpense(new Expense(
                "Transport",
                120.0,
                DateUtils.parseDate("2025-01-11"),
                "Bus fare"
        ));

        analyzer.addExpense(new Expense(
                "Entertainment",
                500.0,
                DateUtils.parseDate("2025-01-12"),
                "Movie"
        ));

        analyzer.addExpense(new Expense(
                "Food",
                300.0,
                DateUtils.parseDate("2025-01-13"),
                "Dinner"
        ));

        analyzer.addExpense(new Expense(
                "Utilities",
                900.0,
                DateUtils.parseDate("2025-01-15"),
                "Electricity bill"
        ));

        // Total expenses
        System.out.println("Total Expenses: " + analyzer.getTotalExpenses());

        // Category-wise breakdown
        System.out.println("\nCategory-wise Expenses:");
        Map<String, Double> categoryTotals = analyzer.getCategoryWiseExpenses();
        categoryTotals.forEach((category, amount) ->
                System.out.println(category + ": " + amount)
        );

        // Highest spending category
        System.out.println("\nHighest Spending Category: "
                + analyzer.getHighestSpendingCategory());

        // Date range filtering
        System.out.println("\nExpenses from 2025-01-11 to 2025-01-13:");
        List<Expense> filtered = analyzer.filterByDate(
                LocalDate.of(2025, 1, 11),
                LocalDate.of(2025, 1, 13)
        );

        filtered.forEach(System.out::println);
    }
}