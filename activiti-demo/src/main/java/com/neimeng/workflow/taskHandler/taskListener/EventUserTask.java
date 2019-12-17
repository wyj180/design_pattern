package com.neimeng.workflow.taskHandler.taskListener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

@Component("eventUserTask")
public class EventUserTask implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("执行了task listener...");
    }
}
