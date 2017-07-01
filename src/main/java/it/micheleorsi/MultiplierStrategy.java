package it.micheleorsi;

class MultiplierStrategy
{
  protected int seed;
  protected String value;

  public MultiplierStrategy(int seed, String value)
  {
    this.seed = seed;
    this.value = value;
  }

  public String parse(String originalValue, String text)
  {
    if(isAMultiplier(originalValue))
    {
      if(aStringValueIsDetected(text))
      {
        return text+" "+value;
      }
      return value;
    }
    return text;
  }

  private boolean aStringValueIsDetected(String text)
  {
    return text.matches(".*[^0-9]+.*");
  }

  private boolean isAMultiplier(String originalValue)
  {
    return Integer.parseInt(originalValue)%seed==0;
  }
}
