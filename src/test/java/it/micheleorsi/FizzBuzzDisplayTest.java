package it.micheleorsi;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class FizzBuzzDisplayTest
{

  @Rule
  public JUnitRuleMockery mockery = new JUnitRuleMockeryForClasses();

  @Mock
  private PrintStream printStream;

  private FizzBuzzDisplay underTest;

  @Before
  public void setup()
  {
    underTest = new FizzBuzzDisplay(printStream);
  }

  @Test
  public void whenAListIsPassed_itHasBeenDisplayed()
  {
    final List<String> displayedList = Arrays.asList("1", "2", "Fizz", "4", "Buzz");
    mockery.checking(new Expectations()
    {{
      oneOf(printStream).println(with(any(String.class)));
      oneOf(printStream).println(with(displayedList));
    }});
    underTest.display(displayedList);

  }
}
