
CREATE TABLE PUBLIC.DATABASECHANGELOG (ID VARCHAR(255) NOT NULL, AUTHOR VARCHAR(255) NOT NULL, FILENAME VARCHAR(255) NOT NULL, DATEEXECUTED TIMESTAMP NOT NULL, ORDEREXECUTED INT NOT NULL, EXECTYPE VARCHAR(10) NOT NULL, MD5SUM VARCHAR(35), DESCRIPTION VARCHAR(255), COMMENTS VARCHAR(255), TAG VARCHAR(255), LIQUIBASE VARCHAR(20), CONTEXTS VARCHAR(255), LABELS VARCHAR(255), DEPLOYMENT_ID VARCHAR(10));

CREATE TABLE PUBLIC.ACT_CMMN_RE_DEPLOYMENT (ID_ VARCHAR(255) NOT NULL, NAME_ VARCHAR(255), CATEGORY_ VARCHAR(255), DEPLOY_TIME_ TIMESTAMP, PARENT_DEPLOYMENT_ID_ VARCHAR(255), TENANT_ID_ VARCHAR(255), CONSTRAINT PK_ACT_CMMN_RE_DEPLOYMENT PRIMARY KEY (ID_));

CREATE TABLE PUBLIC.ACT_CMMN_RE_DEPLOYMENT_RESOURCE (ID_ VARCHAR(255) NOT NULL, NAME_ VARCHAR(255), DEPLOYMENT_ID_ VARCHAR(255), RESOURCE_BYTES_ BLOB, CONSTRAINT PK_ACT_CMMN_RE_DEPLOYMENT_RESOURCE PRIMARY KEY (ID_));

ALTER TABLE PUBLIC.ACT_CMMN_RE_DEPLOYMENT_RESOURCE ADD CONSTRAINT ACT_FK_CMMN_RSRC_DPL FOREIGN KEY (DEPLOYMENT_ID_) REFERENCES PUBLIC.ACT_CMMN_RE_DEPLOYMENT (ID_);

CREATE INDEX PUBLIC.ACT_IDX_CMMN_RSRC_DPL ON PUBLIC.ACT_CMMN_RE_DEPLOYMENT_RESOURCE(DEPLOYMENT_ID_);

CREATE TABLE PUBLIC.ACT_CMMN_RE_CASEDEF (ID_ VARCHAR(255) NOT NULL, REV_ INT NOT NULL, NAME_ VARCHAR(255), KEY_ VARCHAR(255) NOT NULL, VERSION_ VARCHAR(255) NOT NULL, CATEGORY_ VARCHAR(255), DEPLOYMENT_ID_ VARCHAR(255), RESOURCE_NAME_ VARCHAR(4000), DESCRIPTION_ VARCHAR(4000), HAS_GRAPHICAL_NOTATION_ BOOLEAN, TENANT_ID_ VARCHAR(255) DEFAULT '' NOT NULL, CONSTRAINT PK_ACT_CMMN_RE_CASEDEF PRIMARY KEY (ID_));

ALTER TABLE PUBLIC.ACT_CMMN_RE_CASEDEF ADD CONSTRAINT ACT_FK_CASE_DEF_DPLY FOREIGN KEY (DEPLOYMENT_ID_) REFERENCES PUBLIC.ACT_CMMN_RE_DEPLOYMENT (ID_);

CREATE INDEX PUBLIC.ACT_IDX_CASE_DEF_DPLY ON PUBLIC.ACT_CMMN_RE_CASEDEF(DEPLOYMENT_ID_);

CREATE TABLE PUBLIC.ACT_CMMN_RU_CASE_INST (ID_ VARCHAR(255) NOT NULL, REV_ INT NOT NULL, BUSINESS_KEY_ VARCHAR(255), NAME_ VARCHAR(255), PARENT_ID_ VARCHAR(255), CASE_DEF_ID_ VARCHAR(255), STATE_ VARCHAR(255), START_TIME_ TIMESTAMP, START_USER_ID_ VARCHAR(255), CALLBACK_ID_ VARCHAR(255), CALLBACK_TYPE_ VARCHAR(255), TENANT_ID_ VARCHAR(255) DEFAULT '', CONSTRAINT PK_ACT_CMMN_RU_CASE_INST PRIMARY KEY (ID_));

