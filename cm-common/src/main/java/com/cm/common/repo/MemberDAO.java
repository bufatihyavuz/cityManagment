package com.cm.common.repo;

import com.cm.entity.Member;

import java.util.List;

public interface MemberDAO {

    public void addMember(Member member);
    public void updateMember(Member member);
    public void deleteMember(int id);
    public Member getMember (int id);
    public List<Member> getAllMembers();
    public List<Member> getMembers(Integer sayfaNo ,Integer sayfaBasinaSayi);
    public List<String> getMemberPhones(Integer memberId);
    public int getMemberCount();
}
