package com.jsu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFileExample() {
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

        public Criteria andFIdIsNull() {
            addCriterion("f_id is null");
            return (Criteria) this;
        }

        public Criteria andFIdIsNotNull() {
            addCriterion("f_id is not null");
            return (Criteria) this;
        }

        public Criteria andFIdEqualTo(Integer value) {
            addCriterion("f_id =", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotEqualTo(Integer value) {
            addCriterion("f_id <>", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThan(Integer value) {
            addCriterion("f_id >", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_id >=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThan(Integer value) {
            addCriterion("f_id <", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_id <=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdIn(List<Integer> values) {
            addCriterion("f_id in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotIn(List<Integer> values) {
            addCriterion("f_id not in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdBetween(Integer value1, Integer value2) {
            addCriterion("f_id between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_id not between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFNameIsNull() {
            addCriterion("f_name is null");
            return (Criteria) this;
        }

        public Criteria andFNameIsNotNull() {
            addCriterion("f_name is not null");
            return (Criteria) this;
        }

        public Criteria andFNameEqualTo(String value) {
            addCriterion("f_name =", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotEqualTo(String value) {
            addCriterion("f_name <>", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameGreaterThan(String value) {
            addCriterion("f_name >", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_name >=", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLessThan(String value) {
            addCriterion("f_name <", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLessThanOrEqualTo(String value) {
            addCriterion("f_name <=", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameLike(String value) {
            addCriterion("f_name like", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotLike(String value) {
            addCriterion("f_name not like", value, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameIn(List<String> values) {
            addCriterion("f_name in", values, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotIn(List<String> values) {
            addCriterion("f_name not in", values, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameBetween(String value1, String value2) {
            addCriterion("f_name between", value1, value2, "fName");
            return (Criteria) this;
        }

        public Criteria andFNameNotBetween(String value1, String value2) {
            addCriterion("f_name not between", value1, value2, "fName");
            return (Criteria) this;
        }

        public Criteria andFSizeIsNull() {
            addCriterion("f_size is null");
            return (Criteria) this;
        }

        public Criteria andFSizeIsNotNull() {
            addCriterion("f_size is not null");
            return (Criteria) this;
        }

        public Criteria andFSizeEqualTo(Long value) {
            addCriterion("f_size =", value, "fSize");
            return (Criteria) this;
        }

        public Criteria andFSizeNotEqualTo(Long value) {
            addCriterion("f_size <>", value, "fSize");
            return (Criteria) this;
        }

        public Criteria andFSizeGreaterThan(Long value) {
            addCriterion("f_size >", value, "fSize");
            return (Criteria) this;
        }

        public Criteria andFSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("f_size >=", value, "fSize");
            return (Criteria) this;
        }

        public Criteria andFSizeLessThan(Long value) {
            addCriterion("f_size <", value, "fSize");
            return (Criteria) this;
        }

        public Criteria andFSizeLessThanOrEqualTo(Long value) {
            addCriterion("f_size <=", value, "fSize");
            return (Criteria) this;
        }

        public Criteria andFSizeIn(List<Long> values) {
            addCriterion("f_size in", values, "fSize");
            return (Criteria) this;
        }

        public Criteria andFSizeNotIn(List<Long> values) {
            addCriterion("f_size not in", values, "fSize");
            return (Criteria) this;
        }

        public Criteria andFSizeBetween(Long value1, Long value2) {
            addCriterion("f_size between", value1, value2, "fSize");
            return (Criteria) this;
        }

        public Criteria andFSizeNotBetween(Long value1, Long value2) {
            addCriterion("f_size not between", value1, value2, "fSize");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIsNull() {
            addCriterion("f_create_time is null");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIsNotNull() {
            addCriterion("f_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeEqualTo(Date value) {
            addCriterion("f_create_time =", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotEqualTo(Date value) {
            addCriterion("f_create_time <>", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeGreaterThan(Date value) {
            addCriterion("f_create_time >", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_create_time >=", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeLessThan(Date value) {
            addCriterion("f_create_time <", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_create_time <=", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIn(List<Date> values) {
            addCriterion("f_create_time in", values, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotIn(List<Date> values) {
            addCriterion("f_create_time not in", values, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeBetween(Date value1, Date value2) {
            addCriterion("f_create_time between", value1, value2, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_create_time not between", value1, value2, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCateIsNull() {
            addCriterion("f_cate is null");
            return (Criteria) this;
        }

        public Criteria andFCateIsNotNull() {
            addCriterion("f_cate is not null");
            return (Criteria) this;
        }

        public Criteria andFCateEqualTo(Integer value) {
            addCriterion("f_cate =", value, "fCate");
            return (Criteria) this;
        }

        public Criteria andFCateNotEqualTo(Integer value) {
            addCriterion("f_cate <>", value, "fCate");
            return (Criteria) this;
        }

        public Criteria andFCateGreaterThan(Integer value) {
            addCriterion("f_cate >", value, "fCate");
            return (Criteria) this;
        }

        public Criteria andFCateGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_cate >=", value, "fCate");
            return (Criteria) this;
        }

        public Criteria andFCateLessThan(Integer value) {
            addCriterion("f_cate <", value, "fCate");
            return (Criteria) this;
        }

        public Criteria andFCateLessThanOrEqualTo(Integer value) {
            addCriterion("f_cate <=", value, "fCate");
            return (Criteria) this;
        }

        public Criteria andFCateIn(List<Integer> values) {
            addCriterion("f_cate in", values, "fCate");
            return (Criteria) this;
        }

        public Criteria andFCateNotIn(List<Integer> values) {
            addCriterion("f_cate not in", values, "fCate");
            return (Criteria) this;
        }

        public Criteria andFCateBetween(Integer value1, Integer value2) {
            addCriterion("f_cate between", value1, value2, "fCate");
            return (Criteria) this;
        }

        public Criteria andFCateNotBetween(Integer value1, Integer value2) {
            addCriterion("f_cate not between", value1, value2, "fCate");
            return (Criteria) this;
        }

        public Criteria andFDeleteTimeIsNull() {
            addCriterion("f_delete_time is null");
            return (Criteria) this;
        }

        public Criteria andFDeleteTimeIsNotNull() {
            addCriterion("f_delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andFDeleteTimeEqualTo(Date value) {
            addCriterion("f_delete_time =", value, "fDeleteTime");
            return (Criteria) this;
        }

        public Criteria andFDeleteTimeNotEqualTo(Date value) {
            addCriterion("f_delete_time <>", value, "fDeleteTime");
            return (Criteria) this;
        }

        public Criteria andFDeleteTimeGreaterThan(Date value) {
            addCriterion("f_delete_time >", value, "fDeleteTime");
            return (Criteria) this;
        }

        public Criteria andFDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("f_delete_time >=", value, "fDeleteTime");
            return (Criteria) this;
        }

        public Criteria andFDeleteTimeLessThan(Date value) {
            addCriterion("f_delete_time <", value, "fDeleteTime");
            return (Criteria) this;
        }

        public Criteria andFDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("f_delete_time <=", value, "fDeleteTime");
            return (Criteria) this;
        }

        public Criteria andFDeleteTimeIn(List<Date> values) {
            addCriterion("f_delete_time in", values, "fDeleteTime");
            return (Criteria) this;
        }

        public Criteria andFDeleteTimeNotIn(List<Date> values) {
            addCriterion("f_delete_time not in", values, "fDeleteTime");
            return (Criteria) this;
        }

        public Criteria andFDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("f_delete_time between", value1, value2, "fDeleteTime");
            return (Criteria) this;
        }

        public Criteria andFDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("f_delete_time not between", value1, value2, "fDeleteTime");
            return (Criteria) this;
        }

        public Criteria andFStatusIsNull() {
            addCriterion("f_status is null");
            return (Criteria) this;
        }

        public Criteria andFStatusIsNotNull() {
            addCriterion("f_status is not null");
            return (Criteria) this;
        }

        public Criteria andFStatusEqualTo(Integer value) {
            addCriterion("f_status =", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusNotEqualTo(Integer value) {
            addCriterion("f_status <>", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusGreaterThan(Integer value) {
            addCriterion("f_status >", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_status >=", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusLessThan(Integer value) {
            addCriterion("f_status <", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusLessThanOrEqualTo(Integer value) {
            addCriterion("f_status <=", value, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusIn(List<Integer> values) {
            addCriterion("f_status in", values, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusNotIn(List<Integer> values) {
            addCriterion("f_status not in", values, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusBetween(Integer value1, Integer value2) {
            addCriterion("f_status between", value1, value2, "fStatus");
            return (Criteria) this;
        }

        public Criteria andFStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("f_status not between", value1, value2, "fStatus");
            return (Criteria) this;
        }

        public Criteria andIsDirIsNull() {
            addCriterion("is_dir is null");
            return (Criteria) this;
        }

        public Criteria andIsDirIsNotNull() {
            addCriterion("is_dir is not null");
            return (Criteria) this;
        }

        public Criteria andIsDirEqualTo(Integer value) {
            addCriterion("is_dir =", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirNotEqualTo(Integer value) {
            addCriterion("is_dir <>", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirGreaterThan(Integer value) {
            addCriterion("is_dir >", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_dir >=", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirLessThan(Integer value) {
            addCriterion("is_dir <", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirLessThanOrEqualTo(Integer value) {
            addCriterion("is_dir <=", value, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirIn(List<Integer> values) {
            addCriterion("is_dir in", values, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirNotIn(List<Integer> values) {
            addCriterion("is_dir not in", values, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirBetween(Integer value1, Integer value2) {
            addCriterion("is_dir between", value1, value2, "isDir");
            return (Criteria) this;
        }

        public Criteria andIsDirNotBetween(Integer value1, Integer value2) {
            addCriterion("is_dir not between", value1, value2, "isDir");
            return (Criteria) this;
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
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