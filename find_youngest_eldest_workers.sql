WITH YoungestWorkers AS (
    SELECT
        'YOUNGEST' AS TYPE,
        NAME,
        BIRTHDAY
    FROM
        worker
    WHERE
        BIRTHDAY = (
            SELECT
                MIN(BIRTHDAY)
            FROM
                worker
        )
),
EldestWorkers AS (
    SELECT
        'ELDEST' AS TYPE,
        NAME,
        BIRTHDAY
    FROM
        worker
    WHERE
        BIRTHDAY = (
            SELECT
                MAX(BIRTHDAY)
            FROM
                worker
        )
)
SELECT * FROM YoungestWorkers
UNION ALL
SELECT * FROM EldestWorkers;