package com.jsu.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbFileMapperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFileMapperExample() {
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

        public Criteria andMIdIsNull() {
            addCriterion("m_id is null");
            return (Criteria) this;
        }

        public Criteria andMIdIsNotNull() {
            addCriterion("m_id is not null");
            return (Criteria) this;
        }

        public Criteria andMIdEqualTo(Integer value) {
            addCriterion("m_id =", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotEqualTo(Integer value) {
            addCriterion("m_id <>", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThan(Integer value) {
            addCriterion("m_id >", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_id >=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThan(Integer value) {
            addCriterion("m_id <", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThanOrEqualTo(Integer value) {
            addCriterion("m_id <=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdIn(List<Integer> values) {
            addCriterion("m_id in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotIn(List<Integer> values) {
            addCriterion("m_id not in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdBetween(Integer value1, Integer value2) {
            addCriterion("m_id between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotBetween(Integer value1, Integer value2) {
            addCriterion("m_id not between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMMd5IsNull() {
            addCriterion("m_md5 is null");
            return (Criteria) this;
        }

        public Criteria andMMd5IsNotNull() {
            addCriterion("m_md5 is not null");
            return (Criteria) this;
        }

        public Criteria andMMd5EqualTo(String value) {
            addCriterion("m_md5 =", value, "mMd5");
            return (Criteria) this;
        }

        public Criteria andMMd5NotEqualTo(String value) {
            addCriterion("m_md5 <>", value, "mMd5");
            return (Criteria) this;
        }

        public Criteria andMMd5GreaterThan(String value) {
            addCriterion("m_md5 >", value, "mMd5");
            return (Criteria) this;
        }

        public Criteria andMMd5GreaterThanOrEqualTo(String value) {
            addCriterion("m_md5 >=", value, "mMd5");
            return (Criteria) this;
        }

        public Criteria andMMd5LessThan(String value) {
            addCriterion("m_md5 <", value, "mMd5");
            return (Criteria) this;
        }

        public Criteria andMMd5LessThanOrEqualTo(String value) {
            addCriterion("m_md5 <=", value, "mMd5");
            return (Criteria) this;
        }

        public Criteria andMMd5Like(String value) {
            addCriterion("m_md5 like", value, "mMd5");
            return (Criteria) this;
        }

        public Criteria andMMd5NotLike(String value) {
            addCriterion("m_md5 not like", value, "mMd5");
            return (Criteria) this;
        }

        public Criteria andMMd5In(List<String> values) {
            addCriterion("m_md5 in", values, "mMd5");
            return (Criteria) this;
        }

        public Criteria andMMd5NotIn(List<String> values) {
            addCriterion("m_md5 not in", values, "mMd5");
            return (Criteria) this;
        }

        public Criteria andMMd5Between(String value1, String value2) {
            addCriterion("m_md5 between", value1, value2, "mMd5");
            return (Criteria) this;
        }

        public Criteria andMMd5NotBetween(String value1, String value2) {
            addCriterion("m_md5 not between", value1, value2, "mMd5");
            return (Criteria) this;
        }

        public Criteria andMPathIsNull() {
            addCriterion("m_path is null");
            return (Criteria) this;
        }

        public Criteria andMPathIsNotNull() {
            addCriterion("m_path is not null");
            return (Criteria) this;
        }

        public Criteria andMPathEqualTo(String value) {
            addCriterion("m_path =", value, "mPath");
            return (Criteria) this;
        }

        public Criteria andMPathNotEqualTo(String value) {
            addCriterion("m_path <>", value, "mPath");
            return (Criteria) this;
        }

        public Criteria andMPathGreaterThan(String value) {
            addCriterion("m_path >", value, "mPath");
            return (Criteria) this;
        }

        public Criteria andMPathGreaterThanOrEqualTo(String value) {
            addCriterion("m_path >=", value, "mPath");
            return (Criteria) this;
        }

        public Criteria andMPathLessThan(String value) {
            addCriterion("m_path <", value, "mPath");
            return (Criteria) this;
        }

        public Criteria andMPathLessThanOrEqualTo(String value) {
            addCriterion("m_path <=", value, "mPath");
            return (Criteria) this;
        }

        public Criteria andMPathLike(String value) {
            addCriterion("m_path like", value, "mPath");
            return (Criteria) this;
        }

        public Criteria andMPathNotLike(String value) {
            addCriterion("m_path not like", value, "mPath");
            return (Criteria) this;
        }

        public Criteria andMPathIn(List<String> values) {
            addCriterion("m_path in", values, "mPath");
            return (Criteria) this;
        }

        public Criteria andMPathNotIn(List<String> values) {
            addCriterion("m_path not in", values, "mPath");
            return (Criteria) this;
        }

        public Criteria andMPathBetween(String value1, String value2) {
            addCriterion("m_path between", value1, value2, "mPath");
            return (Criteria) this;
        }

        public Criteria andMPathNotBetween(String value1, String value2) {
            addCriterion("m_path not between", value1, value2, "mPath");
            return (Criteria) this;
        }

        public Criteria andMSizeIsNull() {
            addCriterion("m_size is null");
            return (Criteria) this;
        }

        public Criteria andMSizeIsNotNull() {
            addCriterion("m_size is not null");
            return (Criteria) this;
        }

        public Criteria andMSizeEqualTo(Long value) {
            addCriterion("m_size =", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeNotEqualTo(Long value) {
            addCriterion("m_size <>", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeGreaterThan(Long value) {
            addCriterion("m_size >", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("m_size >=", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeLessThan(Long value) {
            addCriterion("m_size <", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeLessThanOrEqualTo(Long value) {
            addCriterion("m_size <=", value, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeIn(List<Long> values) {
            addCriterion("m_size in", values, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeNotIn(List<Long> values) {
            addCriterion("m_size not in", values, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeBetween(Long value1, Long value2) {
            addCriterion("m_size between", value1, value2, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSizeNotBetween(Long value1, Long value2) {
            addCriterion("m_size not between", value1, value2, "mSize");
            return (Criteria) this;
        }

        public Criteria andMSatusIsNull() {
            addCriterion("m_satus is null");
            return (Criteria) this;
        }

        public Criteria andMSatusIsNotNull() {
            addCriterion("m_satus is not null");
            return (Criteria) this;
        }

        public Criteria andMSatusEqualTo(Integer value) {
            addCriterion("m_satus =", value, "mSatus");
            return (Criteria) this;
        }

        public Criteria andMSatusNotEqualTo(Integer value) {
            addCriterion("m_satus <>", value, "mSatus");
            return (Criteria) this;
        }

        public Criteria andMSatusGreaterThan(Integer value) {
            addCriterion("m_satus >", value, "mSatus");
            return (Criteria) this;
        }

        public Criteria andMSatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_satus >=", value, "mSatus");
            return (Criteria) this;
        }

        public Criteria andMSatusLessThan(Integer value) {
            addCriterion("m_satus <", value, "mSatus");
            return (Criteria) this;
        }

        public Criteria andMSatusLessThanOrEqualTo(Integer value) {
            addCriterion("m_satus <=", value, "mSatus");
            return (Criteria) this;
        }

        public Criteria andMSatusIn(List<Integer> values) {
            addCriterion("m_satus in", values, "mSatus");
            return (Criteria) this;
        }

        public Criteria andMSatusNotIn(List<Integer> values) {
            addCriterion("m_satus not in", values, "mSatus");
            return (Criteria) this;
        }

        public Criteria andMSatusBetween(Integer value1, Integer value2) {
            addCriterion("m_satus between", value1, value2, "mSatus");
            return (Criteria) this;
        }

        public Criteria andMSatusNotBetween(Integer value1, Integer value2) {
            addCriterion("m_satus not between", value1, value2, "mSatus");
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