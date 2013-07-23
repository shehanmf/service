package ecompilerlab.service.app.c;

import ecompilerlab.service.app.CompileResult;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/22/13
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class CCompileResult  extends CompileResult
{
  public CCompileResult(int resultCode, String formattedCompileError)
  {
    super(resultCode, formattedCompileError);
  }
}
