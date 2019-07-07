package WebPackage.login;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import WebPackage.database.DBInfo;

/**
 * Application Lifecycle Listener implementation class listener
 *
 */
@WebListener
public class listener implements ServletContextListener {
 
    /**
     * Default constructor. 
     */
    public listener() {
        
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	LogInInfo log = new LogInInfo();
    	ServletContext context = arg0.getServletContext();
    	context.setAttribute(DBInfo.Attribute_Name, log);
    }
	
}