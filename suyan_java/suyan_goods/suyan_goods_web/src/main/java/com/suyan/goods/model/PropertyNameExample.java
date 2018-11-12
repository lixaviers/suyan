package com.suyan.goods.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PropertyNameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PropertyNameExample() {
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIsAllowAliasIsNull() {
            addCriterion("is_allow_alias is null");
            return (Criteria) this;
        }

        public Criteria andIsAllowAliasIsNotNull() {
            addCriterion("is_allow_alias is not null");
            return (Criteria) this;
        }

        public Criteria andIsAllowAliasEqualTo(Boolean value) {
            addCriterion("is_allow_alias =", value, "isAllowAlias");
            return (Criteria) this;
        }

        public Criteria andIsAllowAliasNotEqualTo(Boolean value) {
            addCriterion("is_allow_alias <>", value, "isAllowAlias");
            return (Criteria) this;
        }

        public Criteria andIsAllowAliasGreaterThan(Boolean value) {
            addCriterion("is_allow_alias >", value, "isAllowAlias");
            return (Criteria) this;
        }

        public Criteria andIsAllowAliasGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_allow_alias >=", value, "isAllowAlias");
            return (Criteria) this;
        }

        public Criteria andIsAllowAliasLessThan(Boolean value) {
            addCriterion("is_allow_alias <", value, "isAllowAlias");
            return (Criteria) this;
        }

        public Criteria andIsAllowAliasLessThanOrEqualTo(Boolean value) {
            addCriterion("is_allow_alias <=", value, "isAllowAlias");
            return (Criteria) this;
        }

        public Criteria andIsAllowAliasIn(List<Boolean> values) {
            addCriterion("is_allow_alias in", values, "isAllowAlias");
            return (Criteria) this;
        }

        public Criteria andIsAllowAliasNotIn(List<Boolean> values) {
            addCriterion("is_allow_alias not in", values, "isAllowAlias");
            return (Criteria) this;
        }

        public Criteria andIsAllowAliasBetween(Boolean value1, Boolean value2) {
            addCriterion("is_allow_alias between", value1, value2, "isAllowAlias");
            return (Criteria) this;
        }

        public Criteria andIsAllowAliasNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_allow_alias not between", value1, value2, "isAllowAlias");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeIsNull() {
            addCriterion("is_color_attribute is null");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeIsNotNull() {
            addCriterion("is_color_attribute is not null");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeEqualTo(Boolean value) {
            addCriterion("is_color_attribute =", value, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeNotEqualTo(Boolean value) {
            addCriterion("is_color_attribute <>", value, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeGreaterThan(Boolean value) {
            addCriterion("is_color_attribute >", value, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_color_attribute >=", value, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeLessThan(Boolean value) {
            addCriterion("is_color_attribute <", value, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_color_attribute <=", value, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeIn(List<Boolean> values) {
            addCriterion("is_color_attribute in", values, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeNotIn(List<Boolean> values) {
            addCriterion("is_color_attribute not in", values, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_color_attribute between", value1, value2, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_color_attribute not between", value1, value2, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsEnumAttributeIsNull() {
            addCriterion("is_enum_attribute is null");
            return (Criteria) this;
        }

        public Criteria andIsEnumAttributeIsNotNull() {
            addCriterion("is_enum_attribute is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnumAttributeEqualTo(Boolean value) {
            addCriterion("is_enum_attribute =", value, "isEnumAttribute");
            return (Criteria) this;
        }

        public Criteria andIsEnumAttributeNotEqualTo(Boolean value) {
            addCriterion("is_enum_attribute <>", value, "isEnumAttribute");
            return (Criteria) this;
        }

        public Criteria andIsEnumAttributeGreaterThan(Boolean value) {
            addCriterion("is_enum_attribute >", value, "isEnumAttribute");
            return (Criteria) this;
        }

        public Criteria andIsEnumAttributeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_enum_attribute >=", value, "isEnumAttribute");
            return (Criteria) this;
        }

        public Criteria andIsEnumAttributeLessThan(Boolean value) {
            addCriterion("is_enum_attribute <", value, "isEnumAttribute");
            return (Criteria) this;
        }

        public Criteria andIsEnumAttributeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_enum_attribute <=", value, "isEnumAttribute");
            return (Criteria) this;
        }

        public Criteria andIsEnumAttributeIn(List<Boolean> values) {
            addCriterion("is_enum_attribute in", values, "isEnumAttribute");
            return (Criteria) this;
        }

        public Criteria andIsEnumAttributeNotIn(List<Boolean> values) {
            addCriterion("is_enum_attribute not in", values, "isEnumAttribute");
            return (Criteria) this;
        }

        public Criteria andIsEnumAttributeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enum_attribute between", value1, value2, "isEnumAttribute");
            return (Criteria) this;
        }

        public Criteria andIsEnumAttributeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enum_attribute not between", value1, value2, "isEnumAttribute");
            return (Criteria) this;
        }

        public Criteria andIsInputAttributeIsNull() {
            addCriterion("is_input_attribute is null");
            return (Criteria) this;
        }

        public Criteria andIsInputAttributeIsNotNull() {
            addCriterion("is_input_attribute is not null");
            return (Criteria) this;
        }

        public Criteria andIsInputAttributeEqualTo(Boolean value) {
            addCriterion("is_input_attribute =", value, "isInputAttribute");
            return (Criteria) this;
        }

        public Criteria andIsInputAttributeNotEqualTo(Boolean value) {
            addCriterion("is_input_attribute <>", value, "isInputAttribute");
            return (Criteria) this;
        }

        public Criteria andIsInputAttributeGreaterThan(Boolean value) {
            addCriterion("is_input_attribute >", value, "isInputAttribute");
            return (Criteria) this;
        }

        public Criteria andIsInputAttributeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_input_attribute >=", value, "isInputAttribute");
            return (Criteria) this;
        }

        public Criteria andIsInputAttributeLessThan(Boolean value) {
            addCriterion("is_input_attribute <", value, "isInputAttribute");
            return (Criteria) this;
        }

        public Criteria andIsInputAttributeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_input_attribute <=", value, "isInputAttribute");
            return (Criteria) this;
        }

        public Criteria andIsInputAttributeIn(List<Boolean> values) {
            addCriterion("is_input_attribute in", values, "isInputAttribute");
            return (Criteria) this;
        }

        public Criteria andIsInputAttributeNotIn(List<Boolean> values) {
            addCriterion("is_input_attribute not in", values, "isInputAttribute");
            return (Criteria) this;
        }

        public Criteria andIsInputAttributeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_input_attribute between", value1, value2, "isInputAttribute");
            return (Criteria) this;
        }

        public Criteria andIsInputAttributeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_input_attribute not between", value1, value2, "isInputAttribute");
            return (Criteria) this;
        }

        public Criteria andIsSalesPropertyIsNull() {
            addCriterion("is_sales_property is null");
            return (Criteria) this;
        }

        public Criteria andIsSalesPropertyIsNotNull() {
            addCriterion("is_sales_property is not null");
            return (Criteria) this;
        }

        public Criteria andIsSalesPropertyEqualTo(Boolean value) {
            addCriterion("is_sales_property =", value, "isSalesProperty");
            return (Criteria) this;
        }

        public Criteria andIsSalesPropertyNotEqualTo(Boolean value) {
            addCriterion("is_sales_property <>", value, "isSalesProperty");
            return (Criteria) this;
        }

        public Criteria andIsSalesPropertyGreaterThan(Boolean value) {
            addCriterion("is_sales_property >", value, "isSalesProperty");
            return (Criteria) this;
        }

        public Criteria andIsSalesPropertyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_sales_property >=", value, "isSalesProperty");
            return (Criteria) this;
        }

        public Criteria andIsSalesPropertyLessThan(Boolean value) {
            addCriterion("is_sales_property <", value, "isSalesProperty");
            return (Criteria) this;
        }

        public Criteria andIsSalesPropertyLessThanOrEqualTo(Boolean value) {
            addCriterion("is_sales_property <=", value, "isSalesProperty");
            return (Criteria) this;
        }

        public Criteria andIsSalesPropertyIn(List<Boolean> values) {
            addCriterion("is_sales_property in", values, "isSalesProperty");
            return (Criteria) this;
        }

        public Criteria andIsSalesPropertyNotIn(List<Boolean> values) {
            addCriterion("is_sales_property not in", values, "isSalesProperty");
            return (Criteria) this;
        }

        public Criteria andIsSalesPropertyBetween(Boolean value1, Boolean value2) {
            addCriterion("is_sales_property between", value1, value2, "isSalesProperty");
            return (Criteria) this;
        }

        public Criteria andIsSalesPropertyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_sales_property not between", value1, value2, "isSalesProperty");
            return (Criteria) this;
        }

        public Criteria andIsSearchFieldIsNull() {
            addCriterion("is_search_field is null");
            return (Criteria) this;
        }

        public Criteria andIsSearchFieldIsNotNull() {
            addCriterion("is_search_field is not null");
            return (Criteria) this;
        }

        public Criteria andIsSearchFieldEqualTo(Boolean value) {
            addCriterion("is_search_field =", value, "isSearchField");
            return (Criteria) this;
        }

        public Criteria andIsSearchFieldNotEqualTo(Boolean value) {
            addCriterion("is_search_field <>", value, "isSearchField");
            return (Criteria) this;
        }

        public Criteria andIsSearchFieldGreaterThan(Boolean value) {
            addCriterion("is_search_field >", value, "isSearchField");
            return (Criteria) this;
        }

        public Criteria andIsSearchFieldGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_search_field >=", value, "isSearchField");
            return (Criteria) this;
        }

        public Criteria andIsSearchFieldLessThan(Boolean value) {
            addCriterion("is_search_field <", value, "isSearchField");
            return (Criteria) this;
        }

        public Criteria andIsSearchFieldLessThanOrEqualTo(Boolean value) {
            addCriterion("is_search_field <=", value, "isSearchField");
            return (Criteria) this;
        }

        public Criteria andIsSearchFieldIn(List<Boolean> values) {
            addCriterion("is_search_field in", values, "isSearchField");
            return (Criteria) this;
        }

        public Criteria andIsSearchFieldNotIn(List<Boolean> values) {
            addCriterion("is_search_field not in", values, "isSearchField");
            return (Criteria) this;
        }

        public Criteria andIsSearchFieldBetween(Boolean value1, Boolean value2) {
            addCriterion("is_search_field between", value1, value2, "isSearchField");
            return (Criteria) this;
        }

        public Criteria andIsSearchFieldNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_search_field not between", value1, value2, "isSearchField");
            return (Criteria) this;
        }

        public Criteria andIsWillChooseIsNull() {
            addCriterion("is_will_choose is null");
            return (Criteria) this;
        }

        public Criteria andIsWillChooseIsNotNull() {
            addCriterion("is_will_choose is not null");
            return (Criteria) this;
        }

        public Criteria andIsWillChooseEqualTo(Boolean value) {
            addCriterion("is_will_choose =", value, "isWillChoose");
            return (Criteria) this;
        }

        public Criteria andIsWillChooseNotEqualTo(Boolean value) {
            addCriterion("is_will_choose <>", value, "isWillChoose");
            return (Criteria) this;
        }

        public Criteria andIsWillChooseGreaterThan(Boolean value) {
            addCriterion("is_will_choose >", value, "isWillChoose");
            return (Criteria) this;
        }

        public Criteria andIsWillChooseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_will_choose >=", value, "isWillChoose");
            return (Criteria) this;
        }

        public Criteria andIsWillChooseLessThan(Boolean value) {
            addCriterion("is_will_choose <", value, "isWillChoose");
            return (Criteria) this;
        }

        public Criteria andIsWillChooseLessThanOrEqualTo(Boolean value) {
            addCriterion("is_will_choose <=", value, "isWillChoose");
            return (Criteria) this;
        }

        public Criteria andIsWillChooseIn(List<Boolean> values) {
            addCriterion("is_will_choose in", values, "isWillChoose");
            return (Criteria) this;
        }

        public Criteria andIsWillChooseNotIn(List<Boolean> values) {
            addCriterion("is_will_choose not in", values, "isWillChoose");
            return (Criteria) this;
        }

        public Criteria andIsWillChooseBetween(Boolean value1, Boolean value2) {
            addCriterion("is_will_choose between", value1, value2, "isWillChoose");
            return (Criteria) this;
        }

        public Criteria andIsWillChooseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_will_choose not between", value1, value2, "isWillChoose");
            return (Criteria) this;
        }

        public Criteria andIsMultiSelectIsNull() {
            addCriterion("is_multi_select is null");
            return (Criteria) this;
        }

        public Criteria andIsMultiSelectIsNotNull() {
            addCriterion("is_multi_select is not null");
            return (Criteria) this;
        }

        public Criteria andIsMultiSelectEqualTo(Boolean value) {
            addCriterion("is_multi_select =", value, "isMultiSelect");
            return (Criteria) this;
        }

        public Criteria andIsMultiSelectNotEqualTo(Boolean value) {
            addCriterion("is_multi_select <>", value, "isMultiSelect");
            return (Criteria) this;
        }

        public Criteria andIsMultiSelectGreaterThan(Boolean value) {
            addCriterion("is_multi_select >", value, "isMultiSelect");
            return (Criteria) this;
        }

        public Criteria andIsMultiSelectGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_multi_select >=", value, "isMultiSelect");
            return (Criteria) this;
        }

        public Criteria andIsMultiSelectLessThan(Boolean value) {
            addCriterion("is_multi_select <", value, "isMultiSelect");
            return (Criteria) this;
        }

        public Criteria andIsMultiSelectLessThanOrEqualTo(Boolean value) {
            addCriterion("is_multi_select <=", value, "isMultiSelect");
            return (Criteria) this;
        }

        public Criteria andIsMultiSelectIn(List<Boolean> values) {
            addCriterion("is_multi_select in", values, "isMultiSelect");
            return (Criteria) this;
        }

        public Criteria andIsMultiSelectNotIn(List<Boolean> values) {
            addCriterion("is_multi_select not in", values, "isMultiSelect");
            return (Criteria) this;
        }

        public Criteria andIsMultiSelectBetween(Boolean value1, Boolean value2) {
            addCriterion("is_multi_select between", value1, value2, "isMultiSelect");
            return (Criteria) this;
        }

        public Criteria andIsMultiSelectNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_multi_select not between", value1, value2, "isMultiSelect");
            return (Criteria) this;
        }

        public Criteria andCommonStatusIsNull() {
            addCriterion("common_status is null");
            return (Criteria) this;
        }

        public Criteria andCommonStatusIsNotNull() {
            addCriterion("common_status is not null");
            return (Criteria) this;
        }

        public Criteria andCommonStatusEqualTo(Byte value) {
            addCriterion("common_status =", value, "commonStatus");
            return (Criteria) this;
        }

        public Criteria andCommonStatusNotEqualTo(Byte value) {
            addCriterion("common_status <>", value, "commonStatus");
            return (Criteria) this;
        }

        public Criteria andCommonStatusGreaterThan(Byte value) {
            addCriterion("common_status >", value, "commonStatus");
            return (Criteria) this;
        }

        public Criteria andCommonStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("common_status >=", value, "commonStatus");
            return (Criteria) this;
        }

        public Criteria andCommonStatusLessThan(Byte value) {
            addCriterion("common_status <", value, "commonStatus");
            return (Criteria) this;
        }

        public Criteria andCommonStatusLessThanOrEqualTo(Byte value) {
            addCriterion("common_status <=", value, "commonStatus");
            return (Criteria) this;
        }

        public Criteria andCommonStatusIn(List<Byte> values) {
            addCriterion("common_status in", values, "commonStatus");
            return (Criteria) this;
        }

        public Criteria andCommonStatusNotIn(List<Byte> values) {
            addCriterion("common_status not in", values, "commonStatus");
            return (Criteria) this;
        }

        public Criteria andCommonStatusBetween(Byte value1, Byte value2) {
            addCriterion("common_status between", value1, value2, "commonStatus");
            return (Criteria) this;
        }

        public Criteria andCommonStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("common_status not between", value1, value2, "commonStatus");
            return (Criteria) this;
        }

        public Criteria andSortNumberIsNull() {
            addCriterion("sort_number is null");
            return (Criteria) this;
        }

        public Criteria andSortNumberIsNotNull() {
            addCriterion("sort_number is not null");
            return (Criteria) this;
        }

        public Criteria andSortNumberEqualTo(Integer value) {
            addCriterion("sort_number =", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberNotEqualTo(Integer value) {
            addCriterion("sort_number <>", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberGreaterThan(Integer value) {
            addCriterion("sort_number >", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_number >=", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberLessThan(Integer value) {
            addCriterion("sort_number <", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberLessThanOrEqualTo(Integer value) {
            addCriterion("sort_number <=", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberIn(List<Integer> values) {
            addCriterion("sort_number in", values, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberNotIn(List<Integer> values) {
            addCriterion("sort_number not in", values, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberBetween(Integer value1, Integer value2) {
            addCriterion("sort_number between", value1, value2, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_number not between", value1, value2, "sortNumber");
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