ALTER TABLE PUBLIC.ACT_CMMN_RU_CASE_INST ADD CONSTRAINT ACT_FK_CASE_INST_CASE_DEF FOREIGN KEY (CASE_DEF_ID_) REFERENCES PUBLIC.ACT_CMMN_RE_CASEDEF (ID_);

CREATE INDEX PUBLIC.ACT_IDX_CASE_INST_CASE_DEF ON PUBLIC.ACT_CMMN_RU_CASE_INST(CASE_DEF_ID_);

CREATE INDEX PUBLIC.ACT_IDX_CASE_INST_PARENT ON PUBLIC.ACT_CMMN_RU_CASE_INST(PARENT_ID_);

CREATE TABLE PUBLIC.ACT_CMMN_RU_PLAN_ITEM_INST (ID_ VARCHAR(255) NOT NULL, REV_ INT NOT NULL, CASE_DEF_ID_ VARCHAR(255), CASE_INST_ID_ VARCHAR(255), STAGE_INST_ID_ VARCHAR(255), IS_STAGE_ BOOLEAN, ELEMENT_ID_ VARCHAR(255), NAME_ VARCHAR(255), STATE_ VARCHAR(255), START_TIME_ TIMESTAMP, START_USER_ID_ VARCHAR(255), REFERENCE_ID_ VARCHAR(255), REFERENCE_TYPE_ VARCHAR(255), TENANT_ID_ VARCHAR(255) DEFAULT '', CONSTRAINT PK_ACT_CMMN_RU_PLAN_ITEM_INST PRIMARY KEY (ID_));

ALTER TABLE PUBLIC.ACT_CMMN_RU_PLAN_ITEM_INST ADD CONSTRAINT ACT_FK_PLAN_ITEM_CASE_DEF FOREIGN KEY (CASE_DEF_ID_) REFERENCES PUBLIC.ACT_CMMN_RE_CASEDEF (ID_);

CREATE INDEX PUBLIC.ACT_IDX_PLAN_ITEM_CASE_DEF ON PUBLIC.ACT_CMMN_RU_PLAN_ITEM_INST(CASE_DEF_ID_);

ALTER TABLE PUBLIC.ACT_CMMN_RU_PLAN_ITEM_INST ADD CONSTRAINT ACT_FK_PLAN_ITEM_CASE_INST FOREIGN KEY (CASE_INST_ID_) REFERENCES PUBLIC.ACT_CMMN_RU_CASE_INST (ID_);

CREATE INDEX PUBLIC.ACT_IDX_PLAN_ITEM_CASE_INST ON PUBLIC.ACT_CMMN_RU_PLAN_ITEM_INST(CASE_INST_ID_);

CREATE TABLE PUBLIC.ACT_CMMN_RU_SENTRY_ON_PART_INST (ID_ VARCHAR(255) NOT NULL, REV_ INT NOT NULL, CASE_DEF_ID_ VARCHAR(255), CASE_INST_ID_ VARCHAR(255), PLAN_ITEM_INST_ID_ VARCHAR(255), ON_PART_ID_ VARCHAR(255), TIME_STAMP_ TIMESTAMP, CONSTRAINT PK_ACT_CMMN_RU_SENTRY_ON_PART_INST PRIMARY KEY (ID_));

ALTER TABLE PUBLIC.ACT_CMMN_RU_SENTRY_ON_PART_INST ADD CONSTRAINT ACT_FK_SENTRY_CASE_DEF FOREIGN KEY (CASE_DEF_ID_) REFERENCES PUBLIC.ACT_CMMN_RE_CASEDEF (ID_);

CREATE INDEX PUBLIC.ACT_IDX_SENTRY_CASE_DEF ON PUBLIC.ACT_CMMN_RU_SENTRY_ON_PART_INST(CASE_DEF_ID_);

ALTER TABLE PUBLIC.ACT_CMMN_RU_SENTRY_ON_PART_INST ADD CONSTRAINT ACT_FK_SENTRY_CASE_INST FOREIGN KEY (CASE_INST_ID_) REFERENCES PUBLIC.ACT_CMMN_RU_CASE_INST (ID_);

CREATE INDEX PUBLIC.ACT_IDX_SENTRY_CASE_INST ON PUBLIC.ACT_CMMN_RU_SENTRY_ON_PART_INST(CASE_INST_ID_);

