package com.xll.page.model;

/**
 * Created by lonely.xia on 2017/10/1.
 */
public class FieldParse {

    /** 解析的字段名名 */
    private String fieldName;

    private Rule rule;

    public static class Rule {

        private String parseRule;

        /** 现在只支持HTML和Text类型 */
        private String parseResultType;

        private Rule childRule;

        public Rule(String parseRule , String parseResultType , Rule childRule) {
            this.parseRule = parseRule;
            this.parseResultType = parseResultType;
            this.childRule = childRule;
        }

        public String getParseRule() {
            return parseRule;
        }

        public String getParseResultType() {
            return parseResultType;
        }

        public Rule getChildRule() {
            return childRule;
        }

    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }

}
