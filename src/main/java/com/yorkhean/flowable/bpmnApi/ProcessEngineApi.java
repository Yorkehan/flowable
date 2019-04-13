package com.yorkhean.flowable.bpmnApi;

import org.flowable.engine.*;

import java.util.Map;

/**
 * @ClassName ProcessEngine
 * @Description 流程引擎
 * @Author yorkehan
 * @Date 2019/4/11 22:27
 */

public class ProcessEngineApi {

    /**
     * @Description 获取流程引擎类/服务类
     *
     * 流程引擎管理类         ProcessEngines                   interface
     * 流程引擎类            processEngine
     * 操作流程定            RepositoryService
     * 动态Bpmn服务         DynamicBpmnService
     * 操作流程表单           FormService
     * 查询历史表数据          HistoryService
     * 操作用户或组           IdentityService
     * 执行cmd以及job相关     ManagementSer
     * 流程引擎配置类          ProcessEngineConfiguration      interface
     * 操作流程实例          RuntimeService
     * 操纵任务              TaskService
     *
     * ProcessEngines:
     *     protected static Map<String, ProcessEngine> processEngines = new HashMap<>();                key:流程引擎名称,val:流程引擎实例对象
     *     protected static Map<String, EngineInfo> processEngineInfosByName = new HashMap<>();         key:流程引擎名称,val:流程引擎信息类实例对象
     *     protected static Map<String, EngineInfo> processEngineInfosByResourceUrl = new HashMap<>();  key:构造流程引擎的资源名称,val:流程引擎信息类实例对象
     *     protected static List<EngineInfo> processEngineInfos = new ArrayList<>();                    存储流程引擎信息类实例对象
     *
     *
     *
     *
     *
     * @Author yorkehan
     * @Params
     * @Date 2019/4/11 22:28
     */
    public void testProcessEngine(){
        //获取默认引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
//获取服务类

        //操作流程定义
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //动态Bpmn服务
        DynamicBpmnService dynamicBpmnService = processEngine.getDynamicBpmnService();
        //操作流程表单
        FormService formService = processEngine.getFormService();
        //查询历史表数据
        HistoryService historyService = processEngine.getHistoryService();
        //操作用户或组
        IdentityService identityService = processEngine.getIdentityService();
        //执行cmd以及job相关
        ManagementService managementService = processEngine.getManagementService();
        //流程引擎配置类
        ProcessEngineConfiguration processEngineConfiguration = processEngine.getProcessEngineConfiguration();
        //操作流程实例
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //操纵任务
        TaskService taskService = processEngine.getTaskService();


        //获取实例化bean，只能调用 get containsKey 方法
        Map<Object, Object> beans = processEngineConfiguration.getBeans();
        Object testA = beans.get("testA");
        boolean a = beans.containsKey("testA");

        //手动关闭
        processEngine.close();

    }

    /**
     * @Description 创建流程引擎
     * @Author yorkehan
     * @Params
     * @Date 2019/4/12 0:08
     */
    public void buildProcessEngine(){
        //构造配置
                //手动
        ProcessEngineConfiguration standaloneProcessEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
                //直接
//        StandaloneProcessEngineConfiguration standaloneProcessEngineConfiguration1 = new StandaloneProcessEngineConfiguration();
        standaloneProcessEngineConfiguration.setJdbcDriver("");
        standaloneProcessEngineConfiguration.setJdbcUrl("");
        standaloneProcessEngineConfiguration.setJdbcUsername("");
        standaloneProcessEngineConfiguration.setJdbcPassword("");
        //构造引擎
        ProcessEngine processEngine = standaloneProcessEngineConfiguration.buildProcessEngine();
        //关闭
        processEngine.close();
    }

}
