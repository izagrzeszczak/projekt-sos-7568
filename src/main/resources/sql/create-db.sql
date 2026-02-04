drop schema public cascade;

-- Najpierw tabele zależne (kolejność DROP odwrotna do CREATE)
DROP TABLE GRADE IF EXISTS;
DROP TABLE ENROLLMENT IF EXISTS;
DROP TABLE SCHEDULE_ITEM IF EXISTS;
DROP TABLE PAYMENT IF EXISTS;
DROP TABLE LOAN IF EXISTS;
DROP TABLE BOOK IF EXISTS;
DROP TABLE COURSE IF EXISTS;
DROP TABLE STUDENT IF EXISTS;
DROP TABLE ACCOUNT IF EXISTS;

-- ACCOUNT
CREATE TABLE ACCOUNT (
  account_id         UUID PRIMARY KEY,
  email              VARCHAR(255) NOT NULL UNIQUE,
  password_hash      VARCHAR(255) NOT NULL,
  status             VARCHAR(20)  NOT NULL CHECK (status IN ('active','blocked','deleted')),
  failed_login_count INT          NOT NULL,
  created_at         TIMESTAMP    NOT NULL,
  last_login_at      TIMESTAMP    NULL
);

-- STUDENT (1-1 z ACCOUNT przez FK + UNIQUE)
CREATE TABLE STUDENT (
  student_id UUID PRIMARY KEY,
  account_id UUID NOT NULL UNIQUE,
  index_no   VARCHAR(20) NOT NULL UNIQUE,
  first_name VARCHAR(80) NOT NULL,
  last_name  VARCHAR(80) NOT NULL,
  program    VARCHAR(120) NOT NULL,
  semester   INT NOT NULL,
  CONSTRAINT fk_student_account
    FOREIGN KEY (account_id) REFERENCES ACCOUNT(account_id)
);

-- COURSE
CREATE TABLE COURSE (
  course_id    UUID PRIMARY KEY,
  code         VARCHAR(20) NOT NULL UNIQUE,
  name         VARCHAR(200) NOT NULL,
  ects         DECIMAL(3,1) NOT NULL,
  capacity     INT NOT NULL,
  description  LONGVARCHAR
);

-- SCHEDULE_ITEM (wiele pozycji planu dla COURSE)
CREATE TABLE SCHEDULE_ITEM (
  schedule_item_id UUID PRIMARY KEY,
  course_id        UUID NOT NULL,
  group_code       VARCHAR(20) NOT NULL,
  weekday          TINYINT NOT NULL CHECK (weekday BETWEEN 1 AND 7),
  start_time       TIME NOT NULL,
  end_time         TIME NOT NULL,
  room             VARCHAR(40) NOT NULL,
  type             VARCHAR(20) NOT NULL CHECK (type IN ('lecture','lab','seminar')),
  CONSTRAINT fk_schedule_course
    FOREIGN KEY (course_id) REFERENCES COURSE(course_id)
);

-- ENROLLMENT (zapis studenta na kurs)
CREATE TABLE ENROLLMENT (
  enrollment_id UUID PRIMARY KEY,
  student_id    UUID NOT NULL,
  course_id     UUID NOT NULL,
  status        VARCHAR(20) NOT NULL CHECK (status IN ('enrolled','withdrawn')),
  enrolled_at   TIMESTAMP NOT NULL,
  withdrawn_at  TIMESTAMP NULL,
  CONSTRAINT fk_enrollment_student
    FOREIGN KEY (student_id) REFERENCES STUDENT(student_id),
  CONSTRAINT fk_enrollment_course
    FOREIGN KEY (course_id) REFERENCES COURSE(course_id)
);

-- GRADE (0..1 do ENROLLMENT, więc UNIQUE na enrollment_id)
CREATE TABLE GRADE (
  grade_id       UUID PRIMARY KEY,
  enrollment_id  UUID NOT NULL UNIQUE,
  grade_value    DECIMAL(3,1) NULL,
  passed         BOOLEAN NOT NULL,
  graded_at      TIMESTAMP NULL,
  comment        VARCHAR(255) NULL,
  CONSTRAINT fk_grade_enrollment
    FOREIGN KEY (enrollment_id) REFERENCES ENROLLMENT(enrollment_id)
);

-- PAYMENT (integracja księgowa – w ERD jako tabela)
CREATE TABLE PAYMENT (
  payment_id    UUID PRIMARY KEY,
  student_id    UUID NOT NULL,
  external_ref  VARCHAR(64) NOT NULL,
  amount        DECIMAL(10,2) NOT NULL,
  paid_at       TIMESTAMP NOT NULL,
  status        VARCHAR(20) NOT NULL CHECK (status IN ('paid','pending','failed')),
  CONSTRAINT fk_payment_student
    FOREIGN KEY (student_id) REFERENCES STUDENT(student_id)
);

-- BOOK
CREATE TABLE BOOK (
  book_id UUID PRIMARY KEY,
  isbn    VARCHAR(20) NOT NULL UNIQUE,
  title   VARCHAR(255) NOT NULL,
  author  VARCHAR(255) NOT NULL,
  year    SMALLINT NOT NULL
);

-- LOAN (wypożyczenia)
CREATE TABLE LOAN (
  loan_id      UUID PRIMARY KEY,
  student_id   UUID NOT NULL,
  book_id      UUID NOT NULL,
  borrowed_at  TIMESTAMP NOT NULL,
  due_at       TIMESTAMP NOT NULL,
  returned_at  TIMESTAMP NULL,
  status       VARCHAR(20) NOT NULL CHECK (status IN ('borrowed','overdue','returned','queued')),
  CONSTRAINT fk_loan_student
    FOREIGN KEY (student_id) REFERENCES STUDENT(student_id),
  CONSTRAINT fk_loan_book
    FOREIGN KEY (book_id) REFERENCES BOOK(book_id)
);
