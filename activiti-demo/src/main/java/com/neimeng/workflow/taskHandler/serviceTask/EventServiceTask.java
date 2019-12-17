
package com.neimeng.workflow.taskHandler.serviceTask;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("eventServiceTask")
public class EventServiceTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("执行eventServiceTask...");
        System.out.println("执行eventServiceTask...");
        System.out.println("执行eventServiceTask...");
    }
}
