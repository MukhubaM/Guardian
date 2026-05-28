CREATE TABLE users (
    id                  BIGSERIAL PRIMARY KEY,
    username            VARCHAR(50)  NOT NULL UNIQUE,
    email               VARCHAR(100) NOT NULL UNIQUE,
    password            VARCHAR(255) NOT NULL,
    first_name          VARCHAR(50),
    last_name           VARCHAR(50),
    phone               VARCHAR(20),
    profile_picture     VARCHAR(255),
    role                VARCHAR(20)  NOT NULL DEFAULT 'USER',
    enabled             BOOLEAN      NOT NULL DEFAULT FALSE,
    account_non_locked  BOOLEAN      NOT NULL DEFAULT TRUE,
    failed_login_attempts INT        NOT NULL DEFAULT 0,
    lock_time           TIMESTAMP,
    email_verified      BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at          TIMESTAMP,
    updated_at          TIMESTAMP
);

CREATE INDEX idx_users_email    ON users(email);
CREATE INDEX idx_users_username ON users(username);