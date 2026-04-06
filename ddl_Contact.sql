CREATE TABLE contacts
(
    id         BIGINT AUTO_INCREMENT     NOT NULL,
    name       VARCHAR(255)              NOT NULL,
    email      VARCHAR(255)              NOT NULL,
    user_type  VARCHAR(50)               NOT NULL,
    subject    VARCHAR(255)              NOT NULL,
    message    LONGTEXT                  NOT NULL,
    status     VARCHAR(50) DEFAULT 'NEW' NOT NULL,
    created_at datetime                  NOT NULL,
    created_by VARCHAR(50)               NOT NULL,
    updated_at datetime                  NULL,
    CONSTRAINT pk_contacts PRIMARY KEY (id)
);

ALTER TABLE contacts
    ADD CONSTRAINT uc_contacts_name UNIQUE (name);