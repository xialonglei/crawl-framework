package test;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Created by lonely.xia on 2017/10/4.
 */
public class Test {

    @org.junit.Test
    public void test() {
        System.out.println(StringEscapeUtils
                .unescapeHtml4("<td>&#x670D;&#x52A1;&#x6CBB;&#x7406;</td>"));
    }
}
