package com.looobo.converter;

public enum Columns {
    //1. #2015年3月份临时救助申报基本情况表.xls
    INDEX("index"),
    NAME("name"),
    AGE("age"),
    FAMILY_MEMBERS("family_members"),
    IDENTITY("identity_id"),
    ADDRESS("family_address"),
    HOME_BACKGROUND("home_background"),
    VILLAGE_AMOUNT("village_amount"),
    ALLOWANCES_AMOUNT("allowances_amount"),
    TOWN_AMOUNT("town_amount"),
    //OTHER("other"),

    //2. #2015年3月农村低保备案表.xls
    //INDEX("index"),
    ALLOWANCE_ID("allowance_id"),
    RELATIONSHIP("relationship"),
    FAMILY_NAME("family_name"),
    SEX("sex"),
    //IDENTITY("identity_id"),
    //AGE("age"),
    ALLOWANCE_CREATE_TIME("allowance_create_time"),
    ALLOWANCES_AMOUNT_PER_MONTH("allowances_amount_per_month"),
    FAMILY_MEMBER_CATEGORY_AMOUNT("family_member_category_amount"),
    ELECTRIC_CHARGE_ALLOWANCE("electric_charge_allowance"),
    FAMILY_ALLOWANCE_AMOUNT("family_allowance_amount"),
    //ADDRESS("family_address"),
    //OTHER("other"),
    REASON("reason"),

    //3. 千阳县2015年农村五保户花名册 .xls
    //INDEX("index"),
    FIVE_ALLOWANCE_ID("five_allowance_id"),
    //NAME("name"),
    //SEX("sex"),
    NATION("nation"),
    //IDENTITY("identity_id"),
    //ADDRESS("family_address"),
    SUPPORT_FORM("support_form"),
    APPLY_TIME("apply_time"),
    //OTHER("other"),

    //4. 千阳县城乡医疗救助表格2014年.xls
    //INDEX("index"),
    //NAME("name"),
    //SEX("sex"),
    //AGE("age"),
    //IDENTITY("identity_id"),
    //ADDRESS("family_address"),
    DISEASE("disease"),
    HOSPITAL("hospital"),
    ENTER_HOSPITAL_TIME("enter_hospital_time"),
    LEAVE_HOSPITAL_TIME("leave_hospital_time"),
    VILLAGE_OR_MEDICAL_ASSURANCE("village_or_medical_assurance"),
    MEDICAL_ASSURANCE_CATEGORY("medical_assurance_category"),
    ONCE_MEDICAL_CHARGE("once_medical_charge"),
    BASIC_MEDICAL_ASSURANCE_BASELINE("basic_medical_assurance_baseline"),
    NOT_ALLOWED_CHARGE("not_allowed_charge"),
    BASE_MEDICAL_REIMBURSEMENT("base_medical_reimbursement"),
    BIG_DISEASE_REIMBURSEMENT("big_disease_reimbursement"),
    ONCE_ENTER_HOSPITAL_SUPPORT_CHARGE("once_enter_hospital_support_charge"),


    //5. 2014年11月城市低保备案表.XLS
    //INDEX("index"),
    //NAME("name"),
    //RELATIONSHIP("relationship"),
    //AGE("age"),
    //SEX("sex"),
    //IDENTITY("identity_id"),
    ASSURANCE_NUMBERS("assurance_numbers"),
    //APPLY_TIME("apply_time"),
    CLASS("class"),
    //ALLOWANCES_AMOUNT_PER_MONTH("allowances_amount_per_month"),
    FAMILY_MEMBER_CATEGORY("family_member_category"),
    TOTAL_PER_MONTY("total_per_monty"),
    GET_INDEX("get_index"),
    //OTHER("other"),
    PHONE_NUMBER("phone_number"),
    PHOTO("photo"),

    //6. （水沟镇）2015-2月份优抚花名表.xls
    //INDEX("index"),
    //NAME("name"),
    CATEGORY("category"),
    //ADDRESS("family_address"),
    BANK_ACCOUNT("bank_account"),
    //IDENTITY("identity_id"),
    SHOULD_PAY("should_pay"),
    OUTPATIENTS_ALLOWANCE("outpatients_allowance"),
    PAY_IN_FACT_THIS_MONTH("pay_in_fact_this_month"),
    //OTHER("other"),

    //7. 孤儿确认表（至2014年7-12月）.xls
    //INDEX("index"),
    //NAME("name"),
    //SEX("sex"),
    //IDENTITY("identity_id"),
    BIRTHDAY("birthday"),
    SUPPORT_FEE_BEGIN_TIME("support_fee_begin_time"),
    //CATEGORY("category"),
    HAVE_ALREADY_GET("have_already_get"),
    SHOULD_GET("should_get"),
    HAVE_ALREADY_PROVIDE("have_already_provide"),
    SPRING_FESTIVAL_FEE("spring_festival_fee"),
    TOTAL("total"),
    //OTHER("other"),

    OTHER("other");

    private final String value;

    Columns(String value) {
        this.value = value;
    }
}
