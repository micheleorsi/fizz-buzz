package it.micheleorsi;

import java.io.PrintStream;
import java.util.List;

public class FizzBuzzDisplay
{

  private final PrintStream printStream;

  public FizzBuzzDisplay(PrintStream printStream)
  {
    this.printStream = printStream;
  }

  public void display(List<String> list)
  {
    printStream.println("Here is the list of FizzBuzz:");
    printStream.println(list);
  }
}
