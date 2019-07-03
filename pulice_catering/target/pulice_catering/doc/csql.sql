create table Account_status
(
   asid                 int not null auto_increment,
   name                 varchar(20),
   primary key (asid)
);

create table Acquisition_Methods
(
   id                   int not null auto_increment,
   sid                  int,
   picture              varchar(20),
   piid                 int,
   business_hours       varchar(20),
   phone                varchar(20),
   email                varchar(20),
   site                 varchar(20),
   QR_code              varchar(20),
   Acquisition_Methods  varchar(20),
   primary key (id)
);

create table Closing_the_list
(
   id                   int not null auto_increment,
   this_time            varchar(20),
   last_time            varchar(20),
   number               varchar(20),
   connect              varchar(20),
   reception            varchar(20),
   remark               varchar(20),
   primary key (id)
);

create table Cost_of_ingredients
(
   id                   int not null,
   sid                  int,
   starting_time        varchar(20),
   deadline             varchar(20),
   rmiid                int,
   cost                 double,
   primary key (id)
);

create table Food_list
(
   flid                 int not null auto_increment,
   picture              varchar(20),
   name                 varchar(20),
   fcid                 int,
   rmiid                int,
   quantity             double,
   unit                 varchar(20),
   producer             varchar(20),
   phone                varchar(20),
   unit_price           double,
   remark               varchar(20),
   time                 varchar(20),
   primary key (flid)
);

create table Information_desk
(
   ldid                 int not null,
   number               varchar(20),
   name                 varchar(20),
   capacity             varchar(20),
   type                 varchar(20),
   location             varchar(20),
   sotid                int,
   primary key (ldid)
);

create table Inventory_management
(
   id                   int not null auto_increment,
   sid                  int,
   data                 varchar(20),
   rmiid                int,
   kid                  int,
   model                varchar(20),
   uid                  int,
   Current_Inventory    varchar(20),
   physical_inventory   varchar(20),
   primary key (id)
);

create table Prepaid_phone_list
(
   id                   int not null auto_increment,
   account_number       varchar(20),
   hid                  int,
   piid                 int,
   phone                varchar(20),
   email                varchar(20),
   site                 varchar(20),
   money                double,
   time                 varchar(20),
   expire               varchar(20),
   asid                 int,
   remark               varchar(20),
   primary key (id)
);

create table Purchase_audit
(
   id                   int not null auto_increment,
   serial_number        int,
   time                 varchar(20),
   rmiid                int,
   kid                  int,
   model                varchar(20),
   quantity             double,
   uid                  int,
   total_prices         double,
   way                  varchar(20),
   remark               varchar(20),
   primary key (id)
);

create table Queue_set
(
   id                   int not null auto_increment,
   type                 varchar(20),
   capacity             varchar(20),
   remark               varchar(20),
   update_data          varchar(20),
   primary key (id)
);

create table Raw_material_information
(
   rmiid                int not null auto_increment,
   name                 varchar(20),
   picture              varchar(20),
   kid                  int,
   model                varchar(20),
   unit_price           double,
   uid                  int,
   remark               varchar(20),
   primary key (rmiid)
);

create table Reserve_tables_list
(
   id                   int not null auto_increment,
   number               varchar(20),
   name                 varchar(20),
   people               int,
   reserved             varchar(20),
   order_date           varchar(20),
   scheduled_time       varchar(20),
   qsid                 int,
   remark               varchar(20),
   primary key (id)
);

create table State_of_tables
(
   sotid                int not null auto_increment,
   name                 varchar(20),
   primary key (sotid)
);

create table Stocktaking_manage
(
   id                   int not null auto_increment,
   sid                  int,
   rmiid                int,
   kid                  int,
   model                varchar(20),
   uid                  int,
   Current_Inventory    varchar(20),
   physical_inventory   varchar(20),
   primary key (id)
);

create temporary table Stores_information
(
   sid                  int not null,
   shop_name            varchar(20),
   picture              varchar(20),
   manager              int,
   business_hours       varchar(20),
   phone                varchar(20),
   email                varchar(20),
   shop_site            varchar(20),
   QR_code              varchar(20),
   update_data          varchar(20),
   primary key (sid)
);

create table TangKou_information
(
   id                   int not null auto_increment,
   name                 varchar(20),
   category             varchar(20),
   printer              varchar(20),
   executive_chef       varchar(20),
   remarks              varchar(20),
   primary key (id)
);

create table Temporary_inventory
(
   id                   int not null auto_increment,
   sid                  int,
   rmiid                int,
   kid                  int,
   model                varchar(20),
   unit_price           double,
   uid                  int,
   quantity             double,
   primary key (id)
);

create table asset_information
(
   id                   int not null auto_increment,
   raw_material         varchar(20),
   kind                 varchar(20),
   specification        varchar(20),
   inventory            double,
   consume              double,
   unit                 varchar(20),
   suggest              varchar(20),
   primary key (id)
);

create table connect_message
(
   id                   int not null auto_increment,
   time                 varchar(20),
   way                  varchar(20),
   gathering            double,
   practical_gathering  double,
   heir                 varchar(20),
   accepter             varchar(20),
   Handover_date        varchar(20),
   primary key (id)
);

create table discount_coupon
(
   dcid                 int not null auto_increment,
   name                 varchar(20),
   code                 varchar(20),
   money                double,
   conditionc		varchar(20),
   start_time           varchar(20),
   end_time             varchar(20),
   remark               varchar(20),
   scope                varchar(20),
   primary key (dcid)
);

