package com.satyendra.coding_practice.designpattern;

public class TemplateMethodDesignPattern {

    /*
    1. When we want all classes to follow the specific steps to process the task.
    2. But also need to provide the flexibility that each class can have their own logic in that specific steps
    * */
    public static void main(String[] args) {
        PaymentTemplate payToFriendTemplate = new PaymentToFriend();
        PaymentTemplate payToMerchantTemplate = new PaymentToMerchant();
        payToFriendTemplate.transfer();
        payToMerchantTemplate.transfer();
    }
}

abstract class PaymentTemplate {
    public abstract void validate();
    public abstract void debitMoney();
    public abstract void deductPlatformFee();
    public abstract void creditMoney();

    public final void transfer() {
        validate();
        debitMoney();
        deductPlatformFee();
        creditMoney();
    }
}

class PaymentToFriend extends PaymentTemplate {

    @Override
    public void validate() {
        System.out.println("Validation logic for PaymentToFriend");
    }

    @Override
    public void debitMoney() {
        System.out.println("Money debited for PaymentToFriend");
    }

    @Override
    public void deductPlatformFee() {
        System.out.println("0% platform fee for PaymentToFriend");
    }

    @Override
    public void creditMoney() {
        System.out.println("Money credited for PaymentToFriend");
    }
}

class PaymentToMerchant extends PaymentTemplate {

    @Override
    public void validate() {
        System.out.println("Validation logic for PaymentToMerchant");
    }

    @Override
    public void debitMoney() {
        System.out.println("Money debited for PaymentToMerchant");
    }

    @Override
    public void deductPlatformFee() {
        System.out.println("2% platform charges for PaymentToMerchant");
    }

    @Override
    public void creditMoney() {
        System.out.println("Money credited for PaymentToMerchant");
    }
}
