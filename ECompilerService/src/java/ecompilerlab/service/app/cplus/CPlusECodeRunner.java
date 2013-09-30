package ecompilerlab.service.app.cplus;

import ecompilerlab.service.app.AbstractECodeRunner;
import ecompilerlab.service.app.ApplicationSettings;
import ecompilerlab.service.app.CompileResult;
import ecompilerlab.service.app.ExecuteResult;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/23/13
 * Time: 7:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class CPlusECodeRunner extends AbstractECodeRunner
{

  @Override
  public ExecuteResult executeCode(String className, CompileResult compileResult)
  {

    String exeName = ApplicationSettings.getInstance().getTempFolderPath() + "\\tmpcplus\\" + className + ".exe";

    return CPlusProcessExecuter.runExe(exeName);
  }
}
