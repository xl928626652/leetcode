package com.xl.lc;

/**
 * @ClassName : lc925
 * @Author : Xulian
 * @Date : 2020/10/21 11:58
 */
public class lc925 {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() == 0 || name == null) return false;
        if (typed.length() < name.length()) return false;
        char[] csName = name.toCharArray();
        char[] csType = typed.toCharArray();
        int indexOfName = 0, indexOfTyped = 0;
        while (indexOfName < csName.length && indexOfTyped < csType.length) {
            if (csName[indexOfName] == csType[indexOfTyped]) {
                indexOfName++;
                indexOfTyped++;
            } else {
                return false;
            }

            if (indexOfName == csName.length) {
                while (indexOfTyped < csType.length) {
                    if (csType[indexOfTyped] == csType[indexOfTyped - 1]) {
                        indexOfTyped++;
                    } else {
                        return false;
                    }
                }
            } else {
                while (indexOfTyped < csType.length) {
                    if (csType[indexOfTyped] == csType[indexOfTyped - 1] && csType[indexOfTyped] != csName[indexOfName]) {
                        indexOfTyped++;
                    } else {
                        break;
                    }
                }
            }
        }

        return indexOfName == csName.length;//这个情况没有考虑到。。

    }
}
