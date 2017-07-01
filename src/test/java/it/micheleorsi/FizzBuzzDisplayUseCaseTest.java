package it.micheleorsi;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FizzBuzzDisplayUseCaseTest
{

  private final static String FIZZ_BUZZ_MATCHER = "^Fizz|Buzz|Fizz Buzz$";
  private FizzBuzzUseCase underTest;
  private int randomRumberGreaterThan50;
  private List<String> returnedList;

  @Before
  public void setup()
  {
    underTest = new FizzBuzzUseCase(
      new MultiplierStrategy(3,"Fizz"),
      new MultiplierStrategy(5,"Buzz")
    );
    Random random = new Random();
    randomRumberGreaterThan50 = random.nextInt(100)+50;
    returnedList = underTest.execute(randomRumberGreaterThan50);
  }

  @Test
  public void listOfCorrectSize()
  {
    assertThat(returnedList.size(), is(equalTo(randomRumberGreaterThan50)));
  }

  @Test
  public void orderStrictlyIncreasing()
  {
    int previous = Integer.MIN_VALUE;
    for (String actual : returnedList)
    {
      if (actual.matches("^[0-9]+$"))
      {
        int number = Integer.parseInt(actual);
        if (number < previous)
        {
          fail(number + "<" + previous);
        }
        previous = number;
      }
    }
  }

  @Test
  public void listStartingFrom1()
  {
    assertThat(returnedList.get(0), is(equalTo("1")));
  }

  @Test
  public void listEndingWithNumberOrString()
  {
    assertThat(returnedList.get(returnedList.size()-1).matches(FIZZ_BUZZ_MATCHER+"|"+ randomRumberGreaterThan50 +"$"), is(equalTo(true)));
  }

  @Test
  public void onlyStringShouldBeDuplicated()
  {
    Set<String> duplicates = getDuplicates(returnedList);
    for(String actual: duplicates)
    {
      assertThat(actual.matches(FIZZ_BUZZ_MATCHER),is(true));
    }
  }

  private Set<String> getDuplicates(List<String> returnedList)
  {
    return returnedList.stream()
                       .filter(i -> Collections.frequency(returnedList, i) > 1)
                       .collect(Collectors.toSet());
  }

  @Test
  public void mutipleOf3ShouldContainFizz()
  {
    for(int i = 2; i< randomRumberGreaterThan50; i+=3)
    {
      assertThat(returnedList.get(i),containsString("Fizz"));
    }
  }

  @Test
  public void mutipleOf5ShouldContainBuzz()
  {
    for(int i = 4; i< randomRumberGreaterThan50; i+=5)
    {
      assertThat(returnedList.get(i),containsString("Buzz"));
    }
  }

  @Test
  public void mutipleOf15ShouldContainFizzBuzz()
  {
    for(int i = 14; i< randomRumberGreaterThan50; i+=15)
    {
      assertThat(returnedList.get(i),containsString("Fizz Buzz"));
    }
  }

}