ALTER TABLE PUBLIC.ACT_CMMN_RU_SENTRY_ON_PART_INST ADD CONSTRAINT ACT_FK_SENTRY_PLAN_ITEM FOREIGN KEY (PLAN_ITEM_INST_ID_) REFERENCES PUBLIC.ACT_CMMN_RU_PLAN_ITEM_INST (ID_);

CREATE INDEX PUBLIC.ACT_IDX_SENTRY_PLAN_ITEM ON PUBLIC.ACT_CMMN_RU_SENTRY_ON_PART_INST(PLAN_ITEM_INST_ID_);

CREATE TABLE PUBLIC.ACT_CMMN_RU_MIL_INST (ID_ VARCHAR(255) NOT NULL, NAME_ VARCHAR(255) NOT NULL, TIME_STAMP_ TIMESTAMP NOT NULL, CASE_INST_ID_ VARCHAR(255) NOT NULL, CASE_DEF_ID_ VARCHAR(255) NOT NULL, ELEMENT_ID_ VARCHAR(255) NOT NULL, CONSTRAINT PK_ACT_CMMN_RU_MIL_INST PRIMARY KEY (ID_));

ALTER TABLE PUBLIC.ACT_CMMN_RU_MIL_INST ADD CONSTRAINT ACT_FK_MIL_CASE_DEF FOREIGN KEY (CASE_DEF_ID_) REFERENCES PUBLIC.ACT_CMMN_RE_CASEDEF (ID_);

CREATE INDEX PUBLIC.ACT_IDX_MIL_CASE_DEF ON PUBLIC.ACT_CMMN_RU_MIL_INST(CASE_DEF_ID_);

ALTER TABLE PUBLIC.ACT_CMMN_RU_MIL_INST ADD CONSTRAINT ACT_FK_MIL_CASE_INST FOREIGN KEY (CASE_INST_ID_) REFERENCES PUBLIC.ACT_CMMN_RU_CASE_INST (ID_);

CREATE INDEX PUBLIC.ACT_IDX_MIL_CASE_INST ON PUBLIC.ACT_CMMN_RU_MIL_INST(CASE_INST_ID_);

CREATE TABLE PUBLIC.ACT_CMMN_HI_CASE_INST (ID_ VARCHAR(255) NOT NULL, REV_ INT NOT NULL, BUSINESS_KEY_ VARCHAR(255), NAME_ VARCHAR(255), PARENT_ID_ VARCHAR(255), CASE_DEF_ID_ VARCHAR(255), STATE_ VARCHAR(255), START_TIME_ TIMESTAMP, END_TIME_ TIMESTAMP, START_USER_ID_ VARCHAR(255), CALLBACK_ID_ VARCHAR(255), CALLBACK_TYPE_ VARCHAR(255), TENANT_ID_ VARCHAR(255) DEFAULT '', CONSTRAINT PK_ACT_CMMN_HI_CASE_INST PRIMARY KEY (ID_));

CREATE TABLE PUBLIC.ACT_CMMN_HI_MIL_INST (ID_ VARCHAR(255) NOT NULL, REV_ INT NOT NULL, NAME_ VARCHAR(255) NOT NULL, TIME_STAMP_ TIMESTAMP NOT NULL, CASE_INST_ID_ VARCHAR(255) NOT NULL, CASE_DEF_ID_ VARCHAR(255) NOT NULL, ELEMENT_ID_ VARCHAR(255) NOT NULL, CONSTRAINT PK_ACT_CMMN_HI_MIL_INST PRIMARY KEY (ID_));

INSERT INTO PUBLIC.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1', 'flowable', 'org/flowable/cmmn/db/liquibase/flowable-cmmn-db-changelog.xml', NOW, 1, '7:28e5931d36abab0185c189c584a7c2d0', 'createTable tableName=ACT_CMMN_RE_DEPLOYMENT; createTable tableName=ACT_CMMN_RE_DEPLOYMENT_RESOURCE; addForeignKeyConstraint baseTableName=ACT_CMMN_RE_DEPLOYMENT_RESOURCE, constraintName=ACT_FK_CMMN_RSRC_DPL, referencedTableName=ACT_CMMN_RE_DEPLOY...', '', 'EXECUTED', NULL, NULL, '3.5.3', '4471205090');

