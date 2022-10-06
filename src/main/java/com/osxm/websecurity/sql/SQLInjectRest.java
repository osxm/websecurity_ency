/**  
* @Title: SQLInjectRest.java
* @Package com.osxm.websecurity.sql
* @Description: TODO
* @author XM
* @date 2022年9月22日 上午6:50:47
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.websecurity.sql;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sqlinject")
public class SQLInjectRest {
    
    @Autowired
    private EntityManager em;
    
    @GetMapping("/users")
    public String getUsr(@RequestParam String id) {
        StringBuffer sb = new StringBuffer();
        @SuppressWarnings("rawtypes")
        List list =em.createNativeQuery("select ACCOUNT_ID,DISPLAY_NAME from USR where ID = "+id).getResultList();
        if(list!=null) {
            if(list!=null&&list.size()>0) {
                for(int i=0;i<list.size();i++) {
                    Object row = list.get(i);
                    Object[] cells = (Object[])row;
                    for(Object obj:cells) {
                        sb.append(obj.toString());
                        sb.append(";");
                    }
                }
            }
        }
        return sb.toString();
    }
}