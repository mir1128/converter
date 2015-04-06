create table if not exists temp_support_applying
(
  ind int,
  name varchar(40),
  age int,
  identity_id varchar(20) not null,
  family_address varchar(100),
  home_background varchar(100),
  village_amount varchar(15),
  allowances_amount varchar(15),
  town_amount varchar(15),
  other varchar(100),
  primary key (identity_id)
);


create table if not exists village_allowance_bak
(
  ind int,
  allowance_id varchar(20),
  relationship varchar(10),
  family_name varchar(10),
  sex varchar(5),
  identity_id varchar(20),
  age int,
  allowance_create_time varchar(20),
  allowances_amount_per_month varchar(10),
  family_member_category_amount varchar(10),
  electric_charge_allowance varchar(10),
  family_allowance_amount varchar(10),
  family_address varchar(20),
  other varchar(100),
  reason varchar(100),
  primary key (identity_id)
);


create table if not exists village_5allowance_register
(
  ind int,
  five_allowance_id varchar(15),
  name varchar(10),
  sex varchar(5),
  nation varchar(15),
  identity_id varchar(20),
  family_address varchar(20),
  support_form varchar(20),
  apply_time varchar(20),
  other varchar(20),
  primary key (identity_id)
);

create table if not exists medical_assistance_register
(
  ind int,
  name varchar(10),
  sex varchar(10),
  age int,
  identity_id varchar(20),
  family_address varchar(20),
  disease varchar(20),
  hospital varchar(20),
  enter_hospital_time varchar(20),
  leave_hospital_time varchar(20),
  village_or_medical_assurance varchar(20),
  medical_assurance_category varchar(20),
  once_medical_charge varchar(20),
  basic_medical_assurance_baseline varchar(20),
  not_allowed_charge varchar(20),
  base_medical_reimbursement varchar(20),
  big_disease_reimbursement varchar(20),
  once_enter_hospital_support_charge varchar(20),
  primary key (identity_id)
);

create table if not exists city_allowance_register
(
  ind int,
  name varchar(20),
  relationship varchar(20),
  age int,
  sex varchar(5),
  identity_id varchar(20),
  assurance_numbers varchar(20),
  apply_time varchar(20),
  class varchar(20),
  allowances_amount_per_month varchar(20),
  family_member_category varchar(20),
  total_per_monty varchar(20),
  get_index varchar(20),
  other varchar(20),
  phone_number varchar(20),
  photo varchar(20),
  primary key (identity_id)
);


create table if not exists special_care_register_1
(
  ind int,
  name varchar(10),
  category varchar(10),
  family_address varchar(20),
  bank_account varchar(20),
  identity_id varchar(20),
  should_pay varchar(20),
  outpatients_allowance varchar(20),
  pay_in_fact_this_month varchar(20),
  other varchar(20),
  primary key (identity_id)
);

create table if not exists special_care_register_2
(
  ind int,
  name varchar(10),
  family_address varchar(40),
  bank_account varchar(20),
  identity_id varchar(20),
  service_years int,
  allowances_amount_per_month varchar(20),
  allowances_inc varchar(20),
  pay_in_fact_this_month varchar(20),
  other varchar(100),
  primary key (identity_id)
);

create table if not exists orphan_register
(
  ind int,
  name varchar(10),
  sex varchar(10),
  identity_id varchar(20),
  birthday varchar(20),
  support_fee_begin_time varchar(20),
  category varchar(20),
  have_already_get varchar(20),
  should_get varchar(20),
  have_already_provide varchar(20),
  spring_festival_fee varchar(20),
  total varchar(20),
  other varchar(20),
  primary key (identity_id)
);

