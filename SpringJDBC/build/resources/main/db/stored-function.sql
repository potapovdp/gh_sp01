
CREATE FUNCTION IF NOT EXISTS getUserLoginById(in_id VARCHAR(60)) RETURNS VARCHAR(60)
    LANGUAGE SQL
BEGIN
    RETURN (SELECT LOGIN FROM USERS WHERE id = in_id);
END;