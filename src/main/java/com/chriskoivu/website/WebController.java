package com.chriskoivu.website;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import website.ImportXML;
import website.RepoService;
import website.RepoService2;

@Controller
//@RequestMapping(path="/demo") // This means URL's start with /demo (after 
public class WebController {
	@Autowired
	private UserRepository urepo;
	
	@RequestMapping("/")
	ModelAndView home() {
		 RepoService rs = new RepoService();
		 try {
			System.out.println("<<<<<< TESTING LOGGING IN TO JCR >>>>>>");
			rs.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 RepoService2 rs2 = new RepoService2();
		 try {
			 System.out.println("<<<<<<<< TESTING WRITE TO JCR >>>>>>>>>");
			rs2.test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 ImportXML jcrXML = new ImportXML();
		 try {
			System.out.println("<<<<<<<< TESTING XML IMPORT TO JCR >>>>>>>>>");
			jcrXML.importXML();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
//		 var params = new HashMap<String, HashMap<String, String>>();
		 var contentParams  = new HashMap<String, String>();
		 contentParams.put("title", "Welcome to your new Website!");
		 contentParams.put("footer","footer area");
		 contentParams.put("cardTitle", "this is a card");
		 contentParams.put("cardHeading", "this is the card heading");
		 contentParams.put("template", "card");
		 contentParams.put("cardContent", "this is the content");

		 return new ModelAndView("index", contentParams);		
	}
	@PostMapping(path="/add") // Map ONLY POST Requests
//	  public @ResponseBody String addNewUser (@RequestParam String name
//	      , @RequestParam String email) {
    public ModelAndView addNewUser (User user) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

		 ModelAndView mv = new ModelAndView();
		 mv.addObject(user);
		 urepo.save(user);
		 var params = new HashMap<String, String>();
		 params.put("result", "Item successfully saved");
		
		 return new ModelAndView("result", params);		
		 
	     
	  }

	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<User> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return urepo.findAll();
	  }
	  
	  @RequestMapping("/find")
	  public ModelAndView findUser(Integer uid) {
		  
		  User usr = urepo.findById(uid).orElse(new User());
		  
		  var name = new HashMap<String, String>();
		  name.put("name", usr.getName());
		  return new ModelAndView("name", name);
	  }
	  
	  @RequestMapping("/update")
	  public ModelAndView update(User user) {
		   String name = user.getName();	
		   System.out.println("================");
		   System.out.println(name);
		   
		   
		   System.out.println("================");
		   
		   
		   User usr = urepo.findByName(name);
		   int uid = usr.getId();		   
           urepo.save(usr);
           
           System.out.println(usr);
		   return new ModelAndView("update");
	  }
	  
	  

}
