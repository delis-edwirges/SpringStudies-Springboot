use blog_pessoal;
select * from tb_postagens;
insert into tb_postagens (texto, titulo) values ("Olá! confortáveis? Primeira vez aqui? Apenas um teste com mais de 10 caracteres!", "Bem vindes ao meu Blog!");
ALTER TABLE tb_postagens DROP COLUMN coluna;