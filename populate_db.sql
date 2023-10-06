INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
    ('John Doe', '2000-01-07', 'Senior', 6000),
    ('Jane Smith', '1995-03-15', 'Middle', 3500),
    ('Alice Johnson', '1990-11-25', 'Senior', 7000),
    ('Bob Williams', '1985-08-12', 'Junior', 2500),
    ('Eve Brown', '1998-05-20', 'Middle', 4000),
    ('Charlie Davis', '1993-04-10', 'Senior', 6500),
    ('Grace White', '1996-12-30', 'Junior', 2000),
    ('David Lee', '1988-09-05', 'Trainee', 800),
    ('Sophia Martin', '1997-07-15', 'Trainee', 900),
    ('Olivia Garcia', '1992-02-28', 'Middle', 4500);

INSERT INTO client (NAME)
VALUES
    ('Client A'),
    ('Client B'),
    ('Client C'),
    ('Client D'),
    ('Client E');  

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
    (1, '2023-01-01', '2023-12-31'),
    (2, '2023-02-01', '2023-11-30'),
    (3, '2023-03-01', '2023-10-31'),
    (4, '2023-04-01', '2023-09-30'),
    (5, '2023-05-01', '2023-08-31'),
    (1, '2023-06-01', '2023-07-31'),
    (2, '2023-07-01', '2023-06-30'),
    (3, '2023-08-01', '2023-05-31'),
    (4, '2023-09-01', '2023-04-30'),
    (5, '2023-10-01', '2023-03-31');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2,4);