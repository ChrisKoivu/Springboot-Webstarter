package website;
import javax.jcr.GuestCredentials;
import javax.jcr.Repository;
import javax.jcr.Session; 
import org.apache.jackrabbit.commons.JcrUtils;

public class RepoService {

    /** 
    * The main entry point of the example application. 
    * 
    * @param args command line arguments (ignored) 
     * @return 
    * @throws Exception if an error occurs 
    */ 
    public void init() throws Exception { 
        Repository repository = JcrUtils.getRepository();
        Session session = repository.login(new GuestCredentials());
        try { 
        	System.out.println("#### ATTEMPTING TO LOGIN TO JCR #####");
            String user = session.getUserID(); 
            String name = repository.getDescriptor(Repository.REP_NAME_DESC); 
            System.out.println( 
            "Logged in as " + user + " to a " + name + " repository."); 
        } finally { 
            session.logout(); 
            System.out.println("### LOGGED OUT OF JCR ##### ");
        } 
    } 
}
