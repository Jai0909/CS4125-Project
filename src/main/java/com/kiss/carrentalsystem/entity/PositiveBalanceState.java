package com.kiss.carrentalsystem.entity;

public class PositiveBalanceState implements PaymentState {
    private PaymentContext context;

    public PositiveBalanceState(PaymentContext context) {
        this.context = context;
    }

    @Override
    public void addBalance(PaymentContext context, double amount) {
        context.setBalance(context.getBalance() + amount);
        System.out.println("Balance added. Current balance: " + context.getBalance());
    }

    @Override
    public void removeBalance(PaymentContext context, double amount) {
        if (context.getBalance() >= amount) {
            context.setBalance(context.getBalance() - amount);
            System.out.println("Balance removed. Current balance: " + context.getBalance());

            // Check if balance becomes negative after removal
            if (context.getBalance() < 0) {
                context.setState(new NegativeBalanceState(context));
            }
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}