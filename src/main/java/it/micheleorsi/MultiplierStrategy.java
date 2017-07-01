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
    if(Integer.parseInt(originalValue)%seed==0)
    {
      if(text.matches("[a-zA-z\\s]+"))
      {
        return text+" "+value;
      }
      return value;
    }
    return text;
  }
}
