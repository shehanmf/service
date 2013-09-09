package ecompilerlab.service.app.python;

import ecompilerlab.service.app.ExecuteResult;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 8/3/13
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class PythonExecuteResult extends ExecuteResult
{
  public PythonExecuteResult(int resultCode, String formattedRuntimeError, String formattedResult)
  {
    super(resultCode, formattedRuntimeError, formattedResult);
  }
}
