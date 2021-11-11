package com.example.admit.API;

import com.example.admit.dao.Rank.addRank;
import com.example.admit.dao.Rank.deleteRank;
import com.example.admit.dao.Rank.resivateRank;
import com.example.admit.dao.admit.admitDelete;
import com.example.admit.dao.admit.admitLogin;
import com.example.admit.dao.admit.admitRegister;
import com.example.admit.dao.admit.admitResivate;
import com.example.admit.dao.search;
import com.example.admit.dao.searchCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/admit",method = {RequestMethod.POST,RequestMethod.GET})
public class admit {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @RequestMapping("/login")
    @ResponseBody
    public boolean login(){
        admitLogin adl = new admitLogin();
        return adl.main(request,response);
    }

    @RequestMapping("/register")
    @ResponseBody
    public boolean register(){
        admitRegister adr = new admitRegister();
        return adr.main(request,response);
     }
     //状态更改
    @RequestMapping("/setstate")
    @ResponseBody
    public boolean setstate(){
        admitRegister adr = new admitRegister();
        boolean alex = adr.main(request,response);
        return alex;
    }
    //密码修改
    @RequestMapping("/resivatepassword")
    @ResponseBody
    public boolean resivatepassword(){
        admitRegister adr = new admitRegister();
        return adr.main(request,response);
    }
    @RequestMapping("getsession")
    @ResponseBody
    public String getSession(){
        String str = String.valueOf(request.getSession().getAttribute("admit"));
        System.out.print(str);
        return str;
    }
    @RequestMapping("getRank")
    @ResponseBody
    public String getRank(@RequestBody String str0){
        System.out.print(str0);
        search se = new search(str0);
        String str = se.getJson(request,"getRank").toString();
        return str;
    }
    @RequestMapping("resivateRank")
    @ResponseBody
    public boolean resivateRank(){
        resivateRank re = new resivateRank();
        return re.main(request,response);
    }
    @RequestMapping("deleteRank")
    @ResponseBody
    public boolean deleteRank(){
        deleteRank de = new deleteRank();
        return de.main(request,response);
    }
    @RequestMapping("addRank")
    @ResponseBody
    public boolean addRank(){
        addRank de = new addRank();
        return de.main(request,response);
    }
    @RequestMapping("admitLook")
    @ResponseBody
    public String admitLook(@RequestBody String str0){
        search se = new search(str0);
        String str = se.getJson(request,"admitLook").toString();
        return str;
    }

    @RequestMapping("admitinformation")
    @ResponseBody
    public String admitinformation(@RequestBody String str0){
        search se = new search(str0);
        String str = se.getJson(request,"admitinformation").toString();
        System.out.print(str+"ypfknddnggs");
        return str;
    }
    @RequestMapping("resivateadmit")
    @ResponseBody
    public boolean resivateadmit(){
        admitResivate ar  = new admitResivate();
        return ar.main(request,response);
    }
    @RequestMapping("deleteadmit")
    @ResponseBody
    public boolean deleteadmit(){
        admitDelete add = new admitDelete();
        return add.main(request,response);
    }
    @RequestMapping("information")
    @ResponseBody
    public String informationcount(){
        searchCount sc = new searchCount();
        String str =sc.getJson(request,"informationcount").toString();
        return str;
    }
    @RequestMapping("getinformation")
    @ResponseBody
    public String getinformation(@RequestBody String str0){
        search se = new search(str0);
        String str =se.getJson(request,"getinformation").toString();
        return str;
    }
}