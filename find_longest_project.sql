SELECT id, EXTRACT(MONTH FROM AGE(finish_date, start_date)) AS MONTH_COUNT
FROM project
WHERE EXTRACT(MONTH FROM AGE(finish_date, start_date)) = (
    SELECT MAX(EXTRACT(MONTH FROM AGE(finish_date, start_date)))
    FROM project
);



