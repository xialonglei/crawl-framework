package com.xll.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DubboSchemaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DubboSchemaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andUrlParaIsNull() {
            addCriterion("url_para is null");
            return (Criteria) this;
        }

        public Criteria andUrlParaIsNotNull() {
            addCriterion("url_para is not null");
            return (Criteria) this;
        }

        public Criteria andUrlParaEqualTo(String value) {
            addCriterion("url_para =", value, "urlPara");
            return (Criteria) this;
        }

        public Criteria andUrlParaNotEqualTo(String value) {
            addCriterion("url_para <>", value, "urlPara");
            return (Criteria) this;
        }

        public Criteria andUrlParaGreaterThan(String value) {
            addCriterion("url_para >", value, "urlPara");
            return (Criteria) this;
        }

        public Criteria andUrlParaGreaterThanOrEqualTo(String value) {
            addCriterion("url_para >=", value, "urlPara");
            return (Criteria) this;
        }

        public Criteria andUrlParaLessThan(String value) {
            addCriterion("url_para <", value, "urlPara");
            return (Criteria) this;
        }

        public Criteria andUrlParaLessThanOrEqualTo(String value) {
            addCriterion("url_para <=", value, "urlPara");
            return (Criteria) this;
        }

        public Criteria andUrlParaLike(String value) {
            addCriterion("url_para like", value, "urlPara");
            return (Criteria) this;
        }

        public Criteria andUrlParaNotLike(String value) {
            addCriterion("url_para not like", value, "urlPara");
            return (Criteria) this;
        }

        public Criteria andUrlParaIn(List<String> values) {
            addCriterion("url_para in", values, "urlPara");
            return (Criteria) this;
        }

        public Criteria andUrlParaNotIn(List<String> values) {
            addCriterion("url_para not in", values, "urlPara");
            return (Criteria) this;
        }

        public Criteria andUrlParaBetween(String value1, String value2) {
            addCriterion("url_para between", value1, value2, "urlPara");
            return (Criteria) this;
        }

        public Criteria andUrlParaNotBetween(String value1, String value2) {
            addCriterion("url_para not between", value1, value2, "urlPara");
            return (Criteria) this;
        }

        public Criteria andAttriIsNull() {
            addCriterion("attri is null");
            return (Criteria) this;
        }

        public Criteria andAttriIsNotNull() {
            addCriterion("attri is not null");
            return (Criteria) this;
        }

        public Criteria andAttriEqualTo(String value) {
            addCriterion("attri =", value, "attri");
            return (Criteria) this;
        }

        public Criteria andAttriNotEqualTo(String value) {
            addCriterion("attri <>", value, "attri");
            return (Criteria) this;
        }

        public Criteria andAttriGreaterThan(String value) {
            addCriterion("attri >", value, "attri");
            return (Criteria) this;
        }

        public Criteria andAttriGreaterThanOrEqualTo(String value) {
            addCriterion("attri >=", value, "attri");
            return (Criteria) this;
        }

        public Criteria andAttriLessThan(String value) {
            addCriterion("attri <", value, "attri");
            return (Criteria) this;
        }

        public Criteria andAttriLessThanOrEqualTo(String value) {
            addCriterion("attri <=", value, "attri");
            return (Criteria) this;
        }

        public Criteria andAttriLike(String value) {
            addCriterion("attri like", value, "attri");
            return (Criteria) this;
        }

        public Criteria andAttriNotLike(String value) {
            addCriterion("attri not like", value, "attri");
            return (Criteria) this;
        }

        public Criteria andAttriIn(List<String> values) {
            addCriterion("attri in", values, "attri");
            return (Criteria) this;
        }

        public Criteria andAttriNotIn(List<String> values) {
            addCriterion("attri not in", values, "attri");
            return (Criteria) this;
        }

        public Criteria andAttriBetween(String value1, String value2) {
            addCriterion("attri between", value1, value2, "attri");
            return (Criteria) this;
        }

        public Criteria andAttriNotBetween(String value1, String value2) {
            addCriterion("attri not between", value1, value2, "attri");
            return (Criteria) this;
        }

        public Criteria andAttriTypeIsNull() {
            addCriterion("attri_type is null");
            return (Criteria) this;
        }

        public Criteria andAttriTypeIsNotNull() {
            addCriterion("attri_type is not null");
            return (Criteria) this;
        }

        public Criteria andAttriTypeEqualTo(String value) {
            addCriterion("attri_type =", value, "attriType");
            return (Criteria) this;
        }

        public Criteria andAttriTypeNotEqualTo(String value) {
            addCriterion("attri_type <>", value, "attriType");
            return (Criteria) this;
        }

        public Criteria andAttriTypeGreaterThan(String value) {
            addCriterion("attri_type >", value, "attriType");
            return (Criteria) this;
        }

        public Criteria andAttriTypeGreaterThanOrEqualTo(String value) {
            addCriterion("attri_type >=", value, "attriType");
            return (Criteria) this;
        }

        public Criteria andAttriTypeLessThan(String value) {
            addCriterion("attri_type <", value, "attriType");
            return (Criteria) this;
        }

        public Criteria andAttriTypeLessThanOrEqualTo(String value) {
            addCriterion("attri_type <=", value, "attriType");
            return (Criteria) this;
        }

        public Criteria andAttriTypeLike(String value) {
            addCriterion("attri_type like", value, "attriType");
            return (Criteria) this;
        }

        public Criteria andAttriTypeNotLike(String value) {
            addCriterion("attri_type not like", value, "attriType");
            return (Criteria) this;
        }

        public Criteria andAttriTypeIn(List<String> values) {
            addCriterion("attri_type in", values, "attriType");
            return (Criteria) this;
        }

        public Criteria andAttriTypeNotIn(List<String> values) {
            addCriterion("attri_type not in", values, "attriType");
            return (Criteria) this;
        }

        public Criteria andAttriTypeBetween(String value1, String value2) {
            addCriterion("attri_type between", value1, value2, "attriType");
            return (Criteria) this;
        }

        public Criteria andAttriTypeNotBetween(String value1, String value2) {
            addCriterion("attri_type not between", value1, value2, "attriType");
            return (Criteria) this;
        }

        public Criteria andIsWriteIsNull() {
            addCriterion("is_write is null");
            return (Criteria) this;
        }

        public Criteria andIsWriteIsNotNull() {
            addCriterion("is_write is not null");
            return (Criteria) this;
        }

        public Criteria andIsWriteEqualTo(Boolean value) {
            addCriterion("is_write =", value, "isWrite");
            return (Criteria) this;
        }

        public Criteria andIsWriteNotEqualTo(Boolean value) {
            addCriterion("is_write <>", value, "isWrite");
            return (Criteria) this;
        }

        public Criteria andIsWriteGreaterThan(Boolean value) {
            addCriterion("is_write >", value, "isWrite");
            return (Criteria) this;
        }

        public Criteria andIsWriteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_write >=", value, "isWrite");
            return (Criteria) this;
        }

        public Criteria andIsWriteLessThan(Boolean value) {
            addCriterion("is_write <", value, "isWrite");
            return (Criteria) this;
        }

        public Criteria andIsWriteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_write <=", value, "isWrite");
            return (Criteria) this;
        }

        public Criteria andIsWriteIn(List<Boolean> values) {
            addCriterion("is_write in", values, "isWrite");
            return (Criteria) this;
        }

        public Criteria andIsWriteNotIn(List<Boolean> values) {
            addCriterion("is_write not in", values, "isWrite");
            return (Criteria) this;
        }

        public Criteria andIsWriteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_write between", value1, value2, "isWrite");
            return (Criteria) this;
        }

        public Criteria andIsWriteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_write not between", value1, value2, "isWrite");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNull() {
            addCriterion("default_value is null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNotNull() {
            addCriterion("default_value is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueEqualTo(String value) {
            addCriterion("default_value =", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotEqualTo(String value) {
            addCriterion("default_value <>", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThan(String value) {
            addCriterion("default_value >", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThanOrEqualTo(String value) {
            addCriterion("default_value >=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThan(String value) {
            addCriterion("default_value <", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThanOrEqualTo(String value) {
            addCriterion("default_value <=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLike(String value) {
            addCriterion("default_value like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotLike(String value) {
            addCriterion("default_value not like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIn(List<String> values) {
            addCriterion("default_value in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotIn(List<String> values) {
            addCriterion("default_value not in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueBetween(String value1, String value2) {
            addCriterion("default_value between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotBetween(String value1, String value2) {
            addCriterion("default_value not between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andFuncIsNull() {
            addCriterion("func is null");
            return (Criteria) this;
        }

        public Criteria andFuncIsNotNull() {
            addCriterion("func is not null");
            return (Criteria) this;
        }

        public Criteria andFuncEqualTo(String value) {
            addCriterion("func =", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncNotEqualTo(String value) {
            addCriterion("func <>", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncGreaterThan(String value) {
            addCriterion("func >", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncGreaterThanOrEqualTo(String value) {
            addCriterion("func >=", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncLessThan(String value) {
            addCriterion("func <", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncLessThanOrEqualTo(String value) {
            addCriterion("func <=", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncLike(String value) {
            addCriterion("func like", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncNotLike(String value) {
            addCriterion("func not like", value, "func");
            return (Criteria) this;
        }

        public Criteria andFuncIn(List<String> values) {
            addCriterion("func in", values, "func");
            return (Criteria) this;
        }

        public Criteria andFuncNotIn(List<String> values) {
            addCriterion("func not in", values, "func");
            return (Criteria) this;
        }

        public Criteria andFuncBetween(String value1, String value2) {
            addCriterion("func between", value1, value2, "func");
            return (Criteria) this;
        }

        public Criteria andFuncNotBetween(String value1, String value2) {
            addCriterion("func not between", value1, value2, "func");
            return (Criteria) this;
        }

        public Criteria andDescriptIsNull() {
            addCriterion("descript is null");
            return (Criteria) this;
        }

        public Criteria andDescriptIsNotNull() {
            addCriterion("descript is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptEqualTo(String value) {
            addCriterion("descript =", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotEqualTo(String value) {
            addCriterion("descript <>", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptGreaterThan(String value) {
            addCriterion("descript >", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptGreaterThanOrEqualTo(String value) {
            addCriterion("descript >=", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLessThan(String value) {
            addCriterion("descript <", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLessThanOrEqualTo(String value) {
            addCriterion("descript <=", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLike(String value) {
            addCriterion("descript like", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotLike(String value) {
            addCriterion("descript not like", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptIn(List<String> values) {
            addCriterion("descript in", values, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotIn(List<String> values) {
            addCriterion("descript not in", values, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptBetween(String value1, String value2) {
            addCriterion("descript between", value1, value2, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotBetween(String value1, String value2) {
            addCriterion("descript not between", value1, value2, "descript");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityIsNull() {
            addCriterion("compatible_ability is null");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityIsNotNull() {
            addCriterion("compatible_ability is not null");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityEqualTo(String value) {
            addCriterion("compatible_ability =", value, "compatibleAbility");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityNotEqualTo(String value) {
            addCriterion("compatible_ability <>", value, "compatibleAbility");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityGreaterThan(String value) {
            addCriterion("compatible_ability >", value, "compatibleAbility");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityGreaterThanOrEqualTo(String value) {
            addCriterion("compatible_ability >=", value, "compatibleAbility");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityLessThan(String value) {
            addCriterion("compatible_ability <", value, "compatibleAbility");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityLessThanOrEqualTo(String value) {
            addCriterion("compatible_ability <=", value, "compatibleAbility");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityLike(String value) {
            addCriterion("compatible_ability like", value, "compatibleAbility");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityNotLike(String value) {
            addCriterion("compatible_ability not like", value, "compatibleAbility");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityIn(List<String> values) {
            addCriterion("compatible_ability in", values, "compatibleAbility");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityNotIn(List<String> values) {
            addCriterion("compatible_ability not in", values, "compatibleAbility");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityBetween(String value1, String value2) {
            addCriterion("compatible_ability between", value1, value2, "compatibleAbility");
            return (Criteria) this;
        }

        public Criteria andCompatibleAbilityNotBetween(String value1, String value2) {
            addCriterion("compatible_ability not between", value1, value2, "compatibleAbility");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}