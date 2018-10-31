package com.suyan.mmc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponExample() {
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

        public Criteria andCouponNameIsNull() {
            addCriterion("coupon_name is null");
            return (Criteria) this;
        }

        public Criteria andCouponNameIsNotNull() {
            addCriterion("coupon_name is not null");
            return (Criteria) this;
        }

        public Criteria andCouponNameEqualTo(String value) {
            addCriterion("coupon_name =", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotEqualTo(String value) {
            addCriterion("coupon_name <>", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThan(String value) {
            addCriterion("coupon_name >", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_name >=", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThan(String value) {
            addCriterion("coupon_name <", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLessThanOrEqualTo(String value) {
            addCriterion("coupon_name <=", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameLike(String value) {
            addCriterion("coupon_name like", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotLike(String value) {
            addCriterion("coupon_name not like", value, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameIn(List<String> values) {
            addCriterion("coupon_name in", values, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotIn(List<String> values) {
            addCriterion("coupon_name not in", values, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameBetween(String value1, String value2) {
            addCriterion("coupon_name between", value1, value2, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNameNotBetween(String value1, String value2) {
            addCriterion("coupon_name not between", value1, value2, "couponName");
            return (Criteria) this;
        }

        public Criteria andCouponNoIsNull() {
            addCriterion("coupon_no is null");
            return (Criteria) this;
        }

        public Criteria andCouponNoIsNotNull() {
            addCriterion("coupon_no is not null");
            return (Criteria) this;
        }

        public Criteria andCouponNoEqualTo(String value) {
            addCriterion("coupon_no =", value, "couponNo");
            return (Criteria) this;
        }

        public Criteria andCouponNoNotEqualTo(String value) {
            addCriterion("coupon_no <>", value, "couponNo");
            return (Criteria) this;
        }

        public Criteria andCouponNoGreaterThan(String value) {
            addCriterion("coupon_no >", value, "couponNo");
            return (Criteria) this;
        }

        public Criteria andCouponNoGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_no >=", value, "couponNo");
            return (Criteria) this;
        }

        public Criteria andCouponNoLessThan(String value) {
            addCriterion("coupon_no <", value, "couponNo");
            return (Criteria) this;
        }

        public Criteria andCouponNoLessThanOrEqualTo(String value) {
            addCriterion("coupon_no <=", value, "couponNo");
            return (Criteria) this;
        }

        public Criteria andCouponNoLike(String value) {
            addCriterion("coupon_no like", value, "couponNo");
            return (Criteria) this;
        }

        public Criteria andCouponNoNotLike(String value) {
            addCriterion("coupon_no not like", value, "couponNo");
            return (Criteria) this;
        }

        public Criteria andCouponNoIn(List<String> values) {
            addCriterion("coupon_no in", values, "couponNo");
            return (Criteria) this;
        }

        public Criteria andCouponNoNotIn(List<String> values) {
            addCriterion("coupon_no not in", values, "couponNo");
            return (Criteria) this;
        }

        public Criteria andCouponNoBetween(String value1, String value2) {
            addCriterion("coupon_no between", value1, value2, "couponNo");
            return (Criteria) this;
        }

        public Criteria andCouponNoNotBetween(String value1, String value2) {
            addCriterion("coupon_no not between", value1, value2, "couponNo");
            return (Criteria) this;
        }

        public Criteria andCouponPackageIdIsNull() {
            addCriterion("coupon_package_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponPackageIdIsNotNull() {
            addCriterion("coupon_package_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponPackageIdEqualTo(Long value) {
            addCriterion("coupon_package_id =", value, "couponPackageId");
            return (Criteria) this;
        }

        public Criteria andCouponPackageIdNotEqualTo(Long value) {
            addCriterion("coupon_package_id <>", value, "couponPackageId");
            return (Criteria) this;
        }

        public Criteria andCouponPackageIdGreaterThan(Long value) {
            addCriterion("coupon_package_id >", value, "couponPackageId");
            return (Criteria) this;
        }

        public Criteria andCouponPackageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_package_id >=", value, "couponPackageId");
            return (Criteria) this;
        }

        public Criteria andCouponPackageIdLessThan(Long value) {
            addCriterion("coupon_package_id <", value, "couponPackageId");
            return (Criteria) this;
        }

        public Criteria andCouponPackageIdLessThanOrEqualTo(Long value) {
            addCriterion("coupon_package_id <=", value, "couponPackageId");
            return (Criteria) this;
        }

        public Criteria andCouponPackageIdIn(List<Long> values) {
            addCriterion("coupon_package_id in", values, "couponPackageId");
            return (Criteria) this;
        }

        public Criteria andCouponPackageIdNotIn(List<Long> values) {
            addCriterion("coupon_package_id not in", values, "couponPackageId");
            return (Criteria) this;
        }

        public Criteria andCouponPackageIdBetween(Long value1, Long value2) {
            addCriterion("coupon_package_id between", value1, value2, "couponPackageId");
            return (Criteria) this;
        }

        public Criteria andCouponPackageIdNotBetween(Long value1, Long value2) {
            addCriterion("coupon_package_id not between", value1, value2, "couponPackageId");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNull() {
            addCriterion("use_type is null");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNotNull() {
            addCriterion("use_type is not null");
            return (Criteria) this;
        }

        public Criteria andUseTypeEqualTo(Byte value) {
            addCriterion("use_type =", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotEqualTo(Byte value) {
            addCriterion("use_type <>", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThan(Byte value) {
            addCriterion("use_type >", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("use_type >=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThan(Byte value) {
            addCriterion("use_type <", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThanOrEqualTo(Byte value) {
            addCriterion("use_type <=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeIn(List<Byte> values) {
            addCriterion("use_type in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotIn(List<Byte> values) {
            addCriterion("use_type not in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeBetween(Byte value1, Byte value2) {
            addCriterion("use_type between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("use_type not between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPersonLimitIsNull() {
            addCriterion("person_limit is null");
            return (Criteria) this;
        }

        public Criteria andPersonLimitIsNotNull() {
            addCriterion("person_limit is not null");
            return (Criteria) this;
        }

        public Criteria andPersonLimitEqualTo(Integer value) {
            addCriterion("person_limit =", value, "personLimit");
            return (Criteria) this;
        }

        public Criteria andPersonLimitNotEqualTo(Integer value) {
            addCriterion("person_limit <>", value, "personLimit");
            return (Criteria) this;
        }

        public Criteria andPersonLimitGreaterThan(Integer value) {
            addCriterion("person_limit >", value, "personLimit");
            return (Criteria) this;
        }

        public Criteria andPersonLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_limit >=", value, "personLimit");
            return (Criteria) this;
        }

        public Criteria andPersonLimitLessThan(Integer value) {
            addCriterion("person_limit <", value, "personLimit");
            return (Criteria) this;
        }

        public Criteria andPersonLimitLessThanOrEqualTo(Integer value) {
            addCriterion("person_limit <=", value, "personLimit");
            return (Criteria) this;
        }

        public Criteria andPersonLimitIn(List<Integer> values) {
            addCriterion("person_limit in", values, "personLimit");
            return (Criteria) this;
        }

        public Criteria andPersonLimitNotIn(List<Integer> values) {
            addCriterion("person_limit not in", values, "personLimit");
            return (Criteria) this;
        }

        public Criteria andPersonLimitBetween(Integer value1, Integer value2) {
            addCriterion("person_limit between", value1, value2, "personLimit");
            return (Criteria) this;
        }

        public Criteria andPersonLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("person_limit not between", value1, value2, "personLimit");
            return (Criteria) this;
        }

        public Criteria andOrderLimitIsNull() {
            addCriterion("order_limit is null");
            return (Criteria) this;
        }

        public Criteria andOrderLimitIsNotNull() {
            addCriterion("order_limit is not null");
            return (Criteria) this;
        }

        public Criteria andOrderLimitEqualTo(Integer value) {
            addCriterion("order_limit =", value, "orderLimit");
            return (Criteria) this;
        }

        public Criteria andOrderLimitNotEqualTo(Integer value) {
            addCriterion("order_limit <>", value, "orderLimit");
            return (Criteria) this;
        }

        public Criteria andOrderLimitGreaterThan(Integer value) {
            addCriterion("order_limit >", value, "orderLimit");
            return (Criteria) this;
        }

        public Criteria andOrderLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_limit >=", value, "orderLimit");
            return (Criteria) this;
        }

        public Criteria andOrderLimitLessThan(Integer value) {
            addCriterion("order_limit <", value, "orderLimit");
            return (Criteria) this;
        }

        public Criteria andOrderLimitLessThanOrEqualTo(Integer value) {
            addCriterion("order_limit <=", value, "orderLimit");
            return (Criteria) this;
        }

        public Criteria andOrderLimitIn(List<Integer> values) {
            addCriterion("order_limit in", values, "orderLimit");
            return (Criteria) this;
        }

        public Criteria andOrderLimitNotIn(List<Integer> values) {
            addCriterion("order_limit not in", values, "orderLimit");
            return (Criteria) this;
        }

        public Criteria andOrderLimitBetween(Integer value1, Integer value2) {
            addCriterion("order_limit between", value1, value2, "orderLimit");
            return (Criteria) this;
        }

        public Criteria andOrderLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("order_limit not between", value1, value2, "orderLimit");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Byte value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Byte value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Byte value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Byte value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Byte value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Byte> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Byte> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Byte value1, Byte value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Byte value1, Byte value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeIsNull() {
            addCriterion("pending_time is null");
            return (Criteria) this;
        }

        public Criteria andPendingTimeIsNotNull() {
            addCriterion("pending_time is not null");
            return (Criteria) this;
        }

        public Criteria andPendingTimeEqualTo(Date value) {
            addCriterion("pending_time =", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeNotEqualTo(Date value) {
            addCriterion("pending_time <>", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeGreaterThan(Date value) {
            addCriterion("pending_time >", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pending_time >=", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeLessThan(Date value) {
            addCriterion("pending_time <", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeLessThanOrEqualTo(Date value) {
            addCriterion("pending_time <=", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeIn(List<Date> values) {
            addCriterion("pending_time in", values, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeNotIn(List<Date> values) {
            addCriterion("pending_time not in", values, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeBetween(Date value1, Date value2) {
            addCriterion("pending_time between", value1, value2, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeNotBetween(Date value1, Date value2) {
            addCriterion("pending_time not between", value1, value2, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andIssueTotalAmountIsNull() {
            addCriterion("issue_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andIssueTotalAmountIsNotNull() {
            addCriterion("issue_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andIssueTotalAmountEqualTo(Integer value) {
            addCriterion("issue_total_amount =", value, "issueTotalAmount");
            return (Criteria) this;
        }

        public Criteria andIssueTotalAmountNotEqualTo(Integer value) {
            addCriterion("issue_total_amount <>", value, "issueTotalAmount");
            return (Criteria) this;
        }

        public Criteria andIssueTotalAmountGreaterThan(Integer value) {
            addCriterion("issue_total_amount >", value, "issueTotalAmount");
            return (Criteria) this;
        }

        public Criteria andIssueTotalAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("issue_total_amount >=", value, "issueTotalAmount");
            return (Criteria) this;
        }

        public Criteria andIssueTotalAmountLessThan(Integer value) {
            addCriterion("issue_total_amount <", value, "issueTotalAmount");
            return (Criteria) this;
        }

        public Criteria andIssueTotalAmountLessThanOrEqualTo(Integer value) {
            addCriterion("issue_total_amount <=", value, "issueTotalAmount");
            return (Criteria) this;
        }

        public Criteria andIssueTotalAmountIn(List<Integer> values) {
            addCriterion("issue_total_amount in", values, "issueTotalAmount");
            return (Criteria) this;
        }

        public Criteria andIssueTotalAmountNotIn(List<Integer> values) {
            addCriterion("issue_total_amount not in", values, "issueTotalAmount");
            return (Criteria) this;
        }

        public Criteria andIssueTotalAmountBetween(Integer value1, Integer value2) {
            addCriterion("issue_total_amount between", value1, value2, "issueTotalAmount");
            return (Criteria) this;
        }

        public Criteria andIssueTotalAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("issue_total_amount not between", value1, value2, "issueTotalAmount");
            return (Criteria) this;
        }

        public Criteria andIssueStartTimeIsNull() {
            addCriterion("issue_start_time is null");
            return (Criteria) this;
        }

        public Criteria andIssueStartTimeIsNotNull() {
            addCriterion("issue_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andIssueStartTimeEqualTo(Date value) {
            addCriterion("issue_start_time =", value, "issueStartTime");
            return (Criteria) this;
        }

        public Criteria andIssueStartTimeNotEqualTo(Date value) {
            addCriterion("issue_start_time <>", value, "issueStartTime");
            return (Criteria) this;
        }

        public Criteria andIssueStartTimeGreaterThan(Date value) {
            addCriterion("issue_start_time >", value, "issueStartTime");
            return (Criteria) this;
        }

        public Criteria andIssueStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("issue_start_time >=", value, "issueStartTime");
            return (Criteria) this;
        }

        public Criteria andIssueStartTimeLessThan(Date value) {
            addCriterion("issue_start_time <", value, "issueStartTime");
            return (Criteria) this;
        }

        public Criteria andIssueStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("issue_start_time <=", value, "issueStartTime");
            return (Criteria) this;
        }

        public Criteria andIssueStartTimeIn(List<Date> values) {
            addCriterion("issue_start_time in", values, "issueStartTime");
            return (Criteria) this;
        }

        public Criteria andIssueStartTimeNotIn(List<Date> values) {
            addCriterion("issue_start_time not in", values, "issueStartTime");
            return (Criteria) this;
        }

        public Criteria andIssueStartTimeBetween(Date value1, Date value2) {
            addCriterion("issue_start_time between", value1, value2, "issueStartTime");
            return (Criteria) this;
        }

        public Criteria andIssueStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("issue_start_time not between", value1, value2, "issueStartTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeIsNull() {
            addCriterion("issue_end_time is null");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeIsNotNull() {
            addCriterion("issue_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeEqualTo(Date value) {
            addCriterion("issue_end_time =", value, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeNotEqualTo(Date value) {
            addCriterion("issue_end_time <>", value, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeGreaterThan(Date value) {
            addCriterion("issue_end_time >", value, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("issue_end_time >=", value, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeLessThan(Date value) {
            addCriterion("issue_end_time <", value, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("issue_end_time <=", value, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeIn(List<Date> values) {
            addCriterion("issue_end_time in", values, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeNotIn(List<Date> values) {
            addCriterion("issue_end_time not in", values, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeBetween(Date value1, Date value2) {
            addCriterion("issue_end_time between", value1, value2, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andIssueEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("issue_end_time not between", value1, value2, "issueEndTime");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountIsNull() {
            addCriterion("promotion_amount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountIsNotNull() {
            addCriterion("promotion_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountEqualTo(BigDecimal value) {
            addCriterion("promotion_amount =", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountNotEqualTo(BigDecimal value) {
            addCriterion("promotion_amount <>", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountGreaterThan(BigDecimal value) {
            addCriterion("promotion_amount >", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_amount >=", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountLessThan(BigDecimal value) {
            addCriterion("promotion_amount <", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_amount <=", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountIn(List<BigDecimal> values) {
            addCriterion("promotion_amount in", values, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountNotIn(List<BigDecimal> values) {
            addCriterion("promotion_amount not in", values, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_amount between", value1, value2, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_amount not between", value1, value2, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountIsNull() {
            addCriterion("order_full_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountIsNotNull() {
            addCriterion("order_full_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountEqualTo(BigDecimal value) {
            addCriterion("order_full_amount =", value, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_full_amount <>", value, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountGreaterThan(BigDecimal value) {
            addCriterion("order_full_amount >", value, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_full_amount >=", value, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountLessThan(BigDecimal value) {
            addCriterion("order_full_amount <", value, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_full_amount <=", value, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountIn(List<BigDecimal> values) {
            addCriterion("order_full_amount in", values, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_full_amount not in", values, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_full_amount between", value1, value2, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_full_amount not between", value1, value2, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountIsNull() {
            addCriterion("promotion_max_amount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountIsNotNull() {
            addCriterion("promotion_max_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountEqualTo(BigDecimal value) {
            addCriterion("promotion_max_amount =", value, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("promotion_max_amount <>", value, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountGreaterThan(BigDecimal value) {
            addCriterion("promotion_max_amount >", value, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_max_amount >=", value, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountLessThan(BigDecimal value) {
            addCriterion("promotion_max_amount <", value, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_max_amount <=", value, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountIn(List<BigDecimal> values) {
            addCriterion("promotion_max_amount in", values, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("promotion_max_amount not in", values, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_max_amount between", value1, value2, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_max_amount not between", value1, value2, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNull() {
            addCriterion("discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNotNull() {
            addCriterion("discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountEqualTo(BigDecimal value) {
            addCriterion("discount_amount =", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotEqualTo(BigDecimal value) {
            addCriterion("discount_amount <>", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThan(BigDecimal value) {
            addCriterion("discount_amount >", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_amount >=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThan(BigDecimal value) {
            addCriterion("discount_amount <", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_amount <=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIn(List<BigDecimal> values) {
            addCriterion("discount_amount in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotIn(List<BigDecimal> values) {
            addCriterion("discount_amount not in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_amount between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_amount not between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andCouponStatusIsNull() {
            addCriterion("coupon_status is null");
            return (Criteria) this;
        }

        public Criteria andCouponStatusIsNotNull() {
            addCriterion("coupon_status is not null");
            return (Criteria) this;
        }

        public Criteria andCouponStatusEqualTo(Byte value) {
            addCriterion("coupon_status =", value, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusNotEqualTo(Byte value) {
            addCriterion("coupon_status <>", value, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusGreaterThan(Byte value) {
            addCriterion("coupon_status >", value, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("coupon_status >=", value, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusLessThan(Byte value) {
            addCriterion("coupon_status <", value, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusLessThanOrEqualTo(Byte value) {
            addCriterion("coupon_status <=", value, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusIn(List<Byte> values) {
            addCriterion("coupon_status in", values, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusNotIn(List<Byte> values) {
            addCriterion("coupon_status not in", values, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusBetween(Byte value1, Byte value2) {
            addCriterion("coupon_status between", value1, value2, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("coupon_status not between", value1, value2, "couponStatus");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNull() {
            addCriterion("create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("create_user_name not between", value1, value2, "createUserName");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("update_user_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("update_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("update_user_name =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("update_user_name <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("update_user_name >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_name >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("update_user_name <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("update_user_name <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("update_user_name like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("update_user_name not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(List<String> values) {
            addCriterion("update_user_name in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(List<String> values) {
            addCriterion("update_user_name not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("update_user_name between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("update_user_name not between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
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