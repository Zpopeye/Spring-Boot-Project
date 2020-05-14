package sz.zxl.com.demo.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Scanner;

/**
 * AES加密解密工具类
 *
 */
public class AESUtil {
    private static final String SALT = "zhengda";
    private static Charset charset = Charset.forName("UTF-8");
    /**
     * 偏移量
     * //AES 为16bytes. DES 为8bytes
     */
    public static final String VIPARA = "zhengdascreatkey";
    /**
     * 私钥
     * AES固定格式为128/192/256 bits.即：16/24/32bytes。DES固定格式为128bits，即8bytes。
     */
    private static final String AES_KEY = "DDEA84D02763297C";
    /**
     * 填充类型
     */
    public static final String AES_TYPE = "AES/CBC/PKCS5Padding";
    public static String encrypt(String content) {
        try {
            IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(SALT.getBytes(charset));
            kgen.init(secureRandom);
            SecretKeySpec key = new SecretKeySpec(AES_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(AES_TYPE);
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
            byte[] result = cipher.doFinal(byteContent);
            return parseByte2HexStr(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String decrypt(String content) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(SALT.getBytes(charset));
            kgen.init(secureRandom);
            IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
            SecretKeySpec key = new SecretKeySpec(AES_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(AES_TYPE);
            cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
            byte[] result = cipher.doFinal(parseHexStr2Byte(content));
            return new String(result,charset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print("请输入需要加密的密码串[按回车结束]：");
        Scanner scanner = new Scanner(System.in, "UTF-8");
        String s = scanner.nextLine();
        String encryptStr = AESUtil.encrypt(s);
        String decryptStr = AESUtil.decrypt(encryptStr);
        System.out.println("加密前的密码是:"+decryptStr);
        System.out.println("加密后的密码是:"+encryptStr);
    }
}

