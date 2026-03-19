package design.template;

public abstract class PaymentTemplate {

    abstract void initiate();
    abstract Object fetchSender();
    abstract Object fetchReceiver();
    abstract boolean validate();
    abstract boolean doTransaction();
    abstract boolean doConfirmation();

    boolean proceed(){
        initiate();
        fetchSender();
        fetchReceiver();
        validate();
        doTransaction();
        return doConfirmation();
    }
}
