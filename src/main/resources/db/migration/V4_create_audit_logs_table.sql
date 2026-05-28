CREATE TABLE audit_logs (
    id          BIGSERIAL PRIMARY KEY,
    user_email  VARCHAR(100),
    action      VARCHAR(100) NOT NULL,
    details     VARCHAR(500),
    ip_address  VARCHAR(45),
    user_agent  VARCHAR(500),
    success     BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at  TIMESTAMP    NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_audit_email      ON audit_logs(user_email);
CREATE INDEX idx_audit_created_at ON audit_logs(created_at);