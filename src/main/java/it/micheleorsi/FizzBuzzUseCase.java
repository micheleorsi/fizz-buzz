package it.micheleorsi;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzUseCase
{

  private final MultiplierStrategy[] strategies;

  public FizzBuzzUseCase(MultiplierStrategy... strategies)
  {
    this.strategies = strategies;
  }

  public List<String> execute(int number)
  {
    return IntStream.range(0, number)
                    .map(value -> value + 1)
                    .mapToObj(Integer::toString)
                    .map(applyMultiplierStrategies())
                    .collect(Collectors.toList());
  }

  private Function<String, String> applyMultiplierStrategies()
  {
    return value ->
    {
      String valueToReturn = value;
      for(MultiplierStrategy strategy: strategies)
      {
        valueToReturn = strategy.parse(value,valueToReturn);
      }
      return valueToReturn;
    };
  }

}
