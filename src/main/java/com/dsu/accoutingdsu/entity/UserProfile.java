package com.dsu.accoutingdsu.entity;
// Generated Aug 23, 2017 1:12:31 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * UserProfile generated by hbm2java
 */
@Entity
@Table(name = "user_profile",
         catalog = "organization"
)
public class UserProfile implements java.io.Serializable {

    private Integer userId;
    private Post post;
    private WorkCategory workCategory;
    private String userName;
    private String userSurname;
    private String userMiddleName;
    private Set reportCards = new HashSet(0);

    public UserProfile() {
    }

    public UserProfile(Post post, String userName, String userSurname) {
        this.post = post;
        this.userName = userName;
        this.userSurname = userSurname;
    }

    public UserProfile(Post post, WorkCategory workCategory, String userName, String userSurname, String userMiddleName, Set reportCards) {
        this.post = post;
        this.workCategory = workCategory;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userMiddleName = userMiddleName;
        this.reportCards = reportCards;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "user_id", unique = true, nullable = false)
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    public Post getPost() {
        return this.post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    public WorkCategory getWorkCategory() {
        return this.workCategory;
    }

    public void setWorkCategory(WorkCategory workCategory) {
        this.workCategory = workCategory;
    }

    @Column(name = "user_name", nullable = false)
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "user_surname", nullable = false)
    public String getUserSurname() {
        return this.userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    @Column(name = "user_middleName")
    public String getUserMiddleName() {
        return this.userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfile")
    public Set getReportCards() {
        return this.reportCards;
    }

    public void setReportCards(Set reportCards) {
        this.reportCards = reportCards;
    }

    @Override
    public String toString() {
        return "UserProfile{"
                + "userId=" + userId
                + ", userName=" + userName
                + ", userSurname=" + userSurname
                + ", userMiddleName=" + userMiddleName
                + ", post=" + post.getPost()
                + ", workCategory=" + workCategory.getCategory()
                + ", salary=" + post.getSalary() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.userId);
        hash = 59 * hash + Objects.hashCode(this.post);
        hash = 59 * hash + Objects.hashCode(this.workCategory);
        hash = 59 * hash + Objects.hashCode(this.userName);
        hash = 59 * hash + Objects.hashCode(this.userSurname);
        hash = 59 * hash + Objects.hashCode(this.userMiddleName);
        hash = 59 * hash + Objects.hashCode(this.reportCards);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserProfile other = (UserProfile) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.userSurname, other.userSurname)) {
            return false;
        }
        if (!Objects.equals(this.userMiddleName, other.userMiddleName)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.post, other.post)) {
            return false;
        }
        if (!Objects.equals(this.workCategory, other.workCategory)) {
            return false;
        }
        if (!Objects.equals(this.reportCards, other.reportCards)) {
            return false;
        }
        return true;
    }

}