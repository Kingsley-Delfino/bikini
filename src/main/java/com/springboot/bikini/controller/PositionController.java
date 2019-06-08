package com.springboot.bikini.controller;

import com.springboot.bikini.model.EmployeeDomain;
import com.springboot.bikini.model.JSONResult;
import com.springboot.bikini.model.PositionDomain;
import com.springboot.bikini.service.PositionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class PositionController {
    private PositionService positionService;

    public JSONResult positionRelease(HttpServletRequest request, PositionDomain positionDomain) {
        HttpSession session=request.getSession();
        String tel=(String)session.getAttribute("employerTel");
        int id=positionService.getEmployerId(tel);
        positionDomain.setPositionEmployerId(id);
        positionService.insertPosition(positionDomain);
        return new JSONResult("success");
    }
    /**
     *@description: 职位查询，具有分页功能
     *@param: @PositionDomain,pageNum,limit
     *@return: List<PositionDomain>
     */
    @RequestMapping("/employeeQuery")
    public JSONResult employeeQuery(PositionDomain positionDomain, HttpServletRequest request){
        int pageNum=Integer.parseInt(request.getParameter("page"));
        int limit=Integer.parseInt(request.getParameter("limit"));
        pageNum=1;
        limit=10000;
        List<PositionDomain> positionDomains =positionService.employeeSelectPosition(positionDomain,pageNum,limit);
        return new JSONResult(positionDomains);
    }
    /**
     *@description: 首页的职位查询
     *@param: @PositionDomain（只含有positionName）
     *@return:
    */
    @RequestMapping("/employeeQueryFirst")
    public JSONResult employeeQueryFirst(PositionDomain positionDomain){
        List<PositionDomain> positionDomains =positionService.employeeSelectPosition(positionDomain,1,10000);
        return new JSONResult(positionDomains);
    }
}
