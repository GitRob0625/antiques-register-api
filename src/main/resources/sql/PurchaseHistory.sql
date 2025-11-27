-- ============================
-- PURCHASE_HISTORY（購入履歴）
-- ============================
CREATE TABLE purchase_history (
    purchase_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    transaction_id INT NOT NULL,
    store_id SMALLINT NOT NULL,
    product_name VARCHAR(255),
    price NUMERIC(10,2),
    discount NUMERIC(10,2),
    purchase_date TIMESTAMP,
    order_number VARCHAR(255),
    verify_id SMALLINT,
    category_id SMALLINT,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (transaction_id) REFERENCES partner(transaction_id),
    FOREIGN KEY (store_id) REFERENCES store_master(store_id),
    FOREIGN KEY (verify_id) REFERENCES verify_master(verify_id),
    FOREIGN KEY (category_id) REFERENCES category_master(category_id)
);
