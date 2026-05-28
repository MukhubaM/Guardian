CREATE TABLE otp_tokens (
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(6)   NOT NULL,
    email       VARCHAR(100) NOT NULL,
    otp_type    VARCHAR(30)  NOT NULL,
    expires_at  TIMESTAMP    NOT NULL,
    used        BOOLEAN      NOT NULL DEFAULT FALSE,
    attempts    INT          NOT NULL DEFAULT 0,
    created_at  TIMESTAMP    NOT NULL DEFAULT NOW()
);