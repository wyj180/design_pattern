package com.study.ppt_demo.test01;

public class EventOnePageConstant {

	/**
	 * ppt第一页下标
	 */
	public static final int FIRST_SLIDE_INDEX = 0;

	/**
	 * 需要替换的变量前缀
	 */
	public final static String PPT_VARIABLE_PREFIX = "${var_";

	/**
	 * 导出ppt文本框占位符
	 */
	public static final String VAR_PROGRAM = "${var_program}";
	public static final String VAR_SUPPLIER = "${var_supplier}";
	public static final String VAR_PE = "${var_pe}";
	public static final String VAR_LEAD = "${var_lead}";
	public static final String VAR_LASTUPDATED = "${var_lastUpdated}";
	public static final String VAR_STATUS = "${overall_status}";
	public static final String VAR_PROGRAMKEYUPDATE = "${var_programKeyUpdate}";

	/**
	 * 导出ppt文本框内容前缀
	 */
	public static final String PROGRAM_PREFIX = "Program: ";
	public static final String SUPPLIER_PREFIX = "Supplier: ";
	public static final String PE_PREFIX = "PE: ";
	public static final String LEAD_PREFIX = "Lead: ";
	public static final String LASTUPDATED_PREFIX = "Last Updated: ";
	public static final String STATUS_PREFIX = "Overall Status: ";

}
