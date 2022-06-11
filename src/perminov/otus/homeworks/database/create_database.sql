#Запускаем контейнер с ПГ
docker pull postgres
docker run --name test-postgres -e POSTGRES_PASSWORD=QWEzx123! -d postgres

#Создаём БД и переключаемся на неё
create database test_java_otus;
\c test_java_otus

#Создаём таблицу вопросов
create table Questions (
	id bigint PRIMARY Key GENERATED ALWAYS AS IDENTITY,
	text_question CHARACTER VARYING(30)
);

#Создаём таблицу ответов
create table Answers (
	id bigint PRIMARY Key GENERATED ALWAYS AS IDENTITY,
	text_answer CHARACTER VARYING(300)
);

#Создаём таблицу с тестами
create table Tests (
	id bigint PRIMARY Key GENERATED ALWAYS AS IDENTITY,
	test_name CHARACTER VARYING(30),
	test_question_id INTEGER REFERENCES Questions (Id),
	test_answers_id INTEGER REFERENCES Answers (Id),
	test_good_answer INTEGER
);

#Наполняем все таблицы
insert into answers (text_answer) values ('Москва,Пермь,Воронеж');
insert into answers (text_answer) values ('Черное море,Тихий океан,Каспийское море');
insert into answers (text_answer) values ('Юпитер,Солнце,Всё вращается вокруг земли');

insert into Questions (text_question) values ('Какая столица России?');
insert into Questions (text_question) values ('Куда впадает Волга?');
insert into Questions (text_question) values ('Вокруг чего вращается земля?');

insert into Tests (test_name, test_question_id, test_answers_id, test_good_answer) values ('Викторина №1', 1, 1, 1);
insert into Tests (test_name, test_question_id, test_answers_id, test_good_answer) values ('Викторина №1', 2, 2, 3);
insert into Tests (test_name, test_question_id, test_answers_id, test_good_answer) values ('Викторина №1', 3, 3, 2);

#Проверяем, что данные в таблицах есть
select tests.id, tests.test_name, questions.text_question, answers.text_answer, tests.test_good_answer
from tests
JOIN questions ON questions.id = tests.test_question_id
JOIN answers ON answers.id = tests.test_answers_id;