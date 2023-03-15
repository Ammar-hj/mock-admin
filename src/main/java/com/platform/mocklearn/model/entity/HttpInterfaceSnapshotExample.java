package com.platform.mocklearn.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HttpInterfaceSnapshotExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HttpInterfaceSnapshotExample() {
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

        public Criteria andHttpInterfaceIdIsNull() {
            addCriterion("http_interface_id is null");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceIdIsNotNull() {
            addCriterion("http_interface_id is not null");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceIdEqualTo(Long value) {
            addCriterion("http_interface_id =", value, "httpInterfaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceIdNotEqualTo(Long value) {
            addCriterion("http_interface_id <>", value, "httpInterfaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceIdGreaterThan(Long value) {
            addCriterion("http_interface_id >", value, "httpInterfaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("http_interface_id >=", value, "httpInterfaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceIdLessThan(Long value) {
            addCriterion("http_interface_id <", value, "httpInterfaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceIdLessThanOrEqualTo(Long value) {
            addCriterion("http_interface_id <=", value, "httpInterfaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceIdIn(List<Long> values) {
            addCriterion("http_interface_id in", values, "httpInterfaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceIdNotIn(List<Long> values) {
            addCriterion("http_interface_id not in", values, "httpInterfaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceIdBetween(Long value1, Long value2) {
            addCriterion("http_interface_id between", value1, value2, "httpInterfaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceIdNotBetween(Long value1, Long value2) {
            addCriterion("http_interface_id not between", value1, value2, "httpInterfaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriIsNull() {
            addCriterion("http_interface_request_uri is null");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriIsNotNull() {
            addCriterion("http_interface_request_uri is not null");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriEqualTo(String value) {
            addCriterion("http_interface_request_uri =", value, "httpInterfaceRequestUri");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriNotEqualTo(String value) {
            addCriterion("http_interface_request_uri <>", value, "httpInterfaceRequestUri");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriGreaterThan(String value) {
            addCriterion("http_interface_request_uri >", value, "httpInterfaceRequestUri");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriGreaterThanOrEqualTo(String value) {
            addCriterion("http_interface_request_uri >=", value, "httpInterfaceRequestUri");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriLessThan(String value) {
            addCriterion("http_interface_request_uri <", value, "httpInterfaceRequestUri");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriLessThanOrEqualTo(String value) {
            addCriterion("http_interface_request_uri <=", value, "httpInterfaceRequestUri");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriLike(String value) {
            addCriterion("http_interface_request_uri like", value, "httpInterfaceRequestUri");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriNotLike(String value) {
            addCriterion("http_interface_request_uri not like", value, "httpInterfaceRequestUri");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriIn(List<String> values) {
            addCriterion("http_interface_request_uri in", values, "httpInterfaceRequestUri");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriNotIn(List<String> values) {
            addCriterion("http_interface_request_uri not in", values, "httpInterfaceRequestUri");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriBetween(String value1, String value2) {
            addCriterion("http_interface_request_uri between", value1, value2, "httpInterfaceRequestUri");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestUriNotBetween(String value1, String value2) {
            addCriterion("http_interface_request_uri not between", value1, value2, "httpInterfaceRequestUri");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodIsNull() {
            addCriterion("http_interface_request_method is null");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodIsNotNull() {
            addCriterion("http_interface_request_method is not null");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodEqualTo(String value) {
            addCriterion("http_interface_request_method =", value, "httpInterfaceRequestMethod");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodNotEqualTo(String value) {
            addCriterion("http_interface_request_method <>", value, "httpInterfaceRequestMethod");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodGreaterThan(String value) {
            addCriterion("http_interface_request_method >", value, "httpInterfaceRequestMethod");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodGreaterThanOrEqualTo(String value) {
            addCriterion("http_interface_request_method >=", value, "httpInterfaceRequestMethod");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodLessThan(String value) {
            addCriterion("http_interface_request_method <", value, "httpInterfaceRequestMethod");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodLessThanOrEqualTo(String value) {
            addCriterion("http_interface_request_method <=", value, "httpInterfaceRequestMethod");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodLike(String value) {
            addCriterion("http_interface_request_method like", value, "httpInterfaceRequestMethod");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodNotLike(String value) {
            addCriterion("http_interface_request_method not like", value, "httpInterfaceRequestMethod");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodIn(List<String> values) {
            addCriterion("http_interface_request_method in", values, "httpInterfaceRequestMethod");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodNotIn(List<String> values) {
            addCriterion("http_interface_request_method not in", values, "httpInterfaceRequestMethod");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodBetween(String value1, String value2) {
            addCriterion("http_interface_request_method between", value1, value2, "httpInterfaceRequestMethod");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceRequestMethodNotBetween(String value1, String value2) {
            addCriterion("http_interface_request_method not between", value1, value2, "httpInterfaceRequestMethod");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceSpaceIdIsNull() {
            addCriterion("http_interface_space_id is null");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceSpaceIdIsNotNull() {
            addCriterion("http_interface_space_id is not null");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceSpaceIdEqualTo(Long value) {
            addCriterion("http_interface_space_id =", value, "httpInterfaceSpaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceSpaceIdNotEqualTo(Long value) {
            addCriterion("http_interface_space_id <>", value, "httpInterfaceSpaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceSpaceIdGreaterThan(Long value) {
            addCriterion("http_interface_space_id >", value, "httpInterfaceSpaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceSpaceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("http_interface_space_id >=", value, "httpInterfaceSpaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceSpaceIdLessThan(Long value) {
            addCriterion("http_interface_space_id <", value, "httpInterfaceSpaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceSpaceIdLessThanOrEqualTo(Long value) {
            addCriterion("http_interface_space_id <=", value, "httpInterfaceSpaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceSpaceIdIn(List<Long> values) {
            addCriterion("http_interface_space_id in", values, "httpInterfaceSpaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceSpaceIdNotIn(List<Long> values) {
            addCriterion("http_interface_space_id not in", values, "httpInterfaceSpaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceSpaceIdBetween(Long value1, Long value2) {
            addCriterion("http_interface_space_id between", value1, value2, "httpInterfaceSpaceId");
            return (Criteria) this;
        }

        public Criteria andHttpInterfaceSpaceIdNotBetween(Long value1, Long value2) {
            addCriterion("http_interface_space_id not between", value1, value2, "httpInterfaceSpaceId");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNull() {
            addCriterion("op_type is null");
            return (Criteria) this;
        }

        public Criteria andOpTypeIsNotNull() {
            addCriterion("op_type is not null");
            return (Criteria) this;
        }

        public Criteria andOpTypeEqualTo(String value) {
            addCriterion("op_type =", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotEqualTo(String value) {
            addCriterion("op_type <>", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThan(String value) {
            addCriterion("op_type >", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeGreaterThanOrEqualTo(String value) {
            addCriterion("op_type >=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThan(String value) {
            addCriterion("op_type <", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLessThanOrEqualTo(String value) {
            addCriterion("op_type <=", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeLike(String value) {
            addCriterion("op_type like", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotLike(String value) {
            addCriterion("op_type not like", value, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeIn(List<String> values) {
            addCriterion("op_type in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotIn(List<String> values) {
            addCriterion("op_type not in", values, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeBetween(String value1, String value2) {
            addCriterion("op_type between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andOpTypeNotBetween(String value1, String value2) {
            addCriterion("op_type not between", value1, value2, "opType");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andMtimeIsNull() {
            addCriterion("mtime is null");
            return (Criteria) this;
        }

        public Criteria andMtimeIsNotNull() {
            addCriterion("mtime is not null");
            return (Criteria) this;
        }

        public Criteria andMtimeEqualTo(Date value) {
            addCriterion("mtime =", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotEqualTo(Date value) {
            addCriterion("mtime <>", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeGreaterThan(Date value) {
            addCriterion("mtime >", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mtime >=", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeLessThan(Date value) {
            addCriterion("mtime <", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeLessThanOrEqualTo(Date value) {
            addCriterion("mtime <=", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeIn(List<Date> values) {
            addCriterion("mtime in", values, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotIn(List<Date> values) {
            addCriterion("mtime not in", values, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeBetween(Date value1, Date value2) {
            addCriterion("mtime between", value1, value2, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotBetween(Date value1, Date value2) {
            addCriterion("mtime not between", value1, value2, "mtime");
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