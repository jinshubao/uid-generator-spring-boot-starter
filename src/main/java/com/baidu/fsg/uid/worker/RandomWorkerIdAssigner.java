package com.baidu.fsg.uid.worker;

public class RandomWorkerIdAssigner implements WorkerIdAssigner {

    @Override
    public long assignWorkerId() {
        return 1;
    }
}
