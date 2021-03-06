package it.micheleorsi;

import java.util.List;

public class FizzBuzzApplication
{
  private final FizzBuzzUseCase useCase;
  private final FizzBuzzDisplay display;

  public FizzBuzzApplication(FizzBuzzUseCase useCase, FizzBuzzDisplay display)
  {
    this.useCase = useCase;
    this.display = display;
  }

  public void run(String[] arguments)
  {
    validateInput(arguments);
    int parsedInput = Integer.parseInt(arguments[0]);
    List<String> list = this.useCase.execute(parsedInput);
    display.display(list);
  }

  private void validateInput(String[] args)
  {
    if(args.length==0)
    {
      throw new EmptyInputException();
    }
    if(args.length>1)
    {
      throw new TooManyArgumentsException();
    }
    if(firstArgIsNotANumber(args[0]))
    {
      throw new IllegalInputException();
    }
  }

  private boolean firstArgIsNotANumber(String arg)
  {
    return arg.matches(".*[^0-9]+.*");
  }

  class EmptyInputException extends RuntimeException
  {
    public EmptyInputException()
    {
      super("The input was empty: you should specify a number");
    }
  }

  class IllegalInputException extends RuntimeException
  {
    public IllegalInputException()
    {
      super("The input was illegal: you passed a string, but a number is needed");
    }
  }

  class TooManyArgumentsException extends RuntimeException
  {
    public TooManyArgumentsException()
    {
      super("Too many arguments as input: you should pass only one number");
    }
  }

}

