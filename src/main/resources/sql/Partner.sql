-- ============================
-- PARTNER（取引相手）
-- ============================
CREATE TABLE partner (
    transaction_id BIGSERIAL PRIMARY KEY,
    nickname VARCHAR(255),
    url VARCHAR(500),
    postal_code VARCHAR(20),
    address VARCHAR(255),
    partner_name VARCHAR(255),
    partner_phone VARCHAR(50),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
