package com.xl.msjd;

public class msjd0502_Mark {
    public String printBin(double num) {
        StringBuffer sb = new StringBuffer();
        sb.append("0.");
        while(num != 0) {
            num *= 2;
            if(num >= 1) {
                sb.append(1);
                num -= 1;
            }else {
                sb.append(0);
            }
            if(sb.length() > 32)
                return "ERROR";
        }
        return sb.toString();
    }

//    作者：dushi
//    链接：https://leetcode-cn.com/problems/bianry-number-to-string-lcci/solution/shuang-bai-by-dushi/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
