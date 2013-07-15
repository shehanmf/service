package ecompilerlab.service.app;

import ecompilerlab.service.app.java.JavaECodeFormatter;
import ecompilerlab.service.app.java.JavaECodeRunner;
import ecompilerlab.service.app.java.JavaECompiler;
import ecompilerlab.service.app.java.JavaEResourceFinder;

/**
 * Created with IntelliJ IDEA.
 * User: Shehan
 * Date: 7/7/13
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class JavaECompilerFactory extends ECompilerAbstractFactory
{
  @Override
  AbstractECodeFormatter createCodeFormatter()
  {
    return new JavaECodeFormatter();
  }

  @Override
  AbstractECompiler createCodeCompiler()
  {
    return new JavaECompiler();
  }

  @Override
  AbstractECodeRunner createCodeRunner()
  {
    return new JavaECodeRunner();
  }

  @Override
  AbstractEResourceFinder createResourceFinder()
  {
    return new JavaEResourceFinder();
  }
}
