package com.yorkhean.flowable.bpmnConfig;

import com.yorkhean.flowable.bpmnApi.CustomProcessEngineLifecycleListener;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ProcessEngineConfig
 * @Description 流程引擎配置
 * @Author yorkehan
 * @Date 2019/4/11 23:56
 */
//
@Configuration
public class ProcessEngineConfig {

    @Autowired
    CustomProcessEngineLifecycleListener customeProcessEngineLifecycleListener;

    /**
     * @Description 配置流程引擎监听器
     * @Author yorkehan
     * @Params []
     * @Date 2019/4/12 0:04
     */
    @Bean
    public ProcessEngineConfiguration processEngineConfiguration(){
        StandaloneProcessEngineConfiguration standaloneProcessEngineConfiguration = new StandaloneProcessEngineConfiguration();
        standaloneProcessEngineConfiguration.setProcessEngineLifecycleListener(customeProcessEngineLifecycleListener);
        return standaloneProcessEngineConfiguration;
    }
}
