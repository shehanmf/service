package ecompilerlab.service.app.cplus;

import ecompilerlab.service.app.CompileResult;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/23/13
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class CPlusCompileResult  extends CompileResult
{
  public CPlusCompileResult(int resultCode, String formattedCompileError)
  {
    super(resultCode, formattedCompileError);
  }
}
