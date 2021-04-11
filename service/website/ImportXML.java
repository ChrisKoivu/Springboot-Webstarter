package website;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.*; 
import java.io.FileInputStream;
import org.apache.jackrabbit.commons.JcrUtils;

public class ImportXML {

	 public void importXML() throws Exception { 
		  Repository repository = JcrUtils.getRepository();
          Session session = repository.login( 
          new SimpleCredentials("admin", "admin".toCharArray()));
          try { 
              Node root = session.getRootNode(); 
              System.out.println("<<<<###### IMPORTING XML FILE #######>>>>>>");

              // Import the XML file unless already imported 
              if (!root.hasNode("importxml")) { 
                  System.out.print("Importing xml... "); 

                  // Create an unstructured node under which to import the XML 
                  Node node = root.addNode("importxml", "nt:unstructured"); 
                  
                  System.out.println("LOOKING FOR FILE HERE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                  System.out.println(System.getProperty("user.dir"));

                  // Import the file "test.xml" under the created node 
                  FileInputStream xml = new FileInputStream("test.xml");
               
                  session.importXML( 
                  node.getPath(), xml, ImportUUIDBehavior.IMPORT_UUID_CREATE_NEW); 
                  xml.close();
                  session.save(); 
                  System.out.println("done."); 
              } 
              System.out.println("<<<<###### IMPORT OF XML FILE COMPLETED #######>>>>>>");

              System.out.println("<<<<###### DUMP ROOT NODE FROM JCR #######>>>>>>");
              //output the repository content
              dump(root); 
              System.out.println("<<<<######  JCR NODE DUMP COMPLETE #######>>>>>>");
          } finally { 
              session.logout(); 
              System.out.println("<<<<###### LOGGED OUT OF JCR SESSION  #######>>>>>>");
          } 
	} 
	 
	 /** Recursively outputs the contents of the given node. */ 
	    private static void dump(Node node) throws RepositoryException { 
	        // First output the node path 
	        System.out.println(node.getPath()); 
	        // Skip the virtual (and large!) jcr:system subtree 
	        if (node.getName().equals("jcr:system")) { 
	            return; 
	        } 

	        // Then output the properties 
	        PropertyIterator properties = node.getProperties(); 
	        while (properties.hasNext()) { 
	            Property property = properties.nextProperty(); 
	            if (property.getDefinition().isMultiple()) { 
	                // A multi-valued property, print all values 
	                Value[] values = property.getValues(); 
	                for (int i = 0; i < values.length; i++) { 
	                    System.out.println( 
	                    property.getPath() + " = " + values[i] .getString()); 
	                } 
	            } else { 
	                // A single-valued property 
	                System.out.println( 
	                property.getPath() + " = " + property.getString()); 
	            } 
	        } 

	        // Finally output all the child nodes recursively 
	        NodeIterator nodes = node.getNodes(); 
	        while (nodes.hasNext()) { 
	            dump(nodes.nextNode()); 
	        } 
	    } 
}
