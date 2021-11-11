package com.example.admit.API;

import com.example.admit.dao.yang.addYang;
import com.example.admit.dao.yang.resivateYang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/yang",method = { RequestMethod.GET, RequestMethod.POST })
public class yang {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @RequestMapping("/addyang")
    @ResponseBody
    public boolean addyang(){
        addYang addy = new addYang();
        return addy.main(request,response);
    }

    @RequestMapping("/resivateyang")
    @ResponseBody
    public boolean reaivateyang(){
        resivateYang re = new resivateYang("resivateyaang");
        return re.main(request,response);
    }

}
