package com.cm.business;

import com.cm.common.business.MemberService;
import com.cm.common.repo.MemberDAO;
import com.cm.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public void addMember(Member member) {
        memberDAO.addMember(member);
    }

    @Override
    public void updateMember(Member member) {
        memberDAO.updateMember(member);
    }

    @Override
    public void deleteMember(int id) {
        memberDAO.deleteMember(id);
    }

    @Override
    public Member getMember(int id) {
        return memberDAO.getMember(id);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberDAO.getAllMembers();
    }

    @Override
    public List<Member> getMembers(Integer sayfaNo, Integer sayfaBasinaSayi) {
        return memberDAO.getMembers(sayfaNo,sayfaBasinaSayi);
    }

    @Override
    public List<String> getMemberPhones(Integer memberId) {
        return memberDAO.getMemberPhones(memberId);
    }

    @Override
    public int getMemberCount() {
        return memberDAO.getMemberCount();
    }
}
