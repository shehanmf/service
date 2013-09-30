package ecompilerlab.service.app.python;

import ecompilerlab.service.app.AbstractECodeRunner;
import ecompilerlab.service.app.ApplicationSettings;
import ecompilerlab.service.app.CompileResult;
import ecompilerlab.service.app.ExecuteResult;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 8/3/13
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class PythonECodeRunner extends AbstractECodeRunner
{
  @Override
  public ExecuteResult executeCode(String className, CompileResult compileResult)
  {

    String fileName = ApplicationSettings.getInstance().getTempFolderPath() + "\\tmppython\\" + className + ".py";

    return PythonProcessExecuter.runExe(fileName);
  }

}
