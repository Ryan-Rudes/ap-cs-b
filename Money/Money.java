abstract class Money implements MoneyInterface {
  double value;
  String name;

  Money(double value, String name) {
    this.value = value;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return String.format("%s: $%.2f", name, value);
  }

  public double getAmount() {
    return value;
  }
}
