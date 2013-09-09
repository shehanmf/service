package ecompilerlab.service.app.python;

import ecompilerlab.service.app.CompileResult;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 8/3/13
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class PythonCompileResult extends CompileResult
{
  public PythonCompileResult(int resultCode, String formattedCompileError)
  {
    super(resultCode, formattedCompileError);
  }
}
