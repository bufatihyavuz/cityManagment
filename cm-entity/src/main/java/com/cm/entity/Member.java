package com.cm.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Member {
    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String mail;
    private String tcNo;
    private String job;
    private boolean gender;
    private boolean marialStatus;
    private Date birthday;
    private MemberRole memberRoleByMemberRoleId;
    private Collection<MemberBuildings> memberBuildingsById;
    private Collection<MemberNotification> memberNotificationsById;
    private Collection<MemberRequest> memberRequestsById;
    private Collection<Phone> phonesById;
    private Collection<Renter> rentersById;
    private Collection<Unit> unitsById;
    private Collection<Vehicle> vehiclesById;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "mail", nullable = false, length = 50)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "tcNo", nullable = false, length = 50)
    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    @Basic
    @Column(name = "job", nullable = false, length = 50)
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "gender", nullable = false)
    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "marialStatus", nullable = false)
    public boolean isMarialStatus() {
        return marialStatus;
    }

    public void setMarialStatus(boolean marialStatus) {
        this.marialStatus = marialStatus;
    }

    @Basic
    @Column(name = "birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (id != member.id) return false;
        if (gender != member.gender) return false;
        if (marialStatus != member.marialStatus) return false;
        if (name != null ? !name.equals(member.name) : member.name != null) return false;
        if (surname != null ? !surname.equals(member.surname) : member.surname != null) return false;
        if (username != null ? !username.equals(member.username) : member.username != null) return false;
        if (password != null ? !password.equals(member.password) : member.password != null) return false;
        if (mail != null ? !mail.equals(member.mail) : member.mail != null) return false;
        if (tcNo != null ? !tcNo.equals(member.tcNo) : member.tcNo != null) return false;
        if (job != null ? !job.equals(member.job) : member.job != null) return false;
        if (birthday != null ? !birthday.equals(member.birthday) : member.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (tcNo != null ? tcNo.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (gender ? 1 : 0);
        result = 31 * result + (marialStatus ? 1 : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "memberRoleId", referencedColumnName = "id", nullable = false)
    public MemberRole getMemberRoleByMemberRoleId() {
        return memberRoleByMemberRoleId;
    }

    public void setMemberRoleByMemberRoleId(MemberRole memberRoleByMemberRoleId) {
        this.memberRoleByMemberRoleId = memberRoleByMemberRoleId;
    }

    @OneToMany(mappedBy = "memberByMemberId")
    public Collection<MemberBuildings> getMemberBuildingsById() {
        return memberBuildingsById;
    }

    public void setMemberBuildingsById(Collection<MemberBuildings> memberBuildingsById) {
        this.memberBuildingsById = memberBuildingsById;
    }

    @OneToMany(mappedBy = "memberByMemberId")
    public Collection<MemberNotification> getMemberNotificationsById() {
        return memberNotificationsById;
    }

    public void setMemberNotificationsById(Collection<MemberNotification> memberNotificationsById) {
        this.memberNotificationsById = memberNotificationsById;
    }

    @OneToMany(mappedBy = "memberByMemberId")
    public Collection<MemberRequest> getMemberRequestsById() {
        return memberRequestsById;
    }

    public void setMemberRequestsById(Collection<MemberRequest> memberRequestsById) {
        this.memberRequestsById = memberRequestsById;
    }

    @OneToMany(mappedBy = "memberByMemberId")
    public Collection<Phone> getPhonesById() {
        return phonesById;
    }

    public void setPhonesById(Collection<Phone> phonesById) {
        this.phonesById = phonesById;
    }

    @OneToMany(mappedBy = "memberByMemberId")
    public Collection<Renter> getRentersById() {
        return rentersById;
    }

    public void setRentersById(Collection<Renter> rentersById) {
        this.rentersById = rentersById;
    }

    @OneToMany(mappedBy = "memberByMemberId")
    public Collection<Unit> getUnitsById() {
        return unitsById;
    }

    public void setUnitsById(Collection<Unit> unitsById) {
        this.unitsById = unitsById;
    }

    @OneToMany(mappedBy = "memberByMemberId")
    public Collection<Vehicle> getVehiclesById() {
        return vehiclesById;
    }

    public void setVehiclesById(Collection<Vehicle> vehiclesById) {
        this.vehiclesById = vehiclesById;
    }
}
