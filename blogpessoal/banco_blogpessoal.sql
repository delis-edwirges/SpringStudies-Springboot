use blog_pessoal;
select * from tb_postagens;
insert into tb_postagens (texto, titulo) values ("Olá! confortáveis? Primeira vez aqui? Apenas um teste com mais de 10 caracteres!", "Bem vindes ao meu Blog!");

insert into tb_postagens (datatempo, texto, titulo) values (current_timestamp(),"Olá! confortáveis? Segunda vez aqui? Apenas um teste com mais de 10 caracteres!", "Bem vindes ao meu Blog, de novo!", "2021-06-24");
insert into tb_postagens (texto, titulo) values ("Olá! confortáveis? Terceira vez aqui? Apenas um teste com mais de 10 caracteres!", "Bem vindes ao meu Blog, mais uma vez!" );
insert into tb_postagens (texto, titulo) values ("Olá! confortáveis? Quarta vez aqui? Apenas um teste com mais de 10 caracteres!", "Bem vindes ao meu Blog, olha eu de novo!" );
ALTER TABLE tb_postagens DROP COLUMN coluna;
ALTER TABLE tb_postagens DROP COLUMN date;
ALTER TABLE tb_postagens DROP COLUMN data;