package com.jsu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbShareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbShareExample() {
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

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andSContentIsNull() {
            addCriterion("s_content is null");
            return (Criteria) this;
        }

        public Criteria andSContentIsNotNull() {
            addCriterion("s_content is not null");
            return (Criteria) this;
        }

        public Criteria andSContentEqualTo(String value) {
            addCriterion("s_content =", value, "sContent");
            return (Criteria) this;
        }

        public Criteria andSContentNotEqualTo(String value) {
            addCriterion("s_content <>", value, "sContent");
            return (Criteria) this;
        }

        public Criteria andSContentGreaterThan(String value) {
            addCriterion("s_content >", value, "sContent");
            return (Criteria) this;
        }

        public Criteria andSContentGreaterThanOrEqualTo(String value) {
            addCriterion("s_content >=", value, "sContent");
            return (Criteria) this;
        }

        public Criteria andSContentLessThan(String value) {
            addCriterion("s_content <", value, "sContent");
            return (Criteria) this;
        }

        public Criteria andSContentLessThanOrEqualTo(String value) {
            addCriterion("s_content <=", value, "sContent");
            return (Criteria) this;
        }

        public Criteria andSContentLike(String value) {
            addCriterion("s_content like", value, "sContent");
            return (Criteria) this;
        }

        public Criteria andSContentNotLike(String value) {
            addCriterion("s_content not like", value, "sContent");
            return (Criteria) this;
        }

        public Criteria andSContentIn(List<String> values) {
            addCriterion("s_content in", values, "sContent");
            return (Criteria) this;
        }

        public Criteria andSContentNotIn(List<String> values) {
            addCriterion("s_content not in", values, "sContent");
            return (Criteria) this;
        }

        public Criteria andSContentBetween(String value1, String value2) {
            addCriterion("s_content between", value1, value2, "sContent");
            return (Criteria) this;
        }

        public Criteria andSContentNotBetween(String value1, String value2) {
            addCriterion("s_content not between", value1, value2, "sContent");
            return (Criteria) this;
        }

        public Criteria andSCreateTimeIsNull() {
            addCriterion("s_create_time is null");
            return (Criteria) this;
        }

        public Criteria andSCreateTimeIsNotNull() {
            addCriterion("s_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andSCreateTimeEqualTo(Date value) {
            addCriterion("s_create_time =", value, "sCreateTime");
            return (Criteria) this;
        }

        public Criteria andSCreateTimeNotEqualTo(Date value) {
            addCriterion("s_create_time <>", value, "sCreateTime");
            return (Criteria) this;
        }

        public Criteria andSCreateTimeGreaterThan(Date value) {
            addCriterion("s_create_time >", value, "sCreateTime");
            return (Criteria) this;
        }

        public Criteria andSCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("s_create_time >=", value, "sCreateTime");
            return (Criteria) this;
        }

        public Criteria andSCreateTimeLessThan(Date value) {
            addCriterion("s_create_time <", value, "sCreateTime");
            return (Criteria) this;
        }

        public Criteria andSCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("s_create_time <=", value, "sCreateTime");
            return (Criteria) this;
        }

        public Criteria andSCreateTimeIn(List<Date> values) {
            addCriterion("s_create_time in", values, "sCreateTime");
            return (Criteria) this;
        }

        public Criteria andSCreateTimeNotIn(List<Date> values) {
            addCriterion("s_create_time not in", values, "sCreateTime");
            return (Criteria) this;
        }

        public Criteria andSCreateTimeBetween(Date value1, Date value2) {
            addCriterion("s_create_time between", value1, value2, "sCreateTime");
            return (Criteria) this;
        }

        public Criteria andSCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("s_create_time not between", value1, value2, "sCreateTime");
            return (Criteria) this;
        }

        public Criteria andSStatusIsNull() {
            addCriterion("s_status is null");
            return (Criteria) this;
        }

        public Criteria andSStatusIsNotNull() {
            addCriterion("s_status is not null");
            return (Criteria) this;
        }

        public Criteria andSStatusEqualTo(Integer value) {
            addCriterion("s_status =", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusNotEqualTo(Integer value) {
            addCriterion("s_status <>", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusGreaterThan(Integer value) {
            addCriterion("s_status >", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_status >=", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusLessThan(Integer value) {
            addCriterion("s_status <", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusLessThanOrEqualTo(Integer value) {
            addCriterion("s_status <=", value, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusIn(List<Integer> values) {
            addCriterion("s_status in", values, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusNotIn(List<Integer> values) {
            addCriterion("s_status not in", values, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusBetween(Integer value1, Integer value2) {
            addCriterion("s_status between", value1, value2, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("s_status not between", value1, value2, "sStatus");
            return (Criteria) this;
        }

        public Criteria andSValidDayIsNull() {
            addCriterion("s_valid_day is null");
            return (Criteria) this;
        }

        public Criteria andSValidDayIsNotNull() {
            addCriterion("s_valid_day is not null");
            return (Criteria) this;
        }

        public Criteria andSValidDayEqualTo(Integer value) {
            addCriterion("s_valid_day =", value, "sValidDay");
            return (Criteria) this;
        }

        public Criteria andSValidDayNotEqualTo(Integer value) {
            addCriterion("s_valid_day <>", value, "sValidDay");
            return (Criteria) this;
        }

        public Criteria andSValidDayGreaterThan(Integer value) {
            addCriterion("s_valid_day >", value, "sValidDay");
            return (Criteria) this;
        }

        public Criteria andSValidDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_valid_day >=", value, "sValidDay");
            return (Criteria) this;
        }

        public Criteria andSValidDayLessThan(Integer value) {
            addCriterion("s_valid_day <", value, "sValidDay");
            return (Criteria) this;
        }

        public Criteria andSValidDayLessThanOrEqualTo(Integer value) {
            addCriterion("s_valid_day <=", value, "sValidDay");
            return (Criteria) this;
        }

        public Criteria andSValidDayIn(List<Integer> values) {
            addCriterion("s_valid_day in", values, "sValidDay");
            return (Criteria) this;
        }

        public Criteria andSValidDayNotIn(List<Integer> values) {
            addCriterion("s_valid_day not in", values, "sValidDay");
            return (Criteria) this;
        }

        public Criteria andSValidDayBetween(Integer value1, Integer value2) {
            addCriterion("s_valid_day between", value1, value2, "sValidDay");
            return (Criteria) this;
        }

        public Criteria andSValidDayNotBetween(Integer value1, Integer value2) {
            addCriterion("s_valid_day not between", value1, value2, "sValidDay");
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