package com.study.email.demo02;

import java.math.BigInteger;
import java.util.Date;

public class EventSa {

	public EventSa() {
		super();
	}

	public EventSa(String mtm, String packingBomName, String waveAndFactorySite, String country, Date ok2sDate,
			Date saDate) {
		super();
		this.mtm = mtm;
		this.packingBomName = packingBomName;
		this.waveAndFactorySite = waveAndFactorySite;
		this.country = country;
		this.ok2sDate = ok2sDate;
		this.saDate = saDate;
	}

	private BigInteger id;

	private String no;

	private String internalName;

	private String customerSw;

	private String marketingName;

	private String inhouse;

	private String mtm;

	private String packingBomName;

	private String waveAndFactorySite;

	private String country;

	private Date ok2sDate;

	private Date saDate;

	private String saStatus;

	private String necessaryActions;

	private String exclusions;

	private String componentQuality;

	private String componentQualityOwner;

	private String fpy;

	private String fpyOwner;

	private String oqc;

	private String oqcOwer;

	private String xcsa;

	private String xcsaOwer;

	private String packagingAndLabelsApprovals;

	private String packagingAndLabelsApprovalsOwer;

	private String taSwReleasePlan;

	private String taSwReleasePlanOwer;

	private String smvApproved;

	private String smvApprovedOwer;

	private String saftyAndComplianceSummary;

	private String saftyAndComplianceSummaryOwer;

	private String capacity;

	private String capacityOwer;

	private String cfcReadiness;

	private String cfcReadinessOwer;

	private String postSalesSupport;

	private String postSalesSupportOwer;

	private Date gmtCreate;

	private Date gmtModified;

	private String reviewer;

	private String creator;

	private String reviewerBySupplier;

	private String reviewerByService;

	private Integer processStatus;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getInternalName() {
		return internalName;
	}

	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	public String getCustomerSw() {
		return customerSw;
	}

	public void setCustomerSw(String customerSw) {
		this.customerSw = customerSw;
	}

	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public String getInhouse() {
		return inhouse;
	}

	public void setInhouse(String inhouse) {
		this.inhouse = inhouse;
	}

	public String getMtm() {
		return mtm;
	}

	public void setMtm(String mtm) {
		this.mtm = mtm;
	}

	public String getPackingBomName() {
		return packingBomName;
	}

	public void setPackingBomName(String packingBomName) {
		this.packingBomName = packingBomName;
	}

	public String getWaveAndFactorySite() {
		return waveAndFactorySite;
	}

