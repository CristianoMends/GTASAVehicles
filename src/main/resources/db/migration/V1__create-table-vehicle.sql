CREATE TABLE vehicle (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(100) NOT NULL,
   type VARCHAR(50) NOT NULL,
   gif VARCHAR(255) NOT NULL,
   CONSTRAINT pk_vehicle PRIMARY KEY (id)
);