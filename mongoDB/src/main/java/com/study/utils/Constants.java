package com.study.utils;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyang on 2017/1/3.
 */
public final class Constants {
    private Constants() {
    }

    public static final String COOKIE_KEY_LASTURL = "__lasturl__";
    public static final String PROCESS_KEY_PREFIX = "lenovo_process_";
    // 应用关联的菜单的symbol的前缀, 如Res中的symbol = app_1; 则1为应用ID
    public static final String RES_APP_SYMBOL_PREFIX = "app_";

    public static class AppConfType {
        public static final String SCRIPT = "script";
        public static final String UI = "ui";
    }

    public static class AppConfKey {
        /**
         * 列表字段显示
         **/
        public static final String LIST_DISPLAY_COLUMN = "listDisplayColumn";
        /**
         * 过滤条件
         **/
        public static final String FILTER_CONDITION = "filterCondition";
        /**
         * 启动按钮
         **/
        public static final String STARTUP_BUTTON = "startupButton";
    }

    public static class ProcessConfType {
        public static final String ASSIGNEE_RULES = "assignee_rules";
        public static final String VARIABLE = "variable";
        public static final String FORM = "form";
        public static final String SCRIPT = "script";
    }

    public static class ProcessConfKey {
        public static final String ID = "id";
        public static final String UI_SCHEMA = "uiSchema";
        public static final String DATA_SCHEMA = "dataSchema";
        public static final String DEFAULT = "default";
        public static final String POST_SCRIPT = "post_script";
    }

    public static class MongoKeys {
        public static final String KEY_$or = "$or";
        public static final String KEY_$in = "$in";
        public static final String KEY_$set = "$set";
        public static final String KEY_$sum = "$sum";
        public static final String KEY_$push = "$push";
        public static final String KEY_$pull = "$pull";
        public static final String KEY_$group = "$group";
        public static final String KEY_$project = "$project";
        public static final String KEY_$elemMatch = "$elemMatch";

        public static final String KEY__id = "_id";
        public static final String KEY__app = "_app";
        public static final String KEY__app_appInstanceId = "_app.appInstanceId";

        public static final String KEY_updated = "updated";
        public static final String KEY_created = "created";
        public static final String KEY_createdBy = "createdBy";
        public static final String KEY_orgs = "orgs";
        public static final String KEY_roles = "roles";
        public static final String KEY_assignees = "assignees";
        public static final String KEY_taskId = "taskId";
        public static final String KEY_taskTitle = "taskTitle";
        public static final String KEY_taskDefKey = "taskDefKey";
        public static final String KEY_owner = "owner";
        public static final String KEY_ownerUsername = "ownerUsername";
        public static final String KEY_doneDatetime = "doneDatetime";
        public static final String KEY_appId = "appId";
        public static final String KEY_appTitle = "appTitle";
        public static final String KEY_appSymbol = "appSymbol";
        public static final String KEY_projectId = "projectId";
        public static final String KEY_appInstanceId = "appInstanceId";
        public static final String KEY_creatorUsername = "creatorUsername";

        public static final String KEY_nanoTime = "nanoTime";
        public static final String KEY_from = "from";
        public static final String KEY_to = "to";
        public static final String KEY_id = "id";

        public static final String KEY_app = "app";
        public static final String KEY_app_appId = "app.appId";
        public static final String KEY_app_updated = "app.updated";
        public static final String KEY_app_projectId = "app.projectId";
        public static final String KEY_app_appSymbol = "app.appSymbol";
        public static final String KEY_app_createdBy = "app.createdBy";
        public static final String KEY_app_appInstanceId = "app.appInstanceId";
        public static final String KEY_processInstanceId = "processInstanceId";
        public static final String KEY_executionId = "executionId";
        public static final String KEY_open = "open";
        public static final String KEY_done = "done";
        public static final String KEY_open_$ = "open.$";
        public static final String KEY_done_$ = "done.$";
        public static final String KEY_done_owner = "done.owner";
        public static final String KEY_open_taskId = "open.taskId";
        public static final String KEY_done_taskId = "done.taskId";
        public static final String KEY_businessData = "businessData";
        public static final String KEY_businessKey = "businessKey";
        public static final String KEY_businessData__app = "businessData._app";
        public static final String KEY_count = "count";

        public static final Integer VAL_1 = 1;
        public static final Integer VAL_0 = 0;
        public static final String VAL_null = null;
    }

    public static class MongoTables {
        public static final String ASSIGNEE_SELECTION = "assignee_selection";
        public static final String APP_TASK_ALL = "app_task_all";
        public static final String EXECUTION_FROM_TO = "execution_from_to";
        public static final List<String> ALL = new ArrayList<>();

        static {
            ALL.add(ASSIGNEE_SELECTION);
            ALL.add(APP_TASK_ALL);
            ALL.add(APP_TASK_ALL);
        }
    }

    public static class TaskIssueCodes {
        public static final String NO_ASSIGNEE = "na";//没有处理人
    }

    public static class ShowModel {
        public static final int POPUP = 0;
        public static final int EMBED = 1;
    }

    public static class StartupButtonType {
        public static final String FORM_START_BTN = "form_startup";
        public static final String APP_START_BTN = "app_startup";
    }
}
