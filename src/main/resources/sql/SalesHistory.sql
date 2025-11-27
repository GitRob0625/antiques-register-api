-- ============================
-- SALES_HISTORY（販売履歴）
-- ============================
CREATE TABLE sales_history (
    sales_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    transaction_id INT NOT NULL,
    store_id SMALLINT NOT NULL,
    product_name VARCHAR(255),
    price NUMERIC(10,2),
    shipping NUMERIC(10,2),
    fee NUMERIC(10,2),
    sales_date TIMESTAMP,
    order_number VARCHAR(255),
    category_id SMALLINT,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (transaction_id) REFERENCES partner(transaction_id),
    FOREIGN KEY (store_id) REFERENCES store_master(store_id),
    FOREIGN KEY (category_id) REFERENCES category_master(category_id)
);
