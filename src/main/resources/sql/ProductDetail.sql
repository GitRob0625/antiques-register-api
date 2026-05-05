-- ============================
-- PRODUCT_DETAIL（商品詳細）
-- ============================
CREATE TABLE product_detail (
    product_id SERIAL PRIMARY KEY,
    purchase_id INT,
    sales_id INT,
    item_name VARCHAR(255),
    features TEXT,
    quantity SMALLINT,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (purchase_id) REFERENCES purchase_history(purchase_id),
    FOREIGN KEY (sales_id) REFERENCES sales_history(sales_id)
);
