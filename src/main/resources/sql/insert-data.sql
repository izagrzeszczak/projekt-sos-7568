-- ACCOUNTS
INSERT INTO ACCOUNT (account_id, email, password_hash, status, failed_login_count, created_at, last_login_at)
VALUES ('11111111-1111-1111-1111-111111111111', 'jan.kowalski@example.com', 'hash1', 'active', 0, CURRENT_TIMESTAMP, NULL);

INSERT INTO ACCOUNT (account_id, email, password_hash, status, failed_login_count, created_at, last_login_at)
VALUES ('22222222-2222-2222-2222-222222222222', 'anna.nowak@example.com', 'hash2', 'active', 0, CURRENT_TIMESTAMP, NULL);

-- STUDENTS
INSERT INTO STUDENT (student_id, account_id, index_no, first_name, last_name, program, semester)
VALUES (
  '33333333-3333-3333-3333-333333333333',
  '11111111-1111-1111-1111-111111111111',
  '7568',
  'Jan', 'Kowalski',
  'Informatyka',
  3
);

INSERT INTO STUDENT (student_id, account_id, index_no, first_name, last_name, program, semester)
VALUES (
  '44444444-4444-4444-4444-444444444444',
  '22222222-2222-2222-2222-222222222222',
  '7569',
  'Anna', 'Nowak',
  'Informatyka',
  3
);

-- COURSES
INSERT INTO COURSE (course_id, code, name, ects, capacity, description)
VALUES ('55555555-5555-5555-5555-555555555555', 'BD101', 'Bazy danych', 5.0, 30, 'Podstawy relacyjnych baz danych.');

INSERT INTO COURSE (course_id, code, name, ects, capacity, description)
VALUES ('66666666-6666-6666-6666-666666666666', 'IO202', 'Inżynieria oprogramowania', 6.0, 30, 'Proces wytwarzania oprogramowania.');

INSERT INTO COURSE (course_id, code, name, ects, capacity, description)
VALUES ('77777777-7777-7777-7777-777777777777', 'SI50', 'Sieci komputerowe', 5.0, 25, 'Podstawy sieci i protokołów.');

INSERT INTO COURSE (course_id, code, name, ects, capacity, description)
VALUES ('88888888-8888-8888-8888-888888888888', 'PRJ3', 'Projekt zespołowy', 8.0, 20, 'Projekt realizowany w grupie.');

-- SCHEDULE ITEMS
INSERT INTO SCHEDULE_ITEM (schedule_item_id, course_id, group_code, weekday, start_time, end_time, room, type)
VALUES (
  '99999999-9999-9999-9999-999999999999',
  '55555555-5555-5555-5555-555555555555',
  'A-12',
  1,
  TIME '08:00:00',
  TIME '09:30:00',
  'A-12',
  'lecture'
);

INSERT INTO SCHEDULE_ITEM (schedule_item_id, course_id, group_code, weekday, start_time, end_time, room, type)
VALUES (
  'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
  '66666666-6666-6666-6666-666666666666',
  'B-03',
  3,
  TIME '10:15:00',
  TIME '11:45:00',
  'B-03',
  'lab'
);

-- ENROLLMENTS
INSERT INTO ENROLLMENT (enrollment_id, student_id, course_id, status, enrolled_at, withdrawn_at)
VALUES (
  'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
  '33333333-3333-3333-3333-333333333333',
  '55555555-5555-5555-5555-555555555555',
  'enrolled',
  CURRENT_TIMESTAMP,
  NULL
);

INSERT INTO ENROLLMENT (enrollment_id, student_id, course_id, status, enrolled_at, withdrawn_at)
VALUES (
  'cccccccc-cccc-cccc-cccc-cccccccccccc',
  '33333333-3333-3333-3333-333333333333',
  '66666666-6666-6666-6666-666666666666',
  'enrolled',
  CURRENT_TIMESTAMP,
  NULL
);

-- GRADE
INSERT INTO GRADE (grade_id, enrollment_id, grade_value, passed, graded_at, comment)
VALUES (
  'dddddddd-dddd-dddd-dddd-dddddddddddd',
  'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
  4.5,
  TRUE,
  CURRENT_TIMESTAMP,
  'Zaliczony'
);

-- PAYMENTS
INSERT INTO PAYMENT (payment_id, student_id, external_ref, amount, paid_at, status)
VALUES (
  'eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee',
  '33333333-3333-3333-3333-333333333333',
  'KSIEG-2025-10-01',
  1200.00,
  TIMESTAMP '2025-10-01 10:00:00',
  'paid'
);

INSERT INTO PAYMENT (payment_id, student_id, external_ref, amount, paid_at, status)
VALUES (
  'ffffffff-ffff-ffff-ffff-ffffffffffff',
  '33333333-3333-3333-3333-333333333333',
  'KSIEG-2025-12-25',
  1200.00,
  TIMESTAMP '2025-12-25 10:00:00',
  'failed'
);

-- BOOKS
INSERT INTO BOOK (book_id, isbn, title, author, year)
VALUES ('12121212-1212-1212-1212-121212121212', '9788300000001', 'Clean Code', 'Robert C. Martin', 2008);

INSERT INTO BOOK (book_id, isbn, title, author, year)
VALUES ('13131313-1313-1313-1313-131313131313', '9788300000002', 'UML w praktyce', 'Autor Przykładowy', 2015);

-- LOANS
INSERT INTO LOAN (loan_id, student_id, book_id, borrowed_at, due_at, returned_at, status)
VALUES (
  '14141414-1414-1414-1414-141414141414',
  '33333333-3333-3333-3333-333333333333',
  '12121212-1212-1212-1212-121212121212',
  TIMESTAMP '2025-11-01 09:00:00',
  TIMESTAMP '2025-11-30 23:59:59',
  NULL,
  'borrowed'
);
