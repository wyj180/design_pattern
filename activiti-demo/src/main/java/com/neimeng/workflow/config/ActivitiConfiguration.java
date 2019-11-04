//package com.neimeng.workflow.config;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.neimeng.workflow.utils.ICustomProcessDiagramGenerator;
//import org.activiti.engine.impl.interceptor.SessionFactory;
//import org.activiti.spring.SpringProcessEngineConfiguration;
//import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
//import com.fengunion.scf.data.workflow.manager.CustomGroupEntityManagerFactory;
//import com.fengunion.scf.data.workflow.manager.CustomProcessDiagramGeneratorI;
//import com.fengunion.scf.data.workflow.manager.CustomUserEntityManagerFactory;
//import com.fengunion.scf.data.workflow.manager.ProcessHistoryManagerSessionFactory;
//
//
//@Configuration
//public class ActivitiConfiguration implements ProcessEngineConfigurationConfigurer{
//
//
//
//    @Override
//    public void configure(SpringProcessEngineConfiguration processEngineConfiguration) {
//        processEngineConfiguration.setDatabaseSchemaUpdate("none");// none true
//        processEngineConfiguration.setDatabaseType("mysql");
//
//        // 流程图字体
//        processEngineConfiguration.setActivityFontName("宋体");
//        processEngineConfiguration.setAnnotationFontName("宋体");
//        processEngineConfiguration.setLabelFontName("宋体");
//
//        processEngineConfiguration.setJpaHandleTransaction(false);
//        processEngineConfiguration.setJpaCloseEntityManager(false);
//
//
//    }
//}
