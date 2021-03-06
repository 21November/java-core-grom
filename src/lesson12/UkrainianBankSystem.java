package lesson12;

public class UkrainianBankSystem implements BankSystem{

    @Override
    public void withdraw(User user, int amount) {
        //проверить можно ли снять -
        // проверить лимит
        // проверить достаточно ли денег
        //снть деньги

//        int limitOfWithdrawal = user.getBank().getLimitOfWithdrawal();

//        if (amount + user.getBank().getCommission(amount) > limitOfWithdrawal){
//            printWithdrawalErrorMsg(amount, user);
//            return;
//        }
//        if (amount + user.getBank().getCommission(amount) > user.getBalance()){
//            printWithdrawalErrorMsg(amount,user);
//            return;
//        }

        if (!checkWithdraw(user, amount)){
            return;
        }
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    @Override
    public void fund(User user, int amount) {
        //проверить лимит пополнения для банка user
        //пополнить баланс amount

        if (!checkFundingLimits(user, amount)){
            return;
        }
        user.setBalance(user.getBalance() + amount);

    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        //проверить валюту
        //проверить пределы снятия и пополнения с учетом комисий на снятие и пополнение
        //снимаем деньги с fromUser
        //пополняем toUser

        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency())
            return;
        if (!checkWithdraw(fromUser, amount) || !checkFundingLimits(toUser, amount))
            return;
        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);
    }

    @Override
    public void paySalary(User user) {
        //проверить лимит пополнения для банка user
        //перечисление salary на баланс user

        if (!checkFundingLimits(user, user.getSalary())){
            return;
        }
        user.setBalance(user.getBalance() + user.getSalary());
    }


    private boolean checkWithdraw(User user, int amount){
        return  checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal())&&
                checkWithdrawLimits(user, amount, user.getBalance());

    }

    private boolean checkWithdrawLimits(User user, int amount, double limit){
        if (amount + user.getBank().getCommission(amount) > limit){
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private void printWithdrawalErrorMsg(int amount, User user){
        System.err.println("Can`t withdraw money " + amount + "from user" + user.toString());
    }

    private boolean checkFundingLimits(User user, int amount){
        if (amount + user.getBank().getCommission(amount) > user.getBank().getLimitOfFunding()){
            printFundingErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private void printFundingErrorMsg(int amount, User user){
        System.err.println("Can`t found money " + amount + "to user" + user.toString());
    }
}
