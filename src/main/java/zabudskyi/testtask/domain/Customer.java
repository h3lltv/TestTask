package zabudskyi.testtask.domain;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Where(clause = "DELETED = false")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    @Column(updatable = false, nullable = false)
    private String email;
    private String phone;
    @Column(updatable = false)
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    @Column(name = "DELETED")
    private boolean deleted;

    public Customer() {
    }

    public Customer(String fullName, String email, String phone) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.updateDate=null;
        this.creationDate = LocalDateTime.now();
        this.deleted = false;
    }

    public void updateNameAndPhone(String newName, String newPhone){
        this.fullName=newName;
        this.phone=newPhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDeleted() {
        this.deleted = true;
    }
    public boolean getDeleted(boolean deleted){
        return deleted;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
