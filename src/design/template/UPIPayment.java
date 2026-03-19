package design.template;

public class UPIPayment extends PaymentTemplate{

    @Override
    void initiate() {
        System.out.println("Upi Initiated");
    }

    @Override
    Object fetchSender() {
        System.out.println("Upi Sender");
        return null;
    }

    @Override
    Object fetchReceiver() {
        System.out.println("Upi Receiver");
        return null;
    }

    @Override
    boolean validate() {
        System.out.println("Upi validate");
        return false;
    }

    @Override
    boolean doTransaction() {
        System.out.println("Upi Transaction");
        return false;
    }

    @Override
    boolean doConfirmation() {
        System.out.println("Upi Confirmation");
        return false;
    }
}
