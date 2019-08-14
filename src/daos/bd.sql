create database miniava;

use miniava;

create table aluno (
	pontuaca int,
	nome varchar(200),
	instituicao varchar(200),
	usuario varchar(200) primary key,
	senha varchar(200),
	e_moderador int
);

create table materia (
	nome varchar(200),
	id int primary key,

);

create table materia_aluno (
	id int,
	usuario varchar(200),
	primary key(id, usuario),
	foreign key id references materia(id),
	foreign key usuario references aluno(usuario)
);

create table mensagem (
	remetente varchar(200),
	destinatario varchar(200),
	assunto varchar(200),
	conteudo varchar(200),
	primary key(remetente, destinatario)
);

