CREATE TABLE IF NOT EXISTS regency (
  code varchar PRIMARY KEY,
  province_code varchar REFERENCES province(code) ON UPDATE CASCADE,
  self_code varchar,
  type varchar,
  name varchar NOT NULL
);

CREATE INDEX IF NOT EXISTS regency_name
ON regency(name);
