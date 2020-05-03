package com.neimeng.workflow.taskHandler;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("subProcessHelper")
public class SubProcessHelperImpl {

    public List<String> getUserNames() {
        List<String> userNames = new ArrayList<>();
        userNames.add("test002");
        userNames.add("test003");
        return userNames;
    }

    // TODO 还不知道怎么传参数
//    public boolean isComplete(DelegateExecution execution) {
//        System.out.println("调用了isComplete, execution = " + execution);
//        return true;
//    }

    // 不传参数的情况下，会走这里
    public boolean isComplete() {
        System.out.println("调用了isComplete........................");
        System.out.println("调用了isComplete........................");
        System.out.println("调用了isComplete........................");
        System.out.println("调用了isComplete........................");
        return false;
    }
}