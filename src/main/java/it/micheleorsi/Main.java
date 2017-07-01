package it.micheleorsi;

public class Main
{
  public static void main(String[] args)
  {
    new FizzBuzzApplication(
      new FizzBuzzUseCase(
        new MultiplierStrategy(3,"Fizz"),
        new MultiplierStrategy(5,"Buzz")
      ),
      new FizzBuzzDisplay(System.out)
    ).run(args);
  }
}
