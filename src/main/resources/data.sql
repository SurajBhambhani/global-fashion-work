DROP TABLE IF EXISTS product;

CREATE TABLE product (
  product_id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  brand VARCHAR(50) NOT NULL,
  price DECIMAL (10,2) NOT NULL,
  description VARCHAR(500) DEFAULT NULL,
  color VARCHAR(250) DEFAULT NULL
);

INSERT INTO product (title, brand, price, description, color) VALUES
  ('T-Shirt', 'DKNY', 10.0,'T-Shirt, Black Color, Trimmed.', 'Black'),
  ('T-Shirt', 'DKNY', 10.0,'T-Shirt, Red Color, Trimmed.', 'Red'),
  ('Jeans', 'ZARA', 15.0,'Jeans, Blue Denim, Trimmed.', 'Blue'),
  ('Jeans', 'ZARA', 15.0,'Jeans, Black Denim, Trimmed.', 'Black');