--Execute after logging into user gambit--
CREATE TABLE SKILLTYPE(
    SKILLTYPE_ID NUMBER PRIMARY KEY,
    IS_ACTIVE NUMBER NOT NULL,
    IS_CORE NUMBER NOT NULL,
    SKILLTYPE_DESC VARCHAR2(200 CHAR),
    SKILLTYPE_NAME VARCHAR2(32 CHAR) UNIQUE NOT NULL

);

CREATE TABLE SKILL(
    SKILL_ID NUMBER PRIMARY KEY,
    IS_ACTIVE NUMBER NOT NULL,
    SKILL_NAME VARCHAR2(32 CHAR) UNIQUE NOT NULL
);

CREATE TABLE SKILL_SKILLTYPE(
    SKILLTYPE_ID NUMBER,
    SKILL_ID  NUMBER,
    PRIMARY KEY (SKILLTYPE_ID, SKILL_ID),
    CONSTRAINT FK_SKILLTYPE FOREIGN KEY (SKILLTYPE_ID) REFERENCES SKILLTYPE(SKILLTYPE_ID),
    CONSTRAINT FK_SKILL FOREIGN KEY (SKILL_ID) REFERENCES SKILL(SKILL_ID)
);

CREATE TABLE BUCKET_DTO(
	BUCKET_ID NUMBER,
	PRIMARY KEY (BUCKET_ID)
);

CREATE TABLE SKILLTYPE_BUCKET_LOOKUP(
	SKILLTYPE_ID NUMBER,
	BUCKET_ID NUMBER,
	WEIGHT NUMBER,
	PRIMARY KEY (SKILLTYPE_ID, BUCKET_ID),
	CONSTRAINT FK_SKILLTYPEID FOREIGN KEY (SKILLTYPE_ID) REFERENCES SKILLTYPE(SKILLTYPE_ID),
	CONSTRAINT FK_BUCKET FOREIGN KEY (BUCKET_ID) REFERENCES BUCKET_DTO(BUCKET_ID)
);


CREATE SEQUENCE SKILLTYPE_ID_SEQ MINVALUE 1 INCREMENT BY 1 CACHE 10;
CREATE SEQUENCE SKILL_ID_SEQ MINVALUE 1 INCREMENT BY 1 CACHE 10;