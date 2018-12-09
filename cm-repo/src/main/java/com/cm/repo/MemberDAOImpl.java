package com.cm.repo;

import com.cm.common.repo.MemberDAO;
import com.cm.entity.Member;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void addMember(Member member) {
        getCurrentSession().save(member);
    }

    @Override
    public void updateMember(Member member) {
        getCurrentSession().update(member);
    }

    @Override
    public void deleteMember(int id) {
        Member member = getMember(id);
        if(member!=null) {
            getCurrentSession().delete(member);
        }
    }

    @Override
    public Member getMember(int id) {
        return (Member)getCurrentSession().get(Member.class,id);
    }

    @Override
    public List<Member> getAllMembers() {
        return getCurrentSession().createQuery("SELECT m FROM Member m").list();
    }

    @Override
    public List<Member> getMembers(Integer sayfaNo, Integer sayfaBasinaSayi) {

        Query query;
        query = getCurrentSession().createSQLQuery("EXEC Member_List :sayfaNo , :sayfaBasinaSayi")
                .addEntity(Member.class)
                .setInteger("sayfaNo" ,sayfaNo)
                .setInteger("sayfaBasinaSayi" ,sayfaBasinaSayi);
          List<Member> memberList = query.list();
          return memberList;
    }

    @Override
    public List<String> getMemberPhones(Integer memberId) {
        return getCurrentSession().createSQLQuery("EXEC getMemberPhones  :memberId")
                .setInteger("memberId",memberId).list();
    }

    @Override
    public int getMemberCount() {
        return ((Integer)getCurrentSession().createSQLQuery("SELECT COUNT(*) FROM Member").uniqueResult()).intValue();
    }
}


