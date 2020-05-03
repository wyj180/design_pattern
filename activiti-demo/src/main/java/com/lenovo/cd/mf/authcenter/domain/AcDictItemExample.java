package com.lenovo.cd.mf.authcenter.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcDictItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AcDictItemExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRealmkeyIsNull() {
            addCriterion("realmkey is null");
            return (Criteria) this;
        }

        public Criteria andRealmkeyIsNotNull() {
            addCriterion("realmkey is not null");
            return (Criteria) this;
        }

        public Criteria andRealmkeyEqualTo(String value) {
            addCriterion("realmkey =", value, "realmkey");
            return (Criteria) this;
        }

        public Criteria andRealmkeyNotEqualTo(String value) {
            addCriterion("realmkey <>", value, "realmkey");
            return (Criteria) this;
        }

        public Criteria andRealmkeyGreaterThan(String value) {
            addCriterion("realmkey >", value, "realmkey");
            return (Criteria) this;
        }

        public Criteria andRealmkeyGreaterThanOrEqualTo(String value) {
            addCriterion("realmkey >=", value, "realmkey");
            return (Criteria) this;
        }

        public Criteria andRealmkeyLessThan(String value) {
            addCriterion("realmkey <", value, "realmkey");
            return (Criteria) this;
        }

        public Criteria andRealmkeyLessThanOrEqualTo(String value) {
            addCriterion("realmkey <=", value, "realmkey");
            return (Criteria) this;
        }

        public Criteria andRealmkeyLike(String value) {
            addCriterion("realmkey like", value, "realmkey");
            return (Criteria) this;
        }

        public Criteria andRealmkeyNotLike(String value) {
            addCriterion("realmkey not like", value, "realmkey");
            return (Criteria) this;
        }

        public Criteria andRealmkeyIn(List<String> values) {
            addCriterion("realmkey in", values, "realmkey");
            return (Criteria) this;
        }

        public Criteria andRealmkeyNotIn(List<String> values) {
            addCriterion("realmkey not in", values, "realmkey");
            return (Criteria) this;
        }

        public Criteria andRealmkeyBetween(String value1, String value2) {
            addCriterion("realmkey between", value1, value2, "realmkey");
            return (Criteria) this;
        }

        public Criteria andRealmkeyNotBetween(String value1, String value2) {
            addCriterion("realmkey not between", value1, value2, "realmkey");
            return (Criteria) this;
        }

        public Criteria andDictidIsNull() {
            addCriterion("dictid is null");
            return (Criteria) this;
        }

        public Criteria andDictidIsNotNull() {
            addCriterion("dictid is not null");
            return (Criteria) this;
        }

        public Criteria andDictidEqualTo(Integer value) {
            addCriterion("dictid =", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotEqualTo(Integer value) {
            addCriterion("dictid <>", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidGreaterThan(Integer value) {
            addCriterion("dictid >", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidGreaterThanOrEqualTo(Integer value) {
            addCriterion("dictid >=", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidLessThan(Integer value) {
            addCriterion("dictid <", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidLessThanOrEqualTo(Integer value) {
            addCriterion("dictid <=", value, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidIn(List<Integer> values) {
            addCriterion("dictid in", values, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotIn(List<Integer> values) {
            addCriterion("dictid not in", values, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidBetween(Integer value1, Integer value2) {
            addCriterion("dictid between", value1, value2, "dictid");
            return (Criteria) this;
        }

        public Criteria andDictidNotBetween(Integer value1, Integer value2) {
            addCriterion("dictid not between", value1, value2, "dictid");
            return (Criteria) this;
        }

        public Criteria andItemKeyIsNull() {
            addCriterion("item_key is null");
            return (Criteria) this;
        }

        public Criteria andItemKeyIsNotNull() {
            addCriterion("item_key is not null");
            return (Criteria) this;
        }

        public Criteria andItemKeyEqualTo(String value) {
            addCriterion("item_key =", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyNotEqualTo(String value) {
            addCriterion("item_key <>", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyGreaterThan(String value) {
            addCriterion("item_key >", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyGreaterThanOrEqualTo(String value) {
            addCriterion("item_key >=", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyLessThan(String value) {
            addCriterion("item_key <", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyLessThanOrEqualTo(String value) {
            addCriterion("item_key <=", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyLike(String value) {
            addCriterion("item_key like", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyNotLike(String value) {
            addCriterion("item_key not like", value, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyIn(List<String> values) {
            addCriterion("item_key in", values, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyNotIn(List<String> values) {
            addCriterion("item_key not in", values, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyBetween(String value1, String value2) {
            addCriterion("item_key between", value1, value2, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemKeyNotBetween(String value1, String value2) {
            addCriterion("item_key not between", value1, value2, "itemKey");
            return (Criteria) this;
        }

        public Criteria andItemValueIsNull() {
            addCriterion("item_value is null");
            return (Criteria) this;
        }

        public Criteria andItemValueIsNotNull() {
            addCriterion("item_value is not null");
            return (Criteria) this;
        }

        public Criteria andItemValueEqualTo(String value) {
            addCriterion("item_value =", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueNotEqualTo(String value) {
            addCriterion("item_value <>", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueGreaterThan(String value) {
            addCriterion("item_value >", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueGreaterThanOrEqualTo(String value) {
            addCriterion("item_value >=", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueLessThan(String value) {
            addCriterion("item_value <", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueLessThanOrEqualTo(String value) {
            addCriterion("item_value <=", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueLike(String value) {
            addCriterion("item_value like", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueNotLike(String value) {
            addCriterion("item_value not like", value, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueIn(List<String> values) {
            addCriterion("item_value in", values, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueNotIn(List<String> values) {
            addCriterion("item_value not in", values, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueBetween(String value1, String value2) {
            addCriterion("item_value between", value1, value2, "itemValue");
            return (Criteria) this;
        }

        public Criteria andItemValueNotBetween(String value1, String value2) {
            addCriterion("item_value not between", value1, value2, "itemValue");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andOrderingIsNull() {
            addCriterion("ordering is null");
            return (Criteria) this;
        }

        public Criteria andOrderingIsNotNull() {
            addCriterion("ordering is not null");
            return (Criteria) this;
        }

        public Criteria andOrderingEqualTo(BigDecimal value) {
            addCriterion("ordering =", value, "ordering");
            return (Criteria) this;
        }

        public Criteria andOrderingNotEqualTo(BigDecimal value) {
            addCriterion("ordering <>", value, "ordering");
            return (Criteria) this;
        }

        public Criteria andOrderingGreaterThan(BigDecimal value) {
            addCriterion("ordering >", value, "ordering");
            return (Criteria) this;
        }

        public Criteria andOrderingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ordering >=", value, "ordering");
            return (Criteria) this;
        }

        public Criteria andOrderingLessThan(BigDecimal value) {
            addCriterion("ordering <", value, "ordering");
            return (Criteria) this;
        }

        public Criteria andOrderingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ordering <=", value, "ordering");
            return (Criteria) this;
        }

        public Criteria andOrderingIn(List<BigDecimal> values) {
            addCriterion("ordering in", values, "ordering");
            return (Criteria) this;
        }

        public Criteria andOrderingNotIn(List<BigDecimal> values) {
            addCriterion("ordering not in", values, "ordering");
            return (Criteria) this;
        }

        public Criteria andOrderingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ordering between", value1, value2, "ordering");
            return (Criteria) this;
        }

        public Criteria andOrderingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ordering not between", value1, value2, "ordering");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedIsNull() {
            addCriterion("lastmodified is null");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedIsNotNull() {
            addCriterion("lastmodified is not null");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedEqualTo(Date value) {
            addCriterion("lastmodified =", value, "lastmodified");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedNotEqualTo(Date value) {
            addCriterion("lastmodified <>", value, "lastmodified");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedGreaterThan(Date value) {
            addCriterion("lastmodified >", value, "lastmodified");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("lastmodified >=", value, "lastmodified");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedLessThan(Date value) {
            addCriterion("lastmodified <", value, "lastmodified");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedLessThanOrEqualTo(Date value) {
            addCriterion("lastmodified <=", value, "lastmodified");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedIn(List<Date> values) {
            addCriterion("lastmodified in", values, "lastmodified");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedNotIn(List<Date> values) {
            addCriterion("lastmodified not in", values, "lastmodified");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedBetween(Date value1, Date value2) {
            addCriterion("lastmodified between", value1, value2, "lastmodified");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedNotBetween(Date value1, Date value2) {
            addCriterion("lastmodified not between", value1, value2, "lastmodified");
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