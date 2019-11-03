package com.neimeng.workflow.entity;

public class ResponseCode {

	/**
	 * failure
	 */
	public static final int FAILURE = 0;
	/**
	 * success
	 */
	public static final int SUCCESS = 1;

	/**
	 * business error
	 */
	public static final int BUSINESS_ERROR = 10;

	/**
	 * not logged in
	 */
	public static final int NO_LOGIN = -1;

	/**
	 * Account doesn't exists
	 */
	public static final int NO_ACCOUNT = -2;

	/**
	 * account password error.
	 */
	public static final int CERTIFICATE_ERROR = -3;

	/**
	 * check parameter error
	 */
	public static final int PARAMETER_CHECK_ERROR = -4;

	/**
	 * itcode error.
	 */
	public static final int ITCODE_AUTHENTICATION_ERROR = -5;

	/**
	 * no permission
	 */
	public static final int NO_PERMISSION = -10;

	/**
	 * enum convert
	 */
	public static final int ENUM_CONVERT_ERROR = -20;

	/**
	 * option error
	 */
	public static final int EVENT_OPTION_CHECK_ERROR = -100;
	/**
	 * permission error
	 */
	public static final int EVENT_PERMISSION_CHECK_ERROR = -101;

	/**
	 * task error
	 */
	public static final int EVENT_TASK_CHECK_ERROR = -102;

	/**
	 * upload file max size
	 *
	 * @param null
	 * @return
	 **/
	public static final int COMMON_FILE_UPLOAD_MAX_SIZE = -60;



	/**
	 * ldap account error
	 */
	public static final int LDAP_ACCOUNT_ERROR = 1040;
	/**
	 * ldap account exists
	 */
	public static final int LDAP_ACCOUNT_DUP = 1041;
	/**
	 * ldap account auth failed
	 */
	public static final int LDAP_ACCOUNT_AUTH_FAILED = 1042;
	/**
	 * ldap superuser auth failed
	 */
	public static final int LDAP_SUPERUSER_AUTH_FAILED = 1043;
	/**
	 * ldap server connection failed
	 */
	public static final int LDAP_SERVER_CONNECTION_ERROR = 1044;

	/**
	 * parse file failed
	 */
	public static final int PARSE_FILE_ERROR = 1001;


}
