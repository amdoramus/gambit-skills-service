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



INSERT INTO SKILLTYPE VALUES (SKILLTYPE_ID_SEQ.NEXTVAL, 1, 1, 'Java/Microservices Description', 'Java/Microservices');
INSERT INTO SKILLTYPE VALUES (SKILLTYPE_ID_SEQ.NEXTVAL,  1, 1, 'JTA Description', 'JTA');
INSERT INTO SKILLTYPE VALUES (SKILLTYPE_ID_SEQ.NEXTVAL, 1, 1, 'PEGA Description', 'PEGA');
INSERT INTO SKILLTYPE VALUES (SKILLTYPE_ID_SEQ.NEXTVAL, 1, 1, '.NET Description', '.NET');
INSERT INTO SKILLTYPE VALUES (SKILLTYPE_ID_SEQ.NEXTVAL, 1, 1, 'Dynamics Description', 'Dynamics');
INSERT INTO SKILLTYPE VALUES (SKILLTYPE_ID_SEQ.NEXTVAL, 1, 1, 'Business Analyst Description', 'Business Analyst');
INSERT INTO SKILLTYPE VALUES (SKILLTYPE_ID_SEQ.NEXTVAL, 0, 1, 'JavaScript Web Developer Description. Not active, is core', 'JavaScript Web Developer');
INSERT INTO SKILLTYPE VALUES (SKILLTYPE_ID_SEQ.NEXTVAL, 1, 0, 'DBA Description. Is active, not core', 'DBA');
INSERT INTO SKILLTYPE VALUES (SKILLTYPE_ID_SEQ.NEXTVAL, 0, 0, 'Fortran Description. Not active, not core', 'Fortran');

INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Visual Basic');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'F#');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'C++');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Dynamics');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Sales');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Economics');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 0, 'Fortran');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Java');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'JavaScript');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'PL/SQL');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'MySQL');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'PostgreSQL');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'NoSQL');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'MongoDB');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'H2');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'HTML');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'CSS');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'TypeScript');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Angular');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Hibernate');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Servlets');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'JSP');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Spring');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Microservices');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'REST');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'SOAP');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'DevOps');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Git');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'C#');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'ASP.NET');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Azure');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'AJAX');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'JSON');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'JUnit');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'JDBC');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Selenium');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Cucumber');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Karma');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Agile');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'Scrum');
INSERT INTO SKILL VALUES (SKILL_ID_SEQ.NEXTVAL, 1, 'PEGA');

INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Java'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Spring'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'JUnit'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Hibernate'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'HTML'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'JavaScript'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'CSS'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Angular'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'PL/SQL'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Microservices'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Scrum'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Agile'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'DevOps'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'TypeScript'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'JDBC'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Git'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'AJAX'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'JSON'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Servlets'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'REST'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Java/Microservices'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'SOAP'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JTA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Java'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JTA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'JUnit'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JTA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Selenium'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JTA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Cucumber'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JTA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'PL/SQL'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JTA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Karma'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JTA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Agile'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JTA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Scrum'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JTA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Git'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'PEGA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Java'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'PEGA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'PEGA'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'PEGA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'PL/SQL'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'PEGA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'JavaScript'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'PEGA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'HTML'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'PEGA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'CSS'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = '.NET'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'C#'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = '.NET'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'F#'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = '.NET'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Azure'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = '.NET'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'ASP.NET'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = '.NET'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'DevOps'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = '.NET'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Agile'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = '.NET'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Scrum'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = '.NET'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'SOAP'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = '.NET'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'REST'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Dynamics'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'REST'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Dynamics'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'SOAP'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Dynamics'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Azure'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Dynamics'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'C#'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Dynamics'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Agile'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Dynamics'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Scrum'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Dynamics'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Sales'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Business Analyst'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Economics'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Business Analyst'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Sales'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Business Analyst'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Java'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JavaScript Web Developer'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'JavaScript'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JavaScript Web Developer'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Angular'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JavaScript Web Developer'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'HTML'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JavaScript Web Developer'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'CSS'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JavaScript Web Developer'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'AJAX'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JavaScript Web Developer'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'REST'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JavaScript Web Developer'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'SOAP'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JavaScript Web Developer'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'MongoDB'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JavaScript Web Developer'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Karma'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'JavaScript Web Developer'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Git'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'DBA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'MySQL'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'DBA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'PL/SQL'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'DBA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'MongoDB'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'DBA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'PostgreSQL'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'DBA'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'NoSQL'));
INSERT INTO SKILL_SKILLTYPE VALUES ((SELECT SKILLTYPE_ID FROM SKILLTYPE WHERE SKILLTYPE_NAME = 'Fortran'),
    (SELECT SKILL_ID FROM SKILL WHERE SKILL_NAME = 'Fortran'));
    
INSERT INTO BUCKET_DTO VALUES (1);
INSERT INTO BUCKET_DTO VALUES (2);
INSERT INTO BUCKET_DTO VALUES (3);
INSERT INTO BUCKET_DTO VALUES (4);
INSERT INTO BUCKET_DTO VALUES (5);
INSERT INTO BUCKET_DTO VALUES (6);
INSERT INTO BUCKET_DTO VALUES (7);
INSERT INTO BUCKET_DTO VALUES (8);