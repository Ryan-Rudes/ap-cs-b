/**
Money - lab
Inheritance
  */

import java.util.ArrayList;

public class MainBank {
  public static void main(String[] args) {
    ArrayList<Money> piggyBank = new ArrayList<Money> ();
    piggyBank.add(new Quarter());
    piggyBank.add(new Bill(1));
    piggyBank.add(new Nickel());
    piggyBank.add(new Quarter());
    piggyBank.add(new Dime());
    piggyBank.add(new Bill(5));

    System.out.println(piggyBank);

    double amount = 0;

    for (Money item: piggyBank)
      amount += item.getAmount();

    System.out.printf("The piggy bank holds $%.2f\n", amount);
  }

  /*
  Output:
  [Quarter: $0.25, Bill: $1.00, Nickel: $0.05, Quarter: $0.25, Dime: $0.10, Bill: $5.00]
  The piggy bank holds $6.65
  /*
}
