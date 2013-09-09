package ecompilerlab.service.app.python;

import ecompilerlab.service.app.AbstractECodeFormatter;
import ecompilerlab.service.app.InvalidSourceException;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 8/3/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class PythonECodeFormatter extends AbstractECodeFormatter
{
  private SecureRandom random = new SecureRandom();

  @Override
  public String generate(String snippet, String defaultClassName) throws InvalidSourceException
  {
    return snippet;
  }

  @Override
  public String getClassName(String formattedCode)
  {
    return new BigInteger(130, random).toString(32);

  }
}
