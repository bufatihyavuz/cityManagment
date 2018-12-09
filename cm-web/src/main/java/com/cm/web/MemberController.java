package com.cm.web;

import com.cm.common.business.MemberService;
import com.cm.common.business.PhoneService;
import com.cm.entity.Member;
import com.cm.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/member_list/{sayfaNo}" ,method = RequestMethod.GET)
    public ModelAndView MemberList(@PathVariable("sayfaNo")Integer sayfaNo){
        ModelAndView modelAndView = new ModelAndView("member_list");
        List<Member> memberList = memberService.getMembers(sayfaNo ,10);
        modelAndView.addObject("Members",memberList);
        List<String> memberPhoneList;
        ArrayList<List<String>> arrayList = new ArrayList<List<String>>();
        for(int i = 0 ; i < memberList.size() ; i++){
            memberPhoneList = memberService.getMemberPhones(memberList.get(i).getId());
            arrayList.add(memberPhoneList);
        }
        modelAndView.addObject("arrayList",arrayList);
        return modelAndView;
    }

    @RequestMapping(value = "/member_add" ,method = RequestMethod.GET)
    public ModelAndView MemberAddPage(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("member_add");
        modelAndView.addObject("member" ,new Member());
        Member member = new Member();
        List<Phone> phoneList =(List<Phone>) member.getPhonesById();
        modelAndView.addObject("phoneList",phoneList);
        return modelAndView;
    }

    @RequestMapping(value = "/member_add" ,method = RequestMethod.POST)
    public ModelAndView MemberAdd(@ModelAttribute Member member , HttpServletRequest request){
        memberService.addMember(member);
        Phone phone = new Phone();
        String phoneName  =request.getParameter("phone1");
        String phoneName2  =request.getParameter("phone2");

        if(phoneName=="") {
            phoneName = "Phone1";
        }
        phone.setPhone(phoneName);
        phone.setMemberByMemberId(member);
        phoneService.addPhone(phone);

        if(phoneName2=="") {
            phoneName2 = "Phone2";
        }
        phone.setPhone(phoneName2);
        phone.setMemberByMemberId(member);
        phoneService.addPhone(phone);

        ModelAndView modelAndView = new ModelAndView("redirect:"+"/member_list/1");
        return modelAndView;
    }

    @RequestMapping(value = "/member_update/{id}", method = RequestMethod.GET)
    public ModelAndView MemberUpdatePage(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("member_update");
        List<String> phoneList = phoneService.getPhones(id);
        String phone1 = phoneList.get(0);
        String phone2 = phoneList.get(1);
        Member member = memberService.getMember(id);
        modelAndView.addObject("member" ,member);
        modelAndView.addObject("phone1",phone1);
        modelAndView.addObject("phone2",phone2);
        return modelAndView;
    }

    @RequestMapping(value = "/member_update/{id}" ,method = RequestMethod.POST)
    public ModelAndView MemberUpdate(@ModelAttribute Member member ,@PathVariable Integer id , HttpServletRequest request){
        memberService.updateMember(member);
        ModelAndView modelAndView = new ModelAndView("redirect:"+"/member_list/1");
        String phoneName = request.getParameter("phone1");
        String phoneName2 = request.getParameter("phone2");
        Phone phone = new Phone();
        phone.setPhone(phoneName);
        phone.setMemberByMemberId(memberService.getMember(id));
        phone.setId(phoneService.getPhoneIdsByMemberId(id).get(0));
        phoneService.updatePhone(phone);
        phone.setPhone(phoneName2);
        phone.setMemberByMemberId(memberService.getMember(id));
        phone.setId(phoneService.getPhoneIdsByMemberId(id).get(1));
        phoneService.updatePhone(phone);
        return modelAndView;
    }

    @RequestMapping(value = "/member_delete/{id}" ,method = RequestMethod.GET)
    public ModelAndView MemberDelete(@PathVariable("id") Integer id,HttpServletRequest request){
        String referer = request.getHeader("Referer");
        memberService.deleteMember(id);
        ModelAndView modelAndView = new ModelAndView("redirect:" + referer);
        return modelAndView;
    }

}
