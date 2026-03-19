package design.template;

public class DebitCardPayment extends PaymentTemplate{
    @Override
    void initiate() {
        System.out.println("Debit Card Initiated");
    }

    @Override
    Object fetchSender() {
        System.out.println("Debit card Sender");
        return null;
    }

    @Override
    Object fetchReceiver() {
        System.out.println("Debit Card Receiver");
        return null;
    }

    @Override
    boolean validate() {
        System.out.println("Debit Card validate");
        return false;
    }

    @Override
    boolean doTransaction() {
        System.out.println("Debit Card Transaction");
        return false;
    }

    @Override
    boolean doConfirmation() {
        System.out.println("Debit Card Confirmation");
        return false;
    }
}
