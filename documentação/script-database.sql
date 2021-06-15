create table Estado (
	id int not null primary key,
	nome varchar(40) not null
)

create table Cidade (
	id int not null primary key,
	estado_id int not null,
	nome varchar(40) not null,
	foreign key (estado_id) references Estado(id)
)

create table Bairro (
	id int not null primary key,
	cidade_id int not null,
	nome varchar(40) not null
	foreign key (cidade_id) references Cidade(id)
)

create table Endereco (
	id int not null primary key,
	bairro_id int not null,
	complemento varchar(60),
	rua varchar(50) not null,
	numero int,
	cep int not null,
	foreign key (bairro_id) references Bairro(id)
)

create table Telefone (
	id int not null primary key,
	ddd int not null check(ddd >= 10 and ddd <= 99),
	numero bigint not null
)

create table Cliente (
	id int not null primary key,
	endereco_id int not null,
	telefone_id int not null,
	nome varchar(50) not null,
	cpf bigint not null unique,
	foreign key (endereco_id) references Endereco(id),
	foreign key (telefone_id) references Telefone(id)
)

create table Editora (
	id int not null primary key,
	nome varchar(50) not null
)

create table Genero (
	id int not null primary key,
	nome varchar(50) not null,
	descricao varchar(200)
)

create table Autor (
	id int not null primary key,
	nome varchar(50) not null
)

create table Livro (
	id int not null primary key,
	editora_id int not null,
	genero_id int not null,
	resumo varchar(200),
	quantidade int not null,
	lancamento date not null,
	isbn bigint not null,
	foreign key (editora_id) references Editora(id),
	foreign key (genero_id) references Genero(id)
)

create table Reserva (
	id int not null primary key,
	livro_id int not null,
	cliente_id int not null,
	data_reserva date not null,
	foreign key (livro_id) references Livro(id),
	foreign key (cliente_id) references Cliente(id)
)

create table Compra (
	id int not null primary key,
	livro_id int not null,
	cliente_id int not null,
	valor money not null,
	data_venda date not null,
	foreign key (livro_id) references Livro(id),
	foreign key (cliente_id) references Cliente(id)
)

create table Emprestimo (
	id int not null primary key,
	livro_id int not null,
	cliente_id int not null,
	valor money not null,
	data_emprestimo date not null,
	previsao_devolucao date not null,
	data_devolucao date,
	foreign key (livro_id) references Livro(id),
	foreign key (cliente_id) references Cliente(id)
)
