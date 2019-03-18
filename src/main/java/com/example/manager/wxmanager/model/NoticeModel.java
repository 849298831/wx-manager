package com.example.manager.wxmanager.model;

import com.example.manager.wxmanager.model.common.PageModel;
import com.example.manager.wxmanager.model.common.PageSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 公告实体类
 */
@Table(name = "m_notice")
public class NoticeModel extends PageModel implements PageSupport,Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    /**
     *公告code
     */
    @Column(name = "notice_code")
    private String noticeCode;
    /**
     *用户code
     */
    @Column(name = "user_code")
    private String userCode;
    /**
     *考勤点code
     */
    @Column(name = "address_code")
    private String addressCode;
    /**
     *公告内容
     */
    @Column(name = "content")
    private String content;
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
     *删除标志 0未删除 1以删除
     */
    @Column(name = "data_flag")
    private Long dataFlag;
    @Transient
    private Integer limit;
    @Transient
    private Integer page;
    @Transient
    private String addressName;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getNoticeCode() {
        return noticeCode;
    }

    public void setNoticeCode(String noticeCode) {
        this.noticeCode = noticeCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
