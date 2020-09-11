package guru.springframework;

import java.util.HashMap;

public class Bank {

    HashMap<Pair, Integer>  rateMap = new HashMap<>() ;


    Money reduce(Expression source, String toCurrency){

        return source.reduce(this, toCurrency);
    }

    public int rate(String from, String to){
        Integer rate = (from.equals(to))?1:rateMap.get(new Pair(from, to));
        return rate;
    }

    public void addRate(String from, String to, int rate) {
        rateMap.put(new Pair(from, to), rate);

    }
}
