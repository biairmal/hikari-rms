CREATE TABLE IF NOT EXISTS province (
  code varchar PRIMARY KEY,
  name varchar NOT NULL
);

CREATE INDEX IF NOT EXISTS province_name
ON province(name);
