package com.company.edured.user.roles.admin.editor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.company.edured.user.User;
@Entity
public class Editor {
    @Id
    private int editorId;
    
    @OneToOne
    private User user;
}
