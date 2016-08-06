package com.codecrane.core.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 公共工具类
 *
 * @author Crane(hehebaiy@gmail.com)
 *         <br/>
 *         <br/>
 */
public class CommonUtils {

    private static final String RANDOM_BASE_CHARS = "0123456789abcdefghijklmopqrstuvwxyzABCDEFGHIJKLMOPQRSTUVWXYZ";

    /**
     * 生成指定长度随机字符串
     *
     * @param count
     * @return 0-9 a-z A-Z范围类的字符串
     */
    public static String randomStr(int count) {
        return RandomStringUtils.random(count, RANDOM_BASE_CHARS);
    }

    /**
     * 随机抽取集合下指定长度子集合
     * @param views
     * @param max
     * @param <T>
     * @return
     */
    public static <T> List<T> randomList(List<T> views, int max) {

        final int size = views.size();
        int index = RandomUtils.nextInt(0, size);
        //
        List<T> ret = new ArrayList<T>(max);
        int low = index - 1, high = index;
        while (max > 0 && (low >= 0 || high < size)) {
            if (low >= 0 && max-- > 0) {
                ret.add(views.get(low));
            }
            if (high < size && max-- > 0) {
                ret.add(views.get(high));
            }
            low--;
            high++;
        }
        return ret;
    }

}
