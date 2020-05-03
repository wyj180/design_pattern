package com.study.freemarker_demo.entity;


public class ItemExt extends Info {

    private Integer gb_number = 0; //编号
    private String sample_id= ""; //样品id
    // 样品状态（新建new、一致性检查yzx_check、样品批准审批sample_approve、
    // 发起人修改申请sample_renew、 分发跟踪信息distribute_sample、工厂接受处理factory_accept_deal、
    // 发起人处理驳回factory_reject_deal、有效effective、审计中auditing、作废中revoking、作废revoked）
    private String sample_status= "";
    private String sample_type= "";//原样/复制品 values: original, replica
    private String sample_sign_pe= "";//pe签样人
    private String sample_sign_cxd= ""; //cxd签样人
    private String sample_sign_pqm= ""; //pqm签样人
    private String sample_sign_other= "";//其他签样人
    private String sample_sign_date= "";//签样时间
    private String factory= "";//分发工厂
    private String pn= "";//pn
    private String memo= "";//备注
    private String check_time= "";//稽核时间

    private String product_name= ""; //商品名称
    private String yzx_check_info_status= ""; //一致性检查状态（实物与登记信息）是否
    private String yzx_check_pic_status= "";//一致性检查状态（实物与图纸）是否
    private String yzx_check_memo= "";//一致性检查备注
    private String approve_status= "";//批准审批 String 通过 reject
    private String approve_memo= ""; //审批备注
    private String distribute_method= "";//分发方式快递手提其他
    private String distribute_info= ""; //分发信息
    private String distribute_date= ""; //分发时间
    private String factory_accept_status= ""; //工厂接受状态确认接受 驳回
    private String factory_accept_memo= "";//工厂接受信息

    private String signed_time= "";//签样时间
    private String filed_time= "";//归档时间

    public ItemExt(){

    }

    public ItemExt(String sampleCategory, String odmSupplier){
        setSample_category(sampleCategory);
        setOdm_supplier(odmSupplier);
    }

    public Integer getGb_number() {
        return gb_number;
    }

    public void setGb_number(Integer gb_number) {
        this.gb_number = gb_number;
    }

    public String getSample_id() {
        return sample_id;
    }

    public void setSample_id(String sample_id) {
        this.sample_id = sample_id;
    }

    public String getSample_status() {
        return sample_status;
    }

    public void setSample_status(String sample_status) {
        this.sample_status = sample_status;
    }

    public String getSample_type() {
        return sample_type;
    }

    public void setSample_type(String sample_type) {
        this.sample_type = sample_type;
    }

    public String getSample_sign_pe() {
        return sample_sign_pe;
    }

    public void setSample_sign_pe(String sample_sign_pe) {
        this.sample_sign_pe = sample_sign_pe;
    }

    public String getSample_sign_cxd() {
        return sample_sign_cxd;
    }

    public void setSample_sign_cxd(String sample_sign_cxd) {
        this.sample_sign_cxd = sample_sign_cxd;
    }

    public String getSample_sign_pqm() {
        return sample_sign_pqm;
    }

    public void setSample_sign_pqm(String sample_sign_pqm) {
        this.sample_sign_pqm = sample_sign_pqm;
    }

    public String getSample_sign_other() {
        return sample_sign_other;
    }

    public void setSample_sign_other(String sample_sign_other) {
        this.sample_sign_other = sample_sign_other;
    }

    public String getSample_sign_date() {
        return sample_sign_date;
    }

    public void setSample_sign_date(String sample_sign_date) {
        this.sample_sign_date = sample_sign_date;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCheck_time() {
        return check_time;
    }

    public void setCheck_time(String check_time) {
        this.check_time = check_time;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getYzx_check_info_status() {
        return yzx_check_info_status;
    }

    public void setYzx_check_info_status(String yzx_check_info_status) {
        this.yzx_check_info_status = yzx_check_info_status;
    }

    public String getYzx_check_pic_status() {
        return yzx_check_pic_status;
    }

    public void setYzx_check_pic_status(String yzx_check_pic_status) {
        this.yzx_check_pic_status = yzx_check_pic_status;
    }

    public String getYzx_check_memo() {
        return yzx_check_memo;
    }

    public void setYzx_check_memo(String yzx_check_memo) {
        this.yzx_check_memo = yzx_check_memo;
    }

    public String getApprove_status() {
        return approve_status;
    }

    public void setApprove_status(String approve_status) {
        this.approve_status = approve_status;
    }

    public String getApprove_memo() {
        return approve_memo;
    }

    public void setApprove_memo(String approve_memo) {
        this.approve_memo = approve_memo;
    }

    public String getDistribute_method() {
        return distribute_method;
    }

    public void setDistribute_method(String distribute_method) {
        this.distribute_method = distribute_method;
    }

    public String getDistribute_info() {
        return distribute_info;
    }

    public void setDistribute_info(String distribute_info) {
        this.distribute_info = distribute_info;
    }

    public String getDistribute_date() {
        return distribute_date;
    }

    public void setDistribute_date(String distribute_date) {
        this.distribute_date = distribute_date;
    }

    public String getFactory_accept_status() {
        return factory_accept_status;
    }

    public void setFactory_accept_status(String factory_accept_status) {
        this.factory_accept_status = factory_accept_status;
    }

    public String getFactory_accept_memo() {
        return factory_accept_memo;
    }

    public void setFactory_accept_memo(String factory_accept_memo) {
        this.factory_accept_memo = factory_accept_memo;
    }

    public String getSigned_time() {
        return signed_time;
    }

    public void setSigned_time(String signed_time) {
        this.signed_time = signed_time;
    }

    public String getFiled_time() {
        return filed_time;
    }

    public void setFiled_time(String filed_time) {
        this.filed_time = filed_time;
    }
}
