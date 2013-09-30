package ecompilerlab.service.app;


/**
 * Created with IntelliJ IDEA.
 * User: shehan.fernando
 * Date: 7/6/13
 * Time: 6:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationSettings
{

  private static ApplicationSettings settings = new ApplicationSettings();

  private String javaHome;

  private String testClassName;

  private String libraryBasePath;

  private String tmpFolderPath;

  private String mingw_home;

  private String pythonHome;


    public static ApplicationSettings getInstance()
  {
    return settings;
  }

  public static String APPLICATION_SETTING_PATH = "";

  static
  {
    String userDirectory = System.getenv("ELAB_HOME");
    APPLICATION_SETTING_PATH = userDirectory + "\\app\\settings.dat";
  }

  public void setJavaHome(String javaHome)
  {
    this.javaHome = javaHome;
  }

  public String getJavaHome()
  {
    return javaHome;
  }

  public String getTestClassName()
  {
    return testClassName;
  }

  public void setTestClassName(String testClassName)
  {
    this.testClassName = testClassName;
  }

  public String getLibraryBasePath()
  {
    return libraryBasePath;
  }

  public void setLibraryBasePath(String libraryBasePath)
  {
    this.libraryBasePath = libraryBasePath;
  }

    public String getTempFolderPath() {
        return this.tmpFolderPath;
    }

    public void setTmpFolderPath(String tmpFolderPath) {
        this.tmpFolderPath = tmpFolderPath;
    }

    public void setMinGWHome(String mingw_home) {
        this.mingw_home = mingw_home;
    }

    public String getMinGWHome()
    {
       return this.mingw_home;
    }

    public String getPythonHome() {
        return pythonHome;
    }

    public void setPythonHome(String pythonHome) {
        this.pythonHome = pythonHome;
    }
}
