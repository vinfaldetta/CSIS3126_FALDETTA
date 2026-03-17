package com.faldetta.financebackend.dto;

public class DashboardSummary {

        private double totalIncome;
        private double totalExpenses;
        private double balance;

        public DashboardSummary(double totalIncome, double totalExpenses) {
            this.totalIncome = totalIncome;
            this.totalExpenses = totalExpenses;
            this.balance = totalIncome - totalExpenses;
        }

        public double getTotalIncome() {
            return totalIncome;
        }

        public double getTotalExpenses() {
            return totalExpenses;
        }

        public double getBalance() {
            return balance;
        }
    }

