package com.yorkhean.flowable.bpmnApi;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineLifecycleListener;
import org.springframework.stereotype.Repository;

/**
 * @ClassName CustomeProcessEngineLifecycleListener
 * @Description 流程引擎监听器
 * @Author yorkehan
 * @Date 2019/4/11 23:49
 */

@Repository
public class CustomProcessEngineLifecycleListener implements ProcessEngineLifecycleListener {
    /**
     * @Description 监听流程引擎启动
     * @Author yorkehan
     * @Params [processEngine] 流程引擎实列对象
     * @Date 2019/4/11 23:52
     */
    @Override
    public void onProcessEngineBuilt(ProcessEngine processEngine) {

    }


    /**
     * @Description 监听流程引擎关闭
     * @Author yorkehan
     * @Params [processEngine] 流程引擎实列对象
     * @Date 2019/4/11 23:53
     */
    @Override
    public void onProcessEngineClosed(ProcessEngine processEngine) {

    }
}
