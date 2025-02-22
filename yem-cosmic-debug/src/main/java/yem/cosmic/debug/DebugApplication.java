/**
 * This is a kingdee cosmic template project that is automatically generated by the Kingdee cosmic development assistant plugin. 
 * If there are any issues during the use process, you can provide feedback to the kingdee developer community website.
 * Website: https://developer.kingdee.com/developer?productLineId=29
 * Author: liebin.zheng
 * Generate Date: 2024-01-30 14:37:52
 */
package yem.cosmic.debug;

import kd.cosmic.debug.tools.CosmicLauncher;

/**
 * 启动本地应用程序(微服务节点)
 */
public class DebugApplication {
	
	

    public static void main(String[] args) {
    	
//    	Thread.currentThread().setContextClassLoader(new KDSecurityClassLoader(Thread.currentThread().getContextClassLoader()));
    	
        CosmicLauncher cosmic = new CosmicLauncher(false);

        cosmic.setClusterNumber("cosmic");
        cosmic.setTenantNumber("ierp");
        
        cosmic.setConfigUrl("127.0.0.1:2181/?user=zookeeper&password=12345678");
        
        cosmic.setMcServerUrl("http://127.0.0.1:8090");

        cosmic.setWebResPath("G:/cosmic/static-file-service");
        
        cosmic.setFsServerUrl("127.0.0.1", 8100);
        cosmic.setImageServerUrl("127.0.0.1", 8100);
        
        //自定义本地苍穹调试服务的端口
        cosmic.setCosmicWepPort(8881);
//        cosmic.setDubboConfig(false, true, true);
        cosmic.start();
        
        
    }
}