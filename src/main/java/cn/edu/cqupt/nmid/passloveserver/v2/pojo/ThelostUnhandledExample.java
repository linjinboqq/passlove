package cn.edu.cqupt.nmid.passloveserver.v2.pojo;

import java.util.ArrayList;
import java.util.List;

public class ThelostUnhandledExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ThelostUnhandledExample() {
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

        public Criteria andTypeidIsNull() {
            addCriterion("typeid is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeid is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Short value) {
            addCriterion("typeid =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Short value) {
            addCriterion("typeid <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Short value) {
            addCriterion("typeid >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Short value) {
            addCriterion("typeid >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Short value) {
            addCriterion("typeid <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Short value) {
            addCriterion("typeid <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Short> values) {
            addCriterion("typeid in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Short> values) {
            addCriterion("typeid not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Short value1, Short value2) {
            addCriterion("typeid between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Short value1, Short value2) {
            addCriterion("typeid not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andLosttypeIsNull() {
            addCriterion("losttype is null");
            return (Criteria) this;
        }

        public Criteria andLosttypeIsNotNull() {
            addCriterion("losttype is not null");
            return (Criteria) this;
        }

        public Criteria andLosttypeEqualTo(Integer value) {
            addCriterion("losttype =", value, "losttype");
            return (Criteria) this;
        }

        public Criteria andLosttypeNotEqualTo(Integer value) {
            addCriterion("losttype <>", value, "losttype");
            return (Criteria) this;
        }

        public Criteria andLosttypeGreaterThan(Integer value) {
            addCriterion("losttype >", value, "losttype");
            return (Criteria) this;
        }

        public Criteria andLosttypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("losttype >=", value, "losttype");
            return (Criteria) this;
        }

        public Criteria andLosttypeLessThan(Integer value) {
            addCriterion("losttype <", value, "losttype");
            return (Criteria) this;
        }

        public Criteria andLosttypeLessThanOrEqualTo(Integer value) {
            addCriterion("losttype <=", value, "losttype");
            return (Criteria) this;
        }

        public Criteria andLosttypeIn(List<Integer> values) {
            addCriterion("losttype in", values, "losttype");
            return (Criteria) this;
        }

        public Criteria andLosttypeNotIn(List<Integer> values) {
            addCriterion("losttype not in", values, "losttype");
            return (Criteria) this;
        }

        public Criteria andLosttypeBetween(Integer value1, Integer value2) {
            addCriterion("losttype between", value1, value2, "losttype");
            return (Criteria) this;
        }

        public Criteria andLosttypeNotBetween(Integer value1, Integer value2) {
            addCriterion("losttype not between", value1, value2, "losttype");
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

        public Criteria andPlaceidIsNull() {
            addCriterion("placeid is null");
            return (Criteria) this;
        }

        public Criteria andPlaceidIsNotNull() {
            addCriterion("placeid is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceidEqualTo(Short value) {
            addCriterion("placeid =", value, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidNotEqualTo(Short value) {
            addCriterion("placeid <>", value, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidGreaterThan(Short value) {
            addCriterion("placeid >", value, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidGreaterThanOrEqualTo(Short value) {
            addCriterion("placeid >=", value, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidLessThan(Short value) {
            addCriterion("placeid <", value, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidLessThanOrEqualTo(Short value) {
            addCriterion("placeid <=", value, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidIn(List<Short> values) {
            addCriterion("placeid in", values, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidNotIn(List<Short> values) {
            addCriterion("placeid not in", values, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidBetween(Short value1, Short value2) {
            addCriterion("placeid between", value1, value2, "placeid");
            return (Criteria) this;
        }

        public Criteria andPlaceidNotBetween(Short value1, Short value2) {
            addCriterion("placeid not between", value1, value2, "placeid");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIsNull() {
            addCriterion("publishtime is null");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIsNotNull() {
            addCriterion("publishtime is not null");
            return (Criteria) this;
        }

        public Criteria andPublishtimeEqualTo(String value) {
            addCriterion("publishtime =", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotEqualTo(String value) {
            addCriterion("publishtime <>", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeGreaterThan(String value) {
            addCriterion("publishtime >", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeGreaterThanOrEqualTo(String value) {
            addCriterion("publishtime >=", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLessThan(String value) {
            addCriterion("publishtime <", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLessThanOrEqualTo(String value) {
            addCriterion("publishtime <=", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLike(String value) {
            addCriterion("publishtime like", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotLike(String value) {
            addCriterion("publishtime not like", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIn(List<String> values) {
            addCriterion("publishtime in", values, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotIn(List<String> values) {
            addCriterion("publishtime not in", values, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeBetween(String value1, String value2) {
            addCriterion("publishtime between", value1, value2, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotBetween(String value1, String value2) {
            addCriterion("publishtime not between", value1, value2, "publishtime");
            return (Criteria) this;
        }

        public Criteria andLosttimeIsNull() {
            addCriterion("losttime is null");
            return (Criteria) this;
        }

        public Criteria andLosttimeIsNotNull() {
            addCriterion("losttime is not null");
            return (Criteria) this;
        }

        public Criteria andLosttimeEqualTo(String value) {
            addCriterion("losttime =", value, "losttime");
            return (Criteria) this;
        }

        public Criteria andLosttimeNotEqualTo(String value) {
            addCriterion("losttime <>", value, "losttime");
            return (Criteria) this;
        }

        public Criteria andLosttimeGreaterThan(String value) {
            addCriterion("losttime >", value, "losttime");
            return (Criteria) this;
        }

        public Criteria andLosttimeGreaterThanOrEqualTo(String value) {
            addCriterion("losttime >=", value, "losttime");
            return (Criteria) this;
        }

        public Criteria andLosttimeLessThan(String value) {
            addCriterion("losttime <", value, "losttime");
            return (Criteria) this;
        }

        public Criteria andLosttimeLessThanOrEqualTo(String value) {
            addCriterion("losttime <=", value, "losttime");
            return (Criteria) this;
        }

        public Criteria andLosttimeLike(String value) {
            addCriterion("losttime like", value, "losttime");
            return (Criteria) this;
        }

        public Criteria andLosttimeNotLike(String value) {
            addCriterion("losttime not like", value, "losttime");
            return (Criteria) this;
        }

        public Criteria andLosttimeIn(List<String> values) {
            addCriterion("losttime in", values, "losttime");
            return (Criteria) this;
        }

        public Criteria andLosttimeNotIn(List<String> values) {
            addCriterion("losttime not in", values, "losttime");
            return (Criteria) this;
        }

        public Criteria andLosttimeBetween(String value1, String value2) {
            addCriterion("losttime between", value1, value2, "losttime");
            return (Criteria) this;
        }

        public Criteria andLosttimeNotBetween(String value1, String value2) {
            addCriterion("losttime not between", value1, value2, "losttime");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andIshandledIsNull() {
            addCriterion("ishandled is null");
            return (Criteria) this;
        }

        public Criteria andIshandledIsNotNull() {
            addCriterion("ishandled is not null");
            return (Criteria) this;
        }

        public Criteria andIshandledEqualTo(Integer value) {
            addCriterion("ishandled =", value, "ishandled");
            return (Criteria) this;
        }

        public Criteria andIshandledNotEqualTo(Integer value) {
            addCriterion("ishandled <>", value, "ishandled");
            return (Criteria) this;
        }

        public Criteria andIshandledGreaterThan(Integer value) {
            addCriterion("ishandled >", value, "ishandled");
            return (Criteria) this;
        }

        public Criteria andIshandledGreaterThanOrEqualTo(Integer value) {
            addCriterion("ishandled >=", value, "ishandled");
            return (Criteria) this;
        }

        public Criteria andIshandledLessThan(Integer value) {
            addCriterion("ishandled <", value, "ishandled");
            return (Criteria) this;
        }

        public Criteria andIshandledLessThanOrEqualTo(Integer value) {
            addCriterion("ishandled <=", value, "ishandled");
            return (Criteria) this;
        }

        public Criteria andIshandledIn(List<Integer> values) {
            addCriterion("ishandled in", values, "ishandled");
            return (Criteria) this;
        }

        public Criteria andIshandledNotIn(List<Integer> values) {
            addCriterion("ishandled not in", values, "ishandled");
            return (Criteria) this;
        }

        public Criteria andIshandledBetween(Integer value1, Integer value2) {
            addCriterion("ishandled between", value1, value2, "ishandled");
            return (Criteria) this;
        }

        public Criteria andIshandledNotBetween(Integer value1, Integer value2) {
            addCriterion("ishandled not between", value1, value2, "ishandled");
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