	public void setWaveAndFactorySite(String waveAndFactorySite) {
		this.waveAndFactorySite = waveAndFactorySite;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getOk2sDate() {
		return ok2sDate;
	}

	public void setOk2sDate(Date ok2sDate) {
		this.ok2sDate = ok2sDate;
	}

	public Date getSaDate() {
		return saDate;
	}

	public void setSaDate(Date saDate) {
		this.saDate = saDate;
	}

	public String getSaStatus() {
		return saStatus;
	}

	public void setSaStatus(String saStatus) {
		this.saStatus = saStatus;
	}

	public String getNecessaryActions() {
		return necessaryActions;
	}

	public void setNecessaryActions(String necessaryActions) {
		this.necessaryActions = necessaryActions;
	}

	public String getExclusions() {
		return exclusions;
	}

	public void setExclusions(String exclusions) {
		this.exclusions = exclusions;
	}

	public String getComponentQuality() {
		return componentQuality;
	}

	public void setComponentQuality(String componentQuality) {
		this.componentQuality = componentQuality;
	}

	public String getComponentQualityOwner() {
		return componentQualityOwner;
	}

	public void setComponentQualityOwner(String componentQualityOwner) {
		this.componentQualityOwner = componentQualityOwner;
	}

	public String getFpy() {
		return fpy;
	}

	public void setFpy(String fpy) {
		this.fpy = fpy;
	}

	public String getFpyOwner() {
		return fpyOwner;
	}

	public void setFpyOwner(String fpyOwner) {
		this.fpyOwner = fpyOwner;
	}

	public String getOqc() {
		return oqc;
	}

	public void setOqc(String oqc) {
		this.oqc = oqc;
	}

	public String getOqcOwer() {
		return oqcOwer;
	}

	public void setOqcOwer(String oqcOwer) {
		this.oqcOwer = oqcOwer;
	}

	public String getXcsa() {
		return xcsa;
	}

	public void setXcsa(String xcsa) {
		this.xcsa = xcsa;
	}

	public String getXcsaOwer() {
		return xcsaOwer;
	}

	public void setXcsaOwer(String xcsaOwer) {
		this.xcsaOwer = xcsaOwer;
	}

	public String getPackagingAndLabelsApprovals() {
		return packagingAndLabelsApprovals;
	}

	public void setPackagingAndLabelsApprovals(String packagingAndLabelsApprovals) {
		this.packagingAndLabelsApprovals = packagingAndLabelsApprovals;
	}

	public String getPackagingAndLabelsApprovalsOwer() {
		return packagingAndLabelsApprovalsOwer;
	}

	public void setPackagingAndLabelsApprovalsOwer(String packagingAndLabelsApprovalsOwer) {
		this.packagingAndLabelsApprovalsOwer = packagingAndLabelsApprovalsOwer;
	}

	public String getTaSwReleasePlan() {
		return taSwReleasePlan;
	}

	public void setTaSwReleasePlan(String taSwReleasePlan) {
		this.taSwReleasePlan = taSwReleasePlan;
	}

	public String getTaSwReleasePlanOwer() {
		return taSwReleasePlanOwer;
	}

	public void setTaSwReleasePlanOwer(String taSwReleasePlanOwer) {
		this.taSwReleasePlanOwer = taSwReleasePlanOwer;
	}

	public String getSmvApproved() {
		return smvApproved;
	}

	public void setSmvApproved(String smvApproved) {
		this.smvApproved = smvApproved;
	}

	public String getSmvApprovedOwer() {
		return smvApprovedOwer;
	}

	public void setSmvApprovedOwer(String smvApprovedOwer) {
		this.smvApprovedOwer = smvApprovedOwer;
	}

	public String getSaftyAndComplianceSummary() {
		return saftyAndComplianceSummary;
	}

	public void setSaftyAndComplianceSummary(String saftyAndComplianceSummary) {
		this.saftyAndComplianceSummary = saftyAndComplianceSummary;
	}

	public String getSaftyAndComplianceSummaryOwer() {
		return saftyAndComplianceSummaryOwer;
	}

	public void setSaftyAndComplianceSummaryOwer(String saftyAndComplianceSummaryOwer) {
		this.saftyAndComplianceSummaryOwer = saftyAndComplianceSummaryOwer;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getCapacityOwer() {
		return capacityOwer;
	}

	public void setCapacityOwer(String capacityOwer) {
		this.capacityOwer = capacityOwer;
	}

	public String getCfcReadiness() {
		return cfcReadiness;
	}

	public void setCfcReadiness(String cfcReadiness) {
		this.cfcReadiness = cfcReadiness;
	}

	public String getCfcReadinessOwer() {
		return cfcReadinessOwer;
	}

	public void setCfcReadinessOwer(String cfcReadinessOwer) {
		this.cfcReadinessOwer = cfcReadinessOwer;
	}

	public String getPostSalesSupport() {
		return postSalesSupport;
	}

	public void setPostSalesSupport(String postSalesSupport) {
		this.postSalesSupport = postSalesSupport;
	}

	public String getPostSalesSupportOwer() {
		return postSalesSupportOwer;
	}

	public void setPostSalesSupportOwer(String postSalesSupportOwer) {
		this.postSalesSupportOwer = postSalesSupportOwer;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getReviewerBySupplier() {
		return reviewerBySupplier;
	}

	public void setReviewerBySupplier(String reviewerBySupplier) {
		this.reviewerBySupplier = reviewerBySupplier;
	}

	public String getReviewerByService() {
		return reviewerByService;
	}

	public void setReviewerByService(String reviewerByService) {
		this.reviewerByService = reviewerByService;
	}

	public Integer getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(Integer processStatus) {
		this.processStatus = processStatus;
	}

}