package com.cm.entity;

import javax.persistence.*;

@Entity
public class MemberNotification {
    private int id;
    private Member memberByMemberId;
    private Notification notificationByNotificationId;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberNotification that = (MemberNotification) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "memberId", referencedColumnName = "id", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }

    @ManyToOne
    @JoinColumn(name = "notificationId", referencedColumnName = "id", nullable = false)
    public Notification getNotificationByNotificationId() {
        return notificationByNotificationId;
    }

    public void setNotificationByNotificationId(Notification notificationByNotificationId) {
        this.notificationByNotificationId = notificationByNotificationId;
    }
}
