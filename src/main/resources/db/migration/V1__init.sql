CREATE TABLE category
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at VARCHAR(255) NULL,
    title      VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jt_instructor
(
    id                BIGINT NOT NULL,
    it_specialisation VARCHAR(255) NULL,
    CONSTRAINT pk_jt_instructor PRIMARY KEY (id)
);

CREATE TABLE jt_mentor
(
    id               BIGINT NOT NULL,
    mentor_comp_name VARCHAR(255) NULL,
    mentor_avg_rating DOUBLE NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (id)
);

CREATE TABLE jt_ta
(
    id            BIGINT NOT NULL,
    ta_no_session INT NULL,
    ta_avg_rating DOUBLE NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (id)
);

CREATE TABLE jt_user
(
    id           BIGINT NOT NULL,
    usr_name     VARCHAR(255) NULL,
    usr_email    VARCHAR(255) NULL,
    usr_password VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE mps_instructor
(
    id                BIGINT NOT NULL,
    usr_name          VARCHAR(255) NULL,
    usr_email         VARCHAR(255) NULL,
    usr_password      VARCHAR(255) NULL,
    it_specialisation VARCHAR(255) NULL,
    CONSTRAINT pk_mps_instructor PRIMARY KEY (id)
);

CREATE TABLE mps_mentor
(
    id               BIGINT NOT NULL,
    usr_name         VARCHAR(255) NULL,
    usr_email        VARCHAR(255) NULL,
    usr_password     VARCHAR(255) NULL,
    mentor_comp_name VARCHAR(255) NULL,
    mentor_avg_rating DOUBLE NULL,
    CONSTRAINT pk_mps_mentor PRIMARY KEY (id)
);

CREATE TABLE mps_ta
(
    id            BIGINT NOT NULL,
    usr_name      VARCHAR(255) NULL,
    usr_email     VARCHAR(255) NULL,
    usr_password  VARCHAR(255) NULL,
    ta_no_session INT NULL,
    ta_avg_rating DOUBLE NULL,
    CONSTRAINT pk_mps_ta PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    VARCHAR(255) NULL,
    title         VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    category_id   BIGINT NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE st_user
(
    id                BIGINT NOT NULL,
    user_type         INT NULL,
    usr_name          VARCHAR(255) NULL,
    usr_email         VARCHAR(255) NULL,
    usr_password      VARCHAR(255) NULL,
    ta_no_session     INT NULL,
    ta_avg_rating DOUBLE NULL,
    it_specialisation VARCHAR(255) NULL,
    mentor_comp_name  VARCHAR(255) NULL,
    mentor_avg_rating DOUBLE NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id                BIGINT NOT NULL,
    usr_name          VARCHAR(255) NULL,
    usr_email         VARCHAR(255) NULL,
    usr_password      VARCHAR(255) NULL,
    it_specialisation VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id               BIGINT NOT NULL,
    usr_name         VARCHAR(255) NULL,
    usr_email        VARCHAR(255) NULL,
    usr_password     VARCHAR(255) NULL,
    mentor_comp_name VARCHAR(255) NULL,
    mentor_avg_rating DOUBLE NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id            BIGINT NOT NULL,
    usr_name      VARCHAR(255) NULL,
    usr_email     VARCHAR(255) NULL,
    usr_password  VARCHAR(255) NULL,
    ta_no_session INT NULL,
    ta_avg_rating DOUBLE NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id           BIGINT NOT NULL,
    usr_name     VARCHAR(255) NULL,
    usr_email    VARCHAR(255) NULL,
    usr_password VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE jt_instructor
    ADD CONSTRAINT FK_JT_INSTRUCTOR_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_ID FOREIGN KEY (id) REFERENCES jt_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);