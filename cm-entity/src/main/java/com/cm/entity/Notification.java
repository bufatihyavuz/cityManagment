package com.cm.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Notification {
    private int id;
    private String description;
    private String notificationType;
    private String title;
    private Collection<MemberNotification> memberNotificationsById;

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
    @Column(name = "description", nullable = false, length = 250)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "notificationType", nullable = false, length = 50)
    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (notificationType != null ? !notificationType.equals(that.notificationType) : that.notificationType != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (notificationType != null ? notificationType.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "notificationByNotificationId")
    public Collection<MemberNotification> getMemberNotificationsById() {
        return memberNotificationsById;
    }

    public void setMemberNotificationsById(Collection<MemberNotification> memberNotificationsById) {
        this.memberNotificationsById = memberNotificationsById;
    }
}
