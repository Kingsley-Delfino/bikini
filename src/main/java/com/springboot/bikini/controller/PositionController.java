package com.springboot.bikini.controller;

import com.springboot.bikini.model.EmployeeDomain;
import com.springboot.bikini.model.JSONResult;
import com.springboot.bikini.model.PositionDomain;
import com.springboot.bikini.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
    @RequestMapping("/employeeQueryFirst")
    public JSONResult employeeQueryFirst(@RequestBody PositionDomain positionDomain){
        List<HashMap> positionDomains =positionService.employeeSelectPosition(positionDomain);
        for (HashMap i:
             positionDomains) {
            System.out.println(i.toString());

        }

        return new JSONResult(positionDomains);
    }
    
    /**
     *@description: 申请职位
     *@param: positionId,employeeId
     *@return: void
     */
    @ResponseBody
    @RequestMapping("/employeeSendCv")
    public JSONResult employeeSendCv(HttpServletRequest request,@RequestBody PositionDomain positionDomain){
        int position_employer_id=positionDomain.getPositionEmployerId();
        System.out.println(position_employer_id+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
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
    @ResponseBody
    @RequestMapping("/releasePosition")
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
    @ResponseBody
    @RequestMapping("/selectAllPositionByOneself")
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
    @ResponseBody
    @RequestMapping("/deletePositionById")
    public JSONResult deletePosition(@RequestParam int positionId){
        positionService.deletePosition(positionId);
        return new JSONResult();
    }
    /**
     *@description: 判断有没有注册公司
     *@param:
     *@return:从msg中取值 success代表有公司，fail代表没有
     */
    @ResponseBody
    @RequestMapping("/haveCompany")
    public JSONResult haveCompany(HttpServletRequest request){
        HttpSession session=request.getSession();
        String tel=(String)session.getAttribute("employerTel");
        boolean status=positionService.companyIdIsNull(tel);
        if(status)
            return new JSONResult("success");
        else
            return new JSONResult("fail");
    }

}
