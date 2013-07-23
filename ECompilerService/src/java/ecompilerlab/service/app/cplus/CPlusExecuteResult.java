package ecompilerlab.service.app.cplus;

import ecompilerlab.service.app.ExecuteResult;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/23/13
 * Time: 7:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class CPlusExecuteResult extends ExecuteResult
{
  public CPlusExecuteResult(int resultCode, String formattedRuntimeError, String formattedResult)
  {
    super(resultCode, formattedRuntimeError, formattedResult);
  }
}
