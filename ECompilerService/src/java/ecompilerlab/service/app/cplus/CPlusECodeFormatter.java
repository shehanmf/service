package ecompilerlab.service.app.cplus;

import ecompilerlab.service.app.AbstractECodeFormatter;
import ecompilerlab.service.app.InvalidSourceException;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/23/13
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class CPlusECodeFormatter extends AbstractECodeFormatter
{

  private SecureRandom random = new SecureRandom();

  @Override
  public String generate(String snippet,String defaultClassName) throws InvalidSourceException
  {
    return snippet;
  }

  @Override
  public String getClassName(String formattedCode)
  {
    return new BigInteger(130, random).toString(32);

  }
}
