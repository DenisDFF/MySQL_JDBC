WITH ProjectCost AS (
    SELECT
        NAME,
        SUM(w.SALARY) * EXTRACT(MONTH FROM (p.FINISH_DATE - p.START_DATE)) AS PRICE
    FROM
        project p
    JOIN
        project_worker pw ON p.ID = pw.PROJECT_ID
    JOIN
        worker w ON pw.WORKER_ID = w.ID
    GROUP BY
        NAME, p.START_DATE, p.FINISH_DATE
)
SELECT
    NAME,
    PRICE
FROM
    ProjectCost
ORDER BY
    PRICE DESC;