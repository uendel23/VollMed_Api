create table consultas(
    id bigint not null auto_incrwement,
    medico_id bigint not null,
    paciente_id bigint not null,
    date datetime not null,

    primary key (id),
    constraint fk_consultas_medico_id foreing key (medico_id) references medico(id),
    constraint fk_consultas_paciente_id foreing key (paciente_id) references cliente(id)
);