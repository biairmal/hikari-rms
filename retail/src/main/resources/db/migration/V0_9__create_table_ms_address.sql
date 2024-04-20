CREATE TABLE IF NOT EXISTS ms_address (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name varchar NOT NULL,
    type varchar NOT NULL,
    province_code varchar REFERENCES province(code) ON UPDATE CASCADE ON DELETE SET NULL,
    regency_code varchar REFERENCES regency(code) ON UPDATE CASCADE ON DELETE SET NULL,
    district_code varchar REFERENCES district(code) ON UPDATE CASCADE ON DELETE SET NULL,
    village_code varchar REFERENCES village(code) ON UPDATE CASCADE ON DELETE SET NULL,
    address_detail varchar
);

CREATE INDEX IF NOT EXISTS ms_address_name
ON ms_address(name);

CREATE INDEX IF NOT EXISTS ms_address_type
ON ms_address(type);
