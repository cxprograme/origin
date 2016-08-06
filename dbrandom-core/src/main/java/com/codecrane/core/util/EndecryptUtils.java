package com.codecrane.core.util;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.security.Key;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 加密工具类
 * Created by crane on 16/3/9.
 */
public class EndecryptUtils {
    /**
     * base64进制加密
     *
     * @param password
     * @return
     */
    public static String encrytBase64(String password) {
        byte[] bytes = password.getBytes();
        return Base64.encodeToString(bytes);
    }

    /**
     * base64进制解密
     *
     * @param cipherText
     * @return
     */
    public static String decryptBase64(String cipherText) {
        return Base64.decodeToString(cipherText);
    }

    /**
     * 16进制加密
     *
     * @param password
     * @return
     */
    public static String encrytHex(String password) {
        byte[] bytes = password.getBytes();
        return Hex.encodeToString(bytes);
    }

    /**
     * 16进制解密
     *
     * @param cipherText
     * @return
     */
    public static String decryptHex(String cipherText) {
        return new String(Hex.decode(cipherText));
    }

    public static String generateKey() {
        AesCipherService aesCipherService = new AesCipherService();
        Key key = aesCipherService.generateNewKey();
        return Base64.encodeToString(key.getEncoded());
    }

    /**
     * 对密码进行md5加密,并返回密文和salt，包含在User对象中
     *
     * @param account        用户名
     * @param password       密码
     * @param hashIterations 迭代次数
     * @return Map对象，包含密文和salt
     */
    public static Map<String, String> md5Password(String account, String password, int hashIterations) {
        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
        String salt = secureRandomNumberGenerator.nextBytes().toHex();
        //组合account,两次迭代，对密码进行加密
        String password_cryto = new Md5Hash(password, account + salt, hashIterations).toBase64();
        Map<String, String> info = new ConcurrentHashMap<String, String>();
        info.put("password", password_cryto);
        info.put("salt", salt);
        return info;
    }

    /**
     * 通过username,password,salt,校验密文是否匹配 ，校验规则其实在配置文件中，这里为了清晰，写下来
     *
     * @param account      用户名
     * @param password      原密码
     * @param salt          盐
     * @param md5cipherText 密文
     * @return
     */
    public static boolean checkMd5Password(String account , String password, String salt, String md5cipherText) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(account), "account不能为空");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "password不能为空");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(md5cipherText), "加密后密码不能为空");
        //组合account,两次迭代，对密码进行加密
        String password_cipherText = new Md5Hash(password, account + salt, 2).toBase64();
        return md5cipherText.equals(password_cipherText);
    }
    public static void main(String[] args){
        System.out.println(md5Password("admin","123456",2));
    }

}
