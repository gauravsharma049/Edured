package com.company.edured.user.roles.admin.administrator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.company.edured.user.User;

@Entity
public class Administrator {
    @Id
    private int adminId;
    
    @OneToOne
    private User user;
}
