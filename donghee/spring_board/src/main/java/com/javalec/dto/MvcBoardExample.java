package com.javalec.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MvcBoardExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    public MvcBoardExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
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

        public Criteria andBidIsNull() {
            addCriterion("bId is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bId is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Long value) {
            addCriterion("bId =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Long value) {
            addCriterion("bId <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Long value) {
            addCriterion("bId >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Long value) {
            addCriterion("bId >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Long value) {
            addCriterion("bId <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Long value) {
            addCriterion("bId <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Long> values) {
            addCriterion("bId in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Long> values) {
            addCriterion("bId not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Long value1, Long value2) {
            addCriterion("bId between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Long value1, Long value2) {
            addCriterion("bId not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBnameIsNull() {
            addCriterion("bName is null");
            return (Criteria) this;
        }

        public Criteria andBnameIsNotNull() {
            addCriterion("bName is not null");
            return (Criteria) this;
        }

        public Criteria andBnameEqualTo(String value) {
            addCriterion("bName =", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotEqualTo(String value) {
            addCriterion("bName <>", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThan(String value) {
            addCriterion("bName >", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThanOrEqualTo(String value) {
            addCriterion("bName >=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThan(String value) {
            addCriterion("bName <", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThanOrEqualTo(String value) {
            addCriterion("bName <=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLike(String value) {
            addCriterion("bName like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotLike(String value) {
            addCriterion("bName not like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameIn(List<String> values) {
            addCriterion("bName in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotIn(List<String> values) {
            addCriterion("bName not in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameBetween(String value1, String value2) {
            addCriterion("bName between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotBetween(String value1, String value2) {
            addCriterion("bName not between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBtitleIsNull() {
            addCriterion("bTitle is null");
            return (Criteria) this;
        }

        public Criteria andBtitleIsNotNull() {
            addCriterion("bTitle is not null");
            return (Criteria) this;
        }

        public Criteria andBtitleEqualTo(String value) {
            addCriterion("bTitle =", value, "btitle");
            return (Criteria) this;
        }

        public Criteria andBtitleNotEqualTo(String value) {
            addCriterion("bTitle <>", value, "btitle");
            return (Criteria) this;
        }

        public Criteria andBtitleGreaterThan(String value) {
            addCriterion("bTitle >", value, "btitle");
            return (Criteria) this;
        }

        public Criteria andBtitleGreaterThanOrEqualTo(String value) {
            addCriterion("bTitle >=", value, "btitle");
            return (Criteria) this;
        }

        public Criteria andBtitleLessThan(String value) {
            addCriterion("bTitle <", value, "btitle");
            return (Criteria) this;
        }

        public Criteria andBtitleLessThanOrEqualTo(String value) {
            addCriterion("bTitle <=", value, "btitle");
            return (Criteria) this;
        }

        public Criteria andBtitleLike(String value) {
            addCriterion("bTitle like", value, "btitle");
            return (Criteria) this;
        }

        public Criteria andBtitleNotLike(String value) {
            addCriterion("bTitle not like", value, "btitle");
            return (Criteria) this;
        }

        public Criteria andBtitleIn(List<String> values) {
            addCriterion("bTitle in", values, "btitle");
            return (Criteria) this;
        }

        public Criteria andBtitleNotIn(List<String> values) {
            addCriterion("bTitle not in", values, "btitle");
            return (Criteria) this;
        }

        public Criteria andBtitleBetween(String value1, String value2) {
            addCriterion("bTitle between", value1, value2, "btitle");
            return (Criteria) this;
        }

        public Criteria andBtitleNotBetween(String value1, String value2) {
            addCriterion("bTitle not between", value1, value2, "btitle");
            return (Criteria) this;
        }

        public Criteria andBcontentIsNull() {
            addCriterion("bContent is null");
            return (Criteria) this;
        }

        public Criteria andBcontentIsNotNull() {
            addCriterion("bContent is not null");
            return (Criteria) this;
        }

        public Criteria andBcontentEqualTo(String value) {
            addCriterion("bContent =", value, "bcontent");
            return (Criteria) this;
        }

        public Criteria andBcontentNotEqualTo(String value) {
            addCriterion("bContent <>", value, "bcontent");
            return (Criteria) this;
        }

        public Criteria andBcontentGreaterThan(String value) {
            addCriterion("bContent >", value, "bcontent");
            return (Criteria) this;
        }

        public Criteria andBcontentGreaterThanOrEqualTo(String value) {
            addCriterion("bContent >=", value, "bcontent");
            return (Criteria) this;
        }

        public Criteria andBcontentLessThan(String value) {
            addCriterion("bContent <", value, "bcontent");
            return (Criteria) this;
        }

        public Criteria andBcontentLessThanOrEqualTo(String value) {
            addCriterion("bContent <=", value, "bcontent");
            return (Criteria) this;
        }

        public Criteria andBcontentLike(String value) {
            addCriterion("bContent like", value, "bcontent");
            return (Criteria) this;
        }

        public Criteria andBcontentNotLike(String value) {
            addCriterion("bContent not like", value, "bcontent");
            return (Criteria) this;
        }

        public Criteria andBcontentIn(List<String> values) {
            addCriterion("bContent in", values, "bcontent");
            return (Criteria) this;
        }

        public Criteria andBcontentNotIn(List<String> values) {
            addCriterion("bContent not in", values, "bcontent");
            return (Criteria) this;
        }

        public Criteria andBcontentBetween(String value1, String value2) {
            addCriterion("bContent between", value1, value2, "bcontent");
            return (Criteria) this;
        }

        public Criteria andBcontentNotBetween(String value1, String value2) {
            addCriterion("bContent not between", value1, value2, "bcontent");
            return (Criteria) this;
        }

        public Criteria andBdateIsNull() {
            addCriterion("bDate is null");
            return (Criteria) this;
        }

        public Criteria andBdateIsNotNull() {
            addCriterion("bDate is not null");
            return (Criteria) this;
        }

        public Criteria andBdateEqualTo(Date value) {
            addCriterion("bDate =", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateNotEqualTo(Date value) {
            addCriterion("bDate <>", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateGreaterThan(Date value) {
            addCriterion("bDate >", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateGreaterThanOrEqualTo(Date value) {
            addCriterion("bDate >=", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateLessThan(Date value) {
            addCriterion("bDate <", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateLessThanOrEqualTo(Date value) {
            addCriterion("bDate <=", value, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateIn(List<Date> values) {
            addCriterion("bDate in", values, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateNotIn(List<Date> values) {
            addCriterion("bDate not in", values, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateBetween(Date value1, Date value2) {
            addCriterion("bDate between", value1, value2, "bdate");
            return (Criteria) this;
        }

        public Criteria andBdateNotBetween(Date value1, Date value2) {
            addCriterion("bDate not between", value1, value2, "bdate");
            return (Criteria) this;
        }

        public Criteria andBhitIsNull() {
            addCriterion("bHit is null");
            return (Criteria) this;
        }

        public Criteria andBhitIsNotNull() {
            addCriterion("bHit is not null");
            return (Criteria) this;
        }

        public Criteria andBhitEqualTo(Integer value) {
            addCriterion("bHit =", value, "bhit");
            return (Criteria) this;
        }

        public Criteria andBhitNotEqualTo(Integer value) {
            addCriterion("bHit <>", value, "bhit");
            return (Criteria) this;
        }

        public Criteria andBhitGreaterThan(Integer value) {
            addCriterion("bHit >", value, "bhit");
            return (Criteria) this;
        }

        public Criteria andBhitGreaterThanOrEqualTo(Integer value) {
            addCriterion("bHit >=", value, "bhit");
            return (Criteria) this;
        }

        public Criteria andBhitLessThan(Integer value) {
            addCriterion("bHit <", value, "bhit");
            return (Criteria) this;
        }

        public Criteria andBhitLessThanOrEqualTo(Integer value) {
            addCriterion("bHit <=", value, "bhit");
            return (Criteria) this;
        }

        public Criteria andBhitIn(List<Integer> values) {
            addCriterion("bHit in", values, "bhit");
            return (Criteria) this;
        }

        public Criteria andBhitNotIn(List<Integer> values) {
            addCriterion("bHit not in", values, "bhit");
            return (Criteria) this;
        }

        public Criteria andBhitBetween(Integer value1, Integer value2) {
            addCriterion("bHit between", value1, value2, "bhit");
            return (Criteria) this;
        }

        public Criteria andBhitNotBetween(Integer value1, Integer value2) {
            addCriterion("bHit not between", value1, value2, "bhit");
            return (Criteria) this;
        }

        public Criteria andBgroupIsNull() {
            addCriterion("bGroup is null");
            return (Criteria) this;
        }

        public Criteria andBgroupIsNotNull() {
            addCriterion("bGroup is not null");
            return (Criteria) this;
        }

        public Criteria andBgroupEqualTo(Integer value) {
            addCriterion("bGroup =", value, "bgroup");
            return (Criteria) this;
        }

        public Criteria andBgroupNotEqualTo(Integer value) {
            addCriterion("bGroup <>", value, "bgroup");
            return (Criteria) this;
        }

        public Criteria andBgroupGreaterThan(Integer value) {
            addCriterion("bGroup >", value, "bgroup");
            return (Criteria) this;
        }

        public Criteria andBgroupGreaterThanOrEqualTo(Integer value) {
            addCriterion("bGroup >=", value, "bgroup");
            return (Criteria) this;
        }

        public Criteria andBgroupLessThan(Integer value) {
            addCriterion("bGroup <", value, "bgroup");
            return (Criteria) this;
        }

        public Criteria andBgroupLessThanOrEqualTo(Integer value) {
            addCriterion("bGroup <=", value, "bgroup");
            return (Criteria) this;
        }

        public Criteria andBgroupIn(List<Integer> values) {
            addCriterion("bGroup in", values, "bgroup");
            return (Criteria) this;
        }

        public Criteria andBgroupNotIn(List<Integer> values) {
            addCriterion("bGroup not in", values, "bgroup");
            return (Criteria) this;
        }

        public Criteria andBgroupBetween(Integer value1, Integer value2) {
            addCriterion("bGroup between", value1, value2, "bgroup");
            return (Criteria) this;
        }

        public Criteria andBgroupNotBetween(Integer value1, Integer value2) {
            addCriterion("bGroup not between", value1, value2, "bgroup");
            return (Criteria) this;
        }

        public Criteria andBstepIsNull() {
            addCriterion("bStep is null");
            return (Criteria) this;
        }

        public Criteria andBstepIsNotNull() {
            addCriterion("bStep is not null");
            return (Criteria) this;
        }

        public Criteria andBstepEqualTo(Integer value) {
            addCriterion("bStep =", value, "bstep");
            return (Criteria) this;
        }

        public Criteria andBstepNotEqualTo(Integer value) {
            addCriterion("bStep <>", value, "bstep");
            return (Criteria) this;
        }

        public Criteria andBstepGreaterThan(Integer value) {
            addCriterion("bStep >", value, "bstep");
            return (Criteria) this;
        }

        public Criteria andBstepGreaterThanOrEqualTo(Integer value) {
            addCriterion("bStep >=", value, "bstep");
            return (Criteria) this;
        }

        public Criteria andBstepLessThan(Integer value) {
            addCriterion("bStep <", value, "bstep");
            return (Criteria) this;
        }

        public Criteria andBstepLessThanOrEqualTo(Integer value) {
            addCriterion("bStep <=", value, "bstep");
            return (Criteria) this;
        }

        public Criteria andBstepIn(List<Integer> values) {
            addCriterion("bStep in", values, "bstep");
            return (Criteria) this;
        }

        public Criteria andBstepNotIn(List<Integer> values) {
            addCriterion("bStep not in", values, "bstep");
            return (Criteria) this;
        }

        public Criteria andBstepBetween(Integer value1, Integer value2) {
            addCriterion("bStep between", value1, value2, "bstep");
            return (Criteria) this;
        }

        public Criteria andBstepNotBetween(Integer value1, Integer value2) {
            addCriterion("bStep not between", value1, value2, "bstep");
            return (Criteria) this;
        }

        public Criteria andBindentIsNull() {
            addCriterion("bIndent is null");
            return (Criteria) this;
        }

        public Criteria andBindentIsNotNull() {
            addCriterion("bIndent is not null");
            return (Criteria) this;
        }

        public Criteria andBindentEqualTo(Integer value) {
            addCriterion("bIndent =", value, "bindent");
            return (Criteria) this;
        }

        public Criteria andBindentNotEqualTo(Integer value) {
            addCriterion("bIndent <>", value, "bindent");
            return (Criteria) this;
        }

        public Criteria andBindentGreaterThan(Integer value) {
            addCriterion("bIndent >", value, "bindent");
            return (Criteria) this;
        }

        public Criteria andBindentGreaterThanOrEqualTo(Integer value) {
            addCriterion("bIndent >=", value, "bindent");
            return (Criteria) this;
        }

        public Criteria andBindentLessThan(Integer value) {
            addCriterion("bIndent <", value, "bindent");
            return (Criteria) this;
        }

        public Criteria andBindentLessThanOrEqualTo(Integer value) {
            addCriterion("bIndent <=", value, "bindent");
            return (Criteria) this;
        }

        public Criteria andBindentIn(List<Integer> values) {
            addCriterion("bIndent in", values, "bindent");
            return (Criteria) this;
        }

        public Criteria andBindentNotIn(List<Integer> values) {
            addCriterion("bIndent not in", values, "bindent");
            return (Criteria) this;
        }

        public Criteria andBindentBetween(Integer value1, Integer value2) {
            addCriterion("bIndent between", value1, value2, "bindent");
            return (Criteria) this;
        }

        public Criteria andBindentNotBetween(Integer value1, Integer value2) {
            addCriterion("bIndent not between", value1, value2, "bindent");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIsNull() {
            addCriterion("deleteFlag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIsNotNull() {
            addCriterion("deleteFlag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteflagEqualTo(Integer value) {
            addCriterion("deleteFlag =", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotEqualTo(Integer value) {
            addCriterion("deleteFlag <>", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagGreaterThan(Integer value) {
            addCriterion("deleteFlag >", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleteFlag >=", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagLessThan(Integer value) {
            addCriterion("deleteFlag <", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagLessThanOrEqualTo(Integer value) {
            addCriterion("deleteFlag <=", value, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagIn(List<Integer> values) {
            addCriterion("deleteFlag in", values, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotIn(List<Integer> values) {
            addCriterion("deleteFlag not in", values, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagBetween(Integer value1, Integer value2) {
            addCriterion("deleteFlag between", value1, value2, "deleteflag");
            return (Criteria) this;
        }

        public Criteria andDeleteflagNotBetween(Integer value1, Integer value2) {
            addCriterion("deleteFlag not between", value1, value2, "deleteflag");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mvc_board
     *
     * @mbg.generated do_not_delete_during_merge Sat Dec 16 11:53:36 KST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table mvc_board
     *
     * @mbg.generated Sat Dec 16 11:53:36 KST 2017
     */
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