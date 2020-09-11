package guru.springframework;

public class Sum implements Expression{
    Expression augmend;
    Expression addmend;

    public Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String to ){
        int amount = augmend.reduce(bank, to).getAmount() + addmend.reduce(bank, to).getAmount();
        return new Money(amount, to);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augmend.times(multiplier) , addmend.times(multiplier));
    }

    @Override
    public Expression plus(Expression addend){
        return new Sum(this, addmend);
    }
}
