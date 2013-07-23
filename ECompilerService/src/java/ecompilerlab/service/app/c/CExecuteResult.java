package ecompilerlab.service.app.c;

import ecompilerlab.service.app.ExecuteResult;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/22/13
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class CExecuteResult extends ExecuteResult
{
  public CExecuteResult(int resultCode, String formattedRuntimeError, String formattedResult)
  {
    super(resultCode, formattedRuntimeError, formattedResult);
  }
}
