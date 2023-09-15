package briup.homework.jdk8.Lambda_add;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/1-09-01-16:35
 * @Description：briup.homework.jdk8.Lambda_add
 */
public class Test03_banking_transactions {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //1
        transactions.stream()
                .filter(t -> t.getMonth() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getMoney))
                .map(Transaction::getMoney)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //2
        System.out.println("----------------------------------");
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        //3
        System.out.println("----------------------------------");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //4
        System.out.println("----------------------------------");
        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //5
        System.out.println("----------------------------------");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().contains("Milan"))
                .map(Trader::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        // 6
        System.out.println("-----------------------------------");
        transactions.stream()
                .filter(t-> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getMoney)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        // 7
        System.out.println("-------------------------------------");
        Optional<Integer> reduceMax = transactions.stream()
                .map(Transaction::getMoney)
                .reduce(Integer::max);
        reduceMax.ifPresent(System.out::println);
        // 8
        System.out.println("-------------------------------------");
        Optional<Integer> reduceMin = transactions.stream()
                .map(Transaction::getMoney)
                .reduce(Integer::min);
        reduceMin.ifPresent(System.out::println);
    }
}
class Trader{
    private final String name;
    private final String city;

    public String getName() {return name;}
    public String getCity() {return city;}

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Transaction{
    private final Trader trader;
    private final int month;
    private final int money;
    public Transaction(Trader trader, int month, int money) {
        this.trader = trader;
        this.month = month;
        this.money = money;
    }

    public Trader getTrader() {return trader;}

    public int getMonth() {return month;}
    public int getMoney() {return money;}

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", month=" + month +
                ", money=" + money +
                '}';
    }
}