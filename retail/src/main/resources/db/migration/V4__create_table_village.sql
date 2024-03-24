CREATE TABLE IF NOT EXISTS village (
  code varchar PRIMARY KEY,
  district_code varchar REFERENCES district(code) ON UPDATE CASCADE,
  self_code varchar,
  name varchar NOT NULL,
  postal_code varchar NOT NULL
);

CREATE INDEX IF NOT EXISTS village_name
ON village(name);

CREATE INDEX IF NOT EXISTS village_postal_code
ON village(postal_code);