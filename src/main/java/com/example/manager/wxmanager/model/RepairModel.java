package com.example.manager.wxmanager.model;

import com.example.manager.wxmanager.model.common.PageModel;
import com.example.manager.wxmanager.model.common.PageSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 报修实体类
 */
@Table(name = "m_repair")
public class RepairModel extends PageModel implements PageSupport,Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    /**
     *报修code
     */
    @Column(name = "repair_code")
    private String repairCode;
    /**
     *用户code
     */
    @Column(name = "user_code")
    private String userCode;
    /**
     *报修图片，json字符串
     */
    @Column(name = "repair_imgs")
    private String repairImgs;
    /**
     *报修描述
     */
    @Column(name = "repair_content")
    private String repairContent;
    /**
     * 维修状态
     */
    @Column(name = "repair_status")
    private Long repairStatus; // 0 已发起，1 已维修 2 已取消
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
    private List<String> repairImgList;
    @Transient
    private String trueName;
    @Transient
    private String userPhone;
    @Transient
    private String addressName;
    @Transient
    private String dormitoryCode;
    @Transient
    private String addressCode;
    @Transient
    private Integer limit;
    @Transient
    private Integer page;

    public List<String> getRepairImgList() {
        return repairImgList;
    }

    public void setRepairImgList(List<String> repairImgList) {
        this.repairImgList = repairImgList;
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

    public Long getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(Long repairStatus) {
        this.repairStatus = repairStatus;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
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

    public String getRepairCode() {
        return repairCode;
    }

    public void setRepairCode(String repairCode) {
        this.repairCode = repairCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getRepairImgs() {
        return repairImgs;
    }

    public void setRepairImgs(String repairImgs) {
        this.repairImgs = repairImgs;
    }

    public String getRepairContent() {
        return repairContent;
    }

    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
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
