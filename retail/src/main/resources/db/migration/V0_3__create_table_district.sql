CREATE TABLE IF NOT EXISTS district (
  code varchar PRIMARY KEY,
  regency_code varchar REFERENCES regency(code) ON UPDATE CASCADE,
  self_code varchar,
  name varchar NOT NULL
);

CREATE INDEX IF NOT EXISTS district_name
ON district(name);
