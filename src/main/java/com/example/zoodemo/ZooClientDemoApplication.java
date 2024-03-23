package com.example.zoodemo;


import com.example.zoodemo.config.ZookeeperHost;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ZooClientDemoApplication {

    private static ZookeeperHost zkHost;

    private static String path;

    private static byte[] data;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ZooClientDemoApplication.class, args);

        zkHost = new ZookeeperHost();
        zkHost.connect("zookeeper.default:2181");
        int i=1;
        while(i>0){
            UUID uuid = UUID.randomUUID();
            path = "/" + uuid.toString();
            data = ("testData" + i).getBytes();
            zkHost.create(path, data);
            Thread.sleep(2000);
            i++;
        }
    }
}
