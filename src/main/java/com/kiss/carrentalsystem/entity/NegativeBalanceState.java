package com.kiss.carrentalsystem.entity;
public class NegativeBalanceState implements PaymentState {
    private PaymentContext context;

    public NegativeBalanceState(PaymentContext context) {
        this.context = context;
    }

    @Override
    public void addBalance(PaymentContext context, double amount) {
        context.setBalance(context.getBalance() + amount);
        System.out.println("Balance added. Current balance: " + context.getBalance());
        // change to positive balance state if balance becomes positive
        if (context.getBalance() >= 0) {
            context.setState(new PositiveBalanceState(context));
        }
    }

    @Override
    public void removeBalance(PaymentContext context, double amount) {
        System.out.println("Cannot remove balance. Balance is negative.");
    }
}

