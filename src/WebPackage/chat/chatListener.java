package WebPackage.chat;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import WebPackage.user.findUserInfo;

/**
 * Application Lifecycle Listener implementation class chatListener
 *
 */
@WebListener
public class chatListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public chatListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ServletContext sc  = arg0.getServletContext();
    	//findUserInfo us = new findUserInfo();
    	//sc.setAttribute("findUserInfo", us);
    }
	
}
