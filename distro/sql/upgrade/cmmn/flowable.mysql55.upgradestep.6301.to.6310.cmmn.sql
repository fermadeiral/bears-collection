
CREATE TABLE ACT_CMMN_HI_PLAN_ITEM_INST (ID_ VARCHAR(255) NOT NULL, REV_ INT NOT NULL, NAME_ VARCHAR(255) NULL, STATE_ VARCHAR(255) NULL, CASE_DEF_ID_ VARCHAR(255) NULL, CASE_INST_ID_ VARCHAR(255) NULL, STAGE_INST_ID_ VARCHAR(255) NULL, IS_STAGE_ BIT(1) NULL, ELEMENT_ID_ VARCHAR(255) NULL, ITEM_DEFINITION_ID_ VARCHAR(255) NULL, ITEM_DEFINITION_TYPE_ VARCHAR(255) NULL, CREATED_TIME_ datetime NULL, LAST_AVAILABLE_TIME_ datetime NULL, LAST_ENABLED_TIME_ datetime NULL, LAST_DISABLED_TIME_ datetime NULL, LAST_STARTED_TIME_ datetime NULL, LAST_SUSPENDED_TIME_ datetime NULL, COMPLETED_TIME_ datetime NULL, OCCURRED_TIME_ datetime NULL, TERMINATED_TIME_ datetime NULL, EXIT_TIME_ datetime NULL, ENDED_TIME_ datetime NULL, LAST_UPDATED_TIME_ datetime NULL, START_USER_ID_ VARCHAR(255) NULL, REFERENCE_ID_ VARCHAR(255) NULL, REFERENCE_TYPE_ VARCHAR(255) NULL, TENANT_ID_ VARCHAR(255) DEFAULT '' NULL, CONSTRAINT PK_ACT_CMMN_HI_PLAN_ITEM_INST PRIMARY KEY (ID_));

ALTER TABLE ACT_CMMN_RU_MIL_INST ADD TENANT_ID_ VARCHAR(255) DEFAULT '' NULL;

ALTER TABLE ACT_CMMN_HI_MIL_INST ADD TENANT_ID_ VARCHAR(255) DEFAULT '' NULL;

INSERT INTO ACT_CMMN_DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('4', 'flowable', 'changelog-xml/cmmn/6310.xml', NOW(), 7, '8:e40d29cb79345b7fb5afd38a7f0ba8fc', 'createTable tableName=ACT_CMMN_HI_PLAN_ITEM_INST; addColumn tableName=ACT_CMMN_RU_MIL_INST; addColumn tableName=ACT_CMMN_HI_MIL_INST', '', 'EXECUTED', NULL, NULL, '3.6.1', '6984986790');

