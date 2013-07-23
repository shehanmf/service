package ecompilerlab.service.app.c;

import ecompilerlab.service.app.AbstractECodeRunner;
import ecompilerlab.service.app.CompileResult;
import ecompilerlab.service.app.ExecuteResult;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/7/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class CECodeRunner extends AbstractECodeRunner
{
  @Override
  public ExecuteResult executeCode(String className, CompileResult compileResult)
  {

    String exeName = "H:\\Project\\service\\tmpdir\\tmpc\\" + className + ".exe";

    return CProcessExecuter.runExe(exeName);
  }
}
