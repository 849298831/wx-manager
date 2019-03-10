package com.example.manager.wxmanager.model;

import com.example.manager.wxmanager.model.common.PageModel;
import com.example.manager.wxmanager.model.common.PageSupport;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "test")
public class TestModel extends PageModel implements PageSupport{
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "ago")
    private Long ago;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgo() {
        return ago;
    }

    public void setAgo(Long ago) {
        this.ago = ago;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
