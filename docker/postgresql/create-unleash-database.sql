CREATE DATABASE unleash;
CREATE ROLE unleash LOGIN PASSWORD 'pass';
GRANT ALL PRIVILEGES ON DATABASE unleash TO unleash;
ALTER ROLE unleash SET search_path TO public;
