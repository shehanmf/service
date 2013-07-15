package ecompilerlab.service.impl;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/8/13
 * Time: 12:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class CompileResponse implements Serializable
{

  private CompileResponseState state;

  private String resultString;

  public CompileResponse() {
  }

  

  public CompileResponse(CompileResponseState state, String resultString)
  {
    this.state = state;
    this.resultString = resultString;
  }


  public CompileResponseState getState()
  {
    return state;
  }

  public void setState(CompileResponseState state)
  {
    this.state = state;
  }

  public String getResultString()
  {
    return resultString;
  }

  public void setResultString(String resultString)
  {
    this.resultString = resultString;
  }
}
