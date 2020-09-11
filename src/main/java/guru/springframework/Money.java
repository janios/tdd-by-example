package guru.springframework;

public class Money implements Expression {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }



    protected String currency(){
        return this.currency;
    }

    public Money(int amount) {
        this.amount = amount;

    }

    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    public static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.getAmount() && this.currency == money.getCurrency();
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency(){
        return this.currency;
    }

    public Expression plus(Expression addend){
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String to){

        return new Money(amount/bank.rate(this.currency, to), to);
    }

}
