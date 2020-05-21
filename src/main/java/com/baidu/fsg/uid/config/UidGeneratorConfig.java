package com.baidu.fsg.uid.config;

import com.baidu.fsg.uid.generator.UidGenerator;
import com.baidu.fsg.uid.generator.impl.CachedUidGenerator;
import com.baidu.fsg.uid.generator.impl.DefaultUidGenerator;
import com.baidu.fsg.uid.worker.DisposableWorkerIdAssigner;
import com.baidu.fsg.uid.worker.WorkerIdAssigner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UidGeneratorConfig {

    @Bean
    WorkerIdAssigner workerIdAssigner() {
        return new DisposableWorkerIdAssigner();
    }

    @Bean("cachedUidGenerator")
    UidGenerator cachedUidGenerator() {
        WorkerIdAssigner assigner = workerIdAssigner();
        CachedUidGenerator generator = new CachedUidGenerator();
        generator.setTimeBits(30);
        generator.setWorkerBits(18);
        generator.setSeqBits(15);
        generator.setEpochStr("2020-01-01");
        generator.setWorkerIdAssigner(assigner);
        generator.setBoostPower(3);
        generator.setPaddingFactor(50);
        generator.setScheduleInterval(60L);
        return generator;
    }

    @Bean("defaultUidGenerator")
    UidGenerator defaultUidGenerator() {
        WorkerIdAssigner assigner = workerIdAssigner();
        DefaultUidGenerator generator = new DefaultUidGenerator();
        generator.setTimeBits(30);
        generator.setWorkerBits(18);
        generator.setSeqBits(15);
        generator.setEpochStr("2020-01-01");
        generator.setWorkerIdAssigner(assigner);
        return generator;
    }


}
