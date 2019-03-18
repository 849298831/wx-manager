package com.example.manager.wxmanager.model;

import com.example.manager.wxmanager.model.common.PageModel;
import com.example.manager.wxmanager.model.common.PageSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 签到实体类
 */
@Table(name = "m_sign_in")
public class SignInModel extends PageModel implements PageSupport,Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    /**
     *签到code
     */
    @Column(name = "sign_code")
    private String signCode;
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
    private String trueName;
    @Transient
    private String addressName;
    @Transient
    private String userStudentCode;
    @Transient
    private String dormitoryCode;
    @Transient
    private Integer limit;
    @Transient
    private Integer page;
    @Transient
    private String timestamp;

    /**
     *纬度
     */
    @Transient
    private BigDecimal addressLatitude;
    /**
     *经度
     */
    @Transient
    private BigDecimal addressLongitude;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getAddressLatitude() {
        return addressLatitude;
    }

    public void setAddressLatitude(BigDecimal addressLatitude) {
        this.addressLatitude = addressLatitude;
    }

    public BigDecimal getAddressLongitude() {
        return addressLongitude;
    }

    public void setAddressLongitude(BigDecimal addressLongitude) {
        this.addressLongitude = addressLongitude;
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

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getUserStudentCode() {
        return userStudentCode;
    }

    public void setUserStudentCode(String userStudentCode) {
        this.userStudentCode = userStudentCode;
    }

    public String getDormitoryCode() {
        return dormitoryCode;
    }

    public void setDormitoryCode(String dormitoryCode) {
        this.dormitoryCode = dormitoryCode;
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

    public String getSignCode() {
        return signCode;
    }

    public void setSignCode(String signCode) {
        this.signCode = signCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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


    @Override
    public String toString() {
        return "SignInModel{" +
                "userCode='" + userCode + '\'' +
                ", addressCode='" + addressCode + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", addressLatitude=" + addressLatitude +
                ", addressLongitude=" + addressLongitude +
                '}';
    }
}
