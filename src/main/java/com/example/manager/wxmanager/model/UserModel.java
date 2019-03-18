package com.example.manager.wxmanager.model;

import com.example.manager.wxmanager.model.common.PageModel;
import com.example.manager.wxmanager.model.common.PageSupport;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "m_user")
public class UserModel extends PageModel implements PageSupport,Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    /**
     * 用户code
     */
    @Column(name = "user_code")
    private String userCode;
    /**
     *用户名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     *用户密码
     */
    @Column(name = "user_pwd")
    private String userPwd;
    /**
     *真实姓名
     */
    @Column(name = "true_name")
    private String trueName;
    /**
     *微信openId
     */
    @Column(name = "wx_open_id")
    private String wxOpenId;
    /**
     * 微信头像
     */
    @Column(name = "wx_user_photo")
    private String wxUserPhoto;
    /**
     *用户手机号
     */
    @Column(name = "user_phone")
    private String userPhone;
    /**
     *学号
     */
    @Column(name = "user_student_code")
    private String userStudentCode;
    /**
     * 宿舍号
     */
    @Column(name ="dormitory_code")
    private String dormitoryCode;
    /**
     *用户位置，考勤点code
     */
    @Column(name = "user_address_code")
    private String userAddressCode;
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
     *是否是管理员 0 学生 1 管理人员 2 超级管理员
     */
    @Column(name = "is_admin")
    private Long isAdmin;
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

    public String getWxUserPhoto() {
        return wxUserPhoto;
    }

    public void setWxUserPhoto(String wxUserPhoto) {
        this.wxUserPhoto = wxUserPhoto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserStudentCode() {
        return userStudentCode;
    }

    public void setUserStudentCode(String userStudentCode) {
        this.userStudentCode = userStudentCode;
    }

    public String getUserAddressCode() {
        return userAddressCode;
    }

    public void setUserAddressCode(String userAddrsssCode) {
        this.userAddressCode = userAddrsssCode;
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

    public Long getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Long isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Long getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(Long dataFlag) {
        this.dataFlag = dataFlag;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getDormitoryCode() {
        return dormitoryCode;
    }

    public void setDormitoryCode(String dormitoryCode) {
        this.dormitoryCode = dormitoryCode;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public UserModel(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }
    public UserModel() { ;
    }
    public UserModel(String userCode,Long isAdmin){
        this.userCode = userCode;
        this.isAdmin = isAdmin;
    }
}
