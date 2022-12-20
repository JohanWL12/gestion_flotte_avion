
--
-- TRIGGER AND FUNCTION
--

/*view v_avions*/
CREATE OR REPLACE VIEW v_avions AS
SELECT a.*,i.base FROM Avions a LEFT JOIN images i on i.idavion=a.idavion ORDER BY i.datechangement DESC;

/*function get current duree validite*/
CREATE OR REPLACE FUNCTION getCurrentValidityPeriod()
    RETURNS INTEGER AS
$$
DECLARE
    period INTEGER;
BEGIN
    SELECT dureevalidite into period from ValiditeToken order by DateChangement DESC;
    return period;
end;
$$
    LANGUAGE plpgsql;

/*function add to timestamp*/
CREATE OR REPLACE FUNCTION getDateExpiration(date_gen timestamp)
    RETURNS TIMESTAMP AS
$$
DECLARE
    period   VARCHAR;
    date_exp TIMESTAMP;
BEGIN
    period := (CAST(getCurrentValidityPeriod() AS varchar)) || ' seconds';
    RAISE NOTICE '%',period;
--     date_exp:=(date_gen + interval period);
    select date_gen::timestamp + period::interval into date_exp;
    return date_exp;
end;
$$
    LANGUAGE plpgsql;

/*trigger validate */
CREATE OR REPLACE FUNCTION setDateExpiration()
    RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.Date_generation IS NULL THEN
        NEW.Date_generation := now();
    end if;
    IF NEW.date_expiration IS NULL THEN
        NEW.date_expiration := getDateExpiration(NEW.date_generation);
    END IF;
    RETURN NEW;
end;
$$
    LANGUAGE plpgsql;

CREATE TRIGGER expiration_trigger
    BEFORE INSERT
    ON Tokens
    FOR EACH ROW
EXECUTE PROCEDURE setDateExpiration();
-- select getCurrentValidityPeriod();
-- select getDateExpiration('2022-11-18 9:30'::TIMESTAMP);

/*functio checkToken*/
CREATE OR REPLACE FUNCTION isTokenValid(token_value VARCHAR)
    RETURNS bool AS
$$
DECLARE
    curr_timestamp TIMESTAMP;
    exp_timestamps TIMESTAMP;
BEGIN
    curr_timestamp := now();
    select Date_expiration into exp_timestamps from tokens where token = token_value;
    if curr_timestamp < exp_timestamps then
        return true;
    else
        return false;
    end if;
end;
$$
    LANGUAGE plpgsql;

-- select '2022-11-18 2:45'::timestamp>=now();
select isTokenValid('OUB8bgtfr45cyuikb9');

/*view current assurance*/
CREATE OR REPLACE VIEW v_assurance AS
SELECT a.*
FROM Assurances a,
     (SELECT IdAvion, MAX(DateExpiration) AS DateExpiration FROM Assurances GROUP BY IdAvion) t
where a.IdAvion = t.IdAvion
  and t.DateExpiration = a.DateExpiration;
