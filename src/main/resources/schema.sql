CREATE TABLE fees
(
    id     INT PRIMARY KEY,
    amount DECIMAL(4, 2)
);

CREATE TABLE brands
(
    id   INT PRIMARY KEY,
    name VARCHAR(20)
);

CREATE TABLE prices
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    brand_id   INT,
    start_date TIMESTAMP,
    end_date   TIMESTAMP,
    fee_id     INT,
    product_id INT,
    priority   INT,
    amount      DECIMAL(4, 2),
    curr       VARCHAR(20),
    FOREIGN KEY (brand_id) REFERENCES brands (id),
    FOREIGN KEY (fee_id) REFERENCES fees (id)
);