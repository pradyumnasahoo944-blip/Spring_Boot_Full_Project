package com.jt.expense_tracker;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    // GET all expenses
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    // GET expense by ID
    public Expense getExpenseById(int id) {
        return expenseRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Unable to find expense with id " + id
                    )
                );
    }

    // CREATE expense
    public Expense 
    addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // DELETE expense
    public void deleteExpenseById(int id) {
        // First check whether expense exists
        getExpenseById(id);

        // Delete expense
        expenseRepository.deleteById(id);
    }

    // UPDATE expense
    public Expense updateExpense(Expense expense) {
        // First check whether expense exists
        getExpenseById(expense.getId());

        // Save updated expense
        return expenseRepository.save(expense);
    }
}