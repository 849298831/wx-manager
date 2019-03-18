package com.example.manager.wxmanager.model;

import com.example.manager.wxmanager.model.common.PageModel;
import com.example.manager.wxmanager.model.common.PageSupport;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 人员来访实体类
 */
@Table(name = "m_visit")
public class VisitModel extends PageModel implements PageSupport,Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    /**
     * 位置code
     */
    @Column(name = "address_code")
    private String addressCode;
    /**
     * 来访code
     */
    @Column(name = "visit_code")
    private String visitCode;
    /**
     * 来访人姓名
     */
    @Column(name = "visit_name")
    private String visitName;
    /**
     * 来访人手机号
     */
    @Column(name = "visit_phone")
    private String visitPhone;
    /**
     * 来访原因
     */
    @Column(name = "visit_reason")
    private String visitReason;
    /**
     *创建时间
     */
    @Column(name = "create_time")
    private String createTime;
    /**
     *修改时间
     */
    @Column(name = "modify_time")
    private String modifyTime;
    /**
     *删除标志：0未删除 1 以删除
     */
    @Column(name = "data_flag")
    private Long dataFlag;
    @Transient
    private Integer limit;
    @Transient
    private Integer page;
    @Transient
    private String addressName;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisitCode() {
        return visitCode;
    }

    public void setVisitCode(String visitCode) {
        this.visitCode = visitCode;
    }

    public String getVisitName() {
        return visitName;
    }

    public void setVisitName(String visitName) {
        this.visitName = visitName;
    }

    public String getVisitPhone() {
        return visitPhone;
    }

    public void setVisitPhone(String visitPhone) {
        this.visitPhone = visitPhone;
    }

    public String getVisitReason() {
        return visitReason;
    }

    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(Long dataFlag) {
        this.dataFlag = dataFlag;
    }
}
