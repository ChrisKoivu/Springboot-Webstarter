package website;
import javax.jcr.GuestCredentials;
import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;

public class RepoService2 {

	 public void test() throws Exception { 
		    Repository repository = JcrUtils.getRepository();
		        Session session = repository.login( 
		        new SimpleCredentials("admin", "admin".toCharArray()));
		        try { 
		            Node root = session.getRootNode(); 

		            // Store content 
		            Node hello = root.addNode("hello"); 
		            Node world = hello.addNode("world"); 
		            world.setProperty("message", "Hello, World!"); 
		            session.save(); 
                    System.out.println("#### SAVED NODE TO JCR #######");
		            // Retrieve content 
		            Node node = root.getNode("hello/world"); 
		            System.out.println("### GETTING PATH TO NEWLY CREATED NODE ####");
		            System.out.println(node.getPath()); 
		            
		            System.out.println("### PRINTING MESSAGE VALUE FROM JCR NODE ####");
		            System.out.println(node.getProperty("message").getString()); 

		            // Remove content 
		            System.out.println("### DELETING NEWLY CREATED NODE ####");
		            root.getNode("hello").remove(); 
		            session.save(); 
		        } finally { 
		            session.logout(); 
		        } 
		    } 
}
