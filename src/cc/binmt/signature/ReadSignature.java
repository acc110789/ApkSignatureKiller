package cc.binmt.signature;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.Properties;


public class ReadSignature {

    public static void main(String[] args) throws Exception {
        process();
    }

    private static void process() throws Exception {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.txt")) {
            properties.load(fis);
        }
        File signApk = new File(properties.getProperty("apk.signed"));

        System.out.println("正在读取签名：" + signApk.getPath());
        byte[] signatures = NKillSignatureTool.getApkSignatureData(signApk);

        String result = Base64.getEncoder().encodeToString(signatures);
        System.out.println(result);
    }
}
