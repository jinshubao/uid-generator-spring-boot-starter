package com.baidu.fsg.uid.api;

import com.baidu.fsg.uid.generator.UidGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uid")
class UidGeneratorApi {

    private final UidGenerator defaultUidGenerator;
    private final UidGenerator cachedUidGenerator;

    public UidGeneratorApi(@Qualifier("defaultUidGenerator") UidGenerator defaultUidGenerator,
                           @Qualifier("cachedUidGenerator") UidGenerator cachedUidGenerator) {
        this.defaultUidGenerator = defaultUidGenerator;
        this.cachedUidGenerator = cachedUidGenerator;
    }

    @GetMapping("/cached")
    String cachedGenerator(@RequestParam(name = "qty", required = false, defaultValue = "1") int qty) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 1; i <= qty; i++) {
            long uid = this.cachedUidGenerator.getUID();
//            String uidString = cachedUidGenerator.parseUID(uid);
            buffer.append(uid);
            if (i < qty) {
                buffer.append(",\n");
            }
        }
        return buffer.toString();
    }

    @GetMapping("/default")
    String defaultGenerator(@RequestParam(name = "qty", required = false, defaultValue = "1") int qty) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 1; i <= qty; i++) {
            long uid = this.defaultUidGenerator.getUID();
//            String uidString = defaultUidGenerator.parseUID(uid);
            buffer.append(uid);
            if (i < qty) {
                buffer.append(",\n");
            }
        }
        return buffer.toString();
    }

}
