package it.micheleorsi;

import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;

public class JUnitRuleMockeryForClasses extends JUnitRuleMockery
{
  public JUnitRuleMockeryForClasses()
  {
    setImposteriser(ClassImposteriser.INSTANCE);
  }
}
