package com.springboot.bikini.controller;

import com.springboot.bikini.model.EmployeeDomain;
import com.springboot.bikini.model.JSONResult;
import com.springboot.bikini.model.PositionDomain;
import com.springboot.bikini.service.PositionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
public class PositionController {
    private PositionService positionService;

    public JSONResult positionRelease(HttpServletRequest request, @RequestBody PositionDomain positionDomain) {
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
    public JSONResult employeeQuery(@RequestBody PositionDomain positionDomain){

        List<HashMap> positionDomains =positionService.employeeSelectPosition(positionDomain);
        return new JSONResult(positionDomains);
    }
    /**
     *@description: 首页的职位查询
     *@param: @PositionDomain（只含有positionName）
     *@return:
    */
    @RequestMapping("/employeeQueryFirst")
    public JSONResult employeeQueryFirst(@RequestBody PositionDomain positionDomain){
        List<HashMap> positionDomains =positionService.employeeSelectPosition(positionDomain);
        return new JSONResult(positionDomains);
    }
    
    /**
     *@description: 申请职位
     *@param: positionId,employeeId
     *@return: void
    */
    @RequestMapping("/employeeSendCv")
    public JSONResult employeeSendCv(HttpServletRequest request,@RequestParam int position_employer_id){
        HttpSession session=request.getSession();
        String tel=(String)session.getAttribute("employeeTel");
        positionService.sendCv(tel,position_employer_id);
        return new JSONResult("success");
    }

    /**
     *@description: 发布职位
     *@param: PositionDomain
     *@return: void
    */
    public JSONResult positionRelease(@RequestBody PositionDomain positionDomain,HttpServletRequest request){
        HttpSession session=request.getSession();
        String tel=(String)session.getAttribute("employerTel");
        positionService.release(positionDomain,tel);
        return new JSONResult("success");
    }
    /**
     *@description: 雇主查看自己发布的职位
     *@param: void
     *@return: List<PositionDomain>
    */
    public JSONResult selectOneselfPosition(HttpServletRequest request){
        HttpSession session=request.getSession();
        String tel=(String)session.getAttribute("employerTel");
        List<PositionDomain> list=positionService.selectAllPosition(tel);
        return new JSONResult(list);
    }
    /**
     *@description: 雇主删除自己发布的某个职位
     *@param: positionId
     *@return: void
    */
    public JSONResult deletePosition(@RequestParam int positionId){
        positionService.deletePosition(positionId);
        return new JSONResult();
    }
}