create table discount_coupon_record
(
   id                   int not null auto_increment,
   hid                  int,
   dcid                 int,
   form                 varchar(20),
   quantity             double,
   minimum              varchar(20),
   maximum              varchar(20),
   time                 varchar(20),
   primary key (id)
);

create table expenditure
(
   id                   int not null auto_increment,
   name                 varchar(20),
   money                double,
   remark               varchar(20),
   primary key (id)
);

create table food_category
(
   fcid                 int not null auto_increment,
   name                 varchar(20),
   primary key (fcid)
);

create table headquarters
(
   hid                  int not null auto_increment,
   name                 varchar(20),
   manager              int,
   picture              varchar(20),
   business_hours       varchar(20),
   site                 varchar(20),
   QR_code              varchar(20),
   Administrator        int,
   uptate_data          varchar(20),
   primary key (hid)
);

create table income
(
   id                   int not null auto_increment,
   name                 varchar(20),
   money                double,
   remark               varchar(20),
   primary key (id)
);

create table kind
(
   kid                  int not null auto_increment,
   name                 varchar(20),
   primary key (kid)
);

create table marketing_plan
(
   id                   int not null auto_increment,
   time_frame           varchar(20),
   shop                 int,
   cuisine              int,
   category             int,
   afternoon_session    double,
   lateness_session     double,
   festival_afternoon_session double,
   festival_lateness_session double,
   primary key (id)
);

create table member_management
(
   id                   int not null auto_increment,
   head_portrait        varchar(20),
   name                 varchar(20),
   sex                  varchar(20),
   birthday             varchar(20),
   number               varchar(20),
   site                 varchar(20),
   balance              double,
   class                varchar(20),
   remark               varchar(20),
   primary key (id)
);

create table menu_management
(
   mmid                 int not null auto_increment,
   flid                 int,
   picture              varchar(20),
   sid                  int,
   remark               varchar(20),
   creation_time        varchar(20),
   primary key (mmid)
);

create table menu_statistics
(
   id                   int not null auto_increment,
   sid                  int,
   mmid                 int,
   time                 double,
   primary key (id)
);

create table order_management
(
   id                   int not null auto_increment,
   order_reference      varchar(20),
   ldid                 int,
   name                 varchar(20),
   cell_phone_number    char(20),
   greens_name          varchar(20),
   unit_price           double,
   unit                 varchar(20),
   quantity             double,
   prices               double,
   discount_coupon      double,
   time                 varchar(20),
   osid                 int,
   remark               varchar(20),
   primary key (id)
);

create table order_status
(
   osid                 int not null auto_increment,
   name                 varchar(20),
   primary key (osid)
);

create table other_expenses
(
   id                   int not null auto_increment,
   sid                  int,
   starting_time        varchar(20),
   deadline             varchar(20),
   rmiid                int,
   cost                 varchar(20),
   primary key (id)
);

create table personal_information
(
   piid                 int not null auto_increment,
   company              varchar(20),
   department           varchar(20),
   hid                  int,
   sid                  int,
   name                 varchar(20),
   username             varchar(20),
   psd                  varchar(20),
   email                varchar(20),
   phone                varchar(20),
   remark               varchar(20),
   user                 varchar(20),
   role                 varchar(20),
   last_time            varchar(20),
   primary key (piid)
);

create table procurement_plan
(
   id                   int not null auto_increment,
   time                 varchar(20),
   rmiid                int,
   kid                  int,
   unit_price           double,
   uid                  int,
   inventory            double,
   suggest              double,
   plan                 double,
   primary key (id)
);

create table promotion
(
   id                   int not null auto_increment,
   name                 varchar(20),
   class                varchar(20),
   primary key (id)
);

create table purchase_note
(
   id                   int not null auto_increment,
   state                int,
   serial_number        varchar(20),
   data                 varchar(20),
   rmiid                int,
   kid                  int,
   model                varchar(20),
   quantity             double,
   uid                  int,
   total_prices         double,
   way                  varchar(20),
   remark               varchar(20),
   primary key (id)
);

create table queue_state
(
   qsid                 int not null auto_increment,
   name                 varchar(20),
   primary key (qsid)
);

create table queuing_management
(
   id                   int not null auto_increment,
   queue_type           int,
   number               varchar(20),
   name                 varchar(20),
   people               int,
   capacity             varchar(20),
   Desk_type            int,
   data                 varchar(20),
   await_number         int,
   latency_time         varchar(20),
   qsid                 int,
   remark               varchar(20),
   primary key (id)
);

create table receipts_message
(
   id                   int not null auto_increment,
   serial_number        varchar(20),
   money                double,
   category             varchar(20),
   remark               varchar(20),
   primary key (id)
);

create table role
(
   id                   int not null auto_increment,
   name                 varchar(20),
   department           int,
   primary key (id)
);

create table stock_management
(
   id                   int not null auto_increment,
   odd                  varchar(20),
   data                 varchar(20),
   rmiid                int,
   kid                  int,
   uni_uid              int,
   model                varchar(20),
   unit_price           double,
   unit                 int,
   uid                  double,
   total_prices         double,
   remark               varchar(20),
   primary key (id)
);

create table take_out
(
   id                   int not null auto_increment,
   order_reference      varchar(20),
   name                 varchar(20),
   cell_phone_number    varchar(20),
   greens_name          varchar(20),
   unit_price           double,
   unit                 varchar(20),
   quantity             double,
   prices               double,
   discount_coupon      double,
   time                 varchar(20),
   osid                 int,
   site                 varchar(20),
   remark               varchar(20),
   primary key (id)
);

create table unit
(
   uid                  int not null auto_increment,
   name                 varchar(20),
   primary key (uid)
);