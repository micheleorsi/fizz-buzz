package it.micheleorsi;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

public class FizzBuzzApplicationTest
{

  @Rule
  public JUnitRuleMockery mockery = new JUnitRuleMockeryForClasses();

  @Mock
  private FizzBuzzUseCase useCase;
  @Mock
  private FizzBuzzDisplay display;

  private FizzBuzzApplication underTest;

  @Before
  public void setup()
  {
    underTest = new FizzBuzzApplication(useCase,display);
  }


  @Test(expected = FizzBuzzApplication.EmptyInputException.class)
  public void whenEmptyInput_returnSpecificException()
  {
    underTest.run(new String[]{});
  }

  @Test(expected = FizzBuzzApplication.EmptyInputException.class)
  public void whenEmptyInputString_returnSpecificException()
  {
    underTest.run(new String[]{});
  }

  @Test(expected = FizzBuzzApplication.IllegalInputException.class)
  public void whenInputIsAString_returnSpecificException()
  {
    underTest.run(new String[]{"ciao"});
  }

  @Test
  public void whenValidInput_useCaseIsExecuted()
  {
    mockery.checking(new Expectations()
    {{
      oneOf(useCase).execute(with(10));
      allowing(display).display(with(any(List.class)));
    }});
    underTest.run(new String[]{"10"});
  }

  @Test
  public void whenValidInput_displayIsExecuted()
  {
    mockery.checking(new Expectations()
    {{
      allowing(useCase).execute(with(any(int.class)));
      oneOf(display).display(with(any(List.class)));
    }});
    underTest.run(new String[]{"10"});
  }
}
