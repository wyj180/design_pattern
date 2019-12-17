package com.example.es7.constants;

/**
 * 自定义表单常量
 */
public final class EventFormConstant {

    public static class CommonColumn {
        /**
         * id_数据库字段名称
         */
        public static final String COLUMN_ID = "id";

        /**
         * 子表中关联的主表id名称
         */
        public static final String COLUMN_MAIN_TABLE_ID = "main_table_id";

        /**
         * 系统编号_数据库字段名称
         */
        public static final String COLUMN_EVENT_NO = "no";

        /**
         * 流程状态_数据库字段名称
         */
        public static final String COLUMN_PROCESS_STATUS = "process_status";

        /**
         * 流程状态名称_数据库字段名称
         */
        public static final String COLUMN_PROCESS_STATUS_NAME = "process_status_name";

        /**
         * creator
         */
        public static final String COLUMN_EVENT_CREATOR = "creator";

        /**
         * 外键关联名称
         */
        public static final String COMMON_FOREIGN_ID = "main_table_id";

        /**
         * 下一步处理人
         */
        public static final String COLUMN_NEXT_ASSIGNEE = "nextAssignee";

        /**
         * 创建时间_数据库字段名称
         */
        public static final String COLUMN_CREATE_TIME = "gmt_create";

        /**
         * 数据修改时间_数据库字段名称
         */
        public static final String COLUMN_MODIFIED_TIME = "gmt_modified";

        public static final String DESC = "desc";

        public static final String ASC = "asc";
    }

}
