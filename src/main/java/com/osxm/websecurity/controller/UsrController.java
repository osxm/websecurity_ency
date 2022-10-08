/**  
* @Title: UsrController.java
* @Package com.osxm.websecurity.controller
* @Description: TODO
* @author XM
* @date 2022年10月7日 下午8:49:44
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.websecurity.controller;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsrController {

    @Autowired
    private EntityManager em;
    
    @RequestMapping("/delete")
    @Transactional
    public ModelAndView delete(@RequestParam String id,HttpServletRequest request) {
    	ModelAndView mv = null;
    	if("oscar".equals(request.getSession().getAttribute("username"))) {
    		em.createNativeQuery("delete from usr where id = "+id).executeUpdate();
    		mv = new ModelAndView("status");
    		mv.addObject("msg", "Delete Success!");
    		System.out.println("Delete Success!");
    	}else {
    		mv = new ModelAndView("login");
    	}
    	return mv;
    	
    }
}
